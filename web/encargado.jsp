<%-- 
    Document   : encargado
    Created on : 05-08-2016, 09:43:44 PM
    Author     : aleso
--%>
<%@page import="com.sv.udb.controlador.EncargadoCtrl"%>
<%@page import="com.sv.udb.controlador.UsuarioCtrl"%>
<%@page import="com.sv.udb.controlador.EscuelaCtrl"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encargados</title>
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
          $("#Usua").validate({

              // Specify the validation rules
              rules: {
                  nomb_usua: {required:true},
                  apel_usua: {required:true},
                  corr_usua: {required:true},
                  user_usua: {required:true},
                  pass_usua: {required:true, minlength: 6},
                  confi_usua: {equalTo: "#pass_usua"},
                  codi_escu: {required:true},
                  dui_enca: {required:true, minlength: 9, maxlength: 9},
                  tele_enca: {required:true, minlength: 8, maxlength: 8}
              },

              // Specify the validation error messages
              messages: {
                  nomb_usua: "Ingrese un nombre",
                  apel_usua: "Ingrese un apellido",
                  corr_usua: "Ingrese un correo",
                  user_usua: "Ingrese un Username",
                  pass_usua: "Ingrese una contraseña min (6 caracteres)",
                  confi_usua: "Las contraseñas deben coincidir",
                  codi_escu: "Seleccione una escuela",
                  dui_enca: "Ingrese un DUI",
                  tele_enca: "Ingrese un teléfono"
                  
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
           <h1><fmt:message key="label.TiEnca"/></h1>
           <div class=""><strong>${mensAler}</strong></div><br>
            <div class="row">
            <form name="UsuaForm" id="Usua" method="POST" action="EncargadoServ">
                <input type="hidden" name="codi_usua" value="${codi_usua}"/>
                <input type="hidden" name="codi_enca" value="${codi_enca}"/>
                <div class="row col s12 l6 m6">
                    <label for="nomb_usua"><fmt:message key="label.Nomb"/></label>
                    <input type="text" name="nomb_usua" id="nomb_usua" value="${nomb_usua}"/><br/>
                    <label for="apel_usua"><fmt:message key="label.Apel"/></label>
                    <input type="text" name="apel_usua" id="apel_usua" value="${apel_usua}"/><br/>
                    <label for="corr_usua"><fmt:message key="label.Corr"/></label>
                    <input type="email" name="corr_usua" id="corr_usua" value="${corr_usua}"/><br/>
                    <label for="dui_enca"><fmt:message key="label.Dui"/></label>
                    <input type="text" name="dui_enca" id="dui_enca" value="${dui_enca}"/><br/>
                </div>
                <div class="row col s12 l6 m6">
                    <label for="tele_enca"><fmt:message key="label.Tele"/></label>
                    <input type="text" name="tele_enca" id="tele_enca" value="${tele_enca}"/><br/>
                    <label for="user_usua"><fmt:message key="label.User"/></label>
                    <input type="text" name="user_usua" id="user_usua" value="${user_usua}"/><br/>
                    <c:choose>
                        <c:when test="${codi_usua eq null}">
                            <label for="pass_usua"><fmt:message key="label.Pass"/></label>
                            <input type="password" name="pass_usua" id="pass_usua" value="${pass_usua}"/><br/>
                            <label for="confi_usua"><fmt:message key="label.Confi"/></label>
                            <input type="password" name="confi_usua" id="confi_usua" value="${pass_usua}"/><br/>
                        </c:when>
                        <c:otherwise>
                            <label for="pass_usua"><fmt:message key="label.Pass"/></label>
                            <input type="password" name="pass_usua" id="pass_usua" value="${pass_usua}" disabled/><br/>
                            <label for="confi_usua"><fmt:message key="label.Confi"/></label>
                            <input type="password" name="confi_usua" id="confi_usua" value="${pass_usua}" disabled/><br/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="row col s12">
                    <label><fmt:message key="label.Escuela"/></label>
                    <select name="codi_escu" id="codi_escu">
                        <jsp:useBean id="beanEscuCtrl" class="com.sv.udb.controlador.EscuelaCtrl" scope="page"/>
                        <c:forEach items="${beanEscuCtrl.consTodo()}" var="fila">
                            <c:choose>
                                <c:when test="${fila.codiEscu eq codi_escu}">
                                    <option name="codi_escu" value="${fila.codiEscu}" selected="">${fila.nombEscu}</option>
                                </c:when>
                                <c:otherwise>
                                    <option name="codi_escu" value="${fila.codiEscu}">${fila.nombEscu}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="row col s12">
                    <c:choose>
                        <c:when test="${codi_usua eq null}">
                            <button class="btn waves-effect waves-light green" type="submit" name="cursBton" value="Guardar" id="boton"><fmt:message key="btn.Guardar"/></button></c:when>
                        <c:otherwise>
                            <button  class="btn waves-effect waves-light cyan" type="submit" name="cursBton" value="Modificar" id="boton"><fmt:message key="btn.Modificar"/></button>
                            <button  class="btn waves-effect waves-light red" type="submit" name="cursBton" value="Eliminar" id="boton" onclick="return confirm('<fmt:message key="msg.eli"/>');"><fmt:message key="btn.Eliminar"/></button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form><br/><br><br><br>
            </div>
           <div class="row">
            <form method="POST" name="Frm" action="EncargadoServ">
                <% request.setAttribute( "demoAttr", new EncargadoCtrl().consTodo()); %>
        <display:table id="Usua" name="demoAttr" class="bordered highlight centered">
            <display:column property="codiUsua.nombUsua" title="Nombre"sortable="true"/>
            <display:column property="codiUsua.apelUsua" title="Apellido"sortable="true"/>
            <display:column property="codiUsua.corrUsua" title="Correo"sortable="true"/>
            <display:column property="codiUsua.userUsua" title="Username"sortable="true"/>
            <display:column property="codiEscu" title="Escula"sortable="true"/>
            <display:column title="Codigo" sortable="true">
                <input type="radio" name="codiRadioUsua" id="${Usua.codiEnca}" value="${Usua.codiEnca}"/><label for="${Usua.codiEnca}"></label>
            </display:column>
        </display:table>
            <br/>
            <div class="row">
            <button class="btn waves-effect waves-light blue col s12" type="submit" name="cursBton" value="Consultar"><fmt:message key="btn.Consultar"/></button>
            </div>
        </form>
         </div>
            </div>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script>
          $(document).ready(function() {
            $('select').material_select();
            });
      </script>
    </body>
</html>
