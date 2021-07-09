package wiley.programs.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HubOffice {

	public static void main(String[] args) {
		Address address1 = new Address("DEL", "110001");
		Address address2 = new Address("DEL", "110096");
		Address address3 = new Address("BLR", "560002");
		Address address4 = new Address("BLR", "560038");
		Address address5 = new Address("BLR", "560001");
		Address address6 = new Address("BOM", "400018");
		Address address7 = new Address("BOM", "400037");
		List<Address> addresses1 = Arrays.asList(address5, address3, address1);
		List<Address> addresses2 = Arrays.asList(address4, address2, address1);
		List<Address> addresses3 = Arrays.asList(address6, address7, address1, address5);

		UsersAndAddress user1 = new UsersAndAddress("3", "user3", addresses1);
		UsersAndAddress user2 = new UsersAndAddress("44", "user44", addresses2);
		UsersAndAddress user3 = new UsersAndAddress("2", "user2", addresses3);
		List<UsersAndAddress> users = Arrays.asList(user1, user2, user3);

		Map<Address, List<UsersAndAddress>> addressusers = new HashMap<Address, List<UsersAndAddress>>();
		users.stream().forEach(i -> {
			i.address.stream().forEach(j -> {
				if (addressusers.get(j) == null) {
					List<UsersAndAddress> temp = new ArrayList<>();
					temp.add(i);
					addressusers.put(j, temp);
				} else {
					addressusers.get(j).add(i);
				}
			});
		});
		addressusers.entrySet().stream().sorted((o1, o2) -> {
			int userdiff = o2.getValue().size() - o1.getValue().size();
			if (userdiff == 0) {
				int addresscomparison = ((Address) o1.getKey()).city.compareTo(((Address) o2.getKey()).city);
				if (addresscomparison == 0) {
					return ((Address) o1.getKey()).zipcode.compareTo(((Address) o2.getKey()).zipcode);
				}
				return addresscomparison;
			}
			return userdiff;
		}).forEach(i -> {
			List<UsersAndAddress> susers = i.getValue().stream()
					.sorted((o1, o2) -> (((UsersAndAddress) o1).name.compareTo(((UsersAndAddress) o2).name)))
					.collect(Collectors.toList());
			System.out.println("Address: " + i.getKey() + "-> Users: " + susers);
		});
	}

}

class AddressUsers {
	public String city, zip;
	public List<UsersAndAddress> users;
}

class UsersAndAddress {
	public String id, name;
	public List<Address> address;

	public UsersAndAddress(String id, String name, List<Address> address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserId:" + id + "- Name:" + name;
	}
}

class Address {
	public String city, zipcode;

	Address(String city, String zipcode) {
		this.city = city;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "City: " + city + ", Zipcode: " + zipcode;
	}

	@Override
	public boolean equals(Object obj) {
		return this.city.equals((((Address) obj).city)) && this.zipcode.equals((((Address) obj).zipcode));
	}
}