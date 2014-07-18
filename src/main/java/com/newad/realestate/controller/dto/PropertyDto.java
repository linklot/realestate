package com.newad.realestate.controller.dto;

import com.newad.realestate.model.Property;

public class PropertyDto {
    private long id;
    private String address, suburb;
    private Property.TYPE propertyType;
    private int price;
    private int beds, bathrooms, carSpaces;
    private Property.NEWORESTABLISHED newOrEstablished;
    private float landSize;
    private String feature, introduction;
    private boolean carousel;
    private String agency, contact, contactNote;
    
    public PropertyDto() {
    }
    
    public PropertyDto(Property p) {
        this();
        this.id = p.getId();
        this.address = p.getAddress();
        this.propertyType = p.getPropertyType();
        this.price = p.getPrice();
        this.suburb = p.getSuburb();
        this.beds = p.getBeds();
        this.bathrooms = p.getBathrooms();
        this.carSpaces = p.getCarSpaces();
        this.newOrEstablished = p.getNewOrEstablished();
        this.landSize = p.getLandSize();
        this.feature = p.getFeature();
        this.introduction = p.getIntroduction();
        this.carousel = p.isCarousel();
        this.agency = p.getAgency();
        this.contact = p.getContact();
        this.contactNote = p.getContactNote();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Property.TYPE getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Property.TYPE propertyType) {
        this.propertyType = propertyType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getCarSpaces() {
        return carSpaces;
    }

    public void setCarSpaces(int carSpaces) {
        this.carSpaces = carSpaces;
    }

    public Property.NEWORESTABLISHED getNewOrEstablished() {
        return newOrEstablished;
    }

    public void setNewOrEstablished(Property.NEWORESTABLISHED newOrEstablished) {
        this.newOrEstablished = newOrEstablished;
    }

    public float getLandSize() {
        return landSize;
    }

    public void setLandSize(float landSize) {
        this.landSize = landSize;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isCarousel() {
        return carousel;
    }

    public void setCarousel(boolean carousel) {
        this.carousel = carousel;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactNote() {
        return contactNote;
    }

    public void setContactNote(String contactNote) {
        this.contactNote = contactNote;
    }

}
