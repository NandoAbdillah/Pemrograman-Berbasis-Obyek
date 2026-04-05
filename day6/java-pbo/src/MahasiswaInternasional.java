package src;

public class MahasiswaInternasional extends Mahasiswa{

    public String bahasa;
    public String negaraAsal;
    public boolean  statusVisa;
    

    public MahasiswaInternasional(String nama, String nim, String kelas, int umur, String bahasa, String negaraAsal) {
        super(nama, nim , kelas, umur);
        this.bahasa = bahasa;
        this.negaraAsal = negaraAsal;
        this.statusVisa = true;
    }

    @Override
    public void perkenalan() {
        super.perkenalan();
        System.out.println("Bahasa yang saya gunakan adalah " + bahasa);
        System.out.println("Negara Asal saya adalah " + negaraAsal);
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }
    public void setNegaraAsal(String negaraAsal) {
        this.negaraAsal = negaraAsal;
    } 

    public void setStatusVisa(boolean statusVisa) {
        this.statusVisa = statusVisa;
    }


    public String getBahasa() {
        return bahasa;
    }

    public String getNegaraAsal() {
        return negaraAsal;
    }


    public void inactivateVisa() {
        this.statusVisa = false;
    }

    public boolean  getStatusVisa() {
        return statusVisa;
    }

}
