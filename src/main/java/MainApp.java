import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel; 

    public class MainApp extends javax.swing.JFrame {

        private static final String CLASS_NAME = MainApp.class.getSimpleName();
        private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

        private final String USER = "kevin";
        private final String PASS = "Mark4557";
        final private Database db;

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
        private javax.swing.JMenuItem agregarDireccion;
        private javax.swing.JMenuItem eliminarSkillLevel;
        private javax.swing.JMenuItem agregarRoleMenu;
        private javax.swing.JMenuItem eliminarRoleMenu;
        private javax.swing.JMenuItem eliminarSkill;
        private javax.swing.JMenuItem verRoleMenu;
        private javax.swing.JMenuItem verEmpleadosSkills;
        private javax.swing.JMenuItem eliminarDireccion;
        private javax.swing.JMenuItem verDirecciones;
        private javax.swing.JMenuItem verSkill;
        private javax.swing.JMenuItem insertarFechaMenu;
        private javax.swing.JMenuItem eliminarFechasMenu;
        private javax.swing.JMenuItem verCalendarioMenu;
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
        private javax.swing.JMenuItem verSkillLevels;
        private javax.swing.JMenuItem updateSkillMenu;
        private javax.swing.JMenu menuInformes;
        private javax.swing.JMenuItem informe1MenuItem;
        private javax.swing.JMenuItem informe2MenuItem;
        private javax.swing.JMenuItem informe3MenuItem;
        private JLabel backgroundLabel;
        /**
         * Creates new form MainApp
         */
        public MainApp() {
            //Abrir la conexión a la base de datos
            db = Database.getDatabase(USER, PASS);
            initComponents();
            this.setSize(800, 600);
            agregarImagenFondo();
            
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
            menuCalendario = new javax.swing.JMenu();
            insertarFechaMenu = new javax.swing.JMenuItem();
            eliminarFechasMenu = new javax.swing.JMenuItem();
            verCalendarioMenu = new javax.swing.JMenuItem();
            eliminarSkill = new javax.swing.JMenuItem();
            menuRole = new javax.swing.JMenu();
            agregarRoleMenu = new javax.swing.JMenuItem();
            eliminarRoleMenu = new javax.swing.JMenuItem();
            verRoleMenu = new javax.swing.JMenuItem();
            verEmpleadosSkills = new javax.swing.JMenuItem();
            verSkill = new javax.swing.JMenuItem();
            skillMenu = new javax.swing.JMenu();
            agregarSkill = new javax.swing.JMenuItem();
            agregarSkillLevel = new javax.swing.JMenuItem();
            verEmpleados = new JMenuItem();
            verContacto = new JMenuItem();
            verFechasMenu = new JMenuItem();
            verSkillLevels = new JMenuItem();
            updateSkillMenu = new JMenuItem();

            setTitle("Employees working at house");
            setResizable(false);
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
                    deleteRole(evt);
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

            updateSkillMenu.setText("Actualizar skill");
            updateSkillMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    updateSkill(evt);
                }
            });
            skillMenu.add(updateSkillMenu);

            verSkill.setText("Ver skill");
            verSkill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getSkills(evt);
                }
            });
            skillMenu.add(verSkill);

            verSkillLevels.setText("Ver skill levels");
            verSkillLevels.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    getSkillLevel(evt);
                }
            });
            skillMenu.add(verSkillLevels);

            menuBar.add(skillMenu);

            menuInformes = new javax.swing.JMenu();
            menuInformes.setText("Informes");

            informe1MenuItem = new javax.swing.JMenuItem();
            informe1MenuItem.setText("Informe 1: Empleados en Proyectos");
            informe1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            generarInforme1(evt);
                }
            });
            menuInformes.add(informe1MenuItem);

            informe2MenuItem = new javax.swing.JMenuItem();
            informe2MenuItem.setText("Informe 2: Skills por Empleado");
            informe2MenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarInforme2(evt);
                }
                });
            menuInformes.add(informe2MenuItem);

            informe3MenuItem = new javax.swing.JMenuItem();
            informe3MenuItem.setText("Informe 3: Proyectos y Presupuestos");
            informe3MenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    generarInforme3(evt);
                }
            });
            menuInformes.add(informe3MenuItem);

            menuBar.add(menuInformes);

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

        }

        private void deleteSkillEmployee(java.awt.event.ActionEvent evt) {
            DeleteEmployeeSkillDialog dlg = new DeleteEmployeeSkillDialog(this, db);
            dlg.setVisible(true);
        }

        private void deleteEmployeeProject(java.awt.event.ActionEvent evt) {
            DeleteEmployeeOnProjectDialog emp = new DeleteEmployeeOnProjectDialog(this,db);
            emp.setVisible(true);
        }

        private void getEmployees(java.awt.event.ActionEvent evt) {
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

        private void getEmployeesContact(java.awt.event.ActionEvent evt) {
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

        private void insertProjects(java.awt.event.ActionEvent evt) {
            InsertProject pr=new InsertProject(this,db);
            pr.setVisible(true);
        }

        private void insertProjectEmployee(java.awt.event.ActionEvent evt) {
            InsertEmployeeOnProject pr=new InsertEmployeeOnProject(this,db);
            pr.setVisible(true);
        }

        private void deleteProject(java.awt.event.ActionEvent evt) {
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

    private void getDatesProjects(java.awt.event.ActionEvent evt) {
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

    private void insertDates(java.awt.event.ActionEvent evt) {
        InsertCalendar ca = new InsertCalendar(this,db);
        ca.setVisible(true);
    }

    private void deleteDates(java.awt.event.ActionEvent evt) {
        DeleteCalendarDateDialog dialogo = new DeleteCalendarDateDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getDates(java.awt.event.ActionEvent evt) {
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

    private void insertAddresses(java.awt.event.ActionEvent evt) {
        InsertEmployeesAddresses dialogo = new InsertEmployeesAddresses(this, db);
        dialogo.setVisible(true);
    }

    private void deleteAddresses(java.awt.event.ActionEvent evt) {
        DeleteAddressDialog dialogo = new DeleteAddressDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getAddresses(java.awt.event.ActionEvent evt) {
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

    private void insertRole(java.awt.event.ActionEvent evt) {
        InsertRole dialogo = new InsertRole(this, db);
        dialogo.setVisible(true);
    }

    private void deleteRole(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        DeleteRolesDialog dialogo = new DeleteRolesDialog(this, db);
        dialogo.setVisible(true);
    }

    private void getRoles(java.awt.event.ActionEvent evt) {
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

    private void insertSkill(java.awt.event.ActionEvent evt) {
        InsertSkills dialogo = new InsertSkills(this, db);
        dialogo.setVisible(true);
    }

    private void insertSkillLevel(java.awt.event.ActionEvent evt) {
        InsertSkillLevel dialogo = new InsertSkillLevel(this, db);
        dialogo.setVisible(true);
    }

    private void deleteSkills(java.awt.event.ActionEvent evt) {
        DeleteSkillDialog dialogo = new DeleteSkillDialog(this, db);
        dialogo.setVisible(true);
    }

    private void deleteSkillLevel(java.awt.event.ActionEvent evt) {
        DeleteSkillLevelDialog dialogo = new DeleteSkillLevelDialog(this, db);
        dialogo.setVisible(true);
    }

    private void updateSkill(java.awt.event.ActionEvent evt) {
            UpdateSkill dialogo = new UpdateSkill(this, db);
            dialogo.setVisible(true);
        }

    private void getSkills(java.awt.event.ActionEvent evt) {
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

    private void getSkillLevel(java.awt.event.ActionEvent evt) {
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

    private void getEmployeeSkill(java.awt.event.ActionEvent evt) {
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
        private void generarInforme1(java.awt.event.ActionEvent evt) {
    final String sql = "SELECT " +
            "p.project_name AS \"Proyecto\", " +
            "e.first_name || ' ' || e.last_name AS \"Empleado\", " +
            "r.role_name AS \"Rol\", " +
            "p.project_status AS \"Estado\" " +
            "FROM employee_on_projects eop " +
            "LEFT JOIN employees e ON eop.employee_id = e.employee_id " +
            "LEFT JOIN projects p ON eop.project_id = p.project_id " +
            "LEFT JOIN ref_roles r ON e.role_code = r.role_code " +
            "ORDER BY p.project_name, e.last_name";
    
    try {
        ResultSet rs = db.query(sql);
        JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
        TableBrowser browser = new TableBrowser("Informe 1: Empleados en Proyectos", modelo);
        browser.setVisible(true);
        this.desktopPane.add(browser);
    } catch (SQLException ex) {
        LOGGER.severe("Error: " + ex.getMessage());
        LOGGER.severe("Código: " + ex.getErrorCode());
        JOptionPane.showMessageDialog(this, 
            "Error al generar informe: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

private void generarInforme2(java.awt.event.ActionEvent evt) {
    final String sql = "SELECT " +
            "e.first_name || ' ' || e.last_name AS \"Empleado\", " +
            "COUNT(es.skill_code) AS \"Total Skills\", " +
            "STRING_AGG(s.skill_name, ', ') AS \"Skills\", " +
            "ROUND(AVG(sl.experience_required_years), 1) AS \"Experiencia Promedio (años)\" " +
            "FROM employees e " +
            "LEFT JOIN employee_skills es ON e.employee_id = es.employee_id " +
            "LEFT JOIN ref_skills s ON es.skill_code = s.skill_code " +
            "LEFT JOIN ref_skill_levels sl ON es.skill_level_code = sl.skill_level_code " +
            "GROUP BY e.employee_id, e.first_name, e.last_name " +
            "ORDER BY COUNT(es.skill_code) DESC";
    
    try {
        ResultSet rs = db.query(sql);
        JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
        TableBrowser browser = new TableBrowser("Informe 2: Resumen de Skills por Empleado", modelo);
        browser.setVisible(true);
        this.desktopPane.add(browser);
    } catch (SQLException ex) {
        LOGGER.severe("Error: " + ex.getMessage());
        LOGGER.severe("Código: " + ex.getErrorCode());
        JOptionPane.showMessageDialog(this, 
            "Error al generar informe: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

private void generarInforme3(java.awt.event.ActionEvent evt) {
    final String sql = "SELECT " +
            "p.project_name AS \"Proyecto\", " +
            "p.project_status AS \"Estado\", " +
            "p.project_budget AS \"Presupuesto\", " +
            "COUNT(eop.employee_id) AS \"# Empleados\", " +
            "p.project_start_date AS \"Inicio\", " +
            "p.project_end_date AS \"Fin\" " +
            "FROM projects p " +
            "LEFT JOIN employee_on_projects eop ON p.project_id = eop.project_id " +
            "GROUP BY p.project_id, p.project_name, p.project_status, p.project_budget, " +
            "p.project_start_date, p.project_end_date " +
            "ORDER BY p.project_budget DESC";
    
    try {
        ResultSet rs = db.query(sql);
        JDBCTableAdapter modelo = new JDBCTableAdapter(rs);
        TableBrowser browser = new TableBrowser("Informe 3: Proyectos, Presupuestos y Equipos", modelo);
        browser.setVisible(true);
        this.desktopPane.add(browser);
    } catch (SQLException ex) {
        LOGGER.severe("Error: " + ex.getMessage());
        LOGGER.severe("Código: " + ex.getErrorCode());
        JOptionPane.showMessageDialog(this, 
            "Error al generar informe: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
        private void agregarImagenFondo() {
    try {
        
        URL url = new URL("https://i.imgur.com/5Nv6Oy9.gif");
        ImageIcon icon = new ImageIcon(url);
        
        
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        
        backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        
        desktopPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        
    } catch (Exception e) {
        LOGGER.severe("No se pudo cargar la imagen: " + e.getMessage());
    }
}

}

