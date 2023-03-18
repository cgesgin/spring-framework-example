<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<title>List Todos Page</title>
	</head>

	<body>
		<%@ include file="navigation.jsp" %>
		<div class="container">
			<h3>hello ${name}</h3>
			<hr />
			<h1>Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>description</th>
						<th>targetDate</th>
						<th>Status</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>
								<c:if test = "${todo.status == true}">
									<div style="background-color: greenyellow;  width: 250px;height: 30px;">
										completed    (<c:out value = "${todo.status}"/>)
									</div>
								 </c:if>
								 <c:if test = "${todo.status == false}">
									<div style="background-color: rgb(255, 47, 54);  width: 250px;height: 30px;">
										not completed (<c:out value = "${todo.status}"/>)
									</div>
								 </c:if>
							</td>
							 
							<td>
								<a href="delete?id=${todo.id}" class="btn btn-warning">Delete</a>
								<a href="update?id=${todo.id}" class="btn btn-success">Update</a>
								<a href="status?id=${todo.id}" class="btn btn-info">Change Status</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="create" class="btn btn-success">Create Todo</a>
		</div>

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>

	</body>

	</html>