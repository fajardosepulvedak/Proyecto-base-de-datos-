import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateSkill extends JDialog{
    private final HashMap ht;
    private final Database db;
    private StringBuilder sqlFinal;

    private JLabel label1;
    private JLabel label2;
    private JComboBox cmbSkill;
    private JTextField txtSkillName;
    private JTextField txtSkillCategory;
    private JButton btnUpdate;
    private JButton btnCancelar;
    private JButton btnCargar;

    public UpdateSkill(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
        obtenerSkills();
    }

    private void initComponents() {
        label1=new JLabel();
        label2=new JLabel();
        txtSkillName=new JTextField();
        txtSkillCategory=new JTextField();
        btnUpdate=new JButton();
        btnCancelar=new JButton();
        btnCargar=new JButton();
        cmbSkill=new JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update skill");
        setResizable(false);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Skill name:");
        label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label2.setText("Skill category:");

        cmbSkill.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtSkillName.setColumns(11);
        txtSkillName.setFont(new java.awt.Font("Tahoma", 0, 14));
        
        txtSkillCategory.setColumns(11);
        txtSkillCategory.setFont(new java.awt.Font("Tahoma", 0, 14));
        
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
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

        btnCargar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                                                .addComponent(txtSkillName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSkillCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(cmbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCargar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(txtSkillName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(txtSkillCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnCancelar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

// Ajustar el tamaño de la ventana automáticamente
        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String skill = cmbSkill.getSelectedItem().toString();
        int idSkill = Integer.parseInt(skill.split(" - ")[0]);

        String skillName=txtSkillName.getText();
        String skillCategory=txtSkillCategory.getText();

        StringBuilder sql = new StringBuilder("Update ref_skills set skill_name='"+skillName+"', " +
                "skill_category='"+skillCategory+"' Where skill_code='"+idSkill+"'");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Skill updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void obtenerSkills() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT skill_name, skill_code FROM ref_skills");

            // Limpiar combo antes de llenarlo
            cmbSkill.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("skill_name");
                int id = rs.getInt("skill_code");
                cmbSkill.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar skills: " + e.getMessage());
        }
    }

    private void cargarDatos(){
        String skill = cmbSkill.getSelectedItem().toString();
        int idSkill = Integer.parseInt(skill.split(" - ")[0]);

        final String sql = "SELECT skill_name, skill_category FROM ref_skills WHERE skill_code="+idSkill;
        try {
            ResultSet rs = db.query(sql);
            if (rs != null) {

                if (rs.next()) {
                    String skillName = rs.getString("skill_name");
                    String skillCategory = rs.getString("skill_category");

                    txtSkillName.setText(skillName);
                    txtSkillCategory.setText(skillCategory);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se encontraron datos para el skill seleccionado",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("No se encontraron resultados"); // Debug
                }
                rs.close();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al ejecutar la consulta",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println("ResultSet es null"); // Debug
            }

        } catch (SQLException ex) {
            System.out.println( ex.getMessage() );
        }
    }
}
