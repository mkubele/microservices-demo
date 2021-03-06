# Microservices demo
[![Build master & deploy](https://github.com/mkubele/microservices-demo/actions/workflows/master.yml/badge.svg)](https://github.com/mkubele/microservices-demo/actions/workflows/master.yml)

Microservices demo project using Spring, Kotlin, RabbitMQ, PostgreSQL and Gradle and deployed to Azure Kubernetes.<br>
![diagram-Main drawio](https://user-images.githubusercontent.com/34385616/149660407-8b13d11e-6532-4124-81e6-b8641af0dbcc.png)
### API
#### Rest
- API is accessible on endpoint [microservices-demo.germanywestcentral.cloudapp.azure.com/api/v1/customers](microservices-demo.germanywestcentral.cloudapp.azure.com/api/v1/customers)
- Documentation (Swagger) is available [HERE](http://microservices-demo.germanywestcentral.cloudapp.azure.com/swagger-ui.html)
#### GraphQL
- API is accessible on endpoint [microservices-demo.germanywestcentral.cloudapp.azure.com/api/v1/customers](microservices-demo.germanywestcentral.cloudapp.azure.com/api/v2/customers)
- Documentation (GraphiQL) is available [HERE](http://microservices-demo.germanywestcentral.cloudapp.azure.com/graphiql?query=%23%20Welcome%20to%20GraphiQL%0A%23%0A%23%20GraphiQL%20is%20an%20in-browser%20tool%20for%20writing%2C%20validating%2C%20and%0A%23%20testing%20GraphQL%20queries.%0A%23%0A%23%20Type%20queries%20into%20this%20side%20of%20the%20screen%2C%20and%20you%20will%20see%20intelligent%0A%23%20typeaheads%20aware%20of%20the%20current%20GraphQL%20type%20schema%20and%20live%20syntax%20and%0A%23%20validation%20errors%20highlighted%20within%20the%20text.%0A%23%0A%23%20GraphQL%20queries%20typically%20start%20with%20a%20%22%7B%22%20character.%20Lines%20that%20starts%0A%23%20with%20a%20%23%20are%20ignored.%0A%23%0A%23%20An%20example%20GraphQL%20query%20might%20look%20like%3A%0A%23%0A%23%20%20%20%20%20%7B%0A%23%20%20%20%20%20%20%20field(arg%3A%20%22value%22)%20%7B%0A%23%20%20%20%20%20%20%20%20%20subField%0A%23%20%20%20%20%20%20%20%7D%0A%23%20%20%20%20%20%7D%0A%23%0A%23%20Keyboard%20shortcuts%3A%0A%23%0A%23%20%20Prettify%20Query%3A%20%20Shift-Ctrl-P%20(or%20press%20the%20prettify%20button%20above)%0A%23%0A%23%20%20%20%20%20%20%20Run%20Query%3A%20%20Ctrl-Enter%20(or%20press%20the%20play%20button%20above)%0A%23%0A%23%20%20%20Auto%20Complete%3A%20%20Ctrl-Space%20(or%20just%20start%20typing)%0A%23%0A%0Amutation%20%7B%0A%20%20%20%20registerCustomer(firstName%3A%20%22A%22%2C%20lastName%3A%20%22B%22%2C%20email%3A%20%22test%40test.com%22)%20%7B%0A%20%20%20%20%20%20%20%20id%0A%20%20%20%20%20%20%20%20firstName%0A%20%20%20%20%20%20%20%20lastName%0A%20%20%20%20%20%20%20%20email%0A%20%20%20%20%7D%0A%7D)
### UI
- Simple UI that presents data is available [HERE](http://microservices-demo.germanywestcentral.cloudapp.azure.com/customers)
