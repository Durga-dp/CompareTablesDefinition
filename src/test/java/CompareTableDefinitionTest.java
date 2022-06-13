import org.junit.Assert;
import org.junit.Test;

public class CompareTableDefinitionTest {
    CompareTableDefinition compareTableDefinition;

    @Test
    public void testCompareTablesInDatabases(){
        String databaseConnectionUrl1="jdbc:postgresql://localhost:5432/postgres?user=mani&password=abc123";
        String databaseConnectionUrl2="jdbc:postgresql://localhost:5432/postgres?user=mani&password=abc123";
        String table1="em";
        String table2="em";
        compareTableDefinition=new CompareTableDefinition();

        Assert.assertEquals(true,compareTableDefinition.areTablesDefinitionSame(databaseConnectionUrl1,databaseConnectionUrl2,table1,table2));
    }
}
