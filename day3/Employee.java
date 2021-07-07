package wiley.programs.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class User {
	String id;
	String name;

	User(String id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class Employee extends User implements Comparable {
	Employee(String id, String name, Address address, Project project, double salary) {
		super(id, name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}

	Address address;
	Project project;
	double salary;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Project p = new Project(1, "p1", 5);
		Project p1 = new Project(2, "p2", 1000);
		List<User> users = new ArrayList();
		users.add(new User("1", "Jatin"));
		users.add(new User("2", "Jatin"));
		users.add(new Employee("3", "Jatin3", new Address("JMU3", "1800073"), p1, 1000));
		users.add(new Employee("4", "Jatin4", new Address("JMU4", "1800074"), p, 2));
		users.add(new Employee("5", "Jatin5", new Address("JMU5", "1800075"), p, 1));
		users.add(new Employee("6", "Jatin6", new Address("JMU6", "1800076"), p, 3));
//		[−2, 1, −3, 4, −1, 2, 1, −5, 4]
//		users.add(new Employee("7", "Jatin7", new Address("JMU7", "1800077"), p, 4));
//		users.add(new Employee("8", "Jatin8", new Address("JMU78", "18000778"), p, -1));
//		users.add(new Employee("9", "Jatin9", new Address("JMU79", "1800077"), p, 2));
//		users.add(new Employee("10", "Jatin10", new Address("JMU7", "1800077"), p, 1));
//		users.add(new Employee("11", "Jatin11", new Address("JMU7", "1800077"), p, -5));
//		users.add(new Employee("12", "Jatin12", new Address("JMU7", "1800077"), p, 4));

		Map<Project, ArrayList<Employee>> projectEmp = new HashMap();
		//extract the employees and create a map<project: employees>
		users.stream().
			filter(i->i instanceof Employee).
				map(i->(Employee)i).
				forEach(e->{
			if (projectEmp.get(e.project) == null) {
				ArrayList<Employee> emp = new ArrayList();
				emp.add(e);
				projectEmp.put(e.project, emp);
			} else {
				 projectEmp.get(e.project).add(e);
			}
		});
		for (Entry<Project, ArrayList<Employee>> i : projectEmp.entrySet()) {
			//sort->salary
			Collections.sort(i.getValue());
			//for finding the max sub array
			ArrayList <Integer> finalIndex = new ArrayList();
			double finalexpense = Double.MIN_VALUE;
			
			double budget = i.getKey().budget;
			ArrayList<Employee> emp = i.getValue();
			
			//to use the max budget(find maximum sum of a sub array < budget)
			//can't handle cases when non adjacent elements don't form the max budget
			int j = 0;
			while (j < emp.size()) {
				int k = j + 1;
				double temp = emp.get(j).salary;
				ArrayList<Integer> index = new ArrayList();
				index.add(j);
				while (k < emp.size()) {
					if (temp < budget) {
						temp += emp.get(k).salary;
						index.add(k);
						k++;
					} else {
						break;
					}
				}
				if (temp >= finalexpense && temp<=budget) {
					finalexpense = temp;
					finalIndex = (ArrayList<Integer>) index.clone();
				}
				j++;
			}
			
			//printing the projects and employees
			System.out.println("Project: " + i.getKey().name);
			for (Integer ae : finalIndex) {
				System.out.println("  `" + i.getValue().get(ae).name);
			}
			System.out.println("------------");
		}
	}

	@Override
	public int compareTo(Object o) {
		Employee e = (Employee) o;
		if (e.salary > this.salary) {
			return -1;
		} else if (e.salary < this.salary) {
			return 1;
		}
		return 0;
	}
}

class Address {
	String city, zipcode;

	Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}

}

class Project {
	int pId;
	String name;
	double budget;

	Project(int i, String string, int j) {
		this.pId = i;
		this.name = string;
		this.budget = j;
	}
}
