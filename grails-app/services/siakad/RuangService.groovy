package siakad

import grails.gorm.services.Service

@Service(Ruang)
interface RuangService {

    Ruang get(Serializable id)

    List<Ruang> list(Map args)

    Long count()

    void delete(Serializable id)

    Ruang save(Ruang ruang)

}