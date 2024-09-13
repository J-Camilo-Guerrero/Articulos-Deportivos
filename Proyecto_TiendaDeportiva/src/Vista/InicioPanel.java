package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InicioPanel extends JPanel {

    private JPanel panelOfertas, panelNuevosProductos, panelControl;
    private JLabel[] nuevoProductoLabels, ofertaLabels;
    private JTextField[] descripcionNuevosCampos, precioNuevosCampos, descripcionOfertasCampos;
    private JButton btnCargarImagen, btnAgregarOferta, btnAgregarNuevoProducto;
    private JComboBox<String> comboBoxImagenes;

    public InicioPanel() {
        setLayout(new BorderLayout());

        // Inicializar los paneles y componentes
        inicializarComponentes();

        // Configurar la disposición de los componentes en el panel
        configurarLayout();
    }

    private void inicializarComponentes() {
        // Ofertas especiales
        panelOfertas = new JPanel(new GridLayout(0, 1, 20, 20)); // Espaciado entre componentes
        panelOfertas.setBorder(BorderFactory.createTitledBorder("Ofertas Especiales"));
        ofertaLabels = new JLabel[3];
        descripcionOfertasCampos = new JTextField[3];

        for (int i = 0; i < 3; i++) {
            agregarOferta(i);
        }

        // Nuevos productos
        panelNuevosProductos = new JPanel(new GridLayout(0, 1, 20, 20)); // Una sola columna
        panelNuevosProductos.setBorder(BorderFactory.createTitledBorder("Nuevos Productos"));
        nuevoProductoLabels = new JLabel[2];
        descripcionNuevosCampos = new JTextField[2];
        precioNuevosCampos = new JTextField[2];

        for (int i = 0; i < 2; i++) {
            agregarNuevoProducto(i);
        }

        // Crear una lista de todas las etiquetas con imágenes
        comboBoxImagenes = new JComboBox<>(new String[]{
                "Nuevo Producto 1", "Nuevo Producto 2",
                "Oferta 1", "Oferta 2", "Oferta 3"
        });

        btnCargarImagen = new JButton("Cargar Imagen");
        btnCargarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBoxImagenes.getSelectedIndex();
                if (selectedIndex < nuevoProductoLabels.length) {
                    cargarImagen(nuevoProductoLabels[selectedIndex]);
                } else {
                    cargarImagen(ofertaLabels[selectedIndex - nuevoProductoLabels.length]);
                }
            }
        });

        // Botones para agregar ofertas y nuevos productos
        btnAgregarOferta = new JButton("Agregar Oferta");
        btnAgregarOferta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarOferta(panelOfertas.getComponentCount());
                panelOfertas.revalidate();
                panelOfertas.repaint();
            }
        });

        btnAgregarNuevoProducto = new JButton("Agregar Nuevo Producto");
        btnAgregarNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNuevoProducto(panelNuevosProductos.getComponentCount());
                panelNuevosProductos.revalidate();
                panelNuevosProductos.repaint();
            }
        });
    }

    private void configurarLayout() {
        // Usar JScrollPane para hacer los paneles desplazables
        JScrollPane scrollPaneOfertas = new JScrollPane(panelOfertas);
        JScrollPane scrollPaneNuevosProductos = new JScrollPane(panelNuevosProductos);

        // El panel de ofertas ocupará la mayor parte del espacio
        add(scrollPaneOfertas, BorderLayout.CENTER);

        // Los nuevos productos se mostrarán a la derecha en una sola columna
        add(scrollPaneNuevosProductos, BorderLayout.EAST);

        // Panel de control en la parte inferior
        panelControl = new JPanel();
        panelControl.add(comboBoxImagenes);
        panelControl.add(btnCargarImagen);
        panelControl.add(btnAgregarOferta);
        panelControl.add(btnAgregarNuevoProducto);
        add(panelControl, BorderLayout.PAGE_END);
    }

    private void agregarNuevoProducto(int index) {
        JPanel panelNuevoProducto = new JPanel(new BorderLayout());
        JLabel nuevoProductoLabel = new JLabel("Nuevo Producto " + (index + 1), JLabel.CENTER);
        nuevoProductoLabel.setPreferredSize(new Dimension(250, 150));

        JPanel panelDescripcion = new JPanel(new GridLayout(2, 1));
        JTextField descripcionNuevoField = new JTextField("Descripción " + (index + 1));
        JTextField precioNuevoField = new JTextField("$0.00");
        panelDescripcion.add(descripcionNuevoField);
        panelDescripcion.add(precioNuevoField);

        panelNuevoProducto.add(nuevoProductoLabel, BorderLayout.CENTER);
        panelNuevoProducto.add(panelDescripcion, BorderLayout.SOUTH);

        panelNuevosProductos.add(panelNuevoProducto);
    }

    private void agregarOferta(int index) {
        JPanel panelOferta = new JPanel(new BorderLayout());
        JLabel ofertaLabel = new JLabel("Oferta " + (index + 1), JLabel.CENTER);
        ofertaLabel.setPreferredSize(new Dimension(250, 150));

        JPanel panelDescripcion = new JPanel(new GridLayout(1, 1));
        JTextField descripcionOfertaField = new JTextField("Descripción Oferta " + (index + 1));
        JPanel panelPrecio = new JPanel(new GridLayout(1, 2));
        JTextField precioOfertaField = new JTextField(" Valor: 20.000 " + (index + 1));
        panelPrecio.add(precioOfertaField);
        panelDescripcion.add(descripcionOfertaField);

        panelOferta.add(ofertaLabel, BorderLayout.CENTER);
//        panelOferta.add(panelPrecio, BorderLayout.EAST)
        panelOferta.add(panelDescripcion, BorderLayout.SOUTH);

        panelOfertas.add(panelOferta);
    }

    // Método para cargar una imagen desde el sistema de archivos y redimensionarla
    private void cargarImagen(JLabel label) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "gif"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage originalImage = ImageIO.read(selectedFile);
                int labelWidth = label.getWidth();
                int labelHeight = label.getHeight();
                Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
