# Spring Websocket Chat-Application with MongoDB integartion
This repository is created for a simple Websocket chat application with MongoDB integration.
The project uses STOMP protocol with SockJS integrated with Spring Websocket API.

To run this on your local you need MongoDB to be installed. You can install it on Mac with the following command on home brew:
```
brew install mongodb
```
After installing it, you should create a default directory for storing the data:
```
mkdir -p /data/db
```
Also please make sure that the directory has the right privileges with:
```
sudo chown -R `id -un` /data/db
```
Finally you can run MongoDB with the following command:
```
mongod --p 27017 (default is this)
```
After running the MongoDB, you can run the application and by default it will launch on port 8080. You can access it from:
```
http://localhost:8080/
```
