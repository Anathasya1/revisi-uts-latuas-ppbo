package views;

import Exceptions.InvalidInputException;
import controllers.KendaraanController;
import models.BahanBakar;
import models.Helikopter;
import models.Kendaraan;
import models.Mobil;
import models.Pesawat;
import models.Truk;
import util.CLIUtil;

public class KendaraanView {
    private KendaraanController kendaraanController;

    public KendaraanView() {
        this.kendaraanController = new KendaraanController();
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah kendaraan");
        System.out.println("2. Tampilkan semua kendaraan");
        System.out.println("3. Urutkan kendaraan berdasarkan kapasitas");
        System.out.println("0. Keluar");
    }

    public void render() {
        int menu = -1;
        while (menu != 0) {
            this.printMenu();
            System.out.println("Pilihan menu utama: ");
            menu = CLIUtil.getInt();
            switch (menu) {
                case 1:
                    System.out.print("Tipe kendaraan: 1 = Mobil, 2 = Truk, 3 = Helikopter, 4 = Pesawat \nMasukkan Tipe Kendaraan: ");
                    int tipe = CLIUtil.getInt();
                    handleTambahKendaraan(tipe);
                    break;
                case 2:
                    handlePrintKendaraan();
                    break;
                case 3:
                    handleSortKendaraan();
                    break;

                default:
                    break;
            }
        }

    }

    private void handleTambahKendaraan(int tipe) {
        if (tipe == 0) {
            System.out.println("Batal nambahin");
            return;
        }
        if (tipe > 4 || tipe < 1) {
            System.out.println("tipe kendaraan tidak valid");
            return;
        } 

        CLIUtil.getString();
        System.out.print("Masukkan nama kendaraan: ");
        String nama = CLIUtil.getString();

        try {
            Kendaraan kendaraanBaru = null;
            if (nama.isEmpty()) {
                throw new InvalidInputException("Nama tidak boleh kosong");
            }
            switch (tipe) {
                case 1:
                    int bahanBakarIndex = CLIUtil.askForInt("Masukkan tipe bahan bakar mobil: 1 = bensin, 2 = diesel");
                    BahanBakar bahanBakar;
                    if (bahanBakarIndex == 1) {
                        bahanBakar = BahanBakar.BENSIN;
                    } else if (bahanBakarIndex == 2) {
                        bahanBakar = BahanBakar.DIESEL;
                    } else {
                        System.out.println("Tipe bahan bakar tidak valid");
                        return;
                    }

                    int kapasitas = CLIUtil.askForInt("Masukkan kapasitas mobil: ");
                    if (kapasitas <= 0) {
                        throw new InvalidInputException("Kapasitas tidak boleh negatif dan nol");
                    }

                    kendaraanBaru = new Mobil(bahanBakar, kapasitas, nama);
                    break;

                case 2:
                    int jumlahRoda = CLIUtil.askForInt("Masukkan jumlah roda truk: ");
                    if (jumlahRoda < 4) {
                        throw new InvalidInputException("jumlah roda truk minimal 4");
                    }
                    kendaraanBaru = new Truk(nama, jumlahRoda);
                    break;

                case 3:
                    int kapasitasHeli = CLIUtil.askForInt("Masukkan kapasitas heli: ");
                    int jumlahBalingBaling = CLIUtil.askForInt("Masukkan jumlah baling-baling heli: ");
                    if (kapasitasHeli <= 0 || jumlahBalingBaling <=0) {
                        throw new InvalidInputException("Jumlah tidak boleh nol dan negatif");
                    }
                    kendaraanBaru = new Helikopter(kapasitasHeli, nama, jumlahBalingBaling);
                    break;
                case 4:
                    int kapasitasPesawat = CLIUtil.askForInt("Masukkan kapasitas pesawat: ");
                    int jumlahRodaPesawat = CLIUtil.askForInt("Masukkan jumlah roda pesawat: ");
                    int indeksPesawatTempur = CLIUtil.askForInt("Apakah pesawat tempur? 0 = tidak, lainnya = ya");
                    boolean pesawatTempur = indeksPesawatTempur == 0 ? false : true;
                    if (kapasitasPesawat <= 0 || jumlahRodaPesawat <=0) {
                        throw new InvalidInputException("Jumlah tidak boleh nol dan negatif");
                    }

                    kendaraanBaru = new Pesawat(kapasitasPesawat, nama, jumlahRodaPesawat, pesawatTempur);
                    break;

                default:
                    break;
            }
            if (kendaraanBaru != null) {
                this.kendaraanController.addKendaraan(kendaraanBaru);
            }
        } catch (InvalidInputException e) {
            System.out.println("gagal " + e.getMessage());
        }

    }


