#!/bin/bash


#find instances in us-east-1 region with status "running"
aws ec2 describe-instances --region us-east-1 --filters 
"Name=instance-state-name,Values=running" --query 
"Reservations[].Instances[].InstanceId" --output text

#get list of valid ami in region us-east-1
aws ec2 describe-images --region us-east-1 --owners amazon --filters "Name=name,Values=amzn2-ami-hvm-2.0.????????.?-x86_64-gp2"

#create ec2 instance in region us-east-1
aws ec2 run-instances --image-id ami-0ccb473bada910e74 --instance-type t2.micro  --region us-east-1
#find instances in us-east-1 in status running
aws ec2 describe-instances --region us-east-1 --filters "Name=instance-state-name,Values=running" | grep InstanceId

#find rds cluster in us-east-1
aws rds describe-db-clusters --region us-east-1

