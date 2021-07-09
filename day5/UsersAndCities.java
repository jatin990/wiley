package wiley.programs.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
		
		
		Map<Address,List<UsersAndAddress>> addressusers=new HashMap<Address,List<UsersAndAddress>>();
		users.stream().forEach(i->{
			i.address.stream().forEach(j->{
				if (addressusers.get(j)==null) {
					List<UsersAndAddress> temp=new ArrayList<>();
					temp.add(i);
					addressusers.put(j,temp);
				}
				else {
					addressusers.get(j).add(i);
				}
			});
		});
		addressusers.entrySet().stream()
		.sorted((o1,o2)->((Address)o1.getKey()).city.compareTo(((Address)o2.getKey()).city))
		.filter(i->i.getValue().size()>1)
		.forEach(System.out::println);
//		.forEach(i->System.out.println("Address: "+i.getKey()+"-> Users: "+i.getValue()));
		
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
	public String city,zipcode;
	Address(String city, String zipcode){
		this.city=city;
		this.zipcode=zipcode;
	}
	@Override
	public String toString() {
		return "City: "+city+", Zipcode: "+zipcode;
	}
	@Override
		public boolean equals(Object obj) {
			return this.city.equals((((Address)obj).city));
		}
}