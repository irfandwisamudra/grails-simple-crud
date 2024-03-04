package siakad

class Jam {
    String batasAwal
    String batasAkhir

    static hasMany = [mataKuliah: MataKuliah]

    static constraints = {
        batasAwal nullable: false, maxSize: 100
        batasAkhir nullable: false, maxSize: 100
    }

    String toString() {
        "${batasAwal} - ${batasAkhir}"
    }
}