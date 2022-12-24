package mk.app.mealsmack.PipeAndFilter;

import com.opencsv.CSVWriter;
import mk.app.mealsmack.model.Restaurant;
import mk.app.mealsmack.data.DataHolder;
import org.apache.commons.beanutils.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class CleanData {
    @PostConstruct
    public void create() {
        Pipe<String> pipe = new Pipe<>();
        RawDataFiler filter = new RawDataFiler();

        pipe.addFilter(filter);

        Scanner dataScanner = null;
        StringBuilder sb = new StringBuilder();

        try {
            dataScanner = new Scanner(new File("C:\\Users\\Sergey\\Desktop\\DIANS\\mealsmack\\src\\main\\resources\\static\\Data.csv"));
            dataScanner.useDelimiter(",");

            while (dataScanner.hasNextLine()){
                sb.append(pipe.runFilters(dataScanner.nextLine())).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String []parts = sb.toString().trim().split("\n");


        for (String part : parts) {
            String []data = part.split("\\,",-1);
            List<String> cuisines = new ArrayList<>();
            String []cuisine = data[5].split(";");
            cuisines.addAll(Arrays.asList(cuisine));

            DataHolder.restaurants.add(new Restaurant(data[1], data[2], data[3],data[4],cuisines,data[6]));
        }


/*
        Scanner scanner = null;
        StringBuilder sb = new StringBuilder();
        try {
            scanner = new Scanner(new File("C:\\Users\\Sergey\\Desktop\\DIANS\\mealsmack\\src\\main\\resources\\static\\Opstini.csv"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()){
                sb.append(pipe.runFilters(scanner.nextLine())).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String []parts = sb.toString().trim().split("\n");*/

        /*for (String part : parts) {
            if (!part.startsWith(" "))
                System.out.println(part);

        }*/

/*
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
        }*/

    }





}
