#!/bin/bash
ios-deploy --debug --bundle /Users/rm2652/Documents/ipa/SBC-Test.ipa
sleep 10
mvn clean test -PiOS
