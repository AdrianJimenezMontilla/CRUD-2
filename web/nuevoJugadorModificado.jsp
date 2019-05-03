<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"  crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"  crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    <link rel="stylesheet" href="crud.css">

    <title>NBA Adrian Jimenez Montilla</title>
  </head>
  <body id="correcto"><font size="16">
    <%
          HttpSession sesion = request.getSession();
          String usuario;
          String contra;
          
          if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel") !=null) {
            usuario = sesion.getAttribute("user").toString();
            contra = sesion.getAttribute("nivel").toString();
            out.print("<a href=login.jsp?cerrar=true'><h5>Cerrar Session "+ usuario +"</h5></a>");
            
          if(sesion.getAttribute("user").equals("usuario")) {
            sesion.removeAttribute("user");
            sesion.invalidate();
            response.sendRedirect("login.jsp");
          }
          
          }else {
            out.print("<script>location.replace('login.jsp');</script>");
          }
      
      //HttpSession ses=request.getSession();
       //   if(ses.getAttribute("s1")!= null) {
            
        //  }else {
        //    response.sendRedirect("login.jsp");
        //  }
        //  out.print("<a href=bienvenida.jsp?c=1>Salir</a>");
          
        //  if(request.getParameter("c")!=null) {
            //ses.removeAttribute("s1");
        //    ses.invalidate();
        //    response.sendRedirect("login.jsp");
        //  }

      //Conexion Base de datos
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudnba","root", "");
      Statement s = conexion.createStatement();
      request.setCharacterEncoding("UTF-8");
      // Se compone la sentencia SQL en actualizacion a traves de los parametros recibidos en el formulario
      String actualizacion = "UPDATE jugadores SET "
                           + "NomJug='" + request.getParameter("NomJug")
                           + "', EdaJug=" + Integer.valueOf(request.getParameter("EdaJug"))
                           + ", PosJug='" + request.getParameter("PosJug")
                           + "', AltJug='" + Integer.valueOf(request.getParameter("AltJug"))
                           + "', PesJug='" + Integer.valueOf(request.getParameter("PesJug"))
                           + "', CodEqui=" + Integer.valueOf(request.getParameter("CodEqui"))
                           + " WHERE CodJug=" + Integer.valueOf(request.getParameter("CodJug"));
      //Se ejecuta
      s.execute(actualizacion);
      out.println("<br>Actualizacion realizada.");
      conexion.close();
    %>
    </font>
    <br>
    <a href="index.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Inicio</button>
    <div id="nba22"></div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
