package siakad

class Ruang {
    String nama
    String lokasi

    static hasMany = [mataKuliah: MataKuliah]

    static constraints = {
        nama nullable: false, maxSize: 100
        lokasi nullable: false, maxSize: 100
    }

    String toString() {
        nama
    }
}
