import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class InsertEmployeeSkills extends JDialog {
    private final HashMap ht;
    private final Database db;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JComboBox cmbEmployee;
    private JComboBox cmbskill;
    private JComboBox cmbskillLevel;
    private JButton btnInsertar;
    private JButton btnCancelar;

    public InsertEmployeeSkills(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
        obtenerEmployees();
        obtenerSkills();
        obtenerSkillLevels();
    }

    private void initComponents() {
        jlabel1 = new JLabel();
        jlabel2 = new JLabel();
        jlabel3 = new JLabel();
        cmbEmployee=new JComboBox();
        cmbskill =new JComboBox();
        cmbskillLevel =new JComboBox();
        btnCancelar=new JButton();
        btnInsertar=new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Employee skill");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Employee:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Skill:");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel3.setText("Skill level:");

        cmbEmployee.setFont(new java.awt.Font("Tahoma", 0, 14));
        cmbskill.setFont(new java.awt.Font("Tahoma", 0, 14));
        cmbskillLevel.setFont(new java.awt.Font("Tahoma", 0, 14));

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

        // Configuración para el espaciado automático
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jlabel1)
                                        .addComponent(jlabel2)
                                        .addComponent(jlabel3)
                                        .addComponent(btnInsertar))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbskill, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbskillLevel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancelar))
                                .addGap(20, 20, 20))
        );

        // Agregamos un grupo paralelo para alinear los botones en la base
        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnInsertar});

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel1)
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel2)
                                        .addComponent(cmbskill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3)
                                        .addComponent(cmbskillLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnInsertar)
                                        .addComponent(btnCancelar))
                                .addGap(20, 20, 20))
        );

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String employee = cmbEmployee.getSelectedItem().toString();
        int idEmployee = Integer.parseInt(employee.split(" - ")[0]);
        String skill = cmbskill.getSelectedItem().toString();
        int idSkill = Integer.parseInt(skill.split(" - ")[0]);
        String skillLevel = cmbskillLevel.getSelectedItem().toString();
        int idSkillLevel = Integer.parseInt(skillLevel.split(" - ")[0]);

        StringBuilder sql
                = new StringBuilder("INSERT INTO employee_skills (employee_id, skill_code, skill_level_code) " +
                "VALUES (");
        sql.append(idEmployee);
        sql.append(",");
        sql.append(idSkill);
        sql.append(",");
        sql.append(idSkillLevel);
        sql.append(")");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Employee skill added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void obtenerEmployees() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT first_name, employee_id FROM employees as emp WHERE NOT EXISTS " +
                    "(SELECT employee_id FROM employee_skills as empS WHERE emp.employee_id = empS.employee_id)");

            // Limpiar combo antes de llenarlo
            cmbEmployee.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("first_name");
                int id = rs.getInt("employee_id");
                cmbEmployee.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar employees: " + e.getMessage());
        }
    }

    private void obtenerSkills() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT skill_name, skill_code FROM ref_skills as rS WHERE NOT EXISTS " +
                    "(SELECT skill_code FROM employee_skills as empS WHERE rS.skill_code = empS.skill_code)");

            // Limpiar combo antes de llenarlo
            cmbskill.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("skill_name");
                int id = rs.getInt("skill_code");
                cmbskill.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar skills: " + e.getMessage());
        }
    }

    private void obtenerSkillLevels() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT skill_level_name, skill_level_code FROM ref_skill_levels");
            // Limpiar combo antes de llenarlo
            cmbskillLevel.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("skill_level_name");
                int id = rs.getInt("skill_level_code");
                cmbskillLevel.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar skill levels: " + e.getMessage());
        }
    }
}
