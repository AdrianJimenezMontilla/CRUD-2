<%-- 
    Document   : login
    Created on : Apr 20, 2019, 2:34:56 AM
    Author     : pc21
--%>

<%@page import="modelado.Operaciones"%>
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
        <title>JSP Page</title>
    </head>
    <body id="index">
        <font color="red">
        <!-- <form action="Control" method="post">  -->
        <h1>
            <form action="login.jsp" method="post">
            User: <input type="text" name="txtUsuario"><br>
            Pass: <input type="password" name="txtContra"><br>
            
            <input type="submit" name="btnIngresar" value="Ingresar">
        </form>
        </h1>
        <%
          Operaciones op = new Operaciones();
          
          if(request.getParameter("btnIngresar")!=null) {
            String nombre = request.getParameter("txtUsuario");
            String contra = request.getParameter("txtContra");
            HttpSession sesion = request.getSession();
            switch(op.loguear(nombre, contra)) {
              case 1:
                    
                    sesion.setAttribute("user", nombre);
                    sesion.setAttribute("nivel", 1);
                    response.sendRedirect("index.jsp");
              break;
              case 2:
                    
                    sesion.setAttribute("user", nombre);
                    sesion.setAttribute("nivel", 2);
                    response.sendRedirect("indexUsuario.jsp");
              break;
              
              default:
                    out.write("usuario no existe, o contraseña incorrecta");
                    break;
            }
            
          }
          if(request.getParameter("cerrar") !=null) {
            session.invalidate();
            
          }
        //    if(request.getAttribute("v")!=null) {
        //      if(request.getAttribute("v")=="1") {
        //        HttpSession ses = request.getSession();
        //        ses.setAttribute("s1",request.getAttribute("log"));
        //        response.sendRedirect("bienvenida.jsp");
        //      }else{
        //        out.print("Usuario o contraseña incorrectos");
        //      }
              
        //    }
         %>
         </font>
             <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
