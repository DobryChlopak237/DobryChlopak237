package Test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Zadanie 01:
//wypisz wszystkie liczby 3 cyfrowe ktorych suma cyfr dziesiatek i setek jest rowna cyfrze jednosci. np: 314 bo 3+1=4
//
//Zadanie 02:
//dla każdej liczby dwucyfrowej wypisz jej ilosc dzielników.
//
//Zadanie 03:
//Poproś użytkownika o podanie 10ciu !roznych! napisów.
//Wpisz je wszystkie do tablicy a następnie:
//        - wypisz najdłuższy napis i ile ma znaków.
//- wypisz najkrótszy napis i ile ma znaków.
//- wypisz ile jest palindromów wśród napisów.
// (palindrom to taki wyraz czytany od tyłu jest taki sam jak czytany od przodu np: kajak) [podczas porownania ignoruj wielkosc liter]
//
//Zadanie 04:
//Zapytaj użytkownika o liczby rozdzielone spacją, następnie:
//        - wypisz medianę wprowadzonych liczb.
//        - wypisz liczbę z największą ilością dzielników.
//        - wypisz wszystkie liczby pierwsze.
//
//
//za co mozna niezaliczyc testu:
//        - za liczenie mediany w pętli
//- za brak weryfikacji czy wprowadzone w zadaniu 3 napisy są różne.


        Scanner scanner = new Scanner(System.in);

//Zadanie 1:

        System.out.println("Zadanie 1:");
        for (int i = 100; i < 1000; i++) {
            int setki = i / 100;
            int dziesiatki = (i / 10) % 10;
            int jednosci = i % 10;
            if (setki + dziesiatki == jednosci) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

//Zadanie 2:

        System.out.println("Zadanie 2:");
        for (int i = 10; i < 100; i++) {
            int dzielniki = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    dzielniki++;
                }
            }
            System.out.println("Liczba dzielników dla liczby " + i + " to: " + dzielniki);
        }
        System.out.println();

//Zadanie 3:
        System.out.println("Zadanie 3:");
        ArrayList<String> napisy = new ArrayList<>();
        while (napisy.size() < 10) {
            System.out.println("Podaj napis: ");
            String napis = scanner.nextLine();
            if (!napisy.contains(napis)) {
                napisy.add(napis);
            } else {
                System.out.println("To slowo juz istnieje! Napisz inne slowo.");
            }
        }

        String najdluzszyNapis = napisy.get(0);
        String najkrotszyNapis = napisy.get(0);
        int licznikPalindromow = 0;

        for (String napis : napisy) {
            if (napis.length() > najdluzszyNapis.length()) {
                najdluzszyNapis = napis;
            }
            if (napis.length() < najkrotszyNapis.length()) {
                najkrotszyNapis = napis;
            }
            String odwroconynapis = new StringBuilder(napis.toLowerCase()).reverse().toString();
            if (napis.toLowerCase().equals(odwroconynapis)) {
                licznikPalindromow++;
            }
        }

        System.out.println("Najdłuższy napis: \"" + najdluzszyNapis + "\" (" + najdluzszyNapis.length() + " znaków)");
        System.out.println("Najkrótszy napis: \"" + najkrotszyNapis + "\" (" + najkrotszyNapis.length() + " znaków)");
        System.out.println("Liczba palindromów: " + licznikPalindromow);

//Zadanie 4:
        System.out.println("Zadanie 4: Podaj liczby odzielajac je spacja:");
        String input = scanner.nextLine();
        String[] liczbyStr = input.split(" ");
        ArrayList<Integer> liczby = new ArrayList<>();

        for (String liczba : liczbyStr) {
            liczby.add(Integer.parseInt(liczba));
        }

        liczby.sort(null);

        double mediana;
        int n = liczby.size();
        if (n % 2 == 0) {
            mediana = (liczby.get(n / 2 - 1) + liczby.get(n / 2)) / 2.0;
        } else {
            mediana = liczby.get(n / 2);
        }
        System.out.println("Mediana: " + mediana);

        int maxDzielniki = 0;
        int liczbaMaxDzielniki = liczby.get(0);
        for (int liczba : liczby) {
            int dzielniki = 0;
            for (int i = 1; i <= liczba ; i++) {
                if (liczba % i == 0) {
                    dzielniki++;
                }
            }
            if (dzielniki > maxDzielniki) {
                maxDzielniki = dzielniki;
                liczbaMaxDzielniki = liczba;
            }
        }
        System.out.println("Liczba z najwieksza iloscia dzielników: " + liczbaMaxDzielniki + "(liczba dzielników: " + maxDzielniki + ")");

        System.out.println("Liczby pierwsze:");
        for (int liczba : liczby) {
            boolean pierwsza = liczba > 1;
            for (int i = 2; i <= Math.sqrt(liczba) ; i++) {
                if (liczba % i == 0) {
                    pierwsza = false;
                    break;
                }
            }
            if (pierwsza) {
                System.out.print(liczba + " ");
            }
        }
        scanner.close();
    }
}
















































