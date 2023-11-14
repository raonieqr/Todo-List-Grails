package Todo.List.Grails.entities


import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class TaskController {

    TaskService taskService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond taskService.list(params), model:[taskCount: taskService.count()]
    }

    def show(Long id) {
        respond taskService.get(id)
    }

    def create() {
        respond new Task(params)
    }

    def save(Task task) {
        if (task == null) {
            notFound()
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'task.label', default: 'Task'), task.id])
                redirect task
            }
            '*' { respond task, [status: CREATED] }
        }

    }

    def edit(Long id) {
        respond taskService.get(id)
    }

    def update(Task task) {
        if (task == null) {
            notFound()
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task, view:'edit'
            return
        }

        request.withFormat {
            '*' {
                flash.message = message(code: 'default.updated.message', args: ['Task', task.id]) as Object
                redirect action: "show", id: task.id
            }
        }

    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        taskService.delete(id)

        request.withFormat {
            '*' {
                flash.message = message(code: 'default.deleted.message', args: ['Task', id]) as Object
                redirect action: "index", method: "GET"
            }
        }

    }

    protected void notFound() {
        request.withFormat {
            '*' {
                flash.message = message(code: 'default.not.found.message', args: ['Task', params.id]) as Object
                redirect action: "index", method: "GET"
            }
        }

    }
}
