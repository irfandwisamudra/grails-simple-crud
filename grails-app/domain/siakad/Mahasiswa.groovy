package siakad

class Mahasiswa {
    String nim
    String nama
    String alamat
    String email

    static belongsTo = [programStudi: ProgramStudi]

    static hasMany = [mataKuliah: MataKuliah]

    static constraints = {
        nim unique: true
        nama nullable: false, maxSize: 100
        alamat nullable: false, maxSize: 255
        email nullable: false, email: true, maxSize: 100
    }

    String toString() {
        nama
    }
}
