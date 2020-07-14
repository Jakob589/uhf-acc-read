#!/usr/bin/python3

import csv
import random
import time

import json, subprocess, os, sys
cmd = "echo 192.168.1.60:9090 | java -jar build/UhfRfidReader.jar"

vector = {"x": "1", "y": "1", "z": "1", "status": "down", "QoS": "bad"}

count = 0
x = 1000
y = 1000
z = 1000
fieldnames = ["count", "x", "y", "z"]

with open('data.csv', 'w') as csv_file:
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
    csv_writer.writeheader()

p = subprocess.Popen(cmd,
                     shell=True,
                     bufsize=64,
                     stdout=subprocess.PIPE)

for line in p.stdout:

    raw_data = str(line.rstrip())
    data = raw_data[2:(len(raw_data) -1)]
    if data == "1|1|2,0006&3,010005": data = '{"x": "0", "y": "0", "z": "0", "status": "down", "QoS": "bad"}'
    last_vector = vector
    vector = json.loads(data)
    if (int(vector["x"]) == 0 & int(vector["y"]) == 0 & int(vector["z"]) == 0): vector = last_vector
    print(vector)


    with open('data.csv', 'a') as csv_file:
        csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames)

        info = {
            "count": count,
            "x": x,
            "y": y,
            "z": z
        }

        csv_writer.writerow(info)
        print(count, x, y, z)

        count += 1
        x = vector["x"]
        y = vector["y"]
        z = vector["z"]



    p.stdout.flush()

