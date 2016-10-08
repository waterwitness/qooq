package com.tencent.mobileqq.app;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.util.StringUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qdj;

public class ProcessStats
{
  public static int a = 0;
  public static long a = 0L;
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  public static ProcessStats.Stats a;
  private static final String jdField_a_of_type_JavaLangString = "ProcessStats";
  private static Map jdField_a_of_type_JavaUtilMap;
  public static int b = 0;
  private static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "-2";
  private static Map jdField_b_of_type_JavaUtilMap;
  private static final int jdField_c_of_type_Int = 100;
  private static long jdField_c_of_type_Long = 0L;
  private static final String jdField_c_of_type_JavaLangString = "-1";
  private static int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(ProcessStats.Stats.class, 30);
    jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats = (ProcessStats.Stats)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(ProcessStats.Stats.class);
    jdField_a_of_type_JavaUtilMap = new HashMap(30);
    jdField_b_of_type_JavaUtilMap = new HashMap(20);
    jdField_b_of_type_Int = -1;
  }
  
  public static final int a()
  {
    if (jdField_b_of_type_Int == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (jdField_b_of_type_Int = Runtime.getRuntime().availableProcessors();; jdField_b_of_type_Int = b()) {
      return jdField_b_of_type_Int;
    }
  }
  
  private static final RandomAccessFile a(String paramString)
  {
    Object localObject1 = (RandomAccessFile)jdField_b_of_type_JavaUtilMap.get(paramString);
    Object localObject2 = localObject1;
    if ((localObject1 != null) || (paramString == "-2")) {}
    for (;;)
    {
      try
      {
        localObject2 = new RandomAccessFile("/proc/stat", "r");
        localObject1 = localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        continue;
      }
      jdField_b_of_type_JavaUtilMap.put(paramString, localObject1);
      localObject2 = localObject1;
      return (RandomAccessFile)localObject2;
      if (paramString == "-1")
      {
        localObject2 = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + paramString + "/stat", "r");
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public static final String a(int paramInt)
  {
    // Byte code:
    //   0: new 103	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 133	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_3
    //   12: ldc 23
    //   14: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   17: iconst_0
    //   18: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   21: ldc -118
    //   23: new 103	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   30: ldc -116
    //   32: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   38: getfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   41: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc -109
    //   46: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   52: getfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   55: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 154	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: new 156	java/io/BufferedReader
    //   68: dup
    //   69: new 158	java/io/InputStreamReader
    //   72: dup
    //   73: invokestatic 74	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   76: new 103	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   83: ldc -96
    //   85: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc -94
    //   94: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 166	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   103: invokevirtual 172	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   106: invokespecial 175	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: invokespecial 178	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 181	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   117: astore_2
    //   118: aload_2
    //   119: ifnull +46 -> 165
    //   122: aload_3
    //   123: aload_2
    //   124: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc -73
    //   129: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -20 -> 113
    //   136: astore_1
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 185	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 185	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: areturn
    //   165: ldc 23
    //   167: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   170: iconst_0
    //   171: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   174: ldc -118
    //   176: new 103	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   183: ldc -116
    //   185: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   191: getfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   194: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc -109
    //   199: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   205: getfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   208: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 154	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_3
    //   219: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore_1
    //   223: iconst_0
    //   224: ifeq +11 -> 235
    //   227: new 185	java/lang/NullPointerException
    //   230: dup
    //   231: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   234: athrow
    //   235: aload_1
    //   236: astore_2
    //   237: iconst_0
    //   238: ifeq -75 -> 163
    //   241: new 185	java/lang/NullPointerException
    //   244: dup
    //   245: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   248: athrow
    //   249: astore_2
    //   250: aload_1
    //   251: areturn
    //   252: astore_1
    //   253: iconst_0
    //   254: ifeq +11 -> 265
    //   257: new 185	java/lang/NullPointerException
    //   260: dup
    //   261: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   264: athrow
    //   265: iconst_0
    //   266: ifeq +11 -> 277
    //   269: new 185	java/lang/NullPointerException
    //   272: dup
    //   273: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: astore_2
    //   280: goto -45 -> 235
    //   283: astore_1
    //   284: goto -135 -> 149
    //   287: astore_1
    //   288: goto -127 -> 161
    //   291: astore_2
    //   292: goto -27 -> 265
    //   295: astore_2
    //   296: goto -19 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramInt	int
    //   112	2	1	localBufferedReader	java.io.BufferedReader
    //   136	1	1	localException1	Exception
    //   222	29	1	str1	String
    //   252	26	1	localObject	Object
    //   283	1	1	localException2	Exception
    //   287	1	1	localException3	Exception
    //   117	120	2	str2	String
    //   249	1	2	localException4	Exception
    //   279	1	2	localException5	Exception
    //   291	1	2	localException6	Exception
    //   295	1	2	localException7	Exception
    //   11	208	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	113	136	java/lang/Exception
    //   113	118	136	java/lang/Exception
    //   122	133	136	java/lang/Exception
    //   165	223	136	java/lang/Exception
    //   241	249	249	java/lang/Exception
    //   0	113	252	finally
    //   113	118	252	finally
    //   122	133	252	finally
    //   165	223	252	finally
    //   227	235	279	java/lang/Exception
    //   141	149	283	java/lang/Exception
    //   153	161	287	java/lang/Exception
    //   257	265	291	java/lang/Exception
    //   269	277	295	java/lang/Exception
  }
  
  public static final List a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    Object localObject2;
    int i;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject2 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
      localObject1 = new HashMap(localObject2.length);
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          ((Map)localObject1).put(((Thread)localObject3).getName(), localObject3);
        }
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = new ArrayList(jdField_a_of_type_JavaUtilMap.size() / 2);
      localObject3 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (String)((Iterator)localObject3).next();
        ProcessStats.Stats localStats = (ProcessStats.Stats)jdField_a_of_type_JavaUtilMap.get(localObject4);
        if (localStats.jdField_a_of_type_Int >= paramInt)
        {
          if (paramBoolean) {}
          StringBuilder localStringBuilder;
          for (i = 300;; i = 50)
          {
            localStringBuilder = new StringBuilder(i);
            localStringBuilder.append(localStats.jdField_a_of_type_JavaLangString).append("_").append((String)localObject4).append(":").append(localStats.jdField_a_of_type_Int).append("\r\n");
            if (!paramBoolean) {
              break;
            }
            localObject4 = (Thread)((Map)localObject1).get(localStats.jdField_a_of_type_JavaLangString);
            if (localObject4 != null) {
              localStringBuilder.append(Arrays.toString(((Thread)localObject4).getStackTrace()));
            }
            localObject4 = StringUtils.getStringValue(localStringBuilder);
            if (localObject4 == null) {
              break label302;
            }
            ((List)localObject2).add(StringUtils.newStringWithData((char[])localObject4));
            break;
          }
          label302:
          ((List)localObject2).add(localStringBuilder.toString());
        }
      }
      if (paramBoolean) {
        ((List)localObject2).add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
      }
      return (List)localObject2;
    }
  }
  
  /* Error */
  private static void a(String paramString, ProcessStats.Stats paramStats, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 282	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   6: astore_0
    //   7: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   10: sipush 1024
    //   13: invokevirtual 292	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   16: astore 5
    //   18: aload_0
    //   19: lconst_0
    //   20: invokevirtual 296	java/io/RandomAccessFile:seek	(J)V
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 300	java/io/RandomAccessFile:read	([B)I
    //   29: pop
    //   30: new 238	java/lang/String
    //   33: dup
    //   34: aload 5
    //   36: invokespecial 303	java/lang/String:<init>	([B)V
    //   39: astore_0
    //   40: aload_0
    //   41: ldc_w 305
    //   44: invokevirtual 309	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: iconst_1
    //   50: aaload
    //   51: iconst_1
    //   52: aload_3
    //   53: iconst_1
    //   54: aaload
    //   55: invokevirtual 312	java/lang/String:length	()I
    //   58: iconst_1
    //   59: isub
    //   60: invokevirtual 316	java/lang/String:substring	(II)Ljava/lang/String;
    //   63: astore 4
    //   65: aload_3
    //   66: bipush 13
    //   68: aaload
    //   69: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore 6
    //   74: aload_3
    //   75: bipush 14
    //   77: aaload
    //   78: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 8
    //   83: iload_2
    //   84: ifeq +55 -> 139
    //   87: aload_1
    //   88: lload 6
    //   90: putfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   93: aload_1
    //   94: lload 8
    //   96: putfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   99: aload_1
    //   100: aload 4
    //   102: putfield 242	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: aload_0
    //   106: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +21 -> 130
    //   112: iload_2
    //   113: ifeq +156 -> 269
    //   116: aload_1
    //   117: ldc2_w 329
    //   120: putfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   123: aload_1
    //   124: ldc2_w 329
    //   127: putfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   130: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   133: aload 5
    //   135: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   138: return
    //   139: aload_1
    //   140: getfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   143: ldc2_w 329
    //   146: lcmp
    //   147: ifne +55 -> 202
    //   150: aload_1
    //   151: ldc2_w 329
    //   154: putfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   157: aload_1
    //   158: ldc2_w 329
    //   161: putfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   164: goto -59 -> 105
    //   167: astore_0
    //   168: aconst_null
    //   169: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifeq +21 -> 193
    //   175: iload_2
    //   176: ifeq +110 -> 286
    //   179: aload_1
    //   180: ldc2_w 329
    //   183: putfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   186: aload_1
    //   187: ldc2_w 329
    //   190: putfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   193: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   196: aload 5
    //   198: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   201: return
    //   202: aload_1
    //   203: lload 6
    //   205: aload_1
    //   206: getfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   209: lsub
    //   210: putfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   213: aload_1
    //   214: lload 8
    //   216: aload_1
    //   217: getfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   220: lsub
    //   221: putfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   224: goto -119 -> 105
    //   227: astore 4
    //   229: aload_0
    //   230: astore_3
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: invokestatic 328	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifeq +21 -> 259
    //   241: iload_2
    //   242: ifeq +61 -> 303
    //   245: aload_1
    //   246: ldc2_w 329
    //   249: putfield 149	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_b_of_type_Long	J
    //   252: aload_1
    //   253: ldc2_w 329
    //   256: putfield 142	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Long	J
    //   259: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   262: aload 5
    //   264: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   267: aload_0
    //   268: athrow
    //   269: aload_1
    //   270: ldc2_w 329
    //   273: putfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   276: aload_1
    //   277: ldc2_w 329
    //   280: putfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   283: goto -153 -> 130
    //   286: aload_1
    //   287: ldc2_w 329
    //   290: putfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   293: aload_1
    //   294: ldc2_w 329
    //   297: putfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   300: goto -107 -> 193
    //   303: aload_1
    //   304: ldc2_w 329
    //   307: putfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   310: aload_1
    //   311: ldc2_w 329
    //   314: putfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   317: goto -58 -> 259
    //   320: astore_0
    //   321: goto -87 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramString	String
    //   0	324	1	paramStats	ProcessStats.Stats
    //   0	324	2	paramBoolean	boolean
    //   1	234	3	localObject1	Object
    //   63	38	4	str	String
    //   227	5	4	localObject2	Object
    //   16	247	5	arrayOfByte	byte[]
    //   72	132	6	l1	long
    //   81	134	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   18	40	167	java/lang/Exception
    //   40	83	167	java/lang/Exception
    //   87	105	167	java/lang/Exception
    //   139	164	167	java/lang/Exception
    //   202	224	167	java/lang/Exception
    //   40	83	227	finally
    //   87	105	227	finally
    //   139	164	227	finally
    //   202	224	227	finally
    //   18	40	320	finally
  }
  
  private static final void a(Set paramSet)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramSet.contains(localObject)) && (!((String)localObject).equals("-2")) && (!((String)localObject).equals("-1")))
      {
        localObject = (RandomAccessFile)jdField_b_of_type_JavaUtilMap.get(localObject);
        localIterator.remove();
        try
        {
          ((RandomAccessFile)localObject).close();
        }
        catch (Exception localException) {}
      }
    }
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 292	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore_1
    //   10: ldc 19
    //   12: invokestatic 282	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   15: astore_2
    //   16: aload_2
    //   17: lconst_0
    //   18: invokevirtual 296	java/io/RandomAccessFile:seek	(J)V
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 300	java/io/RandomAccessFile:read	([B)I
    //   26: pop
    //   27: new 238	java/lang/String
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 303	java/lang/String:<init>	([B)V
    //   35: ldc_w 305
    //   38: invokevirtual 309	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: iconst_4
    //   44: aaload
    //   45: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   48: putstatic 354	com/tencent/mobileqq/app/ProcessStats:jdField_b_of_type_Long	J
    //   51: aload_2
    //   52: iconst_1
    //   53: aaload
    //   54: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   57: lstore 7
    //   59: aload_2
    //   60: iconst_2
    //   61: aaload
    //   62: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   65: lstore 9
    //   67: aload_2
    //   68: iconst_3
    //   69: aaload
    //   70: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   73: lstore 11
    //   75: aload_2
    //   76: iconst_5
    //   77: aaload
    //   78: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 13
    //   83: aload_2
    //   84: bipush 6
    //   86: aaload
    //   87: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   90: lstore 15
    //   92: aload_2
    //   93: bipush 7
    //   95: aaload
    //   96: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   99: lstore 17
    //   101: aload_2
    //   102: bipush 8
    //   104: aaload
    //   105: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   108: lload 7
    //   110: lload 9
    //   112: ladd
    //   113: lload 11
    //   115: ladd
    //   116: lload 13
    //   118: ladd
    //   119: lload 15
    //   121: ladd
    //   122: lload 17
    //   124: ladd
    //   125: ladd
    //   126: putstatic 355	com/tencent/mobileqq/app/ProcessStats:c	J
    //   129: ldc 23
    //   131: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   134: iconst_1
    //   135: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   138: iload_0
    //   139: ifeq +134 -> 273
    //   142: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   145: invokeinterface 359 1 0
    //   150: invokeinterface 362 1 0
    //   155: astore_2
    //   156: aload_2
    //   157: invokeinterface 232 1 0
    //   162: ifeq +31 -> 193
    //   165: aload_2
    //   166: invokeinterface 236 1 0
    //   171: checkcast 36	com/tencent/mobileqq/app/ProcessStats$Stats
    //   174: invokevirtual 365	com/tencent/mobileqq/app/ProcessStats$Stats:recycle	()V
    //   177: goto -21 -> 156
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 366	java/io/IOException:printStackTrace	()V
    //   185: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   188: aload_1
    //   189: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   192: return
    //   193: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   196: invokeinterface 369 1 0
    //   201: invokestatic 115	android/os/Process:myPid	()I
    //   204: i2l
    //   205: invokestatic 372	com/tencent/mobileqq/app/ProcessStats:a	(J)[Ljava/lang/String;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnull +63 -> 273
    //   213: aload_2
    //   214: arraylength
    //   215: istore 6
    //   217: iconst_0
    //   218: istore 5
    //   220: iload 5
    //   222: iload 6
    //   224: if_icmpge +49 -> 273
    //   227: aload_2
    //   228: iload 5
    //   230: aaload
    //   231: astore_3
    //   232: getstatic 42	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   235: ldc 36
    //   237: invokevirtual 46	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   240: checkcast 36	com/tencent/mobileqq/app/ProcessStats$Stats
    //   243: astore 4
    //   245: aload_3
    //   246: aload 4
    //   248: iconst_1
    //   249: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   252: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   255: aload_3
    //   256: aload 4
    //   258: invokeinterface 101 3 0
    //   263: pop
    //   264: iload 5
    //   266: iconst_1
    //   267: iadd
    //   268: istore 5
    //   270: goto -50 -> 220
    //   273: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   276: aload_1
    //   277: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   280: return
    //   281: astore_2
    //   282: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   285: aload_1
    //   286: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   289: aload_2
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramBoolean	boolean
    //   9	277	1	arrayOfByte	byte[]
    //   15	151	2	localObject1	Object
    //   180	2	2	localIOException	java.io.IOException
    //   208	20	2	arrayOfString	String[]
    //   281	9	2	localObject2	Object
    //   231	25	3	str	String
    //   243	14	4	localStats	ProcessStats.Stats
    //   218	51	5	i	int
    //   215	10	6	j	int
    //   57	52	7	l1	long
    //   65	46	9	l2	long
    //   73	41	11	l3	long
    //   81	36	13	l4	long
    //   90	30	15	l5	long
    //   99	24	17	l6	long
    // Exception table:
    //   from	to	target	type
    //   10	138	180	java/io/IOException
    //   142	156	180	java/io/IOException
    //   156	177	180	java/io/IOException
    //   193	209	180	java/io/IOException
    //   213	217	180	java/io/IOException
    //   232	264	180	java/io/IOException
    //   10	138	281	finally
    //   142	156	281	finally
    //   156	177	281	finally
    //   181	185	281	finally
    //   193	209	281	finally
    //   213	217	281	finally
    //   232	264	281	finally
  }
  
  private static final String[] a(long paramLong)
  {
    File localFile = new File("/proc/" + paramLong + "/task");
    if ((localFile.exists()) && (localFile.isDirectory())) {
      return localFile.list();
    }
    return null;
  }
  
  private static final int b()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new qdj()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  /* Error */
  public static void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3: sipush 1024
    //   6: invokevirtual 292	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   9: astore_1
    //   10: ldc 19
    //   12: invokestatic 282	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   15: astore_2
    //   16: aload_2
    //   17: lconst_0
    //   18: invokevirtual 296	java/io/RandomAccessFile:seek	(J)V
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 300	java/io/RandomAccessFile:read	([B)I
    //   26: pop
    //   27: new 238	java/lang/String
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 303	java/lang/String:<init>	([B)V
    //   35: ldc_w 305
    //   38: invokevirtual 309	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: iconst_4
    //   44: aaload
    //   45: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   48: lstore 7
    //   50: aload_2
    //   51: iconst_1
    //   52: aaload
    //   53: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   56: aload_2
    //   57: iconst_2
    //   58: aaload
    //   59: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   62: ladd
    //   63: aload_2
    //   64: iconst_3
    //   65: aaload
    //   66: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: ladd
    //   70: aload_2
    //   71: iconst_5
    //   72: aaload
    //   73: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   76: ladd
    //   77: aload_2
    //   78: bipush 6
    //   80: aaload
    //   81: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: ladd
    //   85: aload_2
    //   86: bipush 7
    //   88: aaload
    //   89: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   92: ladd
    //   93: aload_2
    //   94: bipush 8
    //   96: aaload
    //   97: invokestatic 322	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   100: ladd
    //   101: lstore 5
    //   103: lload 5
    //   105: lload 7
    //   107: ladd
    //   108: getstatic 355	com/tencent/mobileqq/app/ProcessStats:c	J
    //   111: lsub
    //   112: getstatic 354	com/tencent/mobileqq/app/ProcessStats:jdField_b_of_type_Long	J
    //   115: lsub
    //   116: lstore 7
    //   118: ldc 23
    //   120: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   123: iconst_0
    //   124: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   127: iload_0
    //   128: ifeq +124 -> 252
    //   131: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   134: invokeinterface 220 1 0
    //   139: invokeinterface 226 1 0
    //   144: astore_2
    //   145: aload_2
    //   146: invokeinterface 232 1 0
    //   151: ifeq +70 -> 221
    //   154: aload_2
    //   155: invokeinterface 236 1 0
    //   160: checkcast 238	java/lang/String
    //   163: astore_3
    //   164: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   167: aload_3
    //   168: invokeinterface 88 2 0
    //   173: checkcast 36	com/tencent/mobileqq/app/ProcessStats$Stats
    //   176: astore 4
    //   178: aload_3
    //   179: aload 4
    //   181: iconst_0
    //   182: invokestatic 136	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/ProcessStats$Stats;Z)V
    //   185: aload 4
    //   187: aload 4
    //   189: getfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   192: aload 4
    //   194: getfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   197: ladd
    //   198: ldc2_w 399
    //   201: lmul
    //   202: lload 7
    //   204: ldiv
    //   205: l2i
    //   206: putfield 240	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Int	I
    //   209: goto -64 -> 145
    //   212: astore_2
    //   213: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   216: aload_1
    //   217: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   220: return
    //   221: getstatic 402	com/tencent/mobileqq/app/ProcessStats:d	I
    //   224: iconst_1
    //   225: iadd
    //   226: putstatic 402	com/tencent/mobileqq/app/ProcessStats:d	I
    //   229: getstatic 402	com/tencent/mobileqq/app/ProcessStats:d	I
    //   232: bipush 8
    //   234: if_icmplt +18 -> 252
    //   237: getstatic 55	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   240: invokeinterface 220 1 0
    //   245: invokestatic 404	com/tencent/mobileqq/app/ProcessStats:a	(Ljava/util/Set;)V
    //   248: iconst_0
    //   249: putstatic 402	com/tencent/mobileqq/app/ProcessStats:d	I
    //   252: lload 5
    //   254: getstatic 355	com/tencent/mobileqq/app/ProcessStats:c	J
    //   257: lsub
    //   258: ldc2_w 399
    //   261: lmul
    //   262: lload 7
    //   264: ldiv
    //   265: l2i
    //   266: putstatic 405	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_Int	I
    //   269: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   272: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   275: getfield 337	com/tencent/mobileqq/app/ProcessStats$Stats:d	J
    //   278: getstatic 48	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_ComTencentMobileqqAppProcessStats$Stats	Lcom/tencent/mobileqq/app/ProcessStats$Stats;
    //   281: getfield 335	com/tencent/mobileqq/app/ProcessStats$Stats:c	J
    //   284: ladd
    //   285: ldc2_w 399
    //   288: lmul
    //   289: lload 7
    //   291: ldiv
    //   292: l2i
    //   293: putfield 240	com/tencent/mobileqq/app/ProcessStats$Stats:jdField_a_of_type_Int	I
    //   296: invokestatic 411	android/os/SystemClock:uptimeMillis	()J
    //   299: putstatic 412	com/tencent/mobileqq/app/ProcessStats:jdField_a_of_type_Long	J
    //   302: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   305: aload_1
    //   306: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   309: return
    //   310: astore_2
    //   311: invokestatic 288	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   314: aload_1
    //   315: invokevirtual 333	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   318: aload_2
    //   319: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramBoolean	boolean
    //   9	306	1	arrayOfByte	byte[]
    //   15	140	2	localObject1	Object
    //   212	1	2	localException	Exception
    //   310	9	2	localObject2	Object
    //   163	16	3	str	String
    //   176	17	4	localStats	ProcessStats.Stats
    //   101	152	5	l1	long
    //   48	242	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   10	127	212	java/lang/Exception
    //   131	145	212	java/lang/Exception
    //   145	209	212	java/lang/Exception
    //   221	252	212	java/lang/Exception
    //   252	302	212	java/lang/Exception
    //   10	127	310	finally
    //   131	145	310	finally
    //   145	209	310	finally
    //   221	252	310	finally
    //   252	302	310	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ProcessStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */