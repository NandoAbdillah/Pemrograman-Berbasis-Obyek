package src;

public class Mahasiswa {
    public String nama;
    public String nim;
    public String kelas;
    public int umur;
    public int nilai;


    public Mahasiswa(String nama, String nim, String kelas, int umur) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.umur = umur;
        this.nilai = -1;
    }

    public void perkenalan() {
        System.out.println("Nama saya adalah " + nama);
        System.out.println("saya dari kelas " + kelas);
        System.out.println("saya berumur " + umur + " tahun");
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }


    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public int getUmur() {
        return umur;
    }

    public int getNilai() {
        return nilai;
    }

    
}