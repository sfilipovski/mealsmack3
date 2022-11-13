package mk.app.mealsmack.PipeAndFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CleanData {
    public static void main(String[] args) {
        Pipe<String> pipe =new Pipe<>();
        RawDataFiler filter = new RawDataFiler();

        pipe.addFilter(filter);

        Scanner scanner = null;
        String s="";
        try {
            scanner = new Scanner(new File("C:\\Users\\Sergey\\Desktop\\mealsmack\\src\\main\\resources\\static\\Butel.csv"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()){
                s+=pipe.runFilters(scanner.nextLine());
                s+="\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(s.trim());
        }


}
