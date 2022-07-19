import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // Из-за проблем с java окружением (при запуске через терминал ничего не проиходит и ничего не выводит)
        // Пришлось сделать выбор файла через консоль
        // Как должна была выглядеть команда запуска программы:
        // PS C:\krista-test> java .\Main.java C:\Code\krista-test\plants__001.xml
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
