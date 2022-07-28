package edu.ilstu;

/**
 * Modified 3/14/2022 by Grayson Newcomer
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrderedList<E extends Comparable<E>> implements Iterable<E>
{
	private DoubleLinkedList<E> theList;

	public OrderedList()
	{
		theList = new DoubleLinkedList<>();
	}

	/**
	 * Insert obj into the list preserving the list's order.
	 * 
	 * @pre The items in the list are ordered.
	 * @post obj has been inserted into the list such that the items are still in
	 *       order.
	 * @param obj The item to be inserted.
	 */
	public void add(E obj)
	{
		ListIterator<E> iter = theList.listIterator(0);
		// Find the insertion position and insert.
		while (iter.hasNext())
		{
			if (obj.compareTo(iter.next()) == 0)
			{
				return;
			}
			else
			{
				iter.previous();
			}
			if (obj.compareTo(iter.next()) < 0)
			{

				// Iterator has just stepped over the first element
				// that is greater than the element to be inserted.
				// Move the iterator back one.
				iter.previous();
				iter.add(obj);

				return;
			}

		}
		// assert: All items were examined and no item is larger than
		// the element to be inserted.
		// Add the new item to the end of the list.
		iter.add(obj);
	}

	public boolean remove(E obj)
	{
		ListIterator<E> iter = theList.listIterator(0);
		while (iter.hasNext())
		{
			if (obj.compareTo(iter.next()) == 0)
			{
				iter.previous();
				iter.remove();
				return true;
			}
		}
		return false;
	}

	public int size()
	{
		return theList.size();
	}

	/**
	 * Returns the element at the specified position.
	 * 
	 * @param index The specified position
	 * @return The element at position index
	 */
	public E get(int index)
	{
		return theList.get(index);
	}

	/**
	 * Returns an iterator to this OrderedList.
	 * 
	 * @return The iterator, positioning it before the first element.
	 */
	public Iterator<E> iterator()
	{
		return theList.iterator();
	}

	public String toString()
	{

		String s = "[" + get(0).toString() + ", ";

		for (int i = 1; i < size() - 2; i++)
		{
			s = s.concat(get(i).toString() + ", ");
		}
		s = s.concat(get(size() - 1).toString() + "]");

		return s;

	}

}
