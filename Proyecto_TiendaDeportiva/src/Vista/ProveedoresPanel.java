package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProveedoresPanel extends JPanel {

    // Declaración de componentes de la interfaz
    private JLabel titulo;
    private JTable tablaProveedores;
    private JScrollPane scrollPane;
    private JButton bAgregar, bEliminar, bActualizar;
    private JPanel panelBotones, panelFormulario;
    private JTextField tNombreProveedor, tDireccion, tTelefono;
    private JLabel lNombreProveedor, lDireccion, lTelefono;
    private TitledBorder tituloFormulario, tituloTabla;

    // Constructor de la clase ProveedoresPanel
    public ProveedoresPanel() {
        // Establecemos el diseño del panel
        setLayout(new BorderLayout());

        // Creación de componentes para la pestaña de Proveedores
        titulo = new JLabel("Gestión de Proveedores", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        // Creación del modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre del Proveedor");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");

        // Creación de la tabla
        tablaProveedores = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tablaProveedores);

        // Título para la tabla
        tituloTabla = new TitledBorder("Proveedores");
        scrollPane.setBorder(tituloTabla);

        // Panel de formulario
        panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        tituloFormulario = new TitledBorder("Formulario de Proveedor");
        panelFormulario.setBorder(tituloFormulario);

        // Etiquetas y campos de texto del formulario
        lNombreProveedor = new JLabel("Nombre del Proveedor:");
        tNombreProveedor = new JTextField();
        lDireccion = new JLabel("Dirección:");
        tDireccion = new JTextField();
        lTelefono = new JLabel("Teléfono:");
        tTelefono = new JTextField();

        // Añadir componentes al panel de formulario
        panelFormulario.add(lNombreProveedor);
        panelFormulario.add(tNombreProveedor);
        panelFormulario.add(lDireccion);
        panelFormulario.add(tDireccion);
        panelFormulario.add(lTelefono);
        panelFormulario.add(tTelefono);

        // Panel de botones
        panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));
        bAgregar = new JButton("Agregar");
        bEliminar = new JButton("Eliminar");
        bActualizar = new JButton("Actualizar");

        // Añadir botones al panel de botones
        panelBotones.add(bAgregar);
        panelBotones.add(bEliminar);
        panelBotones.add(bActualizar);

        // Añadir componentes al panel principal
        add(titulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelFormulario, BorderLayout.SOUTH);
        add(panelBotones, BorderLayout.SOUTH);

        // Acciones de botones
        bAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar un nuevo proveedor
                String nombre = tNombreProveedor.getText();
                String direccion = tDireccion.getText();
                String telefono = tTelefono.getText();

                // Agregar datos a la tabla
                modeloTabla.addRow(new Object[]{modeloTabla.getRowCount() + 1, nombre, direccion, telefono});

                // Limpiar campos de texto
                tNombreProveedor.setText("");
                tDireccion.setText("");
                tTelefono.setText("");
            }
        });

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar un proveedor
                int filaSeleccionada = tablaProveedores.getSelectedRow();
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
                // Lógica para actualizar un proveedor
                int filaSeleccionada = tablaProveedores.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String nombre = tNombreProveedor.getText();
                    String direccion = tDireccion.getText();
                    String telefono = tTelefono.getText();

                    // Actualizar datos en la tabla
                    modeloTabla.setValueAt(nombre, filaSeleccionada, 1);
                    modeloTabla.setValueAt(direccion, filaSeleccionada, 2);
                    modeloTabla.setValueAt(telefono, filaSeleccionada, 3);

                    // Limpiar campos de texto
                    tNombreProveedor.setText("");
                    tDireccion.setText("");
                    tTelefono.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para actualizar");
                }
            }
        });
    }
}