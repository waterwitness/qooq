package com.tencent.mobileqq.lyric.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import szo;

public class ParsingLrc
{
  public static final String a = "ParsingLrc";
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private static final szo jdField_a_of_type_Szo = new szo(null);
  private static final String c = "offset";
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ParsingLrc(String paramString)
  {
    this.b = paramString;
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
      Log.e("ParsingLrc", paramString.toString());
    }
    return 0;
  }
  
  private long a(String paramString)
  {
    paramString = paramString.split("\\:|\\.");
    if (paramString.length < 2) {}
    do
    {
      return -1L;
      if (paramString.length == 2) {}
      int i;
      int j;
      int k;
      try
      {
        if ((this.jdField_a_of_type_Int == 0) && (paramString[0].equalsIgnoreCase("offset")))
        {
          this.jdField_a_of_type_Int = Integer.parseInt(paramString[1]);
          return -1L;
        }
        i = Integer.parseInt(paramString[0]);
        j = Integer.parseInt(paramString[1]);
        if ((i < 0) || (j < 0) || (j >= 60)) {
          throw new RuntimeException("数字不合法!");
        }
        return (i * 60 + j) * 1000L;
      }
      catch (Exception paramString) {}
    } while (paramString.length != 3);
    try
    {
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      k = Integer.parseInt(paramString[2]);
      if ((i < 0) || (j < 0) || (j >= 60) || (k < 0) || (k > 99)) {
        throw new RuntimeException("数字不合法!");
      }
    }
    catch (Exception paramString)
    {
      return -1L;
    }
    return (i * 60 + j) * 1000L + k * 10;
    return -1L;
  }
  
  private Lyric a(String paramString)
  {
    if (a(paramString)) {
      return null;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new BufferedReader(new StringReader(paramString));
        for (;;)
        {
          String str = paramString.readLine();
          if (str == null) {
            break;
          }
          Sentence localSentence = new Sentence();
          localSentence.jdField_a_of_type_JavaLangString = str.trim();
          localSentence.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_JavaUtilArrayList.add(localSentence);
        }
      }
      return new Lyric(3, 0, this.jdField_a_of_type_JavaUtilArrayList);
    }
    catch (Exception paramString)
    {
      paramString = new Sentence();
      paramString.jdField_a_of_type_JavaLangString = "这个歌词是纯txt文本，请自己滑动歌词查看";
      paramString.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, paramString);
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    Object localObject2 = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    int j = -1;
    label37:
    Object localObject1;
    if (((Matcher)localObject2).find())
    {
      localObject1 = ((Matcher)localObject2).group();
      if (localObject1 != null) {
        break label451;
      }
      localObject1 = "";
    }
    label451:
    for (;;)
    {
      int k = paramString.indexOf("[" + (String)localObject1 + "]");
      long l;
      if ((j != -1) && (k - j > i + 2))
      {
        String str = paramString.substring(i + j + 2, k);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          l = a((String)localIterator.next());
          if (l != -1L)
          {
            Sentence localSentence = new Sentence();
            localSentence.jdField_a_of_type_JavaLangString = str;
            localSentence.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilArrayList.add(localSentence);
          }
        }
        localArrayList.clear();
      }
      localArrayList.add(localObject1);
      i = ((String)localObject1).length();
      j = k;
      break label37;
      if (localArrayList.isEmpty()) {
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
          paramString = localArrayList.iterator();
          while (paramString.hasNext())
          {
            i = a((String)paramString.next());
            if (i != Integer.MAX_VALUE) {
              this.jdField_a_of_type_Int = i;
            }
          }
          return;
        }
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = a((String)((Iterator)localObject1).next());
          if ((l != -1L) && (paramString.length() > 0))
          {
            localObject2 = new Sentence();
            ((Sentence)localObject2).jdField_a_of_type_JavaLangString = paramString;
            ((Sentence)localObject2).jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
      }
      catch (Exception paramString)
      {
        Log.e("ParsingLrc", paramString.toString());
        return;
        return;
      }
      finally
      {
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new BufferedReader(new StringReader(paramString));
        int j = 0;
        int i = 0;
        int k;
        int m;
        do
        {
          String str = paramString.readLine();
          k = j;
          if (str != null)
          {
            bool1 = jdField_a_of_type_JavaUtilRegexPattern.matcher(str).find();
            k = j;
            if (bool1) {
              k = j + 1;
            }
          }
          m = i + 1;
          j = k;
          i = m;
        } while (m < 3);
        bool1 = bool2;
        if (k == 3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  public Lyric a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/mobileqq/lyric/util/ParsingLrc:b	Ljava/lang/String;
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: areturn
    //   11: aload_0
    //   12: getfield 53	com/tencent/mobileqq/lyric/util/ParsingLrc:b	Ljava/lang/String;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +64 -> 81
    //   20: new 112	java/io/BufferedReader
    //   23: dup
    //   24: new 114	java/io/StringReader
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 115	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +41 -> 83
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 72	java/lang/String:trim	()Ljava/lang/String;
    //   50: invokespecial 215	com/tencent/mobileqq/lyric/util/ParsingLrc:a	(Ljava/lang/String;)V
    //   53: goto -17 -> 36
    //   56: astore 4
    //   58: aload_3
    //   59: astore_2
    //   60: aload 4
    //   62: astore_3
    //   63: ldc 8
    //   65: aload_3
    //   66: invokevirtual 80	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokestatic 86	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 218	java/io/BufferedReader:close	()V
    //   81: aconst_null
    //   82: areturn
    //   83: aload_0
    //   84: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: getstatic 42	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_Szo	Lszo;
    //   90: invokestatic 224	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   93: iconst_0
    //   94: istore 5
    //   96: iload 5
    //   98: aload_0
    //   99: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   102: invokevirtual 227	java/util/ArrayList:size	()I
    //   105: if_icmpge +100 -> 205
    //   108: iload 5
    //   110: aload_0
    //   111: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   114: invokevirtual 227	java/util/ArrayList:size	()I
    //   117: iconst_1
    //   118: isub
    //   119: if_icmpge +54 -> 173
    //   122: aload_0
    //   123: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: iload 5
    //   128: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   131: checkcast 123	com/tencent/mobileqq/lyric/data/Sentence
    //   134: aload_0
    //   135: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   138: iload 5
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   145: checkcast 123	com/tencent/mobileqq/lyric/data/Sentence
    //   148: getfield 129	com/tencent/mobileqq/lyric/data/Sentence:jdField_a_of_type_Long	J
    //   151: aload_0
    //   152: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   155: iload 5
    //   157: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   160: checkcast 123	com/tencent/mobileqq/lyric/data/Sentence
    //   163: getfield 129	com/tencent/mobileqq/lyric/data/Sentence:jdField_a_of_type_Long	J
    //   166: lsub
    //   167: putfield 233	com/tencent/mobileqq/lyric/data/Sentence:b	J
    //   170: goto +131 -> 301
    //   173: aload_0
    //   174: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   177: iload 5
    //   179: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   182: checkcast 123	com/tencent/mobileqq/lyric/data/Sentence
    //   185: ldc2_w 234
    //   188: putfield 233	com/tencent/mobileqq/lyric/data/Sentence:b	J
    //   191: goto +110 -> 301
    //   194: astore_2
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 218	java/io/BufferedReader:close	()V
    //   203: aload_2
    //   204: athrow
    //   205: new 140	com/tencent/mobileqq/lyric/data/Lyric
    //   208: dup
    //   209: iconst_1
    //   210: aload_0
    //   211: getfield 93	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_Int	I
    //   214: aload_0
    //   215: getfield 51	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   218: invokespecial 143	com/tencent/mobileqq/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   221: astore 4
    //   223: aload 4
    //   225: astore_2
    //   226: aload_3
    //   227: ifnull -218 -> 9
    //   230: aload_3
    //   231: invokevirtual 218	java/io/BufferedReader:close	()V
    //   234: aload 4
    //   236: areturn
    //   237: astore_2
    //   238: ldc 8
    //   240: aload_2
    //   241: invokevirtual 236	java/io/IOException:toString	()Ljava/lang/String;
    //   244: invokestatic 86	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: aload 4
    //   250: areturn
    //   251: astore_2
    //   252: ldc 8
    //   254: aload_2
    //   255: invokevirtual 236	java/io/IOException:toString	()Ljava/lang/String;
    //   258: invokestatic 86	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: goto -181 -> 81
    //   265: astore_3
    //   266: ldc 8
    //   268: aload_3
    //   269: invokevirtual 236	java/io/IOException:toString	()Ljava/lang/String;
    //   272: invokestatic 86	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: goto -73 -> 203
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_3
    //   282: goto -87 -> 195
    //   285: astore 4
    //   287: aload_2
    //   288: astore_3
    //   289: aload 4
    //   291: astore_2
    //   292: goto -97 -> 195
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -235 -> 63
    //   301: iload 5
    //   303: iconst_1
    //   304: iadd
    //   305: istore 5
    //   307: goto -211 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	ParsingLrc
    //   0	310	1	paramBoolean	boolean
    //   8	70	2	localObject1	Object
    //   194	10	2	localObject2	Object
    //   225	1	2	localObject3	Object
    //   237	4	2	localIOException1	java.io.IOException
    //   251	4	2	localIOException2	java.io.IOException
    //   279	9	2	localObject4	Object
    //   291	7	2	localObject5	Object
    //   35	196	3	localObject6	Object
    //   265	4	3	localIOException3	java.io.IOException
    //   281	8	3	localObject7	Object
    //   295	1	3	localException1	Exception
    //   56	5	4	localException2	Exception
    //   221	28	4	localLyric	Lyric
    //   285	5	4	localObject8	Object
    //   94	212	5	i	int
    // Exception table:
    //   from	to	target	type
    //   36	41	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   83	93	56	java/lang/Exception
    //   96	170	56	java/lang/Exception
    //   173	191	56	java/lang/Exception
    //   205	223	56	java/lang/Exception
    //   36	41	194	finally
    //   45	53	194	finally
    //   83	93	194	finally
    //   96	170	194	finally
    //   173	191	194	finally
    //   205	223	194	finally
    //   230	234	237	java/io/IOException
    //   77	81	251	java/io/IOException
    //   199	203	265	java/io/IOException
    //   20	36	279	finally
    //   63	73	285	finally
    //   20	36	295	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\util\ParsingLrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */