<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
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
</head>
<body>

	<%@ include file="header.jsp"%>

	<% String userType = (String)session.getAttribute("userType"); %>
	<input type="hidden" id="user_Type" value="<%= userType %>">
	<h2 align="center">Tests Conducted</h2>

	<table id="example" class="display" style="text-align: center;">
		<thead>
			<tr>
				<th class="label">Test Name</th>

				<th class="label">Test Amount</th>

			</tr>
		</thead>
		<c:forEach var="par" items="${patient.tests}">
			<tr>

				<td>${par.name}</td>
				<td><c:out value="${par.amount}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total Bill for Diagnostics</td>
			<td>${mapForBilling.get('billForDaignostics')}</td>
		</tr>
	</table>
	<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );</script>

	<br>
	<br>
	<h2 align="center">Patient details</h2>
	<table id="example" class="display" style="text-align: center;">
		<thead>
			<tr>
				<th class="label">Patient Id</th>
				<th class="label">Patient Name</th>
				<th class="label">Patient SSN Id</th>
				<th class="label">Patient Age</th>
				<th class="label">Patient AdmissionDtae</th>
				<th class="label">Type Of Room</th>
				<th class="label">Address</th>

				<th class="label">Patient Discharge Date</th>

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
			<td id="date"></td>

		</tr>

		<tr>
			<td>No of Days Stayed</td>
			<td>${mapForBilling.get('noOfDays')}</td>

			<td>Total Bill for Stay</td>
			<td>${mapForBilling.get('billForStay')}</td>
		</tr>

	</table>
	<br />







	<h2 align="center">Medicine issued</h2>

	<table id="example" class="display" style="text-align: center;">
		<thead>
			<tr>
				<th class="label">Medicine Name</th>
				<th class="label">Medicine Quantity</th>
				<th class="label">Medicine Rate</th>
				<th class="label">Medicine Amount</th>

			</tr>
		</thead>
		<c:forEach var="par" items="${patient.medicines}">
			<tr>

				<td>${par.name}</td>
				<td><c:out value="${par.quantity}" /></td>
				<td><c:out value="${par.rate}" /></td>
				<td><c:out value="${par.amount}" /></td>
			</tr>
		</c:forEach>

		<tr>
		<td></td>		<td></td>
		
			<td>total bill for medicine</td>
			<td>${mapForBilling.get('billForMedicine')}</td>
		</tr>

	</table>
	<p align="center">Total Bill Payable
		${mapForBilling.get('totalBill')}</p>
	<form action="/bilingConfirmed" method="post" align="center">
		<input type="hidden" name="patientId" value="${patient.id}"> <input
			type="hidden" name="totalBill"
			value="${mapForBilling.get('totalBill')}"> <input
			type="submit" value="confirm">
	</form>


	<!-- <button type="button" onclick="myFunction()">add medicine</button> -->








</body>
<script>n =  new Date();
	y = n.getFullYear();
	m = n.getMonth() + 1;
	d = n.getDate();
	document.getElementById("date").innerHTML = y + "-" + m + "-" + d;
	</script>

</html>