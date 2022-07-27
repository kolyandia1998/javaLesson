package Task6.task1;

import Task5.task1.People;

public class Employee extends People {

    private int workExperience;
    private String jobTitle;

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Сотрудник:" + getSurname() + " " + getName() + " " + getMiddleName() + "\n" +
                "Стаж= " + workExperience + " лет" + "\n" +
                "Должность='" + jobTitle + '\'';
    }
}
