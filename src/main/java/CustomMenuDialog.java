import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para crear un menú vertical con botones apilados
class CustomMenuDialog extends JDialog implements ActionListener {

    private int selection = -1; // Almacena el índice de la opción seleccionada

    public CustomMenuDialog(Frame owner, String title, Object[] options) {
        super(owner, "Menú: " + title, true);

        // Configuración básica del diálogo
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel para el contenido central (apila los botones)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título del sub-menú
        JLabel instruction = new JLabel("Seleccione una acción", SwingConstants.CENTER);
        instruction.setFont(new Font("Segoe UI", Font.BOLD, 16));
        instruction.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(instruction, BorderLayout.NORTH);

        // Crear botones a partir de las opciones
        for (int i = 0; i < options.length; i++) {
            String label = (String) options[i];
            JButton button = new JButton(label);

            // Usamos el índice de la opción como comando de acción
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);

            // Estilo para que se vean mejor y se expandan horizontalmente
            button.setFont(new Font("Tahoma", Font.PLAIN, 14));
            button.setMaximumSize(new Dimension(300, 40)); // Limitar ancho
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón

            buttonPanel.add(button);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(owner);
    }

    // Método para manejar clics en los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // Almacenar la selección (índice del botón)
        this.selection = Integer.parseInt(e.getActionCommand());
        // Cerrar el diálogo
        this.dispose();
    }

    // Nuevo método que MainApp usará para mostrar el diálogo y obtener el resultado
    public int showDialog() {
        this.setVisible(true); // Bloquea hasta que se cierre
        return selection;
    }
}