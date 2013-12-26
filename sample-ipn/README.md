IPN Sample/Tester
=================

Prerequisite
------------
* Java 1.7+
* Maven 3.x

How to Run
----------
    mvn exec:java

Test
----
Please note the computer running this application must have an internet accessible IP address. If it is behind a
firewall, there is some network configuration required. The steps to perform the necessary network configuration
various depending on test location and is beyond the scope of this README.

After the network is configured such that this computer can receive HTTP post message on 4567 port on this computer,
configure in MWS, Notification Group to post to `http://{computer_external_ip}:4567/ipn`. This application will print
the post message to the console.