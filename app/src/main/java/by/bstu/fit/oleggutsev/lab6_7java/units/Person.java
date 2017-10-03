package by.bstu.fit.oleggutsev.lab6_7java.units;

public abstract class Person {
    private String mFirstName;
    private String mSecondName;
    private String mMiddleName;
    private int mAge;

    public Person() {
        mFirstName = "";
        mSecondName = "";
        mAge = 0;
    }

    public Person(String firstName, String secondName, String middleName, int age) {
        mFirstName = firstName;
        mSecondName = secondName;
        mAge = age;
        mMiddleName = middleName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getSecondName() {
        return mSecondName;
    }

    public void setSecondName(String secondName) {
        mSecondName = secondName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
