/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.controllers.files;

import com.yao.oa.domains.files.Attachment;
import com.yao.oa.services.files.AttachmentService;
import com.yao.oa.services.user.UsersService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author yao
 */
@RestController
@RequestMapping("/services/attachments")
public class AttachmentController {
    @Resource
    private AttachmentService attachService;
    @Resource
    private UsersService userService;
    @RequestMapping(value = "/upload",method = {RequestMethod.POST,RequestMethod.PUT},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Attachment> upload(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        final String attachRootDirectory = "/home/yao/attachs";
        DateTime current = new DateTime();
        StringBuilder sb = new StringBuilder(attachRootDirectory);
        String orginFilename = file.getOriginalFilename();
        String suffix = orginFilename.substring(orginFilename.lastIndexOf('.'),orginFilename.length());
        String dirStr = sb.append("/").append(current.getYear())
          .append("/").append(current.getMonthOfYear())
          .append("/").append(current.getDayOfMonth()).toString();
        String filePath = sb
                .append("/").append(UUID.nameUUIDFromBytes((current.getSecondOfDay()+orginFilename).getBytes()))
                .append(suffix).toString();
        File attachDirectory = new File(dirStr);
        if(!attachDirectory.exists()){
            attachDirectory.mkdirs();
        }
        FileCopyUtils.copy(file.getBytes(), new File(filePath));
        Attachment attach = new Attachment(orginFilename.substring(0,orginFilename.lastIndexOf('.')+1), filePath, file.getContentType(),userService.getCurrentUser());
        Attachment savedAttach = attachService.save(attach);
        return new ResponseEntity<Attachment>(savedAttach,HttpStatus.OK);
    }
    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Attachment> index() {
        return attachService.findAll();
    }
}
