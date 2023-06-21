public class Application {
    public static void main(String[]args) throws SQLException{
        final String user= "postgres";
        final String password= "1234";
        final String url= "jdbc:postgresql://localhost:5432/newbase";
        try (
            final Connection connection= DriverManager.getConnection(url,user,password);
            PreparedStatement statement= connection.prepareStatement(""+
                    "SELECT* FROM employee WHERE id=(?)")){
                statement.setInt(1,6);
                final ResultSet resultSet=statement.executeQuery();
                if (resultSet.next()){
                    String name="Name:"+ resultSet.getString("first_name");
                    String surname="Surname:"+ resultSet.getString("last_name");
                    String gender="Gender:"+ resultSet.getString(4);
                    int age=resultSet.getInt(6);
                    System.out.println(name);
                    System.out.println(surname);
                    System.out.println(gender);
                    System.out.println("Age"+age);
                }
            }
        }
    }
    }

}
