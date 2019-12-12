
package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Country {
    @Expose
    private String uuid;

    @Expose
    private String name;

    @Expose
    private String flag;

    @Expose
    private List<City> cities;


    public Country(String uuid, String name, String flag, List<City> cities) {
        this.uuid = uuid;
        this.name = name;
        this.flag = flag;
        this.cities = cities;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Country getCountry(){
        return this;
    }

}
