package Todo.List.Grails.entities

import Todo.List.Grails.enums.Priority
import Todo.List.Grails.enums.Status
import grails.gorm.annotation.Entity

@Entity
class Task {
    Integer id
    String name
    String description
    String category
    Priority priority
    Status status

    static constraints = {
        priority inList: Priority.values().toList()
        status inList: Status.values().toList()
    }

    Task(String name, String description, String category, Priority priority, Status status) {
        this.name = name
        this.description = description
        this.category = category
        this.priority = priority
        this.status = status
    }
}

