package com.tencent.mobileqq.text;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import uzd;

public class EmotcationConstants
{
  public static final char a = '\024';
  public static final int a = 2130837760;
  public static final SparseIntArray a;
  public static final String a = "faceIdx";
  public static final Map a;
  public static final int[] a;
  public static final String[] a;
  public static final short[] a;
  public static int b = 0;
  public static final int[] b;
  public static String[] b;
  public static final short[] b;
  public static final int c = 2130839808;
  public static int[] c;
  public static String[] c;
  static final int d = 2130839942;
  public static final int[] d;
  public static int e = 0;
  public static final int[] e;
  public static final int f = 1000;
  public static final int[] f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837760, 2130837761, 2130837762, 2130837763, 2130837764, 2130837765, 2130837766, 2130837767, 2130837768, 2130837769, 2130837770, 2130837771, 2130837772, 2130837773, 2130837774, 2130837775, 2130837776, 2130837777, 2130837778, 2130837779, 2130837780, 2130837781, 2130837782, 2130837783, 2130837784, 2130837785, 2130837786, 2130837787, 2130837788, 2130837789, 2130837790, 2130837791, 2130837792, 2130837793, 2130837794, 2130837795, 2130837796, 2130837797, 2130837798, 2130837799, 2130837800, 2130837801, 2130837802, 2130837803, 2130837804, 2130837805, 2130837806, 2130837807, 2130837808, 2130837809, 2130837810, 2130837811, 2130837812, 2130837813, 2130837814, 2130837815, 2130837816, 2130837817, 2130837818, 2130837819, 2130838235, 2130837821, 2130837822, 2130837823, 2130837824, 2130837825, 2130837826, 2130837827, 2130837828, 2130837829, 2130837830, 2130837831, 2130837832, 2130838236, 2130837834, 2130837835, 2130837836, 2130837837, 2130837838, 2130837839, 2130837840, 2130837841, 2130837842, 2130837843, 2130837844, 2130837845, 2130837846, 2130837847, 2130837848, 2130837849, 2130837850, 2130837851, 2130837852, 2130837853, 2130838237, 2130837855, 2130837856, 2130837857, 2130837858, 2130837859, 2130837860, 2130837861, 2130837862, 2130837863, 2130837864, 2130837865, 2130837866, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130838784, 2130838785, 2130838786, 2130838787, 2130838788, 2130838789, 2130838790, 2130837767, 2130837768, 2130838793, 2130838794, 2130838795, 2130838796, 2130838797, 2130838798, 2130838799, 2130837776, 2130838801, 2130838802, 2130838803, 2130838804, 2130838805, 2130838806, 2130838807, 2130838808, 2130838809, 2130838810, 2130838811, 2130837788, 2130838813, 2130838814, 2130838815, 2130837792, 2130838817, 2130838818, 2130838819, 2130838820, 2130838821, 2130838822, 2130837799, 2130838824, 2130838825, 2130838826, 2130838827, 2130838828, 2130838829, 2130838830, 2130837807, 2130838832, 2130838833, 2130838834, 2130838835, 2130838836, 2130838837, 2130838838, 2130838839, 2130838840, 2130837817, 2130837818, 2130838843, 2130838235, 2130838845, 2130838846, 2130838847, 2130837824, 2130838849, 2130838850, 2130837827, 2130837828, 2130837829, 2130838854, 2130837831, 2130838856, 2130838240, 2130838858, 2130837835, 2130837836, 2130838239, 2130837838, 2130838863, 2130837840, 2130838865, 2130838866, 2130838867, 2130838868, 2130838869, 2130838870, 2130838871, 2130838872, 2130838873, 2130838874, 2130838875, 2130838876, 2130838877, 2130838241, 2130838879, 2130838880, 2130838881, 2130838882, 2130838883, 2130838884, 2130838885, 2130838886, 2130838887, 2130838888, 2130838889, 2130838890, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902 };
    jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt.length;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "/呲牙", "/调皮", "/流汗", "/偷笑", "/再见", "/敲打", "/擦汗", "/猪头", "/玫瑰", "/流泪", "/大哭", "/嘘...", "/酷", "/抓狂", "/委屈", "/便便", "/炸弹", "/菜刀", "/可爱", "/色", "/害羞", "/得意", "/吐", "/微笑", "/发怒", "/尴尬", "/惊恐", "/冷汗", "/爱心", "/示爱", "/白眼", "/傲慢", "/难过", "/惊讶", "/疑问", "/睡", "/亲亲", "/憨笑", "/爱情", "/衰", "/撇嘴", "/阴险", "/奋斗", "/发呆", "/右哼哼", "/拥抱", "/坏笑", "/飞吻", "/鄙视", "/晕", "/装逼", "/可怜", "/赞", "/踩", "/握手", "/胜利", "/抱拳", "/凋谢", "/饭", "/蛋糕", "/西瓜", "/啤酒", "/瓢虫", "/勾引", "/OK", "/爱你", "/咖啡", "/钱", "/月亮", "/美女", "/刀", "/发抖", "/差劲", "/拳头", "/心碎", "/太阳", "/礼物", "/足球", "/骷髅", "/挥手", "/闪电", "/饥饿", "/困", "/咒骂", "/折磨", "/抠鼻", "/鼓掌", "/糗大了", "/左哼哼", "/哈欠", "/快哭了", "/吓", "/篮球", "/乒乓", "/NO", "/跳跳", "/怄火", "/转圈", "/磕头", "/回头", "/跳绳", "/激动", "/街舞", "/献吻", "/左太极", "/右太极", "/闭嘴", "/招财进宝", "/双喜", "/鞭炮", "/灯笼", "/发财", "/K歌", "/购物", "/邮件", "/帅", "/喝彩", "/祈祷", "/爆筋", "/棒棒糖", "/喝奶", "/下面", "/香蕉", "/飞机", "/开车", "/高铁左车头", "/车厢", "/高铁右车头", "/多云", "/下雨", "/钞票", "/熊猫", "/灯泡", "/风车", "/闹钟", "/打伞", "/彩球", "/钻戒", "/沙发", "/纸巾", "/药", "/手枪", "/青蛙" };
    jdField_e_of_type_Int = 247;
    jdField_c_of_type_ArrayOfInt = new int[] { 128522, 128524, 128538, 128531, 128560, 128541, 128513, 128540, 9786, 128521, 128525, 128532, 128516, 128527, 128530, 128563, 128536, 128557, 128561, 128514, 128170, 128074, 128077, 9757, 128079, 9996, 128078, 128591, 128076, 128072, 128073, 128070, 128071, 128064, 128067, 128068, 128066, 127834, 127837, 127836, 127833, 127847, 127843, 127874, 127838, 127828, 127859, 127839, 127866, 127867, 127864, 9749, 127822, 127818, 127827, 127817, 128138, 128684, 127876, 127801, 127881, 127796, 128157, 127872, 127880, 128026, 128141, 128163, 128081, 128276, 11088, 10024, 128168, 128166, 128293, 127942, 128176, 128164, 9889, 128099, 128169, 128137, 9832, 128235, 128273, 128274, 9992, 128644, 128663, 128676, 128690, 128014, 128640, 128652, 9973, 128105, 128104, 128103, 128102, 128053, 128025, 128055, 128128, 128036, 128040, 128046, 128020, 128056, 128123, 128027, 128032, 128054, 128047, 128124, 128039, 128051, 128045, 128082, 128087, 128132, 128096, 128098, 127746, 128092, 128089, 128085, 128095, 9729, 9728, 9748, 127769, 9924, 11093, 10060, 10068, 10069, 9742, 128247, 128241, 128224, 128187, 127909, 127908, 128299, 128191, 128147, 9827, 126980, 12349, 127920, 128677, 128679, 127928, 128136, 128704, 128701, 127968, 9962, 127974, 127973, 127976, 127975, 127978, 128697, 128698, 169, 174, 8482, 9786, 9888, 9917, 9925, 9978, 9989, 9994, 9995, 10052, 12951, 127383, 127804, 127808, 127812, 127815, 127820, 127821, 127824, 127846, 127853, 127868, 127918, 127923, 127925, 127929, 127931, 127934, 127936, 127946, 128009, 128013, 128044, 128126, 128127, 128148, 128162, 128175, 128552, 128201, 128205, 128222, 128512, 128545, 128515, 128516, 128517, 128518, 128519, 128520, 128522, 128523, 128525, 128526, 128528, 128529, 128531, 128533, 128535, 128537, 128539, 128542, 128543, 128544, 128547, 128548, 128550, 128551, 128553, 128554, 128555, 128556, 128558, 128559, 128562, 128565, 128566, 128567, 128534, 128549, 128546, 128114, 128115, 128110, 128119, 128130, 128118, 128116, 128117, 128113, 128120, 128570, 128568, 128571, 128573, 128572, 128576, 128575, 128569, 128574, 128121, 128122, 128584, 128585, 128586, 128125, 127775, 128171, 128165, 128167, 128069, 128075, 128080, 128588, 128694, 127939, 128131, 128107, 128106, 128108, 128109, 128143, 128145, 128111, 128582, 128581, 128129, 128587, 128134, 128135, 128133, 128112, 128590, 128589, 128583, 127913, 128094, 128097, 128084, 128090, 127933, 128086, 128088, 128188, 128093, 128091, 128083, 128155, 128153, 128156, 128154, 10084, 128151, 128149, 128150, 128158, 128152, 128140, 128139, 128142, 128100, 128101, 128172, 128173, 128058, 128049, 128057, 128048, 128059, 128061, 128023, 128018, 128052, 128017, 128024, 128060, 128038, 128037, 128035, 128034, 128029, 128028, 128030, 128012, 128031, 128011, 128004, 128015, 128000, 128003, 128005, 128007, 128016, 128019, 128021, 128022, 128001, 128002, 128050, 128033, 128010, 128043, 128042, 128006, 128008, 128041, 128062, 128144, 127800, 127799, 127803, 127802, 127809, 127811, 127810, 127807, 127806, 127797, 127794, 127795, 127792, 127793, 127760, 127774, 127773, 127770, 127761, 127762, 127763, 127764, 127765, 127766, 127767, 127768, 127772, 127771, 127757, 127758, 127759, 127755, 127756, 127776, 127744, 127745, 127752, 127754, 127885, 127886, 127890, 127891, 127887, 127878, 127879, 127888, 127889, 127875, 127877, 127873, 127883, 127882, 127884, 128302, 128249, 128252, 128192, 128189, 128190, 128223, 128225, 128250, 128251, 128266, 128265, 128264, 128263, 128277, 128226, 128227, 9203, 8987, 9200, 8986, 128275, 128271, 128272, 128270, 128161, 128294, 128262, 128261, 128268, 128267, 128269, 128705, 128703, 128295, 128297, 128296, 128682, 128298, 128180, 128181, 128183, 128182, 128179, 128184, 128242, 128231, 128229, 128228, 9993, 128233, 128232, 128239, 128234, 128236, 128237, 128238, 128230, 128221, 128196, 128195, 128209, 128202, 128220, 128203, 128197, 128198, 128199, 128193, 128194, 9986, 128204, 128206, 10002, 9999, 128207, 128208, 128213, 128215, 128216, 128217, 128211, 128212, 128210, 128218, 128214, 128278, 128219, 128300, 128301, 128240, 127911, 127932, 127926, 127930, 127927, 127183, 127924, 127922, 127919, 127944, 9918, 127921, 127945, 9971, 128693, 128692, 127937, 127943, 127935, 127938, 127940, 127907, 127861, 127862, 127865, 127863, 127860, 127829, 127831, 127830, 127835, 127844, 127857, 127845, 127832, 127858, 127842, 127841, 127849, 127854, 127848, 127856, 127850, 127851, 127852, 127855, 127823, 127819, 127826, 127825, 127816, 127840, 127814, 127813, 127805, 127969, 127979, 127970, 127971, 127977, 128146, 127980, 127972, 127751, 127750, 127983, 127984, 127981, 128508, 128510, 128507, 127748, 127749, 127747, 128509, 127753, 127904, 127905, 9970, 127906, 128674, 128675, 9875, 128186, 128641, 128642, 128650, 128649, 128670, 128646, 128645, 128648, 128647, 128669, 128651, 128643, 128654, 128653, 128665, 128664, 128661, 128662, 128667, 128666, 128680, 128660, 128656, 128673, 128671, 128672, 128668, 128655, 127915, 128678, 128304, 9981, 127982, 128511, 127914, 127917, 128681, 128287, 128290, 128291, 11014, 11015, 11013, 128288, 128289, 128292, 8599, 8598, 8600, 8601, 8596, 8597, 128260, 9664, 9654, 128316, 128317, 8617, 8618, 8505, 9194, 9193, 9195, 9196, 10549, 10548, 128256, 128257, 128258, 127381, 127385, 127378, 127379, 127382, 128246, 127910, 127489, 127535, 127539, 127541, 127540, 127538, 127568, 127545, 127546, 127542, 127514, 128699, 128700, 128702, 128688, 128686, 127359, 9855, 128685, 127543, 127544, 127490, 9410, 128706, 128708, 128709, 128707, 127569, 12953, 127377, 127384, 127380, 128683, 128286, 128245, 128687, 128689, 128691, 128695, 128696, 9940, 10035, 10055, 10062, 10036, 128159, 127386, 128243, 128244, 127344, 127345, 127374, 127358, 128160, 10175, 9851, 9800, 9801, 9802, 9803, 9804, 9805, 9806, 9807, 9808, 9809, 9810, 9811, 9934, 128303, 128185, 128178, 128177, 8252, 8265, 10071, 10067, 128285, 128282, 128281, 128283, 128284, 128359, 128336, 128348, 128337, 128349, 128338, 128350, 128339, 128351, 128340, 128352, 128341, 128342, 128343, 128344, 128345, 128346, 128353, 128354, 128355, 128356, 128357, 128358, 10006, 10133, 10134, 10135, 9824, 9829, 9830, 128174, 10004, 9745, 128280, 128279, 10160, 12336, 128305, 9724, 9723, 9726, 9725, 9642, 9643, 128314, 128306, 128307, 9899, 9898, 128308, 128309, 128315, 11036, 11035, 128310, 128311, 128312, 128313, 128657, 128658, 128659 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "嘿嘿", "羞涩", "亲亲", "汗", "紧张", "吐舌", "呲牙", "淘气", "可爱", "媚眼", "花痴", "失落", "高兴", "哼哼", "不屑", "瞪眼", "飞吻", "大哭", "害怕", "激动", "肌肉", "拳头", "厉害", "向上", "鼓掌", "胜利", "鄙视", "合十", "好的", "向左", "向右", "向上", "向下", "眼睛", "鼻子", "嘴唇", "耳朵", "米饭", "意面", "拉面", "饭团", "刨冰", "寿司", "蛋糕", "起司", "汉堡", "煎蛋", "薯条", "啤酒", "干杯", "高脚杯", "咖啡", "苹果", "橙子", "草莓", "西瓜", "药丸", "吸烟", "圣诞树", "玫瑰", "庆祝", "椰子树", "礼物", "蝴蝶结", "气球", "海螺", "戒指", "炸弹", "皇冠", "铃铛", "星星", "闪光", "吹气", "水", "火", "奖杯", "钱", "睡觉", "闪电", "脚印", "便便", "打针", "热", "文件", "钥匙", "锁", "飞机", "列车", "汽车", "快艇", "自行车", "骑马", "火箭", "公交", "船", "妈妈", "爸爸", "女孩", "男孩", "猴", "章鱼", "猪", "骷髅", "小鸡", "树懒", "牛", "公鸡", "青蛙", "幽灵", "虫", "鱼", "狗", "老虎", "天使", "企鹅", "海豚", "老鼠", "帽子", "连衣裙", "口红", "高跟鞋", "鞋子", "雨伞", "包", "内衣", "衣服", "鞋子", "云朵", "晴天", "雨天", "月亮", "雪人", "正确", "错误", "问好", "叹号", "电话", "相机", "手机", "传真", "电脑", "摄影机", "话筒", "手枪", "光碟", "爱心", "扑克", "麻将", "股票", "老虎机", "信号灯", "路障", "吉他", "理发厅", "浴缸", "马桶", "家", "教堂", "银行", "医院", "酒店", "取款机", "超市", "男性", "女性" };
    long l = SystemClock.uptimeMillis();
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(jdField_c_of_type_ArrayOfInt.length);
    jdField_a_of_type_JavaUtilMap = new HashMap(300);
    int i = 0;
    while (i < jdField_c_of_type_ArrayOfInt.length)
    {
      int j = jdField_c_of_type_ArrayOfInt[i];
      jdField_a_of_type_AndroidUtilSparseIntArray.put(j, i);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppleEmojiManager", 2, "old init cost:" + (SystemClock.uptimeMillis() - l) + "EMOJI_CODES.length=" + jdField_c_of_type_ArrayOfInt.length);
    }
    a();
    d = new int[] { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    jdField_e_of_type_ArrayOfInt = new int[] { 33, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
    jdField_a_of_type_ArrayOfShort = new short[] { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    jdField_b_of_type_ArrayOfShort = new short[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 11, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    f = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 67, 69, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "f001", "f004", "f005", "f009", "f010", "f013", "f018", "f019", "f020", "f025", "f037", "f043", "f098", "f099", "f100" };
  }
  
  public static int a(int paramInt)
  {
    int m = 0;
    int j = -1;
    int k = 1;
    if ((paramInt > 8251) && (paramInt < 13056)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramInt > 126979) && (paramInt < 129473)) {
        if (paramInt > 127461)
        {
          i = m;
          if (paramInt < 127488) {}
        }
        else
        {
          if ((paramInt <= 41) || (paramInt >= 64)) {
            break label107;
          }
          i = m;
        }
      }
      for (;;)
      {
        if ((i == 0) && (paramInt > 65) && (paramInt < 175)) {
          i = k;
        }
        for (;;)
        {
          if (i != 0) {
            j = jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, -1);
          }
          return j;
          label107:
          i = 1;
          break;
        }
      }
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (((paramInt2 > 127994) && (paramInt2 < 128000)) || ((paramInt1 > 127461) && (paramInt1 < 127488)) || ((paramInt1 <= 34) || (paramInt1 >= 64) || (jdField_a_of_type_JavaUtilMap == null))) {
      return -1;
    }
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramInt1 + "|" + paramInt2);
    if (localInteger != null) {}
    for (paramInt1 = localInteger.intValue();; paramInt1 = -1) {
      return paramInt1;
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= jdField_b_of_type_ArrayOfJavaLangString.length)) {
      return " 未知 ";
    }
    return jdField_b_of_type_ArrayOfJavaLangString[paramInt] + " ";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(EmotcationConstants.class.getSimpleName(), 2, "beforeXml:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (Character.codePointCount(paramString1, 0, paramString1.length()) == paramString1.length()) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder("[emoji:0x%05x");
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append(']');
    paramString2 = null;
    if (QLog.isColorLevel()) {
      paramString2 = new StringBuilder(1024).append("beforXml start");
    }
    int k = paramString1.length();
    int i = 0;
    while (i < k)
    {
      int n = paramString1.codePointAt(i);
      int j = i;
      String str1 = paramString1;
      if (n > 65535)
      {
        String str2 = paramString1.substring(i, i + 2);
        str1 = String.format(localStringBuilder.toString(), new Object[] { Integer.valueOf(n) });
        paramString1 = paramString1.replace(str2, str1);
        i += str1.length() - 1;
        int m = paramString1.length();
        j = i;
        k = m;
        str1 = paramString1;
        if (QLog.isColorLevel())
        {
          paramString2.append("\n").append("unicode").append(":").append(n);
          str1 = paramString1;
          k = m;
          j = i;
        }
      }
      i = j + 1;
      paramString1 = str1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmotcationConstants", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  public static void a()
  {
    SystemClock.uptimeMillis();
    long l = SystemClock.uptimeMillis();
    File localFile1 = new File(AppleEmojiManager.b);
    File localFile2 = new File(AppleEmojiManager.c);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    boolean bool = ((SharedPreferences)localObject).getBoolean("build_emoji_file", false);
    if (QLog.isColorLevel()) {
      QLog.d("AppleEmojiManager", 2, "loadEmojiMapFormDisk buildSuccess=" + bool);
    }
    if ((bool) && (localFile1.exists()) && (localFile2.exists())) {
      a(localFile1, localFile2);
    }
    label354:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "init full emoji index cost:" + (SystemClock.uptimeMillis() - l));
      }
      return;
      localObject = ((SharedPreferences)localObject).getString("apple_emoji_file", "");
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "loadEmojiMapFormDisk filepath=" + (String)localObject);
      }
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        File localFile3 = new File((String)localObject);
        if (localFile3.exists())
        {
          ThreadManager.a(new uzd(localFile1, localFile2, localFile3), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("MF", 2, "zipfile path=" + (String)localObject);
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label354;
        }
        QLog.d("AppleEmojiManager", 2, "emoji index file not exist,load fail");
        break;
        BaseApplication.getContext().getSharedPreferences(new AppleEmojiData().getSharedPreferencesName(), 0).edit().clear().commit();
        jdField_a_of_type_JavaUtilMap.clear();
        b();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AppleEmojiManager", 2, "apple_emoji_file sp is null reload");
        }
        b();
      }
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +20 -> 25
    //   8: invokestatic 1622	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +13 -> 24
    //   14: ldc_w 1624
    //   17: iconst_2
    //   18: ldc_w 2068
    //   21: invokestatic 1649	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: invokestatic 1599	android/os/SystemClock:uptimeMillis	()J
    //   28: lstore 6
    //   30: invokestatic 1972	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokestatic 1978	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   36: ldc_w 1980
    //   39: iconst_0
    //   40: invokeinterface 1986 3 0
    //   45: ifeq -21 -> 24
    //   48: aload_0
    //   49: invokevirtual 1994	java/io/File:exists	()Z
    //   52: ifeq -28 -> 24
    //   55: aload_1
    //   56: invokevirtual 1994	java/io/File:exists	()Z
    //   59: ifeq -35 -> 24
    //   62: getstatic 1612	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   65: invokeinterface 2060 1 0
    //   70: new 2070	java/io/BufferedInputStream
    //   73: dup
    //   74: new 2072	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 2075	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 2078	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: aload_1
    //   89: invokevirtual 2081	java/io/BufferedInputStream:read	()I
    //   92: istore_3
    //   93: iload_3
    //   94: iconst_m1
    //   95: if_icmpeq +229 -> 324
    //   98: iload_3
    //   99: iconst_1
    //   100: if_icmpne +138 -> 238
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: invokestatic 2084	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/InputStream;)I
    //   109: istore_3
    //   110: aload_1
    //   111: astore_0
    //   112: aload_1
    //   113: invokestatic 2084	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/InputStream;)I
    //   116: istore 4
    //   118: aload_1
    //   119: astore_0
    //   120: getstatic 1607	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   123: iload_3
    //   124: iload 4
    //   126: sipush 1000
    //   129: iadd
    //   130: invokevirtual 1616	android/util/SparseIntArray:put	(II)V
    //   133: goto -47 -> 86
    //   136: astore_2
    //   137: aload_1
    //   138: astore_0
    //   139: ldc_w 1624
    //   142: iconst_1
    //   143: ldc_w 2008
    //   146: aload_2
    //   147: invokestatic 2087	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 2090	java/io/BufferedInputStream:close	()V
    //   158: invokestatic 1622	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -137 -> 24
    //   164: ldc_w 1624
    //   167: iconst_2
    //   168: new 1626	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 1628	java/lang/StringBuilder:<init>	()V
    //   175: invokestatic 2002	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   178: ldc_w 2092
    //   181: invokevirtual 1634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokestatic 1599	android/os/SystemClock:uptimeMillis	()J
    //   187: lload 6
    //   189: lsub
    //   190: invokevirtual 1637	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: invokevirtual 1646	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 1634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 2094
    //   202: invokevirtual 1634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: getstatic 1607	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   208: invokevirtual 2097	android/util/SparseIntArray:size	()I
    //   211: invokevirtual 1642	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: ldc_w 2099
    //   217: invokevirtual 1634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 1612	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   223: invokeinterface 2100 1 0
    //   228: invokevirtual 1642	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 1646	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 1649	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: return
    //   238: aload_1
    //   239: astore_0
    //   240: aload_1
    //   241: invokestatic 2084	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/InputStream;)I
    //   244: istore_3
    //   245: aload_1
    //   246: astore_0
    //   247: aload_1
    //   248: invokestatic 2084	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/InputStream;)I
    //   251: istore 4
    //   253: aload_1
    //   254: astore_0
    //   255: aload_1
    //   256: invokestatic 2084	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/InputStream;)I
    //   259: istore 5
    //   261: aload_1
    //   262: astore_0
    //   263: getstatic 1612	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   266: new 1626	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 1628	java/lang/StringBuilder:<init>	()V
    //   273: iload_3
    //   274: invokevirtual 1642	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 1876
    //   280: invokevirtual 1634	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload 4
    //   285: invokevirtual 1642	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: invokevirtual 1646	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: iload 5
    //   293: sipush 1000
    //   296: iadd
    //   297: invokestatic 1941	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: invokeinterface 2103 3 0
    //   305: pop
    //   306: goto -220 -> 86
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: aload_2
    //   313: astore_0
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 2090	java/io/BufferedInputStream:close	()V
    //   322: aload_0
    //   323: athrow
    //   324: aload_1
    //   325: ifnull -167 -> 158
    //   328: aload_1
    //   329: invokevirtual 2090	java/io/BufferedInputStream:close	()V
    //   332: goto -174 -> 158
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual 2106	java/io/IOException:printStackTrace	()V
    //   340: goto -182 -> 158
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 2106	java/io/IOException:printStackTrace	()V
    //   348: goto -190 -> 158
    //   351: astore_1
    //   352: aload_1
    //   353: invokevirtual 2106	java/io/IOException:printStackTrace	()V
    //   356: goto -34 -> 322
    //   359: astore_0
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -48 -> 314
    //   365: astore_2
    //   366: aconst_null
    //   367: astore_1
    //   368: goto -231 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramFile1	File
    //   0	371	1	paramFile2	File
    //   136	11	2	localIOException1	java.io.IOException
    //   309	4	2	localObject	Object
    //   365	1	2	localIOException2	java.io.IOException
    //   92	182	3	i	int
    //   116	168	4	j	int
    //   259	38	5	k	int
    //   28	160	6	l	long
    // Exception table:
    //   from	to	target	type
    //   88	93	136	java/io/IOException
    //   105	110	136	java/io/IOException
    //   112	118	136	java/io/IOException
    //   120	133	136	java/io/IOException
    //   240	245	136	java/io/IOException
    //   247	253	136	java/io/IOException
    //   255	261	136	java/io/IOException
    //   263	306	136	java/io/IOException
    //   88	93	309	finally
    //   105	110	309	finally
    //   112	118	309	finally
    //   120	133	309	finally
    //   139	150	309	finally
    //   240	245	309	finally
    //   247	253	309	finally
    //   255	261	309	finally
    //   263	306	309	finally
    //   328	332	335	java/io/IOException
    //   154	158	343	java/io/IOException
    //   318	322	351	java/io/IOException
    //   70	86	359	finally
    //   70	86	365	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(EmotcationConstants.class.getSimpleName(), 2, "afterXml:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
    if (!TextUtils.isEmpty(paramString2)) {
      ((StringBuilder)localObject).append(paramString2);
    }
    for (int i = paramString2.length();; i = 0)
    {
      ((StringBuilder)localObject).append("\\]");
      localObject = Pattern.compile(((StringBuilder)localObject).toString()).matcher(paramString1);
      StringBuffer localStringBuffer = new StringBuffer();
      paramString2 = null;
      if (QLog.isColorLevel()) {
        paramString2 = new StringBuilder(1024).append("afterXml start");
      }
      for (int j = 0; ((Matcher)localObject).find(); j = 1)
      {
        j = Integer.valueOf(paramString1.substring(((Matcher)localObject).start() + 9, ((Matcher)localObject).end() - 1 - i), 16).intValue();
        if (j > 65535) {
          ((Matcher)localObject).appendReplacement(localStringBuffer, new String(new int[] { j }, 0, 1));
        }
        if (QLog.isColorLevel()) {
          paramString2.append("\n").append("unicode").append(":").append(j);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotcationConstants", 2, paramString2.toString());
      }
      ((Matcher)localObject).appendTail(localStringBuffer);
      if (j == 0) {
        break;
      }
      return localStringBuffer.toString();
    }
  }
  
  public static void b()
  {
    try
    {
      Object localObject = (EarlyDownloadManager)BaseApplicationImpl.a().a().getManager(76);
      if (localObject != null)
      {
        localObject = (AppleEmojiHandler)((EarlyDownloadManager)localObject).a("qq.android.appleemoji");
        if (localObject != null) {
          ((AppleEmojiHandler)localObject).a(true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "clear sharePreference info,zipfile path is null restartDownload");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AppleEmojiManager", 2, "reDownloadAppleEmoji e=" + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\EmotcationConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */