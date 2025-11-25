import javax.swing.*;
import java.sql.*;

public class DeleteSkillLevelDialog extends JDialog {

    private final Database db;
    private JComboBox<String> combo;

    public DeleteSkillLevelDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        initComponents();
        loadSkillLevels();
    }

    private void loadSkillLevels() {
        String sql = "SELECT skill_level_code, skill_level_name FROM ref_skill_levels ORDER BY skill_level_code";
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
        JButton cancel = new JButton("Cancelar");
        JLabel label = new JLabel("Nivel a eliminar:");

        ok.addActionListener(e -> deleteSkillLevel());
        cancel.addActionListener(e -> doClose());

        setTitle("Eliminar Nivel de Habilidad");
        setLayout(new java.awt.FlowLayout());
        add(label);
        add(combo);
        add(ok);
        add(cancel);
        pack();
    }

    private void deleteSkillLevel() {
        try {
            String item = combo.getSelectedItem().toString();
            int id = Integer.parseInt(item.split(" •")[0]);

            db.update("DELETE FROM ref_skill_levels WHERE skill_level_code = " + id);

        } catch (SQLException e) { System.out.println(e.getMessage()); }

        doClose();
    }

    private void doClose() {
        setVisible(false);
        dispose();
    }
}
