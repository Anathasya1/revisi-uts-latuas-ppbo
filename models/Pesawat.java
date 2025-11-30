package models;

public class Pesawat extends KendaraanUdara implements Kargoable{
    private int jumlahRoda;
    private boolean pesawatTempur;
    public Pesawat(int kapasitasOrang, String nama, int jumlahRoda, boolean pesawatTempur){
        super(BahanBakar.AVTUR, kapasitasOrang, nama);
        this.jumlahRoda = jumlahRoda;
        this.pesawatTempur = pesawatTempur;
    }

    public int getJumlahRoda(){
        return jumlahRoda;
    }

    public boolean isPesawatTempur(){
        return this.pesawatTempur;
    }

    @Override 
    public String getDetails(){
        return "Pesawat " + super.getDetails() + ", jumlah roda: " + jumlahRoda;
    }

    @Override
    public void loadKargo(){
        System.out.println("Pesawar memasukkan kargo");
    }
    @Override
    public void unloadKargo(){
        System.out.println("Pesawat tidak memasukan kargo");
    }
}
