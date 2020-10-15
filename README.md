# MathApi
This is a RESTful API that allows to solve math expressions through GET and POST requests. So given a math expression a number is returned as response. Built with Java (Spring Boot + Maven)
### Libraries used

- [mXparser](http://mathparser.org/) (check supported expressions)
- [Lombok](https://projectlombok.org/)

## Usage

### GET Request

```
GET http://localhost:9000/api/math
```

#### Request Params

Parameter | Description | 
------------ | ------------- |  
expression | 	math expression to be evaluated
precision | 	number of significant digits in formatted output. It's 0 by default

> You must encode characters like "+" and "^" for this request to work. URL Encoding replaces "unsafe" characters with "%" followed by their hex equivalent.
```
4 + 4 ----> 4%2B4
4^4 ----> 4%5E4
```
#### Examples

http://localhost:9000/api/math?expression=4%5E2*25%2Bsqrt(9)
http://localhost:9000/api/math?expression=2*(7-3)
http://localhost:9000/api/math?expression=1.2*(2%2B4.5)*4.321&precision=5
http://localhost:9000/api/math?expression=2%2B3*sqrt(4)
http://localhost:9000/api/math?expression=15.52/7&precision=3

### POST Request

```
POST http://localhost:9000/api/math
```

#### Request Body
```json
{
  "expression":"5/8 + (-4 * 25 / sqrt(25)) - 3^6", 
  "precision":6
}
```

## Response

 Response | Status | Body
------------ | ------------- |  ------------- |
Success | 	`200 OK` | Result of the expresion
Failure | 	`400 BAD REQUEST` | Error message


