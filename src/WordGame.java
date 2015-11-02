import java.util.Scanner;
import java.util.Vector;

/**
 * Created by vmishev on 10/31/15.
 */
public class WordGame {

    private Scanner scanner;
    int x, y, tmp = 0;
    private String word;
    private char[][] table;
    private Vector<Character>[] wordsVector;

    public WordGame() {
        scanner = new Scanner(System.in);
        System.out.println("word: ");
        word = scanner.nextLine();

        System.out.println("x: ");
        x = scanner.nextInt();

        System.out.println("y: ");
        y = scanner.nextInt();

        table = new char[y][x];
        wordsVector = new Vector[2*(x+y)-1];

        for (int i = 0; i < wordsVector.length; i++) wordsVector[i] = new Vector<>(); //init

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                table[i][j] = scanner.next().charAt(0);
                wordsVector[x + getOppositeOf(i - j)].add(table[i][j]); //diagonals
                wordsVector[x + y - 1 + i].add(table[i][j]); //horizontals
                wordsVector[x + 2 * y - 1 + j].add(table[i][j]); //verticals
            }
        }

        for (int i = 0; i < wordsVector.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < wordsVector[i].size(); j++) {
                builder.append(wordsVector[i].get(j));
            }
            if (builder.toString().length() >= word.length() && (builder.toString().contains(word) || builder.toString().contains(new
            StringBuffer(word).reverse().toString()))) tmp++;
        }

        System.out.println(tmp);
    }
    private int getOppositeOf(int a) {return -a;}
}
