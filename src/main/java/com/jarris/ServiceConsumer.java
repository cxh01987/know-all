package com.jarris;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jarris.bean.UploadPdfBean;

@Path("ServiceConsumer") 
public class ServiceConsumer {

	@GET
	@Produces("text/plain")
	public Response getExample() {

		byte[] pdfFile = readFileData("D:/Mule/output2/databass1.txt");
		UploadPdfBean fileBean = new UploadPdfBean();
		fileBean.setPdfFile(pdfFile);
		fileBean.setCustomerNumber("54321");
		fileBean.setFileId("test10");
		return Response.status(Status.OK).entity("result:"+fileBean).build();
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
