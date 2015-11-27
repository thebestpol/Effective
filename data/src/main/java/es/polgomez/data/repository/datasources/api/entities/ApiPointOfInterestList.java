package es.polgomez.data.repository.datasources.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * List of points of interest entity from api
 */
public class ApiPointOfInterestList implements Serializable {

    private List<ApiPointOfInterestListItem> list = new ArrayList<>();

    public List<ApiPointOfInterestListItem> getList() {
        return list;
    }

    public void setList(List<ApiPointOfInterestListItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ApiPointOfInterestList{" +
                "list=" + list +
                '}';
    }
}
