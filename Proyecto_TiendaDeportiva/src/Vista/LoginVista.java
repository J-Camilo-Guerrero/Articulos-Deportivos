package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVista extends JFrame {

    // Declaración de componentes de la interfaz
    private JPanel panelPrincipal;
    private JLabel lUsuario, lContrasena, lLogo;
    private JTextField tUsuario;
    private JPasswordField tContrasena;
    private JButton bIniciarSesion, bCancelar;

    // Constructor de la clase LoginVista
    public LoginVista() {
        super("Inicio de Sesión"); // Título de la ventana

        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar

        // Inicializar y configurar componentes
        inicializarComponentes();

        // Configurar la ventana
        add(panelPrincipal);
        setVisible(true);
    }

    // Método para inicializar y configurar componentes
    private void inicializarComponentes() {
        // Panel principal con GridBagLayout
        panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(new Color(238, 238, 238)); // Fondo claro

        // Cargar la imagen del logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/imagenes/jd_sport.png"));
        lLogo = new JLabel(logoIcon);
        lLogo.setHorizontalAlignment(JLabel.CENTER);
        lLogo.setVerticalAlignment(JLabel.CENTER);

        // Componentes
        lUsuario = new JLabel("Usuario:");
        lContrasena = new JLabel("Contraseña:");
        tUsuario = new JTextField(20);
        tContrasena = new JPasswordField(20);
        bIniciarSesion = new JButton("Iniciar Sesión");
        bCancelar = new JButton("Cancelar");

        // Fuente personalizada para etiquetas y botones
        Font font = new Font("Arial", Font.BOLD, 14);
        lUsuario.setFont(font);
        lContrasena.setFont(font);
        bIniciarSesion.setFont(font);
        bCancelar.setFont(font);

        // Color para botones
        bIniciarSesion.setBackground(new Color(0, 123, 255)); // Azul
        bIniciarSesion.setForeground(Color.WHITE);
        bCancelar.setBackground(new Color(220, 53, 69)); // Rojo
        bCancelar.setForeground(Color.WHITE);

        // Layout y constraints para GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(lLogo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panelPrincipal.add(lUsuario, gbc);

        gbc.gridx++;
        panelPrincipal.add(tUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelPrincipal.add(lContrasena, gbc);

        gbc.gridx++;
        panelPrincipal.add(tContrasena, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(bIniciarSesion, gbc);

        gbc.gridy++;
        panelPrincipal.add(bCancelar, gbc);

        // Acciones de botones
        bIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tUsuario.getText();
                String password = new String(tContrasena.getPassword());

                // Lógica de autenticación aquí
                if (username.equals("camilo") && password.equals("camilo123")) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    dispose();
                    new Vista().mostrarInterfaz();  // Abrir la aplicación principal
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tUsuario.setText("");
                tContrasena.setText("");
            }
        });
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginVista();
            }
        });
    }
}