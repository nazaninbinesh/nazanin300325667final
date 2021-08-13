<%--
  Created by IntelliJ IDEA.
  User: Nazanin
  Date: 8/12/2021
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Nazanin 300325667</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <form method="GET">
            <div class="form-group">
                <label for="custno">Customer number:</label>
                <input type="text" class="form-control" id="custno" value="${id}" />
            </div>
            <div class="form-group">
                <label for="custname">Customer Name:</label>
                <input type="text" class="form-control" id="custname" value="${name}" />
            </div>
            <div class="form-group">
                <label for="cdep">Customer Deposit:</label>
                <input type="text" class="form-control" id="cdep" value="${deposit}" />
            </div>
            <div class="form-group">
                <label for="nyear">Number of Years:</label>
                <input type="text" class="form-control" id="nyear" value="${year}" />
            </div>
            <div class="form-group">
                <label for="type"> Saving Type: </label>
                <select id="type">
                    <option value="saving-deluxe">saving-deluxe</option>
                    <option value="saving-regular">saving-regular</option>
                </select>
            </div>
            <div class="form-group">
                <a class="btn btn-success btn-block" href="add-todo">Add</a>
            </div>
        </form>
        <h1 id="mes">${errorMessage}</h1>
        <div class="container2">
            <h2>Saving Investment Records</h2>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Customer number</th>
                    <th>Customer Name</th>
                    <th>Customer Deposit</th>
                    <th>Number of Years</th>
                    <th>Saving Type</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${cutomerList}" var="customer">
                    <tr>
                        <td>${customer.custno}</td>
                        <td>${customer.custname}</td>
                        <td>${customer.cdep}</td>
                        <td>${customer.nyears}</td>
                        <td>${customer.savtype}</td>
                        <td>
                            <a type="button" class="btn btn-primary"
                               href="update-customer?id=${customer.custno}" >Edit</a>
                        </td>
                        <td>
                            <a type="button" class="btn btn-primary"
                               href="delete-customer?id=${customer.custno}" >Delete</a>
                        </td>
                        <td>
                            <a type="button" class="btn btn-primary" onmouseout="myFunction()"
                               href="see-todo?id=${customer.custno}" >Projected Investment</a>
                        </td>

                    </tr>


                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</div>
</div>
</body>
</html>
