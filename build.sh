#!/bin/bash

mvn clean package

echo "======================================================"

echo "waiting.........."

echo "=========================Exam1 start========================"
java -jar Exam1/target/Exam1.jar
echo "============================ends==========================="

echo "waiting.........."

echo "=========================Exam3 start========================"
java -jar Exam3/target/Exam3.jar
echo "============================ends==========================="
