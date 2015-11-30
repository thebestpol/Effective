package es.polgomez.data.entities;

public class PointOfInterestDetailEntity {

    private String id;
    private String title;
    private String address;
    private String transport;
    private String email;
    private String description;
    private String phone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PointOfInterestDetailEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", transport='" + transport + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
