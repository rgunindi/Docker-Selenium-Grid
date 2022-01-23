#!/bin/bash
selVersion="/hub:4.1.1-20220121";
fullV=selenium$version;
seleniumContainerName=selenium-hub-$RANDOM
browserVersion="4.1.1-20220121";
docker network rm grid;
docker network create grid;sleep 2;
docker run -d -p 4442-4444:4442-4444 --net grid --name $seleniumContainerName selenium$selVersion;sleep 3;
docker run -d --net grid -e SE_EVENT_BUS_HOST=$seleniumContainerName \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-chrome:$browserVersion;sleep 3;
docker run -d --net grid -e SE_EVENT_BUS_HOST=$seleniumContainerName \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-edge:$browserVersion;sleep 3;
docker run -d --net grid -e SE_EVENT_BUS_HOST=$seleniumContainerName \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    selenium/node-firefox:$browserVersion;
