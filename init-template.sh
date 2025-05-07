#!/bin/bash

# Get values
REPO_NAME=$(basename `git rev-parse --show-toplevel`)
USERNAME=$(git config user.name)
YEAR=$(date +%Y)

# Replace placeholders in files
find . -type f \( -name "*.md" -o -name "LICENSE.template" \) -exec sed -i \
-e "s/{{PROJECT_NAME}}/${REPO_NAME}/g" \
-e "s/{{USERNAME}}/${USERNAME}/g" \
-e "s/{{YEAR}}/${YEAR}/g" {} +

# Rename LICENSE
mv LICENSE.template LICENSE

echo "Template initialized for $REPO_NAME."
