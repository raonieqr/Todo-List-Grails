<%@ page import="Todo.List.Grails.enums.Priority" %>
<%@ page import="Todo.List.Grails.enums.Status" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#create-task" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="create-task" class="col-12 content scaffold-create" role="main">
                    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${this.task}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.task}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                    </g:hasErrors>
                    <g:form resource="${this.task}" method="POST">
                        <fieldset class="form">
                            <div class="fieldcontain required">
                                <label for="priority"><g:message code="task.priority.label" default="Priority" /></label>
                                <g:select name="priority" from="${Priority.values()}" value="${task?.priority}" />
                            </div>
                            <div class="fieldcontain required">
                                <label for="status"><g:message code="task.status.label" default="Status" /></label>
                                <g:select name="status" from="${Status.values()}" value="${task?.status}" />
                            </div>
                            <div class="fieldcontain required">
                                <label for="name"><g:message code="task.name.label" default="Name" /></label>
                                <input type="text" name="name" value="${task?.name}" />
                            </div>
                            <div class="fieldcontain">
                                <label for="description"><g:message code="task.description.label" default="Description" /></label>
                                <input name="description" ${task?.description}/>
                            </div>
                            <div class="fieldcontain">
                                <label for="category"><g:message code="task.category.label" default="Category" /></label>
                                <input type="text" name="category" value="${task?.category}" />
                            </div>
                        </fieldset>

                        <fieldset class="buttons">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </fieldset>
                    </g:form>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
