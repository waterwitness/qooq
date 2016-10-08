package com.tencent.mobileqq.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Character;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import szq;

public class ParsingQrc
{
  public static final String a = "ParsingQrc";
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private static final szq jdField_a_of_type_Szq = new szq(null);
  private static final String jdField_b_of_type_JavaLangString = "offset";
  private static final Pattern jdField_b_of_type_JavaUtilRegexPattern;
  private static final String c = "LyricContent";
  private static final String d = "=";
  private static final String e = "\"";
  private static final String f = "/>";
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
    b = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
  }
  
  public ParsingQrc(String paramString)
  {
    this.g = paramString;
  }
  
  private int a(String paramString)
  {
    int j = 0;
    paramString = paramString.split("\\:");
    int i = j;
    try
    {
      if (paramString.length == 2)
      {
        i = j;
        if ("offset".equalsIgnoreCase(paramString[0])) {
          i = Integer.parseInt(paramString[1].trim());
        }
      }
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("ParsingQrc", paramString.toString());
    }
    return 0;
  }
  
  private long a(String paramString, Sentence paramSentence)
  {
    String[] arrayOfString = paramString.split("\\,");
    if (arrayOfString.length < 2)
    {
      paramString = paramString.split("\\:");
      if ((this.jdField_a_of_type_Int == 0) && (paramString[0].equalsIgnoreCase("offset"))) {
        this.jdField_a_of_type_Int = Integer.parseInt(paramString[1]);
      }
    }
    while (arrayOfString.length != 2) {
      return -1L;
    }
    try
    {
      long l1 = Long.parseLong(arrayOfString[1]);
      long l2 = Long.parseLong(arrayOfString[0]);
      paramSentence.jdField_b_of_type_Long = l1;
      paramSentence.jdField_a_of_type_Long = l2;
      return l2;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  private Character a(String paramString, int paramInt1, int paramInt2, Character paramCharacter)
  {
    long l2 = 0L;
    paramString = paramString.split("\\,");
    if (paramString.length < 2) {}
    while (paramString.length != 2) {
      return null;
    }
    long l4 = Long.parseLong(paramString[1]);
    long l3 = Long.parseLong(paramString[0]);
    long l1 = l4;
    if (l4 < 0L) {
      l1 = 0L;
    }
    if (l3 < 0L) {}
    for (;;)
    {
      return new Character(l2, l1, paramInt1, paramInt2);
      l2 = l3;
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    Object localObject3 = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    Object localObject2 = new ArrayList();
    int i = -1;
    int j = -1;
    label37:
    Object localObject1;
    if (((Matcher)localObject3).find())
    {
      localObject1 = ((Matcher)localObject3).group();
      if (localObject1 != null) {
        break label398;
      }
      localObject1 = "";
    }
    label398:
    for (;;)
    {
      int k = paramString.indexOf("[" + (String)localObject1 + "]");
      if ((j != -1) && (k - j > i + 2))
      {
        String str1 = paramString.substring(i + j + 2, k);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Sentence localSentence = new Sentence();
          if (a(str2, localSentence) != -1L)
          {
            a(str1, localSentence);
            this.jdField_a_of_type_JavaUtilArrayList.add(localSentence);
          }
        }
        ((ArrayList)localObject2).clear();
      }
      ((ArrayList)localObject2).add(localObject1);
      i = ((String)localObject1).length();
      j = k;
      break label37;
      if (((ArrayList)localObject2).isEmpty()) {
        break;
      }
      j = i + 2 + j;
      i = j;
      try
      {
        if (j > paramString.length()) {
          i = paramString.length();
        }
        paramString = paramString.substring(i).trim();
        if ((paramString.length() == 0) && (this.jdField_a_of_type_Int == 0))
        {
          paramString = ((ArrayList)localObject2).iterator();
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            i = a((String)paramString.next());
          } while (i == Integer.MAX_VALUE);
          this.jdField_a_of_type_Int = i;
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.e("ParsingQrc", paramString.toString());
        return;
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new Sentence();
        if (a((String)localObject2, (Sentence)localObject3) != -1L)
        {
          a(paramString, (Sentence)localObject3);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      break;
    }
  }
  
  private void a(String paramString, Sentence paramSentence)
  {
    label241:
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        paramSentence.jdField_a_of_type_JavaLangString = "";
        if (paramString == null) {
          break;
        }
        if (paramString.equals("")) {
          return;
        }
        Matcher localMatcher = b.matcher(paramString);
        localArrayList = new ArrayList();
        Object localObject1 = "";
        if (localMatcher.find())
        {
          Object localObject2 = localMatcher.group();
          if (localObject2 != null) {
            break label241;
          }
          localObject2 = "";
          int i = paramString.indexOf("(" + (String)localObject2 + ")");
          int j = ((String)localObject1).length();
          String str1 = (String)localObject1 + paramString.substring(0, i);
          String str2 = paramString.substring(i + ((String)localObject2).length() + 2, paramString.length());
          paramString = null;
          if (localArrayList.size() > 0) {
            paramString = (Character)localArrayList.get(localArrayList.size() - 1);
          }
          localObject2 = a((String)localObject2, j, str1.length(), paramString);
          localObject1 = str1;
          paramString = str2;
          if (localObject2 == null) {
            continue;
          }
          localArrayList.add(localObject2);
          localObject1 = str1;
          paramString = str2;
          continue;
        }
        paramSentence.jdField_a_of_type_JavaLangString = ((String)localObject1);
      }
      catch (Exception paramString)
      {
        Log.e("ParsingQrc", "", paramString);
        return;
      }
      paramSentence.jdField_b_of_type_JavaUtilArrayList = localArrayList;
      return;
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.lyric.data.Lyric a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/mobileqq/lyric/util/ParsingQrc:g	Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +68 -> 74
    //   9: aload_1
    //   10: ldc 16
    //   12: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +61 -> 76
    //   18: aload_1
    //   19: ldc 16
    //   21: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore 4
    //   26: iload 4
    //   28: iconst_m1
    //   29: if_icmpeq +45 -> 74
    //   32: aload_1
    //   33: invokevirtual 194	java/lang/String:length	()I
    //   36: ldc 16
    //   38: invokevirtual 194	java/lang/String:length	()I
    //   41: iload 4
    //   43: iadd
    //   44: iconst_1
    //   45: iadd
    //   46: if_icmple +28 -> 74
    //   49: aload_1
    //   50: iload 4
    //   52: ldc 16
    //   54: invokevirtual 194	java/lang/String:length	()I
    //   57: iadd
    //   58: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   66: ldc 19
    //   68: invokevirtual 233	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifne +11 -> 82
    //   74: aconst_null
    //   75: areturn
    //   76: iconst_m1
    //   77: istore 4
    //   79: goto -53 -> 26
    //   82: aload_1
    //   83: aload_1
    //   84: ldc 19
    //   86: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   89: ldc 19
    //   91: invokevirtual 194	java/lang/String:length	()I
    //   94: iadd
    //   95: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   103: ldc 22
    //   105: invokevirtual 233	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   108: ifeq -34 -> 74
    //   111: aload_1
    //   112: aload_1
    //   113: ldc 22
    //   115: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   118: ldc 22
    //   120: invokevirtual 194	java/lang/String:length	()I
    //   123: iadd
    //   124: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
    //   127: astore_1
    //   128: aload_1
    //   129: ldc 25
    //   131: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   134: ifeq +132 -> 266
    //   137: aload_1
    //   138: ldc 25
    //   140: invokevirtual 236	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   143: istore 4
    //   145: iload 4
    //   147: iconst_m1
    //   148: if_icmpeq -74 -> 74
    //   151: aload_1
    //   152: iconst_0
    //   153: iload 4
    //   155: invokevirtual 165	java/lang/String:substring	(II)Ljava/lang/String;
    //   158: astore_1
    //   159: aload_1
    //   160: ldc 22
    //   162: invokevirtual 230	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +107 -> 272
    //   168: aload_1
    //   169: ldc 22
    //   171: invokevirtual 236	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   174: istore 4
    //   176: iload 4
    //   178: iconst_m1
    //   179: if_icmpeq -105 -> 74
    //   182: aload_1
    //   183: iconst_0
    //   184: iload 4
    //   186: invokevirtual 165	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: astore_1
    //   190: new 238	java/io/BufferedReader
    //   193: dup
    //   194: new 240	java/io/StringReader
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 242	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   202: invokespecial 245	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   205: astore_2
    //   206: aload_2
    //   207: astore_1
    //   208: aload_2
    //   209: invokevirtual 248	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   212: astore_3
    //   213: aload_3
    //   214: ifnull +64 -> 278
    //   217: aload_2
    //   218: astore_1
    //   219: aload_0
    //   220: aload_3
    //   221: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   224: invokespecial 250	com/tencent/mobileqq/lyric/util/ParsingQrc:a	(Ljava/lang/String;)V
    //   227: goto -21 -> 206
    //   230: astore_3
    //   231: aload_2
    //   232: astore_1
    //   233: ldc 8
    //   235: aload_3
    //   236: invokevirtual 96	java/lang/Exception:toString	()Ljava/lang/String;
    //   239: invokestatic 101	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: aload_2
    //   244: ifnull -170 -> 74
    //   247: aload_2
    //   248: invokevirtual 253	java/io/BufferedReader:close	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_1
    //   254: ldc 8
    //   256: aload_1
    //   257: invokevirtual 254	java/io/IOException:toString	()Ljava/lang/String;
    //   260: invokestatic 101	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aconst_null
    //   265: areturn
    //   266: iconst_m1
    //   267: istore 4
    //   269: goto -124 -> 145
    //   272: iconst_m1
    //   273: istore 4
    //   275: goto -99 -> 176
    //   278: aload_2
    //   279: astore_1
    //   280: aload_0
    //   281: getfield 67	com/tencent/mobileqq/lyric/util/ParsingQrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   284: getstatic 58	com/tencent/mobileqq/lyric/util/ParsingQrc:jdField_a_of_type_Szq	Lszq;
    //   287: invokestatic 260	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   290: aload_2
    //   291: astore_1
    //   292: new 262	com/tencent/mobileqq/lyric/data/Lyric
    //   295: dup
    //   296: iconst_2
    //   297: aload_0
    //   298: getfield 106	com/tencent/mobileqq/lyric/util/ParsingQrc:jdField_a_of_type_Int	I
    //   301: aload_0
    //   302: getfield 67	com/tencent/mobileqq/lyric/util/ParsingQrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   305: invokespecial 265	com/tencent/mobileqq/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   308: astore_3
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 253	java/io/BufferedReader:close	()V
    //   317: aload_3
    //   318: areturn
    //   319: astore_1
    //   320: ldc 8
    //   322: aload_1
    //   323: invokevirtual 254	java/io/IOException:toString	()Ljava/lang/String;
    //   326: invokestatic 101	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   329: pop
    //   330: goto -13 -> 317
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 253	java/io/BufferedReader:close	()V
    //   344: aload_2
    //   345: athrow
    //   346: astore_1
    //   347: ldc 8
    //   349: aload_1
    //   350: invokevirtual 254	java/io/IOException:toString	()Ljava/lang/String;
    //   353: invokestatic 101	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   356: pop
    //   357: goto -13 -> 344
    //   360: astore_2
    //   361: goto -25 -> 336
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -136 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	ParsingQrc
    //   4	229	1	localObject1	Object
    //   253	4	1	localIOException1	java.io.IOException
    //   279	13	1	localObject2	Object
    //   319	4	1	localIOException2	java.io.IOException
    //   335	6	1	localObject3	Object
    //   346	4	1	localIOException3	java.io.IOException
    //   205	109	2	localBufferedReader	java.io.BufferedReader
    //   333	12	2	localObject4	Object
    //   360	1	2	localObject5	Object
    //   366	1	2	localObject6	Object
    //   212	9	3	str	String
    //   230	6	3	localException1	Exception
    //   308	10	3	localLyric	com.tencent.mobileqq.lyric.data.Lyric
    //   364	1	3	localException2	Exception
    //   24	250	4	i	int
    // Exception table:
    //   from	to	target	type
    //   208	213	230	java/lang/Exception
    //   219	227	230	java/lang/Exception
    //   280	290	230	java/lang/Exception
    //   292	309	230	java/lang/Exception
    //   247	251	253	java/io/IOException
    //   313	317	319	java/io/IOException
    //   190	206	333	finally
    //   340	344	346	java/io/IOException
    //   208	213	360	finally
    //   219	227	360	finally
    //   233	243	360	finally
    //   280	290	360	finally
    //   292	309	360	finally
    //   190	206	364	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\util\ParsingQrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */