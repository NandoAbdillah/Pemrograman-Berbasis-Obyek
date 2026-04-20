package src.Dosen;

import src.Mahasiswa.MahasiswaInternasional;

public class MainDosen {
    public static void main(String[] args) {
          MahasiswaInternasional mhsInter = new MahasiswaInternasional("Ryan", "123456", "A-1", 20, "Jerman", "Austria");

        System.out.println("Jurusan " + mhsInter.jurusan);
        mhsInter.perkenalan();
    }
}
