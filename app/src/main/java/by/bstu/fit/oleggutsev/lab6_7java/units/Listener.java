package by.bstu.fit.oleggutsev.lab6_7java.units;


import by.bstu.fit.oleggutsev.lab6_7java.organization.Organizations;

public class Listener extends Person {

    private String mOrganization;
    private int mListeningHours;

    public Listener(String firstName, String secondName,
                    String middleName, int age, int listeningHours, String organisation) {
        super(firstName, secondName, middleName, age);
        mOrganization = organisation;
        mListeningHours = listeningHours;
    }

    public Listener() {
    }

    public String getOrganization() {
        return mOrganization;
    }

    public void setOrganization(String organization) {
        mOrganization = organization;
    }

    public int getListeningHours() {
        return mListeningHours;
    }

    public void setListeningHours(int listeningHours) {
        mListeningHours = listeningHours;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSecondName() + " " + getAge()
                + " " + getListeningHours() + " " + getOrganization() + "\n";
    }
}