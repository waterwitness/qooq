package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.j;
import com.tencent.bugly.proguard.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private StringBuilder a;
  private int b = 0;
  
  public b(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  /* Error */
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +11 -> 12
    //   4: aload_1
    //   5: ifnull +7 -> 12
    //   8: aload_2
    //   9: ifnonnull +15 -> 24
    //   12: ldc 23
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 29	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   21: pop
    //   22: aconst_null
    //   23: areturn
    //   24: new 31	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc 33
    //   31: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 40	java/io/File:exists	()Z
    //   39: ifeq -17 -> 22
    //   42: aload_1
    //   43: invokevirtual 43	java/io/File:canRead	()Z
    //   46: ifeq -24 -> 22
    //   49: new 45	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore 4
    //   59: aload 4
    //   61: astore_1
    //   62: aload 4
    //   64: invokestatic 51	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +15 -> 84
    //   72: aload 4
    //   74: astore_1
    //   75: aload_3
    //   76: ldc 53
    //   78: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifne +34 -> 115
    //   84: aload 4
    //   86: astore_1
    //   87: ldc 61
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_3
    //   96: aastore
    //   97: invokestatic 29	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload 4
    //   103: invokevirtual 64	java/io/FileInputStream:close	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: aload 4
    //   117: astore_1
    //   118: new 69	java/util/HashMap
    //   121: dup
    //   122: invokespecial 70	java/util/HashMap:<init>	()V
    //   125: astore 6
    //   127: aconst_null
    //   128: astore_3
    //   129: aload 4
    //   131: astore_1
    //   132: aload 4
    //   134: invokestatic 51	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +32 -> 173
    //   144: aload_3
    //   145: ifnonnull +9 -> 154
    //   148: aload 5
    //   150: astore_3
    //   151: goto -22 -> 129
    //   154: aload 4
    //   156: astore_1
    //   157: aload 6
    //   159: aload_3
    //   160: aload 5
    //   162: invokeinterface 76 3 0
    //   167: pop
    //   168: aconst_null
    //   169: astore_3
    //   170: goto -41 -> 129
    //   173: aload_3
    //   174: ifnull +34 -> 208
    //   177: aload 4
    //   179: astore_1
    //   180: ldc 78
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_3
    //   189: aastore
    //   190: invokestatic 29	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   193: pop
    //   194: aload 4
    //   196: invokevirtual 64	java/io/FileInputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   206: aconst_null
    //   207: areturn
    //   208: aload 4
    //   210: astore_1
    //   211: aload_0
    //   212: aload 6
    //   214: aload_2
    //   215: invokestatic 81	com/tencent/bugly/crashreport/crash/jni/b:a	(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   218: astore_0
    //   219: aload 4
    //   221: invokevirtual 64	java/io/FileInputStream:close	()V
    //   224: aload_0
    //   225: areturn
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   231: aload_0
    //   232: areturn
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_0
    //   236: aload_0
    //   237: astore_1
    //   238: aload_2
    //   239: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   242: aload_0
    //   243: ifnull -221 -> 22
    //   246: aload_0
    //   247: invokevirtual 64	java/io/FileInputStream:close	()V
    //   250: aconst_null
    //   251: areturn
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_0
    //   260: aconst_null
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +7 -> 270
    //   266: aload_1
    //   267: invokevirtual 64	java/io/FileInputStream:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   277: goto -7 -> 270
    //   280: astore_0
    //   281: goto -19 -> 262
    //   284: astore_2
    //   285: aload 4
    //   287: astore_0
    //   288: goto -52 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramContext	Context
    //   0	291	1	paramString	String
    //   0	291	2	paramNativeExceptionHandler	NativeExceptionHandler
    //   67	122	3	localObject	Object
    //   57	229	4	localFileInputStream	java.io.FileInputStream
    //   137	24	5	str	String
    //   125	88	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   101	106	108	java/io/IOException
    //   194	199	201	java/io/IOException
    //   219	224	226	java/io/IOException
    //   49	59	233	java/io/IOException
    //   246	250	252	java/io/IOException
    //   49	59	259	finally
    //   266	270	272	java/io/IOException
    //   62	68	280	finally
    //   75	84	280	finally
    //   87	101	280	finally
    //   118	127	280	finally
    //   132	139	280	finally
    //   157	168	280	finally
    //   180	194	280	finally
    //   211	219	280	finally
    //   238	242	280	finally
    //   62	68	284	java/io/IOException
    //   75	84	284	java/io/IOException
    //   87	101	284	java/io/IOException
    //   118	127	284	java/io/IOException
    //   132	139	284	java/io/IOException
    //   157	168	284	java/io/IOException
    //   180	194	284	java/io/IOException
    //   211	219	284	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler)
  {
    if (paramMap == null) {
      return null;
    }
    if (com.tencent.bugly.crashreport.common.info.a.a(paramContext) == null)
    {
      v.e("abnormal com info not created", new Object[0]);
      return null;
    }
    paramContext = (String)paramMap.get("intStateStr");
    if ((paramContext == null) || (paramContext.trim().length() <= 0))
    {
      v.e("no intStateStr", new Object[0]);
      return null;
    }
    paramContext = c(paramContext);
    if (paramContext == null)
    {
      v.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    }
    label898:
    label901:
    label910:
    label913:
    label916:
    label919:
    label922:
    for (;;)
    {
      int i;
      try
      {
        i = ((Integer)paramContext.get("ep")).intValue();
        int j = ((Integer)paramContext.get("et")).intValue();
        ((Integer)paramContext.get("sino")).intValue();
        int k = ((Integer)paramContext.get("sico")).intValue();
        int m = ((Integer)paramContext.get("spd")).intValue();
        ((Integer)paramContext.get("sud")).intValue();
        long l1 = ((Integer)paramContext.get("ets")).intValue();
        long l2 = ((Integer)paramContext.get("etms")).intValue();
        String str5 = (String)paramMap.get("soVersion");
        if (str5 == null)
        {
          v.e("error format at version", new Object[0]);
          return null;
        }
        String str2 = (String)paramMap.get("errorAddr");
        if (str2 != null) {
          break label910;
        }
        str2 = "unknown2";
        paramContext = (String)paramMap.get("codeMsg");
        if (paramContext != null) {
          break label913;
        }
        paramContext = "unknown2";
        String str3 = (String)paramMap.get("tombPath");
        if (str3 != null) {
          break label916;
        }
        str3 = "unknown2";
        String str1 = (String)paramMap.get("signalName");
        if (str1 != null) {
          break label919;
        }
        str1 = "unknown2";
        paramMap.get("errnoMsg");
        Object localObject1 = (String)paramMap.get("stack");
        if (localObject1 != null) {
          break label922;
        }
        localObject1 = "unknown2";
        String str4 = (String)paramMap.get("jstack");
        if (str4 == null) {
          break label898;
        }
        localObject1 = (String)localObject1 + "java:\n" + str4;
        l2 /= 1000L;
        String str6 = a((String)localObject1);
        str4 = (String)paramMap.get("sendingProcess");
        localObject1 = str4;
        if (str4 == null) {
          localObject1 = "UNKNOWN";
        }
        String str7 = (String)localObject1 + "(" + m + ")";
        str4 = str1;
        localObject1 = paramContext;
        if (k > 0)
        {
          str4 = str1 + "(" + paramContext + ")";
          localObject1 = "KERNEL";
        }
        Object localObject2 = (String)paramMap.get("nativeLog");
        str1 = null;
        paramContext = str1;
        if (localObject2 != null)
        {
          paramContext = str1;
          if (!((String)localObject2).isEmpty()) {
            paramContext = com.tencent.bugly.proguard.a.a(null, (String)localObject2);
          }
        }
        str1 = (String)paramMap.get("processName");
        if (str1 == null)
        {
          str1 = "unknown(" + i + ")";
          Object localObject3 = (String)paramMap.get("threadName");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "unknown";
          }
          String str8 = (String)localObject2 + "(" + j + ")";
          localObject2 = null;
          Object localObject4 = (String)paramMap.get("key-value");
          if (localObject4 != null)
          {
            localObject3 = new HashMap();
            localObject4 = ((String)localObject4).split("\n");
            j = localObject4.length;
            i = 0;
            localObject2 = localObject3;
            if (i < j)
            {
              localObject2 = localObject4[i].split("=");
              if (localObject2.length != 2) {
                break label901;
              }
              ((Map)localObject3).put(localObject2[0], localObject2[1]);
              break label901;
            }
          }
          paramContext = paramNativeExceptionHandler.packageCrashDatas(str1, str8, l1 * 1000L + l2, str4, str2, str6, (String)localObject1, str7, str3, str5, paramContext, (Map)localObject2, false);
          if (paramContext != null)
          {
            paramNativeExceptionHandler = (String)paramMap.get("userId");
            if (paramNativeExceptionHandler != null) {
              paramContext.m = paramNativeExceptionHandler;
            }
            paramNativeExceptionHandler = (String)paramMap.get("sysLog");
            if (paramNativeExceptionHandler != null) {
              paramContext.w = paramNativeExceptionHandler;
            }
            paramMap = (String)paramMap.get("appVersion");
            if (paramMap != null) {
              paramContext.f = paramMap;
            }
            paramContext.y = null;
            paramContext.k = true;
          }
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        v.e("error format", new Object[0]);
        paramContext.printStackTrace();
        return null;
      }
      continue;
      continue;
      i += 1;
      continue;
      continue;
      continue;
      continue;
    }
  }
  
  private static String a(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      if (i == 0) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }
  
  protected static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return str;
        arrayOfString = paramString.split("\n");
        str = paramString;
      } while (arrayOfString == null);
      str = paramString;
    } while (arrayOfString.length == 0);
    paramString = new StringBuilder();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      str = arrayOfString[i];
      if (!str.contains("java.lang.Thread.getStackTrace(")) {
        paramString.append(str).append("\n");
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = c(paramString1, paramString2);
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("Register infos:\n");
      localStringBuilder.append(str);
    }
    paramString1 = d(paramString1, paramString2);
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append("System SO infos:\n");
      localStringBuilder.append(paramString1);
    }
    return localStringBuilder.toString();
  }
  
  public static void b(String paramString)
  {
    File localFile = new File(paramString, "rqd_record.eup");
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      localFile.delete();
      v.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
    }
    localFile = new File(paramString, "reg_record.txt");
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      localFile.delete();
      v.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
    }
    localFile = new File(paramString, "map_record.txt");
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      localFile.delete();
      v.c("delete record file %s", new Object[] { localFile.getAbsoluteFile() });
    }
    paramString = new File(paramString, "backup_record.txt");
    if ((paramString.exists()) && (paramString.canWrite()))
    {
      paramString.delete();
      v.c("delete record file %s", new Object[] { paramString.getAbsoluteFile() });
    }
  }
  
  private static String c(String paramString1, String paramString2)
  {
    Object localObject = null;
    BufferedReader localBufferedReader = com.tencent.bugly.proguard.a.a(paramString1, "reg_record.txt");
    if (localBufferedReader == null) {
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      return paramString2;
      try
      {
        paramString1 = new StringBuilder();
        boolean bool = localBufferedReader.readLine().startsWith(paramString2);
        if (!bool)
        {
          paramString2 = (String)localObject;
          if (localBufferedReader == null) {
            continue;
          }
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            v.a(paramString1);
            return null;
          }
        }
        int k = 0;
        int i = 18;
        int j = 0;
        paramString2 = localBufferedReader.readLine();
        if (paramString2 != null)
        {
          if (j % 4 == 0)
          {
            if (j > 0) {
              paramString1.append("\n");
            }
            paramString1.append("  ");
          }
          for (;;)
          {
            k = paramString2.length();
            paramString1.append(paramString2);
            j += 1;
            break;
            if (paramString2.length() > 16) {
              i = 28;
            }
            paramString1.append("                ".substring(0, i - k));
          }
        }
      }
      catch (Throwable paramString1)
      {
        v.a(paramString1);
        paramString2 = (String)localObject;
        if (localBufferedReader != null)
        {
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            v.a(paramString1);
            return null;
          }
          paramString1.append("\n");
          paramString1 = paramString1.toString();
          paramString2 = paramString1;
          if (localBufferedReader != null) {
            try
            {
              localBufferedReader.close();
              return paramString1;
            }
            catch (Exception paramString2)
            {
              v.a(paramString2);
              return paramString1;
            }
          }
        }
      }
      finally
      {
        if (localBufferedReader == null) {}
      }
    }
    try
    {
      localBufferedReader.close();
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        v.a(paramString2);
      }
    }
  }
  
  private static Map<String, Integer> c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      String[] arrayOfString2;
      try
      {
        HashMap localHashMap = new HashMap();
        String[] arrayOfString1 = paramString.split(",");
        int j = arrayOfString1.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str = arrayOfString1[i];
        arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          v.e("error format at %s", new Object[] { str });
          return null;
        }
      }
      catch (Exception localException)
      {
        v.e("error format intStateStr %s", new Object[] { paramString });
        localException.printStackTrace();
        return null;
      }
      int k = Integer.parseInt(arrayOfString2[1]);
      localException.put(arrayOfString2[0], Integer.valueOf(k));
      i += 1;
    }
    return localException;
  }
  
  private static String d(String paramString1, String paramString2)
  {
    Object localObject = null;
    BufferedReader localBufferedReader = com.tencent.bugly.proguard.a.a(paramString1, "map_record.txt");
    if (localBufferedReader == null) {
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      return paramString2;
      try
      {
        paramString1 = new StringBuilder();
        boolean bool = localBufferedReader.readLine().startsWith(paramString2);
        if (!bool)
        {
          paramString2 = (String)localObject;
          if (localBufferedReader == null) {
            continue;
          }
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            v.a(paramString1);
            return null;
          }
        }
        for (;;)
        {
          paramString2 = localBufferedReader.readLine();
          if (paramString2 == null) {
            break;
          }
          paramString1.append("  ");
          paramString1.append(paramString2);
          paramString1.append("\n");
        }
      }
      catch (Throwable paramString1)
      {
        v.a(paramString1);
        paramString2 = (String)localObject;
        if (localBufferedReader != null)
        {
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            v.a(paramString1);
            return null;
          }
          paramString1 = paramString1.toString();
          paramString2 = paramString1;
          if (localBufferedReader != null) {
            try
            {
              localBufferedReader.close();
              return paramString1;
            }
            catch (Exception paramString2)
            {
              v.a(paramString2);
              return paramString1;
            }
          }
        }
      }
      finally
      {
        if (localBufferedReader == null) {}
      }
    }
    try
    {
      localBufferedReader.close();
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        v.a(paramString2);
      }
    }
  }
  
  private void d(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.a.append(paramString).append(": ");
    }
  }
  
  public b a(byte paramByte, String paramString)
  {
    d(paramString);
    this.a.append(paramByte).append('\n');
    return this;
  }
  
  public b a(char paramChar, String paramString)
  {
    d(paramString);
    this.a.append(paramChar).append('\n');
    return this;
  }
  
  public b a(double paramDouble, String paramString)
  {
    d(paramString);
    this.a.append(paramDouble).append('\n');
    return this;
  }
  
  public b a(float paramFloat, String paramString)
  {
    d(paramString);
    this.a.append(paramFloat).append('\n');
    return this;
  }
  
  public b a(int paramInt, String paramString)
  {
    d(paramString);
    this.a.append(paramInt).append('\n');
    return this;
  }
  
  public b a(long paramLong, String paramString)
  {
    d(paramString);
    this.a.append(paramLong).append('\n');
    return this;
  }
  
  public b a(j paramj, String paramString)
  {
    a('{', paramString);
    if (paramj == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a('}', null);
      return this;
      paramj.a(this.a, this.b + 1);
    }
  }
  
  public <T> b a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      b((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof j))
    {
      a((j)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new com.tencent.bugly.proguard.b("write object error: unsupport type.");
  }
  
  public <T> b a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      d(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public <K, V> b a(Map<K, V> paramMap, String paramString)
  {
    d(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.a.append(paramMap.size()).append(", {}\n");
      return this;
    }
    this.a.append(paramMap.size()).append(", {\n");
    paramString = new b(this.a, this.b + 1);
    b localb = new b(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localb.a(localEntry.getKey(), null);
      localb.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public b a(short paramShort, String paramString)
  {
    d(paramString);
    this.a.append(paramShort).append('\n');
    return this;
  }
  
  public b a(boolean paramBoolean, String paramString)
  {
    d(paramString);
    paramString = this.a;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public b a(byte[] paramArrayOfByte, String paramString)
  {
    d(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.a.append(paramArrayOfByte.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfByte.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(double[] paramArrayOfDouble, String paramString)
  {
    d(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.a.append(paramArrayOfDouble.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(float[] paramArrayOfFloat, String paramString)
  {
    d(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.a.append(paramArrayOfFloat.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(int[] paramArrayOfInt, String paramString)
  {
    d(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.a.append(paramArrayOfInt.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfInt.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(long[] paramArrayOfLong, String paramString)
  {
    d(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.a.append(paramArrayOfLong.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfLong.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public <T> b a(T[] paramArrayOfT, String paramString)
  {
    d(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.a.append(paramArrayOfT.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfT.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(short[] paramArrayOfShort, String paramString)
  {
    d(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.a.append(paramArrayOfShort.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfShort.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b b(String paramString1, String paramString2)
  {
    d(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    this.a.append(paramString1).append('\n');
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */