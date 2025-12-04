import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateAddress extends JDialog{
    private final HashMap ht;
    private final Database db;

    private JLabel label1, label2, label3, label4, label5, label6;
    private JComboBox cmbAddress;
    private JTextField txtLine1;
    private JTextField txtLine2;
    private JTextField txtLine3;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtCountry;
    private JButton btnUpdate;
    private JButton btnCancelar;
    private JButton btnCargar;

    public UpdateAddress(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
        obtenerDirecciones();
    }

    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        txtLine1 = new JTextField();
        txtLine2 = new JTextField();
        txtLine3 = new JTextField();
        txtCity = new JTextField();
        txtState = new JTextField();
        txtCountry = new JTextField();

        btnUpdate = new JButton();
        btnCancelar = new JButton();
        btnCargar = new JButton();
        cmbAddress = new JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update address");
        setResizable(false);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14));
        label1.setText("Line 1:");
        label2.setFont(new java.awt.Font("Tahoma", 1, 14));
        label2.setText("Line 2:");
        label3.setFont(new java.awt.Font("Tahoma", 1, 14));
        label3.setText("Line 3:");
        label4.setFont(new java.awt.Font("Tahoma", 1, 14));
        label4.setText("City:");
        label5.setFont(new java.awt.Font("Tahoma", 1, 14));
        label5.setText("State:");
        label6.setFont(new java.awt.Font("Tahoma", 1, 14));
        label6.setText("Country:");

        cmbAddress.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtLine1.setColumns(15);
        txtLine1.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtLine2.setColumns(15);
        txtLine2.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtLine3.setColumns(15);
        txtLine3.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtCity.setColumns(15);
        txtCity.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtState.setColumns(15);
        txtState.setFont(new java.awt.Font("Tahoma", 0, 14));

        txtCountry.setColumns(15);
        txtCountry.setFont(new java.awt.Font("Tahoma", 0, 14));

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
                                                .addComponent(cmbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCargar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(cmbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCargar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(txtLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(txtLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(txtLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5)
                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6)
                                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnCancelar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String address = cmbAddress.getSelectedItem().toString();
        int idAddress = Integer.parseInt(address.split(" - ")[0]);

        String line1 = txtLine1.getText();
        String line2 = txtLine2.getText();
        String line3 = txtLine3.getText();
        String city = txtCity.getText();
        String state = txtState.getText();
        String country = txtCountry.getText();

        StringBuilder sql = new StringBuilder("UPDATE addresses SET " +
                "line_1='"+line1+"', " +
                "line_2='"+line2+"', " +
                "line_3='"+line3+"', " +
                "town_city='"+city+"', " +
                "state_province='"+state+"', " +
                "country_code='"+country+"' " +
                "WHERE address_id="+idAddress);

        System.out.println(sql.toString());

        try {
            db.update(sql.toString());
            JOptionPane.showMessageDialog(this, "Address updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println(ex.getMessage());
        }
        setVisible(false);
    }

    private void obtenerDirecciones() {
        try {
            String sql = "SELECT a.address_id, a.line_1, e.first_name " +
                    "FROM addresses a " +
                    "LEFT JOIN employee_addresses ea ON a.address_id = ea.address_id " +
                    "LEFT JOIN employees e ON ea.employee_id = e.employee_id " +
                    "ORDER BY a.address_id";
            ResultSet rs = db.query(sql);

            cmbAddress.removeAllItems();

            while (rs.next()) {
                int id = rs.getInt("address_id");
                String line1 = rs.getString("line_1");
                String employee = rs.getString("first_name");

                String display = id + " - " + line1;
                if (employee != null) {
                    display += " (" + employee + ")";
                }
                cmbAddress.addItem(display);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar direcciones: " + e.getMessage());
        }
    }

    private void cargarDatos(){
        String address = cmbAddress.getSelectedItem().toString();
        int idAddress = Integer.parseInt(address.split(" - ")[0]);

        final String sql = "SELECT * FROM addresses WHERE address_id="+idAddress;
        try {
            ResultSet rs = db.query(sql);
            if (rs != null) {
                if (rs.next()) {
                    txtLine1.setText(rs.getString("line_1"));
                    txtLine2.setText(rs.getString("line_2"));
                    txtLine3.setText(rs.getString("line_3"));
                    txtCity.setText(rs.getString("town_city"));
                    txtState.setText(rs.getString("state_province"));
                    txtCountry.setText(rs.getString("country_code"));
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se encontraron datos para la dirección seleccionada",
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