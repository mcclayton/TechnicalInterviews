#!/bin/bash

command -v tree >/dev/null 2>&1 || {
    echo "tree Command Was Not Found. Not Updating README."
    exit 1
}

# Update the README with new file structure.
cat ./.readme_gen/README_TITLE.md > README.md
tree >> README.md

echo "README was updated."

git add README.md
