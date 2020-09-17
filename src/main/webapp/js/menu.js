axios.get('http://localhost:7001/antiguaBweb-1.0-SNAPSHOT/loginServlet')
    .then(response => {
        console.log(response.data);
        document.getElementById("demo").innerHTML = "<label>Cashier</label>" +
            "<input type='text' class='form-control' id='cashier' name='cashier' value=' "+response.data +"' readonly><br>";
    })
    .catch(error => {
        console.error(error)
    });