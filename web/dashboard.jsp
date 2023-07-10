
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${USER}" var="u"/>


<html lang="en" class="mdl-js">
    <script src="chrome-extension://jnlgamecbpmbajjfhmmmlhejkemejdma/static/js/inpage.js"></script>
    <script src="chrome-extension://dlcobpjiigpikoobohmabehhmhfoodbb/inpage.js" id="argent-x-extension"
    data-extension-id="dlcobpjiigpikoobohmabehhmhfoodbb"></script>

    <head>
<link rel="shortcut icon" href="img/icon.ico">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Analytics page</title>
        <meta name="description" content="Tailwind CSS Starter template - Admin theme, dashboard, or web application UI!">
        <meta name="keywords"
              content="tailwind,tailwindcss,tailwind css,css,starter template,free template,fixed header, admin starter template, admin template, admin console, example">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,700,800" rel="stylesheet">
        <link rel="apple-touch-icon" sizes="180x180" href="../apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../favicon-16x16.png">
        <link rel="manifest" href="../site.webmanifest">
        <link rel="mask-icon" href="../safari-pinned-tab.svg" color="#5bbad5">
        <meta name="msapplication-TileColor" content="#00aba9">
        <meta name="theme-color" content="#3b7977">

        <!-- Primary Meta Tags -->
        <title>Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS</title>
        <meta name="title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
        <meta name="description"
              content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">

        <!-- Open Graph / Facebook -->
        <meta property="og:type" content="website">
        <meta property="og:url" content="https://www.tailwindtoolbox.com/">
        <meta property="og:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
        <meta property="og:description"
              content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
        <meta property="og:image" content="https://www.tailwindtoolbox.com/social.png">

        <!-- Twitter -->
        <meta property="twitter:card" content="summary_large_image">
        <meta property="twitter:url" content="https://www.tailwindtoolbox.com/">
        <meta property="twitter:title" content="Tailwind Toolbox - Free Starter Templates and Components for Tailwind CSS">
        <meta property="twitter:description"
              content="Free open source Tailwind CSS starter Templates and Components to get you started quickly to creating websites in Tailwind CSS!">
        <meta property="twitter:image" content="https://www.tailwindtoolbox.com/social.png">


        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="https://unpkg.com/tailwindcss@2.2.19/dist/tailwind.min.css" rel=" stylesheet">
        <!--Replace with your tailwind.css once created-->
        <link href="https://afeld.github.io/emoji-css/emoji.css" rel="stylesheet">
        <!--Totally optional :) -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"
        integrity="sha256-XF29CBwU1MWLaGEnsELogU6Y6rcc5nCkhhx89nFMIDQ=" crossorigin="anonymous"></script>


        <!----------------------------------------------->

    </head>


    <body class=" font-sans leading-normal tracking-normal " data-new-gr-c-s-check-loaded="14.1113.0"
          data-gr-ext-installed="">

        <!--Nav-->
        <header id="header" class="fixed-top" >
            <c:set var="user1" value="${u}"/>
            <c:set var="role" value="${u.getRole()}"/>

            <div  class="container-fluid bg-light position-relative shadow">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0 px-lg-5">
                    <a href="index.jsp" class="navbar-brand font-weight-bold text-secondary" style="font-size: 50px;">
                        <span class="text-primary my-5 bg-green-600" >Kid ABC</span>
                    </a>
                </nav>
            </div>
        </header>


        <div class="flex flex-col md:flex-row container">


            <div class="main-content flex-1 bg-gray-100 md:mt-2 pb-24">

                

                <div class="flex flex-wrap">
                    <!-------------------------------Class------------------------------------->
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-green-200 to-green-100 border-b-4 border-green-600 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-green-600"><i class="fa fa-wallet fa-2x fa-inverse"></i>
                                    </div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">Total Class</h5>
                                    <h3 class="font-bold text-3xl">${listClass.size()} <span class="text-green-500"><i
                                                class="fas fa-caret-up"></i></span></h3>
                                    <a href="class-management" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!----------------------------------User---------------------------------->
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-pink-200 to-pink-100 border-b-4 border-pink-500 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-pink-600"><i class="fas fa-users fa-2x fa-inverse"></i>
                                    </div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">Total Users</h5>
                                    <h3 class="font-bold text-3xl">${listUser.size()} <span class="text-pink-500"><i
                                                class="fas fa-exchange-alt"></i></span></h3>
                                    <a href="admin-list?role=${'Parent'}" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!-----------------------------------New User--------------------------------->
                    
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-yellow-200 to-yellow-100 border-b-4 border-yellow-600 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-yellow-600"><i
                                            class="fas fa-user-plus fa-2x fa-inverse"></i></div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">New Users</h5>
                                    <h3 class="font-bold text-3xl">2 <span class="text-yellow-600"><i
                                                class="fas fa-caret-up"></i></span></h3>
                                    <a href="#" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!----------------------------------Course---------------------------------->
                    
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-blue-200 to-blue-100 border-b-4 border-blue-500 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-blue-600">
                                        <i class="fas fa-server fa-2x fa-inverse"></i>
                                    </div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">Total Course</h5>
                                    <h3 class="font-bold text-3xl">${listSkill.size()} </h3>
                                    <a href="ListClass?id=${u.getIdUser()}" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!----------------------------------Teacher---------------------------------->
                    
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-indigo-200 to-indigo-100 border-b-4 border-indigo-500 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-indigo-600"><i
                                            class="fas fa-tasks fa-2x fa-inverse"></i></div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">Total Teacher</h5>
                                    <h3 class="font-bold text-3xl">${listTeacher.size()} </h3>
                                    <a href="admin-list?role=${'Teacher'}" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!-----------------------------------Child--------------------------------->
                    
                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Metric Card-->
                        <div
                            class="bg-gradient-to-b from-red-200 to-red-100 border-b-4 border-red-500 rounded-lg shadow-xl p-5">
                            <div class="flex flex-row items-center">
                                <div class="flex-shrink pr-4">
                                    <div class="rounded-full p-5 bg-red-600">
                                        <i class="fas fa-graduation-cap  fa-2x"></i>
                                    </div>
                                </div>
                                <div class="flex-1 text-right md:text-center">
                                    <h5 class="font-bold uppercase text-gray-600">Total Child</h5>
                                    <h3 class="font-bold text-3xl">${listChild.size()} <span class="text-red-500"><i
                                                class="fas fa-caret-up"></i></span></h3>
                                    <a href="admin-list?role=${'Child'}" > <h5 class="font-bold uppercase text-gray-600">Detail----->></h5></a>
                                </div>
                            </div>
                        </div>
                        <!--/Metric Card-->
                    </div>
                    <!-------------------------------------------------------------------->
                    
                </div>


                <div class="flex flex-row flex-wrap flex-grow mt-2">

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Graph Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                            </div>
                            <div class="p-5">
                                <div class="chartjs-size-monitor"
                                     style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                    <div class="chartjs-size-monitor-expand"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                    </div>
                                    <div class="chartjs-size-monitor-shrink"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                    </div>
                                </div>
                                <canvas id="chartjs-7" class="chartjs chartjs-render-monitor" width="348" height="173"
                                        style="display: block; height: 139px; width: 279px;"></canvas>
                                <script>
                                    new Chart(document.getElementById("chartjs-7"), {
                                        "type": "bar",
                                        "data": {
                                            "labels": ["January", "February", "March", "April"],
                                            "datasets": [{
                                                    "label": "Page Impressions",
                                                    "data": [10, 20, 30, 40],
                                                    "borderColor": "rgb(255, 99, 132)",
                                                    "backgroundColor": "rgba(255, 99, 132, 0.2)"
                                                }, {
                                                    "label": "Adsense Clicks",
                                                    "data": [5, 15, 10, 30],
                                                    "type": "line",
                                                    "fill": false,
                                                    "borderColor": "rgb(54, 162, 235)"
                                                }]
                                        },
                                        "options": {
                                            "scales": {
                                                "yAxes": [{
                                                        "ticks": {
                                                            "beginAtZero": true
                                                        }
                                                    }]
                                            }
                                        }
                                    });
                                </script>
                            </div>
                        </div>
                        <!--/Graph Card-->
                    </div>

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Graph Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                            </div>
                            <div class="p-5">
                                <div class="chartjs-size-monitor"
                                     style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                    <div class="chartjs-size-monitor-expand"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                    </div>
                                    <div class="chartjs-size-monitor-shrink"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                    </div>
                                </div>
                                <canvas id="chartjs-0" class="chartjs chartjs-render-monitor" width="348" height="173"
                                        style="display: block; height: 139px; width: 279px;"></canvas>
                                <script>
                                    new Chart(document.getElementById("chartjs-0"), {
                                        "type": "line",
                                        "data": {
                                            "labels": ["January", "February", "March", "April", "May", "June", "July"],
                                            "datasets": [{
                                                    "label": "Views",
                                                    "data": [65, 59, 80, 81, 56, 55, 40],
                                                    "fill": false,
                                                    "borderColor": "rgb(75, 192, 192)",
                                                    "lineTension": 0.1
                                                }]
                                        },
                                        "options": {}
                                    });
                                </script>
                            </div>
                        </div>
                        <!--/Graph Card-->
                    </div>

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Graph Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                            </div>
                            <div class="p-5">
                                <div class="chartjs-size-monitor"
                                     style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                    <div class="chartjs-size-monitor-expand"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                    </div>
                                    <div class="chartjs-size-monitor-shrink"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                    </div>
                                </div>
                                <canvas id="chartjs-1" class="chartjs chartjs-render-monitor" width="348" height="173"
                                        style="display: block; height: 139px; width: 279px;"></canvas>
                                <script>
                                    new Chart(document.getElementById("chartjs-1"), {
                                        "type": "bar",
                                        "data": {
                                            "labels": ["January", "February", "March", "April", "May", "June", "July"],
                                            "datasets": [{
                                                    "label": "Likes",
                                                    "data": [65, 59, 80, 81, 56, 55, 40],
                                                    "fill": false,
                                                    "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)", "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)", "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"],
                                                    "borderColor": ["rgb(255, 99, 132)", "rgb(255, 159, 64)", "rgb(255, 205, 86)", "rgb(75, 192, 192)", "rgb(54, 162, 235)", "rgb(153, 102, 255)", "rgb(201, 203, 207)"],
                                                    "borderWidth": 1
                                                }]
                                        },
                                        "options": {
                                            "scales": {
                                                "yAxes": [{
                                                        "ticks": {
                                                            "beginAtZero": true
                                                        }
                                                    }]
                                            }
                                        }
                                    });
                                </script>
                            </div>
                        </div>
                        <!--/Graph Card-->
                    </div>

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Graph Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                            </div>
                            <div class="p-5">
                                <div class="chartjs-size-monitor"
                                     style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
                                    <div class="chartjs-size-monitor-expand"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
                                    </div>
                                    <div class="chartjs-size-monitor-shrink"
                                         style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
                                        <div style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
                                    </div>
                                </div><canvas id="chartjs-4" class="chartjs chartjs-render-monitor" width="348" height="173"
                                              style="display: block; height: 139px; width: 279px;"></canvas>
                                <script>
                                    new Chart(document.getElementById("chartjs-4"), {
                                        "type": "doughnut",
                                        "data": {
                                            "labels": ["P1", "P2", "P3"],
                                            "datasets": [{
                                                    "label": "Issues",
                                                    "data": [300, 50, 100],
                                                    "backgroundColor": ["rgb(255, 99, 132)", "rgb(54, 162, 235)", "rgb(255, 205, 86)"]
                                                }]
                                        }
                                    });
                                </script>
                            </div>
                        </div>
                        <!--/Graph Card-->
                    </div>

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Table Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Graph</h5>
                            </div>
                            <div class="p-5">
                                <table class="w-full p-5 text-gray-700">
                                    <thead>
                                        <tr>
                                            <th class="text-left text-blue-900">Name</th>
                                            <th class="text-left text-blue-900">Side</th>
                                            <th class="text-left text-blue-900">Role</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <tr>
                                            <td>Obi Wan Kenobi</td>
                                            <td>Light</td>
                                            <td>Jedi</td>
                                        </tr>
                                        <tr>
                                            <td>Greedo</td>
                                            <td>South</td>
                                            <td>Scumbag</td>
                                        </tr>
                                        <tr>
                                            <td>Darth Vader</td>
                                            <td>Dark</td>
                                            <td>Sith</td>
                                        </tr>
                                    </tbody>
                                </table>

                                <p class="py-2"><a href="#">See More issues...</a></p>

                            </div>
                        </div>
                        <!--/table Card-->
                    </div>

                    <div class="w-full md:w-1/2 xl:w-1/3 p-6">
                        <!--Advert Card-->
                        <div class="bg-white border-transparent rounded-lg shadow-xl">
                            <div
                                class="bg-gradient-to-b from-gray-300 to-gray-100 uppercase text-gray-800 border-b-2 border-gray-300 rounded-tl-lg rounded-tr-lg p-2">
                                <h5 class="font-bold uppercase text-gray-600">Advert</h5>
                            </div>
                            <div class="p-5 text-center">


                                <script async="" type="text/javascript"
                                        src="//cdn.carbonads.com/carbon.js?serve=CK7D52JJ&amp;placement=wwwtailwindtoolboxcom"
                                id="_carbonads_js"></script>


                            </div>
                        </div>
                        <!--/Advert Card-->
                    </div>


                </div>
            </div>
        </div>








        <script>
                                    /*Toggle dropdown list*/
                                    function toggleDD(myDropMenu) {
                                        document.getElementById(myDropMenu).classList.toggle("invisible");
                                    }
                                    /*Filter dropdown options*/
                                    function filterDD(myDropMenu, myDropMenuSearch) {
                                        var input, filter, ul, li, a, i;
                                        input = document.getElementById(myDropMenuSearch);
                                        filter = input.value.toUpperCase();
                                        div = document.getElementById(myDropMenu);
                                        a = div.getElementsByTagName("a");
                                        for (i = 0; i < a.length; i++) {
                                            if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
                                                a[i].style.display = "";
                                            } else {
                                                a[i].style.display = "none";
                                            }
                                        }
                                    }
                                    // Close the dropdown menu if the user clicks outside of it
                                    window.onclick = function (event) {
                                        if (!event.target.matches('.drop-button') && !event.target.matches('.drop-search')) {
                                            var dropdowns = document.getElementsByClassName("dropdownlist");
                                            for (var i = 0; i < dropdowns.length; i++) {
                                                var openDropdown = dropdowns[i];
                                                if (!openDropdown.classList.contains('invisible')) {
                                                    openDropdown.classList.add('invisible');
                                                }
                                            }
                                        }
                                    }
        </script>




        <div id="eJOY__extension_root" class="eJOY__extension_root_class" style="all: unset;"></div><iframe
            id="nr-ext-rsicon"
            style="position: absolute; display: none; width: 50px; height: 50px; z-index: 2147483647; border-style: none; background: transparent;"></iframe>
    </body><grammarly-desktop-integration data-grammarly-shadow-root="true"></grammarly-desktop-integration>

</html>