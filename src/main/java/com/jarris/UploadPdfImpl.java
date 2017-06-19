package com.jarris;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.WebServiceException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jarris.bean.UploadPdfBean;

public class UploadPdfImpl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static URL UPLOADPDFSERVICEIMPL_WSDL_LOCATION;
	private static Logger log = LoggerFactory.getLogger(UploadPdfImpl.class);

	/**
	 * 鏋勯�犲嚱鏁板姞杞経RL
	 * @param wsdlUrl
	 */
	public UploadPdfImpl(String wsdlUrl) {
		URL url = null;
		try {
			url = new URL(wsdlUrl);
		} catch (MalformedURLException ex) {
			throw new WebServiceException(ex);
		}

		UPLOADPDFSERVICEIMPL_WSDL_LOCATION = url;
	}

	/**
	 * 涓婁紶PDF鍒皐ebService
	 * @param fileBean
	 * @return
	 */
	@SuppressWarnings("restriction")
	public Integer uploadPdfFile(UploadPdfBean fileBean) {

		int iResult = 1005;

		String customerNumber = fileBean.getCustomerNumber();
		String fileId = fileBean.getFileId();
		byte[] pdfFile = fileBean.getPdfFile();

		if (pdfFile == null || pdfFile.length == 0) {
			logger.debug("pdfFile涓嶈兘涓虹┖锛�" + pdfFile);
			return 1004;
		}
		if (StringUtils.isBlank(customerNumber)) {
			logger.debug("customerNumber涓嶈兘涓虹┖锛�" + customerNumber);
			return 1002;
		}
		if (StringUtils.isBlank(fileId)) {
			logger.debug("fileId涓嶈兘涓虹┖锛�" + fileId);
			return 1003;
		}
		String pdfFileStr = new sun.misc.BASE64Encoder().encode(pdfFile);
//		String pdfFileStr = "";
		// 瀹氫箟璇锋眰鍗忚
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" ?>");
		buffer.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		buffer.append("<S:Body>");
		buffer.append("<ns2:uploadPdf xmlns:ns2=\"http://business.vtcsvc.chinasofti.com/\">");
		buffer.append("<pdfFile>" + pdfFileStr + "</pdfFile>");
		buffer.append("<customerNumber>" + customerNumber + "</customerNumber>");
		buffer.append("<fileId>" + fileId + "</fileId>");
		buffer.append("<fileType />");
		buffer.append("</ns2:uploadPdf>");
		buffer.append("</S:Body></S:Envelope>");

		iResult = connectWebService(buffer);
		return iResult;
	}

	/**
	 * 寤虹珛涓巜ebService鐨勮繛鎺ワ紝骞跺洖鍘昏繑鍥炵姸鎬�
	 * @param sb
	 * @return
	 */
	public static int connectWebService(StringBuffer buffer) {

		int iResult = 1005;

		HttpURLConnection conn = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			// 鑾峰彇connection
			conn = (HttpURLConnection) UPLOADPDFSERVICEIMPL_WSDL_LOCATION.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

			// 璁剧疆瓒呮椂鏃堕棿
			conn.setConnectTimeout(15000);
			conn.setReadTimeout(30000);

			os = conn.getOutputStream();
			os.write(buffer.toString().getBytes());
			os.flush();
			is = conn.getInputStream();

			byte[] data = new byte[1024];
			int len = 0;
			String result = "";
			// 璇诲彇WebService杩斿洖鐨刋ML鏁版嵁
			while ((len = is.read(data)) != -1) {
				String ss = new String(data, 0, len, "UTF-8");
				result += ss;
			}

			// 鎴彇杩斿洖鍊�
			result = result.substring(result.indexOf("<UploadPdfService>") + 18, result.indexOf("</UploadPdfService>"));
			iResult = Integer.parseInt(result);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		} finally {
			if (is != null){
			try {
				is.close();
			} catch (IOException e) {
				log.error(e.getMessage(),e);
			}
		}
			if ( os != null){
				try {
					os.close();
				} catch (IOException e) {
					log.error(e.getMessage(),e);
				}	
			}
			if(conn!=null){
				conn.disconnect();
			}
			
		}

		return iResult;
	}

	public static URL getUrl(String wsdlUrl) {

		URL url = null;
		try {
			url = new URL(wsdlUrl);
		} catch (MalformedURLException ex) {
			throw new WebServiceException(ex);
		}
		return url;
	}
}
