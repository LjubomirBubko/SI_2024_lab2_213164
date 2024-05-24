import java.util.List;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
package com.example;

class Item {
    String name;
    String barcode; // numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment) {
        //Старт (1)
        if (allItems == null) { // Проверка дали allItems е null (2)
            throw new RuntimeException("allItems list can't be null!");
            // Точно: Фрли исклучок "allItems листата не може да биде null!" (3)
        }

        float sum = 0; // Иницијализирај sum на 0 (4)


        for (int i = 0; i < allItems.size(); i++) { // За секој item во allItems:(5)
            Item item = allItems.get(i);

            // Проверка дали item.getName() е null или празен: (6)
            if (item.getName() == null || item.getName().length() == 0) {
                // Точно: item.setName("unknown")(7)
                item.setName("unknown");
            } else {
                // Невистинито: Продолжи (8)
            }

            // Проверка дали item.getBarcode() не е null:(9)
            if (item.getBarcode() != null) {
                // Точно:
                // Проверка на секој карактер во item.getBarcode():(11)
                String allowed = "0123456789";
                char chars[] = item.getBarcode().toCharArray();
                for (int j = 0; j < item.getBarcode().length(); j++) {
                    char c = item.getBarcode().charAt(j);
                    // Ако било кој карактер е невалиден, фрли исклучок "Невалиден карактер во баркодот на предметот!"(12)
                    if (allowed.indexOf(c) == -1) {
                        throw new RuntimeException("Invalid character in item barcode!");
                    }
                }

                // Проверка дали item.getDiscount() > 0:(13)
                if (item.getDiscount() > 0) {
                    // Точно: Додај item.getPrice() * item.getDiscount() на sum(14)
                    sum += item.getPrice() * item.getDiscount();
                } else {
                    // Невистинито: Додај item.getPrice() на sum(15)
                    sum += item.getPrice();
                }
            } else {
                // Невистинито: Фрли исклучок "Нема баркод!"(10)
                throw new RuntimeException("No barcode!");
            }

            // Проверка дали item.getPrice() > 300, item.getDiscount() > 0, и item.getBarcode().charAt(0) == '0':(15)
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0') {
                // Точно: Одземи 30 од sum(16)
                sum -= 30;
            } else {
                // Невистинито: Продолжи(17)
            }
        }

        // Проверка дали sum <= payment:(18)
        if (sum <= payment) {
            // Точно: Врати true(19)
            return true;
        } else {
            // Невистинито: Врати false(20)
            return false;
        }
    }
}

public class SILab2Test {

    @Test
    public void testCheckCartNullItems()
    {
        try
        {
            SILab2.checkCart(null, 50);
            fail("Expected RuntimeException for null items");
        }
        catch (RuntimeException e)
        {
            assertEquals("allItems list can't be null!", e.getMessage());
        }
    }

    @Test
    public void testCheckCartEmptyList()
    {
        List<Item> items = new ArrayList<>();
        boolean result = SILab2.checkCart(items, 100);
        assertTrue(result);
    }

    @Test
    public void testCheckCartInvalidBarcode()
    {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "12a45", 100, 0));
        try
        {
            SILab2.checkCart(items, 100);
            fail("Expected RuntimeException for invalid barcode character");
        }
        catch (RuntimeException e)
        {
            assertEquals("Invalid character in item barcode!", e.getMessage());
        }
    }

    @Test
    public void testCheckCartNoBarcodeAndDiscountWithBarcodeStartsWith0()
    {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", null, 100, 0));
        items.add(new Item("Item2", "012345", 400, 0.1f));

        try {

            SILab2.checkCart(items, 100);
            fail("Expected RuntimeException for no barcode");
        }
        catch (RuntimeException e)
        {
            assertEquals("No barcode!", e.getMessage());
        }
    }

    @Test
    public void testCheckCartNoDiscount()
    {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "123456", 100, 0));
        boolean result = SILab2.checkCart(items, 100);
        assertTrue(result);
    }
}


