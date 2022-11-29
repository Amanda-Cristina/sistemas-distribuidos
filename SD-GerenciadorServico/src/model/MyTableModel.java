/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinha
 */
public class MyTableModel extends DefaultTableModel {
    
   public MyTableModel(Object columnNames[], int rowCount) {
        super(columnNames,rowCount );
      }
    
    @Override
    public String getColumnName(int column) {
        return String.valueOf(column);
    }
    @Override
    public Object getValueAt(int row, int column) {
        Vector rowVector = (Vector)dataVector.elementAt(row);
        if (rowVector.isEmpty()) {
            return null;
        }
        return super.getValueAt(row, column);
    }

    
}