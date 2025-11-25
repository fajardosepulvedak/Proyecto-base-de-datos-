import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCalendarDateDialog extends JDialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private int returnStatus = RET_CANCEL;

    private final Database db;
    private JComboBox<String> combo;

    public DeleteCalendarDateDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        initComponents();
        loadDates();
    }

    private void loadDates() {
        String sql = "SELECT day_date, day_name FROM ref_calendar ORDER BY day_date";
        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                combo.addItem(rs.getString(1) + " • " + rs.getString(2));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    private void initComponents() {
        combo = new JComboBox<>();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancelar");
        JLabel l = new JLabel("Día del calendario:");

        ok.addActionListener(e -> deleteDate());
        cancel.addActionListener(e -> doClose(RET_CANCEL));

        setTitle("Eliminar Día del Calendario");
        setLayout(new java.awt.FlowLayout());
        add(l);
        add(combo);
        add(ok);
        add(cancel);
        pack();
    }

    private void deleteDate() {
        try {
            String item = combo.getSelectedItem().toString();
            String date = item.substring(0, item.indexOf(" •"));

            String sql = "DELETE FROM ref_calendar WHERE day_date = '" + date + "'";
            db.update(sql);

        } catch (SQLException e) { System.out.println(e.getMessage()); }

        doClose(RET_OK);
    }

    private void doClose(int s) {
        returnStatus = s;
        setVisible(false);
        dispose();
    }
}
