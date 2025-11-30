import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class InsertEmployeeSkills extends JDialog {
    private final HashMap ht;
    private final Database db;
    private StringBuilder sqlFinal;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JComboBox cmbEmployee;
    private JComboBox cmbskill;
    private JComboBox cmbskillLevel;
    private JButton btnInsertar;
    private JButton btnCancelar;
    private JButton btnConfirmar;

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
        btnConfirmar=new JButton();

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

        // Activación de gestión automática de espacios
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // 1. Diseño Horizontal (Filas): Define cómo se organizan los componentes
        // en cada fila. Los componentes se agrupan horizontalmente.
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        // Columna de JLabels
                                        .addComponent(jlabel1)
                                        .addComponent(jlabel2)
                                        .addComponent(jlabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        // Columna de JComboBoxes
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbskill, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbskillLevel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                // Fila de botones, alineados a la derecha
                                .addComponent(btnInsertar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConfirmar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
        );

        // 2. Diseño Vertical (Columnas): Define cómo se organizan los componentes
        // en cada columna. Los componentes se apilan verticalmente.
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                // Fila 1: Employee Label y ComboBox
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel1)
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 2: Skill Label y ComboBox
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel2)
                                        .addComponent(cmbskill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 3: Skill Level Label y ComboBox
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3)
                                        .addComponent(cmbskillLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                // Fila 4: Botones
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnConfirmar)
                                        .addComponent(btnInsertar)))
        );

        pack();
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
            JOptionPane.showMessageDialog(this, "Employee skill added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
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
        sql.append(");");

        sqlFinal=sql;
        JOptionPane.showMessageDialog(this, "Datos listos para insertar");
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
