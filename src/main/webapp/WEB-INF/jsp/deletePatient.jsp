<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

</head>
<body>
	<%@include file="header.jsp"%>

	<div>
		<input type="hidden" id="userType" value="${userType}">

		<section id="registration" class="section">
		<div class="container tagline">
			<em><h2 align="center">Delete Patient</h2></em><br /> <br>
			<div style="text-align: center;">
				<label>Patient ID</label> <input id="id_C" name="id_C" type="text" />&nbsp;
				&nbsp;
				<button onclick=searchPatientByiD()>Check</button>
			</div>
			<br>

			<form method="post" action="/deletepatient" method="post"
				style="text-align: center;">
				<input type="hidden" name="id" value="${patient.id }">
				<table border="1"
					style="text-align: center; margin-left: auto; margin-right: auto;">

					<tr>
						<td><label>SSN ID</label></td>
						<td><input name="ssnId" type="text" value="${patient.ssnId}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td><label>Name</label></td>
						<td><input name="name" type="text" value="${patient.name}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td><label>Age</label></td>
						<td><input name="age" type="number" value="${patient.age}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><input name="address" type="text"
							value="${patient.address}" readonly="readonly" /></td>
					</tr>

					<tr>
						<td><label>Date of Admission</label></td>
						<td><input name="dateoFAdmission" type="text"
							value="${patient.dateoFAdmission}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td><label>Bed Type</label></td>
						<td><input type="text" name="typeOfBed"
							value="${patient.typeOfBed}" readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>State</label></td>
						<td><input type="text" name="state" value="${patient.state}"
							readonly="readonly"></td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><input type="text" name="city" value="${patient.city}"
							readonly="readonly"></td>
					</tr>

				</table>
				<br> <span>${error}</span> <input type="submit" value="Delete"
					id="submit">
			</form>
		</div>
		</section>
		<%@ include file="footer.jsp"%>
	</div>
	<%
		String userType = (String) session.getAttribute("userType");
	%>
	<input type="hidden" id="user_Type" value="<%=userType%>">

</body>
<script type="text/javascript">
		function searchPatientByiD(){
	 		var selectedPatient = document.getElementById('id_C').value;
	    	var redirectLink ="/goToDelete/searchById?patientId=" + selectedPatient;
	    	console.log('Redirecting to: ' + redirectLink);
	    	window.location.href = redirectLink;
		}
	</script>
</html>
