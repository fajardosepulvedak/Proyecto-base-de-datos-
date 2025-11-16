import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;


public class InsertEmployees extends javax.swing.JFrame{

    private final Database db;

    private JPanel panel1;
    private JTextField fnameText;
    private JTextField lnameText;
    private JTextField birthText;
    private JTextField hireText;
    private JTextField salaryText;
    private JTextField emailText;
    private JTextField phoneText;
    private JComboBox roleCombobox;
    private JComboBox supervisorCombobox;
    private JButton insertarButton;
    private JFrame frame;

    public InsertEmployees(Database db){
        this.db = db;

    }
    public void mostrar(){
        frame=new JFrame("Aplicación CRUD Empleados");
        frame.setContentPane(panel1);   // panel1 viene del .form
        frame.setTitle("Employee");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


  /*  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        String nombre = txtNombre.getText();
        Integer idProveedor = (Integer) ht.get( comboProv.getSelectedItem() );
        String precio = txtPrecio.getText();
        String ventas = txtVentas.getText();
        String total = txtTotal.getText();

        StringBuilder sql
                = new StringBuilder("INSERT INTO coffees (COF_NAME,SUP_ID,PRICE,SALES,TOTAL) VALUES (\'");
        sql.append(nombre);
        sql.append("\',");
        sql.append( idProveedor.intValue() );
        sql.append(",");
        sql.append(precio);
        sql.append(",");
        sql.append(ventas);
        sql.append(",");
        sql.append(total);
        sql.append(")");


        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar café.");
            System.out.println( ex.getMessage() );
        }
        setVisible(false);
    }*/

}
