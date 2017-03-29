<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Edição da Música "${musica.nome}"</h2>
<br/>
<c:url var="actionEditar" value="/musicas/alterar"></c:url>
<form:form action="${actionEditar}" method="post" modelAttribute="musica">

	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label>Id:</label>
				<form:input path="id" cssClass="form-control" readyonly = "true" />				
			</div>
		</div>	
	</div>	
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label>Nome:</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path ="nome" cssStyle="color: red;" />
			</div>
		</div>	
	</div>	
		
	<div class="row">	
		<div class="col-md-6">
			<div class="form-group">
				<label>Data de criação:</label>			
				<form:input path="dataCriacao" cssClass="form-control" />
				<form:errors path ="dataCriacao" cssStyle="color: red;" />
			</div>	
		</div>		
	</div>	
	
	<div class="row">	
		<div class="col-md-6">
			<div class="form-group">
				<label>Álbum:</label>	
				<form:select path="album.id" cssClass="form-control">
					<form:options items="${albuns}" itemLabel="nome" itemValue="id"/>
				</form:select>	
					
				<form:input path="dataCriacao" cssClass="form-control" />
				<form:errors path ="dataCriacao" cssStyle="color: red;" />
			</div>	
		</div>		
	</div>	
		
	<input type="submit" value="Salvar!" class="btn btn-default" />		
</form:form>
</body>
</html>