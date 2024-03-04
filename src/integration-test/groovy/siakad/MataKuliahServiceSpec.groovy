package siakad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MataKuliahServiceSpec extends Specification {

    MataKuliahService mataKuliahService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MataKuliah(...).save(flush: true, failOnError: true)
        //new MataKuliah(...).save(flush: true, failOnError: true)
        //MataKuliah mataKuliah = new MataKuliah(...).save(flush: true, failOnError: true)
        //new MataKuliah(...).save(flush: true, failOnError: true)
        //new MataKuliah(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mataKuliah.id
    }

    void "test get"() {
        setupData()

        expect:
        mataKuliahService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MataKuliah> mataKuliahList = mataKuliahService.list(max: 2, offset: 2)

        then:
        mataKuliahList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mataKuliahService.count() == 5
    }

    void "test delete"() {
        Long mataKuliahId = setupData()

        expect:
        mataKuliahService.count() == 5

        when:
        mataKuliahService.delete(mataKuliahId)
        sessionFactory.currentSession.flush()

        then:
        mataKuliahService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MataKuliah mataKuliah = new MataKuliah()
        mataKuliahService.save(mataKuliah)

        then:
        mataKuliah.id != null
    }
}
