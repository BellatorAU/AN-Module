package by.nc.school.dev.model;

public class Teacher {

    private final Discipline discipline;

    public Teacher(Discipline discipline) {
        this.discipline = discipline;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
