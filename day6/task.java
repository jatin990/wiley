import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//2. transform a list of lists into a map using threads e.g.
// *     Users = [
// *              [
// *                  { id:1, name: User1 ,
// *                      projects: [
// *                                  { id: 1, name: PRJ1 },
// *                                  { id: 2, name: PRJ2 }
// *                                  ]
// *                   }
// *              ]
// *     ]
// *
// *     Expected = [
// *                  { id:1, name: User, projectId: 1 },{ id: 1, PRJ1 }
// *                  { id:1, name: User, projectId: 2 },{ id:2, PRJ2 }
// *     ]
// *
// *     however one of the threads keeps on reading from the expected list to be printed as soon as an element
// *     is added to the list it should be picked by the other thread to be
// *     processed- in our case we will just print it for now

class print extends Thread{
	@Override
	public void run() {
		
	}
}
public class task{
	static List<User> users=Arrays.asList(new User("1","u1",Arrays.asList(new Project("1","p1"),new Project("2","p2"))));
	public static void main(String[] args) {
		input inp=new input();
		task t1=new task();
		print inp1=new print();
		inp.start();
		inp1.start();
		
	}
}
class input extends Thread{
	@Override
	public void run() {
		users.stream().foreach(i->{
			
		})
	}
}
class User{
	public String id,name;
	public User(String id, String name, List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.projects = projects;
	}
	List<Project> projects;
}
class Project{
	public String id,name;

	public Project(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

