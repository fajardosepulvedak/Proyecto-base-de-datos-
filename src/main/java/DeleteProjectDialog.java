import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class DeleteProjectDialog extends javax.swing.JDialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    private final Database db;

    public DeleteProjectDialog(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;

        initComponents();
        buildCombo();
        setupEscKey();
    }

    private void setupEscKey() {
        String cancelName = "cancel";
        InputMap inputMap = getRootPane()
                .getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0),
                cancelName);

        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    private void buildCombo() {
        final String sql = "SELECT project_id, project_name FROM projects ORDER BY project_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                comboProjects.addItem(
                        rs.getInt("project_id") + " - " + rs.getString("project_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        comboProjects = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Eliminar Proyecto");
        setResizable(false);

        okButton.setText("Eliminar");
        okButton.addActionListener(evt -> okButtonActionPerformed(evt));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(evt -> doClose(RET_CANCEL));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Proyecto:");

        javax.swing.GroupLayout layout =
            new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                    .createSequentialGroup()
                    .addContainerGap(180, Short.MAX_VALUE)
                    .addComponent(okButton)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancelButton)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout
                        .createParallelGroup(
                            javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboProjects,
                            javax.swing.GroupLayout.PREFERRED_SIZE, 260,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addContainerGap(18, Short.MAX_VALUE)));

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout
                    .createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel1)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(comboProjects,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
                        Short.MAX_VALUE)
                    .addGroup(layout
                        .createParallelGroup(
                            javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                    .addContainerGap()));

        pack();
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String item = comboProjects.getSelectedItem().toString();
            String id = item.substring(0, item.indexOf(" - "));

            String sql =
                "DELETE FROM projects WHERE project_id = " + id;

            db.update(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        doClose(RET_OK);
    }

    private void doClose(int retStatus) {
        setVisible(false);
        dispose();
    }

    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> comboProjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
}
