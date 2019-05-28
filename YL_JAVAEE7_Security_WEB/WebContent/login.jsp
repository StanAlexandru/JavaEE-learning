<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login.jsp</title>
</head>
<body>
	<form id="sign-in-form" method="POST" action="j_security_check">
		<table>
			<tr>
				<td><label>Username:</label></td>
				<td><input id="user-name" type="text" name="j_username"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
	
	<p1>
		Only POST form can be used for sending secure data.<br>
		j_security_check is our application server's queue to start user validation.<br>
		The username must have j_username and the password j_password.<br><br>
		We have two types of users defined in glassfish server-config->Security->Realms->file->Manage Users:<br>
			<p>1. admin/admin in MANAGER group</p>
			<p>2. astan/astan in NORMAL_CLIENT group</p>
			
		If we login with admin we have access to methods called by SecureServlet(SecuredBean.doSecureTask()).<br>
		This can be checked after login at http://desktop-df02ef8:8080/YL_JAVAEE7_Security_WEB/SecuredServlet<br><br>
		
		<p4>!!! We defined <security-role-mapping> in glassfish-web.xml.</p4>
		<p4>!!! We defined <security-role> and <login-config> in web.xml.</p4>
		
	</p1>
</body>
</html>