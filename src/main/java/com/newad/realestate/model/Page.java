package com.newad.realestate.model;

import java.util.List;

public class Page<T extends Object> {
    
    private int pageSize;
    private long totalCount;
    private int startIndex;
    private int[] indexes = new int[0];
    private List<T> items;
    
    private Page(List<T> items, int startIndex, int pageSize, long totalCount) {
        this.pageSize = pageSize;
        setTotalCount(totalCount);
        this.items = items;
        setStartIndex(startIndex);
    }
    
    public static <T> Page<T> getPage(List<T> items, int startIndex, int pageSize, long totalCount) {
        return new Page<T>(items, startIndex, pageSize, totalCount);
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }
    
    public int getCurrentPage() {
        return this.startIndex / pageSize + 1;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getNextIndex() {
        int nextIndex = getStartIndex() + pageSize;
        return (nextIndex >= totalCount) ? getStartIndex() : nextIndex;
    }

    public int getPreviousIndex() {
        int previousIndex = getStartIndex() - pageSize;
        return (previousIndex < 0) ? 0 : previousIndex;
    }

    public int getPageCount() {
        int count = (int) totalCount / pageSize;
        if (totalCount % pageSize > 0) count++;
        return count;
    }

    public int getLastIndex() {
        return (indexes.length > 0) ? indexes[indexes.length-1] : 0;
    }

    public List<T> getItems() {
        return items;
    }

    private void setStartIndex(int startIndex) {
        if(totalCount <= 0) this.startIndex = 0;
        else if(startIndex >= totalCount)
            this.startIndex = indexes[indexes.length - 1];
        else if(startIndex < 0) this.startIndex = 0;
        else this.startIndex = indexes[startIndex / pageSize];
    }
    
    private void setTotalCount(long totalCount) {
        if(totalCount > 0) {
            this.totalCount = totalCount;
            int count = (int) totalCount / pageSize;
            if(totalCount % pageSize > 0) count++;
            indexes = new int[count];
            for(int i=0; i<count; i++) {
                indexes[i] = pageSize * i;
            }
        } else this.totalCount = 0;
    }

}
