package wiley.programs.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;


public class UsersAndCities {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Address address1=new Address("DEL","123");
		Address address2=new Address("GN","1234");
		Address address3=new Address("BLR","1235");
		List<Address> addresses1=Arrays.asList(address1,address3);
		List<Address> addresses2=Arrays.asList(address2,address3);
		List<Address> addresses3=Arrays.asList(address2,address3);
		
		UsersAndAddress user1=new UsersAndAddress("1","user1",addresses1);
		UsersAndAddress user2=new UsersAndAddress("2","user2",addresses2);
		UsersAndAddress user3=new UsersAndAddress("3","user3",addresses3);
		List<UsersAndAddress> users=Arrays.asList(user1,user2,user3);
		TreeMap<List<String>,List<UsersAndAddress>> addressusers=new TreeMap<List<String>,List<UsersAndAddress>>((o1,o2)->o1.get(0).compareTo(o2.get(0)));

        TreeMap<Integer, String> m = 
                   new TreeMap<Integer, String>((o1, o2) -> (o1 > o2) ? 
                                               -1 : (o1 < o2) ? 1 : 0);
		users.stream().forEach(i->{
			i.address.stream().forEach(j->{
				List<String> address=Arrays.asList(j.city,j.zipcode);
				if (addressusers.get(address)==null) {
					List<UsersAndAddress> temp=new ArrayList<>();
					temp.add(i);
					addressusers.put(address,temp);
				}
				else {
					addressusers.get(address).add(i);
				}
			});
		});
		addressusers.entrySet().stream()
		.filter(i->i.getValue().size()>1)
		.forEach(System.out::println);
		
	}

}
class AddressUsers{
	public String city,zip;
	public List<UsersAndAddress> users;
}
class UsersAndAddress{
	public String id,name;
	public List<Address> address;
	public UsersAndAddress(String id, String name, List<Address> address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserId:"+id+"- Name:"+name;
	}
}
class Address{
//	public List users;
	public String city,zipcode;
	Address(String city, String zipcode){
		this.city=city;
		this.zipcode=zipcode;
	}
}