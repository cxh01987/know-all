package com.jarris.bean;

public class UploadPdfBean {
	
    /**
	 * pdf file
	 */
    private byte[] pdfFile;
    
	/**
     * 客户编号
     */
    private String customerNumber;
    
    /**
     * 通过fileId做pdf类型分类
     */
    private String fileId;
    
    /**
     * 预留字段
     */
    private String fileType;
    
    public byte[] getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(byte[] pdfFile) {
		this.pdfFile = pdfFile;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
