<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.mv9webhib.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css">
        <title>Listagem de Pessoas</title>
    </head>
    <body>
    <%
        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("pessoas");
    %>
        <table>
            <thead>
                <tr>
                    <th colspan="1">Codigo</th>
                    <th colspan="1">Nome</th>
                    <th colspan="1">Email</th>
                    <th colspan="1">Salario</th>
                    <th colspan="1">Area</th>
                </tr>
            </thead>
            <tbody>
    <%
        for (Pessoa pessoa : pessoas) {
    %>
            <tr>
            <td><%=pessoa.getId()%></td>
            <td><%=pessoa.getNome()%></td>
            <td><%=pessoa.getEmail()%></td>
            <td><%=pessoa.getSalario()%></td>
            <td><%=pessoa.getCargo().getNome()%></td>
            </tr>
    <%
        }
    %>       
            </tbody>
        </table>
    <a href="index.html">Retornar ao início</a>
    </body>
</html>
