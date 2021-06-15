`Design Patterns: Builder & Singleton`

# GIFFeed 

1. [Description](#description)
2. [Setup](#setup)
3. [Test](#test)

## Description

> This is a college activity about builder and singleton patterns.
 
The project has been made with Spring Web and Maven, and consists about a simple REST API, 
with a single GET endpoint (besides the root). The point was to build a small application 
that implements singleton and builder patterns.

## Setup

> You will need a Java IDE, like **IntelliJ IDEA**, Eclipse, Netbeans or maybe VS Code w/ Java extensions, 
> and a REST Client, a browser or VS Code w/ a REST client extension.

Also make sure that you have `JDK 11` installed, if not, go get it.

Open the project and let Maven download all the dependencies, so you can build and run it.

After starting the application, open the browser, or a **REST Client** like **Postman** or **Insomnia**, 
and go to `localhost:8080` there you will find more information about how to use the API.

## Test

There is a **Test package** that tests both singleton services (`HttpServiceSingleton` and `TenorServiceSingleton`), 
and the builder (`GifBuilder`). Make sure that the API is running before you run those tests.

## Author

[Aaron Carneiro (@euaaron)](https://github.com/euaaron)
