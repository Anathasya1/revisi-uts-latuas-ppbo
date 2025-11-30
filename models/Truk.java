package models;

public class Truk extends KendaraanDarat implements Kargoable{
    public Truk(String nama, int jumlahRoda){
        super(BahanBakar.DIESEL, 3, nama, jumlahRoda);
    }

    @Override
    public String getDetails(){
        return "Truk " + super.getDetails();
    }

    @Override
    public void loadKargo(){
        System.out.println("Tidak memasukan kargo");
    }
    @Override
    public void unloadKargo(){
        System.out.println("Truk mengeluarkan kargo");
    }
}
