import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl
{
	List<Employee> employee = new ArrayList<>();
	
	public void addEmployees(Employee emp)
	{
		employee.add(emp);
	}
	
	public List<Employee> showEmployees()
	{
		return employee;
	}
}
