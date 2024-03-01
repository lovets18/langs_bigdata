
interface Building{
    void repair();
}

abstract class PublicBuilding implements Building{
    @Override
    public void repair() {
        System.out.println("Public building is being repaired");
    }

    public void close(){
        System.out.println("Public building is closed");
    }

    public void open(){
        System.out.println("Public building is open");
    }

    public abstract void activate();
}

class Theatre extends PublicBuilding{

    @Override
    public void repair() {
        System.out.println("Theatre is being repaired");
    }

    @Override
    public void close(){
        System.out.println("Theatre is closed");
    }
    @Override
    public void open() {
        System.out.println("Theatre is opened");
    }

    @Override
    public void activate() {
        System.out.println("The play is being shown");
    }

    public void antract(){
        System.out.println("The play is on pause");
    }
}


public class Fourth_2 {
    public static void main(String[] args) {
        Building build_1 = new Theatre();
        build_1.repair();

        PublicBuilding build_2 = new Theatre();
        build_2.repair();
        build_2.close();
        build_2.open();
        build_2.activate();

        Theatre build_3 = new Theatre();
        build_3.repair();
        build_3.close();
        build_3.open();
        build_3.activate();
        build_3.antract();

    }
}
