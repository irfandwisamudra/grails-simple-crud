package siakad

import grails.gorm.services.Service

@Service(Mahasiswa)
interface MahasiswaService {

    Mahasiswa get(Serializable id)

    List<Mahasiswa> list(Map args)

    Long count()

    void delete(Serializable id)

    Mahasiswa save(Mahasiswa mahasiswa)

}