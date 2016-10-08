import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class qiw
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public qiw(CleanCache paramCleanCache)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(File paramFile)
  {
    int m = 0;
    j = 0;
    int k = 0;
    i = k;
    if (paramFile.exists())
    {
      i = k;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        if (paramFile != null) {
          break label43;
        }
        i = k;
      }
    }
    return i;
    label43:
    i = paramFile.length;
    k = i;
    int n;
    if (i > 2000)
    {
      Arrays.sort(paramFile, new qiz(this));
      n = paramFile.length;
      k = m;
      j = i;
    }
    for (;;)
    {
      i = j;
      if (k < n)
      {
        paramFile[k].delete();
        i = j - 1;
        if (i > 500) {}
      }
      else
      {
        j = i - 500;
        k = i;
        long l = System.currentTimeMillis();
        k = paramFile.length - k;
        for (;;)
        {
          i = j;
          if (k >= paramFile.length) {
            break;
          }
          Object localObject = paramFile[k];
          i = j;
          if (((File)localObject).exists())
          {
            i = j;
            if (((File)localObject).isFile())
            {
              i = j;
              if (l - ((File)localObject).lastModified() <= 2592000000L) {
                break;
              }
              ((File)localObject).delete();
              j += 1;
              i = j;
              if (k % 200 != 0) {}
            }
          }
          try
          {
            Thread.sleep(100L);
            i = j;
          }
          catch (InterruptedException localInterruptedException2)
          {
            for (;;)
            {
              i = j;
            }
          }
          k += 1;
          j = i;
        }
      }
      if (i % 200 == 0) {}
      try
      {
        Thread.sleep(100L);
        k += 1;
        j = i;
      }
      catch (InterruptedException localInterruptedException1)
      {
        for (;;) {}
      }
    }
  }
  
  private int a(File[] paramArrayOfFile, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < paramArrayOfFile.length)
      {
        File localFile = paramArrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        paramArrayOfFile[i] = null;
        paramInt += 1;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache->delRemainQQHead. delete QQHead,filePath=" + localFile.getAbsolutePath());
        }
        if (paramInt >= this.jdField_a_of_type_Int) {
          j = paramInt;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    int j = 0;
    int i = 0;
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.bj + "shortvideo");
    int m;
    int k;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int n = localObject1.length;
        m = n;
        if (n > 2000)
        {
          Arrays.sort((Object[])localObject1, new qja(this));
          int i1 = localObject1.length;
          k = 0;
          j = i;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            j = i;
            if (localObject2 == null) {
              break label319;
            }
            j = i;
            if (!((File)localObject2).isDirectory()) {
              break label319;
            }
            j = i;
            if (((File)localObject2).getName().equals("thumbs")) {
              break label319;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "delShortVideoCache ===> deleteCount=" + i + ", delete dir=" + ((File)localObject2).getAbsolutePath());
            }
            FileUtils.a(((File)localObject2).getAbsolutePath());
            i += 1;
            if (i < n - 1000) {
              break label299;
            }
            m = n;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "delShortVideoCache(), totalCount=" + m + ", deleteCount= " + j + ", targetDeleteCount=" + (m - 1000) + ", cost: " + (l2 - l1) + " ms");
      }
      return;
      label299:
      j = i;
      if (i % 200 == 0) {}
      try
      {
        Thread.sleep(100L);
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label319:
          j = i;
        }
      }
      k += 1;
      i = j;
      break;
      m = 0;
    }
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: iconst_0
    //   9: istore 10
    //   11: aload_0
    //   12: getfield 13	qiw:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   15: invokestatic 163	com/tencent/mobileqq/app/automator/step/CleanCache:b	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   18: getfield 168	com/tencent/mobileqq/app/automator/Automator:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   24: invokevirtual 179	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   27: astore_2
    //   28: aload_2
    //   29: iconst_0
    //   30: ldc -75
    //   32: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   35: iconst_2
    //   36: anewarray 128	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc -68
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc -66
    //   48: aastore
    //   49: ldc -64
    //   51: iconst_1
    //   52: anewarray 128	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc -62
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 199	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_3
    //   68: aload 5
    //   70: astore 4
    //   72: aload_3
    //   73: ifnull +96 -> 169
    //   76: aload 5
    //   78: astore 4
    //   80: aload_3
    //   81: invokeinterface 204 1 0
    //   86: ifeq +83 -> 169
    //   89: new 206	java/util/HashMap
    //   92: dup
    //   93: aload_3
    //   94: invokeinterface 210 1 0
    //   99: invokespecial 213	java/util/HashMap:<init>	(I)V
    //   102: astore 4
    //   104: aload_3
    //   105: iconst_0
    //   106: invokeinterface 217 2 0
    //   111: astore 5
    //   113: aload_3
    //   114: iconst_1
    //   115: invokeinterface 221 2 0
    //   120: istore 7
    //   122: aload_0
    //   123: getfield 13	qiw:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   126: invokestatic 224	com/tencent/mobileqq/app/automator/step/CleanCache:c	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   129: getfield 168	com/tencent/mobileqq/app/automator/Automator:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: astore 6
    //   134: iload 7
    //   136: iconst_4
    //   137: if_icmpne +403 -> 540
    //   140: iconst_1
    //   141: istore 11
    //   143: aload 4
    //   145: aload 6
    //   147: iload 11
    //   149: aload 5
    //   151: invokevirtual 227	com/tencent/mobileqq/app/QQAppInterface:a	(ZLjava/lang/String;)Ljava/lang/String;
    //   154: aload 5
    //   156: invokevirtual 231	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: aload_3
    //   161: invokeinterface 234 1 0
    //   166: ifne -62 -> 104
    //   169: aload_2
    //   170: new 85	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   177: ldc -20
    //   179: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc -75
    //   184: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   187: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc -18
    //   192: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 241	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   201: pop
    //   202: aload 4
    //   204: ifnull +342 -> 546
    //   207: aload 4
    //   209: invokevirtual 244	java/util/HashMap:size	()I
    //   212: ifle +334 -> 546
    //   215: iconst_0
    //   216: istore 8
    //   218: iconst_0
    //   219: istore 7
    //   221: iload 7
    //   223: istore 9
    //   225: iload 8
    //   227: aload_1
    //   228: arraylength
    //   229: if_icmpge +102 -> 331
    //   232: aload_1
    //   233: iload 8
    //   235: aaload
    //   236: astore 5
    //   238: aload 5
    //   240: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   243: astore 6
    //   245: iload 7
    //   247: istore 9
    //   249: aload 4
    //   251: aload 6
    //   253: invokevirtual 247	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   256: ifeq +271 -> 527
    //   259: aload 5
    //   261: invokevirtual 32	java/io/File:exists	()Z
    //   264: ifeq +9 -> 273
    //   267: aload 5
    //   269: invokevirtual 53	java/io/File:delete	()Z
    //   272: pop
    //   273: aload_1
    //   274: iload 8
    //   276: aconst_null
    //   277: aastore
    //   278: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +240 -> 521
    //   284: ldc 83
    //   286: iconst_2
    //   287: new 85	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   294: ldc -7
    //   296: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 4
    //   301: aload 6
    //   303: invokevirtual 253	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 128	java/lang/String
    //   309: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc -1
    //   314: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 6
    //   319: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: goto +193 -> 521
    //   331: aload_1
    //   332: astore 4
    //   334: iload 9
    //   336: ifle +70 -> 406
    //   339: aload_1
    //   340: arraylength
    //   341: iload 9
    //   343: isub
    //   344: anewarray 28	java/io/File
    //   347: astore 4
    //   349: iconst_0
    //   350: istore 7
    //   352: iload 10
    //   354: istore 8
    //   356: iload 8
    //   358: aload_1
    //   359: arraylength
    //   360: if_icmpge +46 -> 406
    //   363: iload 7
    //   365: aload 4
    //   367: arraylength
    //   368: if_icmpge +38 -> 406
    //   371: aload_1
    //   372: iload 8
    //   374: aaload
    //   375: ifnull +143 -> 518
    //   378: iload 7
    //   380: iconst_1
    //   381: iadd
    //   382: istore 9
    //   384: aload 4
    //   386: iload 7
    //   388: aload_1
    //   389: iload 8
    //   391: aaload
    //   392: aastore
    //   393: iload 9
    //   395: istore 7
    //   397: iload 8
    //   399: iconst_1
    //   400: iadd
    //   401: istore 8
    //   403: goto -47 -> 356
    //   406: aload_3
    //   407: ifnull +9 -> 416
    //   410: aload_3
    //   411: invokeinterface 258 1 0
    //   416: aload 4
    //   418: astore 5
    //   420: aload_2
    //   421: ifnull +11 -> 432
    //   424: aload_2
    //   425: invokevirtual 260	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   428: aload 4
    //   430: astore 5
    //   432: aload 5
    //   434: areturn
    //   435: astore_2
    //   436: aconst_null
    //   437: astore_2
    //   438: aload_2
    //   439: ifnull +9 -> 448
    //   442: aload_2
    //   443: invokeinterface 258 1 0
    //   448: aload_1
    //   449: astore 5
    //   451: aload_3
    //   452: ifnull -20 -> 432
    //   455: aload_3
    //   456: invokevirtual 260	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   459: aload_1
    //   460: areturn
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_3
    //   464: aload 4
    //   466: astore_2
    //   467: aload_3
    //   468: ifnull +9 -> 477
    //   471: aload_3
    //   472: invokeinterface 258 1 0
    //   477: aload_2
    //   478: ifnull +7 -> 485
    //   481: aload_2
    //   482: invokevirtual 260	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   485: aload_1
    //   486: athrow
    //   487: astore_1
    //   488: aconst_null
    //   489: astore_3
    //   490: goto -23 -> 467
    //   493: astore_1
    //   494: goto -27 -> 467
    //   497: astore_3
    //   498: aload_2
    //   499: astore_3
    //   500: aconst_null
    //   501: astore_2
    //   502: goto -64 -> 438
    //   505: astore 4
    //   507: aload_2
    //   508: astore 4
    //   510: aload_3
    //   511: astore_2
    //   512: aload 4
    //   514: astore_3
    //   515: goto -77 -> 438
    //   518: goto -121 -> 397
    //   521: iload 7
    //   523: iconst_1
    //   524: iadd
    //   525: istore 9
    //   527: iload 8
    //   529: iconst_1
    //   530: iadd
    //   531: istore 8
    //   533: iload 9
    //   535: istore 7
    //   537: goto -316 -> 221
    //   540: iconst_0
    //   541: istore 11
    //   543: goto -400 -> 143
    //   546: iconst_0
    //   547: istore 9
    //   549: goto -218 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	qiw
    //   0	552	1	paramArrayOfFile	File[]
    //   27	398	2	localEntityManager	EntityManager
    //   435	1	2	localException1	Exception
    //   437	75	2	localObject1	Object
    //   1	489	3	localCursor	android.database.Cursor
    //   497	1	3	localException2	Exception
    //   499	16	3	localObject2	Object
    //   3	462	4	localObject3	Object
    //   505	1	4	localException3	Exception
    //   508	5	4	localObject4	Object
    //   6	444	5	localObject5	Object
    //   132	186	6	localObject6	Object
    //   120	416	7	i	int
    //   216	316	8	j	int
    //   223	325	9	k	int
    //   9	344	10	m	int
    //   141	401	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	28	435	java/lang/Exception
    //   11	28	461	finally
    //   28	68	487	finally
    //   80	104	493	finally
    //   104	134	493	finally
    //   143	169	493	finally
    //   169	202	493	finally
    //   207	215	493	finally
    //   225	232	493	finally
    //   238	245	493	finally
    //   249	273	493	finally
    //   278	328	493	finally
    //   339	349	493	finally
    //   356	371	493	finally
    //   28	68	497	java/lang/Exception
    //   80	104	505	java/lang/Exception
    //   104	134	505	java/lang/Exception
    //   143	169	505	java/lang/Exception
    //   169	202	505	java/lang/Exception
    //   207	215	505	java/lang/Exception
    //   225	232	505	java/lang/Exception
    //   238	245	505	java/lang/Exception
    //   249	273	505	java/lang/Exception
    //   278	328	505	java/lang/Exception
    //   339	349	505	java/lang/Exception
    //   356	371	505	java/lang/Exception
  }
  
  private File[] a(File[] paramArrayOfFile, int paramInt)
  {
    int m = 0;
    EntityManager localEntityManager = null;
    localObject2 = localEntityManager;
    for (;;)
    {
      try
      {
        localObject3 = new LinkedList();
        localObject2 = localEntityManager;
        localEntityManager = CleanCache.d(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.a().createEntityManager();
        localObject2 = localEntityManager;
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject5;
        int k;
        Object localObject3 = paramArrayOfFile;
        if (localObject2 == null) {
          continue;
        }
        ((EntityManager)localObject2).a();
        return paramArrayOfFile;
      }
      finally
      {
        Object localObject1 = null;
        if (localObject1 != null) {
          ((EntityManager)localObject1).a();
        }
      }
      try
      {
        localObject4 = (ArrayList)localEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
        if (localObject4 != null)
        {
          localObject2 = localEntityManager;
          if (((ArrayList)localObject4).size() != 0)
          {
            i = 0;
            localObject2 = localEntityManager;
            if (i < ((ArrayList)localObject4).size())
            {
              localObject2 = localEntityManager;
              localObject5 = (Friends)((ArrayList)localObject4).get(i);
              localObject2 = localEntityManager;
              ((LinkedList)localObject3).add(CleanCache.e(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.a(false, ((Friends)localObject5).uin));
              i += 1;
              continue;
            }
          }
        }
        localObject2 = localEntityManager;
        localObject4 = (ArrayList)localEntityManager.a(TroopInfo.class, false, null, null, null, null, null, null);
        if (localObject4 == null) {
          break label589;
        }
        localObject2 = localEntityManager;
        if (((ArrayList)localObject4).size() <= 0) {
          break label589;
        }
        i = 0;
        localObject2 = localEntityManager;
        if (i >= ((ArrayList)localObject4).size()) {
          break label589;
        }
        localObject2 = localEntityManager;
        localObject5 = (TroopInfo)((ArrayList)localObject4).get(i);
        localObject2 = localEntityManager;
        ((LinkedList)localObject3).add(CleanCache.f(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.a(true, ((TroopInfo)localObject5).troopuin));
        i += 1;
        continue;
      }
      finally
      {
        continue;
        continue;
        j = 0;
        i = 0;
        continue;
      }
      k = i;
      localObject2 = localEntityManager;
      if (j < paramArrayOfFile.length)
      {
        localObject4 = paramArrayOfFile[j];
        localObject2 = localEntityManager;
        localObject5 = ((File)localObject4).getAbsolutePath();
        k = i;
        localObject2 = localEntityManager;
        if (!((LinkedList)localObject3).contains(localObject5))
        {
          k = i;
          localObject2 = localEntityManager;
          if (((String)localObject5).indexOf("discussion_") < 0)
          {
            k = i;
            localObject2 = localEntityManager;
            if (((String)localObject5).indexOf("sys_") < 0)
            {
              localObject2 = localEntityManager;
              if (((File)localObject4).exists())
              {
                localObject2 = localEntityManager;
                ((File)localObject4).delete();
              }
              paramArrayOfFile[j] = null;
              i += 1;
              localObject2 = localEntityManager;
              if (QLog.isColorLevel())
              {
                localObject2 = localEntityManager;
                QLog.d("QQInitHandler", 2, "onCleanCache->delSecondaryQQHead. delete QQHead,filePath=" + ((File)localObject4).getAbsolutePath());
              }
              k = i;
              localObject2 = localEntityManager;
              if (paramInt + i >= this.jdField_a_of_type_Int) {
                k = i;
              }
            }
          }
        }
      }
      else
      {
        localObject2 = paramArrayOfFile;
        if (k <= 0) {
          continue;
        }
        localObject2 = localEntityManager;
        localObject3 = new File[paramArrayOfFile.length - k];
        paramInt = 0;
        i = m;
        localObject2 = localEntityManager;
        if (i >= paramArrayOfFile.length) {
          continue;
        }
        localObject2 = localEntityManager;
        if (paramInt >= localObject3.length) {
          continue;
        }
        if (paramArrayOfFile[i] == null) {
          break label586;
        }
        j = paramInt + 1;
        localObject3[paramInt] = paramArrayOfFile[i];
        paramInt = j;
        i += 1;
        continue;
      }
      j += 1;
      i = k;
    }
    localObject2 = localObject3;
    localObject3 = localObject2;
    if (localEntityManager != null)
    {
      localEntityManager.a();
      localObject3 = localObject2;
    }
    return (File[])localObject3;
  }
  
  public void run()
  {
    int m = 0;
    int j;
    Object localObject2;
    int k;
    int i1;
    try
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = AppConstants.bG;
      arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
      j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label369;
      }
      localObject2 = new File(arrayOfString[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label790;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 3000)) {
        break label790;
      }
      k = localObject2.length;
      n = localObject2.length;
      this.jdField_a_of_type_Int = (k - 2500);
      localObject2 = a((File[])localObject2);
      n = n - localObject2.length + 0;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delTemporaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
      }
      if (n >= this.jdField_a_of_type_Int) {
        break label790;
      }
      Arrays.sort((Object[])localObject2, new qix(this));
      i1 = localObject2.length;
      localObject2 = a((File[])localObject2, n);
      n += i1 - localObject2.length;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delSecondaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
      }
      if (n >= this.jdField_a_of_type_Int) {
        break label790;
      }
      n = a((File[])localObject2, n);
      if (!QLog.isColorLevel()) {
        break label790;
      }
      QLog.d("QQInitHandler", 2, "onCleanCache. after delRemainQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    label353:
    CleanCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).a(40001, true, null);
    return;
    label369:
    Object localObject1 = new String[2];
    localObject1[0] = AppConstants.bK;
    localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_stranger/";
    int n = localObject1.length;
    int i = 0;
    label393:
    if (i < n)
    {
      localObject2 = new File(localObject1[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label823;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 300)) {
        break label823;
      }
      Arrays.sort((Object[])localObject2, new qiy(this));
      i1 = localObject2.length;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      if (j < i1)
      {
        Object localObject3 = localObject2[j];
        if (!((File)localObject3).exists()) {
          break label799;
        }
        ((File)localObject3).delete();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label823;
        }
        QLog.d("QQInitHandler", 2, "onCleanCache. delete stranger head...");
        break label823;
        localObject1 = new File[6];
        localObject1[0] = URLDrawableHelper.a;
        localObject1[1] = new File(AppConstants.bj + "photo");
        localObject1[2] = new File(AppConstants.bj + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache.a() + "/ptt/");
        localObject1[3] = new File(AppConstants.bj + "shortvideo/thumbs");
        localObject1[4] = new File(AppConstants.bj + "ptv_template");
        localObject1[5] = new File(AppConstants.bj + "head/" + File.separator + "_dynamic");
        k = localObject1.length;
        j = 0;
        i = m;
        while (i < k)
        {
          j += a(localObject1[i]);
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache. delete " + j + " cache file(s)");
        }
        a();
        break label353;
        label790:
        i += 1;
        break;
        label799:
        localObject2[j] = null;
        k += 1;
        if (i1 - k > 20) {
          break label832;
        }
      }
      label823:
      i += 1;
      break label393;
      label832:
      j += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */