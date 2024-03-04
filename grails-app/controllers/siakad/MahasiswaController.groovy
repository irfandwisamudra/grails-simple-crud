package siakad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MahasiswaController {

    MahasiswaService mahasiswaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mahasiswaService.list(params), model:[mahasiswaCount: mahasiswaService.count()]
    }

    def show(Long id) {
        respond mahasiswaService.get(id)
    }

    def create() {
        respond new Mahasiswa(params)
    }

    def save(Mahasiswa mahasiswa) {
        if (mahasiswa == null) {
            notFound()
            return
        }

        try {
            mahasiswaService.save(mahasiswa)
        } catch (ValidationException e) {
            respond mahasiswa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mahasiswa.label', default: 'Mahasiswa'), mahasiswa.id])
                redirect mahasiswa
            }
            '*' { respond mahasiswa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mahasiswaService.get(id)
    }

    def update(Mahasiswa mahasiswa) {
        if (mahasiswa == null) {
            notFound()
            return
        }

        try {
            mahasiswaService.save(mahasiswa)
        } catch (ValidationException e) {
            respond mahasiswa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mahasiswa.label', default: 'Mahasiswa'), mahasiswa.id])
                redirect mahasiswa
            }
            '*'{ respond mahasiswa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mahasiswaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mahasiswa.label', default: 'Mahasiswa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mahasiswa.label', default: 'Mahasiswa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
