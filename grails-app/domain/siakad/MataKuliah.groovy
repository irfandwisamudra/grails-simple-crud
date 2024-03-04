package siakad

class MataKuliah {
    String kode
    String nama
    String deskripsi

    static belongsTo = [dosen: Dosen, ruang: Ruang, jam: Jam]

    static hasMany = [mahasiswa: Mahasiswa]

    static constraints = {
        kode unique: true
        nama nullable: false, maxSize: 100
        deskripsi nullable: true, maxSize: 255
    }

    String toString() {
        nama
    }
}
