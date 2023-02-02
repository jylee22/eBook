package com.ebook.api.util;

import com.ebook.api.vo.ApiDTO;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class NaverBookSearch {

    public String search(String keyword) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "qXj8H0E2hUekh0xziT2l");
        headers.add("X-Naver-Client-Secret", "h43a1mivTW");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        // 넘겨받은 query로 검색 요청
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/book.json?display=100&query=" + keyword, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();

        return response;
    }

    public List<ApiDTO> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ApiDTO> ret = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ApiDTO apiDTO = new ApiDTO(itemJson);
             String apiisbn= apiDTO.getIsbn();
            log.info("====================================================");
            log.info(apiisbn);
            if (apiisbn.length()>2){ret.add(apiDTO);}}
        log.info(ret);
        return ret;
    }
}

