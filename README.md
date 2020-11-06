# market_pulse

Build a Criteria Parser in Android

Replicate the functionality shown in this web app in Android / iOS
https://mp-android-challenge.herokuapp.com/page

What is happening here:
This sample web app lists all available scans as defined on the server. It allows the user to see their criteria and customise them. 

For the purpose of this example, let’s assume that a scan is a set of criteria that can be customised by the user. These scans are defined on the server. We do not need to understand anything more about the scan at this point in time.

What you need to do:

1. Build a replica in android
2. Get scan data from https://mp-android-challenge.herokuapp.com/data
3. Parse the details of the available scans, their name, tags, criteria and customisable parameters
4. Build flow as shown in the web app
    1. Listing Page - show all scans 
    2. Tapping on any scan should show the criteria of each scan
    3. Ability to customise the values in the criteria
5. Code should handle any new scan returned by the API that uses similar criterias 

Out of scope:

1. Saving modified values in the criteria
2. Anything that the web app is not doing

What can impress us:

1. Architecture
2. Clean code
3. Unit tests 
4. Frequent commits to git repo

What not to do:

1. Hardcode values
2. Over-engineer the solution

Once done, kindly share the github repo link for us to review.

Assistance

Reach out to amit@market-pulse.in or call him on +919920620452