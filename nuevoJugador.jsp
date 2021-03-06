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
  <body id="correcto"> <font size="16">
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
      %>
      <%
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
    %>
    </font>
    <br>
    <a href="index.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Volver</button>
    <div id="lebron"></div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>