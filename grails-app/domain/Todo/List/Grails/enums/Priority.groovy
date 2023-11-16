package Todo.List.Grails.enums

enum Priority {
  MUITO_BAIXA(0),
  BAIXA(1),
  MEDIA(2),
  ALTA(3),
  MUITO_ALTA(4)

  int priority

  Priority(int priority) {
    this.priority = priority
  }
}
