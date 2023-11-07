package View;

import CustomGUI.PaletteTable;
import Model.Palette;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;

public class PaletteConfiguration extends JPanel {
    private Palette pal;
    private PaletteTable palTable;
    private TableCellEditor readOnlyEditor = new TableCellEditor() {

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return false;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return false;
        }

        @Override
        public void cancelCellEditing() {

        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {

        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return null;
        }
    };

    public PaletteConfiguration() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        pal = new Palette();
        palTable = new PaletteTable();
        palTable.setDefaultEditor(Object.class, readOnlyEditor);

        addDefaultColorTargets();
        add(palTable);
    }

    public void addDefaultColorTargets() {
        ArrayList<int[]> colourTargets = pal.getColourTargets();
        DefaultTableModel t = palTable.getTableModel();
        Color convertedColor;

        // The colorTarget array is converted to Color datatype and then added to the table.
        for (int[] colourTarget : colourTargets) {
            convertedColor = intToColor(colourTarget);
            Object[] data = {colourTarget[0], convertedColor};
            t.addRow(data);
            changeCellBackgroundColor();
        }
    }

    public void changeCellBackgroundColor() {
        palTable.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    cell.setBackground((Color) value);
                    setText("");

                return cell;
            }
        });
    }

    public void addBlankRow() {
        Object[] blankData = {null, null};
        DefaultTableModel t = palTable.getTableModel();

        t.addRow(blankData);
    }

    public Color intToColor(int[] dirtyColourTarget) {
        int R, G, B, A;

        A = dirtyColourTarget[1];
        R = dirtyColourTarget[2];
        G = dirtyColourTarget[3];
        B = dirtyColourTarget[4];

        return new Color (R, G, B, A);
    }
}
