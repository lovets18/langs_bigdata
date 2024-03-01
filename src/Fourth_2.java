import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class HashName{
    String name;
    int code;

    HashName(String name){
        this.name = name;
        this.code = this.name.hashCode();
    }

    @Override
    public String toString() {
        return "{" + name + ", " + code + '}';
    }
}

class ListNames{

    LinkedList<HashName> names;

    public void append(String name){
        System.out.println(name);
        HashName new_name = new HashName(name);
        int i = 0;
        if (names.isEmpty()){
            this.names.add(new_name);
            System.out.println("\tadded");
        }
        else {
            boolean bigger_previous = true;
            for (HashName cur : names) {
                if (new_name.code < cur.code) {
                    this.names.add(i, new_name);
                    System.out.println("\tadded");
                    return;
                }
                i++;
            }
            this.names.add(new_name);
            System.out.println("\tadded");
        }
    }

    ListNames(){
        this.names = new LinkedList<>();;
    }
    ListNames(String filename){
        this.names = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
//                System.out.println(line);
                this.append(line);
            }

//            System.out.println(names);
//            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void compress(){
        ListNames compressed = new ListNames();
        HashName previous = names.getFirst();
        for (HashName cur : names) {
            if (cur.code != previous.code) {
                compressed.append(previous.name);
                previous = cur;
            }

        }
        compressed.append(names.getLast().name);
        this.names = compressed.names;
    }
}

public class Fourth_2 {
    public static void main(String[] args) {
//        ListNames reader = new ListNames();
//        LinkedList<String> a = new LinkedList<>(reader.readNames("names.txt"));
        ListNames entity = new ListNames("names.txt");
        System.out.println(entity.names);
        entity.compress();
        System.out.println(entity.names);
    }
}
