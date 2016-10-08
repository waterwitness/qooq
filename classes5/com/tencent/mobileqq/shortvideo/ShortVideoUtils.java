package com.tencent.mobileqq.shortvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import uqk;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static boolean a = false;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "GT-N7108" };
  private static final String b = "ShortVideoUtils";
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = false;
  private static volatile boolean e = false;
  private static boolean f = false;
  private static int h = 0;
  private static final int i = 604800000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    b = true;
    f = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    h = 2;
    ThreadManager.b().post(new uqk());
  }
  
  public static int a()
  {
    if (!d)
    {
      b();
      d = true;
    }
    return h;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      return paramInt2;
    }
    if (paramInt1 >= 100) {
      return 100;
    }
    return (int)((100 - paramInt2) * paramInt1 / 100.0F + paramInt2);
  }
  
  public static long a(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int j = localMediaPlayer.getDuration();
      long l = j;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: new 148	android/media/MediaMetadataRetriever
    //   8: dup
    //   9: invokespecial 149	android/media/MediaMetadataRetriever:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 150	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   18: iconst_0
    //   19: ifne +251 -> 270
    //   22: aload_3
    //   23: ldc2_w 112
    //   26: invokevirtual 154	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   29: astore_0
    //   30: aload_3
    //   31: invokevirtual 155	android/media/MediaMetadataRetriever:release	()V
    //   34: aload_0
    //   35: ifnonnull +46 -> 81
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: aload_3
    //   44: invokevirtual 155	android/media/MediaMetadataRetriever:release	()V
    //   47: aconst_null
    //   48: astore_0
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_0
    //   55: goto -21 -> 34
    //   58: astore_0
    //   59: aload_3
    //   60: invokevirtual 155	android/media/MediaMetadataRetriever:release	()V
    //   63: aconst_null
    //   64: astore_0
    //   65: goto -31 -> 34
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: goto -37 -> 34
    //   74: astore_0
    //   75: aload_3
    //   76: invokevirtual 155	android/media/MediaMetadataRetriever:release	()V
    //   79: aload_0
    //   80: athrow
    //   81: aload_0
    //   82: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
    //   85: istore 4
    //   87: aload_0
    //   88: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
    //   91: istore 5
    //   93: iload 4
    //   95: iload 5
    //   97: invokestatic 168	java/lang/Math:max	(II)I
    //   100: istore 6
    //   102: aload_0
    //   103: astore_3
    //   104: iload 6
    //   106: sipush 512
    //   109: if_icmple +32 -> 141
    //   112: ldc -87
    //   114: iload 6
    //   116: i2f
    //   117: fdiv
    //   118: fstore_2
    //   119: aload_0
    //   120: iload 4
    //   122: i2f
    //   123: fload_2
    //   124: fmul
    //   125: invokestatic 173	java/lang/Math:round	(F)I
    //   128: iload 5
    //   130: i2f
    //   131: fload_2
    //   132: fmul
    //   133: invokestatic 173	java/lang/Math:round	(F)I
    //   136: iconst_1
    //   137: invokestatic 177	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   140: astore_3
    //   141: invokestatic 146	java/lang/System:currentTimeMillis	()J
    //   144: lstore 9
    //   146: aload_3
    //   147: ifnull +80 -> 227
    //   150: aload_3
    //   151: astore_0
    //   152: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -115 -> 40
    //   158: ldc 15
    //   160: iconst_2
    //   161: new 95	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   168: ldc -77
    //   170: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_3
    //   174: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
    //   177: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc -72
    //   182: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_3
    //   186: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
    //   189: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc -70
    //   194: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc -68
    //   203: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload 9
    //   208: lload 7
    //   210: lsub
    //   211: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: ldc -63
    //   216: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_3
    //   226: areturn
    //   227: aload_3
    //   228: astore_0
    //   229: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -192 -> 40
    //   235: ldc 15
    //   237: iconst_2
    //   238: new 95	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   245: ldc -59
    //   247: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_3
    //   261: areturn
    //   262: astore_3
    //   263: goto -229 -> 34
    //   266: astore_1
    //   267: goto -188 -> 79
    //   270: aconst_null
    //   271: astore_0
    //   272: goto -242 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramContext	Context
    //   0	275	1	paramString	String
    //   118	14	2	f1	float
    //   12	249	3	localObject	Object
    //   262	1	3	localRuntimeException	RuntimeException
    //   85	36	4	j	int
    //   91	38	5	k	int
    //   100	15	6	m	int
    //   3	206	7	l1	long
    //   144	63	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   13	18	42	java/lang/IllegalArgumentException
    //   22	30	42	java/lang/IllegalArgumentException
    //   43	47	52	java/lang/RuntimeException
    //   13	18	58	java/lang/RuntimeException
    //   22	30	58	java/lang/RuntimeException
    //   59	63	68	java/lang/RuntimeException
    //   13	18	74	finally
    //   22	30	74	finally
    //   30	34	262	java/lang/RuntimeException
    //   75	79	266	java/lang/RuntimeException
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return (Bitmap)localObject;
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        j = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = a(paramBitmap);
        if (localObject != null) {
          break label221;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        localObject = paramBitmap;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + m + ", dstH:" + n);
      }
      f1 = m / j;
      f2 = n / k;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, m, n);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return (Bitmap)localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
      return paramBitmap;
      label221:
      int m = localObject[0];
      int n = localObject[1];
      if (j == m)
      {
        localObject = paramBitmap;
        if (k == n) {
          break;
        }
      }
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      FileUtils.b((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      return " [TYPE_NONE " + paramInt + " ]";
    case 6: 
      return " [TYPE_VIDEO_C2C] ";
    case 7: 
      return " [TYPE_VIDEO_THUMB_C2C] ";
    case 17: 
      return " [TYPE_VIDEO_DISUSS]";
    case 18: 
      return " [TYPE_VIDEO_THUMB_DISUSS] ";
    case 9: 
      return " [TYPE_VIDEO_TROOP]";
    case 16: 
      return " [TYPE_VIDEO_THUMB_TROOP] ";
    }
    return " [TYPE_VIDEO_FORWARD] ";
  }
  
  public static String a(long paramLong)
  {
    int m = (int)paramLong / 1000;
    int j = m % 60;
    int k = m / 60 % 60;
    m /= 3600;
    if (m > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) }).toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int j = str.length();
    paramContext = str;
    if (j > 3) {
      paramContext = str.substring(0, j - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    return a(paramMessageForShortVideo, "mp4") + "." + MD5.toMD5(paramMessageForShortVideo.uuid) + ".tmp";
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int j = 0;
    paramString = b(paramMessageForShortVideo, paramString);
    int k = paramMessageForShortVideo.videoFileStatus;
    switch (k)
    {
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        bool2 = bool1;
        if (FileUtils.b(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = b(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      FileUtils.b(paramMessageForShortVideo + ".nomedia");
      return paramString;
    }
    Object localObject = ((File)localObject).list();
    String str;
    if ((localObject != null) && (localObject.length > 0))
    {
      int m = localObject.length;
      for (;;)
      {
        if (j >= m) {
          break label380;
        }
        str = localObject[j];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        j += 1;
      }
    }
    label380:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        FileUtils.d(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + b(k) + ", needCopy=" + bool2);
        }
      }
      return paramString;
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore 7
    //   5: iconst_4
    //   6: newarray <illegal type>
    //   8: astore_2
    //   9: iconst_4
    //   10: newarray <illegal type>
    //   12: astore 4
    //   14: lconst_0
    //   15: lstore 11
    //   17: bipush 8
    //   19: invokestatic 401	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   22: astore 5
    //   24: new 403	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: iconst_0
    //   34: istore 8
    //   36: iload 7
    //   38: bipush 100
    //   40: if_icmpge +270 -> 310
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 412	java/io/InputStream:read	([B)I
    //   50: istore 9
    //   52: iload 9
    //   54: ifgt +40 -> 94
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 415	java/io/InputStream:close	()V
    //   65: new 95	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   72: iload 8
    //   74: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc_w 417
    //   80: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload 11
    //   85: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_0
    //   92: aload_0
    //   93: areturn
    //   94: aload_1
    //   95: astore_0
    //   96: aload 5
    //   98: iconst_4
    //   99: newarray <illegal type>
    //   101: invokevirtual 421	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   104: pop
    //   105: aload_1
    //   106: astore_0
    //   107: aload 5
    //   109: aload_2
    //   110: invokevirtual 421	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   113: pop
    //   114: aload_1
    //   115: astore_0
    //   116: aload 5
    //   118: invokevirtual 425	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   121: pop
    //   122: aload_1
    //   123: astore_0
    //   124: aload 5
    //   126: invokevirtual 428	java/nio/ByteBuffer:getLong	()J
    //   129: lstore 13
    //   131: aload_1
    //   132: astore_0
    //   133: iload 9
    //   135: aload_1
    //   136: aload 4
    //   138: invokevirtual 412	java/io/InputStream:read	([B)I
    //   141: iadd
    //   142: istore 10
    //   144: iload 10
    //   146: istore 9
    //   148: lload 13
    //   150: lstore 11
    //   152: lload 13
    //   154: lconst_1
    //   155: lcmp
    //   156: ifne +157 -> 313
    //   159: aload_1
    //   160: astore_0
    //   161: bipush 8
    //   163: newarray <illegal type>
    //   165: astore 6
    //   167: aload_1
    //   168: astore_0
    //   169: iload 10
    //   171: aload_1
    //   172: aload 6
    //   174: invokevirtual 412	java/io/InputStream:read	([B)I
    //   177: iadd
    //   178: istore 9
    //   180: aload_1
    //   181: astore_0
    //   182: aload 5
    //   184: invokevirtual 431	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   187: pop
    //   188: aload_1
    //   189: astore_0
    //   190: aload 5
    //   192: aload 6
    //   194: invokevirtual 421	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   197: pop
    //   198: aload_1
    //   199: astore_0
    //   200: aload 5
    //   202: invokevirtual 425	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   205: pop
    //   206: aload_1
    //   207: astore_0
    //   208: aload 5
    //   210: invokevirtual 428	java/nio/ByteBuffer:getLong	()J
    //   213: lstore 11
    //   215: goto +98 -> 313
    //   218: aload_1
    //   219: astore_0
    //   220: aload_1
    //   221: lload 11
    //   223: iload 9
    //   225: i2l
    //   226: lsub
    //   227: invokevirtual 435	java/io/InputStream:skip	(J)J
    //   230: pop2
    //   231: iload 8
    //   233: i2l
    //   234: lload 11
    //   236: ladd
    //   237: l2i
    //   238: istore 8
    //   240: aload_1
    //   241: astore_0
    //   242: aload 5
    //   244: invokevirtual 431	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   247: pop
    //   248: iload 7
    //   250: iconst_1
    //   251: iadd
    //   252: istore 7
    //   254: goto -218 -> 36
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: astore_0
    //   262: aload_2
    //   263: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   266: aload_3
    //   267: astore_0
    //   268: aload_1
    //   269: ifnull -177 -> 92
    //   272: aload_1
    //   273: invokevirtual 415	java/io/InputStream:close	()V
    //   276: aconst_null
    //   277: areturn
    //   278: astore_0
    //   279: aconst_null
    //   280: areturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_0
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 415	java/io/InputStream:close	()V
    //   292: aload_1
    //   293: athrow
    //   294: astore_0
    //   295: goto -230 -> 65
    //   298: astore_0
    //   299: goto -7 -> 292
    //   302: astore_1
    //   303: goto -19 -> 284
    //   306: astore_2
    //   307: goto -47 -> 260
    //   310: goto -253 -> 57
    //   313: aload 4
    //   315: iconst_0
    //   316: baload
    //   317: i2c
    //   318: bipush 109
    //   320: if_icmpne -102 -> 218
    //   323: aload 4
    //   325: iconst_1
    //   326: baload
    //   327: i2c
    //   328: bipush 111
    //   330: if_icmpne -112 -> 218
    //   333: aload 4
    //   335: iconst_2
    //   336: baload
    //   337: i2c
    //   338: bipush 111
    //   340: if_icmpne -122 -> 218
    //   343: aload 4
    //   345: iconst_3
    //   346: baload
    //   347: i2c
    //   348: bipush 118
    //   350: if_icmpne -132 -> 218
    //   353: goto -296 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramFile	File
    //   32	241	1	localFileInputStream	java.io.FileInputStream
    //   281	12	1	localObject1	Object
    //   302	1	1	localObject2	Object
    //   8	102	2	arrayOfByte1	byte[]
    //   257	6	2	localException1	Exception
    //   306	1	2	localException2	Exception
    //   1	266	3	localObject3	Object
    //   12	332	4	arrayOfByte2	byte[]
    //   22	221	5	localByteBuffer	java.nio.ByteBuffer
    //   165	28	6	arrayOfByte3	byte[]
    //   3	250	7	j	int
    //   34	205	8	k	int
    //   50	174	9	m	int
    //   142	36	10	n	int
    //   15	220	11	l1	long
    //   129	24	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   24	33	257	java/lang/Exception
    //   272	276	278	java/lang/Exception
    //   24	33	281	finally
    //   61	65	294	java/lang/Exception
    //   288	292	298	java/lang/Exception
    //   45	52	302	finally
    //   96	105	302	finally
    //   107	114	302	finally
    //   116	122	302	finally
    //   124	131	302	finally
    //   133	144	302	finally
    //   161	167	302	finally
    //   169	180	302	finally
    //   182	188	302	finally
    //   190	198	302	finally
    //   200	206	302	finally
    //   208	215	302	finally
    //   220	231	302	finally
    //   242	248	302	finally
    //   262	266	302	finally
    //   45	52	306	java/lang/Exception
    //   96	105	306	java/lang/Exception
    //   107	114	306	java/lang/Exception
    //   116	122	306	java/lang/Exception
    //   124	131	306	java/lang/Exception
    //   133	144	306	java/lang/Exception
    //   161	167	306	java/lang/Exception
    //   169	180	306	java/lang/Exception
    //   182	188	306	java/lang/Exception
    //   190	198	306	java/lang/Exception
    //   200	206	306	java/lang/Exception
    //   208	215	306	java/lang/Exception
    //   220	231	306	java/lang/Exception
    //   242	248	306	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new StringBuilder(b(paramString1));
    paramString1.append(paramString2);
    paramString1.append(Math.abs(paramLong));
    paramString1.append(".");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("shortVideoThumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AtomicInteger a()
  {
    if (!d)
    {
      b();
      d = true;
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public static void a()
  {
    a("", false);
  }
  
  public static void a(Activity paramActivity, File paramFile)
  {
    long l = FileUtils.a(paramFile.getAbsolutePath());
    paramActivity = new StringBuilder();
    paramActivity.append("VideoSize:");
    paramActivity.append(l / 1000L);
    paramActivity.append("KB\n");
    if (VersionUtils.d())
    {
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramFile.getAbsolutePath());
      paramFile = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      localObject = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      paramActivity.append("VideoResolution:" + paramFile + "*" + str);
      paramActivity.append('\n');
      paramActivity.append("VideoDuration:" + (String)localObject + "ms");
    }
    Toast.makeText(BaseApplicationImpl.a, paramActivity.toString(), 1).show();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    try
    {
      if ((VideoEnvironment.c(paramAppInterface)) && (!a()))
      {
        VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "LoadExtractedShortVideoSo:status_end=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
        }
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      do
      {
        paramAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure.", paramAppInterface);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.getMd5())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
    return;
    FileUtils.d(a(paramMessageForShortVideo, "mp4"));
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, Activity paramActivity, int paramInt, String paramString)
  {
    String str = a(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", c(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", paramInt);
    localBundle.putString("from_session_uin", paramString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putString("thumbfile_send_path", str);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putInt("video_play_caller", 0);
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramMessageForShortVideo = new Intent(paramActivity, ShortVideoPlayActivity.class);
    paramMessageForShortVideo.putExtras(localBundle);
    paramActivity.startActivityForResult(paramMessageForShortVideo, 13002);
    paramActivity.overridePendingTransition(2130968620, 2130968621);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject = new File(b());
    if (!((File)localObject).exists()) {}
    File[] arrayOfFile;
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          arrayOfFile = localObject[j].listFiles();
          if (arrayOfFile != null) {
            break label105;
          }
          j += 1;
        }
      }
    }
    label105:
    int n = arrayOfFile.length;
    int k = 0;
    label112:
    File localFile;
    if (k < n)
    {
      localFile = arrayOfFile[k];
      if (!localFile.getName().equals(paramString)) {
        break label146;
      }
    }
    for (;;)
    {
      k += 1;
      break label112;
      break;
      label146:
      if ((localFile.isFile()) && (localFile.getName().contains(".tmp"))) {
        if (paramBoolean)
        {
          long l = localFile.lastModified();
          if (604800000L <= System.currentTimeMillis() - l) {
            localFile.delete();
          }
        }
        else
        {
          localFile.delete();
        }
      }
    }
  }
  
  public static boolean a()
  {
    return ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS == 0;
  }
  
  public static boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return false;
      if (FileUtils.b(a(paramMessageForShortVideo, "mp4"))) {
        return true;
      }
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (!FileUtils.b(paramMessageForShortVideo.videoFileName)));
    return true;
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile != null)
    {
      bool2 = bool1;
      if (paramFile.exists())
      {
        if (paramFile.isFile()) {
          break label39;
        }
        bool2 = bool1;
      }
    }
    label39:
    long l1;
    do
    {
      int j;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool2;
            l1 = System.currentTimeMillis();
            localObject = a(paramFile);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), moovInfoStr: " + (String)localObject + ", filePath:" + paramFile.getAbsolutePath());
            }
            bool2 = bool1;
          } while (TextUtils.isEmpty((CharSequence)localObject));
          localObject = ((String)localObject).split("\\|");
          bool2 = bool1;
        } while (TextUtils.isEmpty(localObject[0]));
        j = -1;
        try
        {
          int k = Integer.parseInt(localObject[0]);
          j = k;
        }
        catch (Exception localException)
        {
          long l2;
          float f1;
          for (;;) {}
        }
        bool2 = bool1;
      } while (j <= 0);
      l2 = paramFile.length();
      f1 = j / (float)l2;
      bool1 = bool3;
      if (f1 > 0.0F)
      {
        bool1 = bool3;
        if (f1 < 0.5F) {
          bool1 = true;
        }
      }
      l2 = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), ratio: " + f1 + ", result: " + bool1 + ", cost:" + (l2 - l1));
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!e) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    String str1 = "";
    String str2 = paramString + ".tmp";
    if (adjustMoovPosition(paramString, str2) != 0)
    {
      paramString = " adjustMoovPosition failure";
      bool1 = bool3;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoUtils", 2, "moveMoovAtom() result = " + bool1 + ", step = " + paramString + ", cost = " + (l2 - l1) + "ms");
      return bool1;
      String str3 = paramString + ".back";
      FileUtils.c(paramString, str3);
      if (!FileUtils.c(str2, paramString))
      {
        FileUtils.c(str3, paramString);
        paramString = " rename failure";
        bool1 = bool3;
      }
      else
      {
        bool1 = true;
        paramString = str1;
      }
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if ((TextUtils.isEmpty(paramString)) || (0L == paramLong))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), filePath or lastModifyTime is vilid.");
        bool2 = bool1;
      }
    }
    long l1;
    do
    {
      long l2;
      do
      {
        do
        {
          return bool2;
          l1 = System.currentTimeMillis();
          paramString = new File(paramString);
          l2 = paramString.length();
          bool2 = bool1;
        } while (!paramString.isFile());
        bool2 = bool1;
      } while (l2 <= 0L);
      bool1 = bool3;
      if (paramLong == paramString.lastModified()) {
        bool1 = true;
      }
      paramLong = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), result = " + bool1 + ", cost time: " + (paramLong - l1) + " ms");
    return bool1;
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int k;
    int m;
    label14:
    int j;
    int n;
    if (paramInt1 > 0)
    {
      k = paramInt1;
      if (paramInt2 <= 0) {
        break label219;
      }
      m = paramInt2;
      j = (int)(BaseChatItemLayout.i + 0.5D);
      n = URLDrawableHelper.a();
      if (n < 135) {
        break label342;
      }
      n = AIOUtils.a(n, BaseApplicationImpl.a().getResources());
      if (n >= j) {
        break label342;
      }
      j = n;
    }
    label70:
    label219:
    label232:
    label287:
    label342:
    for (;;)
    {
      String str;
      if (k >= m)
      {
        n = 1;
        if (n == 0) {
          break label287;
        }
        if (k / m <= 1.5555556F) {
          break label232;
        }
        str = "landscape close to 16:9";
        k = (int)(j * 9.0F / 16.0F + 0.5D);
        m = j;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "adjustSize " + str + " maxPixel:" + j + " ow:" + paramInt1 + " oh:" + paramInt2 + " w:" + m + " h:" + k);
        }
        return new int[] { m, k };
        k = 100;
        break;
        m = 100;
        break label14;
        n = 0;
        break label70;
        if (k / m > 1.1666667F)
        {
          str = "landscape close to 4:3";
          k = (int)(j * 3.0F / 4.0F + 0.5D);
          m = j;
        }
        else
        {
          str = "landscape close to 1:1";
          k = j;
          m = j;
          continue;
          if (m / k > 1.1666667F)
          {
            str = "portrait close to 3:4";
            m = (int)(j * 3.0F / 4.0F + 0.5D);
            k = j;
          }
          else
          {
            str = "portrait close to 1:1";
            k = j;
            m = j;
          }
        }
      }
    }
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
    }
    do
    {
      return null;
      if (!paramBitmap.isRecycled()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
    return null;
    return a(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    float f2 = 2.0F;
    int j = 160;
    int k = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int m = paramArrayOfInt[0];
    int n = paramArrayOfInt[1];
    if ((m == 0) || (n == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (n > m)
    {
      f1 = n / m;
      if (f1 <= 2.0F) {
        break label129;
      }
      f1 = f2;
      label76:
      if (n <= m) {
        break label152;
      }
      if (n <= 160) {
        break label132;
      }
    }
    for (;;)
    {
      label91:
      m = (int)(j / f1);
      if (m < 80) {}
      for (;;)
      {
        return new int[] { k, j };
        f1 = m / n;
        break;
        label129:
        break label76;
        label132:
        if (n >= 100) {
          break label213;
        }
        j = 100;
        break label91;
        k = m;
      }
      label152:
      if (m > 160) {}
      for (;;)
      {
        label160:
        m = (int)(j / f1);
        if (m < 80) {}
        for (;;)
        {
          m = j;
          j = k;
          k = m;
          break;
          if (m >= 100) {
            break label207;
          }
          j = 100;
          break label160;
          k = m;
        }
        label207:
        j = m;
      }
      label213:
      j = n;
    }
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bj);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [STATUS_UNKNOW " + paramInt + "]";
    case 2004: 
      return " [STATUS_RECV_CANCEL] ";
    case 2005: 
      return " [STATUS_RECV_ERROR] ";
    case 2003: 
      return " [STATUS_RECV_FINISHED] ";
    case 2002: 
      return " [STATUS_RECV_PROCESS] ";
    case 2001: 
      return " [STATUS_RECV_START] ";
    case 2008: 
      return " [STATUS_RECV_PREPARED] ";
    case 2000: 
      return " [STATUS_RECV_REQUEST] ";
    case 999: 
      return " [STATUS_SEND_PREPARE] ";
    case 1000: 
      return " [STATUS_SEND_REQUEST] ";
    case 1001: 
      return " [STATUS_SEND_START] ";
    case 1004: 
      return " [STATUS_SEND_CANCEL] ";
    case 1002: 
      return " [STATUS_SEND_PROCESS] ";
    case 1003: 
      return " [STATUS_SEND_FINISHED] ";
    case 1007: 
      return " [STATUS_UPLOAD_FINISHED] ";
    case 1005: 
      return " [STATUS_SEND_ERROR] ";
    case 5001: 
      return " [STATUS_FILE_UNSAFE] ";
    }
    return " [STATUS_FILE_EXPIRED] ";
  }
  
  @Deprecated
  public static String b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      do
      {
        return null;
        String str = a(paramMessageForShortVideo, "mp4");
        if (FileUtils.b(str)) {
          return str;
        }
      } while (!paramMessageForShortVideo.isSendFromLocal());
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
    } while (!FileUtils.b(paramMessageForShortVideo));
    return paramMessageForShortVideo;
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(b(paramMessageForShortVideo.getMd5()));
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bj);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(AppConstants.bj);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static void b()
  {
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDefaultShortVideoStrategy:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 6)
      {
        localObject = localObject[6].split("_");
        if (localObject.length >= 2)
        {
          int j = Integer.valueOf(localObject[0]).intValue();
          if ((j >= 0) && (j <= 2)) {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(j);
          }
          j = Integer.valueOf(localObject[1]).intValue();
          if ((j >= 0) && (j <= 60)) {
            h = j;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
    }
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 3) {
      return false;
    }
    return localObject[2].equals("1");
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " shortvideo_cmd_unknow ";
    case 2: 
      return " shortvideo_cmd_download ";
    case 0: 
      return " shortvideo_cmd_send ";
    case 1: 
      return " shortvideo_cmd_resend ";
    case 3: 
      return " shortvideo_cmd_forward ";
    }
    return " shortvideo_cmd_reforward ";
  }
  
  public static String c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) {
      return paramMessageForShortVideo.senderuin;
    }
    return paramMessageForShortVideo.frienduin;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isInFullScreenBlackList(), result=" + bool);
    }
    return bool;
  }
  
  public static String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Others";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    }
    return "4G";
  }
  
  public static boolean d()
  {
    if (!c) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 5) {
        f = localObject[5].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
        }
      }
    }
    c = true;
    return f;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */