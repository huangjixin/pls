var baseUrl = "http://172.16.234.157:8000/award";

var headerAuthorization = {
    'Authorization': 'Basic c2VjdXJpdHktc2VydmljZToxMjM0NTY='
}

var headerToken = {
    'authorization': 'Bearer ' + sessionStorage.getItem("token")
}