package DB;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbc_training";
        String userName = "root";
        String password = "Pa$$w0rd";

        // connection string --> jdbc:mysql:// + dpIP + dpPort + dpName

        try {
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(url, userName, password);
            Student st1 = new Student(8,"Mai");

            String query = "insert into student(id, name) values(" +st1.id + "," + "'" +st1.name + "'" +")";
            String query2 = "SELECT * FROM jdbc_training.student;";
            Statement state = connect.createStatement();
            ResultSet resultTable = state.executeQuery(query2);
            while (resultTable.next()){
                int id = resultTable.getInt("id");
                String name = resultTable.getString("name");
                System.out.println(id + "," + name);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
