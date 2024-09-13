//package vista;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import modelo.CarritoDao;
//
//public class CarritoVista extends JPanel {
//    private JTable tablaCarrito;
//    private DefaultTableModel modeloTabla;
//    private JButton bEliminar, bPagar;
//    private JTextField tTotal;
//    private CarritoDao carritoDao;
//
//    public CarritoVista() {
//        setLayout(new BorderLayout());
//
//        modeloTabla = new DefaultTableModel();
//        modeloTabla.addColumn("ID");
//        modeloTabla.addColumn("Nombre del Producto");
//        modeloTabla.addColumn("Cantidad");
//        modeloTabla.addColumn("Precio");
//        modeloTabla.addColumn("Subtotal");
//
//        tablaCarrito = new JTable(modeloTabla);
//        JScrollPane scrollPane = new JScrollPane(tablaCarrito);
//        scrollPane.setBorder(BorderFactory.createTitledBorder("Carrito de Compras"));
//
//        bEliminar = new JButton("Eliminar");
//        bPagar = new JButton("Pagar");
//        tTotal = new JTextField();
//        tTotal.setEditable(false);
//
//        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));
//        panelBotones.add(bEliminar);
//        panelBotones.add(bPagar);
//        panelBotones.add(tTotal);
//
//        add(scrollPane, BorderLayout.CENTER);
//        add(panelBotones, BorderLayout.SOUTH);
//
//        carritoDao = new CarritoDao();
//
//        bEliminar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                eliminarProducto();
//            }
//        });
//
//        bPagar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pagar();
//            }
//        });
//    }
//
//    public void agregarProducto(int id, String nombre, int cantidad, double precio) {
//        double subtotal = cantidad * precio;
//        modeloTabla.addRow(new Object[]{id, nombre, cantidad, precio, subtotal});
//        actualizarTotal();
//    }
//
//    private void eliminarProducto() {
//        int filaSeleccionada = tablaCarrito.getSelectedRow();
//        if (filaSeleccionada >= 0) {
//            modeloTabla.removeRow(filaSeleccionada);
//            actualizarTotal();
//        } else {
//            JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar");
//        }
//    }
//
//    private void pagar() {
//        // Implementar lógica para guardar en el historial de compras y generar PDF
//        int idUsuario = obtenerIdUsuario(); // Método para obtener el ID del usuario actual
//        if (carritoDao.finalizarCompra(idUsuario) == 1) {
//            JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
//            // Aquí se puede agregar código para generar el PDF de la factura
//            modeloTabla.setRowCount(0); // Limpiar carrito
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al procesar la compra.");
//        }
//    }
//
//    private void actualizarTotal() {
//        double total = 0;
//        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
//            total += (double) modeloTabla.getValueAt(i, 4);
//        }
//        tTotal.setText(String.format("Total: %.2f", total));
//    }
//
//    private int obtenerIdUsuario() {
//        // Método placeholder para obtener el ID del usuario actual
//        return 1; // Cambiar por el ID del usuario actual
//    }
//}