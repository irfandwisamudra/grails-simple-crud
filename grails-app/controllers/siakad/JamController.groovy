package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class JamController {

    JamService jamService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond jamService.list(params), model:[jamCount: jamService.count()]
    }

    def show(Long id) {
        respond jamService.get(id)
    }

    def create() {
        respond new Jam(params)
    }

    def save(Jam jam) {
        if (jam == null) {
            notFound()
            return
        }

        try {
            jamService.save(jam)
        } catch (ValidationException e) {
            respond jam.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jam.label', default: 'Jam'), jam.id])
                redirect jam
            }
            '*' { respond jam, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond jamService.get(id)
    }

    def update(Jam jam) {
        if (jam == null) {
            notFound()
            return
        }

        try {
            jamService.save(jam)
        } catch (ValidationException e) {
            respond jam.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'jam.label', default: 'Jam'), jam.id])
                redirect jam
            }
            '*'{ respond jam, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        jamService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'jam.label', default: 'Jam'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jam.label', default: 'Jam'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
