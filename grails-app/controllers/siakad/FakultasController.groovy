package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FakultasController {

    FakultasService fakultasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fakultasService.list(params), model:[fakultasCount: fakultasService.count()]
    }

    def show(Long id) {
        respond fakultasService.get(id)
    }

    def create() {
        respond new Fakultas(params)
    }

    def save(Fakultas fakultas) {
        if (fakultas == null) {
            notFound()
            return
        }

        try {
            fakultasService.save(fakultas)
        } catch (ValidationException e) {
            respond fakultas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fakultas.label', default: 'Fakultas'), fakultas.id])
                redirect fakultas
            }
            '*' { respond fakultas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fakultasService.get(id)
    }

    def update(Fakultas fakultas) {
        if (fakultas == null) {
            notFound()
            return
        }

        try {
            fakultasService.save(fakultas)
        } catch (ValidationException e) {
            respond fakultas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fakultas.label', default: 'Fakultas'), fakultas.id])
                redirect fakultas
            }
            '*'{ respond fakultas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fakultasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fakultas.label', default: 'Fakultas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fakultas.label', default: 'Fakultas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
