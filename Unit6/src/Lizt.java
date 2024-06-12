public interface Lizt<E> {
    /**
     * Returns the number of elements in this list. If this list contains more than
     * Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     * 
     * postcondition: the list is unchanged
     * 
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Appends the specified element to the end of this list (optional operation).
     * Lists that support this operation may place limitations on what elements may
     * be added to this list. In particular, some lists will refuse to add null
     * elements, and others will impose restrictions on the type of elements that
     * may be added. List classes should clearly specify in their documentation any
     * restrictions on what elements may be added.
     * 
     * @param e - element to be appended to this list
     * @return true (as specified by Collection.add(E))
     */
    public boolean add(E e);

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their indices).
     * 
     * precondition: precondition: index >= 0 && index < size, element is valid for type of list
     * postcondition: does not change any other data contained in list
     * 
     * @param index   - index at which the specified element is to be inserted
     * @param element - element to be inserted
     * 
     * 
     */
    public void add(int index, E element);

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one from
     * their indices). Returns the element that was removed from the list.
     * 
     * precondition: index >= 0 && index < size
     * postcondition: does not change any other data contained in list
     * 
     * @param index - the index of the element to be removed
     * @return the element previously at the specified position
     */
    public E remove(int index);

    /**
     * Returns the element at the specified position in this list.
     * 
     * precondition: index >= 0 && index < size
     * postcondition: the list is unchanged
     * 
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public E get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     * 
     * precondition: precondition: index >= 0 && index < size, element is valid for type of list
     * postcondition: does not change any other data contained in list
     * 
     * @param index   - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public E set(int index, E element);

}