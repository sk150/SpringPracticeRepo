package com.sftp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.practice.FilePrinter;

public class DemoSftp {

	public static void main(String[] args) throws SftpException, JSchException, IOException {
		String hostname = "192.168.0.42";
        String login = "development";
        String password = "think_development";
        String directory = "/opt/logs/httpd/";
 
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "yes");
 
        JSch ssh = new JSch();
        Session session = ssh.getSession(login, hostname, 22);
        session.setConfig(config);
        session.setPassword(password);
        session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();
 
        ChannelSftp sftp = (ChannelSftp) channel;
        sftp.cd(directory);
        Vector<LsEntry> files = sftp.ls("*");
        System.out.printf("Found %d files in dir %s%n", files.size(), directory);
 
        for (ChannelSftp.LsEntry file : files) {
            if (file.getAttrs().isDir()) {
                continue;
            }
            System.out.printf("Reading file : %s%n", file.getFilename());
            BufferedReader bis = new BufferedReader(new InputStreamReader(sftp.get(file.getFilename())));
            System.out.println("Buffered InputStream :: "+bis);
            
            
            String line = null;
            int count=0;
            while ((line = bis.readLine()) != null) {
            	count++;
                System.out.println(count+" :: "+line);
            }
            bis.close();
        }
 
        channel.disconnect();
        session.disconnect();
	}

}
