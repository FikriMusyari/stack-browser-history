package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.Scanner;

public class Main {
    private static final Stack<String> History = new Stack<>();

    // Fungsi untuk menampilkan History Browser
    public static void view() {
        if (History.isEmpty()) {
            System.out.println("Browser History Kosong");
        } else {
            for (int i = History.size() - 1; i >= 0; i--) {
                System.out.println(History.get(i));
            }
        }
    }

    // Fungsi untuk menambahkan situs ke dalam History
    public static void browse(String url) {
        History.push(url);
        System.out.println("Anda telah mengunjungi: " + url);
    }

    // Fungsi untuk kembali ke situs sebelumnya
    public static void back() {
        if (!History.isEmpty()) {
            String situsTerakhir = History.pop();
            System.out.println("Anda kembali dari: " + situsTerakhir);
        } else {
            System.out.println("Tidak ada History untuk kembali.");
        }
    }

    // Fungsi untuk menampilkan menu
    public static void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. Kunjungi situs web");
            System.out.println("2. Tampilkan History Browser");
            System.out.println("3. Kembali ke situs sebelumnya");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan URL dari situs yang ingin Anda kunjungi: ");
                    String url = input.nextLine();
                    browse(url);
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    back();
                    break;
                case 4:
                    System.out.println("Keluar dari aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan salah. Coba lagi.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}