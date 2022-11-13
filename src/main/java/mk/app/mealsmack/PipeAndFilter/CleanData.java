package mk.app.mealsmack.PipeAndFilter;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CleanData {
    public static void main(String[] args) {
        Pipe<String> pipe =new Pipe<>();
        RawDataFiler filter = new RawDataFiler();

        pipe.addFilter(filter);

        Scanner scanner = null;
        StringBuilder sb = new StringBuilder();
        try {
            scanner = new Scanner(new File("C:\\Users\\Sergey\\Desktop\\mealsmack\\src\\main\\resources\\static\\Opstini.csv"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()){
                sb.append(pipe.runFilters(scanner.nextLine())).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String []parts = sb.toString().trim().split("\n");

        for (String part : parts) {
            if (!part.startsWith(" "))
                System.out.println(part);

        }


        File file = new File("C:\\Users\\Sergey\\Desktop\\test.csv");
        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(parts[0].split(",",-1));

            for(int i = 1; i < parts.length; i++){
                writer.writeNext(parts[i].split(",",-1));
            }

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
