/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qosserver;
import java.sql.*;
/**
 *
 * @author Ali Raza
 */
public class DbClass {
    
    public ResultSet selectQuery(Connection conn, String query){
        try {
            Statement s = conn.createStatement();
            s.execute(query);
            ResultSet rs = s.getResultSet();
            s.close();
            conn.close();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    Connection connect(){
        String url = "jdbc:ucanaccess://db.accdb";

        try {
            // specify url, username, pasword - make sure these are valid
            Connection conn=DriverManager.getConnection(url);
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
