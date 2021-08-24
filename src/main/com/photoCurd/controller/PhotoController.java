package photoCurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import photoCurd.bean.Msg;
import photoCurd.bean.Photo;
import photoCurd.bean.User;
import photoCurd.service.PhotoService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * @author lixuefeng
 * @date 2021-08-22 21:04
 * @description:
 */
@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/photoFileUpload",method = RequestMethod.GET)
    public ModelAndView fileIndex(){

        return new ModelAndView("upload");
    }

    @ResponseBody
    @RequestMapping(value = "/photoFileUpload",method = RequestMethod.POST)
    public Msg fileUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //需校验上传为图片,
        List<String> list= Arrays.asList("bmp","jpg","tiff","gif","pcx","tga","exif","fpx","svg","psd","cdr","pcd","dxf","ufo","eps","ai","raw");
        Set<String> set=new HashSet<>(list);
        String fileName=file.getName();
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1);
        if(!set.contains(suffix)){
            return Msg.fail().add("upload_msg","上传的文件不为图片");
        }
        if(file.getSize()/1024/1024>100){
            return Msg.fail().add("upload_msg","上传的图片不能大于100M");
        }
        //需要登陆才能进行上传：
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            return Msg.fail().add("upload_msg","未登陆，请刷新页面");
        }
        String photoId=new Date().getTime()+file.getOriginalFilename();
        int orderId=user.getId();
        Date createTime=new Date();
        Date createDate=new Date();
        String path="D:workspace/photo/upload/"+photoId;
        File newFile=new File(path);
        file.transferTo(newFile);
        photoService.addPhoto(new Photo(photoId,fileName,orderId,createTime,createDate,0,0));
        return Msg.success().add("path",path);
    }

    @ResponseBody
    @RequestMapping(value = "/searchPhotoByUser",method = RequestMethod.GET)
    public Msg searchPhotoByUser(User user){
        List<Photo> list=photoService.searchPhotoByUser(user);
        return Msg.success().add("photos",list);
    }

}
