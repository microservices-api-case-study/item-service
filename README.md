# Item Service \(Core\)

[![Build status](https://ci.appveyor.com/api/projects/status/olvuyne97sk9f8cj?svg=true)](https://ci.appveyor.com/project/arockiaanandraj/item-service)

## Architecture

![](https://github.com/microservices-api-case-study/sales-order-service/blob/master/.gitbook/assets/item-service.svg)

## Operations

1. Returns existing item details if the item name is sent as an input
2. Returns all the existing items with their details

### Table

1. Item – id, name, description, price 

**Source:** [https://github.com/microservices-api-case-study/item-service](https://github.com/microservices-api-case-study/item-service)

**Swagger PCF App URL:** [http://anand-item-service.cfapps.io/swagger-ui.html](http://anand-item-service.cfapps.io/swagger-ui.html)

**PCF Logs:** [https://console.run.pivotal.io/organizations/.../spaces/.../applications/.../logs](https://console.run.pivotal.io/organizations/7759b839-ab2d-4c00-9bd9-83a5c8a2e18e/spaces/8d628c1f-6db0-44bc-87f3-68225cdb96d4/applications/489a2e36-3c85-4279-ad63-f84923a21f99/logs)

**REST API Calls:**

1. getAllItems - GET - [http://anand-item-service.cfapps.io/service2/items](http://anand-item-service.cfapps.io/service2/items)

2. getItemByName - GET - [http://anand-item-service.cfapps.io/service2/items/Pen](http://anand-item-service.cfapps.io/service2/items/Pen) 

**Jacoco Code Coverage Report:** [http://anand-item-service.cfapps.io/jacoco/index.html](http://anand-item-service.cfapps.io/jacoco/index.html)
