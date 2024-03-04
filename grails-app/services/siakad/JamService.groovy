package siakad

import grails.gorm.services.Service

@Service(Jam)
interface JamService {

    Jam get(Serializable id)

    List<Jam> list(Map args)

    Long count()

    void delete(Serializable id)

    Jam save(Jam jam)

}