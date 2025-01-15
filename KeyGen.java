import java.util.Scanner;

public class KeyGen {

    public static void main(String[] args) {

        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        char[] chars = username.toCharArray();

        int hash1 = 0;

        for (char var7 : chars) {

            int var33 = var7 % 101;
            var33 += var7 >>> 10;
            var33 += var7 << 5;
            var33 += var7 >>> 6;
            var33 += var7 << 7;
            var33 += var7 << 13;
            hash1 += var33;

        }

        int hash2 = -559038737 - hash1;

        if (hash2 < 0) {
            hash2 = -hash2;
        }

        String var26 = createKey(hash2);

        System.out.println("Password: " + var26);

    }

    public static String createKey(int hash) {
        char[] var2 = new char[33];
        int var4 = 32;
        hash = -hash;
        while (hash <= -16) {
            var2[var4--] = a[-(hash % 16)];
            hash /= 16;
        }
        var2[var4] = a[-hash];
        return new String(var2, var4, 33 - var4);
    }

    static char[] a = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();


}
