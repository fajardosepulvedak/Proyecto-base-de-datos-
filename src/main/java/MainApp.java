import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MainApp extends JFrame {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getSimpleName());

    private final String USER = "kevin";
    private final String PASS = "Mark4557";
    private final Database db;
    private final JDesktopPane desktopPane;

    public MainApp() {
        db = Database.getDatabase(USER, PASS);

        setTitle("Main");
        setSize(1100, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Employee Management Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(title, BorderLayout.NORTH);

        // Inicializar el JDesktopPane antes de usarlo en el layout
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(230, 230, 230));

        JPanel panel = new JPanel(new GridLayout(2, 3, 25, 25));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 30, 25));
        panel.setBackground(new Color(245, 245, 245));

        panel.add(createCard("Empleados", this::openEmployeesMenu));
        panel.add(createCard("Proyectos", this::openProjectsMenu));
        panel.add(createCard("Direcciones", this::openAddressesMenu));
        panel.add(createCard("Calendario", this::openCalendarMenu));
        panel.add(createCard("Skills", this::openSkillsMenu));
        panel.add(createCard("Roles", this::openRolesMenu));

        // Usar un panel intermedio para organizar las tarjetas y el escritorio
        JPanel contentPanel = new JPanel(new BorderLayout());

        // 1. Añadir el panel de tarjetas en la parte superior del contentPanel
        contentPanel.add(panel, BorderLayout.NORTH);

        // 2. Añadir el escritorio (JDesktopPane) en el centro del contentPanel
        contentPanel.add(desktopPane, BorderLayout.CENTER);

        // 3. Añadir el contentPanel al CENTRO del JFrame principal
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, Runnable action) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
        label.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        card.add(label, BorderLayout.CENTER);

        card.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(new Color(230, 230, 230));
                card.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(Color.WHITE);
                card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                action.run();
            }
        });

        return card;
    }

    //SUBMENÚS

    private void openEmployeesMenu() {
        Object[] options = {
                "Agregar empleado",
                "Eliminar empleado",
                "Eliminar habilidades de empleado",
                "Eliminar asignación a proyecto",
                "Ver empleados",
                "Ver informacion de contacto del empleado",
                "Proyectos empleados",
                "Cancelar"
        };

        int ch = showMenu("Empleados", options);

        switch (ch) {
            case 0 -> new InsertEmployee(this, db).setVisible(true);
            case 1 -> new DeleteEmployeeDialog(this, db).setVisible(true);
            case 2 -> new DeleteEmployeeSkillDialog(this, db).setVisible(true);
            case 3 -> new DeleteEmployeeOnProjectDialog(this, db).setVisible(true);
            case 4 -> browseTable("Employees", "SELECT first_name, last_name, salary FROM employees");
            case 5 -> browseTable("Employees contact", "SELECT first_name, email, phone_number FROM employees");
            case 6 -> browseTable("Employees contact", "SELECT E.first_name, E.last_name, P.project_name FROM" +
                    " employees AS E JOIN employee_on_projects AS EP ON E.employee_id = EP.employee_id JOIN projects AS P ON EP.project_id = P.project_id;");
        }
    }

    private void openProjectsMenu() {
        Object[] options = {
                "Agregar proyecto",
                "Agregar proyecto a empleado",
                "Eliminar proyecto",
                "Ver proyectos",
                "Cancelar"
        };

        int ch = showMenu("Proyectos", options);

        switch (ch) {
            case 0 -> new InsertProject(this, db).setVisible(true);
            case 1 -> new InsertEmployeeOnProject(this, db).setVisible(true);
            case 2 -> new DeleteProjectDialog(this, db).setVisible(true);
            case 3 -> browseTable("Projects", "SELECT * FROM projects");

        }
    }

    private void openAddressesMenu() {
        Object[] options = {
                "Agregar dirección",
                "Eliminar dirección",
                "Ver direcciones",
                "Cancelar"
        };

        int ch = showMenu("Direcciones", options);

        switch (ch) {
            case 0 -> new InsertEmployeesAddresses(this, db).setVisible(true);
            case 1 -> new DeleteAddressDialog(this, db).setVisible(true);
            case 2 -> browseTable("Addresses", "SELECT * FROM addresses");
        }
    }

    private void openCalendarMenu() {
        Object[] options = {
                "Insertar fecha",
                "Eliminar fecha",
                "Ver calendario",
                "Cancelar"
        };

        int ch = showMenu("Calendario", options);

        switch (ch) {
            case 0 -> new InsertCalendar(this, db).setVisible(true);
            case 1 -> new DeleteCalendarDateDialog(this, db).setVisible(true);
            case 2 -> browseTable("Calendar", "SELECT * FROM ref_calendar");
        }
    }

    private void openSkillsMenu() {
        Object[] options = {
                "Agregar skill",
                "Agregar skill level",
                "Agregar skill a employee",
                "Eliminar skill",
                "Eliminar nivel de skill",
                "Ver skills",
                "Cancelar"
        };

        int ch = showMenu("Skills", options);

        switch (ch) {
            case 0 -> new InsertSkills(this, db).setVisible(true);
            case 1 -> new InsertSkillLevel(this,db).setVisible(true);
            case 2 -> new InsertEmployeeSkills(this, db).setVisible(true);
            case 3 -> new DeleteSkillDialog(this, db).setVisible(true);
            case 4 -> new DeleteSkillLevelDialog(this, db).setVisible(true);
            case 5 -> browseTable("Skills", "SELECT * FROM ref_skills");

        }
    }

    private void openRolesMenu() {
        Object[] options = {
                "Agregar rol",
                "Eliminar rol",
                "Ver roles",
                "Cancelar"
        };

        int ch = showMenu("Roles", options);

        switch (ch) {
            case 0 -> new InsertRole(this,db).setVisible(true);
            case 1 -> new DeleteProveedorDialog(this, db).setVisible(true);
            case 2 -> browseTable("Roles", "SELECT * FROM ref_roles");
        }
    }

    //UTILIDADES

    private int showMenu(String title, Object[] options) {
        // return JOptionPane.showOptionDialog(...); // <-- ELIMINAR ESTA LÍNEA

        // **REEMPLAZO** por el diálogo personalizado:
        CustomMenuDialog dialog = new CustomMenuDialog(this, title, options);
        return dialog.showDialog(); // Muestra el diálogo y devuelve la selección
    }

    private void browseTable(String title, String query) {
        try {
            ResultSet rs = db.query(query);
            JDBCTableAdapter model = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser(title, model);

            // 1. Añadir la ventana interna al escritorio
            desktopPane.add(browser);

            // 2. Mostrarla y darle un tamaño/posición por defecto
            browser.setVisible(true);
            browser.setSize(800, 600); // Ajusta el tamaño
            browser.setLocation(50, 50); // Ajusta la posición inicial

            // 3. Opcional: intentar seleccionarla para ponerla al frente
            browser.setSelected(true);

        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        } catch (java.beans.PropertyVetoException ex) {
            // Manejar la excepción de setSelected
            LOGGER.severe("Error al seleccionar la ventana: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
}
