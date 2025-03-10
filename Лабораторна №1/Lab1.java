public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Таблиця істинності:");
        System.out.println("a     b     !a     a&b   a||b   a->b   a~b   a^b");
        boolean[] values = {true, false};
        for (boolean a : values) {
            for (boolean b : values) {
                System.out.print(LogCon.getRow(a, b));
                System.out.println();
            }
        }

        System.out.println("\nТаблиця істинності для F17(a, b, c):");
        System.out.println("a  b  c  F17(a, b, c)");
        for (boolean a : values) {
            for (boolean b : values) {
                for (boolean c : values) {
                    System.out.print(a + "  " + b + "  " + c + "  " + LogCon.F17(a, b, c));
                    System.out.println();
                }
            }
        }
    }
}