package service;

import config.ConnectionConfig;
import model.City;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {



        @Override
        public void add(Employee employee){
            try(
                    PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                            "INSERT INTO employee(first_name, last_name,gender,age,city_id)VALUES((?),(?),(?),(?),(?))");){
                statement.setString(1,employee.getFirst_name());
                statement.setString(2,employee.getLast_name());
                statement.setString(3,employee.getGender());
                statement.setInt(4,employee.getAge());
                statement.setInt(5,employee.getCity().getCity_id());
                statement.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public Employee getById(int id) {
            Employee employee = new Employee();

            try (PreparedStatement statement = ConnectionConfig.getConnection().prepareStatement(
                    "SELECT * FROM employee INNER JOIN city" + "ON employee.city_id=city.city_id WHERE id=(?)")) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    employee.setId(resultSet.getInt(1));
                    employee.setFirst_name(resultSet.getString("first_name"));
                    employee.setLast_name(resultSet.getString("last_name"));
                    employee.setGender(resultSet.getString("gender"));
                    employee.setFirst_name(resultSet.getString("first_name"));

                    employee.setAge(resultSet.getInt(5));
                    employee.setCity(new City(resultSet.getInt("city_id"), resultSet.getString("city_name"
                    )));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employee;
        }
                @Override
                public List<Employee> getAllEmployee(){
                    List<Employee> employees=new ArrayList<>();
                    try(PreparedStatement statement=ConnectionConfig.getConnection().prepareStatement(
                            "SELECT * FROM employee INNER JOIN city"+"ON employee.city_id=city.city_id" ))
                    {

                            ResultSet resultSet=statement.executeQuery();
                    while (resultSet.next()){
                        int id= Integer.parseInt(resultSet.getString("id"));
                        String firstName=resultSet.getString("first_name");
                        String lastName=resultSet.getString("last_name");
                        String gender=resultSet.getString("gender");
                        int age= Integer.parseInt(resultSet.getString("age"));
                        City city= new City(resultSet.getInt("city_id"),
                                resultSet.getString("city_name"));
                        employees.add(new Employee(id, firstName,lastName,gender,age,city));}

                }catch (SQLException e) {
                    e.printStackTrace();
                }return employees;

            }
        @Override
        public void updateEmployee(int id, Employee employee){
            try(
                    PreparedStatement statement= ConnectionConfig.getConnection().prepareStatement(
                            "UPDATE employee SET first_name=(?), last_name=(?),gender=(?),age=(?),city_id=(?) WHERE id=(?)")){
                statement.setString(1,employee.getFirst_name());
                statement.setString(2,employee.getLast_name());
                statement.setString(3,employee.getGender());
                statement.setInt(4,employee.getAge());
                statement.setInt(5,employee.getCity().getCity_id());
                statement.setInt(6,id);
                statement.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
        @Override
        public void deleteEmployee(int id){
            try(
                    PreparedStatement statement= ConnectionConfig.getConnection().prepareStatement(
                            "DELETE FROM employee  WHERE id=(?)")){
                statement.setInt(1,id);
                statement.executeUpdate();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
}

