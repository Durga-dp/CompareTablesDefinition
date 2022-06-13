import java.util.List;

public class CompareTableDefinition {

    public  boolean areTablesDefinitionSame(String databaseConnectionUrl1, String databaseConnectionUrl2, String tableName1, String tableName2) {
        JdbcMetaData jdbcMetaData = new JdbcMetaData();
        List<Column> columnListOfTable1 = jdbcMetaData.getColumnList(databaseConnectionUrl1, tableName1);
        List<Column> columnListOfTable2 = jdbcMetaData.getColumnList(databaseConnectionUrl2, tableName2);
        boolean isMatched=jdbcMetaData.compareColumns(columnListOfTable1, columnListOfTable2);
        return isMatched;
    }
}
