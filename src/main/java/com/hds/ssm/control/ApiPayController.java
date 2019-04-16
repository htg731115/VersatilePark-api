package com.hds.ssm.control;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/api")
public class ApiPayController {
    @ResponseBody
    @RequestMapping("/helloWorld")
    public void 方法名(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        AlipayClient client = new
                DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
                "2016092600600525",
                    "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCMUWlpWeloUdNNafYMAfbllgfCrkKOlkD3fwnTycYBTm9cTMrmE+3bdxws7uG2l4UlQxmSB57dTujQyDSym920XUbi23WDPUGrMFD88Yzfyn1dMpPa4c2nRijdgI3NhTuhJ7OjaCath4pPjp/dEIYA9ho4D43yxgnyD5/JrqGCP6TP/7YX7wvY0RxCNdvpvJCfRN/bN9XhKDiulU31UwdJVQiXin+kntYlLS7MFhXQg6zXuGzUXOn9HBB16R0TYfzGs6My05EcShhFOeDmlkIYD/NqdW9qGszvOYkmGd51Ra5T/GG3M5k4BaXgnL3KFIVKhKmtN1E9xplqotUc1RsjAgMBAAECggEADr9fvNreVUCEXNaOLaTnNioWlreJ90KDgX+woLnMPcbonWLU0Gm3ziEurOpOfspeDBSJU3fJkqkAfzELmNoY6yQCl0VJjImbpUpmuK8Kh1rY4jq2n4KsArC1CtLAFKG0KrPphXsk1YgxWTs8QhfCfcdf6hR4btOxp+dMe/4Gq5Gsl4Ue43bvMwjeqj7YB+pV5Uh/fLoFcFLXmHhPOAbKXm7Gdv2FtriER4vRfX9wAnoan4Qi7mJ7ZrljU/C4jOiTHoBszD/Lb3XC1m36wm7q1iZQGOnI7gk4geXFyfWaqTOYbD8AGBNG6xXZ/RoVjEyJuZoGOGNXnJESZxqG22wBgQKBgQDa7kwr/4k7EgNiH7e5SC/j6ISYMFhk1Xu9YPOObUMlYvBmFM3JbvyXY1Fb45mKoRgZV+2+0RkyWBRvYUw+GeE/Y7jZsMctWDtt3maKkM99va8WfU1QuNF/TFQHkfp1Q/Bl7zgp/iNW6aX3CPeT60QsrriRNIzrg3TRBPhZeSXbWwKBgQCkE5bB+KoaJMHFUUQSUvd/PJvUHBlXF0JWm9UyldAqQQksQcV079PJm3/pKKzNtziLHR/sD40XVvOhxkPNhTSfZAmH7AYoU+t+1f8AGCrFWqILCoW1vf3V/omkrGCmyLz9eQGaeGr7TjJM6VVhh+qVoU6hJyO1HjJN5CUO5LFx2QKBgBk87VUJIUXI/tDZ/TEDzFmGnXp54EbHgXtEaO9bUylFLZdnAI4fGElPbrqcE0Ay7/dD9qlPq4rtMnXgjox+KURId6/IvD1S9Y7l24ZPyUuiiUObcEVE+Qmmv+0be/b2vQjTOfNFU8eaKcK/quLHdVV9UtOSbkhcICRUYVjXKXEPAoGAKXTln6cj260z5JZO+85IyLZYrTRYVsACu/1t1fUyfqqmFa+co5pBSexnWlMzrlrAB65ZNX0MajxHHLYKxbAFhsxw+A3z1Fa35vlNEAoLLIhk7yM+e5hAvcQtpRUE6r9HuUfM1uncJhkw7mv6bcU4yYvTYTaReB7kGPgvQN8Z0qkCgYBNM3otN+l1/L+dK1vgjLskigEK52UDCVZ14D4MQOVDdcw0xVtp0cFSinK4PcSOFDy3thnqZcF+bSGX1fOrav1YrJSti75m6GhgvUE/7fVeRAcArCjoJcaQi03esHjkxOVsNr2x2ClSKtGnVM8pF4o4R0LhUzMNbdWqBXiQI024HQ==",
                "json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjFFpaVnpaFHTTWn2DAH25ZYHwq5CjpZA938J08nGAU5vXEzK5hPt23ccLO7htpeFJUMZkgee3U7o0Mg0spvdtF1G4tt1gz1BqzBQ/PGM38p9XTKT2uHNp0Yo3YCNzYU7oSezo2gmrYeKT46f3RCGAPYaOA+N8sYJ8g+fya6hgj+kz/+2F+8L2NEcQjXb6byQn0Tf2zfV4Sg4rpVN9VMHSVUIl4p/pJ7WJS0uzBYV0IOs17hs1Fzp/RwQdekdE2H8xrOjMtORHEoYRTng5pZCGA/zanVvahrM7zmJJhnedUWuU/xhtzOZOAWl4Jy9yhSFSoSprTdRPcaZaqLVHNUbIwIDAQAB",
                "RSA2" );
        String out_trade_no ="233";
                // 订单名称，必填
        String subject = "通用套餐购买";
        System.out.println(subject);
        // 付款金额，必填
        String total_amount="14";
        // 商品描述，可空

        String timeout_express="2m";
        // 销售产品码 必填
        String product_code="QUICK_WAP_WAY";
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        //调用RSA签名方式
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();

        // 封装请求支付信息
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(out_trade_no);
        model.setSubject(subject);
        model.setTotalAmount(total_amount);
        model.setTimeoutExpress(timeout_express);
        model.setProductCode(product_code);
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl("http://x8biih.natappfree.cc/api/helloWorld2");
        // 设置同步地址
        alipay_request.setReturnUrl("http://x8biih.natappfree.cc/api/helloWorld2");

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            form = client.pageExecute(alipay_request).getBody();
            response.setContentType("text/html;charset=" + "UTF-8");
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    @ResponseBody
    @RequestMapping("/helloWorld2")
    public void a(){
        System.out.println("======成功了吗？");
    }
}
