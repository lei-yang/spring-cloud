package cn.lyhxh.wechat.handler;

import cn.lyhxh.wechat.builder.TextBuilder;
import cn.lyhxh.wechat.dao.WxUserInfoMapper;
import cn.lyhxh.wechat.model.WxUserInfo;
import cn.lyhxh.wechat.utils.JsonUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.builder.outxml.NewsBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 关注处理
 */
@Component
public class SubscribeHandler extends AbstractHandler {

  @Autowired
  private WxUserInfoMapper wxUserInfoMapper;

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                  Map<String, Object> context, WxMpService weixinService,
                                  WxSessionManager sessionManager) throws WxErrorException {

    this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

    // 获取微信用户基本信息
    WxMpUser userWxInfo = weixinService.getUserService()
        .userInfo(wxMessage.getFromUser(), null);

    if (userWxInfo != null) {
      // TODO 可以添加关注用户到本地
      WxUserInfo wxUserInfo = new WxUserInfo();
      BeanUtils.copyProperties(userWxInfo, wxUserInfo);
      wxUserInfoMapper.insertSelective(wxUserInfo);
      this.logger.info(">>>userWxInfo>>>" + JsonUtils.toJson(userWxInfo));
    }

    WxMpXmlOutMessage responseResult = null;
    try {
      responseResult = handleSpecial(wxMessage);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    if (responseResult != null) {
      return responseResult;
    }

    try {
      return new TextBuilder().build("感谢关注", wxMessage, weixinService);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    return null;
  }

  /**
   * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
   */
  private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
      throws Exception {
      // 图文信息
    WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
    item.setTitle("黄焖鸡米饭");
    item.setDescription("中午吃黄焖鸡米饭");
    item.setPicUrl("http://localhost:63342/activity/common/kxdz_images/banner_02_01.jpg");
    item.setUrl("http://localhost:63342/activity/kxdz/shenma.html?_ijt=rtai9es11kqhq5n39abb3bmehn");
    return new NewsBuilder().addArticle(item).fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser()).build();
  }

}
