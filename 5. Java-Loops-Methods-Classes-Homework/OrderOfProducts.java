import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderOfProducts {
    public static void main(String[] args) throws IOException {
        try {
            FileReader inputReader = new FileReader("orderProducts_input.txt");
            BufferedReader productsReader = new BufferedReader(inputReader);
            ArrayList<Product> products = new ArrayList<>();

            String productsLine = productsReader.readLine();
            while (productsLine != null) {
                String[] splitLine = productsLine.split(" ");
                String name = splitLine[0];
                BigDecimal price = new BigDecimal(splitLine[1]);

                Product currentProduct = new Product(price, name);
                products.add(currentProduct);

                productsLine = productsReader.readLine();
            }

            FileReader orderReader = new FileReader("orderProducts_order.txt");
            BufferedReader ordersReader = new BufferedReader(orderReader);

            BigDecimal totalPrice = BigDecimal.ZERO;

            String ordersLine = ordersReader.readLine();
            while (ordersLine != null) {
                String[] splitLine = ordersLine.split(" ");
                BigDecimal quantity = new BigDecimal(splitLine[0]);
                String currentProduct = splitLine[1];

                for (Product product : products) {
                    if (product.getName().equals(currentProduct)) {
                        BigDecimal currentPrice = (product.getPrice().multiply(quantity));
                        totalPrice = totalPrice.add(currentPrice);
                    }
                }

                ordersLine = ordersReader.readLine();
            }

            File outputWriter = new File("orderProducts_output.txt");
            PrintStream writer = new PrintStream(outputWriter);

            writer.println(String.format("%.1f", totalPrice));

            productsReader.close();
            ordersReader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
