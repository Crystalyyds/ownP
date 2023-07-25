package com.example.own.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.own.common.Result;
import com.example.own.entity.Files;
import com.example.own.mapper.FilesMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author TD21260225杨继雷
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/file")
public class FilesController {

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Resource
    private FilesMapper filesMapper;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + fileUUID);

        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

        String url;
        String md5 = SecureUtil.md5(file.getInputStream());
        Files dbFiles = getFileByMd5(md5);
        if (dbFiles != null) {
            url = dbFiles.getUrl();
        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            url = "http://localhost:9090/file/" + fileUUID;

            Files saveFile = new Files();
            saveFile.setName(originalFilename);
            saveFile.setType(type);
            saveFile.setSize(size/1024);
            saveFile.setUrl(url);
            saveFile.setMd5(md5);
            filesMapper.insert(saveFile);

        }

        return url;
    }
    private Files getFileByMd5(String md5){
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<Files> filesList = filesMapper.selectList(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name) {
        IPage<Files> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }
        return Result.success(filesMapper.selectPage(page, queryWrapper));
    }

    @GetMapping("/{fileUUID}")
    public void download(@PathVariable("fileUUID") String fileUUID, HttpServletResponse response) throws IOException {
        //根据文件标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");
        //读取文件字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }

    @GetMapping("/look/{id}")
    public Result getById(@PathVariable Integer id){
        Files files = filesMapper.selectById(id);
        return Result.success(files);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Files files = filesMapper.selectById(id);
        files.setIsDelete(true);
        filesMapper.updateById(files);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        // select * from sys_file where id in (id,id,id...)
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        List<Files> files = filesMapper.selectList(queryWrapper);
        for (Files file : files) {
            file.setIsDelete(true);
            filesMapper.updateById(file);
        }
        return Result.success();
    }

    @PostMapping("/update")
    public Result save(@RequestBody Files files) {
        return Result.success(filesMapper.updateById(files));
    }

}

