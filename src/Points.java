import java.util.Scanner;

/**
 * Created by vmishev on 10/22/15.
 */
public class Points {

    private Scanner scanner;
    private String num;
    private int x, y;
    private String directions;

    public Points() {
        scanner = new Scanner(System.in);

        inputNumber(x, scanner, "x");
        inputNumber(x, scanner, "y");

        directions = scanner.nextLine();
        char[] dirArr = directions.toCharArray();
        int tmp = 1;
        for (int i = 0; i < dirArr.length; i++) {
            switch (dirArr[i]) {
                case '~':
                    tmp *= (-1);
                    break;
                case '>':
                    x += tmp;
                    break;
                case '<':
                    x -= tmp;
                    break;
                case 'v':
                    y += tmp;
                    break;
                case '^':
                    y -= tmp;
                    break;
            }
        }
        System.out.println("(" + x + ", " + y +")");
    }
    private void inputNumber(int number, Scanner scanner, String name) {
        while(true) {
            try {
                System.out.println(name + ": ");
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch(Exception ex) {
                System.out.println("Not a number , Try Again");
            }
        }
    }
}
