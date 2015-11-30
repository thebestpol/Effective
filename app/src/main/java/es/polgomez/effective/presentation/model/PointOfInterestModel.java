package es.polgomez.effective.presentation.model;

public class PointOfInterestModel {

    private int id;
    private String title;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PointOfInterestModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
