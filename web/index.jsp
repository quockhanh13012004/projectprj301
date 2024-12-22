<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link
            href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <title>Burger House</title>
    </head>
    <body>
        <header class="header">
            <nav>
                <div class="nav__header">
                    <div class="nav__logo">
                        <a href="index.jsp">
                            <img
                                src="${pageContext.request.contextPath}/img/logo-dark.png"
                                alt="logo"
                                class="nav__logo-dark"
                                />
                            <img
                                src="${pageContext.request.contextPath}/img/logo-white.png"
                                alt="logo"
                                class="nav__logo-white"
                                />
                        </a>
                    </div>
                    <div class="nav__menu__btn" id="menu-btn">
                        <i class="ri-menu-line"></i>
                    </div>
                </div>
                <ul class="nav__links">
                    <li><a href="home">HOME</a></li>
                    <li><a href="trackingOrder">STATUS</a></li>
                        <c:if test="${sessionScope.accAccess == null}">
                        <li><a href="login">LOGIN</a>   </li>
                        </c:if>

                        <c:if test="${sessionScope.accAccess != null}">
                        <li><a href="logout">LOGOUT</a>   </li>
                        </c:if>

                        <c:if test="${sessionScope.accAccess.roleID == 2}">
                        <li><a href="pageStaffMenu">Create Order</a></li>
                        </c:if>

                        <c:if test="${sessionScope.accAccess.roleID == 3}">
                        <li><a href="dashBoard">Manage System</a></li>
                        </c:if>
                </ul>
            </nav>
            <div class="section__container header__container" id="home">
                <div class="header__image">
                    <img src="${pageContext.request.contextPath}/img/header.png" alt="header" />
                </div>
                <div class="header__content">
                    <h2>IT IS GOOD TIME FOR THE GREATE TASTE OF BURGER</h2>
                    <h1>BURGER<br /><span>WEEK</span></h1>
                </div>
            </div>
        </header>

        <section class="section__container banner__container" id="special">
            <div class="banner__card">
                <p>TRY IT OUT TODAY</p>
                <h4>MOST POPULAR BURGER</h4>
            </div>
            <div class="banner__card">
                <p>TRY IT OUT TODAY</p>
                <h4>MORE FUN<br />MORE TASTE</h4>
            </div>
            <div class="banner__card">
                <p>TRY IT OUT TODAY</p>
                <h4>FRESH & CHILI</h4>
            </div>
        </section>

        <section class="section__container order__container" id="menu">
            <h3>ALWAYS TASTEY BURGER</h3>
            <h2 class="section__header">CHOOSE & ENJOY</h2>
            <p class="section__description">
                Whether you crave classic flavors or daring combinations, this is where
                your culinary journey begins. Indulge your cravings and savor every bite
                as you create your personalized burger experience with Burger Company.
            </p>
            <div class="order__grid">
                <c:forEach items="${listDishes}" var="listDishes">
                    <div class="order__card">
                        <img src="${listDishes.image}" alt="order" />
                        <h4>${listDishes.name}</h4>
                        <p>
                            ${listDishes.description}
                        </p>
                        <p>
                            ${listDishes.price}$
                        </p>

                    </div>
                </c:forEach>
            </div>
        </section>

        <section class="section__container event__container" id="event">
            <div class="event__content">
                <div class="event__image">
                    <img src="${pageContext.request.contextPath}/img/event.png" alt="event" />
                </div>
                <div class="event__details">
                    <h3>Discover</h3>
                    <h2 class="section__header">UPCOMING EVENTS</h2>
                    <p class="section__description">
                        From exclusive burger tastings and chef collaborations to community
                        outreach initiatives and seasonal celebrations, there's always
                        something special on the horizon at Burger Company. Be the first to
                        know about our upcoming events, promotions, and gatherings as we
                        continue to bring joy and flavor to our cherished customers. Join us
                        in creating memorable moments and delicious memories together!
                    </p>
                </div>
            </div>
        </section>

        <section class="reservation" id="contact">
            <div class="contact-us" >
                <h3>CONTACT US</h3>       
            </div>
            <img
                src="${pageContext.request.contextPath}/img/reservation-bg-1.png"
                alt="reservation"
                class="reservation__bg-1"
                />
            <img
                src="${pageContext.request.contextPath}/img/reservation-bg-2.png"
                alt="reservation"
                class="reservation__bg-2"
                />
        </section>

        <footer class="footer">
            <div class="section__container footer__container">
                <div class="footer__logo">
                    <img src="${pageContext.request.contextPath}/img/logo-white.png" alt="logo" />
                </div>
                <div class="footer__content">
                    <p>
                        Welcome to Burger Company, where passion for exceptional food and
                        genuine hospitality come together. Our story is one of dedication to
                        crafting the perfect burger experience, from sourcing the finest
                        ingredients to delivering unparalleled taste in every bite.
                    </p>
                    <div>
                        <ul class="footer__links">
                            <li>
                                <span><i class="ri-map-pin-2-fill"></i></span>
                                MG Road, Bangalore, 500089
                            </li>
                            <li>
                                <span><i class="ri-mail-fill"></i></span>
                                info@burgerhouse.com
                            </li>
                        </ul>
                        <div class="footer__socials">
                            <a href="#"><i class="ri-facebook-circle-fill"></i></a>
                            <a href="#"><i class="ri-instagram-fill"></i></a>
                            <a href="#"><i class="ri-twitter-fill"></i></a>
                            <a href="#"><i class="ri-whatsapp-fill"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script src="https://unpkg.com/scrollreveal"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>
