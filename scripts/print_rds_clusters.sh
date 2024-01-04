#!/bin/bash

# Configure AWS CLI
#aws configure

# Define usage
usage() {
  echo "Usage: $0 -r <region>"
  exit 1
}


REGION=$1

if [ -z "$REGION" ]; then
  REGION=us-east-1
  echo "default Region is required" $REGION
fi


# Get and print clusters
clusters=($(aws rds describe-db-clusters --region $REGION --query "DBClusters[*].DBClusterIdentifier" --output text))
for cluster in "${clusters[@]}"; do echo $cluster; done

for cluster in "${clusters[@]}"; do
  echo "Cluster: $cluster"
done
