# Mini-Project-Esport
Mini project tentang pembuatan pendataan ESport (Electronic Sport) sederhana,
flow pembuatan datanya dari tabel Country > User > Teams > Players > Coaches > MatchHistories
Dengan menggunakan CRUD
Untuk pengetesan Aplikasi ini menggunakan Postman,
dan untuk databasenya saya sertakan di dalam project ini yang bernama ESport.bak
dan file Json postman untuk pengetesan aplikasi.


# ESport



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [Country](#country)
    1. [FindAllCountry](#1-findallcountry)
    1. [Create Country](#2-create-country)
    1. [Update Country](#3-update-country)
    1. [Delete Country](#4-delete-country)
    1. [FindCountryById](#5-findcountrybyid)
* [User](#user)
    1. [FIndAllUser](#1-findalluser)
    1. [Create User](#2-create-user)
    1. [Update User](#3-update-user)
    1. [Delete User](#4-delete-user)
    1. [FindUserById](#5-finduserbyid)
    1. [FIndUserByCountry](#6-finduserbycountry)
* [Team](#team)
    1. [FindAllTeam](#1-findallteam)
    1. [Create Team](#2-create-team)
    1. [Update Team](#3-update-team)
    1. [Delete User](#4-delete-user-1)
    1. [FindTeamById](#5-findteambyid)
    1. [FindTeamByCountry](#6-findteambycountry)
* [Player](#player)
    1. [FindAllPlayer](#1-findallplayer)
    1. [Create Player](#2-create-player)
    1. [Update Player](#3-update-player)
    1. [Delete Player](#4-delete-player)
    1. [FindPlayerByTeam](#5-findplayerbyteam)
    1. [FindPlayerByUser](#6-findplayerbyuser)
* [Match History](#match-history)
    1. [FindAllMatchHstory](#1-findallmatchhstory)
    1. [Create MatchHistory](#2-create-matchhistory)
    1. [Update MatchHistory](#3-update-matchhistory)
    1. [Delete MatchHistory](#4-delete-matchhistory)
    1. [FindMatchHistoryById](#5-findmatchhistorybyid)
    1. [FindMatchHstoryByTeam](#6-findmatchhstorybyteam)
* [Coach](#coach)
    1. [FindAllCoach](#1-findallcoach)
    1. [Create Coach](#2-create-coach)
    1. [Update Coach](#3-update-coach)
    1. [Delete Coach](#4-delete-coach)
    1. [FindCoachById](#5-findcoachbyid)
    1. [FindCoachByTeam](#6-findcoachbyteam)
    1. [FindCoachByUser](#7-findcoachbyuser)

--------



## Country



### 1. FindAllCountry



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/country/get-all
```



### 2. Create Country



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/country/insert
```



***Body:***

```js        
{
    "description" : "Malaysia"
}
```



### 3. Update Country



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/country/update/1
```



***Body:***

```js        
{
    "description" : "Singapore"
}
```



### 4. Delete Country



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/country/delete/2
```



### 5. FindCountryById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/country/get-by-id/1
```



## User



### 1. FIndAllUser



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/user/get-all
```



### 2. Create User



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/user/insert
```



***Body:***

```js        
{
    "firstName" : "Erfan",
    "lastName"  : "Budiman",
    "birthDate" : "18/03/1993",
    "birthPlace": "Depok",
    "countryId" : 1
}   
```



### 3. Update User



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/user/update/2
```



***Body:***

```js        
{
    "firstName" : "Erpan",
    "lastName"  :  "Paloran",
    "birthDate" : "13/07/1995",
    "birthPlace": "Depok",
    "countryId" : 3
}
```



### 4. Delete User



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/user/delete/2
```



### 5. FindUserById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/user/get-by-id/1
```



### 6. FIndUserByCountry



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/user/country/3
```



## Team



### 1. FindAllTeam



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/team/get-all
```



### 2. Create Team



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/team/insert
```



***Body:***

```js        
{
    "name"      : "AyamGorengz",
    "countryId" : 3,
    "value"     : "1000000000"
}
```



### 3. Update Team



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/team/update/2
```



***Body:***

```js        
{
    "name"  : "ErpanGaming",
    "countryId" : 3,
    "value" : 5000000000
}
```



### 4. Delete User



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/team/delete/2
```



### 5. FindTeamById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/team/get-by-id/1
```



### 6. FindTeamByCountry



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/team/country/3
```



## Player



### 1. FindAllPlayer



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/player/get-all
```



### 2. Create Player



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/player/insert
```



***Body:***

```js        
{
    "userId"    : 3,
    "teamId"    : 3,
    "nickname"  : "Upin",
    "value"     : 1000000
}
```



### 3. Update Player



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/player/update/1
```



***Body:***

```js        
{
    "userId"    : 1,
    "teamId"    : 1,
    "nickname"  : "ErpaaanGimang",
    "value"     : 3000000
}
```



### 4. Delete Player



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/player/delete/1
```



### 5. FindPlayerByTeam



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/player/team/1
```



### 6. FindPlayerByUser



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/player/user/1
```



## Match History



### 1. FindAllMatchHstory



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/match-history/get-all
```



### 2. Create MatchHistory



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/match-history/insert
```



***Body:***

```js        
{
    "date"  : "20/04/2022",
    "tournament"    : "Ilham championship",
    "teamId"    : 1,
    "result"    : "Win",
    "price"     : 30000000  
}
```



### 3. Update MatchHistory



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/match-history/update/1
```



***Body:***

```js        
{
    "date"  : "20/04/2022",
    "tournament"    : "25 championship",
    "teamId"    : 1,
    "result"    : "1St Place",
    "price"     : 3000000  
}
```



### 4. Delete MatchHistory



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/match-history/delete/1
```



### 5. FindMatchHistoryById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/match-history/get-by-id/2
```



### 6. FindMatchHstoryByTeam



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/match-history/team/1
```



## Coach



### 1. FindAllCoach



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/coach/get-all
```



### 2. Create Coach



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/coach/insert
```



***Body:***

```js        
{
    "userId"    : 6,
    "teamId"    : 3,
    "nickname"  : "WIllyWilly",
    "value"     : 1000000
}
```



### 3. Update Coach



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/coach/update/1
```



***Body:***

```js        
{
    "userId"    : 1,
    "teamId"    : 1,
    "nickname"  : "ErpaaanGimang",
    "value"     : 3000000
}
```



### 4. Delete Coach



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/coach/delete/2
```



### 5. FindCoachById



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/coach/get-by-id/2
```



### 6. FindCoachByTeam



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/coach/team/1
```



### 7. FindCoachByUser



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/coach/user/1
```



---
[Back to top](#esport)

