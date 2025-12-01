import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class InsertRole extends javax.swing.JDialog{
    private final HashMap ht;
    private final Database db;
    private StringBuilder sqlFinal;

    private JLabel jlabel1;
    private JTextField txtRoleName;
    private JButton btnInsertar;
    private JButton btnCancelar;
    private JButton btnConfirmar;

    public InsertRole(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
    }

    private void initComponents() {
        jlabel1 = new JLabel();
        txtRoleName = new JTextField();
        btnCancelar = new JButton();
        btnInsertar = new JButton();
        btnConfirmar= new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Role");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Role name:");

        txtRoleName.setColumns(11);
        txtRoleName.setFont(new java.awt.Font("Tahoma", 0, 14));

        btnInsertar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformedCancelar(evt);
            }
        });

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformedConfirmar(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Horizontal group
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel1)
                                .addComponent(txtRoleName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addComponent(btnConfirmar)
                                .addComponent(btnCancelar))
        );

        // Vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel1)
                                .addComponent(txtRoleName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(btnConfirmar)
                                .addComponent(btnCancelar))
        );

        pack();
        setLocationRelativeTo(null);

    }

    private void okButtonActionPerformedConfirmar(ActionEvent evt) {
        StringBuilder sql=sqlFinal;
        sql.append(" ");
        sql.append("COMMIT;");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Role added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void okButtonActionPerformedCancelar(ActionEvent evt) {
        StringBuilder sql=sqlFinal;
        sql.append(" ");
        sql.append("ROLLBACK;");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Operation canceled");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String roleName = txtRoleName.getText();
        StringBuilder sql
                = new StringBuilder("INSERT INTO ref_roles (role_name) " +
                "VALUES (");
        sql.append("\'");
        sql.append(roleName);
        sql.append("\'");
        sql.append(");");

        sqlFinal=sql;
        JOptionPane.showMessageDialog(this, "Datos listos para insertar");
    }
}
