import javax.swing.*;
import java.sql.*;

public class DeleteEmployeeOnProjectDialog extends JDialog {

    private final Database db;
    private JComboBox<String> combo;

    public DeleteEmployeeOnProjectDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        init();
        loadData();
    }

    private void loadData() {
        String sql =
            "SELECT employee_on_project_period_id, employee_id, project_id " +
            "FROM employee_on_projects ORDER BY employee_on_project_period_id";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                combo.addItem(
                        rs.getInt(1) + " • emp " + rs.getInt(2) + " — proj " + rs.getInt(3)
                );
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    private void init() {
        combo = new JComboBox<>();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancelar");

        ok.addActionListener(e -> deleteRow());
        cancel.addActionListener(e -> close());

        setTitle("Eliminar Asignación Empleado-Proyecto");
        setLayout(new java.awt.FlowLayout());
        add(new JLabel("Asignación a eliminar:"));
        add(combo);
        add(ok);
        add(cancel);
        pack();
    }

    private void deleteRow() {
        try {
            String item = combo.getSelectedItem().toString();
            int id = Integer.parseInt(item.substring(0, item.indexOf(" •")));

            db.update(
                "DELETE FROM employee_on_projects WHERE employee_on_project_period_id = " + id
            );

        } catch (SQLException e) { System.out.println(e.getMessage()); }

        close();
    }

    private void close() {
        setVisible(false);
        dispose();
    }
}
