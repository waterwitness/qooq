package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class SearchStatisticsConstants
{
  public static final int a = 2;
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public static final int b = 4;
  public static final int c = 8;
  public static final int d = 16;
  private static int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_JavaLangString = "";
      e = 0;
      jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void a(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: lookupswitch	default:+92->96, 20:+96->100, 30:+96->100, 40:+96->100, 50:+96->100, 60:+96->100, 70:+96->100, 80:+96->100, 90:+96->100, 100:+96->100, 110:+96->100
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: getstatic 57	com/tencent/mobileqq/search/util/SearchStatisticsConstants:e	I
    //   103: iconst_1
    //   104: iadd
    //   105: putstatic 57	com/tencent/mobileqq/search/util/SearchStatisticsConstants:e	I
    //   108: new 63	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   115: getstatic 28	com/tencent/mobileqq/search/util/SearchStatisticsConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_0
    //   122: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 73
    //   127: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: putstatic 28	com/tencent/mobileqq/search/util/SearchStatisticsConstants:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   136: getstatic 35	com/tencent/mobileqq/search/util/SearchStatisticsConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   139: iload_0
    //   140: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: getstatic 57	com/tencent/mobileqq/search/util/SearchStatisticsConstants:e	I
    //   146: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: invokeinterface 80 3 0
    //   154: pop
    //   155: goto -59 -> 96
    //   158: astore_1
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInt	int
    //   158	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	155	158	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\util\SearchStatisticsConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */