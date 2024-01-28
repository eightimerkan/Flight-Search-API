# Flight-Search-API

This is a backend API for a flight search application.

## Table of Contents
- [Overview](#overview)
- [Data Modeling](#data-modeling)
- [CRUD Structure](#crud-structure)
- [Search API](#search-api)
- [RESTful Service](#restful-service)
- [Authentication](#authentication)
- [Scheduled Background Jobs](#scheduled-background-jobs)
- [Version Control](#version-control)
- [Documentation](#documentation)

## Overview

This project serves as the backend for a flight search application. It includes features such as data modeling, CRUD operations, a search API, RESTful service, authentication, and scheduled background jobs.

## Data Modeling

The data for the application is modeled in a relational database, which includes two main entities: Flights and Airports. The structure is as follows:

- Flights
  - ID
  - Departure Airport
  - Arrival Airport
  - Departure Date/Time
  - Return Date/Time
  - Price
- Airports
  - ID
  - City
 
  - ![image](https://github.com/eightimerkan/Flight-Search-API/assets/94108688/2a5d3950-b601-4414-9203-5f447ad9940f)


## CRUD Structure

The application follows a CRUD (Create, Read, Update, Delete) structure for both Flights and Airports. This allows for the consistent management of data.

### CRUD Endpoints

- Flights
  - Create: `/flights` (POST)
  - Read: `/flights/{id}` (GET)
  - Update: `/flights/{id}` (PUT)
  - Delete: `/flights/{id}` (DELETE)
- Airports
  - Create: `/airports` (POST)
  - Read: `/airports/{id}` (GET)
  - Update: `/airports/{id}` (PUT)
  - Delete: `/airports/{id}` (DELETE)

![image](https://github.com/eightimerkan/Flight-Search-API/assets/94108688/1cbe95bd-70b7-4a10-8dd5-3f32e80f8ad5)
![image](https://github.com/eightimerkan/Flight-Search-API/assets/94108688/91facdeb-bf03-485c-96b4-1504d6615a88)



## Search API

The application provides a search API that lists flights based on the departure and arrival locations, departure date, and return date. The API endpoint is `/search`.

- Single Trip: `/search?departure={departure}&arrival={arrival}&departureDate={departureDate}`
- Round Trip: `/search?departure={departure}&arrival={arrival}&departureDate={departureDate}&returnDate={returnDate}`

- ![image](https://github.com/eightimerkan/Flight-Search-API/assets/94108688/7a207d2c-bb0a-4c9d-b5ca-46e549aa474e)


## RESTful Service

The API is built using Java, specifically with the Spring Boot framework. It follows RESTful architecture, enabling easy integration with other systems.

## Authentication

The application includes an authentication structure to verify user identity and manage authorization. The chosen authentication mechanism can be configured as needed.

## Scheduled Background Jobs

A scheduled job runs daily to fetch flight information from a mock third-party API and stores it in the database.

## Version Control

Git version control is utilized for the project. The codebase is hosted on GitHub.

## Documentation

API documentation is generated using Swagger. You can access the documentation by navigating to `/swagger-ui.html` when the application is running.
