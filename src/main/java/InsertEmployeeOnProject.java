import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class InsertEmployeeOnProject extends JDialog{
    private StringBuilder sqlFinal;
    private StringBuilder sqlFinal2;
    private final HashMap ht;
    private final Database db;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JLabel jlabel4;
    private JLabel jlabel5;
    private JLabel jlabel6;
    private JLabel jlabel7;
    private JLabel jlabel8;

    private JTextField txtHourlyRate;
    private JTextField txtHoursAllocated;
    private JTextField txtPerfomanceNotes;
    private JComboBox cmbFromDayDate;
    private JComboBox cmbToDayDate;
    private JTextField txtStaffId;

    private JComboBox cmbEmployee;
    private JComboBox cmbProjects;
    private JButton btnInsertar;
    private JButton btnCancelar;
    private JButton btnConfirmar;

    public InsertEmployeeOnProject(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
        obtenerEmployees();
        obtenerProjects();
        obtenerDates();
    }


    private void initComponents() {
        jlabel1=new JLabel();
        jlabel2=new JLabel();
        jlabel3=new JLabel();
        jlabel4=new JLabel();
        jlabel5=new JLabel();
        jlabel6=new JLabel("MM-DD-YYYY");
        jlabel7=new JLabel("MM-DD-YYYY");
        jlabel8=new JLabel();
        txtHourlyRate=new JTextField();
        txtHoursAllocated=new JTextField();
        cmbToDayDate=new JComboBox();
        cmbFromDayDate=new JComboBox();
        txtPerfomanceNotes=new JTextField();
        txtStaffId=new JTextField();
        cmbEmployee=new JComboBox();
        cmbProjects=new JComboBox();
        btnCancelar=new JButton();
        btnInsertar=new JButton();
        btnConfirmar=new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Employee on project");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Employee:");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Project:");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel3.setText("Performance notes:");

        jlabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel4.setText("Hourly rate:");

        jlabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel5.setText("Hours allocated:");

        jlabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel6.setText("From day date:");

        jlabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel7.setText("To day date:");

        jlabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel8.setText("Staff id:");

        txtStaffId.setColumns(11);
        txtStaffId.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtPerfomanceNotes.setColumns(11);
        txtPerfomanceNotes.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtHourlyRate.setColumns(11);
        txtHourlyRate.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtHoursAllocated.setColumns(11);
        txtHoursAllocated.setFont(new java.awt.Font("Tahoma", 0, 14));

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
                okButtonActionPerformedCancelar();
            }
        });

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformedConfirmar();
            }
        });

        cmbProjects.setFont(new java.awt.Font("Tahoma", 0, 14));
        cmbEmployee.setFont(new java.awt.Font("Tahoma", 0, 14));
        cmbToDayDate.setFont(new java.awt.Font("Tahoma", 0, 14));
        cmbFromDayDate.setFont(new java.awt.Font("Tahoma", 0, 14));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20) // Margen izquierdo
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        // Columna 1 de Etiquetas (Alineación a la Derecha)
                                        .addComponent(jlabel1) // Employee
                                        .addComponent(jlabel2) // Project
                                        .addComponent(jlabel8) // Staff id
                                        .addComponent(jlabel4) // Hourly rate
                                        .addComponent(jlabel5) // Hours allocated
                                        .addComponent(jlabel6) // From day date
                                        .addComponent(jlabel7) // To day date
                                        .addComponent(jlabel3) // Performance notes
                                )
                                .addGap(18, 18, 18) // Espacio entre etiqueta y campo
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        // Columna 2 de Componentes de Entrada
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbProjects, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtStaffId, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHourlyRate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHoursAllocated, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbFromDayDate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbToDayDate, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPerfomanceNotes, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(20, 20, 20) // Margen derecho
                        )
                        // Botones alineados a la derecha
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsertar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConfirmar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addGap(20, 20, 20))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20) // Margen superior
                                // Fila 1: Employee
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel1)
                                        .addComponent(cmbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) // Espacio entre filas
                                // Fila 2: Project
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel2)
                                        .addComponent(cmbProjects, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 3: Staff id
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel8)
                                        .addComponent(txtStaffId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 4: Hourly rate
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel4)
                                        .addComponent(txtHourlyRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 5: Hours allocated
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel5)
                                        .addComponent(txtHoursAllocated, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 6: From day date
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel6)
                                        .addComponent(cmbFromDayDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 7: To day date
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel7)
                                        .addComponent(cmbToDayDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Fila 8: Performance notes
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3)
                                        .addComponent(txtPerfomanceNotes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(20, 20, 20) // Espacio antes de los botones
                                // Fila de Botones
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnConfirmar)
                                        .addComponent(btnInsertar)
                                )
                                .addGap(20, 20, 20) // Margen inferior
                        )
        );

        // Esto es necesario para que el contenedor se ajuste al tamaño preferido de los componentes
        pack();
    }

    private void okButtonActionPerformedConfirmar() {
        StringBuilder sql=sqlFinal;
        StringBuilder sql2=sqlFinal2;
        sql.append(" ");
        sql.append("COMMIT;");
        sql2.append(" ");
        sql2.append("COMMIT;");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            db.update( sql2.toString() );
            JOptionPane.showMessageDialog(this, "Employee on project add");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void okButtonActionPerformedCancelar() {
        StringBuilder sql=sqlFinal;
        StringBuilder sql2=sqlFinal2;
        sql.append(" ");
        sql.append("ROLLBACK;");
        sql.append(" ");
        sql.append("ROLLBACK;");
        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            db.update( sql2.toString() );
            JOptionPane.showMessageDialog(this, "Operation Canceled");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String employee = cmbEmployee.getSelectedItem().toString();
        int idEmployee = Integer.parseInt(employee.split(" - ")[0]);
        String project = cmbProjects.getSelectedItem().toString();
        int idProject = Integer.parseInt(project.split(" - ")[0]);
        double hourlyRate = Double.parseDouble(txtHourlyRate.getText());
        int hoursdAllo = Integer.parseInt(txtHoursAllocated.getText());
        String notes = txtPerfomanceNotes.getText();
        String fromday= cmbFromDayDate.getSelectedItem().toString();
        String today= cmbToDayDate.getSelectedItem().toString();
        int staffID=Integer.parseInt(txtStaffId.getText());


        StringBuilder sql
                = new StringBuilder("INSERT INTO employee_on_projects (hourly_rate, hours_allocated, performance_notes, project_id, employee_id, from_day_date, to_day_date, staff_id) " +
                "VALUES (");
        sql.append(hourlyRate);
        sql.append(",");
        sql.append(hoursdAllo);
        sql.append(",");
        sql.append("\'");
        sql.append(notes);
        sql.append("\',");
        sql.append(idProject);
        sql.append(",");
        sql.append(idEmployee);
        sql.append(",");
        sql.append("\'");
        sql.append(fromday);
        sql.append("\',");
        sql.append("\'");
        sql.append(today);
        sql.append("\',");
        sql.append(staffID);
        sql.append(");");

        sqlFinal=sql;

        StringBuilder sql2 = new StringBuilder("Update ref_calendar set business_day_yn = 't' Where day_date='"+fromday+"' or day_date='"+today+"';");
        sqlFinal2=sql2;

        JOptionPane.showMessageDialog(this, "Datos listos para insertar");
    }

    private void obtenerEmployees() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT first_name, employee_id FROM employees");

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

    private void obtenerProjects() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT project_name, project_id FROM projects");

            // Limpiar combo antes de llenarlo
            cmbProjects.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("project_name");
                int id = rs.getInt("project_id");
                cmbProjects.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar projects: " + e.getMessage());
        }
    }

    private void obtenerDates() {
        try {
            // Ejecutar consulta
            ResultSet rs = db.query("SELECT day_date FROM ref_calendar WHERE business_day_yn='f'");

            // Limpiar combo antes de llenarlo
            cmbFromDayDate.removeAllItems();
            cmbToDayDate.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String date = rs.getString("day_date");
                cmbFromDayDate.addItem(date);
                cmbToDayDate.addItem(date);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar employees: " + e.getMessage());
        }
    }
}
