//
//package modelo;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import javax.swing.JOptionPane;
//import java.sql.SQLException;
//
//
//public class Conexion {
//    Connection con;
//    String url = "jdbc:mysql://localhost:3306/TiendaDeportiva";
//    //coneccion a base de datos creada anteriormente
//    String pass="";
//    String user="root";    
//    
//    // metodo 
//    public Connection getConection(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver"); 
//            //llama el driver istalador  libreria 
//            con=DriverManager.getConnection(url,user,pass);
////            JOptionPane.showMessageDialog(null,"Conexion exitosa");
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e.toString(),"base de datos Apagada" + 
//                    e.getMessage(),JOptionPane.ERROR_MESSAGE);
//        }
//        return con;
//    }
//    
//    public void closeConnection(Connection con) {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                // Manejo de errores al cerrar la conexión
//                e.printStackTrace();
//            }
//        }
//    }
//    
//    
//}