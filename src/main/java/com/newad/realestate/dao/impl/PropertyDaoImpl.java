package com.newad.realestate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.newad.realestate.dao.PropertyDao;
import com.newad.realestate.model.Property;
import com.newad.realestate.model.Property.NEWORESTABLISHED;
import com.newad.realestate.model.Property.TYPE;

@Repository
public class PropertyDaoImpl extends AbstractHbnDao<Property> implements
        PropertyDao {

    @Override
    @SuppressWarnings("unchecked")
    public String getLastPropertyCode() {
        Query query = super.getSession().getNamedQuery("Property.findAll");
        query.setMaxResults(1);
        List<Property> properties = query.list();
        if(0 == properties.size()) return "0";
        else return properties.get(0).getPropertyCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Property> getPagedProperties(int startIndex, int pageSize) {
        return (List<Property>) super.getSession()
                .getNamedQuery("Property.findAll")
                .setFirstResult(startIndex)
                .setMaxResults(pageSize)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Property> getLatest4Properties() {
        return (List<Property>) super.getSession()
                .getNamedQuery("Property.findAll")
                .setFirstResult(0)
                .setMaxResults(4)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Property> search(String suburb,
            NEWORESTABLISHED newOrEstablished, TYPE type, int beds,
            int bathrooms, int minPrice, int maxPrice) {
        Criteria criteria = super.createCriteria();
        if(!suburb.equals(""))
            criteria.add(Restrictions.ilike("suburb", "%" +suburb+ "%"));
        if(newOrEstablished != null)
            criteria.add(Restrictions.eq("newOrEstablished", newOrEstablished));
        if(type != null)
            criteria.add(Restrictions.eq("propertyType", type));
        if(beds != 0)
            criteria.add(Restrictions.ge("beds", beds));
        if(bathrooms != 0)
            criteria.add(Restrictions.ge("bathrooms", bathrooms));
        if(minPrice != 0)
            criteria.add(Restrictions.ge("price", minPrice));
        if(maxPrice != 0)
            criteria.add(Restrictions.le("price", maxPrice));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Property> getCarouselProperties(int number) {
        List<Property> carouselProperties = new ArrayList<>();
        
        Criteria criteria = super.createCriteria();
        criteria.add(Restrictions.eq("carousel", true));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(number);
        carouselProperties.addAll(criteria.list());
        
        if(carouselProperties.size() < number) {
            // Get more properties to fill up the set
            criteria = super.createCriteria();
            criteria.add(Restrictions.eq("carousel", false));
            criteria.addOrder(Order.desc("id"));
            criteria.setFirstResult(0);
            criteria.setMaxResults(number - carouselProperties.size());
            carouselProperties.addAll(criteria.list());
        }
        
        return carouselProperties;
    }

}
