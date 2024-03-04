package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DosenController {

    DosenService dosenService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dosenService.list(params), model:[dosenCount: dosenService.count()]
    }

    def show(Long id) {
        respond dosenService.get(id)
    }

    def create() {
        respond new Dosen(params)
    }

    def save(Dosen dosen) {
        if (dosen == null) {
            notFound()
            return
        }

        try {
            dosenService.save(dosen)
        } catch (ValidationException e) {
            respond dosen.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dosen.label', default: 'Dosen'), dosen.id])
                redirect dosen
            }
            '*' { respond dosen, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dosenService.get(id)
    }

    def update(Dosen dosen) {
        if (dosen == null) {
            notFound()
            return
        }

        try {
            dosenService.save(dosen)
        } catch (ValidationException e) {
            respond dosen.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dosen.label', default: 'Dosen'), dosen.id])
                redirect dosen
            }
            '*'{ respond dosen, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dosenService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dosen.label', default: 'Dosen'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dosen.label', default: 'Dosen'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
