//package modelo;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;
//
//public class CarritoDao {
//    Conexion conectar = new Conexion();
//    Connection con;
//    PreparedStatement ps;
//    ResultSet rs;
//
//    public List<Carrito> listar() {
//        List<Carrito> datos = new ArrayList<>();
//        String sql = "SELECT * FROM Carrito";
//
//        try {
//            con = conectar.getConection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Carrito c = new Carrito();
//                c.setId(rs.getInt("id"));
//                c.setIdProducto(rs.getInt("id_producto"));
//                c.setNombreProducto(rs.getString("nombre_producto"));
//                c.setCantidad(rs.getInt("cantidad"));
//                c.setPrecio(rs.getDouble("precio"));
//                c.setSubtotal(rs.getDouble("subtotal"));
//                datos.add(c);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR DE CONSULTA", JOptionPane.ERROR_MESSAGE);
//        }
//        return datos;
//    }
//
//    public int agregarProducto(Carrito c) {
//        String sql = "INSERT INTO Carrito (id_producto, nombre_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
//        try {
//            con = conectar.getConection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, c.getIdProducto());
//            ps.setString(2, c.getNombreProducto());
//            ps.setInt(3, c.getCantidad());
//            ps.setDouble(4, c.getPrecio());
//            ps.setDouble(5, c.getSubtotal());
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR DE CONSULTA", JOptionPane.ERROR_MESSAGE);
//            return 0;
//        }
//    }
//
//    public int eliminarProducto(int id) {
//        String sql = "DELETE FROM Carrito WHERE id=?";
//        try {
//            con = conectar.getConection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR DE CONSULTA", JOptionPane.ERROR_MESSAGE);
//            return 0;
//        }
//    }
//
//    public int finalizarCompra(int idUsuario) {
//        Connection con = conectar.getConection();
//        try {
//            con.setAutoCommit(false);
//            String sqlHistorial = "INSERT INTO HistorialCompras (id_usuario, total) VALUES (?, ?)";
//            PreparedStatement psHistorial = con.prepareStatement(sqlHistorial, PreparedStatement.RETURN_GENERATED_KEYS);
//            psHistorial.setInt(1, idUsuario);
//            double total = calcularTotal();
//            psHistorial.setDouble(2, total);
//            psHistorial.executeUpdate();
//            ResultSet rsHistorial = psHistorial.getGeneratedKeys();
//            if (rsHistorial.next()) {
//                int idHistorial = rsHistorial.getInt(1);
//
//                String sqlDetalle = "INSERT INTO DetalleCompra (id_historial, id_producto, cantidad, precio, subtotal) VALUES (?, ?, ?, ?, ?)";
//                PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);
//
//                List<Carrito> carrito = listar();
//                for (Carrito c : carrito) {
//                    psDetalle.setInt(1, idHistorial);
//                    psDetalle.setInt(2, c.getIdProducto());
//                    psDetalle.setInt(3, c.getCantidad());
//                    psDetalle.setDouble(4, c.getPrecio());
//                    psDetalle.setDouble(5, c.getSubtotal());
//                    psDetalle.addBatch();
//
//                    actualizarInventario(c.getIdProducto(), c.getCantidad());
//                }
//                psDetalle.executeBatch();
//
//                String sqlEliminar = "DELETE FROM Carrito";
//                PreparedStatement psEliminar = con.prepareStatement(sqlEliminar);
//                psEliminar.executeUpdate();
//
//                con.commit();
//                return 1;
//            } else {
//                con.rollback();
//                return 0;
//            }
//        } catch (Exception e) {
//            try {
//                con.rollback();
//            } catch (Exception rollbackException) {
//                rollbackException.printStackTrace();
//            }
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR DE CONSULTA", JOptionPane.ERROR_MESSAGE);
//            return 0;
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private double calcularTotal() {
//        double total = 0;
//        List<Carrito> carrito = listar();
//        for (Carrito c : carrito) {
//            total += c.getSubtotal();
//        }
//        return total;
//    }
//
//    private void actualizarInventario(int idProducto, int cantidad) {
//        String sql = "UPDATE Productos SET cantidad = cantidad - ? WHERE id = ?";
//        try {
//            con = conectar.getConection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, cantidad);
//            ps.setInt(2, idProducto);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString(), "ERROR DE CONSULTA", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}
