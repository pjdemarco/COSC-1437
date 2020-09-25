public class Campus extends College {
    private String location;
    private int campusId;
    private College college;

    public Campus(College college, int campusId, String name, String location) {
        super(name, location);
        this.college = college;
        this.campusId = campusId;
    }

    public Campus(int campusId, String name, String location) {
        super(name, location);
        this.campusId = campusId;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public String toString() {
        String str = "Campus: " + getName() + "\nAddress: " + getLocation();
        return str;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }
}
