package mk.ukim.finki.wp.lab.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;

    public ArtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService) {
        this.templateEngine = templateEngine;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("artists", artistService.listArtists());
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long artistID = Long.parseLong(req.getParameter("artistID"));

        Artist artist = artistService.findById(artistID);

        req.getSession().setAttribute("artist", artist);

        resp.sendRedirect("/songDetails.html");
    }
}
