import java.util.Scanner;

/**
 * Created by vmishev on 10/22/15.
 */
public class Points {

    private Scanner scanner, scanner2;
    private int x, y;
    private String directions;

    public Points() {
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        System.out.println("Starting point x: ");
        x = scanner.nextInt();
        System.out.println("Starting point y: ");
        y = scanner.nextInt();

        directions = scanner2.nextLine();
        char[] dirArr = directions.toCharArray();
        int tmp = 1;
        for (int i = 0; i < dirArr.length; i++) {
            switch (dirArr[i]) {
                case '~':
                    tmp *= (-1);
                    break;
                case '>':
                    x+=tmp;
                    break;
                case '<':
                    x-=tmp;
                    break;
                case 'v':
                    y+=tmp;
                    break;
                case '^':
                    y-=tmp;
                    break;
            }
        }
        System.out.println("(" + x + ", " + y +")");
    }
}
