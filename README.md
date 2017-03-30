There is a folder called scripts under /src/main/resources that contains a curl script to add a single ad campaign. This can be modified or duplicated to play with different scenarios.

Clone https://github.com/gschuell/codingproject.

From the top level, run mvn spring-boot:run and execut4e the curl script. Also from a browser go to htto://localhost:8080/ad/Partner%201 to see the added campaign, as well as messages when no ad exists, or the ad exists but has expired.
