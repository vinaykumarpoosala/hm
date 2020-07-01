<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<style>
#example {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#example td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#example tr:nth-child(even) {
	background-color: #f2f2f2;
}

#example tr:hover {
	background-color: #ddd;
}

#example th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">

</head>
<body>

	<%@ include file="header.jsp"%>
	<h2 align="center">Tests Conducted</h2>

	<table id="example" class="display" style="text-align:center;">
		<thead>
			<tr>
				<th class="label">Test Name</th>

				<th class="label">Amount</th>

			</tr>
		</thead>
		<c:forEach var="par" items="${patient.tests}">
			<tr>

				<td>${par.name}</td>
				<td><c:out value="${par.amount}" /></td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	</script>

	<br>
	<br>
	<h2 align="center">Patient Details</h2>
	<table id="example" class="display" style="text-align:center;">
		<thead>
			<tr>
				<th class="label">Patient Id</th>
				<th class="label">Patient Name</th>
				<th class="label">Patient SSN Id</th>
				<th class="label">Patient Age</th>
				<th class="label">Patient AdmissionDate</th>
				<th class="label">Type Of Room</th>
				<th class="label">Address</th>
			</tr>
		</thead>
		<tr>
			<td>${patient.id}</td>
			<td>${patient.name}</td>
			<td>${patient.ssnId}</td>
			<td>${patient.age}</td>
			<td>${patient.dateoFAdmission}</td>
			<td>${patient.typeOfBed}</td>
			<td>${patient.address}</td>
		</tr>
	</table>
	<br />


	<form action="/addTest" method="post">
		<input type="hidden" value='${patient.id }' name="patientId">
		<br>
		<br>
		<h2 align="center">Add new Test</h2>
		<table id="example" class="display" style="text-align:center;">
			<tr>
				<td>Test Name</td>
				<td>Amount</td>
			</tr>
			<tr>
				<td><input type="text" name="name" required="required"/></td>

				<td><input type="number" name='amount' id='am' required="required" /></td>
			</tr>
			<tr>
				<td align="left"><input type="submit" value="confirm"></td>
			</tr>
		</table>


		<!-- <button type="button" onclick="myFunction()">add medicine</button> -->


	</form>
	<%
		String userType = (String) session.getAttribute("userType");
	%>
	<input type="hidden" id="user_Type" value="<%=userType%>">


</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>


</html>