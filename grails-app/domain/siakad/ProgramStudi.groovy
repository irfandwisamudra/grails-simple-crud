package siakad

class ProgramStudi {

    String nama
    String tingkat
    String akreditasi

    static belongsTo = [fakultas: Fakultas]

    static hasMany = [mahasiswa: Mahasiswa]

    static constraints = {
        nama nullable: false, maxSize: 100
        tingkat nullable: false, inList: ["S1", "S2", "S3"]
        akreditasi nullable: true, maxSize: 10
    }

    String toString() {
        nama
    }
}
