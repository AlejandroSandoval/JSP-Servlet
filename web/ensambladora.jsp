<%-- 
    Document   : bodegabens
    Created on : 04-21-2016, 06:04:00 PM
    Author     : Laboratorio
--%>
<%@page import="com.sv.udb.controlador.EnsambladoraCtrl"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ensambladora</title>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
         <!--Import materialize.css-->
         <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/prototype.js"></script>
        <script type="text/javascript" src="js/scriptaculous.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <style>
            label.error
            {
                color: red;
                float: right;
                font-size:  14px;
            }
        </style>
         <script>
        // When the browser is ready...
        $(function() {
          // Setup form validation on the #register-form element
          $("#Ensambladora").validate({

              // Specify the validation rules
              rules: {
                  NombEnsa: "required",    
                  DireEnsa: "required",
                  
              },

              // Specify the validation error messages
              messages: {
                  NombEnsa: "Ingrese un nombre",   
                  DireEnsa: "Ingrese la direccion",
              },
             
              submitHandler: function(form) {
                        var cursBton = $(this).val();
                        var form = $(this).closest("form");
                        $.ajax({
                            type: "POST",
                            url: form.attr('action'),
                            data: form.serialize() + "&cursBton=" + cursBton,
                            success: function (response) {
                                alert('OK');
                            }
                        });
                        event.preventDefault();
              }
          });
        });
  </script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
       <div class="container">
           <h1><fmt:message key="label.Ensambladora"/></h1>
           <div class=""><strong>${mensAler}</strong></div><br>
        <div class="row">
        <form name="EnsambladoraForm" id="Ensambladora" method="POST" action="EnsambladoraServ">
            <input type="hidden" name="CodiEnsa" value="${CodiEnsa}"/>
            <label for="NombEnsa"><fmt:message key="label.NombEnsa"/></label>
            <input type="text" name="NombEnsa" id="NombEscu" value="${NombEnsa}"/><br/>
            <label for="DireEnsa"><fmt:message key="label.DireEnsa"/></label>
            <input type="text" name="DireEnsa" id="DireEnsa" value="${DireEnsa}"/><br/>
            <c:choose>
                <c:when test="${CodiEnsa eq null}">
                    <button class="btn waves-effect waves-light green" type="submit" name="cursBton" value="Guardar" id="boton"><fmt:message key="btn.Guardar"/></button></c:when>
                <c:otherwise>
                    <button  class="btn waves-effect waves-light cyan" type="submit" name="cursBton" value="Modificar" id="boton"><fmt:message key="btn.Modificar"/></button>
                    <button  class="btn waves-effect waves-light red" type="submit" name="cursBton" value="Eliminar" id="boton" onclick="return confirm('<fmt:message key="msg.eli"/>');"><fmt:message key="btn.Eliminar"/></button>
                </c:otherwise>
            </c:choose>
        </form>
            <br/><br><br><br>
            <form method="POST" name="Frm" action="EnsambladoraServ">
        <% request.setAttribute( "demoAttr", new EnsambladoraCtrl().consTodo()); %>
        <display:table id="Ensambladora" name="demoAttr" class="bordered highlight centered">
            <display:column property="nombEnsa" title="Ensambladora" sortable="true"/>
            <display:column property="direEnsa" title="Direccion" sortable="true"/>
            <display:column title="Codigo" sortable="true">
                <input type="radio" name="codiEnsaRadi" id="${Ensambladora.codiEnsa}" value="${Ensambladora.codiEnsa}"/><label for="${Ensambladora.codiEnsa}"></label>
            </display:column>
        </display:table>
            <br/>
            <div class="row">
            <button class="btn waves-effect waves-light blue col s12" type="submit" name="cursBton" value="Consultar"><fmt:message key="btn.Consultar"/></button>
            </div>
        </form>
        </div>
         
            </div>
    </body>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script>
          $(document).ready(function() {
            $('select').material_select();
            });
      </script>
</html>
