package jdbc;

public class Application1 {
    public static void main(String[] args){
        Employee employee= new EmployeeDaoImpl(7, "Anna","Log","f",37,3);
        employeeDao.getAllEmployee().forEach(System.out::println);
        Integer employeeId=employeeDao.add(employee);
        System.out.println(employeeDao.getAllEmployee());
        System.out.println();
        employeeDao.updateEmployee(employee,employeeId);
        employeeDao.deleteEmployee(employeeDao.getById(employeeId));
        System.out.println(employeeDao.getById(4));
    }
}
