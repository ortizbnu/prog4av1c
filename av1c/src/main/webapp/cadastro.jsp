<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.mv9webhib.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Geral" method="post">
            Nome: <input type="text" name="nome"> <br>
            Email: <input type="text" name="email"> <br>
            Salario: <input type="text" name="salario"> <br>
            Cargo: 
        <select name="cargos">
    <%
        ArrayList<Cargo> cargos = (ArrayList<Cargo>) request.getAttribute("cargos");
        for (Cargo cargo : cargos) {
    %>
            <option value="<%=cargo.getId()%>"><%=cargo.getNome()%></option>
    <%
        }
    %>
        </select> <br>
            <input type="hidden" name="parent" value="pessoa">
            <input type="submit" value="Cadastrar">
        </form>
        <a href="index.html">Retornar ao início</a>
    </body>
</html>
