package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProgramStudiController {

    ProgramStudiService programStudiService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond programStudiService.list(params), model:[programStudiCount: programStudiService.count()]
    }

    def show(Long id) {
        respond programStudiService.get(id)
    }

    def create() {
        respond new ProgramStudi(params)
    }

    def save(ProgramStudi programStudi) {
        if (programStudi == null) {
            notFound()
            return
        }

        try {
            programStudiService.save(programStudi)
        } catch (ValidationException e) {
            respond programStudi.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'programStudi.label', default: 'ProgramStudi'), programStudi.id])
                redirect programStudi
            }
            '*' { respond programStudi, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond programStudiService.get(id)
    }

    def update(ProgramStudi programStudi) {
        if (programStudi == null) {
            notFound()
            return
        }

        try {
            programStudiService.save(programStudi)
        } catch (ValidationException e) {
            respond programStudi.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'programStudi.label', default: 'ProgramStudi'), programStudi.id])
                redirect programStudi
            }
            '*'{ respond programStudi, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        programStudiService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'programStudi.label', default: 'ProgramStudi'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'programStudi.label', default: 'ProgramStudi'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
