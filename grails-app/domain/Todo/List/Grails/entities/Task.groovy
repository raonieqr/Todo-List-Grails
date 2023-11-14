package Todo.List.Grails.entities

import grails.gorm.annotation.Entity

@Entity
class Task {
    Integer id
    String name
    String description
    String category
    String priority
    String status

    static constraints = {
        priority inList: ["Muito Baixa", "Baixa", "Média", "Alta", "Muito Alta"]
        status inList: ["A fazer", "Em progresso", "Feito"]
    }
}

