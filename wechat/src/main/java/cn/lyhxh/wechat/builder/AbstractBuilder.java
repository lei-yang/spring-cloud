package cn.lyhxh.wechat.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @Description: 构建器
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 14:03
 * @Version V1.0
 */
public abstract class AbstractBuilder {

    public abstract WxMpXmlOutMessage build(String content,
                                            WxMpXmlMessage wxMessage, WxMpService service);
}
