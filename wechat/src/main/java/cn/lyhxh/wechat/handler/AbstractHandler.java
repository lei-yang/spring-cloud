package cn.lyhxh.wechat.handler;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 处理器
 * @Author leiyang_39@163.com
 * @Date 2018/6/8 14:05
 * @Version V1.0
 */
public abstract class AbstractHandler implements WxMpMessageHandler {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
