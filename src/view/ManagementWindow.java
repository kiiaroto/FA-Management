/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Rank;
import model.User;

/**
 *
 * @author SR
 */
public class ManagementWindow extends javax.swing.JFrame {

    /**
     * Creates new form Management
     */
    public ManagementWindow(User user) throws SQLException {
        UserDao userDao = new UserDao();
        List<User> userList = userDao.findAll();
        initComponents(userList);
    }

    private void initComponents(List<User> userList) {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Rank", "Email", "Name"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });

        tableModel = (DefaultTableModel) jTable2.getModel();

        for (User u : userList) {
            tableModel.addRow(new Object[]{u.getId(), Rank.getValues().get(u.getRank()), u.getEmail(), u.getName()});
        }
        TableColumn col = jTable2.getColumnModel().getColumn(0);
        col.setMaxWidth(32);

        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            System.out.println("Double clicked");
            int row = jTable2.getSelectedRow();
            User user = new User(
                    Integer.parseInt(tableModel.getValueAt(row, 0).toString()),
                    Rank.getKey(tableModel.getValueAt(row, 1).toString()),
                    tableModel.getValueAt(row, 2).toString(),
                    tableModel.getValueAt(row, 3).toString(),
                    null);
            System.out.println(user);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private DefaultTableModel tableModel;
    // End of variables declaration                   
}
