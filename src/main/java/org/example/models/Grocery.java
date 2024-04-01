package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("0: Uygulamayı durdur");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    scanner.nextLine();
                    String toAdd = scanner.nextLine();
                    addItems(toAdd);
                    break;

                case 2:
                    System.out.println("Çıkarmak istediğiniz elemanları girin:");
                    scanner.nextLine();
                    String toRemove = scanner.nextLine();
                    removeItems(toRemove);
                    break;

                case 0:
                    System.out.println("Uygulama durduruldu.");
                    break;

                default:
                    System.out.println("Geçersiz seçenek.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(", ");
        for (String item : items) {
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(", ");
        for (String item : items) {
            if (groceryList.contains(item)) {
                groceryList.remove(item);
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static void printSorted() {
        System.out.println("Listenin Güncel Hali:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }


}
