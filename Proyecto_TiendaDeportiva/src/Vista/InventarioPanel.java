package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioPanel extends JPanel {

    private JLabel titulo;
    private JTable tablaInventario;
    private JScrollPane scrollPane;
    private JButton bAgregar, bEliminar, bActualizar;
    private JPanel panelBotones, panelFormulario;
    private JTextField tNombreProducto, tCantidad, tPrecio;
    private JLabel lNombreProducto, lCantidad, lPrecio;
    private TitledBorder tituloFormulario, tituloTabla;
    private DefaultTableModel modeloTabla;

    public InventarioPanel() {
        setLayout(new BorderLayout());

        titulo = new JLabel("Gestión de Inventario", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre del Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");

        tablaInventario = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tablaInventario);
        tituloTabla = new TitledBorder("Inventario");
        scrollPane.setBorder(tituloTabla);

        panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        tituloFormulario = new TitledBorder("Formulario de Producto");
        panelFormulario.setBorder(tituloFormulario);

        lNombreProducto = new JLabel("Nombre del Producto:");
        tNombreProducto = new JTextField();
        lCantidad = new JLabel("Cantidad:");
        tCantidad = new JTextField();
        lPrecio = new JLabel("Precio:");
        tPrecio = new JTextField();

        panelFormulario.add(lNombreProducto);
        panelFormulario.add(tNombreProducto);
        panelFormulario.add(lCantidad);
        panelFormulario.add(tCantidad);
        panelFormulario.add(lPrecio);
        panelFormulario.add(tPrecio);

        panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));
        bAgregar = new JButton("Agregar");
        bEliminar = new JButton("Eliminar");
        bActualizar = new JButton("Actualizar");

        panelBotones.add(bAgregar);
        panelBotones.add(bEliminar);
        panelBotones.add(bActualizar);

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.Y_AXIS));
        panelSur.add(panelFormulario);
        panelSur.add(panelBotones);

        add(titulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        bAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoAgregar();
            }
        });

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaInventario.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    modeloTabla.removeRow(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
                }
            }
        });

        bActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaInventario.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String nombre = tNombreProducto.getText();
                    int cantidad = Integer.parseInt(tCantidad.getText());
                    double precio = Double.parseDouble(tPrecio.getText());
                    modeloTabla.setValueAt(nombre, filaSeleccionada, 1);
                    modeloTabla.setValueAt(cantidad, filaSeleccionada, 2);
                    modeloTabla.setValueAt(precio, filaSeleccionada, 3);
                    tNombreProducto.setText("");
                    tCantidad.setText("");
                    tPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para actualizar");
                }
            }
        });
    }

    private void mostrarDialogoAgregar() {
        // Crear el diálogo para ingresar los detalles del nuevo producto
        JDialog dialogo = new JDialog((Frame) null, "Agregar Nuevo Producto", true);
        dialogo.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lNombre = new JLabel("Nombre del Producto:");
        JTextField tNombre = new JTextField();
        JLabel lCantidad = new JLabel("Cantidad:");
        JTextField tCantidad = new JTextField();
        JLabel lPrecio = new JLabel("Precio:");
        JTextField tPrecio = new JTextField();
        JButton bAceptar = new JButton("Aceptar");
        JButton bCancelar = new JButton("Cancelar");

        dialogo.add(lNombre);
        dialogo.add(tNombre);
        dialogo.add(lCantidad);
        dialogo.add(tCantidad);
        dialogo.add(lPrecio);
        dialogo.add(tPrecio);
        dialogo.add(bAceptar);
        dialogo.add(bCancelar);

        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = tNombre.getText();
                int cantidad = Integer.parseInt(tCantidad.getText());
                double precio = Double.parseDouble(tPrecio.getText());
                modeloTabla.addRow(new Object[]{modeloTabla.getRowCount() + 1, nombre, cantidad, precio});
                dialogo.dispose();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogo.dispose();
            }
        });
    }

  
}

