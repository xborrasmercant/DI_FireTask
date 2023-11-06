package CustomGUI;

import Model.Palette;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PaletteTable extends JTable {
    DefaultTableModel tModel = new DefaultTableModel();

    public PaletteTable() {
        this.createTableStructure();
    }

    public void createTableStructure() {
        this.setModel(tModel);

        tModel.addColumn("Temp");
        tModel.addColumn("Color");
    }

    public DefaultTableModel getTableModel() {
        return tModel;
    }
    public void setTableModel(DefaultTableModel tModel) {
        this.tModel = tModel;
    }
}
