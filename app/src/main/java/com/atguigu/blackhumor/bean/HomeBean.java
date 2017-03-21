package com.atguigu.blackhumor.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 万里洋 on 2017/3/21.
 */

public class HomeBean {

    /**
     * code : 0
     * message : ok
     * data : {"banner":[{"title":"对象？你尽管抢，抢到算我输","img":"http://i0.hdslb.com/bfs/live/2807719e244e45714a3e08548b1c889815eaa1f6.png","remark":"情人节2.0","link":"http://live.bilibili.com/AppBanner/index?id=467"}],"entranceIcons":[{"id":9,"name":"绘画专区","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?201703141338","height":"66","width":"66"}},{"id":8,"name":"萌宅推荐","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/8_big.png?201703141338","height":"66","width":"66"}},{"id":3,"name":"网络游戏","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/3_big.png?201703141338","height":"66","width":"66"}},{"id":1,"name":"单机联机","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/1_big.png?201703141338","height":"66","width":"66"}},{"id":4,"name":"电子竞技","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/4_big.png?201703141338","height":"66","width":"66"}}],"partitions":[{"partition":{"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338","height":"32","width":"32"},"count":16},"lives":[{"owner":{"face":"http://i1.hdslb.com/bfs/face/e6c43dbbbc99b093bcc636e321afe9eb5552581f.jpg","mid":35853463,"name":"在吗-任性的加班帝"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7dc55f1e44990cc5995e6f582020fbc3020fee07.jpg","height":180,"width":320},"title":"CAD","room_id":519402,"check_version":0,"online":165,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/342348/live_35853463_2348866.flv?wsSecret=3fecbdbb886b2972aa5b697919d49377&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/195f8ce93f0b5526ec41c98914619569b4a9c769.jpg","mid":149066,"name":"Pelokio"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4acadb3b82d9f2f1c115a2b5d264d49316ddc64b.jpg","height":180,"width":320},"title":"边听英语，实力赶稿","room_id":31555,"check_version":0,"online":24,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/586/live_149066_332_c521e483.flv?wsSecret=eb3bbf9f9399a73d5f596cf8d14c97f2&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/fc49cb0317d6574e8a467b7854faa5dca467be7b.jpg","mid":29776658,"name":"画画的灰MO"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7a56c019babcd4c9597cca693e2f94d271275901.jpg","height":180,"width":320},"title":"随便画点什么，沉迷妹抖龙","room_id":162308,"check_version":0,"online":9,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/543531/live_29776658_3739401.flv?wsSecret=45efa1852ed15c89c7d4f14e6bd153d1&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/3afa26e6d5e3068511a48f65d4e366121d504ecf.jpg","mid":96190044,"name":"一叶绣春刀"},"cover":{"src":"http://i0.hdslb.com/bfs/live/34e13cf902a4d9164debfc2439758f63979be8f5.jpg","height":180,"width":320},"title":"腾讯漫画《入侵》赶稿","room_id":3867714,"check_version":0,"online":57,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/266852/live_96190044_1317086.flv?wsSecret=094e705a5ed2e8216e1d427ccf30d8aa&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/4bee6c1183f63a3e404f202adce3d63d2ae040ad.jpg","mid":36006,"name":"kange"},"cover":{"src":"http://i0.hdslb.com/bfs/live/9d6a6d9a2b2d8988168b7187b28eafa7f78e91bc.jpg","height":180,"width":320},"title":"kange的肝爆机","room_id":12790,"check_version":0,"online":23,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/920740/live_36006_332_c521e483.flv?wsSecret=9c97e3fa32bca22517a5ec555558205b&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/79d71d1c93fbaf31df807d75b83a6022a55373cb.jpg","mid":19707743,"name":"B站制簪人蝉蝉"},"cover":{"src":"http://i0.hdslb.com/bfs/live/40541f92ccf11a79d55e9691aaf2d0dad54bf22e.jpg","height":180,"width":320},"title":"蝉蝉搞事，钻真骨头，卡拉卡拉","room_id":102358,"check_version":0,"online":83,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/808702/live_19707743_5536546.flv?wsSecret=8bd55a070cfdc60effc2d770480ddf4d&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/177a690d764bcef1569483dc647ad63cff75678d.jpg","mid":3177174,"name":"公子安好"},"cover":{"src":"http://i0.hdslb.com/bfs/live/aff70f5fa5d1f7780b65de237aa902b08af1dced.jpg","height":180,"width":320},"title":"送你一份超大的胖次、日系卡牌绘制","room_id":1588108,"check_version":0,"online":27,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/583063/live_3177174_7062644.flv?wsSecret=5d1a43c3179a796b97951cbce1dd4950&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/af2a1c6b0842277f9beeaf9df7a79264e496bca6.jpg","mid":69202135,"name":"我叫小薇"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ea95b0535091d5d94a2d773ca5d835cd939546fd.jpg","height":180,"width":320},"title":"日漫一辣眼睛的zb建模日漫原画入上万 盛途","room_id":2796538,"check_version":0,"online":32,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/305615/live_69202135_6613091.flv?wsSecret=acef3d6f8490e7ef07c32dd63d39f2a0&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/ba500657cf4dce0b71f7ab175b00cf18e53b4bc0.jpg","mid":35817562,"name":"飞行员手绘"},"cover":{"src":"http://i0.hdslb.com/bfs/live/11bac33b99a7890c252444045aed6c863addf399.jpg","height":180,"width":320},"title":"画个小姐姐","room_id":932655,"check_version":0,"online":25,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/360710/live_35817562_4490375.flv?wsSecret=d89443bfedbc5c67be80ca61ed18be2a&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/62e13ea28a5a692cfe50292b951352ba4fd794f5.jpg","mid":23487796,"name":"聚流陶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/76361.jpg?03210840","height":180,"width":320},"title":"陶叔 每日百画-群499950841","room_id":76361,"check_version":0,"online":24,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/293/live_23487796_5237678.flv?wsSecret=3c9d4fc8ec6e941b592c306529b2d790&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":6,"name":"生活娱乐","area":"ent-life","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/6.png?201703141338","height":"32","width":"32"},"count":145},"lives":[{"owner":{"face":"http://i1.hdslb.com/bfs/face/35c64b220c2a0cc0f39bf7f09a7d3321c5725227.jpg","mid":79775646,"name":"黑夜阿拉伯"},"cover":{"src":"http://i0.hdslb.com/bfs/live/eaa178e49bd0ec25472b863adc475a1c7e447c05.jpg","height":180,"width":320},"title":"为什么老有人问我性别？不是很明显吗？女","room_id":3172812,"check_version":0,"online":1292,"area":"生活娱乐","area_id":6,"playurl":"http://live-play.acgvideo.com/live/838/live_79775646_8354495.flv?wsSecret=401a73d3bcaf91747fcd071b9596e89d&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/77d42944628e2cfcdc23a3f40da6ba630b41be84.jpg","mid":7952086,"name":"秦淮i"},"cover":{"src":"http://i0.hdslb.com/bfs/live/800d77fecc03ff6cde647ee72dd80dd838abb607.jpg","height":180,"width":320},"title":"加拿大萝莉饲养：秦淮金丝肉松饼预售中","room_id":147191,"check_version":0,"online":421,"area":"生活娱乐","area_id":6,"playurl":"http://live-play.acgvideo.com/live/940/live_7952086_5598684.flv?wsSecret=6b5117cf636a1d734dbbcdbfd7a597ac&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/7303b3032d1e13ca7c788cd9c30d4430f8ffd1ea.jpg","mid":19193,"name":"Zelo-Balance"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5baabb87386b9adc8bf6ea88f89ded6c7f034018.jpg","height":180,"width":320},"title":"最遥远的直播,ISS/NASA实时图像","room_id":14047,"check_version":0,"online":643,"area":"生活娱乐","area_id":6,"playurl":"http://live-play.acgvideo.com/live/708/live_19193_2186291.flv?wsSecret=1b9c601e45b4f73a4a26c7f65ad8234d&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/821449668927ac62ffb38f8c5c89b4e15f000cbb.jpg","mid":8860258,"name":"陈逸闻"},"cover":{"src":"http://i0.hdslb.com/bfs/live/73a0d13342bebde1b5f4755cd727ed9bd6f5dfaa.jpg","height":180,"width":320},"title":"震惊！！！up活五百年竟是每天坚持练","room_id":127970,"check_version":0,"online":36,"area":"生活娱乐","area_id":6,"playurl":"http://dl.live-play.acgvideo.com/live-dl/141941/live_8860258_8425382.flv?wsSecret=7f4120a35b57ad34a9259f79afbfd834&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/63c1247419360cc8001fc8ce59c137acad4b9adf.jpg","mid":65602425,"name":"猫咪乌托帮"},"cover":{"src":"http://i0.hdslb.com/bfs/live/8551e3c11de57758b66dc7542019fc72ba5e7a8b.jpg","height":180,"width":320},"title":"和18只喵主子有个约会","room_id":2514950,"check_version":0,"online":220,"area":"生活娱乐","area_id":6,"playurl":"http://dl.live-play.acgvideo.com/live-dl/422894/live_65602425_9255632.flv?wsSecret=026bec1fd49afb0afe358bd24f07c5ee&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/f3590ce3757735707abc94452b7c1c1f96e517a2.jpg","mid":4505367,"name":"干物猫小圆"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f7f3724857d4ac21f1a621ee335eb97a720359ef.jpg","height":180,"width":320},"title":"喵星人一家三口萌宅生活❤喵宅","room_id":203396,"check_version":0,"online":263,"area":"生活娱乐","area_id":6,"playurl":"http://xl.live-play.acgvideo.com/live-xl/935400/live_4505367_8136424.flv?wsSecret=5c0ec4772cd81c862258503811ff407a&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/51402437ff06fb798835a966ce9c0896620ffb57.jpg","mid":232150,"name":"下限酱Orz"},"cover":{"src":"http://i0.hdslb.com/bfs/live/b222df524419844956d2a9d556955c7f927e0789.jpg","height":180,"width":320},"title":"暗中观察小动物，吃饱睡没救了","room_id":54572,"check_version":0,"online":680,"area":"生活娱乐","area_id":6,"playurl":"http://xl.live-play.acgvideo.com/live-xl/950571/live_232150_1148035.flv?wsSecret=c0c13f06b7fb635d6d042c69ee720e78&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/cc7431f1b39f79a44e523609a03e555e3abc861e.jpg","mid":2125737,"name":"魔性小马哥"},"cover":{"src":"http://i0.hdslb.com/bfs/live/679912218f3d0c2091a4e841d9113c1ceac88e89.jpg","height":180,"width":320},"title":"听歌聊天","room_id":595020,"check_version":0,"online":13,"area":"生活娱乐","area_id":6,"playurl":"http://live-play.acgvideo.com/live/697/live_2125737_9349150.flv?wsSecret=9de69a936eb9bacb21351bb27041c905&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/0735f40ff9c0814f3acdc6262fce40c744a1a180.gif","mid":25085312,"name":"imoemo丨爱萌喵"},"cover":{"src":"http://i0.hdslb.com/bfs/live/85109f668df5731ff4c987cc8a367f5aa4f2a73d.jpg","height":180,"width":320},"title":"我们要吃小鱼干~嗷嗷~~","room_id":1268010,"check_version":0,"online":98,"area":"生活娱乐","area_id":6,"playurl":"http://dl.live-play.acgvideo.com/live-dl/439972/live_25085312_6011036.flv?wsSecret=30b02ccc2d67e959011b7a85c750bf91&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/a3c4f4be0784aec68461c6b48828134ae479883b.jpg","mid":16528791,"name":"秋秋好想侵犯智障啊"},"cover":{"src":"http://i0.hdslb.com/bfs/live/e05dff782d44ef0670f4ab99a6f1c793b9665575.jpg","height":180,"width":320},"title":"陪我做我的盖世英雄ฅ(*°ω°*ฅ)*","room_id":156908,"check_version":0,"online":29,"area":"生活娱乐","area_id":6,"playurl":"http://dl.live-play.acgvideo.com/live-dl/662433/live_16528791_3288780.flv?wsSecret=d1c089392ebcdf4f19f8994e3d3ee7f8&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":1,"is_tv":0}]},{"partition":{"id":10,"name":"唱见舞见","area":"sing-dance","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/10.png?201703141338","height":"32","width":"32"},"count":25},"lives":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/7a8fd4384d6b42c3829675ef0a541f8b3d962e9d.jpg","mid":2854676,"name":"老干笋"},"cover":{"src":"http://i0.hdslb.com/bfs/live/427e42f8097f5609eaef9fc6ea14a4b87ed48962.jpg","height":180,"width":320},"title":"【江苏杨洋】攻音；来扯犊子吧","room_id":81697,"check_version":0,"online":2119,"area":"唱见舞见","area_id":10,"playurl":"http://live-play.acgvideo.com/live/555/live_2854676_6179024.flv?wsSecret=ce4683fbd10e17b99bec9e6f5e17fd18&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/9bcc2d568544a40103e25571b58815dcf2aa4d45.jpg","mid":72893529,"name":"泽也sama"},"cover":{"src":"http://i0.hdslb.com/bfs/live/26daddf1eefd49aafa7dddf538016ffe219cce84.jpg","height":180,"width":320},"title":"【温柔男声】越来越攻的小哥哥","room_id":2899554,"check_version":0,"online":18,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/851391/live_72893529_5644195.flv?wsSecret=767f56fa0f5497bcc4af0eef59326003&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/6b0087dd56c46e194797c4f3c892f22ec18ad1a2.jpg","mid":34044423,"name":"不知休不羞"},"cover":{"src":"http://i0.hdslb.com/bfs/live/075f3b43255eb8bfb5b390242467936336ee1f12.jpg","height":180,"width":320},"title":"低音炮温暖男声的练歌日常","room_id":918442,"check_version":0,"online":1996,"area":"唱见舞见","area_id":10,"playurl":"http://dl.live-play.acgvideo.com/live-dl/469359/live_34044423_7465792.flv?wsSecret=3d140b1e9ad0b1536dad7e8d49ef4679&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/5bebbf68c511fe24652c14d92e9c7f9281675398.jpg","mid":26443543,"name":"叁玖39"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f61e0f07170883d363b2ff80b816d1516c214121.jpg","height":180,"width":320},"title":"天然蠢萌治愈系男声","room_id":2801093,"check_version":0,"online":138,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/734985/live_26443543_5667894.flv?wsSecret=ed5fd7e59fbec9211603c1816709a484&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/59faeafd22f5db53e773612a9e8e78c54e947564.jpg","mid":6642147,"name":"爱唱歌的小音匹"},"cover":{"src":"http://i0.hdslb.com/bfs/live/020e90352246cf877d31910020d923c8b858ef8f.jpg","height":180,"width":320},"title":"练歌连歌，~慎入","room_id":371479,"check_version":0,"online":25,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/388856/live_6642147_7538033.flv?wsSecret=03c126027f56635572c749891119be5f&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/758c3e40a2f01db5cd98840556ee0a088afda46f.jpg","mid":37224192,"name":"姬殇lucker"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3366eabeb98ddda1a10716b5d1073228cc94d273.jpg","height":180,"width":320},"title":"（攻音汉子）柔和催眠向。","room_id":3249539,"check_version":0,"online":26,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/938174/live_37224192_7441867.flv?wsSecret=eb37330104c51c63994200841472b8d3&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/1976282dc8b7c50754aa46a35d498d0ca77fad0a.jpg","mid":92373831,"name":"佳文の阿加西"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a2263cd3839881d7253ba1f3b0a0240a562bc65c.jpg","height":180,"width":320},"title":"【声控】一秒让你爱\u201c上\u201d我！","room_id":3787356,"check_version":0,"online":342,"area":"唱见舞见","area_id":10,"playurl":"http://xl.live-play.acgvideo.com/live-xl/578015/live_92373831_4243499.flv?wsSecret=7de942182cfef7429eb21dd8a6cfefcc&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/195c0fb5bbddf03e025649223271f158122cea20.jpg","mid":3243092,"name":"いぬやしゃ_Inuyasha"},"cover":{"src":"http://i0.hdslb.com/bfs/live/380572a751dd4cee1a43f881394bb0224c2b562b.jpg","height":180,"width":320},"title":"（α波段音乐）神奇专业学习与睡眠音乐BG","room_id":29922,"check_version":0,"online":295,"area":"唱见舞见","area_id":10,"playurl":"http://dl.live-play.acgvideo.com/live-dl/382376/live_3243092_332_c521e483.flv?wsSecret=ce0c30cd601c22d020a4dc324188c113&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/6494df2d1fc5dec7a93e273f2772d4940b040070.jpg","mid":37105922,"name":"小软白zz"},"cover":{"src":"http://i0.hdslb.com/bfs/live/14cfb25cef228eeb8ff9ee86cc5e6cae2ede9c85.jpg","height":180,"width":320},"title":"破喉咙","room_id":1005703,"check_version":0,"online":44,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/885584/live_37105922_6082688.flv?wsSecret=3aaf26eac2beb9f49ed2d535bb399f9f&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/1faf73864635c2670bb18c8280f4979336db0096.jpg","mid":7681264,"name":"Jackic"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7604732bc832fd107cad9b7bd8ee3455b149adbf.jpg","height":180,"width":320},"title":"带上耳机 闭上眼睛 你听到了什么","room_id":85609,"check_version":0,"online":20,"area":"唱见舞见","area_id":10,"playurl":"http://txy.live-play.acgvideo.com/live-txy/795621/live_7681264_3756076.flv?wsSecret=7ac0e71772d955cb8a013a6eb2af45e7&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":12,"name":"手游直播","area":"mobile-game","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/12.png?201703141338","height":"32","width":"32"},"count":97},"lives":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/5ef1f34dbea4ab83756396c14153916eac416cdf.jpg","mid":6537448,"name":"原味乳酪"},"cover":{"src":"http://i0.hdslb.com/bfs/live/e248fb9af8f5da1f87c6ebb4b9b3dbd5f463d1ee.jpg","height":180,"width":320},"title":"台服王者荣耀","room_id":1215087,"check_version":0,"online":11,"area":"手游直播","area_id":12,"playurl":"http://live-play.acgvideo.com/live/725/live_6537448_2052007.flv?wsSecret=1aa837f7a0fab0ace252ef95d14aaa1f&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/cc659338399b6b43c17f7d8f836346dcd0fa4ed7.jpg","mid":6330996,"name":"叫我腐神大人"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a0d16cb5431a8b9d57059c73fdbed946226346f1.jpg","height":180,"width":320},"title":"观世音 上荣誉了发福利免费代打钻石以下段","room_id":1761359,"check_version":0,"online":27,"area":"手游直播","area_id":12,"playurl":"http://txy.live-play.acgvideo.com/live-txy/364356/live_6330996_5734838.flv?wsSecret=0b7398543ec6756b3dbc15c4032639fb&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/c0a6155b87576d47891f1a5adc5f1723a787d378.jpg","mid":56496321,"name":"我心凉か"},"cover":{"src":"http://i0.hdslb.com/bfs/live/18469498548ccf00acb86e9f6287add0a0effb61.jpg","height":180,"width":320},"title":"王者荣耀(单排王者局)","room_id":1967796,"check_version":0,"online":1028,"area":"手游直播","area_id":12,"playurl":"http://xl.live-play.acgvideo.com/live-xl/496218/live_56496321_9028411.flv?wsSecret=bdf662f3e589972de5bcc3d37a6669af&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/63ff47a0b4d9b435bba84fec9fab963a1665bf44.jpg","mid":17682864,"name":"解说亡者农药的小五郎"},"cover":{"src":"http://i0.hdslb.com/bfs/live/d31fda40bee6a9bf3952f817a30ea3f463b19a09.jpg","height":180,"width":320},"title":"五老师课堂又他喵开课了","room_id":48511,"check_version":0,"online":523,"area":"手游直播","area_id":12,"playurl":"http://dl.live-play.acgvideo.com/live-dl/493117/live_17682864_8695489.flv?wsSecret=0dc9bce0a904ad7226a938dafa7afb25&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/1681e8a6e876f6b5474452f4b79ee668ed7457a8.jpg","mid":36823481,"name":"保护我方风荷"},"cover":{"src":"http://i0.hdslb.com/bfs/live/6518deddd16240b6cda694a4bfb263d7af78366e.jpg","height":180,"width":320},"title":"♡这个王者小姐姐既不甜也不软~♪","room_id":1601824,"check_version":0,"online":105,"area":"手游直播","area_id":12,"playurl":"http://txy.live-play.acgvideo.com/live-txy/387938/live_36823481_6143890.flv?wsSecret=2e0cddc71bc13eb9dde955f5b377cac0&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/a3a7030d672da2258e65dbcc28db9817f1b783fa.jpg","mid":49979734,"name":"寻夢丶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c743b97261434fac5c77f2f88f7fc5c5b522f980.jpg","height":180,"width":320},"title":"王者荣耀，永远的白银分段","room_id":1951425,"check_version":0,"online":19,"area":"手游直播","area_id":12,"playurl":"http://txy.live-play.acgvideo.com/live-txy/422940/live_49979734_3987476.flv?wsSecret=332e7176a591bf33c9d4e4fb158352a2&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/40434532a46697887ca9e8234bb5a9446f39546c.jpg","mid":8551960,"name":"m→monster"},"cover":{"src":"http://i0.hdslb.com/bfs/live/340285a6d19f50befd4c5046ea83be199e6ed979.jpg","height":180,"width":320},"title":"日常王者荣耀の艾琳","room_id":1941441,"check_version":0,"online":18,"area":"手游直播","area_id":12,"playurl":"http://dl.live-play.acgvideo.com/live-dl/433761/live_8551960_9354773.flv?wsSecret=9c30fb3ce547bd24ce583cc4fb6cc95c&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/50d505e4675c5a824a619e93abf2150a01b77143.jpg","mid":74350574,"name":"二狗子大佬"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7b5ca6ac60c70424fa6c4cdd56422ab97e809a26.jpg","height":180,"width":320},"title":"【王者荣耀】陪小姐姐练练英雄岂不美滋滋","room_id":2982247,"check_version":0,"online":194,"area":"手游直播","area_id":12,"playurl":"http://live-play.acgvideo.com/live/666/live_74350574_9233761.flv?wsSecret=3395854053b269eadf93f7825d7cbb91&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/88fa6358936d46a184dbbff13269ef8ec8aa8e81.jpg","mid":44988715,"name":"zzzhys"},"cover":{"src":"http://i0.hdslb.com/bfs/live/b5eb6a1d3e4790a0c1a2e2ffa26bbe9e9325e953.jpg","height":180,"width":320},"title":"早上好~(*Ü*)ﾉ☀","room_id":2669363,"check_version":0,"online":197,"area":"手游直播","area_id":12,"playurl":"http://txy.live-play.acgvideo.com/live-txy/102880/live_44988715_4622418.flv?wsSecret=1a5000cae6972e1ff5a9f78aa8d4a234&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/083572a196d60b22e991861abd8c900450cc9d70.jpg","mid":17995060,"name":"清君君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/d4f2d6db2771d82978eb2205874638a005f29874.jpg","height":180,"width":320},"title":"求勾搭娱乐游戏(๑\u2022́ωก̀๑)人家超乖","room_id":1676331,"check_version":0,"online":11,"area":"手游直播","area_id":12,"playurl":"http://dl.live-play.acgvideo.com/live-dl/395113/live_17995060_2051557.flv?wsSecret=d75c4d46fb70227cbe9ef14aee167d92&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":1,"name":"单机联机","area":"single","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/1.png?201703141338","height":"32","width":"32"},"count":169},"lives":[{"owner":{"face":"http://i1.hdslb.com/bfs/face/c1799c2569b12853960f363fe04c2464170a94e3.jpg","mid":40497132,"name":"孤独的喵呜君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/64f9d328ebf0dac39ff893c9f56b74b752c8b01b.jpg","height":180,"width":320},"title":"啊喵H1Z1红色姨妈巾带你拿第一","room_id":1841039,"check_version":0,"online":43,"area":"单机联机","area_id":1,"playurl":"http://txy.live-play.acgvideo.com/live-txy/493051/live_40497132_6126054.flv?wsSecret=e451cc13e99bd74723bb674f19d9940e&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/207c6331d3e7a8afb4545b6c80279ba245f5ef2b.jpg","mid":13553262,"name":"萌宠依雯"},"cover":{"src":"http://i0.hdslb.com/bfs/live/aa36b1546c6d216bb55596488cf7349382d3e4c4.jpg","height":180,"width":320},"title":"不凶 超乖","room_id":52285,"check_version":0,"online":313,"area":"单机联机","area_id":1,"playurl":"http://txy.live-play.acgvideo.com/live-txy/129092/live_13553262_7669196.flv?wsSecret=3b637bf17db2c52a8f7103d8f19cead5&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/c3e342491f57417c8ab900ffa13bfd025eab6aeb.jpg","mid":12765050,"name":"Clannad鬼畜"},"cover":{"src":"http://i0.hdslb.com/bfs/live/262307d169b1445c77830676aff3b96ef3a6f635.jpg","height":180,"width":320},"title":"饥荒生存：大量BOSS再活500天","room_id":2604597,"check_version":0,"online":156,"area":"单机联机","area_id":1,"playurl":"http://live-play.acgvideo.com/live/889/live_12765050_4953997.flv?wsSecret=f5fa12de50fdf89f7c6498d9451b59f6&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/cea89158f542c0d9c6252a24aae95283d6d5ee60.jpg","mid":1349724,"name":"洛凛安"},"cover":{"src":"http://i0.hdslb.com/bfs/live/8443c3ed78d948bcea273f8ce0c74675a3d2287b.jpg","height":180,"width":320},"title":"洛特与凛的直播间","room_id":58801,"check_version":0,"online":25,"area":"单机联机","area_id":1,"playurl":"http://dl.live-play.acgvideo.com/live-dl/145771/live_1349724_5824559.flv?wsSecret=220a1b99644792d30d1e373c411a1075&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/ace57c94dbd1ed002c09bfb1d7d85ad8db1e4b04.jpg","mid":3097441,"name":"littlebzzz"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3309227f2e5e3ecba2b216c86adec38825e574b6.jpg","height":180,"width":320},"title":"【时差党】下班回来~星露谷物语~","room_id":22218,"check_version":0,"online":150,"area":"单机联机","area_id":1,"playurl":"http://xl.live-play.acgvideo.com/live-xl/202656/live_3097441_9574477.flv?wsSecret=854e3cdb2a51df2cf07522e5e224a0cb&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/8c4b01366e051cacf0c5895a17d683eac5eaa237.jpg","mid":331520,"name":"yuki琥珀"},"cover":{"src":"http://i0.hdslb.com/bfs/live/99eb8247e92d51c41244d4871dffb91ddb3382f1.jpg","height":180,"width":320},"title":"气人主播","room_id":10248,"check_version":0,"online":1741,"area":"单机联机","area_id":1,"playurl":"http://dl.live-play.acgvideo.com/live-dl/140732/live_331520_2095558.flv?wsSecret=089cbe8aff8db469f1f435cf3c3d5560&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/b275f6f4d3ec2e7ef3d7f000bb8065f66fbf99db.jpg","mid":37704086,"name":"桃乐丝QwQ"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ff4a269be1845684f3fd8d5c989930cbaa519917.jpg","height":180,"width":320},"title":"I jump","room_id":1137444,"check_version":0,"online":21,"area":"单机联机","area_id":1,"playurl":"http://txy.live-play.acgvideo.com/live-txy/862128/live_37704086_8803193.flv?wsSecret=a40df7d29621105bff988360f71829b0&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/ed2ac9a65405b8bedca67d45fb231043a6947a6b.jpg","mid":582661,"name":"铃椛"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f12b0cfe7ceda8ae0cf87e4a925a2e1dc70a3787.jpg","height":180,"width":320},"title":"单排全是鱼【绝地求生大逃杀】","room_id":39189,"check_version":0,"online":6005,"area":"单机联机","area_id":1,"playurl":"http://xl.live-play.acgvideo.com/live-xl/107897/live_582661_4957174.flv?wsSecret=bec19f81aa1436be42e3fdf3ec0a7cf4&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/c52d8d5df531a70cc9c87fbf4a4f9b1732d803a8.gif","mid":8414991,"name":"比尔盖厕"},"cover":{"src":"http://i0.hdslb.com/bfs/live/978dacd7879170afec9a1a688203da31c37eac99.jpg","height":180,"width":320},"title":"【厕】天降酋长.avi 继续~","room_id":273849,"check_version":0,"online":1116,"area":"单机联机","area_id":1,"playurl":"http://txy.live-play.acgvideo.com/live-txy/585448/live_8414991_8935961.flv?wsSecret=150a210937e9366f2caf9cd3ad116df0&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/532ae1544029b7b658ca74f420efc95039f3a9f5.jpg","mid":40294594,"name":"皮皮虾走位的萌叔"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f2a855a789727298c971d1eff90416fc2f0e5744.jpg","height":180,"width":320},"title":"早起的皮皮虾有屠夫吃~~~","room_id":2528674,"check_version":0,"online":661,"area":"单机联机","area_id":1,"playurl":"http://txy.live-play.acgvideo.com/live-txy/987548/live_40294594_1840677.flv?wsSecret=1b8354ea347cbac44b4361d343429b92&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":3,"name":"网络游戏","area":"online","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/3.png?201703141338","height":"32","width":"32"},"count":217},"lives":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/62d4ff27d66c382459079859922aa18ca80bbead.jpg","mid":90927777,"name":"DouBi丶千本樱"},"cover":{"src":"http://i0.hdslb.com/bfs/live/faf122c612a1846c8d2e8d197658efe2998df247.jpg","height":180,"width":320},"title":"睡不着，来打维护句","room_id":3651213,"check_version":0,"online":394,"area":"网络游戏","area_id":3,"playurl":"http://txy.live-play.acgvideo.com/live-txy/754470/live_90927777_5007931.flv?wsSecret=5592ea0c5848e3bac84dcb38e4a46831&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/ab4939b1a925c6dc56338b3e06f3dc57e55e123d.jpg","mid":2071013,"name":"纯白一人努力着"},"cover":{"src":"http://i0.hdslb.com/bfs/live/8c5f9633c9c7d9e96ab0b14e8f0183a809f06da4.jpg","height":180,"width":320},"title":"纯白:彩笔宇宙打单子","room_id":102652,"check_version":0,"online":1245,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/104801/live_2071013_1516608.flv?wsSecret=b8f1513da399544f6fed4982e5154bda&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/2403cded8cba91118d82f5845c473fdd475c20dc.jpg","mid":264213,"name":"永远君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/36e77d2fe42b379e95ff393a901d1e95f587bb4a.jpg","height":180,"width":320},"title":"【欧服守望先锋】将来欧服第一黑百合","room_id":264456,"check_version":0,"online":31,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/832850/live_264213_4316020.flv?wsSecret=1bc7320ecf595c5578298b5b2ef47bc5&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/702fc382f3db813749907450fb6cd042485e6984.jpg","mid":6521220,"name":"搬砖灬波"},"cover":{"src":"http://i0.hdslb.com/bfs/live/527a849d90e6cc035a0ad8c9184c5da82bd7ea76.jpg","height":180,"width":320},"title":"风里雨里 砖厂等你","room_id":2935053,"check_version":0,"online":36,"area":"网络游戏","area_id":3,"playurl":"http://txy.live-play.acgvideo.com/live-txy/961248/live_6521220_3729386.flv?wsSecret=4b0f3059cd2b356769f0ed8cf25e8eed&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/f643616330783b6d0c1944cdda4445563a431912.jpg","mid":3693702,"name":"布束sam"},"cover":{"src":"http://i0.hdslb.com/bfs/live/eccc5bcc9db56ea14901d4c2abc2f85ace89ef72.jpg","height":180,"width":320},"title":"【千胜炮姐】炮姐就是信仰","room_id":72952,"check_version":0,"online":25,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/599332/live_3693702_2815848.flv?wsSecret=29b01d598a074ab5a6c4d9b0a28fa640&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/88ce6577811dd5b9dd250cbe195376249b0599eb.jpg","mid":14322824,"name":"愽丽灵梦"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a889a7be9f8141df4ba13d1785df4d2622782b6d.jpg","height":180,"width":320},"title":"怕是昨天没睡好今天有点迷糊","room_id":274031,"check_version":0,"online":157,"area":"网络游戏","area_id":3,"playurl":"http://dl.live-play.acgvideo.com/live-dl/275333/live_14322824_5404352.flv?wsSecret=4b5be6d2180f0690e62b75444b35f08f&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/28ce9d6865171ace58492cc0c4485e30aa472226.jpg","mid":11046833,"name":"慕佳3C°"},"cover":{"src":"http://i0.hdslb.com/bfs/live/8d939141c29a524f707072cf9f49297e78790fd6.jpg","height":180,"width":320},"title":"免费接深渊，帮合天空开盒子","room_id":102952,"check_version":0,"online":83,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/321980/live_11046833_4969634.flv?wsSecret=db16fd9b3e299fed0ca04a9f43fcb39d&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/2bfe59d150f64540a8e7ed3876c49cbd01e8b76e.jpg","mid":4540232,"name":"萌萌哒的小鸟丶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/941023a402e5be60bc1d4511356ead238ee09bf1.jpg","height":180,"width":320},"title":"全金青玉德冲天梯","room_id":393561,"check_version":0,"online":154,"area":"网络游戏","area_id":3,"playurl":"http://dl.live-play.acgvideo.com/live-dl/772266/live_4540232_4640087.flv?wsSecret=311f656ee0c5f361bb36c86eb680e98c&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/1e86e8afac2bac8e2507208273048ffb23f1ee9c.jpg","mid":3043814,"name":"吃土少女夏夏酱"},"cover":{"src":"http://i0.hdslb.com/bfs/live/6ea5ff7d51f331f51edeeaf57cd582fef0a8339b.jpg","height":180,"width":320},"title":"【1080】300英雄早班车打单子","room_id":37231,"check_version":0,"online":1230,"area":"网络游戏","area_id":3,"playurl":"http://dl.live-play.acgvideo.com/live-dl/580007/live_3043814_1584424.flv?wsSecret=2b8ca08da5dcd5743e086a7bbca25c13&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/2c992c8b35f479134e257db4d99639de52efccca.jpg","mid":4134370,"name":"野生的娜娜酱"},"cover":{"src":"http://i0.hdslb.com/bfs/live/45336e1a7d197c516e55f0706a853fdb71654ac7.jpg","height":180,"width":320},"title":"【300】免费首胜~ 冲进去就是怼√","room_id":270332,"check_version":0,"online":39,"area":"网络游戏","area_id":3,"playurl":"http://xl.live-play.acgvideo.com/live-xl/412362/live_4134370_1464140.flv?wsSecret=abbd2b69e14f3b24fa8d692cd9323ea7&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":4,"name":"电子竞技","area":"e-sports","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/4.png?201703141338","height":"32","width":"32"},"count":146},"lives":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/8c49a758216f9bd14b0046afe48a3514f44126f0.jpg","mid":110631,"name":"宫本狗雨"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a0b3b4976d5cef9a91a632222eb9df24118bb00b.jpg","height":180,"width":320},"title":"(つД`)ノ","room_id":5279,"check_version":0,"online":5587,"area":"电子竞技","area_id":4,"playurl":"http://live-play.acgvideo.com/live/899/live_110631_5953326.flv?wsSecret=36277cd1127077d459448df0818dbb8a&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/70c03590bed4b1a7bdb9288c6bbab9be63368303.jpg","mid":94344779,"name":"不寻七里"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4950bdd0d642a981b62c9781eb29ca9f4bee9d30.jpg","height":180,"width":320},"title":"美服日常背锅，跪在草丛唱征服","room_id":3838378,"check_version":0,"online":25,"area":"电子竞技","area_id":4,"playurl":"http://live-play.acgvideo.com/live/353/live_94344779_4780881.flv?wsSecret=3ebddda818b63eb2ee1135102398b3cd&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/26d93466115911360d9323d804e7dc3e23353550.jpg","mid":8237763,"name":"CZ今天摸鱼了么"},"cover":{"src":"http://i0.hdslb.com/bfs/live/dcd60e0bf7adde4590199cf6cc14702651aca42c.jpg","height":180,"width":320},"title":"磨练口活","room_id":28859,"check_version":0,"online":16,"area":"电子竞技","area_id":4,"playurl":"http://txy.live-play.acgvideo.com/live-txy/475343/live_8237763_5614114.flv?wsSecret=45cba40351bf75fe1d564438b538ac30&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/47849d300c2668b3863b197d06272dbaac7d4cd9.jpg","mid":3021721,"name":"超高校级的月饼"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f4f4bbe035765b4cf4f7a2b454e1d41008bcab2d.jpg","height":180,"width":320},"title":"稳住 我能Carry","room_id":46819,"check_version":0,"online":35,"area":"电子竞技","area_id":4,"playurl":"http://txy.live-play.acgvideo.com/live-txy/318105/live_3021721_4805325.flv?wsSecret=82ebfc4758d3bbe379d7ca9f313fa307&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/e0487dbb21093f12acec74039cbf795b96e77abc.jpg","mid":272675,"name":"吉尔、"},"cover":{"src":"http://i0.hdslb.com/bfs/live/287901d9325960173e6ab2773f44690069ba6572.jpg","height":180,"width":320},"title":"王者中单❤","room_id":39615,"check_version":0,"online":4559,"area":"电子竞技","area_id":4,"playurl":"http://txy.live-play.acgvideo.com/live-txy/198005/live_272675_6523522.flv?wsSecret=4992ebb60423ed3f82772398f0791bf6&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/8ea00923c302ea6514809cac103ae6ab9bebd106.jpg","mid":94461564,"name":"戏命诗"},"cover":{"src":"http://i0.hdslb.com/bfs/live/d866f2e7938e9ccab964db70cb14d03272a5e9b5.jpg","height":180,"width":320},"title":"生日修仙，求辣条开勋章阿！","room_id":3771993,"check_version":0,"online":1014,"area":"电子竞技","area_id":4,"playurl":"http://txy.live-play.acgvideo.com/live-txy/179313/live_94461564_3844023.flv?wsSecret=157cf781fecab0064f6fcb8c8354fdde&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/750c79cfe0c99888af6b87374a0b6dc95372f5ab.jpg","mid":34339053,"name":"三三3Tsundere"},"cover":{"src":"http://i0.hdslb.com/bfs/live/91bc903236651852689b39b423d27729d953563c.jpg","height":180,"width":320},"title":"33：与君共勉","room_id":1618613,"check_version":0,"online":1830,"area":"电子竞技","area_id":4,"playurl":"http://live-play.acgvideo.com/live/307/live_34339053_7690580.flv?wsSecret=42e7dabe8d1f327976029bc0b40291d9&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/819d7356069b657cb78e716d320e0cb340e98358.jpg","mid":25716315,"name":"tiki姐姐"},"cover":{"src":"http://i0.hdslb.com/bfs/live/cd21cedf10f8bff443fd97d0803f7199cf825aa0.jpg","height":180,"width":320},"title":"划水","room_id":237328,"check_version":0,"online":2161,"area":"电子竞技","area_id":4,"playurl":"http://xl.live-play.acgvideo.com/live-xl/777461/live_25716315_5254294.flv?wsSecret=6fed82c8acb8b2e6e41fe62a42c638c8&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/f15727a906b9333c9c27363800a10af6d7bb7ab3.jpg","mid":6652144,"name":"原来豚鼠是咸鱼王"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c2bf56a5c88400d74fe3f2c1ad0949d3bf2fd737.jpg","height":180,"width":320},"title":"一本不正经的鹅鹅鹅鹅鹅鹅","room_id":128390,"check_version":0,"online":30,"area":"电子竞技","area_id":4,"playurl":"http://xl.live-play.acgvideo.com/live-xl/311579/live_6652144_3978323.flv?wsSecret=275660d062867d09bbf6d29f9ed9d977&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/7119844aad67146da4461fa22b088904c7000ee9.jpg","mid":16151010,"name":"米奇沃克斯"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5cc64e6eef82a79c7481fa9cb49a7a3caf1fce68.jpg","height":180,"width":320},"title":"失踪人口回归","room_id":68578,"check_version":0,"online":44,"area":"电子竞技","area_id":4,"playurl":"http://xl.live-play.acgvideo.com/live-xl/272367/live_16151010_7235689.flv?wsSecret=b0c887380668a326222b45457424334f&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":1,"is_tv":0}]},{"partition":{"id":2,"name":"御宅文化","area":"otaku","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/2.png?201703141338","height":"32","width":"32"},"count":24},"lives":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/70944d5a3db9d4db846c402bee479a9fd7cbae72.jpg","mid":44256620,"name":"就不告诉你我叫神"},"cover":{"src":"http://i0.hdslb.com/bfs/live/14f0846d0da1eb2bc9eda4116f3c00d20f744547.jpg","height":180,"width":320},"title":"ASMR带上耳机 哄睡觉","room_id":2883215,"check_version":0,"online":250,"area":"御宅文化","area_id":2,"playurl":"http://txy.live-play.acgvideo.com/live-txy/332922/live_44256620_7252182.flv?wsSecret=91307e4488fc50b3bafe4cef2cf4b0ee&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/63fc402758dd2f9185f37b6bdc073d9899780325.jpg","mid":20661132,"name":"simaDD"},"cover":{"src":"http://i0.hdslb.com/bfs/live/dda98a1246bd32cca760277f267c201153afe0bb.jpg","height":180,"width":320},"title":"Post-Rock 遇到不一样的风景","room_id":3912065,"check_version":0,"online":45,"area":"御宅文化","area_id":2,"playurl":"http://txy.live-play.acgvideo.com/live-txy/504751/live_20661132_9447357.flv?wsSecret=5e13ee13e03132884fca71362111dcf5&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/b6af71cf86a707cc4557d148eb67f50874ef3cb7.jpg","mid":29403074,"name":"迷城菌"},"cover":{"src":"http://i0.hdslb.com/bfs/live/aa213b254b66bf806407ce6c83f7877dc14ab437.jpg","height":180,"width":320},"title":"周六已更新火影永不完结系列纪念舞台剧","room_id":156681,"check_version":0,"online":3142,"area":"御宅文化","area_id":2,"playurl":"http://dl.live-play.acgvideo.com/live-dl/490626/live_29403074_1530203.flv?wsSecret=5853d488a5fb8516d364c3128d04ba04&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/296a76016d6fa26bc8bc0d58377ca7d3a6e0b09c.jpg","mid":2826981,"name":"cv欧瑞"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5601ded3f0985fd1f06d04901948603537b24b88.jpg","height":180,"width":320},"title":"这只cv已经没救了...","room_id":169770,"check_version":0,"online":260,"area":"御宅文化","area_id":2,"playurl":"http://live-play.acgvideo.com/live/875/live_2826981_7236811.flv?wsSecret=8eb614b4481300805b055994172f341d&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/5238704b9edaf253bd6cfb43a67e2d4d674336bd.jpg","mid":4667424,"name":"独繁君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/fcc89e8d0599b902499082a25b56443088b60081.jpg","height":180,"width":320},"title":"ASMR~睡觉时间到了~","room_id":1568070,"check_version":0,"online":23,"area":"御宅文化","area_id":2,"playurl":"http://dl.live-play.acgvideo.com/live-dl/950275/live_4667424_5862655.flv?wsSecret=7d2003e715ca78cb6996f582b6aad0ae&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/035a4acb6657f3a79de741095192eebb5943bcb3.jpg","mid":16409654,"name":"讲故事的小渔彡"},"cover":{"src":"http://i0.hdslb.com/bfs/live/244ac3104d9e39fc70b4eb0b6949435df7e598b4.jpg","height":180,"width":320},"title":"ASMR哄你睡觉戴...耳机听哦","room_id":316483,"check_version":0,"online":1818,"area":"御宅文化","area_id":2,"playurl":"http://txy.live-play.acgvideo.com/live-txy/470844/live_16409654_9727966.flv?wsSecret=839720387d2feaf9f4d2a031d77d16f5&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/67df54c666b6025a490ec6587e49517ba4eea509.jpg","mid":814713,"name":"sshady"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5d7ce3a3caf8bf341d8375f5a4270318afc513b1.jpg","height":180,"width":320},"title":"初音未来，歌姬计划FT","room_id":483757,"check_version":0,"online":1913,"area":"御宅文化","area_id":2,"playurl":"http://live-play.acgvideo.com/live/216/live_814713_7964584.flv?wsSecret=c4fe78eac8a826ded0533d6c557bf24b&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/2c92657f13aa73fbb5ea4282c12dc15472a540da.jpg","mid":33252396,"name":"养老院院长咕喵"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ef7329d4acaaaa945db1c9fc89319937bd0f650d.jpg","height":180,"width":320},"title":"【十分钟入睡房】纯音乐  暖暖地睡一觉吧~","room_id":2426504,"check_version":0,"online":227,"area":"御宅文化","area_id":2,"playurl":"http://txy.live-play.acgvideo.com/live-txy/829760/live_33252396_2688638.flv?wsSecret=ef751877c6a9c4b419228e457b1de372&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/f3e1fcc2516e333b34d3bc42b16e043b6f87a69b.jpg","mid":280037,"name":"这个立花桑大有问题"},"cover":{"src":"http://i0.hdslb.com/bfs/live/d2e0ea861d90e3b919f880c1c4465ae58ba2854d.jpg","height":180,"width":320},"title":"（FM22.33）这个音乐台大有问题！","room_id":137521,"check_version":0,"online":28,"area":"御宅文化","area_id":2,"playurl":"http://dl.live-play.acgvideo.com/live-dl/782266/live_280037_4264311.flv?wsSecret=34934777dec254e8f8c98c75290b750b&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/390d35f4815cf6e82009df066cb70dd62dd8296b.jpg","mid":96458132,"name":"制造美学"},"cover":{"src":"http://i0.hdslb.com/bfs/live/9282a13fa1c5be87bccd53e833527335c96f5942.jpg","height":180,"width":320},"title":"[24h]3D打印机直播-制造美学","room_id":3875958,"check_version":0,"online":13,"area":"御宅文化","area_id":2,"playurl":"http://dl.live-play.acgvideo.com/live-dl/435426/live_96458132_1780071.flv?wsSecret=e8518199b9b8c86455a88bf6e49d75f8&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]},{"partition":{"id":7,"name":"放映厅","area":"movie","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/7.png?201703141338","height":"32","width":"32"},"count":477},"lives":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/23f36223fa6d975d114269ea2094aa79c2cc046a.jpg","mid":2949989,"name":"电喵大战皮卡丘"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c01c98664bfbff4314a43b6b782942364a929c88.jpg","height":180,"width":320},"title":"【耳机福利】抖腿の人生","room_id":397138,"check_version":0,"online":1352,"area":"放映厅","area_id":7,"playurl":"http://dl.live-play.acgvideo.com/live-dl/299861/live_2949989_6518806.flv?wsSecret=15cfffc5f743ad209f1891851fd475ee&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/a4b61ad66c2c435a40847c6dda494af0aad7fa20.jpg","mid":26390633,"name":"不烦人先森"},"cover":{"src":"http://i0.hdslb.com/bfs/live/6fa2f582b4b6b2670ec758de774ecb4af673f7ba.jpg","height":180,"width":320},"title":"动漫【后宫番】【搞笑番】【污番】【萝莉】","room_id":279430,"check_version":0,"online":305,"area":"放映厅","area_id":7,"playurl":"http://live-play.acgvideo.com/live/472/live_26390633_7977540.flv?wsSecret=a3d3f46377aea543b362ba942b83c1bd&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/90b835b39d17c8c6a24557a4b9caacf5d08b97b3.jpg","mid":4668785,"name":"彩虹堂的梦丶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/88f614682c7eab6ce109e83c4dbf788a9a9bdbc8.jpg","height":180,"width":320},"title":"春日的雨露儿时的回忆","room_id":77263,"check_version":0,"online":4937,"area":"放映厅","area_id":7,"playurl":"http://txy.live-play.acgvideo.com/live-txy/467217/live_4668785_4330807.flv?wsSecret=ae1a3ac80be59ee7bb1b70d1fb9bed1a&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/2e411bfb300f7f636951384306167f7b955dbe05.jpg","mid":1289888,"name":"数码暴龙之东北虎"},"cover":{"src":"http://i0.hdslb.com/bfs/live/41878ce6fd7ac8819bb50e7d6bd887d2dbb48cb7.jpg","height":180,"width":320},"title":"【海绵宝宝】给点饭吃吧！","room_id":61834,"check_version":0,"online":1158,"area":"放映厅","area_id":7,"playurl":"http://txy.live-play.acgvideo.com/live-txy/838138/live_1289888_6800900.flv?wsSecret=782f2c0fffd724f77d6e822f0916f371&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/c419d1356facbec518166bab921aec11ad653d08.jpg","mid":44075827,"name":"捷克斯洛伐特"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3c3da72ccc19d9ed1fc1793611573fecc5a5859e.jpg","height":180,"width":320},"title":"特效化妆师1-9 滴滴滴","room_id":1521711,"check_version":0,"online":30,"area":"放映厅","area_id":7,"playurl":"http://dl.live-play.acgvideo.com/live-dl/676768/live_44075827_6735473.flv?wsSecret=019ddb970d3c11a642cd4cd29284fa37&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/932bf8a0e367d3d63fe6b95dc5a5b30f3437d1e9.jpg","mid":40411491,"name":"星愿TV"},"cover":{"src":"http://i0.hdslb.com/bfs/live/933ffe0e6875e577f2296c88a4aa6bf40e3c5e73.jpg","height":180,"width":320},"title":"(手机点我)24小时点播恐怖片林正英","room_id":1505287,"check_version":0,"online":28,"area":"放映厅","area_id":7,"playurl":"http://live-play.acgvideo.com/live/862/live_40411491_7431623.flv?wsSecret=a3350c0ab65cacd108cc3de5f6d70228&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":1,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/9c5e87509c9c57ec2cacbf97f2ec730b328def0d.jpg","mid":22989278,"name":"果冻萌萌的"},"cover":{"src":"http://i0.hdslb.com/bfs/live/303d99a251408032744ec888353e14fd637b94cf.jpg","height":180,"width":320},"title":"【林正英点播】 僵尸 鬼片（手机点我） 24H","room_id":70155,"check_version":0,"online":24349,"area":"放映厅","area_id":7,"playurl":"http://txy.live-play.acgvideo.com/live-txy/825281/live_22989278_9714011.flv?wsSecret=282556328d234ebc2835161294b152d8&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/ad492891e755b5bb985054031c26bb64d73d03eb.jpg","mid":7869429,"name":"慕容羽川"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ded613c6177b6048bd4127236555550ea93b5683.jpg","height":180,"width":320},"title":"24小时郭于岳孙相声↓↓","room_id":896137,"check_version":0,"online":6944,"area":"放映厅","area_id":7,"playurl":"http://live-play.acgvideo.com/live/243/live_7869429_8807543.flv?wsSecret=1e0b8db8292f2d748777b19afd65863f&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/f81a8ed5b02675adb12f802e598e204403dd39e2.jpg","mid":65601664,"name":"热播动漫"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3abb9bc54276c9cb11f68decd3b09f4237c6097c.jpg","height":180,"width":320},"title":"【日语小新】弹幕点播，手机点这里","room_id":2519310,"check_version":0,"online":16718,"area":"放映厅","area_id":7,"playurl":"http://dl.live-play.acgvideo.com/live-dl/656230/live_65601664_6317141.flv?wsSecret=04935da8cd2133b3e5769baa90ee1b26&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/d0728094766d2855f2ad329d7a4a62f9cf87f968.jpg","mid":23631,"name":"川澄Ayako"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c943def40fb4785351624d18f4b1e6b26dee3354.jpg","height":180,"width":320},"title":"【川澄点播】海量电影(手机点这看片单)欧美","room_id":48770,"check_version":0,"online":38427,"area":"放映厅","area_id":7,"playurl":"http://dl.live-play.acgvideo.com/live-dl/833151/live_23631_332_c521e483.flv?wsSecret=0aa7d9e35d4b7246e1207e9bda92ce06&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0}]}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BannerBean> banner;
        private List<EntranceIconsBean> entranceIcons;
        private List<PartitionsBean> partitions;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<EntranceIconsBean> getEntranceIcons() {
            return entranceIcons;
        }

        public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
            this.entranceIcons = entranceIcons;
        }

        public List<PartitionsBean> getPartitions() {
            return partitions;
        }

        public void setPartitions(List<PartitionsBean> partitions) {
            this.partitions = partitions;
        }

        public static class BannerBean implements Serializable {
            /**
             * title : 对象？你尽管抢，抢到算我输
             * img : http://i0.hdslb.com/bfs/live/2807719e244e45714a3e08548b1c889815eaa1f6.png
             * remark : 情人节2.0
             * link : http://live.bilibili.com/AppBanner/index?id=467
             */

