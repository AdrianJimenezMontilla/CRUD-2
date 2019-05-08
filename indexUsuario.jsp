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
   <body id="index">   
      <div class="container"> <!-- Contenedor -->
      <br><br>			
      <div class="panel panel-warning">
        <div class="panel-heading text-center"><h2>Jugadores y sus equipos de la NBA</h2></div>
        <%
          HttpSession sesion = request.getSession();
          String usuario;
          String contra;
          
          if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel") !=null) {
            usuario = sesion.getAttribute("user").toString();
            out.print("Logueado como: " + usuario);
            out.print("<a href=login.jsp?cerrar=true'><h5>Cerrar Session</h5></a>");
            
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
         
        %>
        <!-- Tabla con formulario para agregar nuevos jugadores -->
        <table class="table table-striped table table-condensed">
        
        <tr><th>Código</th><th>Nombre</th><th>Edad</th><th>Posición</th><th>Altura</th><th>Peso</th><th>Código Equipo</th><th>Nombre Equipo</th><th>Año de fundación</th></tr>
        
        <%//Extraemos los registros con bucle While
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
        %>
        <td>
       
        </td></tr>
        <%
          } //Termina While
          conexion.close();
        %>

        </table>
      </div>
        <div class="text-center"><font color="red">&copy; Adrian Jimenez Montilla</font></div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>