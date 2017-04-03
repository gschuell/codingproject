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