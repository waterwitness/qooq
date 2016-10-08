import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class uuv
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private final int c;
  private final int d;
  private int e;
  
  public uuv(UnifiedMonitor paramUnifiedMonitor, int paramInt, Thread paramThread)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 100000;
    this.d = 10;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
    this.jdField_a_of_type_JavaLangString = "android.support.v4.";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;
    this.e = (UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].d - UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int);
    if (this.e > 0) {}
    for (int i = this.e;; i = this.jdField_b_of_type_Int * 4)
    {
      this.e = i;
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].c);
      this.jdField_a_of_type_JavaLangThread = paramThread;
      return;
    }
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = this.jdField_a_of_type_JavaLangThread.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label267;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int m;
        if (!QLog.isDevelopLevel()) {
          break label259;
        }
        localThrowable.printStackTrace();
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        m = arrayOfString.length;
        j = 0;
        if (j < m)
        {
          if (!str.startsWith(arrayOfString[j])) {
            break label299;
          }
          if (!str.startsWith("android.support.v4.")) {
            break label293;
          }
          j = 0;
          break label276;
        }
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          j = UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[this.jdField_a_of_type_Int].i;
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j;
          if ((i >= 0) && (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j - UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[this.jdField_a_of_type_Int].c))
          {
            this.jdField_a_of_type_JavaLangStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).append(",");
            i -= 1;
            continue;
            this.jdField_a_of_type_JavaUtilArrayList.add(str);
            break label323;
          }
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
          {
            localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
            return (String)localObject;
          }
          return null;
        }
        label259:
        return null;
      }
      int j = 0;
      break label276;
      label267:
      int k = 0;
      int i = 0;
      continue;
      for (;;)
      {
        label276:
        if (j == 0) {
          break label308;
        }
        j = i;
        if (i == 0) {
          break label323;
        }
        break;
        label293:
        j = 1;
      }
      label299:
      j += 1;
      continue;
      label308:
      j = i;
      if (i == 0)
      {
        j = 1;
        continue;
        label323:
        k += 1;
        i = j;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 162	java/util/Random
    //   3: dup
    //   4: invokespecial 163	java/util/Random:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   12: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   15: aload_0
    //   16: getfield 71	uuv:jdField_a_of_type_Int	I
    //   19: aaload
    //   20: getfield 166	uut:g	I
    //   23: aload_0
    //   24: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   27: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   30: aload_0
    //   31: getfield 71	uuv:jdField_a_of_type_Int	I
    //   34: aaload
    //   35: getfield 167	uut:jdField_b_of_type_Int	I
    //   38: if_icmplt +15 -> 53
    //   41: aload_0
    //   42: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   45: aload_0
    //   46: getfield 71	uuv:jdField_a_of_type_Int	I
    //   49: invokestatic 170	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;I)V
    //   52: return
    //   53: aload_0
    //   54: getfield 81	uuv:jdField_b_of_type_Int	I
    //   57: i2l
    //   58: invokestatic 174	java/lang/Thread:sleep	(J)V
    //   61: aload_0
    //   62: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   65: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   68: aload_0
    //   69: getfield 71	uuv:jdField_a_of_type_Int	I
    //   72: aaload
    //   73: getfield 177	uut:jdField_b_of_type_Long	J
    //   76: lconst_0
    //   77: lcmp
    //   78: ifeq -70 -> 8
    //   81: aload_0
    //   82: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   85: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   88: aload_0
    //   89: getfield 71	uuv:jdField_a_of_type_Int	I
    //   92: aaload
    //   93: getfield 177	uut:jdField_b_of_type_Long	J
    //   96: lstore_3
    //   97: invokestatic 183	android/os/SystemClock:uptimeMillis	()J
    //   100: aload_0
    //   101: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   104: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   107: aload_0
    //   108: getfield 71	uuv:jdField_a_of_type_Int	I
    //   111: aaload
    //   112: getfield 177	uut:jdField_b_of_type_Long	J
    //   115: lsub
    //   116: aload_0
    //   117: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   120: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   123: aload_0
    //   124: getfield 71	uuv:jdField_a_of_type_Int	I
    //   127: aaload
    //   128: getfield 79	uut:jdField_a_of_type_Int	I
    //   131: i2l
    //   132: lsub
    //   133: lstore 5
    //   135: lload 5
    //   137: ldc2_w 184
    //   140: lcmp
    //   141: ifgt -133 -> 8
    //   144: lload 5
    //   146: ldc2_w 186
    //   149: lcmp
    //   150: ifge +68 -> 218
    //   153: lload 5
    //   155: lneg
    //   156: lstore 5
    //   158: lload 5
    //   160: invokestatic 174	java/lang/Thread:sleep	(J)V
    //   163: invokestatic 183	android/os/SystemClock:uptimeMillis	()J
    //   166: aload_0
    //   167: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   170: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   173: aload_0
    //   174: getfield 71	uuv:jdField_a_of_type_Int	I
    //   177: aaload
    //   178: getfield 177	uut:jdField_b_of_type_Long	J
    //   181: lsub
    //   182: lstore 5
    //   184: lload 5
    //   186: aload_0
    //   187: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   190: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   193: aload_0
    //   194: getfield 71	uuv:jdField_a_of_type_Int	I
    //   197: aaload
    //   198: getfield 79	uut:jdField_a_of_type_Int	I
    //   201: bipush 10
    //   203: isub
    //   204: i2l
    //   205: lcmp
    //   206: iflt -198 -> 8
    //   209: lload 5
    //   211: ldc2_w 184
    //   214: lcmp
    //   215: ifgt -207 -> 8
    //   218: aload_0
    //   219: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   222: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   225: aload_0
    //   226: getfield 71	uuv:jdField_a_of_type_Int	I
    //   229: aaload
    //   230: aload_0
    //   231: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   234: aload_0
    //   235: getfield 71	uuv:jdField_a_of_type_Int	I
    //   238: iconst_0
    //   239: invokevirtual 191	com/tencent/mobileqq/statistics/UnifiedMonitor:whetherReportThisTime	(IZ)Z
    //   242: putfield 193	uut:jdField_b_of_type_Boolean	Z
    //   245: aload_0
    //   246: getfield 71	uuv:jdField_a_of_type_Int	I
    //   249: ifeq +21 -> 270
    //   252: aload_0
    //   253: getfield 71	uuv:jdField_a_of_type_Int	I
    //   256: bipush 10
    //   258: if_icmpeq +12 -> 270
    //   261: aload_0
    //   262: getfield 71	uuv:jdField_a_of_type_Int	I
    //   265: bipush 14
    //   267: if_icmpne +173 -> 440
    //   270: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +167 -> 440
    //   276: ldc2_w 197
    //   279: invokestatic 174	java/lang/Thread:sleep	(J)V
    //   282: invokestatic 183	android/os/SystemClock:uptimeMillis	()J
    //   285: aload_0
    //   286: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   289: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   292: aload_0
    //   293: getfield 71	uuv:jdField_a_of_type_Int	I
    //   296: aaload
    //   297: getfield 177	uut:jdField_b_of_type_Long	J
    //   300: lsub
    //   301: lstore 5
    //   303: lload_3
    //   304: aload_0
    //   305: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   308: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   311: aload_0
    //   312: getfield 71	uuv:jdField_a_of_type_Int	I
    //   315: aaload
    //   316: getfield 177	uut:jdField_b_of_type_Long	J
    //   319: lcmp
    //   320: ifne +101 -> 421
    //   323: lload 5
    //   325: aload_0
    //   326: getfield 81	uuv:jdField_b_of_type_Int	I
    //   329: sipush 200
    //   332: iadd
    //   333: bipush 10
    //   335: isub
    //   336: i2l
    //   337: lcmp
    //   338: iflt +83 -> 421
    //   341: lload 5
    //   343: ldc2_w 184
    //   346: lcmp
    //   347: ifge +74 -> 421
    //   350: aload_0
    //   351: iconst_1
    //   352: invokespecial 200	uuv:a	(Z)Ljava/lang/String;
    //   355: astore_2
    //   356: ldc -54
    //   358: iconst_2
    //   359: aload_2
    //   360: invokestatic 206	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   367: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   370: aload_0
    //   371: getfield 71	uuv:jdField_a_of_type_Int	I
    //   374: aaload
    //   375: aload_2
    //   376: putfield 207	uut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   383: invokestatic 210	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   386: iconst_2
    //   387: invokestatic 216	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   390: astore_2
    //   391: aload_2
    //   392: aload_0
    //   393: getfield 71	uuv:jdField_a_of_type_Int	I
    //   396: putfield 219	android/os/Message:arg1	I
    //   399: aload_0
    //   400: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   403: invokestatic 210	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)Landroid/os/Handler;
    //   406: aload_2
    //   407: lload_3
    //   408: invokestatic 183	android/os/SystemClock:uptimeMillis	()J
    //   411: lneg
    //   412: ladd
    //   413: ldc2_w 220
    //   416: ladd
    //   417: invokevirtual 227	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   420: pop
    //   421: aload_0
    //   422: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   425: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   428: aload_0
    //   429: getfield 71	uuv:jdField_a_of_type_Int	I
    //   432: aaload
    //   433: lconst_0
    //   434: putfield 177	uut:jdField_b_of_type_Long	J
    //   437: goto -429 -> 8
    //   440: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifne -22 -> 421
    //   446: aload_0
    //   447: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   450: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   453: aload_0
    //   454: getfield 71	uuv:jdField_a_of_type_Int	I
    //   457: aaload
    //   458: getfield 193	uut:jdField_b_of_type_Boolean	Z
    //   461: ifeq -40 -> 421
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 84	uuv:e	I
    //   469: invokevirtual 231	java/util/Random:nextInt	(I)I
    //   472: i2l
    //   473: lstore 5
    //   475: lload 5
    //   477: invokestatic 174	java/lang/Thread:sleep	(J)V
    //   480: lload_3
    //   481: aload_0
    //   482: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   485: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   488: aload_0
    //   489: getfield 71	uuv:jdField_a_of_type_Int	I
    //   492: aaload
    //   493: getfield 177	uut:jdField_b_of_type_Long	J
    //   496: lcmp
    //   497: ifne -76 -> 421
    //   500: aload_0
    //   501: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   504: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   507: aload_0
    //   508: getfield 71	uuv:jdField_a_of_type_Int	I
    //   511: aaload
    //   512: getfield 193	uut:jdField_b_of_type_Boolean	Z
    //   515: ifeq -94 -> 421
    //   518: aload_0
    //   519: getfield 22	uuv:jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor	Lcom/tencent/mobileqq/statistics/UnifiedMonitor;
    //   522: invokestatic 76	com/tencent/mobileqq/statistics/UnifiedMonitor:a	(Lcom/tencent/mobileqq/statistics/UnifiedMonitor;)[Luut;
    //   525: aload_0
    //   526: getfield 71	uuv:jdField_a_of_type_Int	I
    //   529: aaload
    //   530: astore_2
    //   531: aload_0
    //   532: getfield 71	uuv:jdField_a_of_type_Int	I
    //   535: ifeq +21 -> 556
    //   538: aload_0
    //   539: getfield 71	uuv:jdField_a_of_type_Int	I
    //   542: bipush 10
    //   544: if_icmpeq +12 -> 556
    //   547: aload_0
    //   548: getfield 71	uuv:jdField_a_of_type_Int	I
    //   551: bipush 14
    //   553: if_icmpne +19 -> 572
    //   556: iconst_1
    //   557: istore 7
    //   559: aload_2
    //   560: aload_0
    //   561: iload 7
    //   563: invokespecial 200	uuv:a	(Z)Ljava/lang/String;
    //   566: putfield 207	uut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: goto -148 -> 421
    //   572: iconst_0
    //   573: istore 7
    //   575: goto -16 -> 559
    //   578: astore_2
    //   579: goto -571 -> 8
    //   582: astore_2
    //   583: goto -575 -> 8
    //   586: astore_2
    //   587: goto -579 -> 8
    //   590: astore_2
    //   591: goto -530 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	uuv
    //   7	458	1	localRandom	java.util.Random
    //   355	205	2	localObject	Object
    //   578	1	2	localInterruptedException1	InterruptedException
    //   582	1	2	localInterruptedException2	InterruptedException
    //   586	1	2	localInterruptedException3	InterruptedException
    //   590	1	2	localInterruptedException4	InterruptedException
    //   96	385	3	l1	long
    //   133	343	5	l2	long
    //   557	17	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   158	163	578	java/lang/InterruptedException
    //   276	282	582	java/lang/InterruptedException
    //   475	480	586	java/lang/InterruptedException
    //   53	61	590	java/lang/InterruptedException
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */