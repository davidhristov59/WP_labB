package mk.ukim.finki.wp.lab.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.GenreService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="Song_Servlet", urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final SongService songService;
    private final GenreService genreService;

    public SongListServlet(SpringTemplateEngine templateEngine, SongService songService, GenreService genreService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
        this.genreService = genreService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("genres", genreService.listGenres());

        String genre = req.getParameter("genre");

        if (genre != null && !genre.isEmpty()){ //najdi gi pesnite spored zanr ako ne e null
            context.setVariable("songs", songService.findSongsByGenre(new Genre(genre)));
        }
        else {
            context.setVariable("songs", songService.listSongs());
        }

        templateEngine.process("listSongs.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String trackID = req.getParameter("trackID");

        Song song = songService.findByTrackId(trackID);

        req.getSession().setAttribute("song", song);

        resp.sendRedirect("/artist");
    }

}
