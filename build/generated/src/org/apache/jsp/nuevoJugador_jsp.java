package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class nuevoJugador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    \n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"  crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\"  crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"  crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"crud.css\">\n");
      out.write("\n");
      out.write("    <title>NBA Adrian Jimenez Montilla</title>\n");
      out.write("  </head>\n");
      out.write("  <body id=\"correcto\"> <font size=\"16\">\n");
      out.write("    ");

      HttpSession sesion = request.getSession();
          String usuario;
          String contra;
          
          if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel") !=null) {
            usuario = sesion.getAttribute("user").toString();
            contra = sesion.getAttribute("nivel").toString();
            out.print("<a href=login.jsp?cerrar=true'><h5>Cerrar Session "+ usuario +"</h5></a>");
            
          }else {
            out.print("<script>location.replace('login.jsp');</script>");
          }
      //HttpSession ses=request.getSession();
      //    if(ses.getAttribute("s1")!= null) {
            
      //    }else {
      //      response.sendRedirect("login.jsp");
       //   }
       //   out.print("<br><a href=bienvenida.jsp?c=1>Salir</a>");
          
       //   if(request.getParameter("c")!=null) {
       //     //ses.removeAttribute("s1");
       //     ses.invalidate();
       //     response.sendRedirect("login.jsp");
       //   }
      
      out.write("\n");
      out.write("      ");

      //Conexion a la Base de datos
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudnba","root", "");
      Statement s = conexion.createStatement();
      request.setCharacterEncoding("UTF-8");
      // Consulta para obtener el codigo de jugador
      String consultaCodJug = "SELECT * FROM jugadores WHERE CodJug="
                                + Integer.valueOf(request.getParameter("CodJug"));      
      // Ejecuta la consulta para guardar el CodJug
      ResultSet codigoDeJugador = s.executeQuery (consultaCodJug);
      codigoDeJugador.last();
      // Se comprueba si existe el CodJug
      if (codigoDeJugador.getRow() != 0) {
        out.println("<br>Ya existe un jugador con ese codigo "
                    + request.getParameter("CodJug") + ".");
        
      } else { //Se compone la sentencia SQL en Insercion
        String insercion = "INSERT INTO jugadores VALUES (" + Integer.valueOf(request.getParameter("CodJug"))
                           + ", '" + request.getParameter("NomJug")
                           + "', " + Integer.valueOf(request.getParameter("EdaJug"))
                           + ", '" + request.getParameter("PosJug")
                           + "', " + Integer.valueOf(request.getParameter("AltJug"))
                           + ", " + Integer.valueOf(request.getParameter("PesJug"))
                           + ", " + Integer.valueOf(request.getParameter("CodEqui")) + ")";
        s.execute(insercion); //Ejecución
        out.println("<br> Datos dados de alta correctamente.");
      }
      conexion.close();
    
      out.write("\n");
      out.write("    </font>\n");
      out.write("    <br>\n");
      out.write("    <a href=\"index.jsp\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-home\"></span> Volver</button>\n");
      out.write("    <div id=\"lebron\"></div>\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
