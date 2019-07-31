package com.fire.thymeleaf.upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://temp//";
    
    @GetMapping("/")
    public String index(){
    	return "upload";
    }
    
    @PostMapping("/upload") //
    public String singleFileUpload(@RequestParam("file")MultipartFile file,RedirectAttributes redirectAttributes){
    	
    	if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadRes";
        }
    	
    	 try {
             // Get the file and save it somewhere
             byte[] bytes = file.getBytes();
             Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
             Files.write(path, bytes);

             redirectAttributes.addFlashAttribute("message",
                     "You successfully uploaded '" + file.getOriginalFilename() + "'");

         } catch (IOException e) {
             e.printStackTrace();
         }

         return "redirect:/uploadRes";
    }
	
    @GetMapping("/uploadRes")
    public String uploadStatus() {
        return "uploadRes";
    }
	
}
