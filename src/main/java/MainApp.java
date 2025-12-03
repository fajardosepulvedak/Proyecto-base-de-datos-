import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

//public class MainApp extends JFrame {
//
//    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getSimpleName());
//
//    private final String USER = "kevin";
//    private final String PASS = "Mark4557";
//    private final Database db;
//    private final JDesktopPane desktopPane;

//    public MainApp() {
//        db = Database.getDatabase(USER, PASS);
//
//        setTitle("Main");
//        setSize(1100, 750);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        setLayout(new BorderLayout());
//
//        JLabel title = new JLabel("Employee Management Dashboard", SwingConstants.CENTER);
//        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
//        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//        add(title, BorderLayout.NORTH);
//
//        // Inicializar el JDesktopPane antes de usarlo en el layout
//        desktopPane = new JDesktopPane();
//        desktopPane.setBackground(new Color(230, 230, 230));
//
//        JPanel panel = new JPanel(new GridLayout(2, 3, 25, 25));
//        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 30, 25));
//        panel.setBackground(new Color(245, 245, 245));
//
//        panel.add(createCard("Empleados", this::openEmployeesMenu));
//        panel.add(createCard("Proyectos", this::openProjectsMenu));
//        panel.add(createCard("Direcciones", this::openAddressesMenu));
//        panel.add(createCard("Calendario", this::openCalendarMenu));
//        panel.add(createCard("Skills", this::openSkillsMenu));
//        panel.add(createCard("Roles", this::openRolesMenu));
//
//        // Usar un panel intermedio para organizar las tarjetas y el escritorio
//        JPanel contentPanel = new JPanel(new BorderLayout());
//
//        // 1. Añadir el panel de tarjetas en la parte superior del contentPanel
//        contentPanel.add(panel, BorderLayout.NORTH);
//
//        // 2. Añadir el escritorio (JDesktopPane) en el centro del contentPanel
//        contentPanel.add(desktopPane, BorderLayout.CENTER);
//
//        // 3. Añadir el contentPanel al CENTRO del JFrame principal
//        add(contentPanel, BorderLayout.CENTER);
//    }

