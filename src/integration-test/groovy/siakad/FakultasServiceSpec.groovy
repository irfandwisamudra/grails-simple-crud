package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FakultasServiceSpec extends Specification {

    FakultasService fakultasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fakultas(...).save(flush: true, failOnError: true)
        //new Fakultas(...).save(flush: true, failOnError: true)
        //Fakultas fakultas = new Fakultas(...).save(flush: true, failOnError: true)
        //new Fakultas(...).save(flush: true, failOnError: true)
        //new Fakultas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fakultas.id
    }

    void "test get"() {
        setupData()

        expect:
        fakultasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fakultas> fakultasList = fakultasService.list(max: 2, offset: 2)

        then:
        fakultasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fakultasService.count() == 5
    }

    void "test delete"() {
        Long fakultasId = setupData()

        expect:
        fakultasService.count() == 5

        when:
        fakultasService.delete(fakultasId)
        sessionFactory.currentSession.flush()

        then:
        fakultasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fakultas fakultas = new Fakultas()
        fakultasService.save(fakultas)

        then:
        fakultas.id != null
    }
}
