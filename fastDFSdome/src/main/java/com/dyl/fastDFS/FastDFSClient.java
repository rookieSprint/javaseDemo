package com.dyl.fastDFS;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient storageClient = null;
	private String stringPath ="";
	
	public FastDFSClient(String conf) throws FileNotFoundException, IOException, Exception {
		if (conf.contains("classpath:")) {
			conf = conf.replaceAll("classpath:", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		//storageServer = null;
		storageClient = new StorageClient(trackerServer, storageServer);
	}
	
	public String uploadFile(String fileName,String extendName,NameValuePair[] meta_list) throws IOException, Exception{
		//String[] strings = storageClient.upload_appender_file(fileName, extendName, meta_list);
		String[] strings = storageClient.upload_file(fileName, extendName, meta_list);
		for (String string : strings) {
			stringPath += string + "/"; 
		}
		stringPath = stringPath.substring(0, stringPath.length()-1);
		return stringPath;
	}
	public String uploadFile(String fileName,String extendName) throws IOException, Exception{
		return uploadFile(fileName, extendName, null);
	}
	
	public String uploadFile(String fileName) throws IOException, Exception{
		return uploadFile(fileName, null, null);
	}
}
