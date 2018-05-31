import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpGooseGameService extends HttpServlet {

    private GooseGame gooseGame;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String add_player_pippo = gooseGame.writeInstruction("add player pippo");
        resp.getWriter().write(add_player_pippo);
    }

    public void setGooseGame(GooseGame gooseGame) {
        this.gooseGame = gooseGame;
    }
}
