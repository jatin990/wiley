package wiley.programs.day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

//set = [2,1, User{2,"User2"},User{1,"Adam"},Hi,Hello]

//integers
//users
//strings

//case 1: sort : show the integers first then users sorted by user id then strings

//expected sort : 1,2,User{1,"Adam"}, User{2,"User2"} (user by id),Hello,Hi

//case 2: sort : show me sorted strings then users sorted by user id then integers

//expected sort : Hello,Hi, User{1, "Adam"}, User{2,"User2"},1,2

//case 3: sort : show all the objects sorted based on string whether that is username or simple string then integers

//expected sort : User{1,"Adam"},Hello,Hi,User{2,"User2"},1,2
public class SortingAssignment {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeSet set=new TreeSet<>(new sortByStringUserIdInt());
		set.add("hello");
		set.add(new User(10,"user10"));
		set.add(new User(20,"user20"));
		set.add(10);
		set.add("Hi");
		set.add(1);
//		set.stream().forEach(e->{
//			if(e instanceof User) {
//				User i=(User)e;
//				System.out.println("User id: "+i.getId()+", User name: "+i.getName());
//			}
//			else {
//				System.out.println(e);
//			}
//		});
		set.stream().forEach(System.out::println);
	}

}

class sortByIntUserIdString implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Integer) {
			if( o2 instanceof Integer) {
				return (Integer)o1-(Integer)(o2);
			}else if(o2 instanceof User){
				return Integer.MIN_VALUE+1;
			}
			return Integer.MIN_VALUE;
		}else if(o1 instanceof User) {
			if( o2 instanceof User) {
				return ((User) o1).getId()-((User) o2).getId();
			}else if(o2 instanceof Integer){
				return Integer.MAX_VALUE;
			}
			return Integer.MIN_VALUE;
			
		}else if(o1 instanceof String) {
			if( o2 instanceof String) {
				return ((String) o1).compareTo((String)(o2));
			}else if(o2 instanceof Integer){
				return Integer.MAX_VALUE;
			}
			return Integer.MAX_VALUE-1;
		}
		return 0;
	}
}

class sortByStringUserIdInt implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Integer) {
			if( o2 instanceof Integer) {
				return (Integer)o1-(Integer)(o2);
			}else if(o2 instanceof User){
				return Integer.MAX_VALUE-1;
			}
			return Integer.MAX_VALUE;
		}else if(o1 instanceof User) {
			if( o2 instanceof User) {
				return ((User) o1).getId()-((User) o2).getId();
			}else if(o2 instanceof Integer){
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
			
		}else if(o1 instanceof String) {
			if( o2 instanceof String) {
				return ((String) o1).compareTo((String)(o2));
			}else if(o2 instanceof Integer){
				return Integer.MIN_VALUE;
			}
			return Integer.MIN_VALUE+1;
		}
		return 0;
	}
}

class sortByUserNameStringInt implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Integer) {
			if( o2 instanceof Integer) {
				return (Integer)o1-(Integer)(o2);
			}else if(o2 instanceof User){
				return Integer.MAX_VALUE;
			}
			return Integer.MAX_VALUE-1;
		}else if(o1 instanceof User) {
			if( o2 instanceof User) {
				return ((User) o1).getName().compareTo(((User) o2).getName());
			}else if(o2 instanceof Integer){
				return Integer.MIN_VALUE;
			}
			return Integer.MIN_VALUE+1;
			
		}else if(o1 instanceof String) {
			if( o2 instanceof String) {
				return ((String) o1).compareTo((String)(o2));
			}else if(o2 instanceof Integer){
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}
		return 0;
	}
}

//class GenericComp implements Comparator{
//	@Override
//	public List<String> order=new ArrayList();
//	GenericComp(List order){
//		this.order=order;
//	}
//	public int compare(Object o1, Object o2) {
//		if(o1 instanceof Integer) {
//			if( o2 instanceof Integer) {
//				return (Integer)o1-(Integer)(o2);
//			}else if(o2 instanceof User){
//				return Integer.MAX_VALUE;
//			}
//			return Integer.MAX_VALUE-1;
//		}else if(o1 instanceof User) {
//			if( o2 instanceof User) {
//				return ((User) o1).getName().compareTo(((User) o2).getName());
//			}else if(o2 instanceof Integer){
//				return Integer.MIN_VALUE;
//			}
//			return Integer.MIN_VALUE+1;
//			
//		}else if(o1 instanceof String) {
//			if( o2 instanceof String) {
//				return ((String) o1).compareTo((String)(o2));
//			}else if(o2 instanceof Integer){
//				return Integer.MIN_VALUE;
//			}
//			return Integer.MAX_VALUE;
//		}
//		return 0;
//	}
//}











class User {
    private int id;
    private String name;

    public User(){

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
		return id + " " + name ;
	}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}