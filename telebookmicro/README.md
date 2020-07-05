# SERVICE PORT 8081

### 1. City Domain
* Create City: POST http://localhost:8081/api/city
* Find All Cities: GET http://localhost:8081/api/city/findAll
* Find City by ID: GET http://localhost:8081/api/city/findCity/byId/{id}
* Find City by title: GET http://localhost:8081/api/city/findCity/byTitle/{city}
* Delete City by ID: POST http://localhost:8081/api/city/deleteCityById/{id}
* Update City by ID: POST http://localhost:8081/api/city/updateCityTitleById/{id}

### 2. Abonent Domain
* Create Abonent: POST http://localhost:8081/api/abonent
* Find All Abonents: GET http://localhost:8081/api/abonent/findAll
* Find Abonent by name and SurName: GET http://localhost:8081/api/abonent/findAbonent/byNameAndSurName/{name}/{surName}
* Find Abonent by ID: GET http://localhost:8081/api/abonent/findAbonent/byId/{id}
* Delete Abonent by ID: POST http://localhost:8081/api/abonent/delete/byId/{id}
* Delete Abonent by name and SurName: POST http://localhost:8081/api/abonent/delete/ByNameAndSurName/{name}/{surName}
* Update Abonent's name by ID: POST http://localhost:8081/api/abonent/updateAbonentById/name/{id}
* Update Abonent's SurName by ID: POST http://localhost:8081/api/abonent/updateAbonentById/surName/{id}
* Update Abonent's TeleBook by ID: POST http://localhost:8081/api/abonent/updateAbonentById/teleBook/{id}

### 3. TelOperator Domain
* Create TelOperator: POST http://localhost:8081/api/telOperator
* Find All TelOperators: GET http://localhost:8081/api/findAll
* Find TelOperator by ID: GET http://localhost:8081/api/telOperator/findTelOperator/byId/{id}
* Find TelOperator by name: GET http://localhost:8081/api/telOperator/findTelOperator/byName/{operator}
* Delete TelOperator by ID: POST http://localhost:8081/api/telOperator/deleteTelOperatorById/{id}
* Update TelOperator by ID: POST http://localhost:8081/api/telOperator/updateTelOperatorById/{id}

### 4. TeleBook Domain
* Create TeleBook: POST http://localhost:8081/api/teleBook
* Find All TeleBooks: GET http://localhost:8081/api/teleBook/findAll
* Find TeleBook by ID: GET http://localhost:8081/api/teleBook/findTeleBookById/{id}
* Delete TeleBook by ID: GET http://localhost:8081/api/teleBook/deleteTeleBookById/{id}


### 4. TelNum Domain
* Create TelNum: POST http://localhost:8081/api/telNum
* Find All TelNums: GET http://localhost:8081/api/teleBook/findAll
* Find All TelNum by Abonent Id: GET http://localhost:8081/api/teleBook/findTelNumByAbonentId/1
* Find All TelNum by TelOperator Id: GET http://localhost:8081/api/teleBook/findTelNumByTelOperatorId/1
* Find TelNum by telNum: GET http://localhost:8081/api/teleBook/findTelNumByTelNum/1234567
* Find TelNum by ID: GET http://localhost:8081/api/teleBook/findTelNumById/1
* Delete TelNum by ID: POST http://localhost:8081/api/teleBook/deleteTelNumById/1