//    private JPanel createCard(String title, Runnable action) {
//        JPanel card = new JPanel(new BorderLayout());
//        card.setBackground(Color.WHITE);
//        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
//        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
//
//        JLabel label = new JLabel(title, SwingConstants.CENTER);
//        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
//        label.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//        card.add(label, BorderLayout.CENTER);
//
//        card.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                card.setBackground(new Color(230, 230, 230));
//                card.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 3));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                card.setBackground(Color.WHITE);
//                card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                action.run();
//            }
//        });
//
//        return card;
//    }
//
//    //SUBMENÚS
//
//    private void openEmployeesMenu() {
//        Object[] options = {
//                "Agregar empleado",
//                "Eliminar empleado",
//                "Eliminar habilidades de empleado",
//                "Eliminar asignación a proyecto",
//                "Ver empleados",
//                "Ver informacion de contacto del empleado",
//                "Proyectos empleados",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Empleados", options);
//
//        switch (ch) {
//            case 0: new InsertEmployee(this, db).setVisible(true); break;
//            case 1: new DeleteEmployeeDialog(this, db).setVisible(true); break;
//            case 2: new DeleteEmployeeSkillDialog(this, db).setVisible(true); break;
//            case 3: new DeleteEmployeeOnProjectDialog(this, db).setVisible(true); break;
//            case 4: browseTable("Employees", "SELECT first_name, last_name, salary FROM employees"); break;
//            case 5: browseTable("Employees contact", "SELECT first_name, email, phone_number FROM employees"); break;
//            case 6: browseTable("Employees contact", "SELECT E.first_name, E.last_name, P.project_name FROM" +
//                    " employees AS E JOIN employee_on_projects AS EP ON E.employee_id = EP.employee_id JOIN projects AS P ON EP.project_id = P.project_id;"); break;
//        }
//    }
//
//    private void openProjectsMenu() {
//        Object[] options = {
//                "Agregar proyecto",
//                "Agregar proyecto a empleado",
//                "Eliminar proyecto",
//                "Ver proyectos",
//                "Ver fechas de inicio/fin",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Proyectos", options);
//
//        switch (ch) {
//            case 0: new InsertProject(this, db).setVisible(true); break;
//            case 1: new InsertEmployeeOnProject(this, db).setVisible(true); break;
//            case 2: new DeleteProjectDialog(this, db).setVisible(true); break;
//            case 3: browseTable("Projects", "SELECT project_name, project_status, project_budget, project_description FROM projects"); break;
//            case 4: browseTable("Fechas", "SELECT project_name, project_start_date, project_end_date FROM projects"); break;
//
//        }
//    }
//
//    private void openAddressesMenu() {
//        Object[] options = {
//                "Agregar dirección",
//                "Eliminar dirección",
//                "Ver direcciones",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Direcciones", options);
//
//        switch (ch) {
//            case 0: new InsertEmployeesAddresses(this, db).setVisible(true); break;
//            case 1: new DeleteAddressDialog(this, db).setVisible(true); break;
//            case 2: browseTable("Addresses", "SELECT * FROM addresses"); break;
//        }
//    }
//
//    private void openCalendarMenu() {
//        Object[] options = {
//                "Insertar fecha",
//                "Eliminar fecha",
//                "Ver calendario",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Calendario", options);
//
//        switch (ch) {
//            case 0: new InsertCalendar(this, db).setVisible(true); break;
//            case 1: new DeleteCalendarDateDialog(this, db).setVisible(true); break;
//            case 2: browseTable("Calendar", "SELECT * FROM ref_calendar"); break;
//        }
//    }
//
//    private void openSkillsMenu() {
//        Object[] options = {
//                "Agregar skill",
//                "Agregar skill level",
//                "Agregar skill a employee",
//                "Eliminar skill",
//                "Eliminar nivel de skill",
//                "Ver skills",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Skills", options);
//
//        switch (ch) {
//            case 0: new InsertSkills(this, db).setVisible(true); break;
//            case 1: new InsertSkillLevel(this,db).setVisible(true); break;
//            case 2: new InsertEmployeeSkills(this, db).setVisible(true); break;
//            case 3: new DeleteSkillDialog(this, db).setVisible(true); break;
//            case 4: new DeleteSkillLevelDialog(this, db).setVisible(true); break;
//            case 5: browseTable("Skills", "SELECT * FROM ref_skills"); break;
//
//        }
//    }
//
//    private void openRolesMenu() {
//        Object[] options = {
//                "Agregar rol",
//                "Eliminar rol",
//                "Ver roles",
//                "Cancelar"
//        };
//
//        int ch = showMenu("Roles", options);
//
//        switch (ch) {
//            case 0: new InsertRole(this,db).setVisible(true);
//            case 1: new DeleteProveedorDialog(this, db).setVisible(true);
//            case 2: browseTable("Roles", "SELECT * FROM ref_roles");
//        }
//    }
//
//    //UTILIDADES
//
//    private int showMenu(String title, Object[] options) {
//        // return JOptionPane.showOptionDialog(...); // <-- ELIMINAR ESTA LÍNEA
//
//        // **REEMPLAZO** por el diálogo personalizado:
//        CustomMenuDialog dialog = new CustomMenuDialog(this, title, options);
//        return dialog.showDialog(); // Muestra el diálogo y devuelve la selección
//    }
//
//    private void browseTable(String title, String query) {
//        try {
//            ResultSet rs = db.query(query);
//            JDBCTableAdapter model = new JDBCTableAdapter(rs);
//            TableBrowser browser = new TableBrowser(title, model);
//
//            // 1. Añadir la ventana interna al escritorio
//            desktopPane.add(browser);
//
//            // 2. Mostrarla y darle un tamaño/posición por defecto
//            browser.setVisible(true);
//            browser.setSize(800, 600); // Ajusta el tamaño
//            browser.setLocation(50, 50); // Ajusta la posición inicial
//
//            // 3. Opcional: intentar seleccionarla para ponerla al frente
//            browser.setSelected(true);
//
//        } catch (SQLException e) {
//            LOGGER.severe(e.getMessage());
//        } catch (java.beans.PropertyVetoException ex) {
//            // Manejar la excepción de setSelected
//            LOGGER.severe("Error al seleccionar la ventana: " + ex.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        new MainApp().setVisible(true);
//    }
//}
    public class MainApp extends javax.swing.JFrame {

        private static final String CLASS_NAME = MainApp.class.getSimpleName();
        private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

        //private final String USER = "usr210215739";
        //private final String PASS = "pw210215739";
        private final String USER = "kevin";
        private final String PASS = "Mark4557";
        final private Database db;
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenuItem agregarSkillLevel;
        private javax.swing.JMenuItem agregarSkill;
        private javax.swing.JMenuItem agregarProjectoEmpleado;
        private javax.swing.JMenuItem agregarProjectMenuItem;
        private javax.swing.JMenuItem verProjects;
        private javax.swing.JDesktopPane desktopPane;
        private javax.swing.JMenu projectsMenu;
        private javax.swing.JMenuItem eliminarProyecto;
        private javax.swing.JMenu employeesMenu;
        private javax.swing.JMenu skillMenu;
        private javax.swing.JMenu jMenu1;
        private javax.swing.JMenuItem agregarDireccion;
        private javax.swing.JMenuItem eliminarSkillLevel;
        private javax.swing.JMenuItem agregarRoleMenu;
        private javax.swing.JMenuItem eliminarRoleMenu;
        private javax.swing.JMenuItem eliminarSkill;
        private javax.swing.JMenuItem verRoleMenu;
        private javax.swing.JMenuItem verEmpleadosSkills;
        private javax.swing.JMenuItem jMenuItem16;
        private javax.swing.JMenuItem eliminarDireccion;
        private javax.swing.JMenuItem verDirecciones;
        private javax.swing.JMenuItem verSkill;
        private javax.swing.JMenuItem jMenuItem5;
        private javax.swing.JMenuItem insertarFechaMenu;
        private javax.swing.JMenuItem eliminarFechasMenu;
        private javax.swing.JMenuItem verCalendarioMenu;
        private javax.swing.JMenuItem jMenuItem9;
        private javax.swing.JMenuBar menuBar;
        private javax.swing.JMenu menuCalendario;
        private javax.swing.JMenu menuRole;
        private javax.swing.JMenu menuDirecciones;
        private javax.swing.JMenuItem agregarEmployee;
        private javax.swing.JMenuItem eliminarProjectMenu;
        private javax.swing.JMenuItem eliminarHabilidad;
        private javax.swing.JMenuItem EliminarEmpleado;
        private javax.swing.JMenuItem verEmpleados;
        private javax.swing.JMenuItem verContacto;
        private javax.swing.JMenuItem verFechasMenu;
        /**
         * Creates new form MainApp
         */
        public MainApp() {
            //Abrir la conexión a la base de datos
            db = Database.getDatabase(USER, PASS);
            initComponents();
            this.setSize(800, 600);
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainApp().setVisible(true);
                }
            });
        }
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            desktopPane = new javax.swing.JDesktopPane();
            menuBar = new javax.swing.JMenuBar();
            employeesMenu = new javax.swing.JMenu();
            agregarEmployee = new javax.swing.JMenuItem();
            EliminarEmpleado = new javax.swing.JMenuItem();
            eliminarHabilidad = new javax.swing.JMenuItem();
            eliminarProyecto = new javax.swing.JMenuItem();
            projectsMenu = new javax.swing.JMenu();
            agregarProjectMenuItem = new javax.swing.JMenuItem();
            agregarProjectoEmpleado = new javax.swing.JMenuItem();
            eliminarProjectMenu = new javax.swing.JMenuItem();
            verProjects = new javax.swing.JMenuItem();
            menuDirecciones = new javax.swing.JMenu();
            agregarDireccion = new javax.swing.JMenuItem();
            eliminarDireccion = new javax.swing.JMenuItem();
            verDirecciones = new javax.swing.JMenuItem();
            eliminarSkillLevel = new javax.swing.JMenuItem();
            jMenuItem5 = new javax.swing.JMenuItem();
            menuCalendario = new javax.swing.JMenu();
            insertarFechaMenu = new javax.swing.JMenuItem();
            eliminarFechasMenu = new javax.swing.JMenuItem();
            verCalendarioMenu = new javax.swing.JMenuItem();
            jMenuItem9 = new javax.swing.JMenuItem();
            eliminarSkill = new javax.swing.JMenuItem();
            menuRole = new javax.swing.JMenu();
            agregarRoleMenu = new javax.swing.JMenuItem();
            eliminarRoleMenu = new javax.swing.JMenuItem();
            verRoleMenu = new javax.swing.JMenuItem();
            verEmpleadosSkills = new javax.swing.JMenuItem();
            jMenu1 = new javax.swing.JMenu();
            jMenuItem16 = new javax.swing.JMenuItem();
            verSkill = new javax.swing.JMenuItem();
            skillMenu = new javax.swing.JMenu();
            agregarSkill = new javax.swing.JMenuItem();
            agregarSkillLevel = new javax.swing.JMenuItem();
            verEmpleados = new JMenuItem();
            verContacto = new JMenuItem();
            verFechasMenu = new JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            employeesMenu.setText("Employees");

            agregarEmployee.setText("Agregar");
            agregarEmployee.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertarEmployee(evt);
                }
            });
            employeesMenu.add(agregarEmployee);

            EliminarEmpleado.setText("Eliminar");
            EliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteEmployee(evt);
                }
            });
            employeesMenu.add(EliminarEmpleado);

            eliminarHabilidad.setText("Eliminar habilidad");
            eliminarHabilidad.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteSkillEmployee(evt);
                }
            });
            employeesMenu.add(eliminarHabilidad);

            eliminarProyecto.setText("Eliminar asignacion de proyecto");
            eliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteEmployeeProject(evt);
                }
            });
            employeesMenu.add(eliminarProyecto);

            verEmpleados.setText("Ver employees");
            verEmpleados.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getEmployees(evt);
                }
            });
            employeesMenu.add(verEmpleados);

            verContacto.setText("Ver contactos");
            verContacto.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getEmployeesContact(evt);
                }
            });
            employeesMenu.add(verContacto);

            verEmpleadosSkills.setText("Ver employee skills");
            verEmpleadosSkills.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getEmployeeSkill(evt);
                }
            });

            employeesMenu.add(verEmpleadosSkills);

            menuBar.add(employeesMenu);

            projectsMenu.setText("Projects");

            agregarProjectMenuItem.setText("Agregar");
            agregarProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertProjects(evt);
                }
            });
            projectsMenu.add(agregarProjectMenuItem);
            
            agregarProjectoEmpleado.setText("Agregar proyecto a empleado");
            agregarProjectoEmpleado.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertProjectEmployee(evt);
                }
            });
            projectsMenu.add(agregarProjectoEmpleado);

            eliminarProjectMenu.setText("Eliminar");
            eliminarProjectMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteProject(evt);
                }
            });
            projectsMenu.add(eliminarProjectMenu);
            
            verProjects.setText("Ver projects");
            verProjects.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getProyectos(evt);
                }
            });
            projectsMenu.add(verProjects);

            verFechasMenu.setText("Fechas inicio/fin");
            verFechasMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getDatesProjects(evt);
                }
            });
            projectsMenu.add(verFechasMenu);

            menuBar.add(projectsMenu);

            menuDirecciones.setText("Direcciones");

            agregarDireccion.setText("Agregar");
            agregarDireccion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertAddresses(evt);
                }
            });
            menuDirecciones.add(agregarDireccion);

            eliminarDireccion.setText("Eliminar");
            eliminarDireccion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteAddresses(evt);
                }
            });
            menuDirecciones.add(eliminarDireccion);

            verDirecciones.setText("Ver direcciones");
            verDirecciones.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getAddresses(evt);
                }
            });
            menuDirecciones.add(verDirecciones);

            menuBar.add(menuDirecciones);

            menuCalendario.setText("Calendario");

            insertarFechaMenu.setText("Insertar");
            insertarFechaMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertDates(evt);
                }
            });
            menuCalendario.add(insertarFechaMenu);

            eliminarFechasMenu.setText("Eliminar");
            eliminarFechasMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteDates(evt);
                }
            });
            menuCalendario.add(eliminarFechasMenu);

            verCalendarioMenu.setText("Ver calendario");
            verCalendarioMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getDates(evt);
                }
            });
            menuCalendario.add(verCalendarioMenu);

            menuBar.add(menuCalendario);

            menuRole.setText("Roles");

            agregarRoleMenu.setText("Agregar");
            agregarRoleMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertRole(evt);
                }
            });
            menuRole.add(agregarRoleMenu);

            eliminarRoleMenu.setText("Eliminar");
            eliminarRoleMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //deleteRole(evt);
                }
            });
            menuRole.add(eliminarRoleMenu);

            verRoleMenu.setText("Ver roles");
            verRoleMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getRoles(evt);
                }
            });
            menuRole.add(verRoleMenu);

            menuBar.add(menuRole);
            
            skillMenu.setText("Skills");
            
            agregarSkill.setText("Agregar skill");
            agregarSkill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertSkill(evt);
                }
            });
            skillMenu.add(agregarSkill);
            
            agregarSkillLevel.setText("Agregar skill level");
            agregarSkillLevel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    insertSkillLevel(evt);
                }
            });
            skillMenu.add(agregarSkillLevel);

            eliminarSkillLevel.setText("Eliminar skill level");
            eliminarSkillLevel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteSkillLevel(evt);
                }
            });
            skillMenu.add(eliminarSkillLevel);

            eliminarSkill.setText("Eliminar skill");
            eliminarSkill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteSkills(evt);
                }
            });
            skillMenu.add(eliminarSkill);

            verSkill.setText("Ver skill");
            verSkill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getSkills(evt);
                }
            });
            skillMenu.add(verSkill);

            menuBar.add(skillMenu);

            setJMenuBar(menuBar);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    //METODOS

        private void insertarEmployee(java.awt.event.ActionEvent evt) {
            InsertEmployee emp = new InsertEmployee(this, db);
            emp.setVisible(true);
        }

        private void deleteEmployee(java.awt.event.ActionEvent evt) {
            DeleteEmployeeDialog emp = new DeleteEmployeeDialog(this,db);
            emp.setVisible(true);
//            final String sql = "SELECT cof_name, "
//                    + "sup_id, "
//                    + "price , "
//                    + "sales,"
//                    + "total FROM coffees ORDER BY cof_name";
//            try {
//                ResultSet rs = db.query(sql);
//
//                JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
//
//                modelo.addTableModelListener(new CoffeesTableListener(db));
//
//                TableBrowser browser = new TableBrowser("Cafés", modelo);
//
//                browser.setVisible(true);
//
//                this.desktopPane.add(browser);
//
//            } catch (SQLException ex) {
//                LOGGER.severe("Error: " + ex.getMessage());
//                LOGGER.severe("Codigo : " + ex.getErrorCode());
//            }
        }

        private void deleteSkillEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            DeleteEmployeeSkillDialog dlg = new DeleteEmployeeSkillDialog(this, db);
            dlg.setVisible(true);
        }

        private void deleteEmployeeProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
            DeleteEmployeeOnProjectDialog emp = new DeleteEmployeeOnProjectDialog(this,db);
            emp.setVisible(true);
        }

        private void getEmployees(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            final String sql = "SELECT e.first_name, e.last_name, e.date_of_birth, e.hire_date, e.salary, r.role_name FROM" +
                    "  employees e LEFT JOIN ref_roles r ON e.role_code = r.role_code ORDER BY e.employee_id";
            try {
                ResultSet rs = db.query(sql);

                JDBCTableAdapter modelo = new JDBCTableAdapter(rs);

                modelo.addTableModelListener(new CoffeesTableListener(db));

                TableBrowser browser = new TableBrowser("Employees", modelo);

                browser.setVisible(true);

                this.desktopPane.add(browser);

            } catch (SQLException ex) {
                LOGGER.severe("Error: " + ex.getMessage());
                LOGGER.severe("Codigo : " + ex.getErrorCode());
            }
        }

        private void getEmployeesContact(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
            final String sql = "SELECT first_name, last_name, email, phone_number FROM employees";
            try {
                ResultSet rs = db.query(sql);

                JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
                TableBrowser browser = new TableBrowser("Employee contacts", modelo);
                browser.setVisible(true);
                this.desktopPane.add(browser);

            } catch (SQLException ex) {
                LOGGER.severe("Error: " + ex.getMessage());
                LOGGER.severe("Codigo : " + ex.getErrorCode());

            }


        }

        private void insertProjects(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
            InsertProject pr=new InsertProject(this,db);
            pr.setVisible(true);
        }

        private void insertProjectEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
            InsertEmployeeOnProject pr=new InsertEmployeeOnProject(this,db);
            pr.setVisible(true);
        }

        private void deleteProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
            DeleteProjectDialog pr=new DeleteProjectDialog(this,db);
            pr.setVisible(true);
            }

    private void getProyectos(java.awt.event.ActionEvent evt) {
        final String sql = "SELECT project_name, project_status, project_budget, project_description FROM projects";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Projects", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void getDatesProjects(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        final String sql = "SELECT project_name, project_start_date, project_end_date FROM projects";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Dates Projects", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void insertDates(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        InsertCalendar ca = new InsertCalendar(this,db);
        ca.setVisible(true);
    }

    private void deleteDates(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DeleteCalendarDateDialog dialogo = new DeleteCalendarDateDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getDates(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        final String sql = "SELECT * FROM ref_calendar";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Dates", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void insertAddresses(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        InsertEmployeesAddresses dialogo = new InsertEmployeesAddresses(this, db);
        dialogo.setVisible(true);
    }

    private void deleteAddresses(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DeleteAddressDialog dialogo = new DeleteAddressDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getAddresses(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final String sql = "SELECT e.first_name, a.line_1, a.line_2, a.line_3, a.town_city, a.state_province, a.country_code FROM" +
                " employees e LEFT JOIN employee_addresses ea ON e.employee_id = ea.employee_id LEFT JOIN addresses a ON a.address_id= ea.address_id";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Addresses", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void insertRole(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        InsertRole dialogo = new InsertRole(this, db);
        dialogo.setVisible(true);
    }

//    private void deleteRole(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
//        DeleteRoleDialog dialogo = new DeleteRoleDialog(this, db);
//        dialogo.setVisible(true);
//    }

    private void getRoles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final String sql = "SELECT * FROM ref_roles";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Roles", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void insertSkill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        InsertSkills dialogo = new InsertSkills(this, db);
        dialogo.setVisible(true);
    }

    private void insertSkillLevel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        InsertSkillLevel dialogo = new InsertSkillLevel(this, db);
        dialogo.setVisible(true);
    }

    private void deleteSkills(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DeleteSkillDialog dialogo = new DeleteSkillDialog(this, db);
        dialogo.setVisible(true);
    }

    private void deleteSkillLevel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DeleteSkillLevelDialog dialogo = new DeleteSkillLevelDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getSkills(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final String sql = "SELECT * FROM ref_skills";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Skills", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void getSkillLevel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final String sql = "SELECT * FROM ref_skill_levels";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Skill levels", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

    private void getEmployeeSkill(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final String sql = "Select e.first_name, e.last_name, s.skill_name, s.skill_category, sl.skill_level_name, " +
                "sl.experience_required_years FROM employees e LEFT JOIN employee_skills es ON e.employee_id=es.employee_id " +
                "LEFT JOIN ref_skills s ON s.skill_code=es.skill_code LEFT JOIN ref_skill_levels sl ON " +
                "sl.skill_level_code=es.skill_level_code ORDER BY last_name DESC;";
        try {
            ResultSet rs = db.query(sql);

            JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
            TableBrowser browser = new TableBrowser("Skill levels", modelo);
            browser.setVisible(true);
            this.desktopPane.add(browser);

        } catch (SQLException ex) {
            LOGGER.severe("Error: " + ex.getMessage());
            LOGGER.severe("Codigo : " + ex.getErrorCode());

        }
    }

}

