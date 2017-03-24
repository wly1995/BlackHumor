package com.atguigu.blackhumor.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 万里洋 on 2017/3/24.
 */

public class RankBean {
    /**
     * code : 0
     * data : [{"title":"被封禁四十年后 这部漫画终于重见天日《阿修罗》","cover":"http://i1.hdslb.com/bfs/archive/346b8941701812e23dd8c5949a3b2159b71500bc.jpg_320x200.jpg","uri":"bilibili://video/9322338","param":"9322338","goto":"av","name":"八月看大片","play":282938,"danmaku":943,"reply":1,"favourite":9527,"pts":327680},{"title":"【敖厂长】荒岛求生","cover":"http://i1.hdslb.com/bfs/archive/02cb57469b8e68bfaa501060f0d3a56fd7429dff.png_320x200.png","uri":"bilibili://video/9350079","param":"9350079","goto":"av","name":"敖厂长","play":354696,"danmaku":10231,"reply":12,"favourite":2243,"pts":318745},{"title":"起小点TOP10 VOL283 危机乍现，暴烈骑士背水一战","cover":"http://i2.hdslb.com/bfs/archive/032708eab543ecdf042c82d0acd762d6a4859a78.jpg_320x200.jpg","uri":"bilibili://video/9310469","param":"9310469","goto":"av","name":"长歌是大腿","play":300942,"danmaku":1399,"reply":2,"favourite":295,"pts":274626},{"title":"【国漫导视】你的全职到货了！一口气看完17年值得期待的国漫","cover":"http://i2.hdslb.com/bfs/archive/c536fa724e59412117a900da76f2629fdb0d3851.jpg_320x200.jpg","uri":"bilibili://video/9324315","param":"9324315","goto":"av","name":"凉风有性胖次君","play":164138,"danmaku":3365,"reply":2,"favourite":8773,"pts":235945},{"title":"【逗鱼时刻】第102期 军备宝箱有什么用","cover":"http://i0.hdslb.com/bfs/archive/3a0265cd56a19ae454ed7e1b187ec99de143b884.jpg_320x200.jpg","uri":"bilibili://video/9349329","param":"9349329","goto":"av","name":"天天卡牌","play":257946,"danmaku":2772,"favourite":526,"pts":226971},{"title":"【主播真会玩】82：狗粮，还是洞主牌好吃！","cover":"http://i1.hdslb.com/bfs/archive/ffe6172ccb9e00aea9f8e8b8bce734c6fc4a4ff1.jpg_320x200.jpg","uri":"bilibili://video/9348072","param":"9348072","goto":"av","name":"起小点是大腿","play":252926,"danmaku":3417,"reply":1,"favourite":320,"pts":223028},{"title":"五五开与女粉丝开视频，女粉丝害羞捂脸跟五五开谈自己男友","cover":"http://i0.hdslb.com/bfs/archive/920fb0dcd71bdea7efd6dc1c0c11248efb74c7db.jpg_320x200.jpg","uri":"bilibili://video/9309084","param":"9309084","goto":"av","name":"笑疯江湖","play":230264,"danmaku":1197,"favourite":1553,"pts":221852},{"title":"大胃王密子君（披萨甜品）到底发生了什么？密子君在视频中居然啪啪打脸，吃播吃货美食！","cover":"http://i1.hdslb.com/bfs/archive/52cbfcaf73a8e4b8160de1f104ff37de76b37987.jpg_320x200.jpg","uri":"bilibili://video/9311129","param":"9311129","goto":"av","name":"大胃王密子君","play":244529,"danmaku":1471,"reply":2,"favourite":391,"pts":217637},{"title":"主播炸了232：PDD风骚像个300斤胖子 德云色并没有女粉丝","cover":"http://i1.hdslb.com/bfs/archive/5e97cb8dff35eb6a1933b4fe0caa3d1619ac74a8.jpg_320x200.jpg","uri":"bilibili://video/9314079","param":"9314079","goto":"av","name":"聚印象视频","play":245260,"danmaku":1784,"favourite":199,"pts":216389},{"title":"【允星河】来一起乘坐我建造的最变态的过山车！不能我一个人被恶心！","cover":"http://i1.hdslb.com/bfs/archive/cee02405272108633ddbc94232809007371c37b5.jpg_320x200.jpg","uri":"bilibili://video/9307650","param":"9307650","goto":"av","name":"允星河Yoseya","play":207356,"danmaku":3445,"reply":1,"favourite":1318,"pts":210247},{"title":"日本人发明了踩上去会有快感的拖鞋，妹纸穿了脱不下来","cover":"http://i1.hdslb.com/bfs/archive/d90c870cef4dd6fac9818a51eb7f91b3db4dbe8d.jpg_320x200.jpg","uri":"bilibili://video/9306491","param":"9306491","goto":"av","name":"极客真会玩","play":212011,"danmaku":141,"favourite":1204,"pts":208186},{"title":"钢铁侠险些丧命，地球最强登场《浩克世界大战》下","cover":"http://i2.hdslb.com/bfs/archive/5d639c373ac7f72e8c5904729271ee6b3ff57181.jpg_320x200.jpg","uri":"bilibili://video/9332353","param":"9332353","goto":"av","name":"努力的Lorre","play":188353,"danmaku":1224,"reply":4,"favourite":1720,"pts":180266},{"title":"长夜漫漫，无心睡眠 @野食小哥","cover":"http://i2.hdslb.com/bfs/archive/bbf6aec7fa560f1c6efe467ca14037252b5e1bc7.jpg_320x200.jpg","uri":"bilibili://video/9323088","param":"9323088","goto":"av","name":"野食小哥","play":194400,"danmaku":2673,"reply":2,"favourite":627,"pts":174983},{"title":"自从这群歪果仁游遍中国以后。。。","cover":"http://i0.hdslb.com/bfs/archive/537b3ab0ff2620f33dd628baa3f40731866c7106.jpg_320x200.jpg","uri":"bilibili://video/9345244","param":"9345244","goto":"av","name":"歪果仁研究协会","play":183873,"danmaku":4310,"reply":5,"favourite":999,"pts":172906},{"title":"【抗韩中年人】112期.蜘蛛蛮王最强越塔组合 131偷塔偷龙逆风翻盘","cover":"http://i1.hdslb.com/bfs/archive/d5192d32bf357c6d4037ab770a6b05c6991db17b.jpg_320x200.jpg","uri":"bilibili://video/9312779","param":"9312779","goto":"av","name":"拳师小七","play":168502,"danmaku":2995,"reply":2,"favourite":398,"pts":154869},{"title":"【动漫碎碎念】第40期\u2014\u2014不按套路出牌！那些在主流背景下的反主流动画","cover":"http://i1.hdslb.com/bfs/archive/ecbf26d89b90fc64ec71739bd816922a822485af.jpg_320x200.jpg","uri":"bilibili://video/9325157","param":"9325157","goto":"av","name":"尕丶天堂","play":129375,"danmaku":8597,"reply":2,"favourite":2253,"pts":151202},{"title":"【排骨】翅膀","cover":"http://i0.hdslb.com/bfs/archive/9fb7eded619eec9aa326b66a93b7b61e698d7df5.png_320x200.png","uri":"bilibili://video/9345810","param":"9345810","goto":"av","name":"排骨教主","play":88462,"danmaku":3643,"reply":3,"favourite":6604,"pts":149211},{"title":"【神他妈违和感 VOL3】神他妈你还没看过超兽1、2部，第三部开拍了！","cover":"http://i2.hdslb.com/bfs/archive/e582811453649bcad31dfcd0a5e843603bfc602d.jpg_320x200.jpg","uri":"bilibili://video/9307362","param":"9307362","goto":"av","name":"紫银风","play":109325,"danmaku":845,"favourite":3805,"pts":145417},{"title":"【王者荣耀体验服黄buff登场and吕布大招视觉效果修改】","cover":"http://i0.hdslb.com/bfs/archive/81643de2fa3e9b74364a27e7d0f8221a1c1f608f.jpg_320x200.jpg","uri":"bilibili://video/9308675","param":"9308675","goto":"av","name":"浅忆丶","play":146592,"danmaku":390,"reply":1,"favourite":1046,"pts":143464},{"title":"这是二哈吗，真不敢相信","cover":"http://i2.hdslb.com/bfs/archive/f656a2765455b661aa278ef980ac5f5b76f1d60c.jpg_320x200.jpg","uri":"bilibili://video/9309327","param":"9309327","goto":"av","name":"Alfred斯斯","play":139872,"danmaku":414,"favourite":1204,"pts":140363}]
     * message :
     */
    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 被封禁四十年后 这部漫画终于重见天日《阿修罗》
         * cover : http://i1.hdslb.com/bfs/archive/346b8941701812e23dd8c5949a3b2159b71500bc.jpg_320x200.jpg
         * uri : bilibili://video/9322338
         * param : 9322338
         * goto : av
         * name : 八月看大片
         * play : 282938
         * danmaku : 943
         * reply : 1
         * favourite : 9527
         * pts : 327680
         */

        private String title;
        private String cover;
        private String uri;
        private String param;
        @JSONField(name = "goto")
        private String gotoX;
        private String name;
        private int play;
        private int danmaku;
        private int reply;
        private int favourite;
        private int pts;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getReply() {
            return reply;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public int getFavourite() {
            return favourite;
        }

        public void setFavourite(int favourite) {
            this.favourite = favourite;
        }

        public int getPts() {
            return pts;
        }

        public void setPts(int pts) {
            this.pts = pts;
        }
    }
}
