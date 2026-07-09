package com.jinan.springmvcdemo;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("request")
public class RequestController {
    private final ListableBeanFactory listableBeanFactory;

    public RequestController(ListableBeanFactory listableBeanFactory) {
        this.listableBeanFactory = listableBeanFactory;
    }

    //传递单个参数
    @RequestMapping("/r1")
    public String r1(String s1) {
        return "接受到参数:"+s1;
    }

    @RequestMapping("/r2")
    public String r2(int age) {
        return "接收到参数:" + age;
    }

    //传递多个参数
    @RequestMapping("/r3")
    public String r3(String name,Integer age) {
        return "接受到参数:"+String.format("[%s],[%d]",name,age);
    }

    //传递对象
    @RequestMapping("/r4")
    public String r4(Person person) {
        return "接受到参数:"+person;
    }

    //后端参数重命名
    /*某些特殊的情况下，前端传递的参数 key 和我们后端接收的 key 可以不⼀致，⽐如前端传递了⼀个
    time 给后端，⽽后端是使⽤ createtime 字段来接收的，这样就会出现参数接收不到的情况，如果出现
    这种情况，我们就可以使⽤ @RequestParam 来重命名前后端的参数值.
    * */
    @RequestMapping("/r5")
    //把前端返回的time参数赋值给后端createTime
    public String r5(@RequestParam(value = "time",required = false)String createTime) {
        return "接受到参数:"+createTime;
    }

    //传递数组
    @RequestMapping("/r6")
    public String r6(String[] array) {
        return "接受到参数:"+ Arrays.toString(array);
    }

    //传递集合 需要使用RequestParam绑定参数关系
    @RequestMapping("/r7")
    public String r7(@RequestParam List<String> list) {
        return "接受到参数" + list;
    }

    //传递JSON数据
    @RequestMapping("/r8")
    public String r8( @RequestBody Person person) {
        return "接收到参数:" + person;
    }

    //获取URL中的参数
    //http://127.0.0.1:8080/r9
    @RequestMapping("/{articleId}")
    public String r9(@PathVariable("articleId") String articleId) {
        return "接收到参数" + articleId;
    }

    //http://127.0.0.1:8080/r10/12306
    @RequestMapping("/{type}/{articleId}")
    public String r10(@PathVariable("articleId") Integer articleId, @PathVariable("type") String type) {
        return "接收到请求" + articleId + ", " + type;
    }

    //上传文件@RequestPart
    @RequestMapping("/r11")
    public String r11(@RequestPart("file") MultipartFile file) throws IOException {
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename"+originalFilename);
        String contentType = file.getContentType();
        System.out.println("contentType"+contentType);

        //文件上传
        file.transferTo(new File("D:\\111"));
        return "接收到文件" + name;
    }

}
