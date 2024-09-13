//package Vista;
//
//import javax.swing.*;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ProductosPanel extends JPanel {
//
//    private JTable tablaProductos;
//    private DefaultTableModel modeloTabla;
//    private JButton bAgregarAlCarrito;
//    private CarritoVista carrito;

//    public ProductosPanel(CarritoVista carrito) {
//        this.carrito = carrito;
//        setLayout(new BorderLayout());
//
//        modeloTabla = new DefaultTableModel();
//        modeloTabla.addColumn("ID");
//        modeloTabla.addColumn("Nombre del Producto");
//        modeloTabla.addColumn("Cantidad");
//        modeloTabla.addColumn("Precio");
//
//        tablaProductos = new JTable(modeloTabla);
//        JScrollPane scrollPane = new JScrollPane(tablaProductos);
//        TitledBorder tituloTabla = new TitledBorder("Productos");
//        scrollPane.setBorder(tituloTabla);
//
//        bAgregarAlCarrito = new JButton("Agregar al Carrito");
//
//        add(scrollPane, BorderLayout.CENTER);
//        add(bAgregarAlCarrito, BorderLayout.SOUTH);
//
//        bAgregarAlCarrito.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agregarAlCarrito();
//            }
//       }
//        );
//    }

//    private void agregarAlCarrito() {
//        int filaSeleccionada = tablaProductos.getSelectedRow();
//        if (filaSeleccionada >= 0) {
//            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
//            String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
//            int cantidad = (int) modeloTabla.getValueAt(filaSeleccionada, 2);
//            double precio = (double) modeloTabla.getValueAt(filaSeleccionada, 3);
//
//            // se grega el producto al carrito
//            carrito.agregarProducto(id, nombre, cantidad, precio);
//        } else {
//            JOptionPane.showMessageDialog(null, "Seleccione un producto para agregar al carrito");
//        }
//    }
//}
//
