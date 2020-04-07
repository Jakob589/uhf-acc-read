build jar:

ant buld
ant run
ant clean

run jar:
java -jar build/UhfRfidReader.jar

after running the jar, you are prompted with input IP:
Enter the ip and do not forger the port!!!
format is: 192.168.1.60:9090

if reader not connected, or tag not responding program returns the following:
1|1|2,0006&3,010005 ->(used antennas, where to start reading and how long)

If text above is displayed it means that you have one of the following problems:
1. IP not typed correctly (port!)
2. Static ip of reader is in your DHCP range
3. TAG not close enogh
4. Not the right type of tag - (has to be farsens EVAL01-Kineo-RM (6C) or similar)

When connected to the reader program prints:
"sucess" 

If checksum ok program prints:
"x":"667" "y":"-117" "z":"720" "status":"up" "QoS":"best"  
where the measurements are on the interval from -1000 to +1000. If recieved power is low QoS obtains the "good" flag.

if checksum is not ok, vectors obtain value of 0, and QoS flag turns to "bad"
