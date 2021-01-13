package com.example.demo.test.reptile;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * @author ZhaoXin
 * @date 2020/10/10 15:32
 */
public class ReptileDemo extends Thread {

    public static String getHtmlResourceByUrl(String url, String encoding) {
        StringBuffer buffer = new StringBuffer();
        URL urlObj = null;
        URLConnection uc = null;
        InputStreamReader in = null;
        BufferedReader reader = null;

        try {
            // 建立网络连接
            urlObj = new URL(url);
            // 打开网络连接
            uc = urlObj.openConnection();
            // 创建输入流
            in = new InputStreamReader(uc.getInputStream(), encoding);
            // 创建一个缓冲写入流
            reader = new BufferedReader(in);

            String line = null;
            while ((line = reader.readLine()) != null) {
                // 一行一行追加
                buffer.append(line + "\r\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }

    /**
     * 根据图片的URL下载的图片到本地的filePath
     *
     * @param filePath 文件夹
     * @param imageUrl 图片的网址
     */
    public static void downImages(String filePath, String imageUrl) {
        // 截取图片的名称
        // String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
        String fileName = UUID.randomUUID().toString() + ".jpg";

        System.out.println(filePath);
        //创建文件的目录结构
        File files = new File(filePath);
        if (!files.exists()) {// 判断文件夹是否存在，如果不存在就创建一个文件夹
            files.mkdirs();
        }
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            // 创建文件，并设置默认文件名
            File file = new File(filePath + fileName);
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while ((i = is.read()) != -1) {
                out.write(i);
            }
            is.close();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //执行测试程序代码
    public static void main(String[] args) {
        //要爬取的网页地址
        String url = "https://blog.csdn.net/weixin_47723732/article/details/107891884?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522160231746119725255540730%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=160231746119725255540730&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v28-1-107891884.pc_first_rank_v2_rank_v28&utm_term=pycharm%E9%AB%98%E6%B8%85%E5%A3%81%E7%BA%B8&spm=1018.2118.3001.4187";
        //编码方式
        String encoding = "gbk";
        //存储到本地的位置
        String filePath = "D://img";
        String htmlResource = getHtmlResourceByUrl(url, encoding);
        // 解析网页源代码
        Document document = Jsoup.parse(htmlResource);
        // 获取所有图片的地址
        Elements elements = document.getElementsByTag("img");
        // Elements elements = document.select(".img_box img");
        System.out.println("-------------------------开始下载！----------------------------");
        for (Element element : elements) {
            String imgSrc = element.attr("src");
            // 判断imgSrc是否为空且是否以"http://"或是"https://"开头
            if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
                System.out.println("正在下载的图片的地址：" + imgSrc);
                downImages(filePath, imgSrc);
            }
        }
        System.out.println("-------------------------下载完毕！----------------------------");
    }
}
