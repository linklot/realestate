package com.newad.realestate.dao;

import java.util.List;

import com.newad.realestate.model.Property;

public interface PropertyDao extends Dao<Property> {
    
    /**
     * Get the last property code.
     * @return "0" when there is no record
     */
    String getLastPropertyCode();
    
    List<Property> getPagedProperties(int startIndex, int pageSize);
    
    List<Property> getLatest4Properties();
    
    List<Property> search(String suburb, Property.NEWORESTABLISHED newOrEstablished,
            Property.TYPE type, int beds, int bathrooms,
            int minPrice, int maxPrice);
    
    List<Property> getCarouselProperties(int number);

}
