public class College {
    private String name;
    private String location;
    private int collegeId;

    public College(int collegeId, String name, String location) {
        this.collegeId = collegeId;
        this.name = name;
        this.location = location;
    }

    public College(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
