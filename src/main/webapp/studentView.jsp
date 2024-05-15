<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
// Set the current page variable in the request scope to determine active navbar tab
request.setAttribute("currentPage", "student");
%>
<%@ page import="com.entities.*"%>
<%@ page import="com.util.*"%>
<%@ page import="com.dao.*"%>
<%@ page import="java.util.*"%>
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
if (session.getAttribute("admin") == null) {
	response.sendRedirect("index.jsp");
} else {
	StudentDAO studentDAO = new StudentDAO();
	List<Student> students = studentDAO.getAllStudents();
	pageContext.setAttribute("students", students);

	ClassDAO classDAO = new ClassDAO();
	List<LAClass> classes = classDAO.getAllClasses();
	pageContext.setAttribute("classes", classes);
	pageContext.setAttribute("classDAO", classDAO);
}
%>
<body class="h-full">
	<div class="min-h-full">
		<%@include file="navigationView.jsp"%>
		<header class="bg-white shadow">
			<div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
				<h1 class="text-3xl font-bold tracking-tight text-gray-900">Manage
					Students</h1>
			</div>
		</header>
		<main>
			<div class="mx-auto max-w-7xl">
				<!-- Your content -->
				<!-- Create modal -->
				<div id="createProductModal"
					class="justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
					<div class="relative p-4 w-full max-w-4xl max-h-full">
						<!-- Modal content -->
						<div
							class="relative p-4 bg-white rounded-lg shadow dark:bg-gray-800 sm:p-5">
							<!-- Modal header -->
							<div
								class="flex justify-between items-center pb-4 mb-4 rounded-t border-b sm:mb-5 dark:border-gray-600">
								<h3 class="text-lg font-semibold text-gray-900 dark:text-white">Add
									Student</h3>
							</div>
							<!-- Modal body -->
							<form action="StudentServlet" method="post">
								<div class="grid gap-4 mb-4 sm:grid-cols-5">
									<div>
										<label for="name"
											class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Full
											Name</label> <input type="text" name="fullName" id="name"
											class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
											placeholder="Type product name" required="">
									</div>
									<div>
										<label for="brand"
											class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Gender</label>
										<input type="text" name="gender" id="brand"
											class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
											placeholder="Product brand" required="">
									</div>
									<div>
										<label for="price"
											class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Age</label>
										<input type="number" name="age" id="price"
											class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
											placeholder="$2999" required="">
									</div>
									<div>
										<label for="category"
											class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Class</label>

										<select
											class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5"
											required name="classID"
											class="rounded-md border border-gray-300 px-3 py-2 ml-2">
											<option value="" disabled selected>Select Class</option>
											<c:forEach var="classItem" items="${classes}">
												<option value="${classItem.id}"><c:out
														value="${classItem.name}" /></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<button type="submit"
									class="text-white bg-blue-500 hover:bg-blue-800 border-black-500 font-medium rounded-lg text-sm px-5 py-2.5 text-center">

									Add new student</button>
							</form>



						</div>
					</div>
				</div>
				<div class="overflow-x-auto">
					<table
						class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
						<thead
							class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
							<tr>
								<th scope="col" class="px-4 py-4">Student Name</th>
								<th scope="col" class="px-4 py-3">Gender</th>
								<th scope="col" class="px-4 py-3">Age</th>
								<th scope="col" class="px-4 py-3">ClassID</th>
								<th scope="col" class="px-4 py-3">Actions</th>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${students }">
								<tr class="border-b dark:border-gray-700">
									<th
										class="px-4 py-3 font-medium text-gray-900 whitespace-nowrap dark:text-white">
										<c:out value="${student.fullName}" />
									</th>
									<th
										class="px-4 py-3 font-medium text-gray-900 whitespace-nowrap dark:text-white">
										<c:out value="${student.gender}" />
									</th>
									<th
										class="px-4 py-3 font-medium text-gray-900 whitespace-nowrap dark:text-white">
										<c:out value="${student.age}" />
									</th>
									<th
										class="px-4 py-3 font-medium text-gray-900 whitespace-nowrap dark:text-white">
										<c:out value="${classDAO.getClassByID(student.classID).name}" />
									</th>
									<td class="px-4 py-3"><a href="#" class="text-blue-400 hover:underline">delete</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</div>
</body>
</html>