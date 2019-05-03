package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class modificaJugador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"crud.css\">\n");
      out.write("\n");
      out.write("    <title>NBA Adrian Jimenez Montilla</title>\n");
      out.write("  </head>\n");
      out.write("  <body id=\"modifica\"> <!-- Contenedor -->\n");
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
       //   if(ses.getAttribute("s1")!= null) {
       //     out.print("Bienvenid@ " + ses.getAttribute("s1"));
       //   }else {
       //     response.sendRedirect("login.jsp");
       //   }
       //   out.print("<br><a href=bienvenida.jsp?c=1>Salir</a>");
          
       //   if(request.getParameter("c")!=null) {
            //ses.removeAttribute("s1");
         //   ses.invalidate();
         //   response.sendRedirect("login.jsp");
         // }
          
      out.write("\n");
      out.write("    ");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <br><br>\n");
      out.write("      <div class=\"panel panel-warning\">\n");
      out.write("        <div class=\"panel-heading panel text-center\">Modificar jugador</div>\n");
      out.write("          <form method=\"get\" action=\"nuevoJugadorModificado.jsp\">   <!-- Formulario que manda las modificaciones -->\n");
      out.write("            <div id=\"nba2\"></div>\n");
      out.write("            <div class=\"form-group\"> \n");
      out.write("              <label>&nbsp;&nbsp;Código de jugador:&nbsp;</label><input type=\"text\" size=\"5\" name=\"CodJug\" value=\"");
      out.print( request.getParameter("CodJug") );
      out.write("\" readonly>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label>&nbsp;&nbsp;Nombre:&nbsp;</label><input type=\"text\" size=\"20\" name=\"NomJug\" value=\"");
      out.print( request.getParameter("NomJug") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label>&nbsp;&nbsp;Edad:&nbsp;</label><input type=\"text\" size=\"10\" name=\"EdaJug\" value=\"");
      out.print( request.getParameter("EdaJug") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label>&nbsp;&nbsp;Posición:&nbsp;</label><input type=\"text\" size=\"20\" name=\"PosJug\" value=\"");
      out.print( request.getParameter("PosJug") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label>&nbsp;&nbsp;Estatura (en cm):&nbsp;</label><input type=\"text\" size=\"5\" name=\"AltJug\" value=\"");
      out.print( request.getParameter("AltJug") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("              <label>&nbsp;&nbsp;Peso (en kg):&nbsp;</label><input type=\"text\" size=\"5\" name=\"PesJug\" value=\"");
      out.print( request.getParameter("PesJug") );
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              ");
 String NomEqui = request.getParameter("NomEqui"); 
      out.write("\n");
      out.write("                <label>&nbsp;&nbsp;Equipo:&nbsp;</label><select name=\"CodEqui\"><option value=\"");
      out.print( request.getParameter("CodEqui") );
      out.write('"');
      out.write('>');
      out.print(NomEqui);
      out.write("</option>    \n");
      out.write("                  ");
 //Conexion a Base de datos
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudnba","root", "");
                  Statement s = conexion.createStatement();
                  //Ejecuta la consulta para guardarlo en listado
                  ResultSet listado = s.executeQuery ("SELECT CodEqui, NomEqui FROM equipo");
                  //Extraemos los registros con bucle While
                  while(listado.next()) {
                    
                    out.println("<option value=" + listado.getString("CodEqui") + ">" + listado.getString("NomEqui") + "</option>");  
                  } //Cierra while
                  
                  conexion.close();
                 
      out.write("\n");
      out.write("              \n");
      out.write("            </select>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            &nbsp;&nbsp;<a href=\"index.jsp\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-remove\"></span>Cancelar</a>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-info\"><span class=\"glyphicon glyphicon-ok\"></span>Aceptar</button><br><br>\n");
      out.write("          </form>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("                 <div class=\"text-center\"><font color=\"red\">&copy; Adrian Jimenez Montilla</font></div>\n");
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
