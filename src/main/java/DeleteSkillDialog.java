import javax.swing.*;
import java.sql.*;

public class DeleteSkillDialog extends JDialog {

    private final Database db;
    private JComboBox<String> combo;

    public DeleteSkillDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        initComponents();
        loadSkills();
    }

    private void loadSkills() {
        String sql = "SELECT skill_code, skill_name FROM ref_skills ORDER BY skill_code";
        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                combo.addItem(rs.getInt(1) + " • " + rs.getString(2));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    private void initComponents() {
        combo = new JComboBox<>();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JLabel label = new JLabel("Habilidad a eliminar:");

        ok.addActionListener(e -> deleteSkill());
        cancel.addActionListener(e -> doClose());

        setTitle("Eliminar Habilidad");
        setLayout(new java.awt.FlowLayout());
        add(label);
        add(combo);
        add(ok);
        add(cancel);
        pack();
    }

    private void deleteSkill() {
        try {
            String item = combo.getSelectedItem().toString();
            int id = Integer.parseInt(item.split(" •")[0]);

            db.update("DELETE FROM ref_skills WHERE skill_code = " + id);

        } catch (SQLException e) { System.out.println(e.getMessage()); }

        doClose();
    }

    private void doClose() {
        setVisible(false);
        dispose();
    }
}
