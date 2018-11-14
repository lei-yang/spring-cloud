package cn.lyhxh.wechat.controller;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 菜单管理
 * @Author leiyang_39@163.com
 * @Date 2018/7/19 9:37
 * @Version V3.0
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WxMpService wxService;

    /**
     * 菜单列表
     *
     * @param modelMap
     * @return
     */
    @GetMapping("list")
    public String list(ModelMap modelMap) {
        try {
            WxMpMenu wxMpMenu = wxService.getMenuService().menuGet();
            logger.info("wxMpMenu:{}", JSON.toJSONString(wxMpMenu));
            modelMap.put("wxMpMenu", wxMpMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "menu/list";
    }

    /**
     * 跳转编辑/保存页面
     *
     * @return
     */
    @GetMapping("saveUI")
    public String save() {
        return "menu/saveUI";
    }

//    @PostMapping("save")
    @GetMapping("save")
    public String save(String menu, ModelMap modelMap) {
        try {
            menu = "{\n" +
                    "    \"button\": [\n" +
                    "        {\n" +
                    "            \"type\": \"click\", \n" +
                    "            \"name\": \"今日歌曲\", \n" +
                    "            \"key\": \"V1001_TODAY_MUSIC\"\n" +
                    "        }, \n" +
                    "        {\n" +
                    "            \"name\": \"菜单\", \n" +
                    "            \"sub_button\": [\n" +
                    "                {\n" +
                    "                    \"type\": \"view\", \n" +
                    "                    \"name\": \"邀请函\", \n" +
                    "                    \"url\": \"http://h5.eqxiu.com/s/AUk2qGuM\"\n" +
                    "                } \n" +
                    "            ]\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
//            WxMenu wxMenu = JSON.parseObject(menu, WxMenu.class);
            String result = wxService.getMenuService().menuCreate(menu);
            logger.info("menuCreate result:{}", result);
            modelMap.put("result", result);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "menu/list";
    }

//    @DeleteMapping("remove")
    @GetMapping("remove")
    public String remove(ModelMap modelMap) {
        try {
            wxService.getMenuService().menuDelete();
            modelMap.put("result", "result");
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "menu/list";
    }

}
