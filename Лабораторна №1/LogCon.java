public class LogCon {

    private static boolean NOT(boolean a) {
        if (a == false) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean AND(boolean a, boolean b) {
        if (a == true && b == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean OR(boolean a, boolean b) {
        if (a == true || b == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean IMP(boolean a, boolean b) {
        if (a == false) {
            return true;
        } else if (b == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean XOR(boolean a, boolean b) {
        if (a == true && b == false) {
            return true;
        } else if (a == false && b == true) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean EQU(boolean a, boolean b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRow(boolean a, boolean b){
        return (a + "  " + b + "  " + LogCon.NOT(a) + "  " + LogCon.AND(a, b) + "  " + LogCon.OR(a, b) + "  " + LogCon.IMP(a, b) + "  " + LogCon.EQU(a, b) + "  " + LogCon.XOR(a, b));
    }

    public static boolean F17(boolean a, boolean b, boolean c){
        return EQU(AND(a, OR(NOT(b), NOT(c))), IMP(a,b));
    }
}
