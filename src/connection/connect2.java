/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author Familia
 */
import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class connect2 {
    public Database ComprobationDB() {
        Database db = null;
        
        File directory = new File("C:\\Users\\Familia\\Documents\\db");
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        
        try {
            File dbFile = new File("C:\\Users\\Familia\\Documents\\db\\db.accdb");
            if (dbFile.exists() && !dbFile.isDirectory()) {
                db = DatabaseBuilder.open(dbFile);
            } else {
                db = DatabaseBuilder.create(Database.FileFormat.V2007, dbFile);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Can't create or open file \"testDB.accdb\". Check if it permitted by security settings of path/file.\nMore info:\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            if (!db.getTableNames().contains("DB")) {
                Table tblNew = new TableBuilder("DB")
                        .addColumn(new ColumnBuilder("id", DataType.LONG)
                                .setAutoNumber(true))
                        .addColumn(new ColumnBuilder("name", DataType.TEXT))
                        .addColumn(new ColumnBuilder("age", DataType.INT))
                        .addIndex(new IndexBuilder(IndexBuilder.PRIMARY_KEY_NAME)
                                .addColumns("id").setPrimaryKey())
                        .toTable(db);

                // Fill table by data
                tblNew.addRow(Column.AUTO_NUMBER, "John", 27);
                tblNew.addRow(Column.AUTO_NUMBER, "Peter", 43);
                tblNew.addRow(Column.AUTO_NUMBER, "Maycon", 21);
            }
        } catch (Exception e) {
        }
        return null;
    }

    static Connection conexion;

    public Connection getConnection() {

        try {
            String routeFile = "C:\\Users\\Familia\\Documents\\db\\db.accdb";
            String Url = "jdbc:ucanaccess://" + routeFile;
            conexion = DriverManager.getConnection(Url);

        } catch (Exception e) {
        }

        return conexion;
    }

    public static void main(String[] args) throws SQLException {
        connect2 acc = new connect2();
        acc.ComprobationDB();
        if (acc.getConnection() != null) {
            JOptionPane.showMessageDialog(null, "Conectado");
            String query = "select name from DB";
            PreparedStatement pst = conexion.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error Coneccion");
        }
    }
}
