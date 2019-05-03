package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   <body id=\"index\">   \n");
      out.write("      <div class=\"container\"> <!-- Contenedor -->\n");
      out.write("      <br><br>\t\t\t\n");
      out.write("      <div class=\"panel panel-warning\">\n");
      out.write("        <div class=\"panel-heading text-center\"><h2>Jugadores y sus equipos de la NBA</h2></div>\n");
      out.write("        ");

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
          //if(ses.getAttribute("s1")!= null) {
          //  out.print("Bienvenid@ " + ses.getAttribute("s1"));
          //}else {
          //  response.sendRedirect("login.jsp");
         // }
         // out.print("<br><a href=bienvenida.jsp?c=1>Salir</a>");
        //  
         // if(request.getParameter("c")!=null) {
           
         //   ses.invalidate();
         //   response.sendRedirect("login.jsp");
         // } 


          //Acceso a la Base de Datos//
          Class.forName("com.mysql.jdbc.Driver");
          Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudnba","root", "");
          Statement s = conexion.createStatement();
//Ejecuta la consulta para guardarlo en listado
          ResultSet listado = s.executeQuery ("SELECT * FROM jugadores INNER JOIN equipo ON jugadores.CodEqui = equipo.CodEqui");
         
        
      out.write("\n");
      out.write("        <!-- Tabla con formulario para agregar nuevos jugadores -->\n");
      out.write("        <table class=\"table table-striped table table-condensed\">\n");
      out.write("        <form method=\"get\" action=\"nuevoJugador.jsp\">\n");
      out.write("          <tr><td><input type=\"text\" name=\"CodJug\" size=\"2\"></td>\n");
      out.write("              <td><input type=\"text\" name=\"NomJug\" size=\"13\"></td>\n");
      out.write("              <td><input type=\"text\" name=\"EdaJug\" size=\"2\"></td>\n");
      out.write("              <td><input type=\"text\" name=\"PosJug\" size=\"13\"></td>\n");
      out.write("              <td><input type=\"text\" name=\"AltJug\" size=\"3\"></td>\n");
      out.write("              <td><input type=\"text\" name=\"PesJug\" size=\"2\"></td>\n");
      out.write("              <td><select name=\"CodEqui\">\n");
      out.write("                <option value=\"0\"></option>  \n");
      out.write("                <option value=\"1\">Los Angeles Lakers</option>\n");
      out.write("                <option value=\"2\">Golden State Warriors</option>\n");
      out.write("                <option value=\"3\">Boston Celtics</option>\n");
      out.write("                <option value=\"4\">Toronto Raptors</option>\n");
      out.write("                <option value=\"5\">Houston Rockets</option>\n");
      out.write("                <option value=\"6\">Oklahoma City Thunder</option>\n");
      out.write("                <option value=\"7\">Milwaukee Bucks</option>\n");
      out.write("                <option value=\"8\">San Antonio Spurs</option>\n");
      out.write("                <option value=\"9\">Philadelphia 76ers</option>\n");
      out.write("                <option value=\"10\">New York Knicks</option>\n");
      out.write("                <option value=\"11\">Chicago Bulls</option>\n");
      out.write("                <option value=\"12\">Miami Heat</option>\n");
      out.write("                <option value=\"13\">Cleveland Cavaliers</option>\n");
      out.write("                <option value=\"14\">Denver Nuggets</option>\n");
      out.write("                <option value=\"15\">Dallas Mavericks</option>\n");
      out.write("                <option value=\"16\">Sacramento Kings</option>\n");
      out.write("                <option value=\"17\">Los Angels Clippers</option>\n");
      out.write("                <option value=\"18\">Utah Jazz</option>\n");
      out.write("                <option value=\"19\">New Orleans Pelicans</option>\n");
      out.write("                <option value=\"20\">Portland Trail Blazers</option>\n");
      out.write("              </select></td>\n");
      out.write("              \n");
      out.write("              <td><button type=\"submit\" value=\"Añadir\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon-plus\"></span> Añadir</button></td><td></td></tr>           \n");
      out.write("          <td><div> </div></td>\n");
      out.write("        </form>\n");
      out.write("        <tr><th>Código</th><th>Nombre</th><th>Edad</th><th>Posición</th><th>Altura</th><th>Peso</th><th>Código Equipo</th><th>Nombre Equipo</th><th>Año de fundación</th></tr>\n");
      out.write("        \n");
      out.write("        ");
//Extraemos los registros con bucle While
          while (listado.next()) {
            out.println("<tr><td>");
            out.println(listado.getString("CodJug") + "</td>");
            out.println("<td>" + listado.getString("NomJug") + "</td>");
            out.println("<td>" + listado.getString("EdaJug") + "</td>");
            out.println("<td>" + listado.getString("PosJug") + "</td>");
            out.println("<td>" + listado.getString("AltJug") + "</td>");
            out.println("<td>" + listado.getString("PesJug") + "</td>");
            out.println("<td>" + listado.getString("CodEqui") + "</td>");
            out.println("<td>" + listado.getString("NomEqui") + "</td>");
            out.println("<td>" + listado.getString("FunEqui") + "</td>");
        
      out.write("\n");
      out.write("        <td>\n");
      out.write("        <!-- Formulario que gestiona el boton editar -->\n");
      out.write("        <form method=\"get\" action=\"modificaJugador.jsp\">\n");
      out.write("          <input type=\"hidden\" name=\"CodJug\" value=\"");
      out.print(listado.getString("CodJug") );
      out.write("\">\n");
      out.write("\t  <input type=\"hidden\" name=\"NomJug\" value=\"");
      out.print(listado.getString("NomJug") );
      out.write("\">\n");
      out.write("          <input type=\"hidden\" name=\"EdaJug\" value=\"");
      out.print(listado.getString("EdaJug") );
      out.write("\">\n");
      out.write("          <input type=\"hidden\" name=\"PosJug\" value=\"");
      out.print(listado.getString("PosJug") );
      out.write("\">\n");
      out.write("          <input type=\"hidden\" name=\"AltJug\" value=\"");
      out.print(listado.getString("AltJug") );
      out.write("\">\n");
      out.write("          <input type=\"hidden\" name=\"PesJug\" value=\"");
      out.print(listado.getString("PesJug") );
      out.write("\">\n");
      out.write("          <input type=\"hidden\" name=\"CodEqui\" value=\"");
      out.print(listado.getString("CodEqui") );
      out.write("\">\n");
      out.write("\t  <button type=\"submit\"  class=\"btn btn-warning\"><span class=\"glyphicon glyphicon-pencil\"></span></button>\n");
      out.write("\t  </form>\n");
      out.write("\t  </td>\n");
      out.write("\t  <td>\n");
      out.write("         <!-- Formulario que gestiona el boton borrar-->\n");
      out.write("        <form method=\"get\" action=\"borraJugador.jsp\">\n");
      out.write("          <input type=\"hidden\" name=\"CodJug\" value=\"");
      out.print(listado.getString("CodJug") );
      out.write("\"/>\n");
      out.write("          <button type=\"submit\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-remove\"></span></button>\n");
      out.write("        </form>\n");
      out.write("        </td></tr>\n");
      out.write("        ");

          } //Termina While
          conexion.close();
        
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"text-center\"><font color=\"red\">&copy; Adrian Jimenez Montilla</font></div>\n");
      out.write("    </div>\n");
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
