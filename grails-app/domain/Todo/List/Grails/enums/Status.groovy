package Todo.List.Grails.enums

enum Status {
  A_FAZER(0),
  EM_ANDAMENTO(1),
  FEITO(2)

  int status

  Status(int status) {
    this.status = status
  }

}
