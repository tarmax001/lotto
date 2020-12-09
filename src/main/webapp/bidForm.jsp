<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Bid Form</title>
</head>
<body>
<h3><a href="index.jsp">Home</a></h3>
<jsp:useBean id="bid" type="by.tarmax.lotto.model.Bid" scope="request"/>
<form action="bids" method="post">
    <input type="hidden" name="id" value="${bid.id}">
    <dl>
        <dt>Play date:</dt>
        <dd><input type="date" value="${bid.playDate}" name="playDate" required></dd>
    </dl>
    <dl>
        <dt>Bid date:</dt>
        <dd><input type="date" value="${bid.bidDate}" name="bidDate" required></dd>
    </dl>
    <dl>
        <dt>Amount:</dt>
        <dd><select name="amount" required>
            <option value="2" ${bid.amount == 2 ? 'selected' : ''}>2</option>
            <option value="1" ${bid.amount == 1 ? 'selected' : ''}>1</option>
        </select></dd>
    </dl>
    <dl>
        <dt>Balls:</dt>
        <dd><select name="balls" size="10" multiple required>
            <c:forEach items="${balls}" var="ball">
                <option value="${ball}" ${bid.balls.contains(ball) ? 'selected' : ''}>${ball}</option>
            </c:forEach>
        </select></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
