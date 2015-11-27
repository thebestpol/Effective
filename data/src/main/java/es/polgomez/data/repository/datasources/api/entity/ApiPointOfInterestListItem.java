package es.polgomez.data.repository.datasources.api.entity;

import java.io.Serializable;

/**
 * Point of Interest api entity from list
 */
public class ApiPointOfInterestListItem implements Serializable {

    private String id;
    private String title;
    private String geocoordinates;

    public ApiPointOfInterestListItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeocoordinates() {
        return geocoordinates;
    }

    public void setGeocoordinates(String geocoordinates) {
        this.geocoordinates = geocoordinates;
    }

    @Override
    public String toString() {
        return "ApiPointOfInterestListItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", geocoordinates='" + geocoordinates + '\'' +
                '}';
    }
}
