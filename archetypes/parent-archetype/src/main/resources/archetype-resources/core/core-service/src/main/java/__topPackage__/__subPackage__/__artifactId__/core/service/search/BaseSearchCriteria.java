package ${topPackage}.${subPackage}.${artifactId}.core.service.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BaseSearchCriteria<T> implements SearchCriteria<T>, Serializable {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		protected SortOrderList sortOrderList = new SortOrderList();
	    protected int offset = 0;
	    protected int maxItems = 25;

	    public final SortOrderList getSortOrderList() {
	        return sortOrderList;
	    }

	    public final void setSortOrder(String sortOrderString) {
	        processSortOrderString(sortOrderString);
	    }

	    public final void setSortOrder(String sortField, SortDirectionEnum sortDirection)
	    {
	        setSortOrder(new SortOrder(sortField, sortDirection));
	    }

	    public final void setSortOrder(SortOrder sortOrder) {
	        this.sortOrderList = new SortOrderList();
	        this.sortOrderList.add(filterSortOrder(sortOrder));
	    }

	    public final void setSortOrderList(List<SortOrder> sortOrderList) {
	        this.sortOrderList = new SortOrderList();
	        for (SortOrder sortOrder : sortOrderList) {
	            this.sortOrderList.add(filterSortOrder(sortOrder));
	        }
	   }

	    public final int getOffset() {
	        return offset;
	    }

	    public final void setOffset(int offset) {
	        this.offset = offset;
	    }

	    public final int getMaxItems() {
	        return maxItems;
	    }

	    public final void setMaxItems(int maxItems) {
	        this.maxItems = maxItems;
	    }

	    public final void setOffset(String offset) {
	        if (StringUtils.isNotBlank(offset)) {
	            try {
	                setOffset(Integer.parseInt(offset));
	            } catch (Exception e) {
	                // ignore
	            }
	        }
	    }

	    public final void setMaxItems(String maxItems) {
	        if (StringUtils.isNotBlank(maxItems)) {
	            try {
	                setMaxItems(Integer.parseInt(maxItems));
	            } catch (Exception e) {
	                // ignore
	            }
	        }
	    }

	    public List<SortOrder> getDefaultSortOrder() {
	        return new ArrayList<>();
	    }

	    public List<SortOrder> processSortOrderString(String sortOrderString) {

	        return new ArrayList<>();
	    }

	    /**
	     * Subclasses should override as needed. Provides ability to filter sort order prior to setting.
	     *
	     * @param sortOrder Sort Order Object
	     * @return SortOrder
	     */
	    protected SortOrder filterSortOrder(SortOrder sortOrder) {
	        // Do nothing
	        return sortOrder;
	    }

	    @Override
	    public String toString() {
	        return "AbstractSearchCriteria{" +
	                "sortOrderList=" + sortOrderList +
	                ", offset=" + offset +
	                ", maxItems=" + maxItems +
	                "}";
	    }
}
