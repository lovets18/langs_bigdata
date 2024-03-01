import java.util.Arrays;
import java.util.List;

interface Employer {

    void work();
}

class Engineer implements Employer{

    @Override
    public void work() {
        System.out.println("Engineer is working");
    }

    public void checkScheme(){
        System.out.println("Engineer is checking scheme");
    }
}

class Manager extends Engineer{
    @Override
    public void work() {
        System.out.println("Manager is working");
    }

    @Override
    public void checkScheme() {
        System.out.println("Manager is checking scheme");
    }

    public void createTask(){
        System.out.println("Manager is creating a task");
    }
}



public class Third_2 {
    public static void main(String[] args) {
        Employer engineer = new Engineer();
        Employer manager = new Manager();

        List<Employer> employers = Arrays.asList(engineer, manager);
        for (Employer emp : employers) {
            emp.work();
        }


        Engineer engineer_1 = new Engineer();
        Engineer manager_1 = new Manager();

        List<Engineer> employers_1 = Arrays.asList(engineer_1, manager_1);
        for (Engineer emp : employers_1) {
            emp.checkScheme();
        }

        Manager manager_2 = new Manager();
        manager_2.createTask();

    }
}