            private String title;
            private String img;
            private String remark;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class EntranceIconsBean {
            /**
             * id : 9
             * name : 绘画专区
             * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?201703141338","height":"66","width":"66"}
             */

            private int id;
            private String name;
            private EntranceIconBean entrance_icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public EntranceIconBean getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBean entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            public static class EntranceIconBean {
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?201703141338
                 * height : 66
                 * width : 66
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class PartitionsBean {
            /**
             * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338","height":"32","width":"32"},"count":16}
             * lives : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/e6c43dbbbc99b093bcc636e321afe9eb5552581f.jpg","mid":35853463,"name":"在吗-任性的加班帝"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7dc55f1e44990cc5995e6f582020fbc3020fee07.jpg","height":180,"width":320},"title":"CAD","room_id":519402,"check_version":0,"online":165,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/342348/live_35853463_2348866.flv?wsSecret=3fecbdbb886b2972aa5b697919d49377&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/195f8ce93f0b5526ec41c98914619569b4a9c769.jpg","mid":149066,"name":"Pelokio"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4acadb3b82d9f2f1c115a2b5d264d49316ddc64b.jpg","height":180,"width":320},"title":"边听英语，实力赶稿","room_id":31555,"check_version":0,"online":24,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/586/live_149066_332_c521e483.flv?wsSecret=eb3bbf9f9399a73d5f596cf8d14c97f2&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/fc49cb0317d6574e8a467b7854faa5dca467be7b.jpg","mid":29776658,"name":"画画的灰MO"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7a56c019babcd4c9597cca693e2f94d271275901.jpg","height":180,"width":320},"title":"随便画点什么，沉迷妹抖龙","room_id":162308,"check_version":0,"online":9,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/543531/live_29776658_3739401.flv?wsSecret=45efa1852ed15c89c7d4f14e6bd153d1&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/3afa26e6d5e3068511a48f65d4e366121d504ecf.jpg","mid":96190044,"name":"一叶绣春刀"},"cover":{"src":"http://i0.hdslb.com/bfs/live/34e13cf902a4d9164debfc2439758f63979be8f5.jpg","height":180,"width":320},"title":"腾讯漫画《入侵》赶稿","room_id":3867714,"check_version":0,"online":57,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/266852/live_96190044_1317086.flv?wsSecret=094e705a5ed2e8216e1d427ccf30d8aa&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/4bee6c1183f63a3e404f202adce3d63d2ae040ad.jpg","mid":36006,"name":"kange"},"cover":{"src":"http://i0.hdslb.com/bfs/live/9d6a6d9a2b2d8988168b7187b28eafa7f78e91bc.jpg","height":180,"width":320},"title":"kange的肝爆机","room_id":12790,"check_version":0,"online":23,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/920740/live_36006_332_c521e483.flv?wsSecret=9c97e3fa32bca22517a5ec555558205b&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/79d71d1c93fbaf31df807d75b83a6022a55373cb.jpg","mid":19707743,"name":"B站制簪人蝉蝉"},"cover":{"src":"http://i0.hdslb.com/bfs/live/40541f92ccf11a79d55e9691aaf2d0dad54bf22e.jpg","height":180,"width":320},"title":"蝉蝉搞事，钻真骨头，卡拉卡拉","room_id":102358,"check_version":0,"online":83,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/808702/live_19707743_5536546.flv?wsSecret=8bd55a070cfdc60effc2d770480ddf4d&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/177a690d764bcef1569483dc647ad63cff75678d.jpg","mid":3177174,"name":"公子安好"},"cover":{"src":"http://i0.hdslb.com/bfs/live/aff70f5fa5d1f7780b65de237aa902b08af1dced.jpg","height":180,"width":320},"title":"送你一份超大的胖次、日系卡牌绘制","room_id":1588108,"check_version":0,"online":27,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/583063/live_3177174_7062644.flv?wsSecret=5d1a43c3179a796b97951cbce1dd4950&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/af2a1c6b0842277f9beeaf9df7a79264e496bca6.jpg","mid":69202135,"name":"我叫小薇"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ea95b0535091d5d94a2d773ca5d835cd939546fd.jpg","height":180,"width":320},"title":"日漫一辣眼睛的zb建模日漫原画入上万 盛途","room_id":2796538,"check_version":0,"online":32,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/305615/live_69202135_6613091.flv?wsSecret=acef3d6f8490e7ef07c32dd63d39f2a0&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/ba500657cf4dce0b71f7ab175b00cf18e53b4bc0.jpg","mid":35817562,"name":"飞行员手绘"},"cover":{"src":"http://i0.hdslb.com/bfs/live/11bac33b99a7890c252444045aed6c863addf399.jpg","height":180,"width":320},"title":"画个小姐姐","room_id":932655,"check_version":0,"online":25,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/360710/live_35817562_4490375.flv?wsSecret=d89443bfedbc5c67be80ca61ed18be2a&amp;wsTime=1490058722","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/62e13ea28a5a692cfe50292b951352ba4fd794f5.jpg","mid":23487796,"name":"聚流陶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/76361.jpg?03210840","height":180,"width":320},"title":"陶叔 每日百画-群499950841","room_id":76361,"check_version":0,"online":24,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/293/live_23487796_5237678.flv?wsSecret=3c9d4fc8ec6e941b592c306529b2d790&amp;wsTime=58a8f7ea","accept_quality":"4","broadcast_type":0,"is_tv":0}]
             */

            private PartitionBean partition;
            private List<LivesBean> lives;

            public PartitionBean getPartition() {
                return partition;
            }

            public void setPartition(PartitionBean partition) {
                this.partition = partition;
            }

            public List<LivesBean> getLives() {
                return lives;
            }

            public void setLives(List<LivesBean> lives) {
                this.lives = lives;
            }

            public static class PartitionBean {
                /**
                 * id : 9
                 * name : 绘画专区
                 * area : draw
                 * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338","height":"32","width":"32"}
                 * count : 16
                 */

                private int id;
                private String name;
                private String area;
                private SubIconBean sub_icon;
                private int count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconBean getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconBean sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public static class SubIconBean {
                    /**
                     * src : http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338
                     * height : 32
                     * width : 32
                     */

                    private String src;
                    private String height;
                    private String width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }
                }
            }

            public static class LivesBean {
                /**
                 * owner : {"face":"http://i1.hdslb.com/bfs/face/e6c43dbbbc99b093bcc636e321afe9eb5552581f.jpg","mid":35853463,"name":"在吗-任性的加班帝"}
                 * cover : {"src":"http://i0.hdslb.com/bfs/live/7dc55f1e44990cc5995e6f582020fbc3020fee07.jpg","height":180,"width":320}
                 * title : CAD
                 * room_id : 519402
                 * check_version : 0
                 * online : 165
                 * area : 绘画专区
                 * area_id : 9
                 * playurl : http://dl.live-play.acgvideo.com/live-dl/342348/live_35853463_2348866.flv?wsSecret=3fecbdbb886b2972aa5b697919d49377&amp;wsTime=1490058722
                 * accept_quality : 4
                 * broadcast_type : 0
                 * is_tv : 0
                 */

                private OwnerBean owner;
                private CoverBean cover;
                private String title;
                private int room_id;
                private int check_version;
                private int online;
                private String area;
                private int area_id;
                private String playurl;
                private String accept_quality;
                private int broadcast_type;
                private int is_tv;

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getCheck_version() {
                    return check_version;
                }

                public void setCheck_version(int check_version) {
                    this.check_version = check_version;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getPlayurl() {
                    return playurl;
                }

                public void setPlayurl(String playurl) {
                    this.playurl = playurl;
                }

                public String getAccept_quality() {
                    return accept_quality;
                }

                public void setAccept_quality(String accept_quality) {
                    this.accept_quality = accept_quality;
                }

                public int getBroadcast_type() {
                    return broadcast_type;
                }

                public void setBroadcast_type(int broadcast_type) {
                    this.broadcast_type = broadcast_type;
                }

                public int getIs_tv() {
                    return is_tv;
                }

                public void setIs_tv(int is_tv) {
                    this.is_tv = is_tv;
                }

                public static class OwnerBean {
                    /**
                     * face : http://i1.hdslb.com/bfs/face/e6c43dbbbc99b093bcc636e321afe9eb5552581f.jpg
                     * mid : 35853463
                     * name : 在吗-任性的加班帝
                     */

                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CoverBean {
                    /**
                     * src : http://i0.hdslb.com/bfs/live/7dc55f1e44990cc5995e6f582020fbc3020fee07.jpg
                     * height : 180
                     * width : 320
                     */

                    private String src;
                    private int height;
                    private int width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }
                }
            }
        }
    }
}
