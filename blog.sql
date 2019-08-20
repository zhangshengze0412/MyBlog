/*
 Navicat Premium Data Transfer

 Source Server         : 我的连接
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 30/07/2019 20:49:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES (11, 2018211261, 2027202434);
INSERT INTO `attention` VALUES (12, 2018211261, 1533260543);
INSERT INTO `attention` VALUES (13, 2018211258, 2018211261);
INSERT INTO `attention` VALUES (14, 2018211259, 2018211261);
INSERT INTO `attention` VALUES (15, 2018211249, 2018211261);
INSERT INTO `attention` VALUES (16, 2018211261, 2018211249);
INSERT INTO `attention` VALUES (17, 2018211261, 2023232323);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `see` int(255) NULL DEFAULT NULL,
  `thumbup` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (23, 2027202434, '一病解千愁', '灯下鼠', '2019-07-30 16:25:17', '古代中国的文化人很变态，他们不追求健康，反倒认为生个病才美滋滋的。这就是鲁迅所说的 “秋天薄暮，吐半口血，两个侍儿扶着，恹恹的到阶前去看秋海棠”。\r\n\r\n\r\n\r\n我坦白，我年轻时也变态，也幻想去看秋海棠，有俩侍儿，必须是漂亮女的，扶着我去阶前。后来命运之神眷顾，我得偿所愿，年纪轻轻二十多岁就实现了人生理想 - 我真得了病，很难缠的慢性病，叫类风湿。然而，病虽是有了，俩侍儿却一直没到岗，秋海棠也是连毛都没有一根。\r\n\r\n也许是类风湿不吐血的缘故，它营造不出哀愁悲壮的气氛。类风湿只是默默的摧毁病人的小关节，它几十年如一日的努力，直到给病人干残了，它.........也不会收手，因为身上的关节多着呢，轮换着玩几辈子都够用。\r\n\r\n病人这才醒悟过来，我日他妈的，要什么侍儿，要什么秋海棠，要什么自行车啊。\r\n\r\n如果全世界的病人联合起来，应该有个几十亿，光糖尿病全球就 4.5 亿呢。粗估计下，可以算全世界病人联合会有 40 亿人，地球上最大的社群或国家就此诞生！Facebook 玩蛋去吧！\r\n\r\n若是按照病症轻重设立此病国的城市，估计我就是到不了北京上海，也得是广州深圳重庆天津这样的一二线，而且我肯定户口、社保、工作、房产都齐备，保不准还是个公务员。北京上海这样的超大城市留给癌症这些王者之病，超大城市人口流动率极大，进去了领个暂住证，很快就走了，所以北京上海的户口就很稀罕........病国的居民最不愿意的，就是往大城市调动迁移：“我一个成都的书记，怎么就调到北京了呢？”\r\n\r\n\r\n\r\n但是我们要辩证的看问题，生病虽然痛苦，也一样存在两面性，只要善于总结，好处还是有的。最大的好处，就是可以把病用来当借口和理由。比如最简单的，请个病假：“感冒了，下午要手术，项目评审会不能参加”。\r\n\r\n用来骗骗别人，对于大病、重病来说，那是大材小用，用来骗自己才称得上国之重器。 比如我吧，有了类风湿这个理由，首先就砍掉了当年的那个小目标，一个亿的预期收入当即减半、再减半、再减半、再减半、再减半、再减半、再减半、再减半、再减半、再减半，这才紧巴巴地完成了全年计划。\r\n\r\n当我们的 “野心” 和 “欲望” 两法官联手，在灵魂之庭拷问 “能力” 和 “努力” 二犯人的时候，二犯理直气壮的为自己辩护：“不怪我们俩，是体制问题，体制得了类风湿。”\r\n\r\n所以古人常说贫病交加，说到底，有病才会贫，而因为贫，病才痛苦。君不见，有钱的人生病，那是福气，直接就侍儿扶着去看秋海棠了。贫与病，互为因果，又互为支撑。\r\n\r\n有了病之后，也就安贫乐道了，这也是好处。十几年来，我一箪食一瓢饮，怎么做到不改其乐的呢？当然要谢谢类风湿了。啊！我的 inner peace！ 啊！我的类风湿！\r\n\r\n人类的忧愁，也有一个算法模型。比如，你正在忧愁，因为刚去过同学会，那帮逼个顶个亿万富翁，个顶个司局级干部，而你却一贫如洗，布衣短褐牛犊裤一介平头百姓，搁在古代，你这同学会就得跪着参加。于是你嫉火中烧，于是你怨天尤人。此时，只要有一纸体检报告就能解你此忧，那纸报告意思是要调动迁移你去北京上海这样的一线城市。惊吓之下，你肯定立刻忘记了那帮亿万富翁和司局级的老同学们。 在魂飞魄散的宏大背景下，专心致志地思虑你的病。\r\n\r\n任何忧愁，都只能用另一个更大的忧愁去掩盖。\r\n\r\n生病，能掩盖很多忧愁，越重的病，掩盖效果越好。这样想来，北京上海乃是无忧无虑之都。\r\n\r\n这个算法还没说完。生病的时候集中精力去对付痛苦折磨，此时的人真乃粪土万户侯、千金不入眼的豪杰通达之士，到达了 inner peace 的完美境界，俗话叫豁达，也叫看开了。可一旦病好转了，inner peace 按照惯性定律也就坚持了两个月，悄悄的，那一个亿的小目标就又露出了小荷尖尖角。再去参加个同学会、同乡会什么的，那嫉火和幽怨，刷的就全回来了，包你个严严实实。\r\n\r\n病就很无奈，妈的，你再要我帮忙消愁，我就直接调动你去北京上海得了。\r\n\r\n我说过，我早就 inner peace 了，境界非常的辽阔高远，真乃一片碧空万里无云啊。这当然首先要感谢国家，其次我想说我得感谢病，虽然暂时没有一线城市的调动通知，但二三线城市我是走过不少.....\r\n\r\n2 月份的时候，类风湿轻微发作，这是例行公事，也没什么稀奇的。两个指关节肿胀，右腿膝盖肿胀积液。按照经验来说，1-2个月就会过去。\r\n\r\n2个月过后，指关节倒是好了，膝关节越发严重，而且玩出了新花样，以前没有过的。右腿小腿肌肉僵硬，仿佛肌肉冻僵结冰了，成了一块坚硬的晶体。那么小腿里塞入一块晶体的感觉是什么呢？ 是一种抽筋的感觉，酸疼肿胀。\r\n\r\n好奇特呀。以前常常膝盖肿，但肌肉变铁块，倒是第一次。难道要换城市？我暗自纳罕。不过我觉得应该不是什么大毛病，毕竟是肌肉的毛病，不会是大事。\r\n\r\n我的类风湿医生还是很有经验的，他摸了一下，便问：“膝盖后面，是不是长了积液囊肿？”\r\n\r\n我莫名其妙，没长什么囊肿啊，就是类风湿积液罢了。医生沉吟了下，开了张 B 超。\r\n\r\nB 超大夫是位女士，面容清秀，她摸了一下惊叹道：“(*@ο@*) 哇～， 好大好硬。” 我有点羞涩，心说您夸人太直接了吧。\r\n\r\nB 超头在腿部探察了一圈，医生看着屏幕，就下结论了。清秀面容一字一句说，助理跟着敲字：“腘窝囊肿”。我下了小床，放下裤腿，马上google，这腘窝囊肿倒不是什么一线城市，不过需要手术。\r\n\r\n但我的医生说别手术了，你这囊肿都破了，积液已经到了肌肉里，挤得肌肉坚钢如铁，象无产阶级战士一样，你就等着慢慢吸收吧。\r\n\r\n“积液黑糊糊，粘稠，跟沥青一样，吸收需要时间。” 医生见怪不怪：“还是吃药控制类风湿炎症重要。” 医生给我加了药，加的药叫柳氮磺吡定片，病友们俗称 “流弹” 是也。我10年前就用过这药。\r\n\r\n“对流弹不过敏吧？” 医生问。\r\n\r\n“不过敏。” 我很自信，以前吃过嘛。\r\n\r\n后来的事实证明，我错了。我以为，我对于病国的城市天际线已经很熟悉，然而，我没想到这城市搞了一次 “拆除广告牌，亮出天际线”，我就迷路了。\r\n\r\n服用流弹 2 个月后，我进入了一个陌生的城市，它是驻马店和杭州的结合部。简单说，就是药物荨麻疹。\r\n\r\n这病并不严重，医生也只是嘱咐停药即可。不过，从感官上，这药疹的冲击性极其剧烈。浑身长包，密密麻麻的，可以吓死密集恐惧症患者。另外，全身痒不可耐，完全控制不住，挠得浑身血淋淋，仿若僵尸。不过，药疹留情了，没上脸，脸上倒没长包。\r\n\r\n我向医生汇报，描述荨麻疹的症状，就很自豪，颇有成就感。医生见怪不怪：“你这不算什么，还有浑身掉皮的，掉得跟刚出生的小老鼠一样，粉红粉红。”\r\n\r\n“还好，你药物过敏只是影响皮肤，要是连累内脏器官，还是有危险的。” 医生年纪轻轻，声音里就有佛祖那种平静的慈悲。\r\n\r\n“可 10 年前我用过流弹，不过敏啊。” 我还是不敢相信。\r\n\r\n“你变了，” 医生的声音里带着一丝哀怨：“环境改变了你。” \r\n\r\n看着满身的包包和疙瘩，我充满爱意的抚摸它们，问：“你们从哪里来？要到哪里去？你们会陪我很久吗？”\r\n\r\n我捡最密集的地方，拍了张照片，以作留念。 \r\n\r\n一位朋友要去洛杉矶发展了，他来和我小聚，看着我胳膊上的荨麻疹包块，他思索片刻：“我可以推荐你去演 X 战警中的魔形女。”\r\n\r\n1 个月后，荨麻疹消失。2 个月后，浑身挠出来的伤疤消失。腿部肌肉的肿块也逐渐消失，不再又大又硬，它慢慢的松弛下来，恢复成缺乏锻炼的中年人应该有的肌肉。\r\n\r\n类风湿的药也换了一种，叫做艾拉莫德。我搜索了一下，是日本研制的，但国内药厂却号称是自研的。\r\n\r\n膝盖还有点肿胀，行走略为不便，去公厕我可以理直气壮的走进残障人士专用包间。\r\n\r\n2019 年的这几个月，就这么无忧无虑的过去了。虽然计划中 20 亿的营业额没有完成，3 篇顶级刊物的论文没有完成，改变社会的核心科技产品没有完成，就连读书与写简书都停了，但我有理由啊 - 我生病了。\r\n\r\n衷心感谢各种病，一病解千愁！\r\n\r\n祝广大朋友们都生病，当然不是重病，就在那种十八线的城市安居下来，获得 inner peace，也获得一个解放自己的理由。 \r\n\r\n', 151, 2);
INSERT INTO `blog` VALUES (24, 2027202434, '到底谁，才是强东的兄弟', '灯下鼠', '2019-07-30 16:39:43', '桃园，花开正盛。云长、翼德跪在香前，等待已久。二人齐声唤道：“哥哥，我是你的兄弟。”强东摇摇头：“不，你们不是我的兄弟。”那怪从新礼拜三藏，愿随西去。又与强东拜了，以先进者为兄，遂称强东为师哥。强东摇摇头：“不，你不是我的兄弟。”梁山泊忠义堂上，号令已定，各各遵守。捡了良辰吉日，焚一炉香，鸣鼓聚众。一百零八兄弟，拈香已罢，一齐跪在堂上。独独强东站了起来。强东摇摇头：“不，你们不是我的兄弟。”吴道官伸开疏纸朗声读道：“维大宋国山东东平府清河县信士强东、应伯爵、谢希大、花子虚、孙天化、祝念实、云理守、吴典恩、常峙节、白赉光等.....” 话犹未完强东摇摇头：“不，你们不是我的兄弟。”凤姐笑道：“好兄弟，你是个尊贵人，女孩儿一样的人品，别学他们猴在马上。下来，咱们姐儿两个坐车，岂不好。”强东摇摇头：“不，你不是我的兄弟。”小蝌蚪看见他头顶上有两只大眼睛，嘴巴又阔又大，他们想一定是他来了，追上去喊：“哥哥！哥哥！我们是你的兄弟。”强东摇摇头：“不，你们不是我的兄弟。”', 124, 1);
INSERT INTO `blog` VALUES (25, 2023232323, '【言论】智能理论-4', 'zhyuzh3d', '2019-07-30 16:44:50', '## 智能表现\r\n\r\n智能是一种能力，只有当它实际表现出来的时候才有意义。尽管我们接下来更多的讨论是关于这种能力的本身动力，但日常我们所见的确都是它的具体表现。这就像数字1本身是一个抽象的数量概念，但现实中我们所能看到的确都是它的表现形式，一个苹果，一个人，一句话。\r\n\r\n正如一个聪明的人，我们所见的只是他如何更快速找到各种问题的答案或者解决方案，而不是看到他大脑结构和运行方式。在这里，我们将聚焦于智能的结果和运作方式，而不是它的表现。但即使是把智能表现从其他行为表现中剥离出来，都不是一件简单的事。\r\n\r\n智能的表现是指根据已知信息和经验信息来对未知结果进行预测。\r\n\r\n一个运动员具有灵活的肢体，当他挥动球棒击中棒球的时候，智能在这里只是表现在他对飞球轨迹的预测，也表现在他对手中球棒速度、位置和时间的预测，他预测到在某个时间球棒的运动轨迹和飞球的轨迹会相交，击球会成功。然而至于挥棒的速度和力度，以及如何控制手臂肌肉运动，这些并不是智能表现的内容。\r\n\r\n实际上运动员在这个挥棒动作中，预测行为并不是一次性的，他不断的从视觉系统获得球的飞行信息，不断的进行预测，使预测结果越来越准确。对于人类大脑来说，挥棒击球这个动作实在太快，在动作发起之后我们几乎没有办法再做出有效的补救调整，但我们的预测并没停止，所以很多时候动作还没完成的时候我们就已经知道了结果。\r\n\r\n“完蛋了”，动作才发出我们就已经知道失败，这正说明智能预测与动作控制是完全不同的两种的行为表现。\r\n\r\n我们必须把智能展现放在预测能力这个角度进行讨论，才能排除其他行为表现造成的干扰。\r\n\r\n## 智能体\r\n\r\n智能的表现必须依赖于整体，我们称之为智能体。\r\n\r\n智能体并非指物理实体，而是指智能表现所依赖的整体结构及运行规则。比如一段智能程序，它可以运行在电脑、手机或者其他设备上，智能体是指这段程序所建立的结构和运行规则，而不是具体的某台设备。\r\n\r\n将智能体和物理实体划分开来，可以让我们关注智能的本质。\r\n\r\n## 智能潜力\r\n\r\n就像马力衡量引擎一样，我们用智能潜力来衡量一个智能体所具备的自身潜能。\r\n\r\n智能潜力不是智能体所表现出来的智能水平，而是指这个智能体结构及其规则可以实现多高的智能。\r\n\r\n智能潜力是衡量智能体基因优劣的指标。\r\n\r\n一个人的智能水平受到多方面影响，包括先天生理因素和后天学习与训练。对于人的智能表现水平，人们可能更倾向于和遗传基因无关，然而对比猿类或者其他动物物种之后，我们就不得不承认人类大脑的基本生理结构对人类智能的决定性作用。\r\n\r\n我们可以说人类DNA基因决定了人类大脑的结构和运作机制，进一步决定了人类智能潜力的高低。\r\n\r\n## 智能广度\r\n\r\n智能体很多时候都是在某些方面表现优异，而在另一些方面表现就差强人意。人类学生读书的偏科现象就是最典型情况，有的人擅长运动，有人擅长音乐，有人擅长文学，有人擅长绘画。\r\n\r\n这在人工智能中表现的更加突出，目前绝大部分的人工智能体都是专用专有的，某些程序只能做图像识别，甚至只能做人脸识别，猫脸都不识别不了。\r\n\r\n在机器学习或深度学习领域，很多学者认为这归因于AI程序缺乏迁移能力。在这里我认为这更多的是本质结构和运作规律的区别，而不是其他原因。\r\n\r\n所以我在这里引入智能广度这个概念。\r\n\r\n## 运算单元\r\n\r\n智能体由一个或多个运算单元构成，正如大脑由众多神经元构成一样。智能体和运算单元都是抽象概念，并非物理实体。\r\n\r\n每个运算单元都接收前面单元的一个或多个输入，并产生一个或多个输出发送到后面单元。以此形成网状连接。\r\n\r\n但这个网状连接是可以任意形式的，可以有前后（或说上下）的层级关系，也可以完全随机的连接，也可以是两者的结合，即在局部形成层级或随机连接。\r\n\r\n## 运算单元的数量\r\n\r\n毫无疑问，运算单元的数量与整体的智能潜力直接相关。但这个相关并非线性的，对最初少量运算单元组成的整体，运输单元数量对整体智能潜力有着明显的影响，但是在达到一定数量之后这种影响就会快速下降，就像小鼠的智能水平远超昆虫细菌，但是大象和小鼠来比较又没有太大优势。\r\n\r\n> 人类的智能潜力远超小鼠和大象，但这并不是运算单元数量上优势产生的结果。\r\n\r\n## 运算速度\r\n\r\n运算单元的运算速度无疑和智能潜力是正相关的。而且这种相关性似乎看不到极限情况中的下降或衰减。\r\n\r\n速度越快，智能潜力越大。\r\n\r\n但是这里的速度并不是所有运算单元计算速度的简单平均，还必要考虑它们的分布情况。所有单元的运算速度完全相同并不是最高效的情况，恰恰相反，这是最低效的糟糕情况之一。最好的情况是所有运算单元的运算速度在一定的基数上呈高斯分布。\r\n\r\n例如，A智能体所有单元的运算速度都小于10毫秒，很少数情况下运算会较慢，接近10毫秒；同样接近0秒的高速运算情况也很少；绝大数情况下运算速度是5毫秒。B智能体所有单元的运算情况都是均等的5毫秒，那么可知A智能体的智能潜力一定大于B智能体。\r\n\r\n## 连接数量\r\n\r\n运算单元之间的连接数量是影响智能潜力的另一个重要因素。\r\n\r\n连接数量在大多数情况下与智能潜力成正比，但是当连接数量过多以至于明显拖慢整体运算速度的时候，就将产生负作用。\r\n\r\n同样连接数量也应该具有良好的分布曲线，所有神经元都具有相同的连接数量往往是低效的表现。\r\n\r\n## 分化程度\r\n\r\n运算方法、运算速度、连接数量都是智能体的深层结构，而由于这些因素的不均等分布，必将导致运算单元分化为不同的类型，或者结合成不同的区块，进而实现不同的功用，这里我们称之为分化程度。\r\n\r\n分化程度对整体智能潜力无疑产生至关重要的影响，但也是最难分析和量化的一个因素，在后续文章中我们继续讨论和思考。\r\n\r\n## 解读效率\r\n\r\n智能体是一个处于动态变化中的运算网络。而其最后输出的结果需要另外一个机制进行提取和判断，我们把它称之为解读器。这就像照相机一样，它不断地对运算网络进行快照，并阐述快照的含义。\r\n\r\n对用于手写图像数字识别的计算机神经网络算法而言，这个解读器就是将每次输出的10个0到1权重数字解读成为一个最终的数字。这个过程其实很简单，但这也是最简单的情况。\r\n\r\n运算中的智能体是一个世界副本，拍照效率对其职能潜力似乎并不产生影响。但这是没有把解读器作为智能体内部机制来考虑的。所以，解读器的效率也是智能体智能潜力的一个重要指标，它是智能潜力的瓶口。\r\n\r\n', 55, 2);
INSERT INTO `blog` VALUES (26, 2018211261, 'Numpy数据存取与函数', '为学日益', '2019-07-30 16:56:26', 'Numpy数据存取与函数\r\n文章目录\r\n数据的CSV文件存取\r\n什么是CSV文件\r\n写入\r\n读入\r\n多维数据的存取\r\ntofile\r\nfromfile\r\nNumpy的随机函数\r\nrandom子库\r\nrandom函数\r\nNumpy的统计函数\r\nNumpy的梯度函数\r\nNumpy中的梯度函数\r\n计算一维数组的梯度值\r\n二维数组梯度值的计算\r\n数据的CSV文件存取\r\n什么是CSV文件\r\nCSV（Comma-Separated Value）逗号分隔值\r\nCSV是一种常见的文件格式，用来存储批量数据\r\nCSV文件只能有效存储一维与二维数组\r\n写入\r\nnp.savetxt(frame, array, fmt=’%.18e’, demliniter=None)\r\n\r\nframe：文件、字符串、或产生器，可以使 .gz 或 .bz2 的压缩文件\r\narray：存入文件的数组\r\nfmt：写入文件的格式\r\ndelimiter：分割字符串的分隔符，默认为空格\r\nIn [1]：a = np.arange(0,100).reshape(20,5)\r\nIn [2]：np.savetxt(\"a.csv\",a,fmt=\"%0.2f\",delimiter=\",\")\r\n保存后的文件a.csv：\r\n\r\n0.00,1.00,2.00,3.00,4.00\r\n5.00,6.00,7.00,8.00,9.00\r\n10.00,11.00,12.00,13.00,14.00\r\n15.00,16.00,17.00,18.00,19.00\r\n20.00,21.00,22.00,23.00,24.00\r\n25.00,26.00,27.00,28.00,29.00\r\n30.00,31.00,32.00,33.00,34.00\r\n35.00,36.00,37.00,38.00,39.00\r\n40.00,41.00,42.00,43.00,44.00\r\n45.00,46.00,47.00,48.00,49.00\r\n50.00,51.00,52.00,53.00,54.00\r\n55.00,56.00,57.00,58.00,59.00\r\n60.00,61.00,62.00,63.00,64.00\r\n65.00,66.00,67.00,68.00,69.00\r\n70.00,71.00,72.00,73.00,74.00\r\n75.00,76.00,77.00,78.00,79.00\r\n80.00,81.00,82.00,83.00,84.00\r\n85.00,86.00,87.00,88.00,89.00\r\n90.00,91.00,92.00,93.00,94.00\r\n95.00,96.00,97.00,98.00,99.00\r\n读入\r\nnp.loadtxt(frame, dtype=np.float64, delimiter=None, unpack=False)\r\n\r\nframe：文件、字符串、或产生器，可以使 .gz 或 .bz2 的压缩文件\r\ndtype：数据类型，可选\r\ndelimiter：分割字符串的分隔符，默认为空格\r\nunpack：如果为True，读入属性将分别写入不同的变量\r\n//将之前写入的a.csv文件读入\r\nIn [3]：b = np.loadtxt(\"a.csv\",dtype=np.float64,delimiter=\",\")\r\n\r\nIn [4]：b\r\nOut[4]: \r\narray([[ 0.,  1.,  2.,  3.,  4.],\r\n       [ 5.,  6.,  7.,  8.,  9.],\r\n       [10., 11., 12., 13., 14.],\r\n       [15., 16., 17., 18., 19.],\r\n       [20., 21., 22., 23., 24.],\r\n       [25., 26., 27., 28., 29.],\r\n       [30., 31., 32., 33., 34.],\r\n       [35., 36., 37., 38., 39.],\r\n       [40., 41., 42., 43., 44.],\r\n       [45., 46., 47., 48., 49.],\r\n       [50., 51., 52., 53., 54.],\r\n       [55., 56., 57., 58., 59.],\r\n       [60., 61., 62., 63., 64.],\r\n       [65., 66., 67., 68., 69.],\r\n       [70., 71., 72., 73., 74.],\r\n       [75., 76., 77., 78., 79.],\r\n       [80., 81., 82., 83., 84.],\r\n       [85., 86., 87., 88., 89.],\r\n       [90., 91., 92., 93., 94.],\r\n       [95., 96., 97., 98., 99.]])\r\n\r\n多维数据的存取\r\ntofile\r\na.tofile( frame, sep=’’, format=’%s’)\r\n\r\nframe:文件名\r\n\r\nsep:数据分割字符串，如果是空格，写入文件为二进制\r\n\r\nformat:写入数据的格式\r\n\r\nIn [1]：import numpy as np\r\n\r\n#生成一个形状为（2,3,4）的数组\r\nIn [2]：a = np.arange(0,24).reshape(2,3,4)\r\n\r\nIn [3]：a\r\nOut[3]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n\r\n#通过tofile方法将数组a保存为a.bat文件\r\nIn [4]：a.tofile(\'a.bat\',sep=\',\',format=\'%1.1f\')\r\n上面代码将数组a保存为a.bat文件，结果如下：\r\n\r\n0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0,21.0,22.0,23.0\r\n注：不难发现使用tofile方法，将多维数据保存为了一维数据，丢失了数组的维度信息\r\n\r\nfromfile\r\nnp.fromfile( frame, dtype=np.float64, count= -1, sep=’’)\r\n\r\nframe:文件名\r\n\r\ndtype:存储为数组的数据类型\r\n\r\nsep:数据分割字符串，如果是空格，写入文件为二进制\r\n\r\ncount:读取数据个数，‘-1’表示全部\r\n\r\n#从a.bat文件中读取数据，返回一维数组b\r\nIn [7]：b = np.fromfile(\'a.bat\', dtype=np.float64, count=-1, sep=\',\')\r\n\r\nIn [8]：b\r\nOut[8]: \r\narray([ 0.,  1.,  2.,  3.,  4.,  5.,  6.,  7.,  8.,  9., 10., 11., 12.,\r\n       13., 14., 15., 16., 17., 18., 19., 20., 21., 22., 23.])\r\n\r\n#通过reshape方法还原为数组a\r\nIn [9]：b.reshape(2,3,4)\r\nOut[9]: \r\narray([[[ 0.,  1.,  2.,  3.],\r\n        [ 4.,  5.,  6.,  7.],\r\n        [ 8.,  9., 10., 11.]],\r\n\r\n       [[12., 13., 14., 15.],\r\n        [16., 17., 18., 19.],\r\n        [20., 21., 22., 23.]]])\r\n\r\n使用该方法读取时需要知道存入文件是数组的维度和元素类型\r\n\r\n通常 .tofile()和np.fromfile()需要配合使用\r\n\r\n可通过元数据文件来存储额外信息的方法解决存入文件时部分信息丢失的问题\r\n\r\nNumpy的便捷文件存取\r\n\r\nnp.save(frame, array) 或 np.savez(frame, array)\r\n\r\nsavez()表示为存储成压缩文件\r\n\r\nframe：文件名，以 .npy为扩展名， 压缩扩展名为 .npz\r\n\r\narray：数组变量\r\n\r\nIn [10]：np.save(\'a.npy\',a)\r\na.npy文件的头部信息\r\n\r\n{\'descr\': \'<i4\', \'fortran_order\': False, \'shape\': (2, 3, 4), }\r\nsave方法将数组保存为带有数组元信息的文件，所以不会丢失信息\r\n\r\nnp.load(frame)\r\n\r\n读取文件中保存的数组信息，与np.save配合使用\r\n\r\nIn [10]：b = np.load(\'a.npy\')\r\n\r\nIn [10]：b\r\nOut[12]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n\r\n通过以上代码再一次说明了np.save()方法不会丢失数组信息\r\n\r\nNumpy的随机函数\r\nrandom子库\r\nrandom子库的导入\r\n\r\nimport numpy.random.*\r\nrandom函数\r\n函数	说明\r\nrand(d0, d1, ··· , dn)	根据d0-d1创建随机函数数组，浮点数，[0,1),分布均匀\r\nrandn(d0, d1, ··· , dn)	根据d0-d1创建随机函数数组，标准正态分布\r\nrandint(low[,high,shape])	根据shape创建随机整数或浮点数数组，范围是[low,high)\r\nseed(s)	随机种子\r\nshuffle(a)	根据数组a的第一轴（最外轴）进行随机排列，改变数组a\r\npermutation(a)	根据数组a的第一轴（最外轴）产生一个新的乱序数组，作用于shuffle相同，但不改变数组a\r\nchoice(a[,size,repalce,p])	从一维数组a中以概率p抽取元素，形成size形状的新数组\r\nuniform(low,high,size)	产生具有分布均匀的数组\r\nnormal(loc,scale,size)	产生具有正态分布的数组，loc为均值，scale为标准差\r\npoisson(lam,size)	产生均有泊松分布的数组，lam随机事件发生率\r\n对random子库中的函数进行测试：\r\n\r\nIn [1]: import numpy as np\r\n\r\n#根据（2,3,4）创建随机数组，其值在[0,1)中，分布均匀\r\nIn [6]: a = np.random.rand(2,3,4)\r\nIn [7]: a\r\nOut[7]: \r\narray([[[0.84540801, 0.64559993, 0.41654873, 0.24768038],\r\n        [0.16777791, 0.61298643, 0.51036569, 0.54994355],\r\n        [0.92492084, 0.3732955 , 0.16278449, 0.40695526]],\r\n\r\n       [[0.5083265 , 0.24169989, 0.21318507, 0.71978147],\r\n        [0.86114801, 0.68021546, 0.11903414, 0.2655616 ],\r\n        [0.12417876, 0.3344801 , 0.50973188, 0.64684601]]])\r\n\r\n#作用于rand相似，但其创建的数组符合正态分布\r\nIn [8]: a = np.random.randn(2,3,4)\r\nIn [9]: a\r\nOut[9]: \r\narray([[[ 0.65312152, -0.2914076 , -0.51309828,  0.31448023],\r\n        [-0.38883461,  0.47311716, -1.76270235,  0.49765299],\r\n        [-0.09067566,  0.30675027,  1.04241505, -2.19737617]],\r\n\r\n       [[ 1.13004816,  0.34356503, -0.72446734, -0.00267191],\r\n        [ 0.35305905, -0.57468234,  1.46999405, -1.24446079],\r\n        [ 0.15446604,  0.47257601,  0.90387111,  0.29725092]]])\r\n\r\n#根据shape创建随机整数或浮点数数组，范围是[low,high)\r\nIn [10]: a = np.random.randint(10,100,(2,3,4))\r\nIn [11]: a\r\nOut[11]: \r\narray([[[76, 24, 58, 93],\r\n        [96, 35, 36, 43],\r\n        [10, 25, 34, 31]],\r\n\r\n       [[71, 89, 59, 73],\r\n        [63, 55, 32, 43],\r\n        [49, 72, 43, 82]]])\r\n\r\n对比shuffle与permutation的区别：\r\n\r\n#创建数组a,便于观察random.shuffle函数，是否改变原数组\r\nIn [12]: a = np.arange(0,24).reshape(2,3,4)				#生成shape为（2,3,4）的数组\r\nIn [13]: a\r\nOut[13]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n#使用random.shuffle函数，可发现数组a发生了改变\r\nIn [14]: np.random.shuffle(a)\r\nIn [15]: a\r\nOut[15]: \r\narray([[[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]],\r\n\r\n       [[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]]]\r\n\r\n#同样创建数组a\r\nIn [17]: a = np.arange(0,24).reshape(2,3,4)\r\nIn [18]: a\r\nOut[18]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n#调用permutation函数，得到数组b\r\nIn [19]: b = np.random.permutation(a)\r\n\r\nIn [20]: b\r\nIn [20]: \r\narray([[[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]],\r\n\r\n       [[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]]])\r\n#通过前后对比发现，permutation函数对最外的维度进行随机排列，但不改变原来数组a\r\nIn [21]: a\r\nOut[21]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\nNumpy的统计函数\r\n函数	说明\r\nsum(a, axis=None)	根据给定轴axis计算数组a相关元素之和，axis为整数或者元组\r\nmean(a, axis=None)	根据给定轴axis计算数组a相关元素的期望，axis为整数或者元组\r\naverage(a, axis=None, weight=None)	根据给定轴axis计算数组a相关元素的加权平均数\r\nstd(a, axis=None)	根据给定轴axis计算数组a相关元素的标准差\r\nvar(a, axis=None)	根据给定轴axis计算数组a相关元素的方差\r\nmin(a)	计算数组a中的最小值\r\nmax(a)	计算数组a中的最大值\r\nargmin(a)	计算数组a中的最小值的降一维下标\r\nargmax(a)	计算数组a中的最大值的降一维下标\r\nunravel_index(index, shape)	根据shape降一维下标新index转换成多维下标\r\nptp(a)	计算数组a中元素最大值与最小值的差\r\nmedian(a)	计算数组a中元素的中位数，为浮点类型\r\n测试Numpy的统计函数：\r\n\r\nIn [35]：import numpy as np\r\n\r\nIn [36]：a = np.arange(0,24).reshape(2,3,4)\r\n#sum函数仅仅将数组a中所有元素相加\r\nIn [37]：np.sum(a)\r\nOut[37]: 276\r\n\r\n#给定在0维度上相加\r\nIn [38]：np.sum(a,axis=0)\r\nOut[38]: \r\narray([[12, 14, 16, 18],\r\n       [20, 22, 24, 26],\r\n       [28, 30, 32, 34]])\r\n#在第2维度上相加\r\nIn [39]：np.sum(a,axis=2)\r\nOut[39]: \r\narray([[ 6, 22, 38],\r\n       [54, 70, 86]])\r\n#计算期望\r\nIn [40]：np.mean(a)\r\nOut[40]: 11.5\r\n#计算加权平均数\r\nIn [41]：np.average(a)\r\nOut[41]: 11.5\r\n#随机生成一个形状为（2,3,4）的权重数组\r\nIn [42]：p = np.random.rand(2,3,4)\r\nIn [43]：p\r\nOut[43]: \r\narray([[[0.65696812, 0.8138606 , 0.39989611, 0.37383667],\r\n        [0.8543696 , 0.39942311, 0.47069648, 0.69283641],\r\n        [0.92581672, 0.95013379, 0.94120393, 0.77962655]],\r\n\r\n       [[0.59640761, 0.57884295, 0.72814852, 0.79480906],\r\n        [0.84310508, 0.00335858, 0.52832612, 0.77628422],\r\n        [0.71638493, 0.4282441 , 0.4032651 , 0.15317423]]])\r\n#为数组a添加权重，重新计算其加权平均数\r\nIn [44]：np.average(a,weight=p)\r\nOut[44]: 10.810252907478565\r\n\r\n#计算方差\r\nIn [51]：np.var(a)\r\nOut[51]: 47.916666666666664\r\n#计算最大最小值之差\r\nIn [52]：np.ptp(a)\r\nOut[52]: 23\r\n#计算中位数\r\nIn [53]：np.median(a)\r\nOut[53]: 11.5\r\nargmin()、argmin()与unravel_index()的配合使用\r\n\r\nargmin()与argmax()方法将多维数组降成一维数组后，找出其最大最小值\r\n\r\nIn [55]：np.argmax(a)\r\nOut[55]: 23\r\n通过argmin()与argmax()方法返回的下标为一个数，但我们往往需要得到其在多维数组中的下标或者索引，可通过unravel_index()方法将一维索引得到shape形状的索引\r\n\r\nIn [56]：a\r\nOut[56]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n#利用argmax获得数组a的最大值的一维下标，在通过unravel_index获得数组a最大值的多维下标\r\nIn [57]：np.unravel_index(np.argmax(a), shape=(2,3,4))\r\nOut[57]: (1, 2, 3)\r\nNumpy的梯度函数\r\n梯度的本意是一个向量（矢量），表示某一函数在该点处的方向导数沿着该方向取得最大值，即函数在该点处沿着该方向（此梯度的方向）变化最快，变化率最大（为该梯度的模）\r\n\r\nNumpy中的梯度函数\r\nnp.gradient( f )\r\n\r\n计算数组f中元素的梯度，当f为多维时，返回每个维度上的梯度\r\n\r\n计算一维数组的梯度值\r\n如果一个元素左右两侧都有元素\r\n\r\n​	（后一个元素 - 前一个元素）/ 2\r\n\r\n如果该元素为最后一个元素\r\n\r\n​	（当前元素 - 前一个元素)）/ 1\r\n\r\n如果该元素为第一个元素\r\n\r\n​	（后一个元素 - 当前元素）/ 1\r\n\r\nIn [1]：import numpy as np\r\n\r\nIn [2]：a = np.random.randint(0,20,(5))\r\n#生成随机数组a\r\nIn [3]：a\r\nOut[3]: array([11,  7, 19, 10,  1])\r\n#计算数组a的梯度\r\n\'\'\'\r\n梯度数组的第一个值为（7-11）/ 1 = -4得到\r\n第二个值的左右两侧都存在元素，所以其值为：（19-11）/ 2 = 4\r\n最后一个值：（1-10）/ 1 = -9\r\n\'\'\'\r\nIn [4]：np.gradient(a)\r\nOut[4]: array([-4. ,  4. ,  1.5, -9. , -9. ])\r\n\r\nIn [5]：b = np.random.randint(0,20,(5))\r\n\r\nIn [6]：b\r\nOut[6]: array([ 2,  6,  2, 14,  7])\r\n#数组b的梯度也是如此计算\r\nIn [7]：np.gradient(b)\r\nOut[7]: array([ 4. ,  0. ,  4. ,  2.5, -7. ])\r\n二维数组梯度值的计算\r\n​	生成二维梯度，即存在两组梯度，依次对应最外层梯度与第二层梯度\r\n\r\n#生成二维数组c\r\nIn [7]：c = np.random.randint(0,50,(3,5))\r\n\r\nIn [7]：c\r\nOut[9]: \r\narray([[23, 12, 45, 33, 26],\r\n       [39, 10, 18, 23,  9],\r\n       [11,  5, 24, 28, 47]])\r\n\'\'\'\r\n计算二维数组c的梯度，其结果返回2个数组组成的列表\r\n第一个数组为最外层维度的梯度\r\n第二个数组对应第二维度的梯度\r\n\'\'\'\r\nIn [7]：np.gradient(c)\r\nOut[10]: \r\n[array([[ 16. ,  -2. , -27. , -10. , -17. ],\r\n        [ -6. ,  -3.5, -10.5,  -2.5,  10.5],\r\n        [-28. ,  -5. ,   6. ,   5. ,  38. ]]),\r\n array([[-11. ,  11. ,  10.5,  -9.5,  -7. ],\r\n        [-29. , -10.5,   6.5,  -4.5, -14. ],\r\n        [ -6. ,   6.5,  11.5,  11.5,  19. ]])]\r\n附：给一个Numpy中文手册的连接', 24, 0);
INSERT INTO `blog` VALUES (27, 2018211261, 'Numpy入门', '为学日益', '2019-07-30 16:59:05', '文章目录\r\nNumpy入门\r\n数据维度：\r\n一维数据\r\n二维数据\r\n多维数据\r\n高维数据：\r\nNumpy的数组对象：ndarray\r\nndarray的优势：\r\nndarray属性：\r\nndarray数组的创建和变换\r\nndarray数组的创建方法：\r\nndarray数组的变换：\r\n对数组的操作\r\n一维数组的索引与切片:\r\n多维数组的索引与切片：\r\nndarray数组运算\r\n数组与标量之间的运算\r\nNumpy一元函数\r\nNumpy二元函数\r\nNumpy入门\r\n数据维度：\r\n一组数据的组织形式\r\n\r\n一维数据\r\n对等关系\r\n\r\n有序或无序\r\n\r\n线性的方式组织\r\n\r\n对应列表、数组、集合等概念（在Python基础数据类型中没有数组类型，在Numpy库中，定义了数组ndarray类）\r\n\r\n列表与数组的异同：\r\n\r\n​	同：都表示为一维数组的有序结构\r\n\r\n​	异：列表中可以有不同数据类型的数据\r\n\r\n​	数组中的数据类型必须相同（ndarray类中定义的数组可以存取不同数据类型的数据，但一般情况下数据类型相同）\r\n\r\n二维数据\r\n由多个一维数据构成\r\n一维数据的组合形式\r\n表格为典型的二维数据结构\r\n\r\n二维数据可用列表表示\r\n\r\n多维数据\r\n由一维或二维数据在新维度上扩展形成\r\n比如，在一张数据表上增加时间维度\r\n\r\n同样可用列表的套嵌表示\r\n\r\n高维数据：\r\n仅利用最基本的二元关系（字典）展示数据间的复杂结构\r\n可用键值树表示\r\nNumpy的数组对象：ndarray\r\nndarray的优势：\r\n数组对象可以去掉元素间运算所需要的循环，使一维向量更像单个数据\r\n设置专门的数组对象，经过优化可以提升这类应用的运算速度（底层由C语言实现）\r\n数组对象采用相同的数据类型，有助于节省运算和存储空间\r\nndarray是一个多维数组对象，由两部分构成:\r\n\r\n实际的数据\r\n描述这些数据的元数据（数据维度、数据类型等）\r\nndarray数组一般要求所有元素类型相同（同质），数组下标从0开始（这与列表类型相同）\r\n\r\n一般通过\r\n\r\nimport numpy as np\r\n引入Numpy库，并简称为np\r\n\r\n可通过np.array()生成ndarray数组\r\n\r\nprint(np.array([1,2,3,4,5]))\r\n[1 2 3 4 5]\r\nnp.array（）输出成 [ ] 形式，元素有空格分隔\r\n\r\n在ndarray数组中有两个概念：\r\n\r\n轴（axis）：保存数据的维度\r\n秩（rank）：轴的数量\r\nndarray属性：\r\n属性	描述\r\nndim	秩，及轴的数量或维度数量\r\nshape	对象的尺度，对于矩阵即n行m列,返回元组\r\nsize	对象元素的个数，相当于n*m\r\ndtype	对象的元素类型\r\nitemsize	对象中每个元素的大小，以字节表示\r\nIn [21]: a= np.array([[1,2,3,4,5],[6,7,8,9,10]])\r\n\r\nIn [22]: a.ndim\r\nOut[22]: 2\r\n\r\nIn [23]: a.shape\r\nOut[23]: (2, 5)\r\n\r\nIn [24]: a.size\r\nOut[24]: 10\r\n\r\nIn [25]: a.dtype\r\nOut[25]: dtype(\'int32\')\r\n\r\nIn [26]: a.itemsize\r\nOut[26]: 4\r\n注：Numpy中存在有其自己定义的数据类型，大致与Python中的数据类型相同\r\n\r\nndarray数组的创建和变换\r\nndarray数组的创建方法：\r\n从Python中列表、元组等类型创建ndarray数组\r\n\r\nnp.array( list/tuple , dtype = np.float32 )\r\n\r\nIn [27]：a = np.array([[0,1,2,3,4,],[5,6,7,8,9]],dtype=np.float32)\r\n\r\nIn [28]：a\r\nOut[28]: \r\narray([[0., 1., 2., 3., 4.],\r\n       [5., 6., 7., 8., 9.]], dtype=float32)\r\n\r\n使用Numpy中的函数创建ndarray数组\r\n\r\n方法	描述\r\nnp.arange(n)	类似range（）函数，返回ndarray数组，[0,n)\r\nnp.ones(shape)	根据shape生成一个全1数组，shape为元组\r\nnp.zeros(shape)	根据shape生成一个全0数组，shape为元组\r\nnp.full(shape,val)	根据shape生成一个全为val的数组，shape为元组\r\nnp.eye(n)	创建一个正方向n*n的单位矩阵\r\nnp.ones_like(a)	根据数组a生成一个全1数组，shape为元组\r\nnp.zeros_like(a)	根据数组a生成一个全0数组，shape为元组\r\nnp.full_like(a,val)	根据数组a生成一个全为val的数组，shape为元组\r\nnp.linspace()	根据起止数据，等间距填充数据\r\nnp.concatenate()	将两个或多个数组合并成一个新数组\r\n从字节流（raw bytes）中创建ndarray数组\r\n\r\n从文件中读取特定格式，创建ndarray\r\n\r\nndarray数组的变换：\r\n对于创建后的ndarray数组，可对其进行维度变换和元素类型变换\r\n\r\n方法	描述\r\n.reshape(shape)	不改变数组元素，返回一个shape形状的数组，原数组不变\r\n.resize(shape)	与np.reshape（）功能一致，但修改原数组\r\n.swapaxes(ax1,ax2)	将数组n个维度中的两个维度进行调换\r\n.flatten()	对数据进行降维，返回折叠后的一维数组\r\n.astype(new_type)	改变数据类型\r\n.tolist()	转换为列表\r\n对数组的操作\r\n一维数组的索引与切片:\r\n索引：\r\n​	与Python列表类似\r\n\r\n//使用np.arange()创建数组\r\nIn [9]：a = np.arange(0,23,2)\r\n\r\nIn [10]：a\r\nOut[10]: array([ 0,  2,  4,  6,  8, 10, 12, 14, 16, 18, 20, 22])\r\n    \r\n//对数组a进行索引，从0开始\r\nIn [11]：a[0]\r\nOut[11]: 0\r\n//同样存在负数的索引\r\nIn [12]：a[-1]\r\nOut[12]: 22\r\n切片：\r\n\r\n同样与Python列表类似\r\n\r\nIn [13]：a[0:10:2]\r\nOut[13]: array([ 0,  4,  8, 12, 16])\r\n\r\nIn [14]：a[::-1]\r\nOut[14]: array([22, 20, 18, 16, 14, 12, 10,  8,  6,  4,  2,  0])\r\n多维数组的索引与切片：\r\n索引\r\n\r\n根据维度从里到外索引\r\n\r\n每个维度用“，”风隔\r\n\r\n同样从0开始\r\n\r\n//创建形状（2,3,4）的3维数组\r\nIn [2]：a = np.arange(0,24).reshape(2,3,4)\r\nIn [3]：a\r\nOut[3]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n\r\nIn [4]：a[0,2,2]						//索引\r\nOut[4]: 10							//根据索引返回值\r\n\r\n切片\r\n\r\n每个维度切片用“，”风隔\r\n\r\n可对每个维度单独切片\r\n\r\n选去整个维度可用“：”，这与Python列表选取整个列表相同\r\n\r\n每个维度可用步长跳跃切片\r\n\r\n//创建形状（2,3,4）的3维数组\r\nIn [2]：a = np.arange(0,24).reshape(2,3,4)		\r\nIn [3]：a\r\nOut[3]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n//对每个维度切片\r\nIn [5]：a[:,1:2,:1]\r\nOut[5]: \r\narray([[[ 4]],\r\n\r\n       [[16]]])\r\n\r\n//使用“：”选取整个维度，不对其切片\r\nIn [6]：a[:,:,0:3]\r\nOut[6]: \r\narray([[[ 0,  1,  2],\r\n        [ 4,  5,  6],\r\n        [ 8,  9, 10]],\r\n\r\n       [[12, 13, 14],\r\n        [16, 17, 18],\r\n        [20, 21, 22]]])\r\n\r\n//使用步长跳跃切片\r\nIn [7]：a[:,0::2,0::2]\r\nOut[7]: \r\narray([[[ 0,  2],\r\n        [ 8, 10]],\r\n\r\n       [[12, 14],\r\n        [20, 22]]])\r\nPS：对多维数组的切片有点绕，不过仔细想想就明白了\r\n\r\nndarray数组运算\r\n数组与标量之间的运算\r\n数组与标量之间的运算作用于数组的每个元素\r\n.mean（）计算数组平均值（即数组中每个元素之和 / 元素个数）\r\n//创建形状（2,3,4）的3维数组\r\nIn [16]：a = np.arange(0,24).reshape(2,3,4)\r\nIn [17]：a\r\nOut[17]: \r\narray([[[ 0,  1,  2,  3],\r\n        [ 4,  5,  6,  7],\r\n        [ 8,  9, 10, 11]],\r\n\r\n       [[12, 13, 14, 15],\r\n        [16, 17, 18, 19],\r\n        [20, 21, 22, 23]]])\r\n\r\n//计算平均值\r\nIn [18]：a.mean()\r\nOut[18]: 11.5\r\n    \r\n//每个元素都乘以4   \r\nIn [19]：a*4\r\nOut[19]: \r\narray([[[ 0,  4,  8, 12],\r\n        [16, 20, 24, 28],\r\n        [32, 36, 40, 44]],\r\n\r\n       [[48, 52, 56, 60],\r\n        [64, 68, 72, 76],\r\n        [80, 84, 88, 92]]])\r\nNumpy一元函数\r\n对ndarray中的数据执行元素级运算的函数，即对每个元素都进行运算，返回结果\r\n函数	说明\r\nnp.abs(x)	计算数组各元素的绝对值\r\nnp.fabs(x)	计算数组各元素的绝对值\r\nnp.square(x)	计算数组各元素的平方值\r\nnp.log(x)	计算数组各元素的自然对数\r\nnp.log10(x)	计算数组各元素的以10为底的对数\r\nnp.log2(x)	计算数组各元素的以2为底的对数\r\nnp.ceil(x)	计算数组各元素的大于其元素的最小整数值\r\nnp.floor(x)	计算数组各元素的小于其元素的最大整数值\r\nnp.rint(x)	将数组各元素四舍五入\r\nnp.modf(x)	将各元素的小数和整数部分已两个独立数组返回\r\nnp.cos(x)	计算数组各元素的cos值\r\nnp.sin(x)	计算数组各元素的sin值\r\nnp.tan(x)	计算数组各元素的tan值\r\nnp.cosh(x)	计算数组各元素的双曲型三角函数cosh值\r\nnp.sinh(x)	计算数组各元素的双曲型三角函数sinh值\r\nnp.tanh(x)	计算数组各元素的双曲型三角函数tanh值\r\nnp.exp(x)	计算数组各元素的指数值\r\nnp.sign(x)	计算数组各元素的符号值，正为1，其他为0\r\nnp.sqrt(x)	平方根\r\nNumpy二元函数\r\n函数	说明\r\n+ - * / **	两个数组各元素进行对应运算\r\nnp.maximum(x,y)	元素级的最大值计算\r\nnp.fmax(x,y)	元素级的最大值计算\r\nnp.minimum(x,y)	元素级的最小值计算\r\nnp.fmin(x,y)	元素级的最小值计算\r\nnp.mod(x,y)	元素级的模运算\r\nnp.copysign(x,y)	将数组y中各元素值得符号赋值给数组x对应元素\r\n> < >= <= == !=	算数比较，产生布尔型数组\r\n注：不管对数组进行一元二元还是与标量之间的计算，只要返回的结果是数值型，返回数组的数据类型都为float64\r\n\r\n如：\r\n\r\nIn [25]：a = np.arange(0,24).reshape(2,3,4)\r\n\r\n//a的数据类型为‘int32’\r\nIn [26]：a.dtype\r\nOut[26]: dtype(\'int32\')\r\n\r\n//对数组a进行开平方操作，得到数组b\r\nIn [27]：b = np.sqrt(a)\r\n\r\nIn [28]：b\r\nOut[28]: \r\narray([[[0.        , 1.        , 1.41421356, 1.73205081],\r\n        [2.        , 2.23606798, 2.44948974, 2.64575131],\r\n        [2.82842712, 3.        , 3.16227766, 3.31662479]],\r\n\r\n       [[3.46410162, 3.60555128, 3.74165739, 3.87298335],\r\n        [4.        , 4.12310563, 4.24264069, 4.35889894],\r\n        [4.47213595, 4.58257569, 4.69041576, 4.79583152]]])\r\n\r\n//对数组a与数组b比较其大小\r\nIn [29]：c = np.fmax(a,b)\r\n\r\nIn [30]：c\r\nOut[30]: \r\narray([[[ 0.,  1.,  2.,  3.],\r\n        [ 4.,  5.,  6.,  7.],\r\n        [ 8.,  9., 10., 11.]],\r\n\r\n       [[12., 13., 14., 15.],\r\n        [16., 17., 18., 19.],\r\n        [20., 21., 22., 23.]]])\r\n\r\n//得到的结果的数据类型不是数组a的‘int32’,而是‘float64’\r\nIn [31]：c.dtype\r\nOut[31]: dtype(\'float64\')\r\n给一个Numpy中文手册的连接', 45, 0);

-- ----------------------------
-- Table structure for blog_classification
-- ----------------------------
DROP TABLE IF EXISTS `blog_classification`;
CREATE TABLE `blog_classification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(255) NOT NULL,
  `bid` int(11) NOT NULL,
  `classification` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_classification
-- ----------------------------
INSERT INTO `blog_classification` VALUES (45, 2027202434, 23, '言论');
INSERT INTO `blog_classification` VALUES (46, 2027202434, 23, '见解');
INSERT INTO `blog_classification` VALUES (47, 2027202434, 24, '嘲讽');
INSERT INTO `blog_classification` VALUES (48, 2023232323, 25, '人工智能');
INSERT INTO `blog_classification` VALUES (49, 2023232323, 25, '言论');
INSERT INTO `blog_classification` VALUES (50, 2023232323, 25, '科普');
INSERT INTO `blog_classification` VALUES (51, 2018211261, 26, 'Numpy');
INSERT INTO `blog_classification` VALUES (52, 2018211261, 26, '数据科学');
INSERT INTO `blog_classification` VALUES (53, 2018211261, 26, '人工智能');
INSERT INTO `blog_classification` VALUES (54, 2018211261, 26, 'Python');
INSERT INTO `blog_classification` VALUES (55, 2018211261, 27, 'Python');
INSERT INTO `blog_classification` VALUES (56, 2018211261, 27, '人工智能');
INSERT INTO `blog_classification` VALUES (57, 2018211261, 27, '数据科学');
INSERT INTO `blog_classification` VALUES (58, 2018211261, 27, 'Numpy');
INSERT INTO `blog_classification` VALUES (59, 2018211261, 28, 'JAVA');
INSERT INTO `blog_classification` VALUES (60, 2018211261, 28, 'IO');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (6, 2018211261, 23);
INSERT INTO `collection` VALUES (7, 2018211261, 24);
INSERT INTO `collection` VALUES (8, 2018211261, 25);
INSERT INTO `collection` VALUES (9, 2018211249, 25);
INSERT INTO `collection` VALUES (10, 2018211259, 24);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (15, 2018211261, 23, '嘻嘻', '2019-07-30 17:04:11');
INSERT INTO `review` VALUES (16, 2018211261, 24, '哈哈哈', '2019-07-30 17:04:16');
INSERT INTO `review` VALUES (17, 2018211261, 25, '厉害', '2019-07-30 17:04:50');
INSERT INTO `review` VALUES (18, 2018211258, 24, 'emmm', '2019-07-30 17:04:55');
INSERT INTO `review` VALUES (19, 2018211259, 24, 'nb', '2019-07-30 17:05:44');
INSERT INTO `review` VALUES (20, 2018211261, 25, '大佬', '2019-07-30 17:05:53');
INSERT INTO `review` VALUES (21, 2018211258, 26, '好强', '2019-07-30 17:06:34');
INSERT INTO `review` VALUES (22, 2018211249, 27, '感谢博主', '2019-07-30 17:06:42');
INSERT INTO `review` VALUES (23, 2018211259, 26, '学到了', '2019-07-30 17:07:32');

-- ----------------------------
-- Table structure for thumbup
-- ----------------------------
DROP TABLE IF EXISTS `thumbup`;
CREATE TABLE `thumbup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thumbup
-- ----------------------------
INSERT INTO `thumbup` VALUES (6, 2018211261, 23);
INSERT INTO `thumbup` VALUES (7, 2018211258, 23);
INSERT INTO `thumbup` VALUES (8, 2018211261, 24);
INSERT INTO `thumbup` VALUES (9, 2018211261, 25);
INSERT INTO `thumbup` VALUES (10, 2018211249, 25);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1533260543, '数据架构师', '111111', '男', '10086', '10086@qq.com', 2, NULL, 1);
INSERT INTO `user` VALUES (2018211249, '鲁艳琳', '123456', '女', '19936016525', '1491500997@qq.com', 1, NULL, 1);
INSERT INTO `user` VALUES (2018211258, '齐子鸣', '333333', '男', '13323902028', '849656219@qq.com', 2, NULL, 1);
INSERT INTO `user` VALUES (2018211259, '王梦飞', '222222', '男', '13092256521', '675075368@qq.com', 2, NULL, 1);
INSERT INTO `user` VALUES (2018211261, '为学日益', '123456', '男', '13516964920', '2955324023@qq.com', 1, NULL, 1);
INSERT INTO `user` VALUES (2027202434, '灯下鼠', '123456', '男', '23333333333', '23333333333@qq.com', 2, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
