#!/bin/bash

# Test valid region
. ./scripts/print_rds_clusters.sh
echo "Test valid region passed"

# Test invalid region
./scripts/print_rds_clusters.sh -r invalid 2>/dev/null && echo "Test invalid region failed" || echo "Test invalid region passed"

# Verify output 
expected="cluster1 cluster2"
output=$("./scripts/print_rds_clusters.sh")
if [[ "$output" == "$expected" ]]; then
  echo "Output matches"
else
  echo "Output does not match"
fi

# Add documentation
