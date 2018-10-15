package cn.lyhxh.wechat.handler;

import cn.lyhxh.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.builder.outxml.NewsBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Description: 点击事件
 * @Author leiyang_39@163.com
 * @Date 2018/7/20 9:43
 * @Version V3.0
 */
@Component
public class ClickHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> map, WxMpService weixinService, WxSessionManager wxSessionManager) throws WxErrorException {
        String eventKey = wxMessage.getEventKey();
        if (StringUtils.isEmpty(eventKey)) {

        }
        switch (eventKey) {
            case "V1001_TODAY_MUSIC" :
                // 图文消息
                WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
                item.setTitle("GitHub");
                item.setDescription("GitHub lei-yang");
                item.setPicUrl("https://avatars1.githubusercontent.com/u/16114856?s=40&v=4");
                item.setUrl("https://github.com");
                return new NewsBuilder().addArticle(item).fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser()).build();
            default:
                // 文本消息
                String content = "收到点击事件key为null";
                return new TextBuilder().build(content, wxMessage, weixinService);
        }
    }
}
