package in.codefather.custom.collection;

public class UserCollection implements CollectionInterface{
	
	private User[] users;
	private final int size;
	private int elementCount;
	private int changeTimes;
	
	public UserCollection(int size) {
		users = new User[size];
		this.size = size;
	}

	@Override
	public IteratorInterface iterator() {
		return new UserIterator(this);
	}
	
	/**
	 * Adds a user at the end of the UserCollection
	 * @param object
	 */
	public void add(Object object) {
		this.changeTimes = changeTimes+1;
		if(getElementCount()<=getSize()) {
			this.users[elementCount] = (User)object;
			this.setElementCount(elementCount+1);;
		}
	}
	
	/**
	 * Removes a user at the end of the UserCollection
	 * @return
	 */
	public User remove() {
		this.changeTimes = changeTimes+1;
		if(getElementCount()>0) {
			User removedUser = users[getElementCount()-1];
			setElementCount(getElementCount()-1);
			return removedUser;
		}
		return null;
	}

	public User get(int index) {
		return this.users[index];
	}
	public int getSize() {
		return this.size;
	}

	public int getElementCount() {
		return this.elementCount;
	}
	
	private void setElementCount(int elementCount) {
		this.elementCount = elementCount;
	}
	
	public int getChangeTimes() {
		return this.changeTimes;
	}
}