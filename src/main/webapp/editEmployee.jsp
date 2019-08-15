<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>Edit Employee</h2>
  <form method="POST" action="save.html">
    <table>
      <tr>
       <td>Employee Id:</td>
       <td><input type=text name="empid" value=<%=request.getAttribute("eid")%> readonly="true"></td>
      </tr>
      <tr>
        <td>Employee Name:</td>
        <td><input type=text name="empname"></td>
      </tr>
      <tr>
        <td>Employee age:</td>
        <td><input type=text name="empage"></td>
      </tr>
      <tr>
        <td>Employee salary:</td>
        <td><input type=text name="empsalary"></td>
      </tr>
      <tr>
        <td>Employee Address:</td>
        <td><input type=text name="empaddress"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="submit"/></td>
      </tr>
  </table>
  </form>
</body>
</html>