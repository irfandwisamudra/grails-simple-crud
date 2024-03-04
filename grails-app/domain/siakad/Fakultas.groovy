package siakad

class Fakultas {
    String nama
    String dekan

    static hasMany = [programStudi: ProgramStudi]

    static constraints = {
        nama nullable: false, maxSize: 100
        dekan nullable: false, maxSize: 100
    }

    String toString() {
        nama
    }
}
