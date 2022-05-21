package com.example.demo.test;

import com.example.demo.dto.test.OrderItemRequest;
import com.example.demo.dto.test.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    // 2022-05-19 10:24:00.383 INFO  [main] k.c.y.p.s.v.OrderServiceV3: 실주문 makeOrderInfo orderItems=Optional[[OrderItemRequest(cartSeq=35775, cartType=null, packageTypeCode=COURSE, packageSeq=843, packageName=[패키지] 인스타부터 스마트스토어까지! 퇴근 후 월 200만원 벌기, freeYn=N, originalPrice=1159000, salePrice=1159000, cnt=1, requiredYn=Y, productSeq=null, sortOrder=0, productItems=[OrderItemRequest(cartSeq=35776, cartType=null, packageTypeCode=CLASS, packageSeq=843, packageName=돈 되는 인스타 공동구매 시작하기, freeYn=N, originalPrice=399000, salePrice=102934, cnt=1, requiredYn=Y, productSeq=588, sortOrder=1, productItems=null), OrderItemRequest(cartSeq=35777, cartType=null, packageTypeCode=CLASS, packageSeq=843, packageName=바로 써먹는 구매대행 노하우, freeYn=N, originalPrice=418000, salePrice=107836, cnt=1, requiredYn=Y, productSeq=605, sortOrder=2, productItems=null), OrderItemRequest(cartSeq=35778, cartType=null, packageTypeCode=CLASS, packageSeq=843, packageName=예비CEO를 위한 실전 창업브랜딩, freeYn=N, originalPrice=342000, salePrice=88230, cnt=1, requiredYn=Y, productSeq=585, sortOrder=3, productItems=null)]), OrderItemRequest(cartSeq=35821, cartType=null, packageTypeCode=ENTRANCE, packageSeq=1884, packageName=Yanadoo University 입학, freeYn=N, originalPrice=1981000, salePrice=168000, cnt=1, requiredYn=Y, productSeq=null, sortOrder=0, productItems=[OrderItemRequest(cartSeq=35822, cartType=null, packageTypeCode=CLASS, packageSeq=1884, packageName=성공을 향한 마인드셋, freeYn=N, originalPrice=0, salePrice=0, cnt=1, requiredYn=Y, productSeq=729, sortOrder=1, productItems=null), OrderItemRequest(cartSeq=35823, cartType=null, packageTypeCode=CLASS, packageSeq=1884, packageName=하루 10분 영어 습관 만들기, freeYn=N, originalPrice=776000, salePrice=12630, cnt=1, requiredYn=Y, productSeq=730, sortOrder=2, productItems=null), OrderItemRequest(cartSeq=35824, cartType=null, packageTypeCode=CLASS, packageSeq=1884, packageName=경제적 자유를 위한 하루 10분 투자, freeYn=N, originalPrice=513000, salePrice=8350, cnt=1, requiredYn=Y, productSeq=744, sortOrder=3, productItems=null), OrderItemRequest(cartSeq=35825, cartType=null, packageTypeCode=CLASS, packageSeq=1884, packageName=하루 10분 운동 습관 만들기, freeYn=N, originalPrice=554000, salePrice=9020, cnt=1, requiredYn=Y, productSeq=732, sortOrder=4, productItems=null), OrderItemRequest(cartSeq=35969, cartType=null, packageTypeCode=REAL, packageSeq=1884, packageName=[굿즈] 카카오 스마트가습기, freeYn=N, originalPrice=69000, salePrice=69000, cnt=1, requiredYn=N, productSeq=822, sortOrder=5, productItems=null), OrderItemRequest(cartSeq=35826, cartType=null, packageTypeCode=REAL, packageSeq=1884, packageName=[굿즈] 카카오 스마트램프, freeYn=N, originalPrice=69000, salePrice=69000, cnt=1, requiredYn=N, productSeq=823, sortOrder=5, productItems=null)])]]
    @Test
    void objectToJsonTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        OrderItemRequest orderItemRequest = OrderItemRequest.builder()
                .cartSeq(1)
                .cartType("cartType")
                .cnt(10)
                .freeYn("Y")
                .originalPrice(1000)
                .build();
        String orderItem = objectMapper.writeValueAsString(orderItemRequest);
        System.out.println(orderItem);
    }

    @Test
    void jsonToObjectTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderItemRequest orderItemRequest = OrderItemRequest.builder()
                .cartSeq(1)
                .cartType("cartType")
                .cnt(10)
                .freeYn("Y")
                .originalPrice(1000)
                .build();
        String orderItem = objectMapper.writeValueAsString(orderItemRequest);
        System.out.println(orderItem);
        String jsonStr = "[{\"cartSeq\":35775,\"cartType\":null,\"packageTypeCode\":\"COURSE\",\"packageSeq\":843,\"packageName\":\"[패키지] 인스타부터 스마트스토어까지! 퇴근 후 월 200만원 벌기\",\"freeYn\":\"N\",\"originalPrice\":1159000,\"salePrice\":1159000,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":null,\"sortOrder\":0,\"productItems\":[{\"cartSeq\":35776,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":843,\"packageName\":\"돈 되는 인스타 공동구매 시작하기\",\"freeYn\":\"N\",\"originalPrice\":399000,\"salePrice\":102934,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":588,\"sortOrder\":1,\"productItems\":null},{\"cartSeq\":35777,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":843,\"packageName\":\"바로 써먹는 구매대행 노하우\",\"freeYn\":\"N\",\"originalPrice\":418000,\"salePrice\":107836,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":605,\"sortOrder\":2,\"productItems\":null},{\"cartSeq\":35778,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":843,\"packageName\":\"예비CEO를 위한 실전 창업브랜딩\",\"freeYn\":\"N\",\"originalPrice\":342000,\"salePrice\":88230,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":585,\"sortOrder\":3,\"productItems\":null}]},{\"cartSeq\":35821,\"cartType\":null,\"packageTypeCode\":\"ENTRANCE\",\"packageSeq\":1884,\"packageName\":\"Yanadoo University 입학\",\"freeYn\":\"N\",\"originalPrice\":1981000,\"salePrice\":168000,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":null,\"sortOrder\":0,\"productItems\":[{\"cartSeq\":35822,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":1884,\"packageName\":\"성공을 향한 마인드셋\",\"freeYn\":\"N\",\"originalPrice\":0,\"salePrice\":0,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":729,\"sortOrder\":1,\"productItems\":null},{\"cartSeq\":35823,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":1884,\"packageName\":\"하루 10분 영어 습관 만들기\",\"freeYn\":\"N\",\"originalPrice\":776000,\"salePrice\":12630,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":730,\"sortOrder\":2,\"productItems\":null},{\"cartSeq\":35824,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":1884,\"packageName\":\"경제적 자유를 위한 하루 10분 투자\",\"freeYn\":\"N\",\"originalPrice\":513000,\"salePrice\":8350,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":744,\"sortOrder\":3,\"productItems\":null},{\"cartSeq\":35825,\"cartType\":null,\"packageTypeCode\":\"CLASS\",\"packageSeq\":1884,\"packageName\":\"하루 10분 운동 습관 만들기\",\"freeYn\":\"N\",\"originalPrice\":554000,\"salePrice\":9020,\"cnt\":1,\"requiredYn\":\"Y\",\"productSeq\":732,\"sortOrder\":4,\"productItems\":null},{\"cartSeq\":35969,\"cartType\":null,\"packageTypeCode\":\"REAL\",\"packageSeq\":1884,\"packageName\":\"[굿즈] 카카오 스마트가습기\",\"freeYn\":\"N\",\"originalPrice\":69000,\"salePrice\":69000,\"cnt\":1,\"requiredYn\":\"N\",\"productSeq\":822,\"sortOrder\":5,\"productItems\":null},{\"cartSeq\":35826,\"cartType\":null,\"packageTypeCode\":\"REAL\",\"packageSeq\":1884,\"packageName\":\"[굿즈] 카카오 스마트램프\",\"freeYn\":\"N\",\"originalPrice\":69000,\"salePrice\":69000,\"cnt\":1,\"requiredYn\":\"N\",\"productSeq\":823,\"sortOrder\":5,\"productItems\":null}]}]";
        OrderItemRequest[] orderItemRequest1 = objectMapper.readValue(jsonStr, OrderItemRequest[].class);
        System.out.println(Arrays.toString(orderItemRequest1));
    }

    @Test
    void jsonToObjectPaymentRequestTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String paymentRequest = "{\n" +
                "  \"deviceType\": \"PC\",\n" +
                "  \"deliveryRequest\": {\n" +
                "    \"addr1\": \"경기 용인시 수지구 만현로 99 (상현동, 만현마을쌍용3차아파트)\",\n" +
                "    \"addr2\": \"605동\",\n" +
                "    \"cellphone\": \"010-2627-4952\",\n" +
                "    \"message\": \"601호\",\n" +
                "    \"name\": \"허우용\",\n" +
                "    \"zipcode\": \"16930\"\n" +
                "  },\n" +
                "  \"detailCounts\": [\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1,\n" +
                "    1\n" +
                "  ],\n" +
                "  \"detailPaymentPrices\": [\n" +
                "    178500,\n" +
                "    180500,\n" +
                "    247000,\n" +
                "    20,\n" +
                "    6840,\n" +
                "    6340,\n" +
                "    69000,\n" +
                "    870,\n" +
                "    15930\n" +
                "  ],\n" +
                "  \"discountPrices\": [\n" +
                "    0,\n" +
                "    0\n" +
                "  ],\n" +
                "  \"orderNo\": \"YND_1249856\",\n" +
                "  \"paymentPrices\": [\n" +
                "    199000,\n" +
                "    99000\n" +
                "  ],\n" +
                "  \"paymentType\": \"CARD\",\n" +
                "  \"paymentWay\": \"GENERAL_PAY\",\n" +
                "  \"price\": 298000,\n" +
                "  \"couponRequests\": []\n" +
                "}";
// OrderItemRequest[] orderItemRequest1 = objectMapper.readValue(jsonStr, OrderItemRequest[].class);
//        System.out.println(Arrays.toString(orderItemRequest1));
        PaymentRequest request = objectMapper.readValue(paymentRequest, PaymentRequest.class);
        System.out.println(request.toString());
    }

    @Test
    void jsonObjectTest() {
        Map<String, Object> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");

        JSONObject json = new JSONObject(map);
        System.out.printf("JSON: %s", json);
    }

}
