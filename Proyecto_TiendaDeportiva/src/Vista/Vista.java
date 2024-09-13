package Vista;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    // Componentes de la interfaz
    private JPanel panelEncabezado, panelPie;
    private JLabel logo, nombreTienda;
    private JTabbedPane tabbedPane;
    private ImageIcon logoIcon;

    // Constructor de la clase Vista
    public Vista() {
        super("SportVenture - Tienda de Artículos Deportivos");
        configurarVentana();
        inicializarComponentes();
        configurarLayout();
    }

    // Configura la ventana principal
    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }

    // Inicializa los componentes de la interfaz
    private void inicializarComponentes() {
        // Panel del encabezado
        panelEncabezado = new JPanel(new BorderLayout());
        panelEncabezado.setBackground(Color.WHITE);
        panelEncabezado.setPreferredSize(new Dimension(0, 150));

        // Logo de la tienda
        logoIcon = new ImageIcon(getClass().getResource("/imagenes/jd_sport.png"));
        logo = new JLabel(logoIcon);
        logo.setHorizontalAlignment(JLabel.CENTER);

        // Nombre de la tienda
        nombreTienda = new JLabel("JD Sport: Equípate para Ganar", JLabel.CENTER);
        nombreTienda.setForeground(Color.BLACK);
        nombreTienda.setFont(new Font("Algerian", Font.BOLD, 24));

        JPanel panelLogoYLeema = new JPanel(new BorderLayout());
        panelLogoYLeema.setBackground(Color.WHITE);
        panelLogoYLeema.add(logo, BorderLayout.CENTER);
        panelLogoYLeema.add(nombreTienda, BorderLayout.SOUTH);

        panelEncabezado.add(panelLogoYLeema, BorderLayout.CENTER);

        // Panel inferior
        panelPie = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelPie.setBackground(Color.GREEN);
        JLabel infoContacto = new JLabel("Contacto: sportventure@hotmail.com");
        infoContacto.setForeground(Color.WHITE);
        JLabel politicasEnlaces = new JLabel("Políticas | Términos");
        politicasEnlaces.setForeground(Color.WHITE);
        JLabel redesSociales = new JLabel("Síguenos en Instagram: @SportVenture");
        redesSociales.setForeground(Color.WHITE);
        panelPie.add(infoContacto);
        panelPie.add(politicasEnlaces);
        panelPie.add(redesSociales);

        // Crear las pestañas
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inicio", new InicioPanel());
        tabbedPane.addTab("Usuarios", new UsuariosPanel());
        tabbedPane.addTab("Proveedores", new ProveedoresPanel());
        tabbedPane.addTab("Inventario", new InventarioPanel());
    }

    // Configura el diseño principal
    private void configurarLayout() {
        if (panelEncabezado != null) {
            add(panelEncabezado, BorderLayout.NORTH);
        }
        if (tabbedPane != null) {
            add(tabbedPane, BorderLayout.CENTER);
        }
        if (panelPie != null) {
            add(panelPie, BorderLayout.SOUTH);
        }
    }

    // Mostrar la interfaz
    public void mostrarInterfaz() {
        setVisible(true);
    }
}
