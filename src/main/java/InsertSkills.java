import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertSkills extends javax.swing.JDialog {
    private final HashMap ht;
    private final Database db;
    private StringBuilder sqlFinal;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JTextField txtSkillName;
    private JTextField txtSkillCategory;
    private JButton btnInsertar;
    private JButton btnCancelar;
    private JButton btnConfirmar;

    public InsertSkills(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
    }
    private void initComponents() {
        jlabel1=new JLabel();
        jlabel2=new JLabel();
        txtSkillCategory = new JTextField();
        txtSkillName=new JTextField();
        btnInsertar = new JButton();
        btnCancelar = new JButton();
        btnConfirmar=new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Skill");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Skill name:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Skill category:");

        txtSkillName.setColumns(11);
        txtSkillName.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtSkillCategory.setColumns(11);
        txtSkillCategory.setFont(new java.awt.Font("Tahoma", 0, 14));

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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlabel1)
                                        .addComponent(jlabel2))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSkillName)
                                        .addComponent(txtSkillCategory)))
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
                                .addComponent(txtSkillName))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlabel2)
                                .addComponent(txtSkillCategory))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(btnConfirmar)
                                .addComponent(btnCancelar))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void okButtonActionPerformedConfirmar(ActionEvent evt) {
        StringBuilder sql=sqlFinal;
        sql.append(" ");
        sql.append("COMMIT;");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Skill added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String skillName = txtSkillName.getText();
        String skillCat = txtSkillCategory.getText();

        StringBuilder sql
                = new StringBuilder("INSERT INTO ref_skills (skill_name, skill_category) " +
                "VALUES (");
        sql.append("\'");
        sql.append(skillName);
        sql.append("\',");
        sql.append("\'");
        sql.append(skillCat);
        sql.append("\'");
        sql.append(");");

        sqlFinal=sql;
        JOptionPane.showMessageDialog(this, "Datos listos para insertar");
    }
    }



