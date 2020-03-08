package com.vijaysidhu.springmvc.model;

import lombok.Data;

@Data
public class Brewery {

    private int id;
    private String name;
    private String brewery_type;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String country;
    private String longitude;
    private String latitude;
    private String phone;
    private String website_url;
    private String updated_at;

    public Brewery(){

    }

    public Brewery(int id, String name, String brewery_type, String street, String city, String state, String postal_code, String country, String longitude, String latitude, String phone, String website_url, String updated_at) {
        this.id = id;
        this.name = name;
        this.brewery_type = brewery_type;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.website_url = website_url;
        this.updated_at = updated_at;
    }
}
