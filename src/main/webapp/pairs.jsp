<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Pair list</title>
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <hr/>
    <h2>Pairs</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Balls</th>
            <th>Drop rate</th>
            <th>Sum</th>
            <th>Last drop date</th>
            <th>Constancy</th>
        </tr>
        </thead>
        <c:forEach items="${pairs}" var="pair">
            <jsp:useBean id="pair" type="by.tarmax.lotto.model.Pair"/>
            <tr>
                <td>${pair.balls}</td>
                <td>${pair.dropRate}</td>
                <td>${pair.sum}</td>
                <td>${pair.lastDate}</td>
                <td>${pair.constancy}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>