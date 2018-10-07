/**
 *
 * @author Carina Amairani Díaz Ramírez 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelAgenda {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private String Nombre;
    private String Email;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

     /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/agenda_mvc","root","");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            Nombre = rs.getString("nombre");
            Email = rs.getString("email");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }

    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro(){
        System.out.print("Programa accion moverPrimerRegistro");
        try {
            rs.first();
            Nombre = rs.getString("nombre");
            Email = rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro(){
        System.out.print("Programa accion moverSiguienteRegistro");
        try {
            if (!rs.isLast()) {
                rs.next();
                
                Nombre = rs.getString("nombre");
                Email = rs.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro(){
        System.out.print("Programa accion moverAnteriorRegistro");
       try {
            if (!rs.isFirst()) {
                rs.previous();
                Nombre = rs.getString("nombre");
                Email = rs.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro(){
        System.out.print("Programa accion moverUltimoRegistro");
        try {
            rs.last();
           Nombre = rs.getString("nombre");
           Email = rs.getString("email");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }
    
    
}
