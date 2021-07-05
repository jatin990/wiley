package wiley.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class comparatoremployee {

	public static void main(String[] args) {
		List emp=Arrays.asList(new employee("BOM",1000),new employee("DEL",1200),new employee("BLR",1000),new employee("BLR",1200),new employee("DEL",1400));
		Collections.sort(emp);
		for(Object i:emp) {
			employee i1=(employee) i;
			System.out.println("City: "+i1.city+", Salary: "+i1.salary+", Emp id: "+i1.id);
		}
	}

}
class employee implements Comparable{
	String city;
	int salary,id;
	static int empid=1;
	employee(String city,int salary){
		this.city=city;
		this.salary=salary;
		this.id=empid;
		empid++;
	}
	@Override
	public int compareTo(Object o) {
		employee user=(employee) o;
		if(user.city.compareTo(this.city)==0) {
			return user.salary-this.salary;
		}
		return this.city.compareTo(user.city);
	}
	
}
