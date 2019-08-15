<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employees</title>
</head>
<body>
   <h1>List Employees</h1>
  
   <h3><a href="add.html">Add More Employee</a></h3>
 
  <table align="left" border="1">
       <tr>
         <th>Employee Id</th>
         <th>Employee Name</th>
         <th>Employee Age</th>
         <th>Employee salary</th>  
         <th>Employee Address</th>
         <th>Action On Row</th>
       </tr>
       <c:forEach items="${listemployees}" var="employee">
          <tr>
            <td><c:out value="${employee.empId}"/></td>
            <td><c:out value="${employee.empName}"/></td>	
            <td><c:out value="${employee.empAge}"/></td>
            <td><c:out value="${employee.salary}"/></td>
            <td><c:out value="${employee.empAddress}"/></td>
            
            <td align="center"><a href="edit.html?id=${employee.empId}">Edit</a>
            <a href="delete.html?id=${employee.empId}">Delete</a></td>        
          </tr>
       </c:forEach>
     </table>
 
</body>
</html>