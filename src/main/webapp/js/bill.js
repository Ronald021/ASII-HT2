axios.get('http://localhost:7001/antiguaBweb-1.0-SNAPSHOT/menuServlet')
    .then(response => {
        console.log(response.data);
        var i;
        var getMenu = response.data["items"];
        var getExtras = response.data["data"];
        var getOrder = response.data ["order"];
        var getDate = response.data ["time"];
        var getCashier = response.data["cashier"];
        var getCostumer = response.data["customer"];
        var getTaxId = response.data["taxid"];
        var getTotal = response.data["total"];

        var menu = "<h2 align='center'> Cuenta Menu </h2>";
        var extras ="<h2 align='center'> Extras </h2>";
        var order = "<h2 align='center'>Order</h2>";
        var date = "<h2>Date</h2>";
        var cashier = "<h2>Cashier</h2>"
        var costumer = "<h2>Costumer</h2>"
        var tax = "<h2 align=>Tax Number</h2>"
        var total = "<h2 align=>Total</h2>"

        var jumbo = "<div style='background:darkgray !important' class='jumbotron'>"
        var form = "<form>";
        var forme = "</form>";
        var deco = "<div class='container'>";
        var div = "</div>";

        for (i = 0; i < getMenu.length; i++) {
            menu = menu + "<div class='form-control'> " + getMenu[i] + " </div>";
        }
        for (i = 0; i < getExtras.length; i++) {
            extras = extras  + " <div class='form-control'> " + getExtras[i] + " </div>";
        }

        order = order + "<div class='form-control'>" + getOrder + "</div>";
        date = date + "<div class='form-control'>" + getDate + "</div>";
        cashier = cashier + "<div class='form-control'>" + getCashier + "</div>";
        costumer = costumer + "<div class='form-control'>" + getCostumer + "</div>";
        tax = tax + "<div class='form-control'>" + getTaxId + "</div>";
        total = total + "<div class='form-control'>" + getTotal + "</div>";

        document.getElementById("body").innerHTML = form + jumbo + deco + order + date + cashier + costumer + tax + menu + extras + total + div + div + forme;
    })
    .catch(error => {
        console.error(error)
    });