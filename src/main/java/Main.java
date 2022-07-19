import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // args[0]="plants__001.xml";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь до файла:");
        String str = sc.nextLine();
        File file = new File(str);
        ArrayList<Plant> plants = new ArrayList<>();
        Catalog catalog = XMLParser.parse(file, plants);
        DBWriter.write(catalog);
    }
}
