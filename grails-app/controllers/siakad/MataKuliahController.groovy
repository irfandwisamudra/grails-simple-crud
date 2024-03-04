package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MataKuliahController {

    MataKuliahService mataKuliahService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mataKuliahService.list(params), model:[mataKuliahCount: mataKuliahService.count()]
    }

    def show(Long id) {
        respond mataKuliahService.get(id)
    }

    def create() {
        respond new MataKuliah(params)
    }

    def save(MataKuliah mataKuliah) {
        if (mataKuliah == null) {
            notFound()
            return
        }

        try {
            mataKuliahService.save(mataKuliah)
        } catch (ValidationException e) {
            respond mataKuliah.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mataKuliah.label', default: 'MataKuliah'), mataKuliah.id])
                redirect mataKuliah
            }
            '*' { respond mataKuliah, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mataKuliahService.get(id)
    }

    def update(MataKuliah mataKuliah) {
        if (mataKuliah == null) {
            notFound()
            return
        }

        try {
            mataKuliahService.save(mataKuliah)
        } catch (ValidationException e) {
            respond mataKuliah.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mataKuliah.label', default: 'MataKuliah'), mataKuliah.id])
                redirect mataKuliah
            }
            '*'{ respond mataKuliah, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mataKuliahService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mataKuliah.label', default: 'MataKuliah'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mataKuliah.label', default: 'MataKuliah'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
