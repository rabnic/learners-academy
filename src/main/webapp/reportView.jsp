<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
// Set the current page variable in the request scope to determine active navbar tab
request.setAttribute("currentPage", "report");
%>
<!DOCTYPE html>
<html class="h-full bg-gray-100">
<head>
<meta charset="charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Students</title>
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
	}
%>
<body class="h-full">
	<div class="min-h-full">
<%@include file="navigationView.jsp" %>
		<header class="bg-white shadow">
			<div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
				<h1 class="text-3xl font-bold tracking-tight text-gray-900">
				Dashboard - Class Reports
					</h1>
			</div>
		</header>
		<main>
			<div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
				<!-- Your content -->
			</div>
		</main>
	</div>
</body>
</html>