package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nama, nim, kelas, bahasa, negaraAsal;
        int umur, nilai;

        Scanner input = new Scanner(System.in);
        MahasiswaInternasional mhsInter1 = null;

        while (true) {

            if (mhsInter1 == null) {
                System.out.println("Masukkan data mahasiswa baru");
                System.out.print("Masukkan Nama : ");
                nama = input.nextLine();

                System.out.print("Masukkan NIM  :");
                nim = input.nextLine();

                System.out.print("Kelas :");
                kelas = input.nextLine();

                System.out.print("Masukkan Umur :");
                umur = input.nextInt();

                input.nextLine();

                System.out.print("Masukkan Bahasa :");
                bahasa = input.nextLine();

                System.out.print("Masukkan Asal Negara :");
                negaraAsal = input.nextLine();

                mhsInter1 = new MahasiswaInternasional(nama, nim, kelas, umur, bahasa, negaraAsal);

                mhsInter1.perkenalan();
            }

            System.out.println("\n\nMenu cek nilai dan status visa mahasiswa ");
            System.out.println("===============================================");
            System.out.println("1. Cek Nilai");
            System.out.println("2. Cek Status Visa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (mhsInter1.getNilai() == -1) {
                        System.out.println("Nilai belum diinputkan, silahkan input nilai terlebih dahulu");
                        System.out.print("Masukkkan nilai (0-100) : ");
                        nilai = input.nextInt();
                        mhsInter1.setNilai(nilai);
                        System.out.println("================================");

                    }

                    if (mhsInter1.getNilai() >= 75) {
                        System.out.println("Mahasiswa LULUS");
                    } else if (mhsInter1.getNilai() >= 60) {
                        System.out.println("Remidial diperbolehkan");
                    } else {
                        System.out.println(
                                "Harus mengulang, diperbolehkan memperpanjang masa tinggal (kepulangan ditunda)");
                    }

                }
                case 2 -> {
                    if (mhsInter1.getStatusVisa()) {
                        System.out.println("Visa aktif, mahasiswa diizinkan tinggal");
                    } else if (!mhsInter1.getStatusVisa() && mhsInter1.getNilai() < 60) {
                        System.out.println("PERINGATAN : Mahasiswa harus mengulang dan segera memperpanjang visa !");
                    } else {
                        System.out.println("Visa tidak aktif, segera melakukan perpanjangan visa");
                    }

                    System.out.print("Apakah ingin menonaktifkan/ memperpanjang visa? (y/n) : ");
                    String opsiVisa = input.nextLine();
                    if (opsiVisa.equalsIgnoreCase("y")) {
                        mhsInter1.setStatusVisa(!mhsInter1.getStatusVisa());

                        System.out.println(mhsInter1.getStatusVisa() ? "Visa berhasil diperpanjang (Aktif)"
                                : "Visa dinonaktifkan (Tidak Aktif)");
                    }
                }
                case 3 -> {
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);
                }
                default -> throw new AssertionError();
            }
        }

    }
}