import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class DeleteAddressDialog extends JDialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    private final Database db;

    public DeleteAddressDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;
        initComponents();
        buildCombo();

        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) { doClose(RET_CANCEL); }
        });
    }

    private void buildCombo() {
        String sql = "SELECT address_id, town_city, country_code FROM addresses ORDER BY address_id";
        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String city = rs.getString(2);
                String country = rs.getString(3);
                combo.addItem(id + " • " + city + ", " + country);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        okButton = new JButton();
        cancelButton = new JButton();
        jLabel1 = new JLabel();
        combo = new JComboBox<>();

        setTitle("Eliminar Dirección");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) { closeDialog(evt); }
        });

        okButton.setText("OK");
        okButton.addActionListener(evt -> okButtonActionPerformed(evt));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(evt -> cancelButtonActionPerformed(evt));

        jLabel1.setText("Dirección a eliminar:");

        combo.setFont(new java.awt.Font("Tahoma", 0, 14));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(combo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 150, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(okButton))
                                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);
        pack();
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String item = combo.getSelectedItem().toString();
            int id = Integer.parseInt(item.substring(0, item.indexOf(" •")));

            String sql = "DELETE FROM addresses WHERE address_id = " + id;
            db.update(sql);

        } catch (SQLException ex) { System.out.println(ex.getMessage()); }

        doClose(RET_OK);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    private void closeDialog(java.awt.event.WindowEvent evt) { doClose(RET_CANCEL); }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private JButton cancelButton;
    private JComboBox<String> combo;
    private JLabel jLabel1;
    private JButton okButton;

    private int returnStatus = RET_CANCEL;
}
