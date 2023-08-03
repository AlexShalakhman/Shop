package task.Task.dao;

import task.Task.data.Product;
import task.Task.data.ProductDescription;
import task.Task.UI.EnumUI.ProductType;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class ProductDao {
    private static final Path DB_PATH = Path.of("Task/DataBase/product_table.txt");


    public static Product findProductByName(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 5) {
                    String productName = columns[1].trim();
                    if (productName.contains(name)) {
                        int id = Integer.parseInt(columns[0].trim());
                        String type = columns[2].trim();
                        double price = Double.parseDouble(columns[4].trim());

                        return new Product(id, productName, new ProductDescription(type), price);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean addNewProductToFile(String name, String type, String quantity, String price) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_PATH.toFile(), true))) {
            int newId = 1; // Default initial ID

            List<String> lines = Files.readAllLines(Path.of(DB_PATH.toString()));
            if (!lines.isEmpty()) {
                String previousLine = lines.get(lines.size() - 1);
                String[] lineValues = previousLine.split(",");
                int previousId = Integer.parseInt(lineValues[0].trim());
                newId = previousId + 1;
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(newId).append(",")
                    .append(name).append(",")
                    .append(type).append(",")
                    .append(quantity).append(",")
                    .append(price);

            writer.write(stringBuilder.toString());
            writer.newLine();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static List<Product> initializeProduct() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 5) {
                    int id = Integer.parseInt(columns[0].trim());
                    String name = columns[1].trim();
                    String type = columns[2].trim();
                    double price = Double.parseDouble(columns[4].trim());

                    Product product = new Product(id, name, new ProductDescription(type), price);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
    public void printProductsByTypeUsingString(String productType) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 3 && columns[2].trim().equalsIgnoreCase(productType)) {
                    int id = Integer.parseInt(columns[0].trim());
                    String name = columns[1].trim();
                    double price = Double.parseDouble(columns[4].trim());

                    Product product = new Product(id, name, new ProductDescription(productType.replace(" ", "_")), price);
                    System.out.println(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printProductsByType(ProductType productType) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()));
            String line;
        while ((line = reader.readLine()) != null) {
            String[] lineValues = line.split(",");
            if (lineValues[2].equalsIgnoreCase(productType.getLabel())) {
                System.out.println(lineValues[1] + ", " + lineValues[3] + " items available, " + lineValues[4] + " CAD per item");
            }
        }
        return null;
    }



}
