package com.shop.controller;
import com.shop.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/list")
    public Map<String,Object> getOrderList(
            @RequestHeader("Authorization") String token,
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize){
        Map<String,Object> res = new HashMap<>();
        //拿登录用户id，隔离数据
        Integer userId = JwtUtil.getUserId(token.replace("Bearer ",""));
        //模拟订单数据
        List<Map<String,Object>> records = new ArrayList<>();
        Map<String,Object> order = new HashMap<>();
        order.put("orderNo","ORD20260614001");
        order.put("amount",199.0);
        order.put("status","已支付");
        order.put("createTime","2026-06-14 10:00:00");
        records.add(order);

        res.put("code",200);
        res.put("records",records);
        res.put("total",1);
        return res;
    }
}