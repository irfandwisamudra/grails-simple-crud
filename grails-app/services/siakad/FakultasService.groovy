package siakad

import grails.gorm.services.Service

@Service(Fakultas)
interface FakultasService {

    Fakultas get(Serializable id)

    List<Fakultas> list(Map args)

    Long count()

    void delete(Serializable id)

    Fakultas save(Fakultas fakultas)

}