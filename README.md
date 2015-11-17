# eAdmin backend services

## TO BE COMPLETED

# How to...
En local, il faut soit changer les attributs HOST, PORT, USERNAME et PASSWORD de la classe DbManager, soit lancer un CouchDb local dans Docker...

## CouchDb Local sur Docker
http://docs.docker.com/windows/step_one/
https://hub.docker.com/r/frodenas/couchdb/

### Lancer et Configurer CouchDb sur Docker
Sous Linux, il faut l'exécuter en sudo. Sous Windows, certainement en Admin, et sous MacOS X... en sudo ?

#### Installer (et démarer) un CouchDb
docker run -d --name couchdb -p 5984:5984 -v ~/couchdb:/data -e COUCHDB_USERNAME=couchdb  -e COUCHDB_PASSWORD=8o#pq-CKMx -e COUCHDB_DBNAME=eadmin  frodenas/couchdb 

#### Administrer CouchDb après installation...
docker stop couchdb
docker start couchdb

#### RTFM
docker --help

# En Intégration
Le point d'accès pour lister tous les services est :
https://apps.athena-software.fr/eadmin-ground-backend/swagger-ui.html
