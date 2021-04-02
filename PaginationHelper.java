package net.Corejava;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saroj on 4/1/2021.
 */
public class PaginationHelper<I> {
    private int totalItemCount = 0;
    private int countPerPage = 0;
    
    /**
     * The constructor takes in an array of items 
     */
    public PaginationHelper(List<I> ItemList, int countPerPage) {
        this.totalItemCount = ItemList.size();
        this.countPerPage = countPerPage;
    }

    /**
     * This will return the number of items within the entire List
     */
    public int itemCount() {
        return totalItemCount;
    }

    /**
     * This will return the number of pages
     */
    public int pageCount() {
        return (totalItemCount-1)/countPerPage+1;
    }

    /**
     * Returns the number of items on the current page.
     */
    public int pageItemCount(int index) {
        int count = pageCount();
        if(index < 0 || index >= count)
        	return -1;
        if(index == count -1)
            return totalItemCount%countPerPage;
        else
            return countPerPage;
    }

    /**
     * Page index should start with zero and out of range should return -1
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex >= totalItemCount) return -1;
        return (itemIndex-1)/countPerPage;
    }

    public static void main(String args[])
    {
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('a');arr.add('b');arr.add('c');arr.add('d');arr.add('e');arr.add('f');
        PaginationHelper<Character> helper = new PaginationHelper(arr, 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }
}