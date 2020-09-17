axios.get('http://localhost:7001/antiguaBweb-1.0-SNAPSHOT/loginServlet')
    .then(response => {
        console.log(response.data);
        document.getElementById("demo").innerHTML = "<label>Cashier</label>" +
            "<input type='text' class='form-group' id='cashier' name='cashier' '"+response.data +"' ><br>";
    })
    .catch(error => {
        console.error(error)
    });

