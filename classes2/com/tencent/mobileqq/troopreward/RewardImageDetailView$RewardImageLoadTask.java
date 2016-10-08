package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicHeader;
import vvu;

public class RewardImageDetailView$RewardImageLoadTask
  implements HttpDownloadUtil.DownloadInfoListener, Runnable
{
  public static final int a = 0;
  public static final int b = 1;
  protected static final int c = 2;
  protected static final int d = 8;
  protected static final int e = 15;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public String c;
  String d;
  int f;
  public int g;
  
  public RewardImageDetailView$RewardImageLoadTask(String paramString1, String paramString2, String paramString3, int paramInt, View paramView, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    this.g = -1;
    this.d = "clear";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.g = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
  }
  
  protected Bitmap a(byte[] paramArrayOfByte)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return null;
    }
    int i = ((View)localObject).getHeight();
    int j = ((View)localObject).getWidth();
    int k;
    int m;
    if ((i == 0) || (j == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.w(".troop.troop_reward.image", 2, "processBitmap,  view not ready, sleep");
      }
      try
      {
        Thread.sleep(800L);
        k = ((View)localObject).getHeight();
        m = ((View)localObject).getWidth();
        if (k != 0)
        {
          j = m;
          i = k;
          if (m != 0) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w(".troop.troop_reward.image", 2, "processBitmap return, view.w=" + m + ", view.h=" + k);
          }
          return null;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if (this.g == 0)
    {
      k = ((BitmapFactory.Options)localObject).outHeight;
      m = ((BitmapFactory.Options)localObject).outWidth;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.image", 2, "processBitmap, type=blur, bytes.len=" + paramArrayOfByte.length + ", bmp.w=" + m + ", bmp.h=" + k + ", view.w=" + j + ", view.h=" + i);
      }
      if ((m <= 80) || (k <= 80)) {
        break label804;
      }
      k = j / 8;
      j = i / 8;
      i = k;
      k = 8;
    }
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = k;
      localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
      m = ((Bitmap)localObject).getHeight();
      int n = ((Bitmap)localObject).getWidth();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.image", 2, "afterScale: bmp.w=" + n + ", bmp.h=" + m + ", view.w=" + i + ", view.h=" + j + ", sampleSize=" + k);
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-16777216);
      paramArrayOfByte = new RectF(0.0F, 0.0F, i, j);
      float f1 = i * 1.0F / j;
      float f2 = n * 1.0F / m;
      if (f1 > f2)
      {
        k = (int)(n * 1.0F * j / m);
        i = (i - k) / 2;
        paramArrayOfByte = new RectF(i, 0.0F, i + k, j);
      }
      for (;;)
      {
        localCanvas.drawBitmap((Bitmap)localObject, null, paramArrayOfByte, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (!((Bitmap)localObject).isRecycled()) {
          ((Bitmap)localObject).recycle();
        }
        long l1 = 0L;
        if (QLog.isColorLevel()) {
          l1 = System.currentTimeMillis();
        }
        StackBlur.a(localBitmap, 15);
        if (QLog.isColorLevel())
        {
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward.image", 2, "fastblur costTime=" + (l2 - l1));
          }
        }
        return localBitmap;
        if (f1 < f2)
        {
          k = (int)(m * 1.0F * i / n);
          j = (j - k) / 2;
          paramArrayOfByte = new RectF(0.0F, j, i, j + k);
        }
      }
      k = RewardImageDetailView.a((BitmapFactory.Options)localObject, j, i);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = k;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.image", 2, "processBitmap, type=clear, bytes.len=" + paramArrayOfByte.length + ", bmp.w=" + ((BitmapFactory.Options)localObject).outWidth + ", bmp.h=" + ((BitmapFactory.Options)localObject).outHeight + ", view.w=" + j + ", view.h=" + i + ", sampleSize=" + k);
      }
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
      label804:
      m = i;
      i = j;
      k = 1;
      j = m;
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    Object localObject = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Handler localHandler = (Handler)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && (paramBitmap != null) && (localHandler != null)) {
      localHandler.post(new vvu(this, (View)localObject, paramBitmap));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("setBitmap, targetView isNUll=");
    if (localObject == null)
    {
      bool1 = true;
      localObject = localStringBuilder.append(bool1).append(", rawBitmap isNull=");
      if (paramBitmap != null) {
        break label142;
      }
      bool1 = true;
      label100:
      paramBitmap = ((StringBuilder)localObject).append(bool1).append(", handler isNull=");
      if (localHandler != null) {
        break label148;
      }
    }
    label142:
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d(".troop.troop_reward.image", 2, bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label100;
    }
  }
  
  /* Error */
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +45 -> 48
    //   6: ldc 98
    //   8: iconst_2
    //   9: new 114	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 259
    //   19: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: getfield 263	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   26: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 265
    //   32: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 43	com/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask:d	Ljava/lang/String;
    //   39: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 263	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   52: ifne +105 -> 157
    //   55: aload_1
    //   56: getfield 268	com/tencent/mobileqq/emoticon/DownloadInfo:a	Ljava/net/HttpURLConnection;
    //   59: ifnull +98 -> 157
    //   62: new 270	java/io/BufferedInputStream
    //   65: dup
    //   66: aload_1
    //   67: getfield 268	com/tencent/mobileqq/emoticon/DownloadInfo:a	Ljava/net/HttpURLConnection;
    //   70: invokevirtual 276	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   73: invokespecial 279	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_2
    //   77: aload_2
    //   78: astore_1
    //   79: sipush 4096
    //   82: newarray <illegal type>
    //   84: astore 4
    //   86: aload_2
    //   87: astore_1
    //   88: new 281	java/io/ByteArrayOutputStream
    //   91: dup
    //   92: ldc_w 282
    //   95: invokespecial 284	java/io/ByteArrayOutputStream:<init>	(I)V
    //   98: astore_3
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload 4
    //   104: invokevirtual 290	java/io/InputStream:read	([B)I
    //   107: istore 5
    //   109: iload 5
    //   111: ifle +48 -> 159
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: aload 4
    //   119: iconst_0
    //   120: iload 5
    //   122: invokevirtual 294	java/io/ByteArrayOutputStream:write	([BII)V
    //   125: goto -26 -> 99
    //   128: astore_3
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +15 -> 149
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 98
    //   141: iconst_2
    //   142: ldc_w 296
    //   145: aload_3
    //   146: invokestatic 299	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 302	java/io/InputStream:close	()V
    //   157: iconst_1
    //   158: ireturn
    //   159: aload_2
    //   160: astore_1
    //   161: aload_3
    //   162: invokevirtual 305	java/io/ByteArrayOutputStream:flush	()V
    //   165: aload_2
    //   166: astore_1
    //   167: aload_0
    //   168: aload_3
    //   169: invokevirtual 309	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   172: invokevirtual 311	com/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask:a	([B)Landroid/graphics/Bitmap;
    //   175: astore 4
    //   177: aload_2
    //   178: astore_1
    //   179: aload_3
    //   180: invokevirtual 312	java/io/ByteArrayOutputStream:close	()V
    //   183: aload 4
    //   185: ifnull +39 -> 224
    //   188: aload_2
    //   189: astore_1
    //   190: aload_0
    //   191: aload 4
    //   193: invokevirtual 314	com/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask:a	(Landroid/graphics/Bitmap;)V
    //   196: aload_2
    //   197: astore_1
    //   198: aload_0
    //   199: getfield 39	com/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask:g	I
    //   202: ifne +39 -> 241
    //   205: aload_2
    //   206: astore_1
    //   207: new 316	vvt
    //   210: dup
    //   211: aload_0
    //   212: aload 4
    //   214: invokespecial 319	vvt:<init>	(Lcom/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask;Landroid/graphics/Bitmap;)V
    //   217: bipush 8
    //   219: aconst_null
    //   220: iconst_1
    //   221: invokestatic 324	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   224: aload_2
    //   225: ifnull -68 -> 157
    //   228: aload_2
    //   229: invokevirtual 302	java/io/InputStream:close	()V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   239: iconst_1
    //   240: ireturn
    //   241: aload_2
    //   242: astore_1
    //   243: aload_0
    //   244: getfield 39	com/tencent/mobileqq/troopreward/RewardImageDetailView$RewardImageLoadTask:g	I
    //   247: istore 5
    //   249: iload 5
    //   251: iconst_1
    //   252: if_icmpne -28 -> 224
    //   255: goto -31 -> 224
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_3
    //   266: aconst_null
    //   267: astore_2
    //   268: aload_2
    //   269: astore_1
    //   270: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +15 -> 288
    //   276: aload_2
    //   277: astore_1
    //   278: ldc 98
    //   280: iconst_2
    //   281: ldc_w 327
    //   284: aload_3
    //   285: invokestatic 299	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_2
    //   289: ifnull -132 -> 157
    //   292: aload_2
    //   293: invokevirtual 302	java/io/InputStream:close	()V
    //   296: iconst_1
    //   297: ireturn
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   303: iconst_1
    //   304: ireturn
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_1
    //   308: aload_1
    //   309: ifnull +7 -> 316
    //   312: aload_1
    //   313: invokevirtual 302	java/io/InputStream:close	()V
    //   316: aload_2
    //   317: athrow
    //   318: astore_1
    //   319: aload_1
    //   320: invokevirtual 325	java/io/IOException:printStackTrace	()V
    //   323: goto -7 -> 316
    //   326: astore_2
    //   327: goto -19 -> 308
    //   330: astore_3
    //   331: goto -63 -> 268
    //   334: astore_3
    //   335: aconst_null
    //   336: astore_2
    //   337: goto -208 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	RewardImageLoadTask
    //   0	340	1	paramDownloadInfo	DownloadInfo
    //   76	217	2	localBufferedInputStream	java.io.BufferedInputStream
    //   305	12	2	localObject1	Object
    //   326	1	2	localObject2	Object
    //   336	1	2	localObject3	Object
    //   98	19	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   128	52	3	localException1	Exception
    //   265	20	3	localOutOfMemoryError1	OutOfMemoryError
    //   330	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   334	1	3	localException2	Exception
    //   84	129	4	localObject4	Object
    //   107	146	5	i	int
    // Exception table:
    //   from	to	target	type
    //   79	86	128	java/lang/Exception
    //   88	99	128	java/lang/Exception
    //   101	109	128	java/lang/Exception
    //   116	125	128	java/lang/Exception
    //   161	165	128	java/lang/Exception
    //   167	177	128	java/lang/Exception
    //   179	183	128	java/lang/Exception
    //   190	196	128	java/lang/Exception
    //   198	205	128	java/lang/Exception
    //   207	224	128	java/lang/Exception
    //   243	249	128	java/lang/Exception
    //   228	232	234	java/io/IOException
    //   153	157	258	java/io/IOException
    //   62	77	265	java/lang/OutOfMemoryError
    //   292	296	298	java/io/IOException
    //   62	77	305	finally
    //   312	316	318	java/io/IOException
    //   79	86	326	finally
    //   88	99	326	finally
    //   101	109	326	finally
    //   116	125	326	finally
    //   131	137	326	finally
    //   139	149	326	finally
    //   161	165	326	finally
    //   167	177	326	finally
    //   179	183	326	finally
    //   190	196	326	finally
    //   198	205	326	finally
    //   207	224	326	finally
    //   243	249	326	finally
    //   270	276	326	finally
    //   278	288	326	finally
    //   79	86	330	java/lang/OutOfMemoryError
    //   88	99	330	java/lang/OutOfMemoryError
    //   101	109	330	java/lang/OutOfMemoryError
    //   116	125	330	java/lang/OutOfMemoryError
    //   161	165	330	java/lang/OutOfMemoryError
    //   167	177	330	java/lang/OutOfMemoryError
    //   179	183	330	java/lang/OutOfMemoryError
    //   190	196	330	java/lang/OutOfMemoryError
    //   198	205	330	java/lang/OutOfMemoryError
    //   207	224	330	java/lang/OutOfMemoryError
    //   243	249	330	java/lang/OutOfMemoryError
    //   62	77	334	java/lang/Exception
  }
  
  public void run()
  {
    int k = 1;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    Object localObject1;
    if (this.g == 0)
    {
      this.d = "blur";
      localObject1 = new File(this.c);
    }
    label390:
    label636:
    for (;;)
    {
      int j;
      int i;
      try
      {
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()) && (((File)localObject1).length() > 0L))
        {
          a(BitmapFactory.decodeFile(this.c));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(".troop.troop_reward.image", 2, "useDiskCacheFile=" + this.c + "," + ((File)localObject1).length());
          return;
        }
      }
      catch (Exception localException2)
      {
        ((File)localObject1).delete();
        if (QLog.isColorLevel()) {
          QLog.w(".troop.troop_reward.image", 2, "checkDiskCache failed:" + this.c, localException2);
        }
        localObject1 = new ArrayList();
        j = 0;
        if (this.f < 2) {
          break label390;
        }
        i = j;
        try
        {
          localObject1 = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject1 == null) {
            break;
          }
          int m = NetworkUtil.b(((View)localObject1).getContext().getApplicationContext());
          j = k;
          if (i == 0) {
            j = 0;
          }
          ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_troop_reward", "load_big_pic", 0, j, this.g + "", i + "", m + "", "");
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localException1.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w(".troop.troop_reward.image", 2, "checkDiskCache failed:" + this.c, localOutOfMemoryError);
        continue;
      }
      if (this.g == 1)
      {
        continue;
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        localException1.clear();
        if (this.f < 1) {}
        try
        {
          localException1.add(new BasicHeader("Host", new URL(this.jdField_a_of_type_JavaLangString).getHost()));
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            localException1.add(new BasicHeader("Cookie", this.jdField_b_of_type_JavaLangString));
          }
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward.image", 2, "reqUrl=" + (String)localObject2 + ", cookie=" + this.jdField_b_of_type_JavaLangString + ", downloadIdx=" + this.f);
          }
          this.f += 1;
          localObject2 = HttpDownloadUtil.a((String)localObject2, this, localException1, 4, false);
          i = ((DownloadInfo)localObject2).b;
          if (((DownloadInfo)localObject2).b == 0)
          {
            if (!QLog.isColorLevel()) {
              break label636;
            }
            QLog.d(".troop.troop_reward.image", 2, "run: resultCode==DOWNLOAD_SUCCESS, break, picType=" + this.d);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w(".troop.troop_reward.image", 2, "convertURLHost exp", localException3);
            }
          }
          j = i;
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\RewardImageDetailView$RewardImageLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */