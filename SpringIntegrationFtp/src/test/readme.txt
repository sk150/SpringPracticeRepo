Project Details :-

=========================
Spring Integration-
=========================
1. Reference :: 
https://www.safaribooksonline.com/library/view/understanding-spring-integration/9781491968703/?utm_medium=referral&utm_source=oreilly.com&utm_campaign=welcome&utm_content=infinite+skills+redirect+product
a) File System Integrations >> Reading Files :: read-integration-context.xml :: sample.txt
b) Integration With FTP >> FTP Inbound Channel Adapter :: ftp-integration-context.xml :: log.txt, log1.txt downloaded from ftp server
c)* CASE :: local-integration-context.xml :: Testing on local system on which FTP not installed and configured
	1. create /opt/logs >> log.txt
	2. user and group
		a) List of groups :: sudo nano /etc/group
		b) User in group ::  grep 'sudo' /etc/group
	2. set permissions -R on opt folder chmod=755 and chown=user::usergroup [IMPORTANT]
		a) sudo chown -R thinktalent17:sudo /opt
		b) sudo chmod -R 755 /opt
	3. host=192.168.0.76, username=thinktalent17, password=A11qgtij
	4. no FTP installed
	5. OUTPUT :: failed to create FTPClient :: although files were read and written to folder 



============================================
Server FTP configuration & Installation-
============================================
1. Reference :: for CENTOS >> 192.168.0.76
https://www.linux.com/blog/install-and-configure-ftp-server-redhatcentos-linux

http://www.linuxnix.com/7-steps-to-install-and-configure-ftp-server/

2. Create a folder inside /opt/logs
a) List of groups :: sudo nano /etc/group
b) User in group ::  grep 'sudo' /etc/group
c) opt and log must have chmod=755 and chown=user::usergroup
where user must be the same which is mentioned in-
<property name="username" value="ttserver"/> i.e inside ftp-integration-context 

=================================================================
Spring integration ftp inbound channel adapter -ANNOTATION BASED
=================================================================
Reference :: http://docs.spring.io/spring-integration/archive/1.0.0.M3/reference/html/ch04s03.html

===============================================
Spring integration SFTP inbound channel adapter  
===============================================
http://docs.spring.io/spring-integration/reference/html/sftp.html
1) jsch required :: http://docs.spring.io/spring-integration/reference/html/sftp.html#sftp-jsch-logging
2) example :: https://atechblogagain.wordpress.com/2013/06/04/simple-sftp-example-in-java-with-jsch/
3) info :: xml - not required, file - /opt/logs/httpd/access_log.log
4) SFTP :: DemoSftp
5) SFTP :: WITH XML >> /sftp/withxml . SftpBootApplication + boot

