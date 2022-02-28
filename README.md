# springboot-redis-cache
1. Save Product
http://localhost:8080/api/products/save
Method : POST
Content-type: application/json

Request :

{
    "products" :[
    {
    "id":"33dd-cf55-bbg7-ffff-58hh",
    "name":"Vaccume Cleaner",
    "price":"22.50",
    "qty":1
    }
    ]
}

Response: true/false

2. Get Product
http://localhost:8080/api/products/33dd-cf55-bbg7-ffff-58hh

Method: GET

Response:

 {
    "id":"33dd-cf55-bbg7-ffff-58hh",
    "name":"Vaccume Cleaner",
    "price":"22.50",
    "qty":1
    }
