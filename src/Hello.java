public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, user");

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + ", ");
        }

//        for (String arg : args) {
//            System.out.print(arg + ", ");
//        }
    }
}
