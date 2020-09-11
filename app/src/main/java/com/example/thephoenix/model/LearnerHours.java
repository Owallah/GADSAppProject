package com.example.thephoenix.model;

public class LearnerHours implements Comparable< LearnerHours > {
    private String name;
    private Integer hours;
    private String country;
    private String badgeUrl;
    private Integer criteria;

    public LearnerHours(String name, Integer hours, String country, String badgeUrl, Integer criteria) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setCriteria(Integer criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compareTo(LearnerHours o) {
        return this.getHours().compareTo(o.getHours());
    }
}
