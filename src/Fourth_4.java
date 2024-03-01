// Класс Абитуриент
class Applicant {
    String name;
    double mark;
    boolean admitted;

    Faculty faculty;

    public Applicant(String name, Faculty faculty) {
        this.name = name;
        this.mark = 0.0;
        this.admitted = false;
        this.faculty = faculty;
    }

    public void setMark(double averageGrade) {
        this.mark = averageGrade;
    }

    public void setAdmitted(boolean admitted) {
        this.admitted = admitted;
    }
}

// Класс Преподаватель
class Teacher {
    public void giveGrade(Applicant applicant, double mark) {
        applicant.setMark(mark);
    }
}

// Класс Факультет
class Faculty {

    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public double getAverage(Applicant[] applicants) {
        double result = 0;
        int n = 0;
        for (Applicant applicant : applicants) {
            if (applicant.faculty.name == this.name) {
                result += applicant.mark;
                n++;
            }
        }
        return (result / n);
    }

    public void admitApplicants(Applicant[] applicants) {
        double avg = getAverage(applicants);
        for (Applicant applicant : applicants) {
            if (applicant.faculty.name == this.name & applicant.mark >=avg) {
                applicant.setAdmitted(true);
            }
        }
    }
}

public class Fourth_4 {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Информатика");
        Faculty faculty_2 = new Faculty("Лингвистика");
        Applicant applicant1 = new Applicant("Иванов", faculty);
        Applicant applicant2 = new Applicant("Петров", faculty);
        Applicant applicant3 = new Applicant("Смирнов", faculty);
        Applicant applicant4 = new Applicant("Сидоров", faculty_2);
        Applicant applicant5 = new Applicant("Борисов", faculty_2);
        Applicant applicant6 = new Applicant("Звягинцев", faculty);

        Teacher teacher = new Teacher();
        teacher.giveGrade(applicant1, 8.5);
        teacher.giveGrade(applicant2, 6.0);
        teacher.giveGrade(applicant3, 7.0);
        teacher.giveGrade(applicant4, 9.0);
        teacher.giveGrade(applicant5, 5.0);
        teacher.giveGrade(applicant6, 7.5);

        Applicant[] applicants = {
                applicant1,
                applicant2,
                applicant3,
                applicant4,
                applicant5,
                applicant6
        };

        double avg1 = faculty.getAverage(applicants);
        double avg2 = faculty_2.getAverage(applicants);


        faculty.admitApplicants(applicants);
        faculty_2.admitApplicants(applicants);

        System.out.println(
                "Проходной балл на факультет " + faculty.name
                + ": " + avg1
        );

        System.out.println(
                "Проходной балл на факультет " + faculty_2.name
                        + ": " + avg2
        );

        for (Applicant applicant : applicants) {
            if (applicant.admitted) {
                System.out.println(
                        applicant.name + ": зачислен на факультет "
                        + applicant.faculty.name + " | балл: "
                        + applicant.mark
                );
            } else {
                System.out.println(
                        applicant.name + ": не зачислен на факультет "
                                + applicant.faculty.name + " | балл: "
                                + applicant.mark
                );
            }
        }
    }
}
