<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSSDK</title>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script>
        wx.config({
            debug: true,
            appId: 'wx603470cad1fcb1a1',
            timestamp: '1532340474',
            nonceStr: 'TBYnfEDpaJxIcMTf', // 必填，生成签名的随机串
            signature: '057ad63b9f16b4d403bd78c3c5730df4357f22d5',// 必填，签名
            jsApiList: [
            'checkJsApi',
            'onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareWeibo',
            'hideMenuItems',
            'showMenuItems',
            'hideAllNonBaseMenuItem',
            'showAllNonBaseMenuItem',
            'translateVoice',
            'startRecord',
            'stopRecord',
            'onRecordEnd',
            'playVoice',
            'pauseVoice',
            'stopVoice',
            'uploadVoice',
            'downloadVoice',
            'chooseImage',
            'previewImage',
            'uploadImage',
            'downloadImage',
            'getNetworkType',
            'openLocation',
            'getLocation',
            'hideOptionMenu',
            'showOptionMenu',
            'closeWindow',
            'scanQRCode',
            'chooseWXPay',
            'openProductSpecificView',
            'addCard',
            'chooseCard',
            'openCard'
        ]
        });
    </script>
</head>
<body>
hello ${say!''}<br>
<input type="button" onclick="chooseImage()" value="选择照片" >
<input type="button" onclick="shareQQ()" value="分享到QQ" >
<input type="button" onclick="shareWX()" value="分享到微信" >
<script>
    wx.ready(function () {
        // 分享到朋友圈
        wx.onMenuShareTimeline({
            title: '起航', // 分享标题
            link: 'https://github.com/lei-yang', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
            imgUrl: 'https://avatars1.githubusercontent.com/u/16114856?s=40&v=4', // 分享图标
            success: function () {
                // 用户点击了分享后执行的回调函数
                console.log("success")
            }
        }),
        wx.onMenuShareAppMessage({
            title: '起航', // 分享标题
            desc: 'GitHub', // 分享描述
            link: 'https://github.com/lei-yang', // 分享链接
            imgUrl: 'https://avatars1.githubusercontent.com/u/16114856?s=40&v=4', // 分享图标
            type: '', // 分享类型,music、video或link，不填默认为link
            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
            success: function () {
                // 用户点击了分享后执行的回调函数
            }
        }),
        // 分享到QQ
        wx.onMenuShareQQ({
            title: '起航', // 分享标题
            desc: 'GitHub', // 分享描述
            link: 'https://github.com/lei-yang', // 分享链接
            imgUrl: 'https://avatars1.githubusercontent.com/u/16114856?s=40&v=4', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    function shareWX() {
        wx.onMenuShareAppMessage({
            title: '起航', // 分享标题
            desc: 'GitHub', // 分享描述
            link: 'https://github.com/lei-yang', // 分享链接
            imgUrl: 'https://avatars1.githubusercontent.com/u/16114856?s=40&v=4', // 分享图标
            type: '', // 分享类型,music、video或link，不填默认为link
            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
            success: function () {
                // 用户点击了分享后执行的回调函数
            }
        }),
    }
    function shareQQ() {
        // 分享到QQ
        wx.onMenuShareQQ({
            title: '起航', // 分享标题
            desc: 'GitHub', // 分享描述
            link: 'https://github.com/lei-yang', // 分享链接
            imgUrl: 'https://avatars1.githubusercontent.com/u/16114856?s=40&v=4', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    }
    function chooseImage() {
        // 拍照或从手机相册中选图接口
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
            }
        });
    }
</script>
</body>
</html>