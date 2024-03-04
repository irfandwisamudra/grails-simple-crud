package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DosenServiceSpec extends Specification {

    DosenService dosenService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dosen(...).save(flush: true, failOnError: true)
        //new Dosen(...).save(flush: true, failOnError: true)
        //Dosen dosen = new Dosen(...).save(flush: true, failOnError: true)
        //new Dosen(...).save(flush: true, failOnError: true)
        //new Dosen(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dosen.id
    }

    void "test get"() {
        setupData()

        expect:
        dosenService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dosen> dosenList = dosenService.list(max: 2, offset: 2)

        then:
        dosenList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dosenService.count() == 5
    }

    void "test delete"() {
        Long dosenId = setupData()

        expect:
        dosenService.count() == 5

        when:
        dosenService.delete(dosenId)
        sessionFactory.currentSession.flush()

        then:
        dosenService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dosen dosen = new Dosen()
        dosenService.save(dosen)

        then:
        dosen.id != null
    }
}
