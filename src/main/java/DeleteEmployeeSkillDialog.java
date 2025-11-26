import javax.swing.*;
import java.sql.*;

public class DeleteEmployeeSkillDialog extends JDialog {

    private final Database db;
    private JComboBox<String> combo;

    public DeleteEmployeeSkillDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        init();
        loadData();
    }

    private void loadData() {
        String sql =
            "SELECT es.employee_id, e.first_name, e.last_name, es.skill_code, s.skill_name, es.skill_level_code " +
            "FROM employee_skills es " +
            "JOIN employees e ON e.employee_id = es.employee_id " +
            "JOIN ref_skills s ON s.skill_code = es.skill_code " +
            "ORDER BY es.employee_id";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                combo.addItem(
                    rs.getInt(1) + " • " + rs.getString(2) + " " + rs.getString(3) +
                    " — " + rs.getInt(4) + " • " + rs.getString(5) +
                    " — nivel " + rs.getInt(6)
                );
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    private void init() {
        combo = new JComboBox<>();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancelar");
        JLabel lbl = new JLabel("Habilidad del empleado:");

        ok.addActionListener(e -> deleteRow());
        cancel.addActionListener(e -> close());

        setTitle("Eliminar Habilidad de Empleado");
        setLayout(new java.awt.FlowLayout());
        add(lbl);
        add(combo);
        add(ok);
        add(cancel);
        pack();
    }

    private void deleteRow() {
        try {
            String item = combo.getSelectedItem().toString();

            int empId = Integer.parseInt(item.substring(0, item.indexOf(" •")));
            String after1 = item.substring(item.indexOf("—") + 1).trim();
            int skillCode = Integer.parseInt(after1.substring(0, after1.indexOf(" •")));

            String lvl = item.substring(item.lastIndexOf("nivel") + 6).trim();
            int levelCode = Integer.parseInt(lvl);

            String sql =
                "DELETE FROM employee_skills WHERE employee_id = " + empId +
                " AND skill_code = " + skillCode +
                " AND skill_level_code = " + levelCode;

            db.update(sql);

        } catch (Exception e) { System.out.println(e.getMessage()); }

        close();
    }

    private void close() {
        setVisible(false);
        dispose();
    }
}
