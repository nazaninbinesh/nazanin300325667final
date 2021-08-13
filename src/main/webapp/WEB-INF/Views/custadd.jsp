<%--
  Created by IntelliJ IDEA.
  User: Nazanin
  Date: 8/12/2021
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Add an Entry</h1>
    <form method="POST">
        <fieldset class="form-group">
            <label for="custno">Customer number:</label>
            <input name="custno" type="text" class="form-control" id="custno" value="${id}" />
        </fieldset>


        <fieldset class="form-group">
            <label for="custname">Customer Name:</label>
            <input name ="custname" type="text" class="form-control" id="custname" value="${name}" />
        </fieldset>

        <fieldset class="form-group">
            <label for="cdep">Customer Deposit:</label>
            <input name="cdep" type="text" class="form-control" id="cdep" value="${deposit}" />
        </fieldset>

        <fieldset class="form-group">
            <label for="nyears">Number of Years:</label>
            <input name="nyears" type="text" class="form-control" id="nyears" value="${year}" />
        </fieldset>


        <fieldset class="form-group">
            <label for="savtype"> Saving Type: </label>
            <select id="savtype">
                <option value="saving-deluxe">saving-deluxe</option>
                <option value="saving-regular">saving-regular</option>
            </select>
        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit">
    </form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
