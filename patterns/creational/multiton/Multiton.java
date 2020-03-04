package patterns.creational.multiton;


import java.util.HashMap;

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer {
    private static int instanceCount = 0;

    private Printer() {
        instanceCount++;
        System.out.println("A total of " +
                instanceCount + " instances created so far.");
    }

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        }

        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }
}

public class Multiton {
    public static void main(String[] args) {
        Printer primary = Printer.get(Subsystem.PRIMARY);
        Printer auxiliary1 = Printer.get(Subsystem.AUXILIARY);
        Printer auxiliary2 = Printer.get(Subsystem.AUXILIARY);
        Printer auxiliary3 = Printer.get(Subsystem.AUXILIARY);
        Printer auxiliary4 = Printer.get(Subsystem.AUXILIARY);
        Printer fallback = Printer.get(Subsystem.FALLBACK);

        System.out.println("\nprimary     == auxiliary1 ? : " + (primary == auxiliary1));
        System.out.println("auxiliary1  == auxiliary2 ? : " + (auxiliary1 == auxiliary2));
        System.out.println("auxiliary1  == auxiliary3 ? : " + (auxiliary1 == auxiliary2));
        System.out.println("auxiliary2  == auxiliary4 ? : " + (auxiliary2 == auxiliary4));
        System.out.println("fallback    == auxiliary3 ? : " + (fallback == auxiliary3));
        System.out.println("primary     == fallback   ? : " + (primary == fallback));

    }
}
