package goid.kotajambi.aplikasi_pembelajaran_biologi.model;




public class model_vidio {

    public String getNama_materi() {
        return nama_materi;
    }

    public void setNama_materi(String nama_materi) {
        this.nama_materi = nama_materi;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getId_materi() {
        return id_materi;
    }

    public void setId_materi(int id_materi) {
        this.id_materi = id_materi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String nama_materi;
    String file;
    int id_materi;
    int image;

    public model_vidio(String nama_materi, String file, int id_materi, int image) {
        this.nama_materi = nama_materi;
        this.file = file;
        this.id_materi = id_materi;
        this.image=image;
    }


}
