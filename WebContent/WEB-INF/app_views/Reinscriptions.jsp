<%@ page import="soac.miniprojet.model.dao.daos.StudentsDAO" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="soac.miniprojet.model.beans.Students" %><%--
  Created by IntelliJ IDEA.
  User: Ouala Eddine
  Date: 03/01/2020
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Biblio - Reinscriptions</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
</head>

<body id="page-top">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-text mx-3"><span>Biblio</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation"><a class="nav-link" href="Dashboard"><i
                        class="fas fa-tachometer-alt"></i><span>Dashboard</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="Students"><i
                        class="fas fa-tachometer-alt"></i><span>Gestion des etudiants</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="Inscriptions"><i
                        class="fas fa-tachometer-alt"></i><span>Inscriptions</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="Reinscriptions"><i
                        class="fas fa-tachometer-alt"></i><span>Reinscription</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="Users"><i
                        class="fas fa-tachometer-alt"></i><span>Inscriptions</span></a></li>
            </ul>
            <div class="text-center d-none d-md-inline">
                <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
            </div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid">
                    <button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i
                            class="fas fa-bars"></i></button>
                    <ul class="nav navbar-nav flex-nowrap ml-auto">
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link"
                                                                       data-toggle="dropdown" aria-expanded="false"
                                                                       href="#"><span
                                    class="d-none d-lg-inline mr-2 text-gray-600 small">Valerie Luna</span><img
                                    class="border rounded-circle img-profile" src="assets/img/avatars/avatar1.jpeg"></a>
                                <div
                                        class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu">
                                    <a class="dropdown-item" role="presentation" href="#"><i
                                            class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Profile</a><a
                                        class="dropdown-item" role="presentation" href="#"><i
                                        class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Settings</a>
                                    <a
                                            class="dropdown-item" role="presentation" href="#"><i
                                            class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Activity
                                        log</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" role="presentation" href="#"><i
                                            class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;Logout</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="container-fluid">
                <div class="d-sm-flex justify-content-between align-items-center mb-4">
                    <h3 class="text-dark mb-0">Reinscriptions</h3>

                </div>
                <div class="row">
                    <div class="col-lg-7 col-xl-12">
                        <div class="card shadow mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h6 class="text-primary font-weight-bold m-0">Liste des etudiants</h6>
                                <div class="dropdown no-arrow">
                                    <button class="btn btn-link btn-sm dropdown-toggle" data-toggle="dropdown"
                                            aria-expanded="false" type="button"><i
                                            class="fas fa-ellipsis-v text-gray-400"></i></button>
                                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                                         role="menu"></div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-sm">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nom</th>
                                            <th>Prénom</th>
                                            <th>Date de naissance</th>
                                            <th>sexe</th>
                                            <th>n° BAC</th>
                                            <th>Date d'inscription</th>
                                            <th>Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            LinkedList<Students> studs = (LinkedList<Students>) request.getAttribute("students");
                                            for (Students student : studs) {
                                        %>
                                        <tr>
                                            <td><%= student.getId()%>
                                            </td>
                                            <td><%= student.getNom()%>
                                            </td>
                                            <td><%= student.getPrenom()%>
                                            </td>
                                            <td>
                                                <%= student.getDateNaiss()%>
                                            </td>
                                            <td>
                                                <%= student.getSexe()%>
                                            </td>
                                            <td>
                                                <%= student.getNumBac()%>
                                            </td>
                                            <td>
                                                <%= student.getDateInsc()%>
                                            </td>
                                            <td class="text-center" style="padding-top: 0px;">
                                                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#staticBackdrop"><i class="fa fa-recycle"></i>
                                                    Réinscrire
                                                </button>

                                                <!-- Modal -->
                                                <div class="modal fade " id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog"
                                                     aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                    <form>

                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="staticBackdropLabel">Réinscrire un etudiant</h5>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">


                                                                    <div class="form-group">
                                                                        <label for="disabledTextInput">Niveau en cours</label>
                                                                        <input type="text" id="disabledTextInput" class="form-control" placeholder="<% %>niveau a retourner">
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="niveau">Niveau : </label>
                                                                        <select id="niveau" name="niveau" class="form-control form-control-lg" >
                                                                            <option>--Selectionner--</option>
                                                                            <option value="L1">L1</option>
                                                                            <option value="L2">L2</option>
                                                                            <option value="L3">L3</option>
                                                                            <option value="M1">M1</option>
                                                                            <option value="M2">M2</option>

                                                                        </select>
                                                                    </div>


                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Annuler
                                                                        </button>
                                                                        <button type="submit" class="btn btn-success"><i
                                                                                class="fa fa-dot-circle-o"></i> Réinscrire
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>

                                                </div>

                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2019</span></div>
            </div>
        </footer>
    </div>
    <a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>