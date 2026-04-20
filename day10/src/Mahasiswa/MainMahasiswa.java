package src.Mahasiswa;


public class MainMahasiswa {

    public static void main(String[] args) {
        MahasiswaInternasional mhsInter = new MahasiswaInternasional("Ryan", "123456", "A-1", 20, "Jerman", "Austria");

        System.out.println("Jurusan : " + mhsInter.jurusan);
        System.out.println("\n=====Mahasiswa Baru Perkenalan=====");
        mhsInter.perkenalan();
        mhsInter.aktivitas();
    }
}