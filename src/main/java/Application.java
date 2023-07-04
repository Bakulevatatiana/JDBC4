import model.City;
import model.Employee;
import service.EmployeeDao;
import service.EmployeeDaoImpl;

public class Application {
    public static void main(String[] args){
        EmployeeDao employeeDao= new EmployeeDaoImpl();
        System.out.println(employeeDao.getAllEmployee());
        Employee employee= new Employee(1,"Анна","Симонова","m",67, new City(1,"Oмск"));
        employeeDao.getAllEmployee().forEach(System.out::println);
        employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());

        System.out.println();
        employee.setLast_name("Петров");
        employeeDao.updateEmployee(13,employee);
        System.out.println(employeeDao.getById(13));
        employeeDao.deleteEmployee(1);
        System.out.println();
        System.out.println(employeeDao.getAllEmployee());
    }
}
