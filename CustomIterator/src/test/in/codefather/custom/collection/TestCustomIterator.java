package test.in.codefather.custom.collection;

import in.codefather.custom.collection.IteratorInterface;
import in.codefather.custom.collection.User;
import in.codefather.custom.collection.UserCollection;

public class TestCustomIterator {
	public static void main(String[] args) {
		UserCollection collection = new UserCollection(10);
		IteratorInterface  iterator = collection.iterator();
		User user1 = new User();
		user1.setName("Ajay");
		User user2 = new User();
		user2.setName("Ajay");
		User user3 = new User();
		user3.setName("Ajay");
		User user4 = new User();
		user4.setName("Ajay");
		collection.add(user1);
		collection.add(user2);
		while(iterator.hasNext()) {
			User user = (User)iterator.next();
			if(!user.getName().equals("Ajay")) break;
			System.out.println(iterator.next());
		}
		collection.add(user3);
		if(iterator.hasNext()) {System.out.println(iterator.next());}
	}
}