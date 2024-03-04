package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProgramStudiServiceSpec extends Specification {

    ProgramStudiService programStudiService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ProgramStudi(...).save(flush: true, failOnError: true)
        //new ProgramStudi(...).save(flush: true, failOnError: true)
        //ProgramStudi programStudi = new ProgramStudi(...).save(flush: true, failOnError: true)
        //new ProgramStudi(...).save(flush: true, failOnError: true)
        //new ProgramStudi(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //programStudi.id
    }

    void "test get"() {
        setupData()

        expect:
        programStudiService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ProgramStudi> programStudiList = programStudiService.list(max: 2, offset: 2)

        then:
        programStudiList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        programStudiService.count() == 5
    }

    void "test delete"() {
        Long programStudiId = setupData()

        expect:
        programStudiService.count() == 5

        when:
        programStudiService.delete(programStudiId)
        sessionFactory.currentSession.flush()

        then:
        programStudiService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ProgramStudi programStudi = new ProgramStudi()
        programStudiService.save(programStudi)

        then:
        programStudi.id != null
    }
}
