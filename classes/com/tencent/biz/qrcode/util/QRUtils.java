package com.tencent.biz.qrcode.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;
import jcu;
import mqq.app.NewIntent;

public class QRUtils
{
  private static String A = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  private static String B = "^https?://url\\.cn/.+#flyticket";
  private static final String C = "http://vac.qq.com/wallet/qrcode.htm";
  private static final String D = "https://vac.qq.com/wallet/qrcode.htm";
  private static final String E = "http://qpay.qq.com/qr/";
  private static final String F = "https://qpay.qq.com/qr/";
  public static final int a = 540;
  protected static final String a = "QRUtils";
  public static final int b = 740;
  public static final String b = "";
  public static final int c = 600;
  public static final String c = "addfriend_QR";
  public static final String d = "find_QR";
  public static final String e = "bigpicture_QR";
  public static final String f = "bulb_QR";
  public static final String g = "shareConsumerQRcard";
  public static final String h = "shareGroupQRcard";
  public static final String i = "saveConsumerQRcard";
  public static final String j = "saveGroupQRcard";
  public static final String k = "ConsumerQRcard";
  public static final String l = "GroupQRcard";
  public static final String m = "PublicAccountQRcard";
  public static final String n = "ThirdpartyQRcard";
  public static final String o = "TPQRcardurl";
  public static final String p = "TPQRcardtext";
  public static final String q = "TPQRcardphone";
  public static final String r = "changeConsumerQRcard";
  public static final String s = "changeGroupQRcard";
  protected static String t;
  protected static String u = ".*(\\+86|086)?\\d{5,12}.*";
  public static String v = "qm.qq.com";
  protected static String w = "183.61.32.185";
  protected static String x = "58.250.135.158";
  protected static String y = "120.198.189.104";
  protected static String z = "182.254.1.144";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    t = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  }
  
  protected static int a(int paramInt)
  {
    if (paramInt < 21) {
      return 1;
    }
    if (paramInt > 177) {
      return 39;
    }
    return (paramInt - 21) / 4 + 1;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 += ((paramArrayOfByte[(i2 - i1 - 1)] & 0xFF) << i1 * 8);
      i1 += 1;
    }
    return l1;
  }
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, ArrayList paramArrayList, int paramInt4)
  {
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        localBitmap = Bitmap.createBitmap(540, 740, Bitmap.Config.ARGB_8888);
        if (paramInt4 == 0) {
          break label1069;
        }
        localObject = BitmapFactory.decodeResource(paramContext.getResources(), paramInt4);
        if (localBitmap == null) {
          return null;
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QRUtils", 2, paramContext.getMessage());
        }
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (paramBitmap1 != null)
      {
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, 540, 740);
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(paramBitmap1, null, localRect, localPaint);
        if (paramBitmap2 != null)
        {
          paramBitmap1 = new Paint();
          paramBitmap1.setAntiAlias(true);
          localCanvas.drawBitmap(paramBitmap2, null, new Rect(20, 621, 120, 721), paramBitmap1);
        }
        paramInt4 = 0;
        if (localObject != null)
        {
          paramInt4 = 1;
          paramBitmap1 = new Paint();
          paramBitmap1.setAntiAlias(true);
          paramBitmap1.setFilterBitmap(true);
          localCanvas.drawBitmap((Bitmap)localObject, null, new Rect(140, 633, 176, 669), paramBitmap1);
        }
        localPaint = new Paint();
        localPaint.setTextAlign(Paint.Align.LEFT);
        localPaint.setAntiAlias(true);
        localPaint.setColor(paramInt1);
        localPaint.setTextSize(32.0F);
        localPaint.setFlags(1);
        localPaint.setTypeface(Typeface.SANS_SERIF);
        if (paramInt4 == 0) {
          break label687;
        }
        paramInt1 = 342;
        label273:
        if (paramString1 != null)
        {
          int i1 = Math.max(2, paramString1.length());
          localObject = paramString1;
          if (localPaint.measureText(paramString1) > paramInt1)
          {
            do
            {
              i1 -= 2;
              paramBitmap1 = paramString1.substring(0, i1) + "…";
              localObject = paramBitmap1;
              if (i1 <= 0) {
                break;
              }
              paramString1 = paramBitmap1;
            } while (localPaint.measureText(paramBitmap1) > paramInt1);
            localObject = paramBitmap1;
          }
          if (paramInt4 == 0) {
            break label694;
          }
          paramInt1 = 182;
          label375:
          localCanvas.drawText((String)localObject, paramInt1, 665.0F, localPaint);
        }
        if (paramBitmap3 != null) {
          localCanvas.drawBitmap(paramBitmap3, null, new Rect(0, 0, 540, 600), null);
        }
        if (paramRect == null) {
          break label701;
        }
        label423:
        if (paramArrayList == null) {
          break label863;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QRUtils", 2, "size: w=" + paramBitmap4.getWidth() + ",h=" + paramBitmap4.getHeight());
        }
      }
      for (;;)
      {
        try
        {
          paramBitmap1 = Bitmap.createScaledBitmap(paramBitmap4, paramRect.width(), paramRect.height(), false);
          paramString1 = new Canvas(paramBitmap1);
          paramBitmap3 = new Paint();
          paramBitmap3.setAlpha(0);
          paramBitmap3.setAntiAlias(true);
          paramBitmap3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          paramInt1 = 0;
          if (paramInt1 < paramArrayList.size())
          {
            paramString1.drawRect(new Rect((Rect)paramArrayList.get(paramInt1)), paramBitmap3);
            paramInt1 += 1;
            continue;
            paramBitmap1 = new Paint();
            paramBitmap1.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
            localCanvas.drawRect(0.0F, 0.0F, 540.0F, 600.0F, paramBitmap1);
            paramBitmap1.setShader(null);
            paramBitmap1.setColor(-2565928);
            localCanvas.drawLine(0.0F, 600.0F, 540.0F, 600.0F, paramBitmap1);
            paramBitmap1.setColor(-986896);
            localCanvas.drawRect(0.0F, 601.0F, 540.0F, 740.0F, paramBitmap1);
            break;
            label687:
            paramInt1 = 380;
            break label273;
            label694:
            paramInt1 = 140;
            break label375;
            label701:
            paramRect = new Rect(70, 100, 470, 500);
            break label423;
          }
          localCanvas.drawBitmap(paramBitmap1, null, paramRect, null);
          paramBitmap1.recycle();
          if (paramInt2 != 1) {
            break label877;
          }
          localCanvas.drawBitmap(paramBitmap4, null, paramRect, null);
        }
        catch (OutOfMemoryError paramContext)
        {
          try
          {
            paramBitmap1 = new Paint();
            paramBitmap1.setAntiAlias(true);
            paramBitmap2 = new Rect(217, 247, 323, 353);
            paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838505);
            localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
            paramContext.recycle();
            paramContext = new Paint();
            paramContext.setTextAlign(Paint.Align.LEFT);
            paramContext.setAntiAlias(true);
            paramContext.setColor(paramInt3);
            paramContext.setTextSize(24.0F);
            paramContext.setTypeface(null);
            localCanvas.drawText(paramString2, 140.0F, 706.0F, paramContext);
            return localBitmap;
          }
          catch (OutOfMemoryError paramContext)
          {
            paramContext.printStackTrace();
            return null;
          }
          paramContext = paramContext;
          paramContext.printStackTrace();
          return null;
        }
        label863:
        continue;
        label877:
        if ((paramInt2 == 2) && (paramBitmap2 != null))
        {
          paramContext = new Paint();
          paramContext.setAntiAlias(true);
          localCanvas.drawBitmap(paramBitmap2, null, new Rect(217, 247, 323, 353), paramContext);
        }
        else if (paramInt2 == 3)
        {
          paramBitmap1 = new Paint();
          paramBitmap1.setAntiAlias(true);
          paramBitmap2 = new Rect(217, 247, 323, 353);
          paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838505);
          localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
          paramContext.recycle();
        }
        else if (paramInt2 == 4)
        {
          paramBitmap1 = new Paint();
          paramBitmap1.setAntiAlias(true);
          paramBitmap2 = new Rect(217, 247, 323, 353);
          paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838505);
          localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
          paramContext.recycle();
        }
      }
      label1069:
      Object localObject = null;
    }
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {}
    do
    {
      return null;
      try
      {
        Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        if (localBitmap1 != null)
        {
          Canvas localCanvas = new Canvas(localBitmap1);
          Paint localPaint = new Paint();
          Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect);
          localPaint.setAntiAlias(true);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
        }
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          System.gc();
          try
          {
            Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          }
          catch (OutOfMemoryError paramBitmap) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("QRUtils", 2, paramBitmap.getMessage());
    return null;
  }
  
  public static BitMatrix a(String paramString, int paramInt)
  {
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    Object localObject = a(paramString);
    if (localObject != null) {
      localEnumMap.put(EncodeHintType.CHARACTER_SET, localObject);
    }
    if (paramInt != -1) {
      localEnumMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(a(paramInt)));
    }
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject = new QRCodeWriter();
    try
    {
      paramString = ((QRCodeWriter)localObject).a(paramString, 0, 0, localEnumMap);
      return paramString;
    }
    catch (WriterException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("host", 0).getString(paramString, null);
    if (paramContext != null) {
      return paramContext;
    }
    if (paramString.equals(v)) {
      return w;
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: getstatic 462	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 8
    //   11: if_icmplt +122 -> 133
    //   14: aload_0
    //   15: invokevirtual 466	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   18: astore_3
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 469	android/content/Context:getCacheDir	()Ljava/io/File;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull -30 -> 4
    //   37: aload 4
    //   39: invokevirtual 474	java/io/File:canWrite	()Z
    //   42: ifeq -38 -> 4
    //   45: new 251	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 477	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 480	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_3
    //   74: new 471	java/io/File
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 483	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 486	java/io/File:exists	()Z
    //   87: ifeq +8 -> 95
    //   90: aload_0
    //   91: invokevirtual 489	java/io/File:delete	()Z
    //   94: pop
    //   95: new 491	java/io/FileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 494	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: getstatic 500	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload_1
    //   113: invokevirtual 504	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   116: pop
    //   117: aload_1
    //   118: astore_0
    //   119: aload_1
    //   120: invokevirtual 507	java/io/FileOutputStream:flush	()V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: new 471	java/io/File
    //   136: dup
    //   137: invokestatic 515	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   140: new 251	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 517
    //   150: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 520	android/content/Context:getPackageName	()Ljava/lang/String;
    //   157: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 522
    //   163: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 525	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 528	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: goto -159 -> 19
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   186: goto -55 -> 131
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_2
    //   195: invokevirtual 530	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload_1
    //   199: ifnull -195 -> 4
    //   202: aload_1
    //   203: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: astore_0
    //   220: aload_2
    //   221: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   224: aload_1
    //   225: ifnull -221 -> 4
    //   228: aload_1
    //   229: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 529	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore_1
    //   263: goto -19 -> 244
    //   266: astore_2
    //   267: goto -49 -> 218
    //   270: astore_2
    //   271: goto -79 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramString	String
    //   0	274	2	paramBitmap	Bitmap
    //   18	156	3	localObject1	Object
    //   20	33	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   127	131	181	java/io/IOException
    //   95	104	189	java/io/FileNotFoundException
    //   202	206	208	java/io/IOException
    //   95	104	215	java/io/IOException
    //   228	232	234	java/io/IOException
    //   95	104	241	finally
    //   248	252	254	java/io/IOException
    //   106	117	262	finally
    //   119	123	262	finally
    //   194	198	262	finally
    //   220	224	262	finally
    //   106	117	266	java/io/IOException
    //   119	123	266	java/io/IOException
    //   106	117	270	java/io/FileNotFoundException
    //   119	123	270	java/io/FileNotFoundException
  }
  
  protected static String a(CharSequence paramCharSequence)
  {
    int i1 = 0;
    while (i1 < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(i1) > 'ÿ') {
        return "UTF-8";
      }
      i1 += 1;
    }
    return null;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131492908));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("host", 0);
    try
    {
      paramContext = InetAddress.getByName(paramString).getHostAddress();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, paramContext);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("QRUtils", 2, "lookup address: " + paramString + ", ip: " + paramContext);
      }
      return;
    }
    catch (UnknownHostException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, QRCodeEncodeCallback paramQRCodeEncodeCallback)
  {
    paramString1 = QRActionEntity.a(paramInt, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt);
      }
      return;
    }
    paramString1 = paramString1.a();
    paramString2 = new jcu(paramQRCodeEncodeCallback);
    paramContext = new NewIntent(paramContext, QRCodeServlet.class);
    paramContext.putExtra("skey", paramString3);
    paramContext.putExtra("d", paramString1);
    paramContext.putExtra("cmd", "QRCodeSvc.encode");
    paramContext.setObserver(paramString2);
    paramQQAppInterface.startServlet(paramContext);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(t, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(A, paramString)) && (!Pattern.matches(B, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(B, paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://vac.qq.com/wallet/qrcode.htm"))) {
      return false;
    }
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://qpay.qq.com/qr/")) && (!paramString.startsWith("https://qpay.qq.com/qr/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return URLUtil.isValidUrl(paramString);
  }
  
  public static boolean g(String paramString)
  {
    return (f(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean h(String paramString)
  {
    return Pattern.matches(u, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\biz\qrcode\util\QRUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */