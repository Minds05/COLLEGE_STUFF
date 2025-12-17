import java.io.*; import javax.servlet.*; import javax.servlet.http.*;

public class Q11_Servlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("user");
        int age = Integer.parseInt(req.getParameter("age"));
        
        if (age < 18) out.println("Hello " + name + ", you are not authorized.");
        else out.println("Welcome to this site, " + name);
    }
}