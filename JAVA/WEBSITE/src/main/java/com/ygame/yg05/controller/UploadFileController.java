package com.ygame.yg05.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UploadFileController {
    public static final String uploading = System.getProperty("user.dir") + "/templates/uploads/";
    
    // Multiple file upload
    @RequestMapping(value = "/upload_img", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
        @RequestParam("uploadfile") MultipartFile uploadfile) {

      try {
        // Get the filename and build the local file path (be sure that the 
        // application have write permissions on such directory)
        String filename = uploadfile.getOriginalFilename();
        String filepath = Paths.get(uploading, filename).toString();

        // Save the file locally
        BufferedOutputStream stream =
            new BufferedOutputStream(new FileOutputStream(new File(filepath)));
        stream.write(uploadfile.getBytes());
        stream.close();
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile
}
