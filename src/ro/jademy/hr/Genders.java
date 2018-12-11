package ro.jademy.hr;

public enum Genders {
    M("M"),
    F("F");

    private String genderName;
    Genders(String genderName){
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }
}
