package siakad

import grails.gorm.services.Service

@Service(Dosen)
interface DosenService {

    Dosen get(Serializable id)

    List<Dosen> list(Map args)

    Long count()

    void delete(Serializable id)

    Dosen save(Dosen dosen)

}