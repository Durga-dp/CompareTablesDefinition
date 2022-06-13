import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMetaData {

    /**
     * Compare given list of columns
     * @param t1
     * @param t2
     * @return
     */
    public  boolean compareColumns(List<Column> t1, List<Column> t2) {
        if (t1.size() == t2.size()) {
            for (Column colum : t1) {
                if (!t2.remove(colum)) {
                    System.out.println("No matching " + colum);
                    return false;
                }
            }
        } else {
            return false;
        }
        if(t2.isEmpty())
            return true;
        return false;
    }

    /**
     * Get list of columns for given table
     * @param postgresUrl
     * @param table
     * @return
     */
    public  List<Column> getColumnList(String postgresUrl, String table) {
        List<Column> columnList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(postgresUrl);
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet columns = databaseMetaData.getColumns(null, null, table, null);
            while (columns.next()) {
                Column colum = new Column();
                colum.setCol_name(columns.getString("COLUMN_NAME"));
                colum.setCol_size(String.valueOf(columns.getInt("COLUMN_SIZE")));
                colum.setType_name(columns.getString("TYPE_NAME"));
                columnList.add(colum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnList;
    }
}
