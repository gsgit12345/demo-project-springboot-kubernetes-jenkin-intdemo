#!/bin/bash
sed "s/tagVersion/$1/g" appdeployment.yaml > apppod.yml
