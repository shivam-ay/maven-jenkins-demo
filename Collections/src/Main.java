import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		EmployeeImpl emp = new EmployeeImpl();
		while(choice!=3)
		{
			System.out.println("1. Add Employee");
			System.out.println("2. Display Employee");
			System.out.println("3. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter name: ");
					String name = sc.next();
					System.out.println("Enter department name: ");
					String department = sc.next();
					
					emp.addEmployees(new Employee(UUID.randomUUID().toString(),name,department));
					break;
				}
				case 2:
				{
					List<Employee> list = emp.showEmployees();
					for(int i = 0; i<list.size();i++)
					{
						System.out.println("list.get()");
						System.out.println(list.get(i));
						System.out.println(list.get(i).getId());
						System.out.println();
					}
					
					Iterator<Employee> iter = list.iterator();
					while(iter.hasNext())
					{
						System.out.println("Iterator");
						System.out.println(iter.next());
						System.out.println();
					}
					
					for(Employee e:emp.showEmployees())
					{
						System.out.println("For Each Loop");
						System.out.println(e);
						System.out.println(e.getDepartment());
						System.out.println();
					}
					break;
				}
			}
		}
	}
}
