/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.services.files.impl;

import com.yao.oa.domains.files.Attachment;
import com.yao.oa.repositories.files.AttachmentsRepository;
import com.yao.oa.services.BaseServiceSupport;
import com.yao.oa.services.files.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author yao
 */
@Service
public class AttachmentServiceImpl extends BaseServiceSupport<Attachment, Integer> implements AttachmentService {
    private final AttachmentsRepository attachmentsRepository;
    
    @Autowired
    public AttachmentServiceImpl(AttachmentsRepository attachmentRepository){
        this.attachmentsRepository = attachmentRepository;
    }
    
    @Override
    public JpaRepository<Attachment, Integer> getJpaRepository() {
        return attachmentsRepository;
    }
    
}
