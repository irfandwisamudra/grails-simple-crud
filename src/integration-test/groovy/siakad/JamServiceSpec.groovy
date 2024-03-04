package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class JamServiceSpec extends Specification {

    JamService jamService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Jam(...).save(flush: true, failOnError: true)
        //new Jam(...).save(flush: true, failOnError: true)
        //Jam jam = new Jam(...).save(flush: true, failOnError: true)
        //new Jam(...).save(flush: true, failOnError: true)
        //new Jam(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //jam.id
    }

    void "test get"() {
        setupData()

        expect:
        jamService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Jam> jamList = jamService.list(max: 2, offset: 2)

        then:
        jamList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        jamService.count() == 5
    }

    void "test delete"() {
        Long jamId = setupData()

        expect:
        jamService.count() == 5

        when:
        jamService.delete(jamId)
        sessionFactory.currentSession.flush()

        then:
        jamService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Jam jam = new Jam()
        jamService.save(jam)

        then:
        jam.id != null
    }
}
