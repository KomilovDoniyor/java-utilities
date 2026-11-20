package uz.startup.booking.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class JsonExample {
    //JSON - JavaScript Object Notation

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        JsonMapper mapper = JsonMapper
                .builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
//
//        Food food = new Food("Bread", 5000);
//        String json = mapper.writeValueAsString(food);
//        System.out.println(json);
//
//        String object = """
//                {
//                  "name" : "Lemon",
//                  "price" : 10000
//                }
//                """;
//        Food objectFood = mapper.readValue(object, Food.class);
//        System.out.println(objectFood.getName());
//
//        List<Food> foods = List.of(
//                new Food("Kiwi", 20000),
//                new Food("Ananas", 25000),
//                new Food("Orange", 15000)
//        );
//        String jsonList = mapper.writeValueAsString(foods);
//        System.out.println(jsonList);
//
//        List<Food> foodList = mapper.readValue(jsonList, new TypeReference<List<Food>>() {});
//        foodList.forEach(f -> System.out.println(f.getName()));

        Path path = Path.of("/Users/doniyor/Documents/JavaProjects/java-utilities/currency.json");
        File file = path.toFile();
        List<Currency> currencies = mapper.readValue(file, new TypeReference<>() {
        });

        boolean isSuccess = true;
        while (isSuccess) {
            for (int i = 0; i < currencies.size(); i++) {
                System.out.println((i + 1) + " :: " +
                        currencies.get(i).getNominal() + " - " +
                        currencies.get(i).getCcy() + " = " + currencies.get(i).getRate() + " UZS");
            }
            System.out.println("Qaysi konversiya turidan foydalanmoqchisiz? ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Qancha konversiya qilmoqchisiz? ");
                    double startPrice = scanner.nextDouble();
                    Currency currency = currencies.get(0);
                    double finalPrice = startPrice * Double.parseDouble(currency.getRate());
                    System.out.println(startPrice + "-" + currency.getCcy() + " = " + finalPrice + " UZS  Sana: " + currency.getDate());
                case 0:
                    isSuccess = false;
                    break;
            }
        }

    }
}
