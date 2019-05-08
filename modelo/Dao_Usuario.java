/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author pc21
 */
public class Dao_Usuario {
  private PreparedStatement ps;
  private ResultSet rs;
  Conex c = new Conex();
  Connection con() throws SQLException,ClassNotFoundException {
    Class.forName(c.getDriver());
    return DriverManager.getConnection(c.getUrl(),c.getUsuario(),c.getPassword());
  }
  public boolean validar(String login, String password) {
    try{
       ps = con().prepareStatement("SELECT * FROM usuario WHERE login =? AND password =?");
       ps.setString(1, login);
       ps.setString(2, password);
       rs = ps.executeQuery();
       while(rs.next())
         return true;
    }catch(Exception e) {
    
    }
      return false;
  }
}
