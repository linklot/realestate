package com.newad.realestate.model;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * @author lincoln
 * Property model
 *
 */
@Entity
@Table(name = "PROPERTY")
@NamedQueries({
////@NamedQuery(name="Role.findRolesByUserId",
////            query="select r from Role r join r.users rusers where rusers.id = :id")
    @NamedQuery(name="Property.findAll",
                query="from Property p order by p.id desc")
})
public class Property {
    
    /**
     * The property type, including 'HOUSE, APARTMENT, UNIT, TOWNHOUSE, LAND'.
     * @author lincoln
     *
     */
    public enum TYPE {
        HOUSE, APARTMENT, UNIT, TOWNHOUSE, LAND;
    }
    
    /**
     * Whether the property is new or established.
     * @author lincoln
     *
     */
    public enum NEWORESTABLISHED {
        NEW, ESTABLISHED;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROPERTY_ID")
    private long id;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "SUBURB")
    private String suburb;
    
    @Column(name = "FEATURE")
    private String feature;
    
    @Column(name = "INTRO")
    private String introduction;
    
    @Column(name = "PROPERTY_TYPE")
    @Enumerated(EnumType.STRING)
    private TYPE propertyType;
    
    @Column(name = "NEWORESTABLISHED")
    @Enumerated(EnumType.STRING)
    private NEWORESTABLISHED newOrEstablished;
    
    @Column(name = "PRICE")
    private int price;
    
    @Column(name = "PROPERTY_CODE")
    private String propertyCode;
    
    @Column(name = "BEDS")
    private int beds;
    
    @Column(name = "BATHROOMS")
    private int bathrooms;
    
    @Column(name = "CARSPACES")
    private int carSpaces;
    
    @Column(name = "LANDSIZE")
    private float landSize;
    
    @Column(name = "CAROUSEL")
    @Type(type = "yes_no")
    private boolean carousel;
    
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "FK_PICTUREGROUP_ID")
    private PictureGroup pictureGroup;
    
    @Column(name = "AGENCY")
    private String agency;
    
    @Column(name = "CONTACT")
    private String contact;
    
    @Column(name = "CONTACTNOTE")
    private String contactNote;
    
    public Property() {}
    
    private Property(Builder builder) {
        this.id = 0l;
        this.propertyCode = builder.propertyCode;
        this.address = builder.address;
        this.feature = builder.feature;
        this.introduction = builder.introduction;
        this.propertyType = builder.propertyType;
        this.newOrEstablished = builder.newOrEstablished;
        this.price = builder.price;
        this.beds = builder.beds;
        this.bathrooms = builder.bathrooms;
        this.carSpaces = builder.carSpaces;
        this.landSize = builder.landSize;
        this.pictureGroup = builder.pictureGroup;
        this.suburb = builder.suburb;
        this.carousel = builder.carousel;
        this.agency = builder.agency;
        this.contact = builder.contact;
        this.contactNote = builder.contactNote;
    }

    public static class Builder {
        private final String propertyCode, address;
        private String suburb, feature, introduction;
        private String agency, contact, contactNote;
        private Property.TYPE propertyType;
        private Property.NEWORESTABLISHED newOrEstablished;
        private int price, beds, bathrooms, carSpaces;
        private float landSize;
        private PictureGroup pictureGroup;
        private boolean carousel;
        
        public Builder(String propertyCode, String address) {
            this.propertyCode = propertyCode;
            this.address = address;
            this.feature = this.introduction = "";
            this.propertyType = Property.TYPE.HOUSE;
            this.newOrEstablished = Property.NEWORESTABLISHED.NEW;
            this.price = this.beds = this.bathrooms = this.carSpaces = 1;
            this.landSize = 0.0f;
            this.pictureGroup = PictureGroup.getInstance();
            this.carousel = false;
            this.agency = this.contact = this.contactNote = "";
        }
        
        public Builder feature(String feature) {
            this.feature = feature;
            return this;
        }
        
        public Builder introduction(String introduction) {
            this.introduction = introduction;
            return this;
        }
        
        public Builder propertyType(Property.TYPE type) {
            this.propertyType = type;
            return this;
        }
        
        public Builder newOrEstablished(Property.NEWORESTABLISHED newOrEstablished) {
            this.newOrEstablished = newOrEstablished;
            return this;
        }
        
        public Builder price(int price) {
            this.price = price;
            return this;
        }
        
        public Builder beds(int beds) {
            this.beds = beds;
            return this;
        }
        
        public Builder bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }
        
        public Builder carSpaces(int carSpaces) {
            this.carSpaces = carSpaces;
            return this;
        }
        
        public Builder landSize(float landSize) {
            this.landSize = landSize;
            return this;
        }
        
        public Builder pictureGroup(PictureGroup pictureGroup) {
            this.pictureGroup = pictureGroup;
            return this;
        }
        
        public Builder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }
        
        public Builder carousel(boolean carousel) {
            this.carousel = carousel;
            return this;
        }
        
        public Builder agency(String agency) {
            this.agency = agency;
            return this;
        }
        
        public Builder contact(String contact) {
            this.contact = contact;
            return this;
        }
        
        public Builder contactNote(String contactNote) {
            this.contactNote = contactNote;
            return this;
        }
        
        public Property build() {
            return new Property(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
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

    public float getLandSize() {
        return landSize;
    }

    public void setLandSize(float landSize) {
        this.landSize = landSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public TYPE getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(TYPE propertyType) {
        this.propertyType = propertyType;
    }

    public NEWORESTABLISHED getNewOrEstablished() {
        return newOrEstablished;
    }

    public void setNewOrEstablished(NEWORESTABLISHED newOrEstablished) {
        this.newOrEstablished = newOrEstablished;
    }

    public PictureGroup getPictureGroup() {
        return pictureGroup;
    }

    public void setPictureGroup(PictureGroup pictureGroup) {
        this.pictureGroup = pictureGroup;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
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
