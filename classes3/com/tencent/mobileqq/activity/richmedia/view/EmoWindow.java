package com.tencent.mobileqq.activity.richmedia.view;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmoWindow
{
  public static final int a = 20;
  public static final String a = "EmoWindow";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static ConcurrentHashMap a;
  public static final Pattern a;
  public static final short a = 65;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final String[] a;
  public static final short[] a;
  public static final String b = "http://qzonestyle.gtimg.cn/qzone/em/";
  private static final HashMap b;
  public static final Pattern b;
  public static final short b = 135;
  public static final String[] b;
  public static final String c = ".gif";
  private static final HashMap c;
  public static final Pattern c;
  public static final short c;
  public static final String[] c;
  public static final String d = "[/美女]";
  private static Pattern d;
  public static final String[] d;
  public static final String e = "[/钱]";
  private static Pattern e;
  public static final String f = "[em]";
  private static Pattern f;
  public static final String g = "[/em]";
  static final String h = "[表情]";
  public static final String i = "w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
  public static final String j = "\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b";
  private static final String k = "\\[/美女\\]|\\[/钱\\]";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ArrayOfShort = new short[] { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 196, 127, 128, 130, 131, 132, 133, 134, 7 };
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\[/美女\\]|\\[/钱\\]");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[/钱]", "[em]e175[/em]", "[/美女]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]", "[em]e121000[/em]", "[em]e121001[/em]", "[em]e121002[/em]", "[em]e121003[/em]", "[em]e121004[/em]", "[em]e121005[/em]", "[em]e121006[/em]", "[em]e121007[/em]", "[em]e121008[/em]", "[em]e121009[/em]", "[em]e121010[/em]", "[em]e121011[/em]", "[em]e121012[/em]", "[em]e121013[/em]", "[em]e121014[/em]", "[em]e121015[/em]", "[em]e121016[/em]", "[em]e121017[/em]", "[em]e121018[/em]", "[em]e121019[/em]", "[em]e121020[/em]", "[em]e121021[/em]", "[em]e121022[/em]", "[em]e121023[/em]", "[em]e121024[/em]", "[em]e121025[/em]", "[em]e121026[/em]", "[em]e121027[/em]", "[em]e121028[/em]", "[em]e121029[/em]", "[em]e121030[/em]", "[em]e121031[/em]", "[em]e121032[/em]", "[em]e121033[/em]", "[em]e121034[/em]", "[em]e121035[/em]" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "/微笑", "/撇嘴", "/色", "/发呆", "/得意", "/流泪", "/害羞", "/闭嘴", "/睡", "/大哭", "/尴尬", "/发怒", "/调皮", "/呲牙", "/惊讶", "/难过", "/酷", "/冷汗", "/抓狂", "/吐", "/偷笑", "/可爱", "/白眼", "/傲慢", "/饥饿", "/困", "/惊恐", "/流汗", "/憨笑", "/装逼", "/奋斗", "/咒骂", "/疑问", "/嘘...", "/晕", "/折磨", "/衰", "/骷髅", "/敲打", "/再见", "/擦汗", "/抠鼻", "/鼓掌", "/糗大了", "/坏笑", "/左哼哼", "/右哼哼", "/哈欠", "/鄙视", "/委屈", "/快哭了", "/阴险", "/亲亲", "/吓", "/可怜", "/菜刀", "/西瓜", "/啤酒", "/篮球", "/乒乓", "/咖啡", "/饭", "/猪头", "/玫瑰", "/凋谢", "/示爱", "/爱心", "/心碎", "/蛋糕", "/闪电", "/炸弹", "/刀", "/足球", "/瓢虫", "/便便", "/月亮", "/太阳", "/礼物", "/拥抱", "/赞", "/踩", "/握手", "/胜利", "/抱拳", "/勾引", "/拳头", "/差劲", "/爱你", "/NO", "/OK", "/爱情", "/飞吻", "/跳跳", "/发抖", "/怄火", "/转圈", "/磕头", "/回头", "/跳绳", "/挥手", "/激动", "/街舞", "/献吻", "/左太极", "/右太极", "/金钱", "/MM", "/招财进宝", "/双喜", "/鞭炮", "/灯笼", "/发财", "/K歌", "/购物", "/邮件", "/帅", "/喝彩", "/祈祷", "/爆筋", "/棒棒糖", "/喝奶", "/下面", "/香蕉", "/飞机", "/开车", "/高铁左车头", "/车厢", "/高铁右车头", "/多云", "/下雨", "/钞票", "/熊猫", "/灯泡", "/风车", "/闹钟", "/打伞", "/彩球", "/钻戒", "/沙发", "/纸巾", "/药", "/手枪", "/青蛙" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "[微笑]", "[撇嘴]", "[色]", "[发呆]", "[得意]", "[流泪]", "[害羞]", "[闭嘴]", "[睡]", "[大哭]", "[尴尬]", "[发怒]", "[调皮]", "[呲牙]", "[惊讶]", "[难过]", "[酷]", "[冷汗]", "[抓狂]", "[吐]", "[偷笑]", "[愉快]", "[白眼]", "[傲慢]", "[饥饿]", "[困]", "[惊恐]", "[流汗]", "[憨笑]", "[悠闲]", "[奋斗]", "[咒骂]", "[疑问]", "[嘘]", "[晕]", "[疯了]", "[衰]", "[骷髅]", "[敲打]", "[再见]", "[擦汗]", "[抠鼻]", "[鼓掌]", "[糗大了]", "[坏笑]", "[左哼哼]", "[右哼哼]", "[哈欠]", "[鄙视]", "[委屈]", "[快哭了]", "[阴险]", "[亲亲]", "[吓]", "[可怜]", "[菜刀]", "[西瓜]", "[啤酒]", "[篮球]", "[乒乓]", "[咖啡]", "[饭]", "[猪头]", "[玫瑰]", "[凋谢]", "[嘴唇]", "[爱心]", "[心碎]", "[蛋糕]", "[闪电]", "[炸弹]", "[刀]", "[足球]", "[瓢虫]", "[便便]", "[月亮]", "[太阳]", "[礼物]", "[拥抱]", "[强]", "[弱]", "[握手]", "[胜利]", "[抱拳]", "[勾引]", "[拳头]", "[差劲]", "[爱你]", "[NO]", "[OK]", "[爱情]", "[飞吻]", "[跳跳]", "[发抖]", "[怄火]", "[转圈]", "[磕头]", "[回头]", "[跳绳]", "[挥手]", "[激动]", "[街舞]", "[献吻]", "[左太极]", "[右太极]", "[金钱]", "[MM]", "[招财进宝]", "[双喜]", "[鞭炮]", "[灯笼]", "[发财]", "[K歌]", "[购物]", "[邮件]", "[帅]", "[喝彩]", "[祈祷]", "[爆筋]", "[棒棒糖]", "[喝奶]", "[下面]", "[香蕉]", "[飞机]", "[开车]", "[高铁左车头]", "[车厢]", "[高铁右车头]", "[多云]", "[下雨]", "[钞票]", "[熊猫]", "[灯泡]", "[风车]", "[闹钟]", "[打伞]", "[彩球]", "[钻戒]", "[沙发]", "[纸巾]", "[药]", "[手枪]", "[青蛙]" };
    jdField_c_of_type_Short = (short)jdField_b_of_type_ArrayOfJavaLangString.length;
    jdField_b_of_type_JavaUtilHashMap = new HashMap(106);
    jdField_c_of_type_JavaUtilHashMap = new HashMap(106);
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "[em]e100[/em]", "[em]e101[/em]", "[em]e102[/em]", "[em]e103[/em]", "[em]e104[/em]", "[em]e105[/em]", "[em]e106[/em]", "[em]e107[/em]", "[em]e108[/em]", "[em]e109[/em]", "[em]e110[/em]", "[em]e111[/em]", "[em]e112[/em]", "[em]e113[/em]", "[em]e114[/em]", "[em]e115[/em]", "[em]e116[/em]", "[em]e117[/em]", "[em]e118[/em]", "[em]e119[/em]", "[em]e120[/em]", "[em]e121[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e126[/em]", "[em]e127[/em]", "[em]e128[/em]", "[em]e129[/em]", "[em]e130[/em]", "[em]e131[/em]", "[em]e132[/em]", "[em]e133[/em]", "[em]e134[/em]", "[em]e135[/em]", "[em]e136[/em]", "[em]e137[/em]", "[em]e138[/em]", "[em]e139[/em]", "[em]e140[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e144[/em]", "[em]e145[/em]", "[em]e146[/em]", "[em]e147[/em]", "[em]e148[/em]", "[em]e149[/em]", "[em]e150[/em]", "[em]e151[/em]", "[em]e152[/em]", "[em]e153[/em]", "[em]e154[/em]", "[em]e155[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e160[/em]", "[em]e161[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e164[/em]", "[em]e165[/em]", "[em]e166[/em]", "[em]e167[/em]", "[em]e168[/em]", "[em]e169[/em]", "[em]e170[/em]", "[em]e171[/em]", "[em]e172[/em]", "[em]e173[/em]", "[em]e174[/em]", "[em]e175[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e178[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e184[/em]", "[em]e185[/em]", "[em]e186[/em]", "[em]e187[/em]", "[em]e188[/em]", "[em]e189[/em]", "[em]e190[/em]", "[em]e191[/em]", "[em]e192[/em]", "[em]e193[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e199[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[/钱]", "[/美女]", "[em]e121000[/em]", "[em]e121001[/em]", "[em]e121002[/em]", "[em]e121003[/em]", "[em]e121004[/em]", "[em]e121005[/em]", "[em]e121006[/em]", "[em]e121007[/em]", "[em]e121008[/em]", "[em]e121009[/em]", "[em]e121010[/em]", "[em]e121011[/em]", "[em]e121012[/em]", "[em]e121013[/em]", "[em]e121014[/em]", "[em]e121015[/em]", "[em]e121016[/em]", "[em]e121017[/em]", "[em]e121018[/em]", "[em]e121019[/em]", "[em]e121020[/em]", "[em]e121021[/em]", "[em]e121022[/em]", "[em]e121023[/em]", "[em]e121024[/em]", "[em]e121025[/em]", "[em]e121026[/em]", "[em]e121027[/em]", "[em]e121028[/em]", "[em]e121029[/em]", "[em]e121030[/em]", "[em]e121031[/em]", "[em]e121032[/em]", "[em]e121033[/em]", "[em]e121034[/em]", "[em]e121035[/em]" };
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
    jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("\\{uin:.*?\\}");
  }
  
  public static int a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      c();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramString = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return -1;
  }
  
  public static String a(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    Matcher localMatcher = f.matcher(paramString);
    while (localMatcher.find())
    {
      String str = localMatcher.group();
      if (jdField_c_of_type_JavaUtilHashMap.containsKey(str)) {
        paramString = paramString.replace(str, (CharSequence)jdField_c_of_type_JavaUtilHashMap.get(str));
      }
    }
    return paramString;
  }
  
  public static void a()
  {
    int m = 0;
    for (;;)
    {
      if (m < SystemEmoticonInfo.a.length)
      {
        int n = com.tencent.mobileqq.text.EmotcationConstants.b[SystemEmoticonInfo.a[m]];
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(n)) == null) {}
        try
        {
          Drawable localDrawable = BitmapDrawable.createFromStream(BaseApplicationImpl.getContext().getResources().openRawResource(n), null).mutate();
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(n), ((BitmapDrawable)localDrawable).getBitmap());
          m += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.d("EmoWindow", 2, "emowindow memory error" + localOutOfMemoryError.getMessage());
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    if ((jdField_d_of_type_JavaUtilRegexPattern == null) || (paramString == null)) {
      return paramString;
    }
    int m = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Matcher localMatcher = e.matcher(paramString);
    while (localMatcher.find())
    {
      if (localMatcher.start() >= m)
      {
        localStringBuilder.append(d(paramString.substring(m, localMatcher.start())));
        localStringBuilder.append(paramString.substring(localMatcher.start(), localMatcher.end()));
      }
      m = localMatcher.end();
    }
    localStringBuilder.append(d(paramString.substring(m, paramString.length())));
    return localStringBuilder.toString();
  }
  
  private static void b()
  {
    int n = 1;
    for (;;)
    {
      try
      {
        int i1 = jdField_b_of_type_ArrayOfJavaLangString.length;
        int m = 0;
        Object localObject1;
        if (m < i1)
        {
          jdField_b_of_type_JavaUtilHashMap.put(jdField_b_of_type_ArrayOfJavaLangString[m], jdField_d_of_type_ArrayOfJavaLangString[m]);
          HashMap localHashMap = jdField_c_of_type_JavaUtilHashMap;
          String str2 = jdField_d_of_type_ArrayOfJavaLangString[m];
          if (m < jdField_c_of_type_ArrayOfJavaLangString.length)
          {
            localObject1 = jdField_c_of_type_ArrayOfJavaLangString[m];
            localHashMap.put(str2, localObject1);
            m += 1;
          }
        }
        else
        {
          localObject1 = new StringBuffer("(" + jdField_b_of_type_ArrayOfJavaLangString[0] + ")");
          m = n;
          if (m < i1)
          {
            ((StringBuffer)localObject1).append("|(" + jdField_b_of_type_ArrayOfJavaLangString[m] + ")");
            m += 1;
            continue;
          }
          e = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
          jdField_d_of_type_JavaUtilRegexPattern = Pattern.compile(((StringBuffer)localObject1).toString());
          f = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
          jdField_a_of_type_Boolean = true;
          return;
        }
      }
      finally {}
      String str1 = "";
    }
  }
  
  public static String c(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    if (paramString == null) {
      return paramString;
    }
    int n = jdField_b_of_type_ArrayOfJavaLangString.length;
    String str = null;
    int m = 0;
    while (m < n)
    {
      if (jdField_d_of_type_ArrayOfJavaLangString[m].equalsIgnoreCase(paramString)) {
        str = jdField_b_of_type_ArrayOfJavaLangString[m];
      }
      m += 1;
    }
    return str;
  }
  
  private static void c()
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    int m = 0;
    while (m < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      jdField_a_of_type_JavaUtilHashMap.put(jdField_a_of_type_ArrayOfJavaLangString[m], Integer.valueOf(m));
      m += 1;
    }
  }
  
  private static String d(String paramString)
  {
    Matcher localMatcher = jdField_d_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null)
      {
        String str2 = (String)jdField_b_of_type_JavaUtilHashMap.get(str1);
        if (str2 != null)
        {
          str1 = paramString.replace(str1, str2);
          if (str1 != null) {
            paramString = str1;
          }
        }
      }
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\EmoWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */