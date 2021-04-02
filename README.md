# pagenation


/*
The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types of values contained within the collection/array are not relevant.

The following are some examples of how this class is used:


var helper = new PaginationHelper(['a','b','c','d','e','f'], 4);
helper.pageCount(); //should == 2
helper.itemCount(); //should == 6
helper.pageItemCount(0); //should == 4
helper.pageItemCount(1); // last page - should == 2
helper.pageItemCount(2); // should == -1 since the page is invalid

# page_Index takes an item index and returns the page that it belongs on
helper.pageIndex(5); //should == 1 (zero based index)
helper.pageIndex(2); //should == 0
helper.pageIndex(20); //should == -1
helper.pageIndex(-10); //should == -1

*/

//Junit test cases:

var helper = new PaginationHelper(['a','b','c','d','e','f'], 4);


assertEquals(“Page Count should be equal to 2 ”, helper.pageCount(), 2);

assertEquals(“ Item count should be equal to 6 ”, helper.itemCount(), 6);

assertEquals(“ Item count(0) should be equal to 4 ”, helper.itemCount(0), 4);

assertEquals(“ Item count(1) should be equal to 2 ”, helper.itemCount(1), 2);

assertEquals(“ Item count(2) should be equal to -1 ”, helper.itemCount(2), -1);

// Junit test cases for page Index scenario
assertEquals(“Page Index (5) should be equal to 1 ”, helper.pageIndex(5), 1);

assertEquals(“Page Index (2) should be equal to 0 ”, helper.pageIndex(2), 0);

assertEquals(“Page Index (20) should be equal to -1 ”, helper.pageIndex(20), -1);

assertEquals(“Page Index (-10) should be equal to -1 ”, helper.pageIndex(-10), -1);


Java Code for the given problem

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
