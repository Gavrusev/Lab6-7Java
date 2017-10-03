package by.bstu.fit.oleggutsev.lab6_7java.units;

public class Student extends Person {

    private String mSpeciality;
    private String mFaculty;

    public Student(String firstName, String secondName, String middleName,
                        String speciality, String faculty, int age) {
        super(firstName, secondName, middleName, age);
        mSpeciality = speciality;
        mFaculty = faculty;
    }

    public Student() {
    }

    public String getSpeciality() {
        return mSpeciality;
    }

    public void setSpeciality(String speciality) {
        mSpeciality = speciality;
    }

    public String getFaculty() {
        return mFaculty;
    }

    public void setFaculty(String faculty) {
        mFaculty = faculty;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName() + " "
                + getMiddleName() + " " +  getAge()  + " "
                + getFaculty() + " "  + getSpeciality() + "\n";

    }
}
