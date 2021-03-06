import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    private static Server server = new Server(9001)  ;

    public static void main(String[] args) throws Exception{
        start();
    }

    public static void start() throws Exception {
        ServletContextHandler  handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new HttpGreetingService()), "/greating");
        server.setHandler(handler);
        server.start();
    }

    public static void stop() throws Exception {
        server.stop();
    }
}
