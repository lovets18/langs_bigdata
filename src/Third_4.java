// Класс Пациент
class Patient {
    String name;
    Doctor doctor;
    boolean discharged;

    String treatment;

    public Patient(String name, Doctor doctor) {
        this.name = name;
        this.doctor = doctor;
        this.discharged = false;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
        System.out.println("Пациент " + this.name + " выписан");
    }
}


// Класс Медсестра
class Medical {
    String name;

    public Medical(String name) {
        this.name = name;
    }
    public void performTreatment(Patient patient) {
        patient.treatment += " - done. |  ";
        System.out.println(
                "Пациенту " + patient.name + " выполнено назначение: " + patient.treatment
                        + " медсестрой " + this.name
        );
    }

    public void punish(Patient patient) {
        System.out.println(
                "Пациент " + patient.name + " наказан за нарушение режима медсестрой " + this.name
        );
        patient.setDischarged(true);
        patient.treatment = "go home";
    }
}

// Класс Врач
class Doctor extends Medical {

    public Doctor(String name) {
        super(name);
    }

    public void setHealthy(Patient patient) {
        System.out.println(
                "Пациент " + patient.name + " выписан"
                + " врачем " + this.name
        );
        patient.setDischarged(true);
        patient.treatment = "healthy";

    }
    
    public void prescribeTreatment(Patient patient, String treatment) {
        patient.treatment = treatment;
        System.out.println(
                "Пациенту " + patient.name + " выписано назначение: " + patient.treatment
                + " врачем " + this.name
        );
    }

    @Override
    public void performTreatment(Patient patient) {
        patient.treatment += " - done.  |  ";
        System.out.println(
                "Пациенту " + patient.name + " выполнено назначение: " + patient.treatment
                        + " врачем " + this.name
        );
    }

    @Override
    public void punish(Patient patient) {
        System.out.println(
                "Пациент " + patient.name + " наказан за нарушение режима врачем " + this.name
        );
        patient.setDischarged(true);
        patient.treatment = "go home";

    }
}



public class Third_4 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Иванов");
        Doctor doctor_2 = new Doctor("Сидоров");
        Patient patient = new Patient("Смирнов", doctor);
        Patient patient_2 = new Patient("Соколов", doctor_2);
        Medical nurse = new Medical("Борисова");

        doctor.prescribeTreatment(patient, "Лекарство А");
        doctor_2.prescribeTreatment(patient_2, "Лекарство Б");

        nurse.performTreatment(patient_2);
        doctor_2.performTreatment(patient);

        doctor.setHealthy(patient);
        nurse.punish(patient_2);
    }
}
