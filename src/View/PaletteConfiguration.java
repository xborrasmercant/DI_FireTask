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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

public class PaletteConfiguration extends JPanel {
    private Palette pal;
    private PaletteTable palTable;
    private DefaultTableModel t;
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
        t = palTable.getTableModel();
        addDefaultColorTargets();
        addCellBackgroundRenderer();
        palTable.setDefaultEditor(Color.class, readOnlyEditor);
        palTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = palTable.rowAtPoint(e.getPoint());
                int column = palTable.columnAtPoint(e.getPoint());
                Color newColour;
                printCellInfo(row, column);


                if (column == 0) {
                    // No JColorChooser is shown up.
                }
                else {
                    newColour = JColorChooser.showDialog(null, "Select a color", (Color) t.getValueAt(row, column));

                    if (newColour != null) {
                        t.setValueAt(newColour, row, 1);
                        System.out.println(newColour);
                        pal.setColourTarget(row, newColour.getAlpha(), newColour.getRed(), newColour.getGreen(), newColour.getBlue());
                        System.out.println(newColour.getAlpha() + " " + newColour.getRed() + " " + newColour.getGreen() + " " + newColour.getBlue());
                        pal.calc();
                    }
                }
            }
        });

        add(palTable);
    }

    public void addDefaultColorTargets() {
        ArrayList<int[]> colourTargets = pal.getColourTargets();
        Color convertedColor;

        // The colorTarget array is converted to Color datatype and then added to the table.
        for (int[] colourTarget : colourTargets) {
            convertedColor = intToColor(colourTarget);
            Object[] data = {colourTarget[0], convertedColor};
            t.addRow(data);
        }
    }

    public void addCellBackgroundRenderer() {
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

    public void printCellInfo(int row, int col) {
        if (col == 0) {
            System.out.println("Temp: (" + row + "," + col +")");
        }
        else {
            System.out.println("Colour: (" + row + "," + col +")");
        }
    }

    public void addTempsToPal() {
        for (int i = 0; i < palTable.getSize().height; i++) {
            pal.setColourTargetTemperature(i, (int) palTable.getValueAt(i, 0));
            System.out.println(i);
        }
    }

    public Palette getPalette() {
        return pal;
    }

    public void setPalette(Palette pal) {
        this.pal = pal;
    }

    public PaletteTable getPaletteTable() {
        return palTable;
    }

    public void setPaletteTable(PaletteTable palTable) {
        this.palTable = palTable;
    }

    public TableCellEditor getReadOnlyEditor() {
        return readOnlyEditor;
    }

    public void setReadOnlyEditor(TableCellEditor readOnlyEditor) {
        this.readOnlyEditor = readOnlyEditor;
    }
}
