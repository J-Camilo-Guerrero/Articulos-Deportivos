package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UsuariosPanel extends JPanel {

    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private JTextField campoBusqueda;
    private JButton btnAgregar, btnEditar, btnEliminar, btnBuscar;

    public UsuariosPanel() {
        setLayout(new BorderLayout());

        // Título del panel
        JLabel titulo = new JLabel("Gestión de Usuarios", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        campoBusqueda = new JTextField(20);
        btnBuscar = new JButton("Buscar");
        panelBusqueda.add(new JLabel("Buscar Usuario:"));
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(btnBuscar);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAgregar = new JButton("Agregar Usuario");
        btnEditar = new JButton("Editar Usuario");
        btnEliminar = new JButton("Eliminar Usuario");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        // Tabla de usuarios
        String[] columnas = {"ID", "Nombre", "Correo Electrónico", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        
        // Añadir componentes al panel principal
        add(panelBusqueda, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Ejemplo de datos para la tabla
        agregarUsuario("1", "Juan Pérez", "juan.perez@example.com", "Vendedor");
        agregarUsuario("2", "Ana Gómez", "ana.gomez@example.com", "Administrador");
        agregarUsuario("3", "Carlos Martínez", "carlos.martinez@example.com", "Cliente");
    }

    // Método para agregar un usuario a la tabla
    private void agregarUsuario(String id, String nombre, String correo, String rol) {
        modeloTabla.addRow(new Object[]{id, nombre, correo, rol});
    }

   
}

