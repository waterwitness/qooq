package com.tencent.mobileqq.utils;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChnToSpell
{
  public static final int a = 1;
  private static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
  private static final String jdField_a_of_type_JavaLangString = "qq_uni2py.db";
  private static Map jdField_a_of_type_JavaUtilMap;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final String[] a;
  private static short[] jdField_a_of_type_ArrayOfShort;
  public static final int b = 2;
  private static LruCache jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(1024);
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final int c = 19968;
  public static final int d = 40869;
  private static final int e = 2048;
  private static final int f = 3;
  private static final int g = 8544;
  private static final int h = 8575;
  private static final int i = 12295;
  private static final int j = 65281;
  private static final int k = 65374;
  private static final int l = 33;
  private static final int m = 65248;
  private static final int n = 5;
  private static final int o = -3;
  private static final int p = -5;
  private static final int q = -7;
  private static final int r = -10;
  private static final int s = -12;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "?", "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", "ji", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", "m", "n", "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000" };
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, Integer.MAX_VALUE };
  }
  
  public static ChnToSpell.CharSpelling a(char paramChar, int paramInt)
  {
    ChnToSpell.CharSpelling localCharSpelling = new ChnToSpell.CharSpelling();
    if (paramInt == 0)
    {
      if (paramChar == '单')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "shan";
        return localCharSpelling;
      }
      if (paramChar == '仇')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "qiu";
        return localCharSpelling;
      }
      if (paramChar == '曾')
      {
        localCharSpelling.jdField_a_of_type_Int = 5;
        localCharSpelling.jdField_a_of_type_JavaLangString = "zeng";
        return localCharSpelling;
      }
    }
    switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, paramChar))
    {
    default: 
      if (Character.isHighSurrogate(paramChar))
      {
        localCharSpelling.jdField_a_of_type_Int = 0;
        localCharSpelling.jdField_a_of_type_JavaLangString = "??";
      }
      break;
    }
    for (;;)
    {
      return localCharSpelling;
      int i1 = paramChar - 'Ⅰ';
      paramInt = i1;
      if (i1 >= jdField_b_of_type_ArrayOfJavaLangString.length) {
        paramInt = i1 - jdField_b_of_type_ArrayOfJavaLangString.length;
      }
      localCharSpelling.jdField_a_of_type_Int = 1;
      localCharSpelling.jdField_a_of_type_JavaLangString = jdField_b_of_type_ArrayOfJavaLangString[paramInt];
      continue;
      localCharSpelling.jdField_a_of_type_Int = 2;
      localCharSpelling.jdField_a_of_type_JavaLangString = "ling";
      continue;
      localCharSpelling.jdField_a_of_type_Int = 4;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
      continue;
      localCharSpelling.jdField_a_of_type_Int = 3;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
      continue;
      localCharSpelling.jdField_a_of_type_Int = 5;
      localCharSpelling.jdField_a_of_type_JavaLangString = jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(paramChar - '一')]];
      continue;
      localCharSpelling.jdField_a_of_type_Int = 6;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(Character.toLowerCase((char)(paramChar - 65248)));
      continue;
      localCharSpelling.jdField_a_of_type_Int = 0;
      localCharSpelling.jdField_a_of_type_JavaLangString = String.valueOf(paramChar);
    }
  }
  
  public static ChnToSpell.ChnSpelling a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject1 = new ChnToSpell.ChnSpelling();
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_Int = paramInt;
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaLangString = "";
    }
    do
    {
      return (ChnToSpell.ChnSpelling)localObject1;
      if (paramInt != 1) {
        break;
      }
      localObject2 = (ChnToSpell.ChnSpelling)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject1 = new ChnToSpell.ChnSpelling();
    ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_Int = paramInt;
    ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
    if (jdField_a_of_type_ArrayOfShort == null) {
      b();
    }
    Object localObject2 = new StringBuilder();
    int i5 = paramString.length();
    int i2 = paramString.charAt(0);
    if (i2 == 21333) {
      if (paramInt == 1)
      {
        ((StringBuilder)localObject2).append("shan");
        label146:
        ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
        i2 = 1;
      }
    }
    for (;;)
    {
      label163:
      if (i2 < i5)
      {
        int i1 = paramString.charAt(i2);
        ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
        switch (Arrays.binarySearch(jdField_a_of_type_ArrayOfInt, i1))
        {
        default: 
          if (Character.isHighSurrogate(i1))
          {
            ((StringBuilder)localObject2).append('?');
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((StringBuilder)localObject2).length()));
            ((StringBuilder)localObject2).append('?');
            i2 += 1;
          }
          break;
        }
        for (;;)
        {
          i2 += 1;
          break label163;
          if (paramInt != 2) {
            break;
          }
          localObject1 = (ChnToSpell.ChnSpelling)jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
          if (localObject1 == null) {
            break;
          }
          return (ChnToSpell.ChnSpelling)localObject1;
          if (paramInt != 2) {
            break label146;
          }
          ((StringBuilder)localObject2).append('s');
          break label146;
          if (i2 == 20167)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("qiu");
            }
            for (;;)
            {
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              i2 = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('1');
              }
            }
          }
          if (i2 == 26366)
          {
            if (paramInt == 1) {
              ((StringBuilder)localObject2).append("zeng");
            }
            for (;;)
            {
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              i2 = 1;
              break;
              if (paramInt == 2) {
                ((StringBuilder)localObject2).append('z');
              }
            }
          }
          if ((i2 != 19975) || (paramString.length() <= 1) || (paramString.charAt(1) != '俟')) {
            break label807;
          }
          if (paramInt == 1)
          {
            ((StringBuilder)localObject2).append("moqi");
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
            ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
          }
          for (;;)
          {
            i2 = 2;
            break;
            if (paramInt == 2)
            {
              ((StringBuilder)localObject2).append("mq");
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
              ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
            }
          }
          int i4 = i1 - 8544;
          int i3 = i4;
          if (i4 >= jdField_b_of_type_ArrayOfJavaLangString.length) {
            i3 = i4 - jdField_b_of_type_ArrayOfJavaLangString.length;
          }
          ((StringBuilder)localObject2).append(jdField_b_of_type_ArrayOfJavaLangString[i3]);
          continue;
          if (paramInt == 1)
          {
            ((StringBuilder)localObject2).append("ling");
          }
          else
          {
            ((StringBuilder)localObject2).append('l');
            continue;
            ((StringBuilder)localObject2).append(Character.toLowerCase(i1));
            continue;
            ((StringBuilder)localObject2).append(i1);
            continue;
            if (paramInt == 1)
            {
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i1 - 19968)]]);
            }
            else
            {
              ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[jdField_a_of_type_ArrayOfShort[(i1 - 19968)]].charAt(0));
              continue;
              ((StringBuilder)localObject2).append(Character.toLowerCase((char)(i1 - 65248)));
              continue;
              ((StringBuilder)localObject2).append(i1);
            }
          }
        }
      }
      ((ChnToSpell.ChnSpelling)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      if (paramInt == 1) {
        jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
      }
      for (;;)
      {
        return (ChnToSpell.ChnSpelling)localObject1;
        if (paramInt == 2) {
          jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject1);
        }
      }
      label807:
      i2 = 0;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt).jdField_a_of_type_JavaLangString;
  }
  
  private static void a()
  {
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('查'), new String[] { "zha", "cha" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('曾'), new String[] { "zeng", "ceng" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(34892), new String[] { "xing", "hang" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(35299), new String[] { "xie", "jie" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(39049), new String[] { "xie", "jie", "jia" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('校'), new String[] { "xiao", "jiao" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(33688), new String[] { "shen", "xin" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('召'), new String[] { "shao", "zhao" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('单'), new String[] { "shan", "dan" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('仇'), new String[] { "qiu", "chou" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('卡'), new String[] { "qia", "ka" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('便'), new String[] { "bian", "pian" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('区'), new String[] { "ou", "qu" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('粘'), new String[] { "nian", "zhan" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('圈'), new String[] { "juan", "quan" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('炅'), new String[] { "gui", "jiong" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('朝'), new String[] { "chao", "zhao" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(34255), new String[] { "cang", "zang" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('秘'), new String[] { "bi", "mi", "bei" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('尉'), new String[] { "wei" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('万'), new String[] { "wan", "mo" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(35203), new String[] { "qin", "tan", "xun" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('折'), new String[] { "she", "zhe" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('乐'), new String[] { "le", "yue" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(38551), new String[] { "kui", "wei", "yu" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('宓'), new String[] { "fu", "mi" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf(37063), new String[] { "huan", "xun" });
      jdField_a_of_type_JavaUtilMap.put(Character.valueOf('种'), new String[] { "zhong", "chong" });
    }
  }
  
  public static String[] a(char paramChar)
  {
    
    if (jdField_a_of_type_JavaUtilMap.containsKey(Character.valueOf(paramChar))) {
      return (String[])jdField_a_of_type_JavaUtilMap.get(Character.valueOf(paramChar));
    }
    return new String[] { a(String.valueOf(paramChar), 1) };
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 954	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   6: ifnull +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: sipush 20902
    //   16: newarray <illegal type>
    //   18: putstatic 954	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   21: sipush 2048
    //   24: newarray <illegal type>
    //   26: astore 5
    //   28: iconst_0
    //   29: istore 7
    //   31: getstatic 1060	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   34: invokevirtual 1064	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   37: invokevirtual 1070	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   40: ldc 11
    //   42: invokevirtual 1076	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_0
    //   46: aload 5
    //   48: invokestatic 1082	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   51: astore 4
    //   53: new 1084	java/io/BufferedInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 1087	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_1
    //   62: aload_1
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: aload_1
    //   67: aload 5
    //   69: iconst_0
    //   70: sipush 2048
    //   73: invokevirtual 1091	java/io/BufferedInputStream:read	([BII)I
    //   76: iconst_2
    //   77: idiv
    //   78: istore 8
    //   80: iconst_0
    //   81: istore 6
    //   83: iload 8
    //   85: ifeq +82 -> 167
    //   88: iload 6
    //   90: iload 8
    //   92: iadd
    //   93: sipush 20902
    //   96: if_icmpgt +71 -> 167
    //   99: aload_1
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: aload 4
    //   105: iconst_0
    //   106: invokevirtual 1095	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   109: pop
    //   110: aload_1
    //   111: astore_3
    //   112: aload_0
    //   113: astore_2
    //   114: aload 4
    //   116: invokevirtual 1099	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   119: getstatic 954	com/tencent/mobileqq/utils/ChnToSpell:jdField_a_of_type_ArrayOfShort	[S
    //   122: iload 6
    //   124: iload 8
    //   126: sipush 20902
    //   129: iload 6
    //   131: isub
    //   132: invokestatic 1104	java/lang/Math:min	(II)I
    //   135: invokevirtual 1109	java/nio/ShortBuffer:get	([SII)Ljava/nio/ShortBuffer;
    //   138: pop
    //   139: iload 6
    //   141: iload 8
    //   143: iadd
    //   144: istore 6
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: astore_2
    //   150: aload_1
    //   151: aload 5
    //   153: iconst_0
    //   154: sipush 2048
    //   157: invokevirtual 1091	java/io/BufferedInputStream:read	([BII)I
    //   160: iconst_2
    //   161: idiv
    //   162: istore 8
    //   164: goto -81 -> 83
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 1112	java/io/BufferedInputStream:close	()V
    //   175: aload_0
    //   176: ifnull +185 -> 361
    //   179: aload_0
    //   180: invokevirtual 1115	java/io/InputStream:close	()V
    //   183: iconst_3
    //   184: istore 6
    //   186: iload 6
    //   188: iconst_1
    //   189: iadd
    //   190: istore 6
    //   192: iload 6
    //   194: istore 7
    //   196: iload 6
    //   198: iconst_3
    //   199: if_icmplt -168 -> 31
    //   202: ldc 2
    //   204: monitorexit
    //   205: return
    //   206: astore_0
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   217: goto -42 -> 175
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   225: iconst_3
    //   226: istore 6
    //   228: goto -42 -> 186
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_1
    //   238: astore_3
    //   239: aload_0
    //   240: astore_2
    //   241: ldc_w 1120
    //   244: iconst_1
    //   245: aconst_null
    //   246: aload 4
    //   248: invokestatic 1125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: ifnull +7 -> 259
    //   255: aload_1
    //   256: invokevirtual 1112	java/io/BufferedInputStream:close	()V
    //   259: iload 7
    //   261: istore 6
    //   263: aload_0
    //   264: ifnull -78 -> 186
    //   267: aload_0
    //   268: invokevirtual 1115	java/io/InputStream:close	()V
    //   271: iload 7
    //   273: istore 6
    //   275: goto -89 -> 186
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   283: iload 7
    //   285: istore 6
    //   287: goto -101 -> 186
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   295: goto -36 -> 259
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_3
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_3
    //   304: ifnull +7 -> 311
    //   307: aload_3
    //   308: invokevirtual 1112	java/io/BufferedInputStream:close	()V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 1115	java/io/InputStream:close	()V
    //   319: aload_1
    //   320: athrow
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   326: goto -15 -> 311
    //   329: astore_0
    //   330: aload_0
    //   331: invokevirtual 1118	java/io/IOException:printStackTrace	()V
    //   334: goto -15 -> 319
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_3
    //   340: goto -37 -> 303
    //   343: astore_1
    //   344: aload_2
    //   345: astore_0
    //   346: goto -43 -> 303
    //   349: astore 4
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -116 -> 237
    //   356: astore 4
    //   358: goto -121 -> 237
    //   361: iconst_3
    //   362: istore 6
    //   364: goto -178 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	135	0	localInputStream	java.io.InputStream
    //   206	5	0	localObject1	Object
    //   220	2	0	localIOException1	java.io.IOException
    //   236	32	0	localObject2	Object
    //   278	2	0	localIOException2	java.io.IOException
    //   302	14	0	localObject3	Object
    //   329	2	0	localIOException3	java.io.IOException
    //   345	1	0	localObject4	Object
    //   61	111	1	localBufferedInputStream	java.io.BufferedInputStream
    //   212	2	1	localIOException4	java.io.IOException
    //   234	22	1	localObject5	Object
    //   290	2	1	localIOException5	java.io.IOException
    //   298	22	1	localObject6	Object
    //   337	1	1	localObject7	Object
    //   343	1	1	localObject8	Object
    //   352	1	1	localObject9	Object
    //   65	176	2	localObject10	Object
    //   321	24	2	localIOException6	java.io.IOException
    //   63	277	3	localObject11	Object
    //   51	64	4	localByteBuffer	java.nio.ByteBuffer
    //   231	16	4	localException1	Exception
    //   349	1	4	localException2	Exception
    //   356	1	4	localException3	Exception
    //   26	126	5	arrayOfByte	byte[]
    //   81	282	6	i1	int
    //   29	255	7	i2	int
    //   78	85	8	i3	int
    // Exception table:
    //   from	to	target	type
    //   3	12	206	finally
    //   13	28	206	finally
    //   171	175	206	finally
    //   179	183	206	finally
    //   202	205	206	finally
    //   207	210	206	finally
    //   213	217	206	finally
    //   221	225	206	finally
    //   255	259	206	finally
    //   267	271	206	finally
    //   279	283	206	finally
    //   291	295	206	finally
    //   307	311	206	finally
    //   315	319	206	finally
    //   319	321	206	finally
    //   322	326	206	finally
    //   330	334	206	finally
    //   171	175	212	java/io/IOException
    //   179	183	220	java/io/IOException
    //   31	46	231	java/lang/Exception
    //   267	271	278	java/io/IOException
    //   255	259	290	java/io/IOException
    //   31	46	298	finally
    //   307	311	321	java/io/IOException
    //   315	319	329	java/io/IOException
    //   46	62	337	finally
    //   66	80	343	finally
    //   103	110	343	finally
    //   114	139	343	finally
    //   150	164	343	finally
    //   241	251	343	finally
    //   46	62	349	java/lang/Exception
    //   66	80	356	java/lang/Exception
    //   103	110	356	java/lang/Exception
    //   114	139	356	java/lang/Exception
    //   150	164	356	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ChnToSpell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */