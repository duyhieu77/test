import Entity.Customer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Read data in file
        String sysPath = System.getProperty("user.dir");

        String fileInPath = sysPath.replace("/", "\\") + "/data/customer.in.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "/data/customer.out.txt";
        List<Customer> customers = new ArrayList<>();

        // Reading data from file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath))) {
            String lineData;
            while ((lineData = bufferedReader.readLine()) != null) {
                if (!lineData.isEmpty()) {
                    String[] arData = lineData.split(";");
                    Customer customer = new Customer();
                    customer.setId(Integer.parseInt(arData[0]));
                    customer.setCode(arData[1]);
                    customer.setName(arData[2]);
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Sort and display
        Set<Customer> setCustomer = customers.stream()
                .sorted(Comparator.comparing(Customer::getName, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .collect(Collectors.toSet());
        setCustomer.forEach(c -> System.out.println(c.toString("~")));

        // Write data to file
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath))) {
            setCustomer.stream()
                    .forEach(c -> {
                        try {
                            String line2Write = c.toString(":=:");
                            bufferedWriter.write(line2Write);
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}