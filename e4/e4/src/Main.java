import Entity.Product;
import FileService.FileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sysPath = System.getProperty("user.dir");

        String fileInPath = sysPath.replace("/", "\\") + "\\data\\product.in.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "\\data\\product.out.txt";

        FileService fileService = new FileService();

        List<Product> products = fileService.readFile(fileInPath);

        List<String> outputLines = new ArrayList<>();
        for (Product product : products) {
            String outputLine = product.getProductID() + ";" + product.getAddToCart() + "/" + product.getCheckOut();
            outputLines.add(outputLine);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutPath))) {
            for (String line : outputLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Đã ghi kết quả vào tệp: " + fileOutPath);
    }
}