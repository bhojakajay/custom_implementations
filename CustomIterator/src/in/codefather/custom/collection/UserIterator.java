package in.codefather.custom.collection;

import java.util.ConcurrentModificationException;

public class UserIterator implements IteratorInterface{
	
	private UserCollection collection;
	private int changeTimes;
	private int cursor;
	private boolean isIterationStarted;
	public UserIterator(final UserCollection collection) {
		this.collection = collection;
		this.changeTimes = collection.getChangeTimes();
	}
	
	@Override
	public boolean hasNext() {
		if(isIterationStarted) {
			checkForModifications();	
		}
		changeTimes = collection.getChangeTimes();
		isIterationStarted = true;
		if(boundryConditionCheck() && cursorLocationCheck() && cursorMaxLimit()) {
			return true;
		}
		return false;
	}

	private void checkForModifications() {
		if(!(this.changeTimes==collection.getChangeTimes())) {
			throw new ConcurrentModificationException();
		}
	}

	private boolean cursorMaxLimit() {
		return cursor<collection.getSize();
	}

	private boolean cursorLocationCheck() {
		return cursor<collection.getElementCount();
	}

	private boolean boundryConditionCheck() {
		return collection.getSize()!=0 && collection.getElementCount()!=0;
	}
	
	@Override
	public Object next() {
		checkForModifications();
		Object obj = collection.get(cursor);
		cursor++;
		return obj;
	}
	
	public Object remove() {
		Object obj = collection.remove();
		this.changeTimes = collection.getChangeTimes();
		return obj;
	}
	
	public void add(Object object) {
		collection.add(object);
		this.changeTimes = collection.getChangeTimes();
	}
}