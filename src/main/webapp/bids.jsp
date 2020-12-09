<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Bid list</title>
    <style>
        .normal {
            color: blue;
        }

        .won {
            color: orange;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.jsp">Home</a></h3>
    <hr/>
    <h2>Bids</h2>
    <a href="bids?action=create">Create</a>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Play Date</th>
            <th>Bid Date</th>
            <th>Bid Amount</th>
            <th>Gain</th>
            <th>Balls</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${bids}" var="bid">
            <jsp:useBean id="bid" type="by.tarmax.lotto.to.BidTo"/>
            <tr>
                <td>${bid.playDate}</td>
                <td>${bid.date}</td>
                <td>${bid.amount}</td>
                <td>${bid.gain}</td>
                <td> <c:forEach items="${bid.balls}" var="ball">
                    <jsp:useBean id="ball" type="by.tarmax.lotto.model.Ball"/>
                    <strong class="${ball.von ? 'won' : 'normal'}">${ball.value} </strong>
                </c:forEach> </td>
                <td><a href="bids?action=update&id=${bid.id}">Update</a></td>
                <td><a href="bids?action=delete&id=${bid.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>