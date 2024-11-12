package FileService;

import Entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private List<Product> products = new ArrayList<>();

    public class FileService {
        private List<Product> products = new ArrayList<>();

        public List<Product> readFile(String fileInPath) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(";");
                    if (data.length == 5) {
                        int productID = Integer.parseInt(data[0]);
                        String click = data[1];
                        int addToCart = Integer.parseInt(data[2]);
                        int checkOut = Integer.parseInt(data[3]);

                        LocalDate dateTime = LocalDate.parse(data[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                        Product product = new Product(productID, click, addToCart, checkOut, dateTime);
                        products.add(product);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }
}