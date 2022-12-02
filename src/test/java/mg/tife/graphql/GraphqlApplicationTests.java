package mg.tife.graphql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraphqlApplicationTests {

	@Test
	void contextLoads() {
	}
	
		@Test
		public void testDatabaseNoMem() throws SQLException {
		    
		}
		@Test
		public void testDatabaseMem() throws SQLException {
		    
		}

		private void testDatabase(String url) throws SQLException {
		    Connection connection= DriverManager.getConnection(url);
		    Statement s=connection.createStatement();
		    try {
		    s.execute("DROP TABLE PERSON");
		    } catch(SQLException sqle) {
		        System.out.println("Table not found, not dropping");
		    }
		    s.execute("CREATE TABLE PERSON (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
		    PreparedStatement ps=connection.prepareStatement("select * from PERSON");
		    ResultSet r=ps.executeQuery();
		    if(r.next()) {
		        System.out.println("data?");
		    }
		    r.close();
		    ps.close();
		    s.close();
		    connection.close();
		}

}
