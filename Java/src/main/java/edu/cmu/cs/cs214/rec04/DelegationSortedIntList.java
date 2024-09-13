package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList;
    private int totalAdded;
    public DelegationSortedIntList() {
        // Initialize the delegated SortedIntList instance
        sortedIntList = new SortedIntList();
        totalAdded = 0;
    }
    @Override
    public boolean add(int num) {
        // Delegate to the SortedIntList's add method
        boolean result = sortedIntList.add(num);

        // If the element was successfully added, increment totalAdded
        if (result) {
            totalAdded++;
        }

        return result;
    }
    @Override
    public boolean addAll(IntegerList list) {
        boolean result = false;

        // Iterate through the given list and delegate adding to sortedIntList
        for (int i = 0; i < list.size(); i++) {
            result |= this.add(list.get(i)); // Calls the add method, which tracks totalAdded
        }

        return result;
    }
    public int getTotalAdded() {
        return totalAdded;
    }
    @Override
    public int get(int index) {
        return sortedIntList.get(index); // Delegates to the internal SortedIntList
    }

    @Override
    public boolean remove(int num) {
        return sortedIntList.remove(num); // Delegates to the internal SortedIntList
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedIntList.removeAll(list); // Delegates to the internal SortedIntList
    }

    @Override
    public int size() {
        return sortedIntList.size(); // Delegates to the internal SortedIntList
    }
}