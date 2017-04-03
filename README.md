There is a script under /src/main/resources that contains a bash script to run diffrent scenarios,
 add an ad, list the ad, try to run another ad with the ame partner_id to display a message that ad already exists,
 as well as adding multiple parthers with ads and list independently. Note the application must be running for this script to execute properly.


Clone https://github.com/gschuell/codingproject.

From the top level, run mvn spring-boot:run and execute the curl script TestAdServer.sh. 
Also from a browser go to http://localhost:8080/ad/Partner_1 to see the added campaign, as well as 
messages when no ad exists, or the ad exists but has expired.

{
"partner_id": "Partner_1",
"duration": 20,
"ad_content": "Now you can be your very own business owner...see how"
}

The script can be be edited to increase durations and add extra partners. This script can also be enhanced 
to list all active ads, although this functionality hasn't been fully implemented yet.


Here is the script as it currently exists:

#!/bin/bash

curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_1","duration":20,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad
sleep 10s
echo "Display current active ad\n"
curl -H "Content-Type: application/json" http://localhost:8080/ad/Partner_1
sleep 12s
echo "Try to display ad after duration exceeded\n"
curl -H "Content-Type: application/json" http://localhost:8080/ad/Partner_1
echo "Ad another ad record for Partner_1\n"
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_1","duration":20,"ad_content":"Now you can own your oen hair salon..see how"}' http://localhost:8080/ad
sleep 10s
echo "Attempt to add another add for same partner_id with same duration\n"
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_1","duration":20,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad
sleep 12s
echo "Try to display an ad for an expired ad\n"
curl -H "Content-Type: application/json" http://localhost:8080/ad/Partner_1
echo "Adding some more ads for other partners. then list them\n"
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_1","duration":200,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_11","duration":200,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_21","duration":200,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad
curl -H "Content-Type: application/json" -X POST -d '{"partner_id": "Partner_177","duration":200,"ad_content":"Now you can be your very own business owner...see how"}' http://localhost:8080/ad

You can view these entries in a browser or with Curl using the URL localhost:8080/ad/{partner_id}.