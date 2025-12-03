import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteRolesDialog extends JDialog {

    private final Database db;

    private JComboBox<String> comboRoles;
    private JButton deleteButton;
    private JButton cancelButton;

    public DeleteRolesDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        initComponents();
    }

    private void initComponents() {

        JLabel label = new JLabel("Seleccione un rol para eliminar:");
        comboRoles = new JComboBox<>(cargarRoles().toArray(new String[0]));

        deleteButton = new JButton("Eliminar");
        cancelButton = new JButton("Cancelar");

        deleteButton.addActionListener(this::deleteAction);
        cancelButton.addActionListener(e -> setVisible(false));

        setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        add(label);
        add(comboRoles);
        add(deleteButton);
        add(cancelButton);

        setTitle("Eliminar Rol");
        setSize(350, 200);
        setLocationRelativeTo(null);
    }

    private ArrayList<String> cargarRoles() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            ResultSet rs = db.query("SELECT role_name FROM ref_roles ORDER BY role_name ASC");
            while (rs.next()) {
                lista.add(rs.getString("role_name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar roles: " + e.getMessage());
        }
        return lista;
    }

    private void deleteAction(ActionEvent evt) {
        String rol = (String) comboRoles.getSelectedItem();

        if (rol == null) {
            JOptionPane.showMessageDialog(this, "No hay rol seleccionado.");
            return;
        }

        int opc = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar el rol \"" + rol + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (opc != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM ref_roles WHERE role_name='" + rol + "';";

        try {
            db.update(sql);
            JOptionPane.showMessageDialog(this, "Rol eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar rol: " + e.getMessage());
        }

        setVisible(false);
    }
}
