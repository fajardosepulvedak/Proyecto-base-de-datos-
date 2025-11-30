import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertCalendar extends javax.swing.JDialog{
    private final HashMap ht;
    private final Database db;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JLabel jlabel4;
    private JTextField txtDayDate;
    private JTextField txtDayNumber;
    private JTextField txtPeriodId;
    private JTextField txtDayName;
    private JButton btnInsertar;
    private JButton btnCancelar;

    public InsertCalendar(java.awt.Frame parent, Database db){
        super(parent, true);
        this.db = db;
        ht = new HashMap<String, Integer>();
        initComponents();
    }

    private void initComponents() {
        jlabel1 = new JLabel();
        jlabel2 = new JLabel();
        jlabel3 = new JLabel();
        jlabel4 = new JLabel();
        txtDayDate = new JTextField("MM-DD-YYYY");
        txtDayNumber = new JTextField();
        txtPeriodId = new JTextField();
        txtDayName = new JTextField();
        btnCancelar = new JButton();
        btnInsertar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insert Calendar");
        setResizable(false);

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("Day date:");
        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Day number:");
        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel3.setText("Period Id:");
        jlabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel4.setText("Day name:");

        txtDayDate.setColumns(11);
        txtDayDate.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtDayNumber.setColumns(11);
        txtDayNumber.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtPeriodId.setColumns(11);
        txtPeriodId.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtDayName.setColumns(11);
        txtDayName.setFont(new java.awt.Font("Tahoma", 0, 14));

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

        // Configura los espacios predeterminados
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20) // Margen izquierdo
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        // Grupo de etiquetas
                                        .addComponent(jlabel1)
                                        .addComponent(jlabel2)
                                        .addComponent(jlabel3)
                                        .addComponent(jlabel4))
                                .addGap(18, 18, 18) // Espacio entre etiquetas y campos de texto
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        // Grupo de campos de texto
                                        .addComponent(txtDayDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDayNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPeriodId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE)) // Margen derecho
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Empuja los botones a la derecha
                                .addComponent(btnInsertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Espacio entre botones
                                .addComponent(btnCancelar)
                                .addGap(20, 20, 20)) // Margen derecho para botones
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20) // Margen superior
                                // Fila 1: Day date
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel1)
                                        .addComponent(txtDayDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Espacio vertical
                                // Fila 2: Day number
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel2)
                                        .addComponent(txtDayNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Espacio vertical
                                // Fila 3: Period Id
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel3)
                                        .addComponent(txtPeriodId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Espacio vertical
                                // Fila 4: Day name
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabel4)
                                        .addComponent(txtDayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26) // Espacio entre campos y botones
                                // Fila 5: Botones
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnInsertar))
                                .addContainerGap(20, Short.MAX_VALUE)) // Margen inferior
        );

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String dayDate = txtDayDate.getText();
        int dayNumber = Integer.parseInt(txtDayNumber.getText());
        int periodId = Integer.parseInt(txtPeriodId.getText());
        String dayName = txtDayName.getText();

        StringBuilder sql
                = new StringBuilder("INSERT INTO ref_calendar (day_date,business_day_yn,day_number,period_id,day_name) " +
                "VALUES (");
        sql.append("\'");
        sql.append(dayDate);
        sql.append("\',");
        sql.append("FALSE");
        sql.append(",");
        sql.append(dayNumber);
        sql.append(",");
        sql.append(periodId);
        sql.append(",");
        sql.append("\'");
        sql.append(dayName);
        sql.append("\'");
        sql.append(")");

        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
            JOptionPane.showMessageDialog(this, "Calendar added");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);

    }
}
