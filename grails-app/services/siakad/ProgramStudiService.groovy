package siakad

import grails.gorm.services.Service

@Service(ProgramStudi)
interface ProgramStudiService {

    ProgramStudi get(Serializable id)

    List<ProgramStudi> list(Map args)

    Long count()

    void delete(Serializable id)

    ProgramStudi save(ProgramStudi programStudi)

}