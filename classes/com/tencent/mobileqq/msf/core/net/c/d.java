package com.tencent.mobileqq.msf.core.net.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class d
{
  private static final String a = "PingAndTraceroute";
  private boolean b;
  private String c = "";
  private String d = "";
  private int e = 60;
  private int f = 10;
  private int g = 1200000;
  private int h = 3;
  private boolean i;
  private a j = new a();
  private HashMap k;
  private String l = "";
  
  public d(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.b = paramBoolean;
  }
  
  public d(String paramString, boolean paramBoolean, int paramInt)
  {
    this.c = paramString;
    this.b = paramBoolean;
    this.g = paramInt;
  }
  
  /* Error */
  private String a(String paramString, int paramInt1, int paramInt2)
    throws Exception
  {
    // Byte code:
    //   0: invokestatic 63	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 65	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   10: ldc 68
    //   12: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_3
    //   16: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 77
    //   21: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc 79
    //   30: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 87	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: astore 5
    //   45: new 89	java/io/BufferedReader
    //   48: dup
    //   49: new 91	java/io/InputStreamReader
    //   52: dup
    //   53: aload 5
    //   55: invokevirtual 97	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   58: invokespecial 100	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   61: invokespecial 103	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   64: astore 6
    //   66: new 105	java/lang/String
    //   69: dup
    //   70: invokespecial 106	java/lang/String:<init>	()V
    //   73: pop
    //   74: ldc 32
    //   76: astore_1
    //   77: aload 6
    //   79: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +100 -> 186
    //   89: new 65	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 4
    //   102: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore 4
    //   110: aload 4
    //   112: astore_1
    //   113: goto -36 -> 77
    //   116: astore 4
    //   118: ldc 32
    //   120: astore_1
    //   121: aload 4
    //   123: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   126: aload 5
    //   128: invokevirtual 116	java/lang/Process:exitValue	()I
    //   131: pop
    //   132: aload_1
    //   133: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   136: areturn
    //   137: astore_1
    //   138: aload 5
    //   140: invokevirtual 116	java/lang/Process:exitValue	()I
    //   143: pop
    //   144: aload_1
    //   145: athrow
    //   146: astore 4
    //   148: aload 5
    //   150: invokevirtual 122	java/lang/Process:destroy	()V
    //   153: goto -9 -> 144
    //   156: astore 5
    //   158: aload 4
    //   160: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   163: goto -19 -> 144
    //   166: astore 4
    //   168: aload 5
    //   170: invokevirtual 122	java/lang/Process:destroy	()V
    //   173: goto -41 -> 132
    //   176: astore 5
    //   178: aload 4
    //   180: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   183: goto -51 -> 132
    //   186: aload 5
    //   188: invokevirtual 116	java/lang/Process:exitValue	()I
    //   191: pop
    //   192: goto -60 -> 132
    //   195: astore 4
    //   197: aload 5
    //   199: invokevirtual 122	java/lang/Process:destroy	()V
    //   202: goto -70 -> 132
    //   205: astore 5
    //   207: goto -29 -> 178
    //   210: astore 4
    //   212: goto -91 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	d
    //   0	215	1	paramString	String
    //   0	215	2	paramInt1	int
    //   0	215	3	paramInt2	int
    //   82	29	4	str	String
    //   116	6	4	localException1	Exception
    //   146	13	4	localException2	Exception
    //   166	13	4	localException3	Exception
    //   195	1	4	localException4	Exception
    //   210	1	4	localException5	Exception
    //   43	106	5	localProcess	Process
    //   156	13	5	localException6	Exception
    //   176	22	5	localException7	Exception
    //   205	1	5	localException8	Exception
    //   64	14	6	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   45	74	116	java/lang/Exception
    //   45	74	137	finally
    //   77	84	137	finally
    //   89	110	137	finally
    //   121	126	137	finally
    //   138	144	146	java/lang/Exception
    //   148	153	156	java/lang/Exception
    //   126	132	166	java/lang/Exception
    //   168	173	176	java/lang/Exception
    //   186	192	195	java/lang/Exception
    //   197	202	205	java/lang/Exception
    //   77	84	210	java/lang/Exception
    //   89	110	210	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    String str2 = "*";
    int m = paramString.indexOf("from");
    String str1 = str2;
    if (m >= 0)
    {
      int n = paramString.indexOf(" ", m + 5);
      str1 = str2;
      if (n > 0) {
        str1 = paramString.substring(m + 5, n);
      }
    }
    str1 = str1.trim();
    paramString = str1;
    if (str1.endsWith(":")) {
      paramString = str1.substring(0, str1.length() - 1).trim();
    }
    str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "*";
    }
    return str1;
  }
  
  private String c(String paramString)
  {
    String str = "";
    if (paramString.contains("ping")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  private String d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return this.c;
    }
    return this.d;
  }
  
  public a a()
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 1;
    String str1;
    String str2;
    int n;
    if (m < this.e)
    {
      str1 = "*";
      str2 = "";
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.h)
        {
          long l2 = SystemClock.elapsedRealtime();
          int i1 = this.f;
          int i2 = (int)(l2 - l1);
          if (i2 >= this.g)
          {
            this.j.b = true;
            this.j.a = m;
            this.j.d = "\n";
            return this.j;
          }
          if (this.g - i2 < 10000) {
            i1 = (this.g - i2) / 1000 + 1;
          }
          str2 = a(d(), m, i1);
          long l3 = SystemClock.elapsedRealtime();
          String str3 = c(str2);
          if (!TextUtils.isEmpty(str3))
          {
            this.d = str3;
            if (!this.i)
            {
              this.j.c = str3;
              str3 = "Traceroute to " + this.c + " (" + str3 + "), " + this.e + " hops max, 60 byte packets, mTimeout " + this.f + "s";
              this.i = true;
              if (this.b) {
                QLog.d("PingAndTraceroute", 1, str3);
              }
              localStringBuilder.append(str3).append("\n");
            }
          }
          str2 = b(str2);
          if (str2.equals("*")) {
            break label632;
          }
          if (!str2.equals(str1)) {
            break label627;
          }
          str2 = "";
          str2 = String.format("%s %10d ms ", new Object[] { str2, Long.valueOf(l3 - l2) }).toString();
          localStringBuilder.append(str2);
          n += 1;
          continue;
        }
        localStringBuilder.append("\n");
        if (this.b) {
          QLog.d("PingAndTraceroute", 1, str2);
        }
        if ((this.c.equals(str1)) || (this.d.equals(str1)))
        {
          this.j.b = true;
          this.j.a = m;
          if (!this.j.b) {
            break label574;
          }
          str1 = "Traceroute succ host: " + this.c + "(" + this.d + ") TTL: " + this.j.a;
          if ((this.b) && (QLog.isColorLevel())) {
            QLog.d("PingAndTraceroute", 2, str1);
          }
          this.j.d = localStringBuilder.toString();
          return this.j;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = "Ping error: " + localException.getMessage();
        if (this.b) {
          QLog.d("PingAndTraceroute", 1, (String)localObject);
        }
        localStringBuilder.append((String)localObject).append("\n");
        m += 1;
      }
      break;
      label574:
      Object localObject = "Traceroute fail host: " + this.c + "(" + this.d + ") TTL: " + this.j.a;
      continue;
      label627:
      localObject = str2;
      continue;
      label632:
      str2 = " * ";
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(HashMap paramHashMap)
  {
    this.k = paramHashMap;
  }
  
  /* Error */
  public a b()
  {
    // Byte code:
    //   0: invokestatic 173	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: new 65	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 50	com/tencent/mobileqq/msf/core/net/c/d:l	Ljava/lang/String;
    //   17: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +265 -> 285
    //   23: new 65	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   30: ldc -10
    //   32: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 50	com/tencent/mobileqq/msf/core/net/c/d:l	Ljava/lang/String;
    //   39: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: ldc -8
    //   51: invokevirtual 162	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   54: ifne +23 -> 77
    //   57: new 65	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   64: aload_2
    //   65: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc -6
    //   70: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_1
    //   77: aload_1
    //   78: astore_2
    //   79: aload_1
    //   80: ldc -4
    //   82: invokevirtual 162	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   85: ifne +23 -> 108
    //   88: new 65	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   95: aload_1
    //   96: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc -2
    //   101: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: new 65	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   115: aload_2
    //   116: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokespecial 181	com/tencent/mobileqq/msf/core/net/c/d:d	()Ljava/lang/String;
    //   123: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore_1
    //   130: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +29 -> 162
    //   136: ldc 10
    //   138: iconst_2
    //   139: new 65	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 256
    //   149: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: invokestatic 63	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   165: aload_1
    //   166: invokevirtual 87	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   169: astore_1
    //   170: new 89	java/io/BufferedReader
    //   173: dup
    //   174: new 91	java/io/InputStreamReader
    //   177: dup
    //   178: aload_1
    //   179: invokevirtual 97	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   182: invokespecial 100	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   185: invokespecial 103	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   188: astore_2
    //   189: new 105	java/lang/String
    //   192: dup
    //   193: invokespecial 106	java/lang/String:<init>	()V
    //   196: pop
    //   197: aload_2
    //   198: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   201: astore 4
    //   203: aload 4
    //   205: ifnull +30 -> 235
    //   208: aload_3
    //   209: aload 4
    //   211: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc -78
    //   216: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: invokestatic 173	android/os/SystemClock:elapsedRealtime	()J
    //   223: lload 5
    //   225: lsub
    //   226: aload_0
    //   227: getfield 43	com/tencent/mobileqq/msf/core/net/c/d:g	I
    //   230: i2l
    //   231: lcmp
    //   232: iflt -35 -> 197
    //   235: aload_0
    //   236: getfield 48	com/tencent/mobileqq/msf/core/net/c/d:j	Lcom/tencent/mobileqq/msf/core/net/c/d$a;
    //   239: iconst_1
    //   240: putfield 174	com/tencent/mobileqq/msf/core/net/c/d$a:b	Z
    //   243: aload_1
    //   244: invokevirtual 116	java/lang/Process:exitValue	()I
    //   247: pop
    //   248: aload_0
    //   249: getfield 48	com/tencent/mobileqq/msf/core/net/c/d:j	Lcom/tencent/mobileqq/msf/core/net/c/d$a;
    //   252: aload_3
    //   253: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: putfield 179	com/tencent/mobileqq/msf/core/net/c/d$a:d	Ljava/lang/String;
    //   259: aload_0
    //   260: getfield 48	com/tencent/mobileqq/msf/core/net/c/d:j	Lcom/tencent/mobileqq/msf/core/net/c/d$a;
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 48	com/tencent/mobileqq/msf/core/net/c/d:j	Lcom/tencent/mobileqq/msf/core/net/c/d$a;
    //   268: getfield 179	com/tencent/mobileqq/msf/core/net/c/d$a:d	Ljava/lang/String;
    //   271: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   274: invokespecial 185	com/tencent/mobileqq/msf/core/net/c/d:c	(Ljava/lang/String;)Ljava/lang/String;
    //   277: putfield 188	com/tencent/mobileqq/msf/core/net/c/d$a:c	Ljava/lang/String;
    //   280: aload_0
    //   281: getfield 48	com/tencent/mobileqq/msf/core/net/c/d:j	Lcom/tencent/mobileqq/msf/core/net/c/d$a;
    //   284: areturn
    //   285: new 65	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   292: ldc -10
    //   294: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 258
    //   300: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_2
    //   307: goto -199 -> 108
    //   310: astore_2
    //   311: aload_2
    //   312: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   315: aload_1
    //   316: invokevirtual 116	java/lang/Process:exitValue	()I
    //   319: pop
    //   320: goto -72 -> 248
    //   323: astore_2
    //   324: aload_1
    //   325: invokevirtual 122	java/lang/Process:destroy	()V
    //   328: goto -80 -> 248
    //   331: astore_1
    //   332: aload_2
    //   333: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   336: goto -88 -> 248
    //   339: astore_1
    //   340: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq -95 -> 248
    //   346: ldc 10
    //   348: iconst_2
    //   349: aload_1
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   357: goto -109 -> 248
    //   360: astore_2
    //   361: aload_1
    //   362: invokevirtual 116	java/lang/Process:exitValue	()I
    //   365: pop
    //   366: aload_2
    //   367: athrow
    //   368: astore 4
    //   370: aload_1
    //   371: invokevirtual 122	java/lang/Process:destroy	()V
    //   374: goto -8 -> 366
    //   377: astore_1
    //   378: aload 4
    //   380: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   383: goto -17 -> 366
    //   386: astore_2
    //   387: aload_1
    //   388: invokevirtual 122	java/lang/Process:destroy	()V
    //   391: goto -143 -> 248
    //   394: astore_1
    //   395: aload_2
    //   396: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   399: goto -151 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	d
    //   47	278	1	localObject1	Object
    //   331	1	1	localException1	Exception
    //   339	32	1	localException2	Exception
    //   377	11	1	localException3	Exception
    //   394	1	1	localException4	Exception
    //   45	262	2	localObject2	Object
    //   310	2	2	localException5	Exception
    //   323	10	2	localException6	Exception
    //   360	7	2	localObject3	Object
    //   386	10	2	localException7	Exception
    //   12	241	3	localStringBuilder	StringBuilder
    //   201	9	4	str	String
    //   368	11	4	localException8	Exception
    //   3	221	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   170	197	310	java/lang/Exception
    //   197	203	310	java/lang/Exception
    //   208	235	310	java/lang/Exception
    //   235	243	310	java/lang/Exception
    //   315	320	323	java/lang/Exception
    //   324	328	331	java/lang/Exception
    //   13	46	339	java/lang/Exception
    //   48	77	339	java/lang/Exception
    //   79	108	339	java/lang/Exception
    //   108	162	339	java/lang/Exception
    //   162	170	339	java/lang/Exception
    //   285	307	339	java/lang/Exception
    //   332	336	339	java/lang/Exception
    //   366	368	339	java/lang/Exception
    //   378	383	339	java/lang/Exception
    //   395	399	339	java/lang/Exception
    //   170	197	360	finally
    //   197	203	360	finally
    //   208	235	360	finally
    //   235	243	360	finally
    //   311	315	360	finally
    //   361	366	368	java/lang/Exception
    //   370	374	377	java/lang/Exception
    //   243	248	386	java/lang/Exception
    //   387	391	394	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public a c()
  {
    return this.j;
  }
  
  public static class a
  {
    public int a;
    public boolean b;
    public String c = "";
    public String d = "";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */