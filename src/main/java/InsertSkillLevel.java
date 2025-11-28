import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertSkillLevel extends javax.swing.JDialog {
    private final HashMap ht;
    private final Database db;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JTextField txtSkillLevelName;
    private JTextField txtExp;
    private JButton btnInsertar;
    private JButton btnCancelar;

    public InsertSkillLevel(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
    }
    private void initComponents() {
        jlabel1=new JLabel();
        jlabel2=new JLabel();
        txtSkillLevelName = new JTextField();
        txtExp=new JTextField();
        btnInsertar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Skill Level");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Skill level name:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Experience required years:");

        txtSkillLevelName.setColumns(11);
        txtSkillLevelName.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtExp.setColumns(11);
        txtExp.setFont(new java.awt.Font("Tahoma", 0, 14));

        btnInsertar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInsertar.setText("Aceptar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlabel1)
                                        .addComponent(jlabel2))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSkillLevelName)
                                        .addComponent(txtExp)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addComponent(btnCancelar))
        );

        // Vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel1)
                                .addComponent(txtSkillLevelName))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel2)
                                .addComponent(txtExp))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(btnCancelar))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String skillLevelName = txtSkillLevelName.getText();
        int exp = Integer.parseInt(txtExp.getText());

        StringBuilder sql
                = new StringBuilder("INSERT INTO ref_skill_levels (skill_level_name, experience_required_years) " +
                "VALUES (");
        sql.append("\'");
        sql.append(skillLevelName);
        sql.append("\',");
        sql.append(exp);
        sql.append(")");


        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Skill Level added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }
}


