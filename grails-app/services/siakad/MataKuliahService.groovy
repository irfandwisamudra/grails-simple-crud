package siakad

import grails.gorm.services.Service

@Service(MataKuliah)
interface MataKuliahService {

    MataKuliah get(Serializable id)

    List<MataKuliah> list(Map args)

    Long count()

    void delete(Serializable id)

    MataKuliah save(MataKuliah mataKuliah)

}