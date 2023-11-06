package View;

import CustomGUI.PaletteTable;
import Model.Palette;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PaletteConfiguration extends JPanel {
    Palette pal;
    PaletteTable palTable;

    public PaletteConfiguration() {
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        setBorder(blackBorder);
        setLayout(new GridBagLayout());
        pal = new Palette();
        palTable = new PaletteTable();
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
        }
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
