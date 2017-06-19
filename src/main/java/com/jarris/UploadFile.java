package com.jarris;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jarris.bean.UploadPdfBean;
import javax.ws.rs.core.Response.Status;

@Path("UploadFile") 
public class UploadFile {
	
	 @GET
	 @Produces("text/plain")
	public Response getExample() {
		String url = "http://127.0.0.1:8080/group-vtc-service-prd/webservice/UploadPdfServiceImpl?wsdl";
		byte[] pdfFile = readFileData("D:/Mule/output2/databass1.txt");
		int iResult = 0000;
		UploadPdfBean fileBean = new UploadPdfBean();
		fileBean.setPdfFile(pdfFile);
		fileBean.setCustomerNumber("54321");
		fileBean.setFileId("test10");

		UploadPdfImpl uploadPdfImpl = new UploadPdfImpl(url);
		try {
			iResult =uploadPdfImpl.uploadPdfFile(fileBean);
			System.out.println("iResult"+iResult);
			
		} catch (Exception e) {
			System.out.println("异常:" + e);
			e.printStackTrace();
		}
	 return Response.status(Status.OK).entity("Result:" + String.valueOf(iResult)).build();
//		return "REST and be well.";
	}

	/**
	 * 读取文件内容
	 * 
	 * @param filePath
	 * @return
	 */
	public static byte[] readFileData(String filePath) {

		File file = new File(filePath);
		FileInputStream fis = null;

		byte[] retByte = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(retByte);
			fis.close();
		} catch (Exception e) {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e1) {
				}
			}
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
		}

		return retByte;
	}
}
