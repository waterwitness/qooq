package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable.MutilePlayInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import wer;
import wes;
import wet;
import weu;
import wev;

public class PendantInfo
  implements VipPendantDrawable.MutilePlayInfo
{
  static int jdField_a_of_type_Int = 0;
  public static final String a = "PendantInfo";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  static final int jdField_b_of_type_Int = 16;
  static final int jdField_c_of_type_Int = 17;
  private static final String jdField_c_of_type_JavaLangString = "dynamic_pendant";
  static final int jdField_d_of_type_Int = 18;
  private static final String jdField_d_of_type_JavaLangString = "static_pendant";
  static final int jdField_e_of_type_Int = 19;
  static final int f = 20;
  static final int g = 0;
  static final int h = 1;
  public static int i = 1;
  public static int j = 2;
  public static int k = 3;
  public static int l = 4;
  public static int m = 5;
  public static int n = 6;
  public static int o = 7;
  public static int p = Integer.MIN_VALUE;
  public static int q = 100;
  public static int r = Integer.MAX_VALUE;
  public static int s = 3;
  private static final int w = 7;
  private static int x;
  private int A;
  public long a;
  protected Context a;
  public Bitmap a;
  protected AppInterface a;
  public PendantInfo.AnimationLruCache a;
  public PendantInfo.DecodeNextFrameTask a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wet(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  protected Object a;
  public MqqHandler a;
  public boolean a;
  public String[] a;
  DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new weu(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  public int t;
  public int u = -1;
  public int v = s;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1000;
    x = 20;
  }
  
  public PendantInfo(AppInterface paramAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.t = -1;
    this.z = -1;
    this.y = -1;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_MqqOsMqqHandler = new wer(this, Looper.getMainLooper(), null);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramAppInterface.getManager(46));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache = new PendantInfo.AnimationLruCache(this, x);
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4));
    if (!((File)localObject).exists())
    {
      str = AvatarPendantUtil.b(this.jdField_a_of_type_Long, 4);
      localBundle = new Bundle();
      localBundle.putLong("id", this.jdField_a_of_type_Long);
      localBundle.putInt("pendantResType", paramInt);
      localBundle.putLong("targetId", paramLong);
      localObject = new DownloadTask(str, (File)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    }
    while (!a((File)localObject, paramInt))
    {
      String str;
      Bundle localBundle;
      return;
    }
    a(paramLong, paramInt);
  }
  
  private void a(Bitmap paramBitmap)
  {
    int i1 = Utils.a(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources(), paramBitmap);
    localBitmapDrawable.setTargetDensity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources().getDisplayMetrics());
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "setPendantBitmap cache key equal null");
      }
      localStringBuilder = AIOUtils.a();
      if (this.t != 2) {
        break label145;
      }
    }
    label145:
    for (paramBitmap = "dynamic_pendant";; paramBitmap = "static_pendant")
    {
      this.jdField_b_of_type_JavaLangString = (paramBitmap + "_" + this.jdField_a_of_type_Long + "_" + this.t);
      BaseApplicationImpl.a.put(this.jdField_b_of_type_JavaLangString, new Pair(localBitmapDrawable.getConstantState(), Integer.valueOf(i1)));
      return;
    }
  }
  
  private void a(String paramString)
  {
    int i1;
    if (paramString != null)
    {
      i1 = paramString.indexOf("\"interval\":");
      if (i1 == -1) {
        break label112;
      }
      int i2 = paramString.indexOf(",", i1 + 10);
      if (i2 == -1) {
        break label112;
      }
      paramString = paramString.substring(i1 + 11, i2);
      if (paramString == null) {
        break label112;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString.trim());
        if (Integer.MIN_VALUE != i1)
        {
          this.z = i1;
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.z));
          return;
        }
      }
      catch (Exception paramString)
      {
        i1 = Integer.MIN_VALUE;
        continue;
        this.z = q;
        a(1, 7, 0L);
        return;
      }
      label112:
      i1 = Integer.MIN_VALUE;
    }
  }
  
  private boolean a()
  {
    Pair localPair = (Pair)BaseApplicationImpl.a.get(this.jdField_b_of_type_JavaLangString);
    return (localPair != null) && (localPair.first != null);
  }
  
  public static boolean a(Message paramMessage, long paramLong)
  {
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null)
    {
      localBundle = new Bundle();
      localBundle.putLong("targetId", paramLong);
      paramMessage.setData(localBundle);
      return true;
    }
    try
    {
      localBundle.putLong("targetId", paramLong);
      return true;
    }
    catch (ClassCastException paramMessage)
    {
      QLog.e("PendantInfo", 1, "pendant can not display because of system error!");
    }
    return false;
  }
  
  private Bitmap b()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "getPendantBitmap cache key equal null");
      }
      localStringBuilder = AIOUtils.a();
      if (this.t != 2) {
        break label127;
      }
    }
    label127:
    for (Object localObject = "dynamic_pendant";; localObject = "static_pendant")
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject + "_" + this.jdField_a_of_type_Long + "_" + this.t);
      localObject = (Pair)BaseApplicationImpl.a.get(this.jdField_b_of_type_JavaLangString);
      if ((localObject == null) || (((Pair)localObject).first == null)) {
        break;
      }
      return ((BitmapDrawable)((Drawable.ConstantState)((Pair)localObject).first).newDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getResources())).getBitmap();
    }
    return null;
  }
  
  private void e()
  {
    try
    {
      if (((this.jdField_a_of_type_JavaLangObject instanceof wev)) && (a()))
      {
        if ((this.jdField_a_of_type_JavaLangObject != null) && (((wev)this.jdField_a_of_type_JavaLangObject).a != null) && (((wev)this.jdField_a_of_type_JavaLangObject).a.equals(this.e))) {
          return;
        }
        if (this.c) {}
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask != null)
      {
        Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
        if (!a(localMessage, m)) {
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    this.jdField_a_of_type_JavaLangObject = new wev(this, this.e);
    this.v = 0;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject, m);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.z;
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.u), Long.valueOf(this.t) });
  }
  
  public int a(int paramInt)
  {
    if (paramInt == this.A - 1)
    {
      this.v -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public Bitmap a()
  {
    return b();
  }
  
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if (paramInt1 == 2) {
      if (paramObject == null) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    do
    {
      return null;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      paramObject = (String[])paramObject;
      String str = paramObject[((paramInt2 + 1) % paramObject.length)];
      localOptions.inDensity = 320;
      localOptions.inTargetDensity = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources().getDisplayMetrics().densityDpi;
      if (localOptions.inDensity < localOptions.inTargetDensity) {
        localOptions.inDensity = localOptions.inTargetDensity;
      }
      FileInputStream localFileInputStream = new FileInputStream(str);
      for (;;)
      {
        try
        {
          if ((Build.VERSION.SDK_INT > 11) && (localOptions.inDensity <= localOptions.inTargetDensity))
          {
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              continue;
            }
            localOptions.inBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
            localOptions.inMutable = true;
            localOptions.inSampleSize = 1;
          }
          paramObject = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, localOptions);
        }
        catch (OutOfMemoryError paramObject)
        {
          QLog.e("PendantInfo", 1, "doDecodeNext, oom=" + MsfSdkUtils.getStackTraceString((Throwable)paramObject));
          paramObject = localObject3;
          continue;
        }
        catch (IllegalArgumentException paramObject)
        {
          QLog.e("PendantInfo", 1, "doDecodeNext, IllegalArgumentException=" + MsfSdkUtils.getStackTraceString((Throwable)paramObject));
          localOptions.inBitmap = null;
          localOptions.inMutable = false;
        }
        try
        {
          localFileInputStream.close();
          return (Bitmap)paramObject;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return (Bitmap)paramObject;
        }
        localOptions.inBitmap = null;
        continue;
        try
        {
          paramObject = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, localOptions);
          localObject2 = paramObject;
        }
        catch (OutOfMemoryError paramObject)
        {
          for (;;)
          {
            QLog.e("PendantInfo", 1, "doDecodeNext, try not reuse bitmap, oom=" + MsfSdkUtils.getStackTraceString((Throwable)paramObject));
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            QLog.e("PendantInfo", 1, "doDecodeNext, try not reuse bitmap, exception=" + MsfSdkUtils.getStackTraceString((Throwable)paramObject));
          }
        }
        QLog.e("PendantInfo", 1, "doDecodeNext, maybe reuse failed, path=" + str);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          QLog.e("PendantInfo", 1, "doDecodeNext, mRecycleBitmap width=" + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + ", height=" + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        }
        paramObject = localObject2;
        if (localObject2 != null)
        {
          QLog.e("PendantInfo", 1, "doDecodeNext, bitmap width=" + ((Bitmap)localObject2).getWidth() + ", height=" + ((Bitmap)localObject2).getHeight());
          paramObject = localObject2;
        }
      }
      Object localObject2 = new BitmapFactory.Options();
      paramObject = (wev)paramObject;
      ((BitmapFactory.Options)localObject2).inDensity = 320;
      ((BitmapFactory.Options)localObject2).inTargetDensity = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources().getDisplayMetrics().densityDpi;
      if (((BitmapFactory.Options)localObject2).inDensity < ((BitmapFactory.Options)localObject2).inTargetDensity) {
        ((BitmapFactory.Options)localObject2).inDensity = ((BitmapFactory.Options)localObject2).inTargetDensity;
      }
      try
      {
        paramObject = SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(((wev)paramObject).a)), null, (BitmapFactory.Options)localObject2);
        return (Bitmap)paramObject;
      }
      catch (OutOfMemoryError paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.i("PendantInfo", 2, "decodeFile failed OOM");
    return null;
  }
  
  public Drawable a(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    if (paramAppInterface == null) {
      return null;
    }
    this.t = paramInt;
    StringBuilder localStringBuilder = AIOUtils.a();
    if (this.t == 2)
    {
      paramAppInterface = "dynamic_pendant";
      this.jdField_b_of_type_JavaLangString = (paramAppInterface + "_" + this.jdField_a_of_type_Long + "_" + this.t);
      paramAppInterface = (VipPendantDrawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
      if (paramAppInterface != null) {
        break label147;
      }
      paramAppInterface = new VipPendantDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources());
      paramAppInterface.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramAppInterface);
    }
    label147:
    for (;;)
    {
      ThreadManager.a(new wes(this, paramInt, paramLong, paramAppInterface), 8, null, true);
      return paramAppInterface;
      paramAppInterface = "static_pendant";
      break;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 137	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   18: bipush 8
    //   20: invokestatic 199	com/tencent/mobileqq/utils/AvatarPendantUtil:a	(JI)Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 592	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   28: ifeq -17 -> 11
    //   31: aload_1
    //   32: invokestatic 595	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 600	java/util/ArrayList:size	()I
    //   40: ifle -29 -> 11
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 600	java/util/ArrayList:size	()I
    //   48: anewarray 343	java/lang/String
    //   51: putfield 145	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   54: new 286	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 438	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 603	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_2
    //   75: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: iconst_0
    //   80: istore_3
    //   81: aload_0
    //   82: getfield 145	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   85: arraylength
    //   86: istore 4
    //   88: iload_3
    //   89: iload 4
    //   91: if_icmpge -80 -> 11
    //   94: aload_0
    //   95: getfield 145	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   98: iload_3
    //   99: invokestatic 284	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_3
    //   107: iconst_1
    //   108: iadd
    //   109: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 605
    //   115: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aastore
    //   122: iload_3
    //   123: iconst_1
    //   124: iadd
    //   125: istore_3
    //   126: goto -38 -> 88
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	PendantInfo
    //   6	97	1	localObject1	Object
    //   129	4	1	localObject2	Object
    //   35	40	2	localObject3	Object
    //   80	46	3	i1	int
    //   86	6	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   2	7	129	finally
    //   14	79	129	finally
    //   81	88	129	finally
    //   94	122	129	finally
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "download pendant report actionResult=" + paramInt1 + ",pendantId=" + this.jdField_a_of_type_Long + ",type=" + paramInt2);
      }
      int i1 = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
      if (paramLong < 3600000L) {
        VasWebviewUtil.reportVasStatus("AvatarPendant", "download", String.valueOf(this.jdField_a_of_type_Long), 0, 0, paramInt1, i1, String.valueOf(paramLong), String.valueOf(paramInt2));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    long l1;
    long l2;
    if ((this.jdField_a_of_type_Boolean) && (!this.c))
    {
      this.jdField_a_of_type_Boolean = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.z;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_ArrayOfJavaLangString, paramLong);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.u), Long.valueOf(this.t) });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = new File(AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt));
    String str = AvatarPendantUtil.b(this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getPendantInfo pendantId=" + this.jdField_a_of_type_Long + " will down " + ",file path=" + ((File)localObject).getAbsolutePath());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("name", ((File)localObject).getAbsolutePath());
    localBundle.putLong("id", this.jdField_a_of_type_Long);
    localBundle.putLong("targetId", paramLong);
    localBundle.putInt("pendantResType", paramInt);
    localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).j = false;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    this.e = AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt);
    Drawable localDrawable = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt, paramLong);
    if ((paramView instanceof BaseChatItemLayout)) {
      ((BaseChatItemLayout)paramView).setPendantImage(localDrawable);
    }
    while (!(paramView instanceof ImageView)) {
      return;
    }
    ((ImageView)paramView).setImageDrawable(localDrawable);
  }
  
  public void a(VipPendantDrawable paramVipPendantDrawable, long paramLong)
  {
    if ((paramVipPendantDrawable == null) || (this.jdField_a_of_type_ArrayOfJavaLangString == null)) {}
    label151:
    label172:
    for (;;)
    {
      return;
      paramVipPendantDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString, this.z);
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.A = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      boolean bool;
      if ((!this.jdField_b_of_type_Boolean) && (this.v > 3))
      {
        bool = true;
        if (paramLong != o) {
          break label151;
        }
        this.jdField_b_of_type_Boolean = false;
        this.v = r;
        a(o);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.d("PendantInfo", 2, "setPngsDrawable repeatCount:" + this.v + ",targetID:" + paramLong + ",pendantInMarket:" + bool);
        return;
        bool = false;
        break;
        if (!bool)
        {
          this.v = s;
          a(m);
        }
      }
    }
  }
  
  public void a(VipPendantDrawable paramVipPendantDrawable, boolean paramBoolean, long paramLong)
  {
    if (paramVipPendantDrawable == null) {}
    for (;;)
    {
      return;
      try
      {
        e();
        this.v = 0;
        paramVipPendantDrawable.a(this.e);
        paramVipPendantDrawable = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
        if (paramBoolean) {
          paramLong = m;
        }
        if (!a(paramVipPendantDrawable, paramLong)) {
          continue;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramVipPendantDrawable);
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    try
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(18);
      if (a(localMessage, m)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 2, "bundle exception" + localException.getMessage());
    }
  }
  
  public boolean a(File paramFile, int paramInt)
  {
    if (paramFile == null) {
      return false;
    }
    Integer localInteger = (Integer)AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
    String str1 = null;
    Object localObject;
    int i1;
    if ((paramFile.exists()) && (localInteger == null))
    {
      localObject = FileUtils.a(paramFile);
      if (localObject != null)
      {
        str1 = new String((byte[])localObject);
        i1 = str1.indexOf("\"type\":");
        if (i1 != -1)
        {
          int i2 = str1.indexOf(",", i1 + 6);
          if (i2 != -1) {
            localObject = str1.substring(i1 + 7, i2);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(((String)localObject).trim());
        a(1, 7, 0L);
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "pendant type=" + i1);
          }
          this.y = i1;
          AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(i1));
          if (i1 != Integer.MIN_VALUE) {
            break label347;
          }
          paramFile.delete();
          a(1, 7, 0L);
          if ((-1 == this.z) && (paramInt == 2))
          {
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long))) {
              break label368;
            }
            this.z = ((Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long))).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("PendantInfo", 2, "parsePendantConfig, read interval from cache=" + this.z + ", id=" + this.jdField_a_of_type_Long);
            }
          }
          if ((localInteger == null) || (localInteger.intValue() != 0) || (paramInt != 2)) {
            break label500;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "static pendant, abort dynamic request");
          }
          return false;
        }
        catch (Exception localException2)
        {
          String str2;
          for (;;) {}
        }
        localException1 = localException1;
        i1 = Integer.MIN_VALUE;
      }
      continue;
      label347:
      localInteger = (Integer)AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
      continue;
      label368:
      str2 = str1;
      if (str1 == null)
      {
        str2 = str1;
        if (!paramFile.exists()) {}
      }
      try
      {
        str2 = FileUtils.b(paramFile);
        a(str2);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          str2 = str1;
          if (QLog.isColorLevel())
          {
            QLog.e("PendantInfo", 2, "parsePendantConfig, read config file exception: " + paramFile + ", " + MsfSdkUtils.getStackTraceString(localIOException));
            str2 = str1;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          String str3 = str1;
          if (QLog.isColorLevel())
          {
            QLog.e("PendantInfo", 2, "parsePendantConfig, read config file oom: " + paramFile);
            str3 = str1;
          }
        }
      }
      label500:
      return true;
      i1 = Integer.MIN_VALUE;
      continue;
      i1 = Integer.MIN_VALUE;
      continue;
      str1 = null;
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.clear();
    d();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\PendantInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */