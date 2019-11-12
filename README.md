# Report Generation System

This is a system that receives a file through REST and generates a JSON report from the information contained in the file..

---
## Requeriments

- Java 8
- Tomcat 9

---

## About the operation
A REST request is made, sent a file with the standardized data. Then the report will be returned in JSON format.

You can use the tab of your choice, here I am using "/".

- Salesman data has the format id 001 and the line will have the following format:

``001/CPF/Name/Salary``

- Customer data has the format id 002 and the line will have the following format:

``002/CNPJ/Name/Business Area``

- Sales data has the format id 003. Inside the sales row, there is the list of items, which is wrapped by square brackets []. The line will have the following format:

``003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name``
