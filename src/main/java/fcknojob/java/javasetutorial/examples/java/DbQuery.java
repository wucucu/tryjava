package fcknojob.java.javasetutorial.examples.java;

import java.sql.*;

class DbConnector {
    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String database = "addressBook";
        String userName = "local";
        String password = "root";
        return DriverManager.getConnection(url + database, userName, password);
    }
}

public class DbQuery {
    public static void main(String[] args) {
        try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM contact;")) {
            System.out.println("ID \tfName \tlName \temail \t\t\tphoneNo");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t"
                + resultSet.getString("firstName") + "\t"
                + resultSet.getString("lastName") + "\t"
                + resultSet.getString("email") + "\t"
                + resultSet.getString("phoneNo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class DbQuery4 {
    public static void main(String[] args) {
        try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT firstName, email FROM contact WHERE firstName=\"Michael\";")) {
            int numOfColumns = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= numOfColumns; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println("");
            while (resultSet.next()) {
                for (int i = 1; i <= numOfColumns; i++) {
                    System.out.print(resultSet.getObject(i) + "\t");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class ResultSetPrinter {
    public static void print(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numOfColumns = rsmd.getColumnCount();
        for (int i = 1; i <= numOfColumns; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= numOfColumns; i++) {
                System.out.print(rs.getObject(i) + "\t");
            }
            System.out.println();
        }
        rs.beforeFirst();
    }
}

class DbUpdate {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnector.connectToDb();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contact WHERE firstName=\"Michael\"")) {
            System.out.println("Before the update");
            ResultSetPrinter.print(resultSet);
            resultSet.absolute(1);
            resultSet.updateString("phoneNo", "+919976543210");
            resultSet.updateRow();
            System.out.println("After the update");
            ResultSetPrinter.print(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class DbInsert {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")) {
            System.out.println("Before the insert");
            ResultSetPrinter.print(resultSet);
            resultSet.moveToInsertRow();
            resultSet.updateString("firstName", "John");
            resultSet.updateString("lastName","K.");
            resultSet.updateString("email", "john@abc.om");
            resultSet.updateString("phoneNo", "+19753186420");
            resultSet.insertRow();
            System.out.println("After the insert");
            ResultSetPrinter.print(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

class DbDelete {
    public static void main(String[] args) throws SQLException {
        String sqlString = "SELECT * FROM contact WHERE firstName=\"John\"";
        try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet1 = statement.executeQuery(sqlString)) {
            System.out.println("Before the deletion");
            ResultSetPrinter.print(resultSet1);
            while (resultSet1.next()) {
                resultSet1.deleteRow();
            }
            resultSet1.close();

            try (ResultSet resultSet2 = statement.executeQuery(sqlString)) {
                System.out.println("After the deletion");
                ResultSetPrinter.print(resultSet2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
