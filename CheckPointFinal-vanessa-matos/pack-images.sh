#!/bin/bash

echo "docker-compose down"
docker-compose -f docker-compose-full.yml down
echo "docker-compose rm -f"
docker-compose -f docker-compose-full.yml rm -f

echo "build"
cd config
./mvnw clean package -DskipTests
cd ..
cd eureka
./mvnw clean package -DskipTests
cd ..
cd catalogo
./mvnw clean package -DskipTests
cd ..
cd movie
./mvnw clean package -DskipTests
cd ..
cd series
./mvnw clean package -DskipTests
cd ..
cd gateway
./mvnw clean package -DskipTests
cd ..

echo "docker-compose build"
docker-compose -f docker-compose-full.yml build

echo "docker-compose up"
docker-compose -f docker-compose-full.yml up

# Restart servicos que dependem do config
# docker-compose -f docker-compose-full.yml restart series movie catalogo gateway
# docker-compose -f docker-compose-full.yml restart  gateway