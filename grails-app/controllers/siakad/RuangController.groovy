package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RuangController {

    RuangService ruangService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ruangService.list(params), model:[ruangCount: ruangService.count()]
    }

    def show(Long id) {
        respond ruangService.get(id)
    }

    def create() {
        respond new Ruang(params)
    }

    def save(Ruang ruang) {
        if (ruang == null) {
            notFound()
            return
        }

        try {
            ruangService.save(ruang)
        } catch (ValidationException e) {
            respond ruang.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ruang.label', default: 'Ruang'), ruang.id])
                redirect ruang
            }
            '*' { respond ruang, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ruangService.get(id)
    }

    def update(Ruang ruang) {
        if (ruang == null) {
            notFound()
            return
        }

        try {
            ruangService.save(ruang)
        } catch (ValidationException e) {
            respond ruang.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ruang.label', default: 'Ruang'), ruang.id])
                redirect ruang
            }
            '*'{ respond ruang, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ruangService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ruang.label', default: 'Ruang'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ruang.label', default: 'Ruang'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
