package Task11.task2;

import java.util.Objects;

public class Employer extends Task6.task1.Employer {
    public Employer(String jobTittle,String surName, String name,String middleName, int workExperience) {
        this.jobTitle = jobTittle;
        this.surname = surName;
        this.name = name;
        this.middleName =middleName;
        this.workExperience = workExperience;
    }
    @Override
    public int hashCode() {
        return Objects.hash(surname, name, birthDay, jobTitle, middleName, workExperience);
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employer) || this.hashCode() != obj.hashCode() || obj == null)
            return false;
        if (this == obj)
            return true;

        Employer employer = (Employer) obj;
        return this.workExperience == employer.workExperience && this.jobTitle != null
                && this.jobTitle.equals(employer.jobTitle) && this.surname != null
                && this.surname.equals(employer.surname) && this.name != null
                && this.name.equals(employer.name) && this.middleName != null
                && this.middleName.equals(employer.middleName) && this.birthDay == employer.birthDay;

    }

}