    //ini yang ngelanggar tadi sebelum revisi
    // private void handleTambahKendaraan(int tipe) {
    //     if (tipe == 0) {
    //         System.out.println("Batal nambahin");
    //         return;
    //     }
    //     if (tipe > 4 || tipe < 1) {
    //         System.out.println("tipe kendaraan tidak valid");
    //         return;
    //     } 

    //     CLIUtil.getString();
    //     System.out.print("Masukkan nama kendaraan: ");
    //     String nama = CLIUtil.getString();

    //     try {
    //         switch (tipe) {
    //             case 1:
    //                 int bahanBakarIndex = CLIUtil.askForInt("Masukkan tipe bahan bakar mobil: 1 = bensin, 2 = diesel");
    //                 BahanBakar bahanBakar;
    //                 if (bahanBakarIndex == 1) {
    //                     bahanBakar = BahanBakar.BENSIN;
    //                 } else if (bahanBakarIndex == 2) {
    //                     bahanBakar = BahanBakar.DIESEL;
    //                 } else {
    //                     System.out.println("Tipe bahan bakar tidak valid");
    //                     return;
    //                 }
    //                 int kapasitas = CLIUtil.askForInt("Masukkan kapasitas mobil: ");
    //                 this.kendaraanController.add(bahanBakar, kapasitas, nama);
    //                 break;
    //             case 2:
    //                 int jumlahRoda = CLIUtil.askForInt("Masukkan jumlah roda truk: ");
    //                 this.kendaraanController.add(nama, jumlahRoda);
    //                 break;
    //             case 3:
    //                 int kapasitasHeli = CLIUtil.askForInt("Masukkan kapasitas heli: ");
    //                 int jumlahBalingBaling = CLIUtil.askForInt("Masukkan jumlah baling-baling heli: ");
    //                 this.kendaraanController.add(kapasitasHeli, nama, jumlahBalingBaling);
    //                 break;
    //             case 4:
    //                 int kapasitasPesawat = CLIUtil.askForInt("Masukkan kapasitas pesawat: ");
    //                 int jumlahRodaPesawat = CLIUtil.askForInt("Masukkan jumlah roda pesawat: ");
    //                 int indeksPesawatTempur = CLIUtil.askForInt("Apakah pesawat tempur? 0 = tidak, lainnya = ya");
    //                 boolean pesawatTempur = indeksPesawatTempur == 0 ? false : true;
    //                 this.kendaraanController.add(kapasitasPesawat, nama, jumlahRodaPesawat, pesawatTempur);
    //                 break;

    //             default:
    //                 break;
    //         }
    //     } catch (InvalidInputException e) {
    //         System.out.println("gagal " + e.getMessage());
    //     }

    // }

    private void handlePrintKendaraan() {
        var objects = this.kendaraanController.getAllKendaraan();
        for (Kendaraan kendaraan : objects) {
            System.out.println(kendaraan.getDetails());
        }
    }

    private void handleSortKendaraan() {
        this.kendaraanController.sortByKapasitas();
        System.out.println("Kendaraan telah diurutkan");
        handlePrintKendaraan();
    }
}
