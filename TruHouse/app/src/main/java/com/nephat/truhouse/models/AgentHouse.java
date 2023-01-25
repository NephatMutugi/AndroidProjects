package com.nephat.truhouse.models;

public class AgentHouse {

    private final String id;
    private final String image_path;
    private final String image_path2;
    private final String image_path3;
    private final String title;
    private final String location;
    private final String price;
    private final String contact;
    private final String description;
    private final String house_type;

    public AgentHouse(String id, String image_path, String image_path2, String image_path3, String title, String location, String price, String contact, String description, String house_type) {
        this.id = id;
        this.image_path = image_path;
        this.image_path2 = image_path2;
        this.image_path3 = image_path3;
        this.title = title;
        this.location = location;
        this.price = price;
        this.contact = contact;
        this.description = description;
        this.house_type = house_type;
    }

    public String getId() {
        return id;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getImage_path2() {
        return image_path2;
    }

    public String getImage_path3() {
        return image_path3;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public String getHouse_type() {
        return house_type;
    }
}
