package models;

public class Helikopter extends KendaraanUdara{
    private int jumlahBalingBaling;

    public Helikopter(int kapasitasOrang, String nama, int jumlahBalingBaling){
        super(BahanBakar.AVTUR, kapasitasOrang, nama);
        this.jumlahBalingBaling = jumlahBalingBaling;
    }

    public int getJumlahBalingBaling(){
        return this.jumlahBalingBaling;
    }

    @Override
    public String getDetails(){
        return "Helikopter " + super.getDetails() + ", jumlah Baling baling: " + jumlahBalingBaling;
    }
}
