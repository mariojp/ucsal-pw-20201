#!/bin/bash
#Inicializa o banco
java -cp ./hsqldb.jar org.hsqldb.server.Server --database.0 file:sistema.db --dbname.0 banco