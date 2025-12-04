import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateRole extends JDialog{
    private final HashMap ht;
    private final Database db;

    private JLabel label1;
    private JLabel label2;
    private JComboBox cmbRole;
    private JTextField txtRoleName;
    private JTextField txtRoleDescription;
    private JButton btnUpdate;
    private JButton btnCancelar;
    private JButton btnCargar;

    public UpdateRole(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
        obtenerRoles();
    }

    private void initComponents() {
        label1=new JLabel();
        label2=new JLabel();
        txtRoleName=new JTextField();
        txtRoleDescription=new JTextField();
        btnUpdate=new JButton();
        btnCancelar=new JButton();
        btnCargar=new JButton();
        cmbRole=new JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update role");
        setResizable(false);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14));
        label1.setText("Role name:");
        label2.setFont(new java.awt.Font("Tahoma", 1, 14));
        label2.setText("Role description:");

        cmbRole.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtRoleName.setColumns(11);
        txtRoleName.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtRoleDescription.setColumns(11);
        txtRoleDescription.setFont(new java.awt.Font("Tahoma", 0, 14));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });

        btnCargar.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatos();
            }
        });

        // Crear el layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtRoleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCargar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCargar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(txtRoleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnCancelar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String role = cmbRole.getSelectedItem().toString();
        String roleCode = role.split(" - ")[0];

        String roleName = txtRoleName.getText();
        String roleDescription = txtRoleDescription.getText();

        StringBuilder sql = new StringBuilder("UPDATE ref_roles SET role_name='"+roleName+"', " +
                "role_description='"+roleDescription+"' WHERE role_code='"+roleCode+"'");

        System.out.println(sql.toString());

        try {
            db.update(sql.toString());
            JOptionPane.showMessageDialog(this, "Role updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println(ex.getMessage());
        }
        setVisible(false);
    }

    private void obtenerRoles() {
        try {
            ResultSet rs = db.query("SELECT role_name, role_code FROM ref_roles");

            cmbRole.removeAllItems();

            while (rs.next()) {
                String name = rs.getString("role_name");
                String code = rs.getString("role_code");
                cmbRole.addItem(code + " - " + name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar roles: " + e.getMessage());
        }
    }

    private void cargarDatos(){
        String role = cmbRole.getSelectedItem().toString();
        String roleCode = role.split(" - ")[0];

        final String sql = "SELECT role_name, role_description FROM ref_roles WHERE role_code='"+roleCode+"'";
        try {
            ResultSet rs = db.query(sql);
            if (rs != null) {
                if (rs.next()) {
                    String roleName = rs.getString("role_name");
                    String roleDescription = rs.getString("role_description");

                    txtRoleName.setText(roleName);
                    txtRoleDescription.setText(roleDescription);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se encontraron datos para el role seleccionado",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                rs.close();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al ejecutar la consulta",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}