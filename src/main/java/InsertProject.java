import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertProject extends javax.swing.JDialog{
    private final HashMap ht;
    private final Database db;

    public InsertProject(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        this.db = db;
        ht = new HashMap<String, Integer>();
    }

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JTextField txtClientId;
    private JTextField txtPname;
    private JTextField txtPStartDate;
    private JTextField txtPEndDate;
    private JTextField txtPbudget;
    private JTextArea txtPdescription;
    private JButton btnInsertar;
    private JButton btnCancelar;

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtClientId = new JTextField();
        txtPname = new JTextField();
        txtPStartDate = new JTextField("DD-MM-YYYY");
        txtPEndDate = new JTextField("DD-MM-YYYY");
        txtPbudget = new JTextField();
        txtPdescription = new JTextArea();
        btnInsertar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Project");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Client id:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("P. name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("P. start date:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("P. end date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("P. budget:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("P. description:");

        txtClientId.setColumns(11);
        txtClientId.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtPname.setColumns(11);
        txtPname.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtPStartDate.setColumns(11);
        txtPStartDate.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtPEndDate.setColumns(11);
        txtPEndDate.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtPbudget.setColumns(11);
        txtPbudget.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtPdescription.setColumns(30);
        txtPdescription.setFont(new java.awt.Font("Tahoma", 0, 14));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtClientId)
                                        .addComponent(txtPname)
                                        .addComponent(txtPStartDate)
                                        .addComponent(txtPEndDate)
                                        .addComponent(txtPbudget)
                                        .addComponent(txtPdescription)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addGap(20)
                                .addComponent(btnCancelar))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtClientId))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtPname))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtPStartDate))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtPEndDate))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtPbudget))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtPdescription))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(btnCancelar))
        );

        pack();
        
    }
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int clientId= Integer.parseInt(txtClientId.getText());
        String Pname = txtPname.getText();
        String startDate = txtPStartDate.getText();
        String endDate= txtPEndDate.getText();
        double budget = Double.parseDouble(txtPbudget.getText());
        String description = txtPdescription.getText();

        StringBuilder sql
                = new StringBuilder("INSERT INTO projects (client_id, project_name, project_start_date, project_end_date, project_status, project_budget, project_description) " +
                "VALUES (");
        sql.append(clientId);
        sql.append(",");
        sql.append("\'");
        sql.append(Pname);
        sql.append("\',");
        sql.append("\'");
        sql.append(startDate);
        sql.append("\',");
        sql.append("\'");
        sql.append(endDate);
        sql.append("\',");
        sql.append("\'");
        sql.append("Active");
        sql.append("\',");
        sql.append(budget);
        sql.append(",");
        sql.append("\'");
        sql.append(description);
        sql.append("\'");
        sql.append(")");


        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Project added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }
    }

