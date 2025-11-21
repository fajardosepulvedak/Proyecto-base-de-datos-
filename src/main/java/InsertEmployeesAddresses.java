import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class InsertEmployeesAddresses extends JDialog{
    private final HashMap ht;
    private final Database db;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JComboBox comboEmployee;
    private JTextField txtLine1;
    private JTextField txtLine2;
    private JTextField txtLine3;
    private JTextField txtTwonCity;
    private JTextField txtState;
    private JTextField txtCountryCode;
    private JTextField txtDateFrom;
    private JTextField txtDateTo;
    private JButton btnCancelar;
    private JButton btnInsertar;

    public InsertEmployeesAddresses(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        obtenerEmployees();
        this.db = db;
        ht = new HashMap<String, Integer>();

    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        comboEmployee = new JComboBox();
        txtLine1 = new JTextField();
        txtLine2 = new JTextField();
        txtLine3 = new JTextField();
        txtTwonCity = new JTextField();
        txtState = new JTextField();
        txtCountryCode = new JTextField();
        txtDateFrom = new JTextField("DD-MM-YYYY");
        txtDateTo = new JTextField("DD-MM-YYYY");
        btnCancelar = new JButton();
        btnInsertar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Employee Address");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Employee:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Line 1:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Line 2:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Line 3:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Twon/City:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("State province:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Country code:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Date address from:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Date address from:");

        comboEmployee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtLine1.setColumns(11);
        txtLine1.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtLine2.setColumns(11);
        txtLine2.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtLine3.setColumns(11);
        txtLine3.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtTwonCity.setColumns(11);
        txtTwonCity.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtState.setColumns(11);
        txtState.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtCountryCode.setColumns(11);
        txtCountryCode.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtDateFrom.setColumns(11);
        txtDateFrom.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtDateTo.setColumns(11);
        txtDateTo.setFont(new java.awt.Font("Tahoma", 0, 14));

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

// Auto gaps entre componentes y bordes
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

// Definición horizontal
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(comboEmployee, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLine1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLine2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLine3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTwonCity, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtState, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCountryCode, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDateFrom, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDateTo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(btnInsertar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(30)
                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        );

// Definición vertical
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(comboEmployee))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtLine1))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtLine2))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtLine3))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtTwonCity))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtState))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtCountryCode))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtDateFrom))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtDateTo))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(btnCancelar))
        );
        pack();
    }

    private void obtenerEmployees() {
        try {
            // Conectar usando tu clase Database
            Database db = Database.getDatabase("kevin", "Mark4557");

            // Ejecutar consulta
            ResultSet rs = db.query("SELECT first_name, employee_id FROM employees as emp WHERE NOT EXISTS " +
                    "(SELECT employee_id FROM employee_addresses as empAd WHERE emp.employee_id = empAd.employee_id)");

            // Limpiar combo antes de llenarlo
            comboEmployee.removeAllItems();

            // Recorrer resultados y agregar al combo
            while (rs.next()) {
                String name = rs.getString("first_name");
                int id = rs.getInt("employee_id");
                comboEmployee.addItem(id+" - "+name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar employees: " + e.getMessage());
        }
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selected = comboEmployee.getSelectedItem().toString();
        int id = Integer.parseInt(selected.split(" - ")[0]);
        String line1 = txtLine1.getText();
        String line2 = txtLine2.getText();
        String line3 = txtLine3.getText();
        String city = txtTwonCity.getText();
        String state = txtState.getText();
        String country = txtCountryCode.getText();
        String dateFrom = txtDateFrom.getText();
        String dateTo = txtDateTo.getText();

        StringBuilder sql
                = new StringBuilder("INSERT INTO addresses (line_1, line_2, line_3, town_city, state_province, country_code) " +
                "VALUES (\'");
        sql.append(line1);
        sql.append("\',");
        sql.append("\'");
        sql.append(line2);
        sql.append("\',");
        sql.append("\'");
        sql.append(line3);
        sql.append("\',");
        sql.append("\'");
        sql.append(city);
        sql.append("\',");
        sql.append("\'");
        sql.append(state);
        sql.append("\',");
        sql.append("\'");
        sql.append(country);
        sql.append("\'");
        sql.append(")");


        System.out.println( sql.toString() );

        StringBuilder sql2
                = new StringBuilder("INSERT INTO employee_addresses (employee_id, address_id, date_address_from, date_address_to) " +
                "VALUES (");
        sql2.append(id);
        sql2.append(",");
        sql2.append("(Select address_id from addresses where " +
                "line_1='"+line1+"' and line_2='"+line2+"' and line_3='"+line3+"' and town_city='"+city+"' and state_province='"+state+"' and country_code='"+country+"')");
        sql2.append(",");
        sql2.append("\'");
        sql2.append(dateFrom);
        sql2.append("\',");
        sql2.append("\'");
        sql2.append(dateTo);
        sql2.append("\'");
        sql2.append(")");


        System.out.println( sql2.toString() );

        try {
            db.update( sql.toString() );
            db.update( sql2.toString() );
            JOptionPane.showMessageDialog(this, "Address added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }
}
