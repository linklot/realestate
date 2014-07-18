package com.newad.realestate.controller.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.newad.realestate.model.Picture;
import com.newad.realestate.model.Property;

public class IndexPropertyDto {
    
    private long id;
    private String address;
    private String propertyType;
    private int price;
    private String suburb;
    private int beds, bathrooms, carSpaces;
    private String newOrEstablished;
    private float landSize;
    private String feature;
    private String introduction;
    private long firstPicId;
    private List<Long> picIds;
    private boolean carousel;
    
    private IndexPropertyDto() {
        picIds = new ArrayList<>();
    }
    
    public IndexPropertyDto(Property p) {
        this();
        this.carousel = p.isCarousel();
        this.id = p.getId();
        this.address = p.getAddress();
        switch (p.getPropertyType()) {
        case APARTMENT:
            this.propertyType = "APARTMENT";
            break;
        case HOUSE:
            this.propertyType = "HOUSE";
            break;
        case LAND:
            this.propertyType = "LAND";
            break;
        case TOWNHOUSE:
            this.propertyType = "TOWNHOUSE";
            break;
        case UNIT:
            this.propertyType = "UNIT";
            break;
        default:
            this.propertyType = "HOUSE";
            break;
        
        }
        this.price = p.getPrice();
        this.suburb = p.getSuburb();
        this.beds = p.getBeds();
        this.bathrooms = p.getBathrooms();
        this.carSpaces = p.getCarSpaces();
        switch(p.getNewOrEstablished()) {
        case ESTABLISHED:
            this.newOrEstablished = "现房";
            break;
        case NEW:
            this.newOrEstablished = "期房";
            break;
        default:
            this.newOrEstablished = "现房";
            break;
        
        }
        this.landSize = p.getLandSize();
        this.feature = p.getFeature();
        this.introduction = p.getIntroduction();
        
        Set<Picture> pics = p.getPictureGroup().getPictures();
        if(pics.size() > 0) {
            this.firstPicId = pics.iterator().next().getId();
            Iterator<Picture> it = pics.iterator();
            while(it.hasNext()) {
                picIds.add(it.next().getId());
            }
        }
        else this.firstPicId = 0;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public int getPrice() {
        return price;
    }

    public String getSuburb() {
        return suburb;
    }

    public int getBeds() {
        return beds;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getCarSpaces() {
        return carSpaces;
    }

    public String getNewOrEstablished() {
        return newOrEstablished;
    }

    public float getLandSize() {
        return landSize;
    }

    public String getFeature() {
        return feature;
    }

    public String getIntroduction() {
        return introduction;
    }

    public long getFirstPicId() {
        return firstPicId;
    }

    public List<Long> getPicIds() {
        return picIds;
    }

    public boolean isCarousel() {
        return carousel;
    }

}
