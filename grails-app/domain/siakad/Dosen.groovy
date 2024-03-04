package siakad

class Dosen {
    String nidn
    String nama
    String alamat
    String email

    static hasMany = [mataKuliah: MataKuliah]

    static constraints = {
        nidn unique: true
        nama nullable: false, maxSize: 100
        alamat nullable: false, maxSize: 255
        email nullable: false, email: true, maxSize: 100
    }

    String toString() {
        nama
    }
}
