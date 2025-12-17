<%
    String u = request.getParameter("u");
    session.setAttribute("user", u);
    session.setAttribute("start", System.currentTimeMillis());
%>
<div style="text-align:right">Time: <%= new java.util.Date() %></div>
<h1>Hello <%= u %></h1>
<a href="logout.jsp">Logout</a>