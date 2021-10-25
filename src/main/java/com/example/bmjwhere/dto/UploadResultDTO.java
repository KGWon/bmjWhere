package com.example.bmjwhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable {
    private String fileName;
    private String uuid;
    private String folderPath;

    public String getImageURL() { // 파일의 전체 경로
        try {
            // URLEncoder.encode(): URL 인코딩은 문자를 인터넷을 통해 전송할 수 있는 형식으로 변환
            // 참초 : https://www.w3schools.com/tags/ref_urlencode.asp
            return URLEncoder.encode(folderPath+"/" + uuid + "_" + fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getThumbnailURL() { // 섬네일 링크 처리
        try {
            return URLEncoder.encode(folderPath + "/s_" + uuid + "_" + fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
