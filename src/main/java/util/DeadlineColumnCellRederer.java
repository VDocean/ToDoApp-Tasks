/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Tasks;

/**
 *
 * @author barbara
 */
public class DeadlineColumnCellRederer extends DefaultTableCellRenderer{
    
    @Override
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        //Cells are by default rendered as a JLabel.
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        label.setHorizontalAlignment( JLabel.CENTER );

        //Get the status for the current row.
        TaskTableModel tasksModel = (TaskTableModel) table.getModel();
        Tasks task = tasksModel.getTasks().get(row);

        if (task.getDeadline().equals(new Date())) {// se a data da deadline eh igual a atual
            label.setBackground(Color.YELLOW);
        } else {
            if (task.getDeadline().after(new Date())) {
                label.setBackground(Color.GREEN);
            } else {
                label.setBackground(Color.RED); //se o deadline estiver antes da data atual, ou seja, esta atrasada
            }
        }
        //Return the JLabel which renders the cell.
        return label;
    }
    
}
