#!/bin/sh

imageName="sergeystol/mongo-crud"
imageVersion="v1"

docker build -f local.Dockerfile -t $imageName:$imageVersion --progress=plain --no-cache .
if [ $? != 0 ] ; then # [ $? != 0 ] - means that previous command isn't successful
    exit 1 # General errors
fi
# Don't forget to authorize on docker hub before using command `docker login`
docker push $imageName:$imageVersion
