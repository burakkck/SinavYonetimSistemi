package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Ogrenci;



@WebServlet("/ogrencikayit")
public class OgrenciKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	        Hashtable<String, String> rqParams = new Hashtable<String, String>();
	        String fileName = null;
	        InputStream streamImg = null;
	        try {
	            // parses the request's content to extract file data
	            List<FileItem> formItems = upload.parseRequest(request);
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        fileName = item.getName().replace(" ", "-");
	                        
	                        System.out.println("file name : " + fileName);
	                        // saves the file on disk
	                        streamImg = item.getInputStream();
	                        
	                    }
	                    if(item.isFormField()){
	                    	InputStream stream = item.getInputStream();
	                    	rqParams.put(item.getFieldName(), Streams.asString(stream,"utf-8"));
	                    }
	                }
	            }
	            
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
	        String ad = rqParams.get("ad");
	        String soyad = rqParams.get("soyad");
	        String no = rqParams.get("ogrencino");
	        String sinif = rqParams.get("sinif");
	        String fakulteid = rqParams.get("fakulte");
	        String bolumid = rqParams.get("bolum");
	        String sifre = rqParams.get("password");
	        String email = rqParams.get("email");
			
			
//			System.out.println("ad : " + ad);
//			System.out.println("soyad : " + soyad);
//			System.out.println("no : " + no);
//			System.out.println("sinif : " + sinif);
//			System.out.println("fakulteid : " + fakulteid);
//			System.out.println("bolumid : " + bolumid);
//			System.out.println("sifre : " + sifre);
//			System.out.println("resim : " + streamImg);
			
			Fakulte fakulte = new Fakulte(Integer.parseInt(fakulteid));
			Bolum bolum = new Bolum();
			bolum.setId(Integer.parseInt(bolumid));
			Ogrenci ogrenci = new Ogrenci(ad, soyad, Integer.parseInt(sinif), bolum, fakulte, no, sifre,email);
			ogrenci.setStreamImg(streamImg);
			int state = OgrenciDAO.addOgrenci(ogrenci);
			String message;
			if(state == 1){
				message = "Kayıt işlemi başarılı";
			}else{
				message = "Kayıt işlemi sırasında bir hata oluştu";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("index").forward(request, response);
	}
}
