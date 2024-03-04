package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RuangServiceSpec extends Specification {

    RuangService ruangService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ruang(...).save(flush: true, failOnError: true)
        //new Ruang(...).save(flush: true, failOnError: true)
        //Ruang ruang = new Ruang(...).save(flush: true, failOnError: true)
        //new Ruang(...).save(flush: true, failOnError: true)
        //new Ruang(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ruang.id
    }

    void "test get"() {
        setupData()

        expect:
        ruangService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ruang> ruangList = ruangService.list(max: 2, offset: 2)

        then:
        ruangList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ruangService.count() == 5
    }

    void "test delete"() {
        Long ruangId = setupData()

        expect:
        ruangService.count() == 5

        when:
        ruangService.delete(ruangId)
        sessionFactory.currentSession.flush()

        then:
        ruangService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ruang ruang = new Ruang()
        ruangService.save(ruang)

        then:
        ruang.id != null
    }
}
