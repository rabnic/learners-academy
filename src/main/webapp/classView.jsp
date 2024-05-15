<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
// Set the current page variable in the request scope to determine active navbar tab
request.setAttribute("currentPage", "class");
%>
<%@ page import="com.entities.*" %>
    <%@ page import="com.util.*" %>
    <%@ page import="com.dao.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html class="h-full bg-gray-100">
<head>
<meta charset="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Subjects</title>
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css"
	rel="stylesheet">

<style>
body {
	font-family: 'Roboto', sans-serif;
}
</style>
</head>
<%

	if(session.getAttribute("admin") == null)
	{
		response.sendRedirect("index.jsp");
	} else {
		ClassDAO classDAO = new ClassDAO();
		List<LAClass>  classes = classDAO.getAllClasses();
		pageContext.setAttribute("classes", classes);
	}
%>
<body class="h-full">
	<div class="min-h-full">
		<%@include file="navigationView.jsp"%>
		<header class="bg-white shadow">
			<div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
				<h1 class="text-3xl font-bold tracking-tight text-gray-900">Manage
					Classes</h1>
			</div>
		</header>
		<main>
			<div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
				<!-- Your content -->
				<div class="">
					<form action="ClassServlet" method="post" class="mb-4">
						<!-- Input fields for subject data -->
						<input type="text" name="name" placeholder="Class Name" required
							class="rounded-md border border-gray-300 px-3 py-2">
						<!-- Add/Update button -->
						<button type="submit"
							class="bg-blue-500 text-white rounded-md px-4 py-2 ml-2">Add
							Class</button>
					</form>

					<div class="overflow-x-auto">
						<table
							class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
							<thead
								class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
								<tr>
									<th scope="col" class="px-4 py-4">Class Name</th>
									<th scope="col" class="px-4 py-3">Actions</th>
									</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="classObj"  items="${classes }">
								<tr class="border-b dark:border-gray-700">
									<th class="px-4 py-3 font-medium text-gray-900 whitespace-nowrap dark:text-white">
										<c:out value="${classObj.name}" />
										</th>
									<td class="px-4 py-3"><a href="#" class="text-blue-400 hover:underline">delete</a></td>
									
								</tr>
</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</main>
	</div>
</body>
</html>