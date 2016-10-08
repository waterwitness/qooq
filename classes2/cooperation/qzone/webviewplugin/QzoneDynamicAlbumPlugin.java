package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yrc;
import yrd;
import yre;
import yrf;
import yrg;
import yrh;
import yri;

public class QzoneDynamicAlbumPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  static File jdField_a_of_type_JavaIoFile;
  public static final String a = "http://www.dynamicalbumlocalimage.com";
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static final int jdField_b_of_type_Int = 2;
  static File jdField_b_of_type_JavaIoFile = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/Qzone/qzoneothers/");
  public static final String b = "qzDynamicAlbum";
  public static final String c = "callback";
  public static final String d;
  private static final String jdField_e_of_type_JavaLangString;
  private static final String g = "com.tencent.process.stopping";
  private static final String h = "com.tencent.process.starting";
  private static final String i = "h5s.qzone.qq.com/dynamic";
  private static final String j = "qbrowserVolumeChange";
  private byte jdField_a_of_type_Byte = 111;
  private int jdField_a_of_type_Int = 274;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new yrd(this);
  public Handler a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    e = QzoneDynamicAlbumPlugin.class.getSimpleName();
    jdField_d_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/Tencent/Qzone/qzonedynamicalbum/";
  }
  
  public QzoneDynamicAlbumPlugin()
  {
    this.jdField_a_of_type_AndroidOsHandler = new yrg(this);
  }
  
  public static double a(QzoneDynamicAlbumPlugin.Size paramSize)
  {
    if (jdField_a_of_type_ArrayOfInt == null) {
      jdField_a_of_type_ArrayOfInt = a();
    }
    if (paramSize != null)
    {
      int k = paramSize.jdField_a_of_type_Int;
      int m = paramSize.b;
      int n;
      if (k < m)
      {
        n = m;
        m = k;
      }
      for (;;)
      {
        double d3;
        if ((n <= jdField_a_of_type_ArrayOfInt[0]) && (m <= jdField_a_of_type_ArrayOfInt[1]))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (n > m) {
          d1 = n / jdField_a_of_type_ArrayOfInt[0];
        }
        for (double d2 = m / jdField_a_of_type_ArrayOfInt[1];; d2 = n / jdField_a_of_type_ArrayOfInt[1])
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = m / jdField_a_of_type_ArrayOfInt[0];
        }
        n = k;
      }
    }
    return 0.0D;
  }
  
  public static double a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      k = localOptions.outWidth;
      m = localOptions.outHeight;
      double d1 = 0.0D;
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        d1 = k / paramInt1;
        d2 = m / paramInt2;
        if (d1 > d2) {
          return d1;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      int m;
      do
      {
        int k;
        double d2;
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
        return d2;
        if (paramInt1 != -1) {
          return k / paramInt1;
        }
      } while (paramInt2 == -1);
      return m / paramInt2;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;) {}
    }
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int k = JpegExifReader.getRotationDegree(paramString);
      return k;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return (Bitmap)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static BitmapFactory.Options a(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = a(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        QLog.e(e, 1, "getSizeCrop" + paramContext);
      }
    }
  }
  
  public static WebResourceResponse a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return null;
        String str = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
        try
        {
          str = URLDecoder.decode(str, "UTF-8");
          if (QLog.isDevelopLevel()) {
            QLog.i(e, 4, "image filePath :" + str);
          }
          if (!new File(str).exists())
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.i(e, 4, "getImageResponse local file not exists :" + str);
            return null;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Object localObject;
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            localObject = null;
          }
          try
          {
            localObject = new FileInputStream((String)localObject);
            if (QLog.isDevelopLevel()) {
              QLog.i(e, 4, "getImageResponse ****************** :" + paramString);
            }
            return new WebResourceResponse("image/*", "utf-8", (InputStream)localObject);
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            localFileNotFoundException.printStackTrace();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(e, 2, "getImageResponse get local file fail:" + paramString);
    return null;
  }
  
  public static QzoneDynamicAlbumPlugin.Size a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      localOptions.inJustDecodeBounds = false;
      return new QzoneDynamicAlbumPlugin.Size(localOptions.outWidth, localOptions.outHeight);
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e(e, 1, "getBitmapSize: OutOfMemoryError" + paramString);
      }
    }
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: aload 5
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: aload_1
    //   13: aload_0
    //   14: iload_2
    //   15: iload_3
    //   16: invokestatic 289	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   19: astore 6
    //   21: aload_0
    //   22: invokevirtual 200	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: aload_1
    //   26: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   29: astore_0
    //   30: aload_0
    //   31: astore 4
    //   33: getstatic 89	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   36: invokevirtual 253	java/io/File:exists	()Z
    //   39: ifne +13 -> 52
    //   42: aload_0
    //   43: astore 4
    //   45: getstatic 89	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   48: invokevirtual 292	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_0
    //   53: astore 4
    //   55: getstatic 89	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   58: invokevirtual 253	java/io/File:exists	()Z
    //   61: ifne +186 -> 247
    //   64: aload_0
    //   65: astore 4
    //   67: new 68	java/io/File
    //   70: dup
    //   71: new 57	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 66	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   81: invokevirtual 71	java/io/File:getPath	()Ljava/lang/String;
    //   84: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 294
    //   90: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload_0
    //   102: astore 4
    //   104: aload 7
    //   106: invokevirtual 253	java/io/File:exists	()Z
    //   109: ifne +12 -> 121
    //   112: aload_0
    //   113: astore 4
    //   115: aload 7
    //   117: invokevirtual 292	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: aload_0
    //   122: astore 4
    //   124: new 68	java/io/File
    //   127: dup
    //   128: new 57	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   135: invokestatic 66	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   138: invokevirtual 71	java/io/File:getPath	()Ljava/lang/String;
    //   141: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 296
    //   147: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: astore 7
    //   158: aload_0
    //   159: astore 4
    //   161: aload 7
    //   163: invokevirtual 253	java/io/File:exists	()Z
    //   166: ifne +12 -> 178
    //   169: aload_0
    //   170: astore 4
    //   172: aload 7
    //   174: invokevirtual 292	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: aload_0
    //   179: astore 4
    //   181: new 68	java/io/File
    //   184: dup
    //   185: new 57	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   192: invokestatic 66	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   195: invokevirtual 71	java/io/File:getPath	()Ljava/lang/String;
    //   198: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 84
    //   203: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 7
    //   214: aload_0
    //   215: astore 4
    //   217: aload 7
    //   219: invokevirtual 253	java/io/File:exists	()Z
    //   222: ifne +12 -> 234
    //   225: aload_0
    //   226: astore 4
    //   228: aload 7
    //   230: invokevirtual 292	java/io/File:mkdirs	()Z
    //   233: pop
    //   234: aload_0
    //   235: astore 4
    //   237: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   240: iconst_1
    //   241: ldc_w 298
    //   244: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: astore 4
    //   250: aload_0
    //   251: aload 6
    //   253: getstatic 89	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   256: aload_1
    //   257: invokevirtual 301	android/net/Uri:getPath	()Ljava/lang/String;
    //   260: invokestatic 303	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)I
    //   263: invokestatic 306	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;Ljava/io/File;I)Ljava/lang/String;
    //   266: astore_1
    //   267: aload_1
    //   268: astore 4
    //   270: aload 4
    //   272: astore_1
    //   273: aload_0
    //   274: ifnull -264 -> 10
    //   277: aload_0
    //   278: invokevirtual 145	java/io/InputStream:close	()V
    //   281: aload 4
    //   283: areturn
    //   284: astore_0
    //   285: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   288: iconst_1
    //   289: new 57	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 308
    //   299: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload 4
    //   314: areturn
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_0
    //   318: aload_0
    //   319: astore 4
    //   321: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   324: iconst_1
    //   325: new 57	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 310
    //   335: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload 5
    //   350: astore_1
    //   351: aload_0
    //   352: ifnull -342 -> 10
    //   355: aload_0
    //   356: invokevirtual 145	java/io/InputStream:close	()V
    //   359: aconst_null
    //   360: areturn
    //   361: astore_0
    //   362: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   365: iconst_1
    //   366: new 57	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 308
    //   376: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_0
    //   380: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: aconst_null
    //   390: areturn
    //   391: astore_0
    //   392: aconst_null
    //   393: astore 4
    //   395: aload 4
    //   397: ifnull +8 -> 405
    //   400: aload 4
    //   402: invokevirtual 145	java/io/InputStream:close	()V
    //   405: aload_0
    //   406: athrow
    //   407: astore_1
    //   408: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   411: iconst_1
    //   412: new 57	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 308
    //   422: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_1
    //   426: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: goto -30 -> 405
    //   438: astore_0
    //   439: goto -44 -> 395
    //   442: astore_1
    //   443: goto -125 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramContext	Context
    //   0	446	1	paramUri	Uri
    //   0	446	2	paramInt1	int
    //   0	446	3	paramInt2	int
    //   31	370	4	localObject1	Object
    //   1	348	5	localObject2	Object
    //   19	233	6	localOptions	BitmapFactory.Options
    //   99	130	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   277	281	284	java/io/IOException
    //   12	30	315	java/lang/Exception
    //   355	359	361	java/io/IOException
    //   12	30	391	finally
    //   400	405	407	java/io/IOException
    //   33	42	438	finally
    //   45	52	438	finally
    //   55	64	438	finally
    //   67	101	438	finally
    //   104	112	438	finally
    //   115	121	438	finally
    //   124	158	438	finally
    //   161	169	438	finally
    //   172	178	438	finally
    //   181	214	438	finally
    //   217	225	438	finally
    //   228	234	438	finally
    //   237	247	438	finally
    //   250	267	438	finally
    //   321	348	438	finally
    //   33	42	442	java/lang/Exception
    //   45	52	442	java/lang/Exception
    //   55	64	442	java/lang/Exception
    //   67	101	442	java/lang/Exception
    //   104	112	442	java/lang/Exception
    //   115	121	442	java/lang/Exception
    //   124	158	442	java/lang/Exception
    //   161	169	442	java/lang/Exception
    //   172	178	442	java/lang/Exception
    //   181	214	442	java/lang/Exception
    //   217	225	442	java/lang/Exception
    //   228	234	442	java/lang/Exception
    //   237	247	442	java/lang/Exception
    //   250	267	442	java/lang/Exception
  }
  
  /* Error */
  private static String a(InputStream paramInputStream, BitmapFactory.Options paramOptions, File paramFile, int paramInt)
  {
    // Byte code:
    //   0: new 57	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 317	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: getstatic 321	java/io/File:separatorChar	C
    //   17: invokevirtual 324	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   20: new 326	java/util/Date
    //   23: dup
    //   24: invokespecial 327	java/util/Date:<init>	()V
    //   27: invokevirtual 331	java/util/Date:getTime	()J
    //   30: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 68	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: aload_2
    //   50: invokevirtual 253	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 292	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: aload 6
    //   63: invokevirtual 253	java/io/File:exists	()Z
    //   66: ifne +9 -> 75
    //   69: aload 6
    //   71: invokevirtual 337	java/io/File:createNewFile	()Z
    //   74: pop
    //   75: new 339	java/io/FileOutputStream
    //   78: dup
    //   79: aload 6
    //   81: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore 4
    //   86: aload 4
    //   88: astore_2
    //   89: aload_1
    //   90: getfield 211	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   93: iconst_1
    //   94: if_icmpgt +16 -> 110
    //   97: aload 4
    //   99: astore_2
    //   100: aload_1
    //   101: getfield 345	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   104: invokestatic 348	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)Z
    //   107: ifne +220 -> 327
    //   110: aload 4
    //   112: astore_2
    //   113: aload_1
    //   114: getstatic 354	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   117: putfield 357	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: aload 4
    //   122: astore_2
    //   123: aload_1
    //   124: iconst_1
    //   125: putfield 360	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   128: aload 4
    //   130: astore_2
    //   131: aload_1
    //   132: iconst_1
    //   133: putfield 363	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   136: aload 4
    //   138: astore_2
    //   139: aload_0
    //   140: aconst_null
    //   141: aload_1
    //   142: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore_0
    //   146: aload_0
    //   147: astore_1
    //   148: iload_3
    //   149: ifeq +12 -> 161
    //   152: aload 4
    //   154: astore_2
    //   155: aload_0
    //   156: iload_3
    //   157: invokestatic 365	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +82 -> 244
    //   165: aload 4
    //   167: astore_2
    //   168: aload_1
    //   169: getstatic 371	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   172: bipush 60
    //   174: aload 4
    //   176: invokevirtual 375	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   179: pop
    //   180: aload 4
    //   182: astore_2
    //   183: aload_1
    //   184: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   187: aload 4
    //   189: astore_2
    //   190: aload 4
    //   192: invokevirtual 378	java/io/OutputStream:close	()V
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 378	java/io/OutputStream:close	()V
    //   205: aload 5
    //   207: areturn
    //   208: astore_0
    //   209: aload 4
    //   211: astore_2
    //   212: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   215: iconst_1
    //   216: new 57	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 380
    //   226: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aconst_null
    //   240: astore_0
    //   241: goto -95 -> 146
    //   244: aload 4
    //   246: ifnull +8 -> 254
    //   249: aload 4
    //   251: invokevirtual 378	java/io/OutputStream:close	()V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   260: astore_1
    //   261: new 57	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 382
    //   271: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: ifnonnull +16 -> 298
    //   285: ldc_w 384
    //   288: astore_0
    //   289: aload_1
    //   290: iconst_1
    //   291: aload_0
    //   292: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: goto -41 -> 254
    //   298: new 57	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   305: aload 5
    //   307: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 384
    //   313: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_0
    //   317: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore_0
    //   324: goto -35 -> 289
    //   327: aload 4
    //   329: astore_2
    //   330: sipush 1024
    //   333: newarray <illegal type>
    //   335: astore_1
    //   336: aload 4
    //   338: astore_2
    //   339: aload_0
    //   340: aload_1
    //   341: invokevirtual 388	java/io/InputStream:read	([B)I
    //   344: istore_3
    //   345: iload_3
    //   346: iconst_m1
    //   347: if_icmpeq -160 -> 187
    //   350: aload 4
    //   352: astore_2
    //   353: aload 4
    //   355: aload_1
    //   356: iconst_0
    //   357: iload_3
    //   358: invokevirtual 392	java/io/OutputStream:write	([BII)V
    //   361: goto -25 -> 336
    //   364: astore_1
    //   365: aload 4
    //   367: astore_0
    //   368: aload_0
    //   369: astore_2
    //   370: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   373: astore 4
    //   375: aload_0
    //   376: astore_2
    //   377: new 57	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 394
    //   387: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 5
    //   392: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: ifnonnull +97 -> 495
    //   401: ldc_w 384
    //   404: astore_1
    //   405: aload_0
    //   406: astore_2
    //   407: aload 4
    //   409: iconst_1
    //   410: aload_1
    //   411: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aload_0
    //   415: ifnull +7 -> 422
    //   418: aload_0
    //   419: invokevirtual 378	java/io/OutputStream:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   428: astore_1
    //   429: new 57	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 382
    //   439: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 5
    //   444: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: ifnonnull +16 -> 466
    //   453: ldc_w 384
    //   456: astore_0
    //   457: aload_1
    //   458: iconst_1
    //   459: aload_0
    //   460: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: goto -258 -> 205
    //   466: new 57	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   473: aload 5
    //   475: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 384
    //   481: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_0
    //   485: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: astore_0
    //   492: goto -35 -> 457
    //   495: aload_0
    //   496: astore_2
    //   497: new 57	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   504: aload 5
    //   506: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 396
    //   512: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 6
    //   517: invokevirtual 253	java/io/File:exists	()Z
    //   520: invokevirtual 399	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   523: ldc_w 401
    //   526: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore_1
    //   537: goto -132 -> 405
    //   540: astore_0
    //   541: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   544: astore_1
    //   545: new 57	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 382
    //   555: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 5
    //   560: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: ifnonnull +16 -> 582
    //   569: ldc_w 384
    //   572: astore_0
    //   573: aload_1
    //   574: iconst_1
    //   575: aload_0
    //   576: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: goto -157 -> 422
    //   582: new 57	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   589: aload 5
    //   591: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 384
    //   597: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: astore_0
    //   608: goto -35 -> 573
    //   611: astore_0
    //   612: aconst_null
    //   613: astore_2
    //   614: aload_2
    //   615: ifnull +7 -> 622
    //   618: aload_2
    //   619: invokevirtual 378	java/io/OutputStream:close	()V
    //   622: aload_0
    //   623: athrow
    //   624: astore_1
    //   625: getstatic 55	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:e	Ljava/lang/String;
    //   628: astore_2
    //   629: new 57	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 382
    //   639: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload 5
    //   644: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: ifnonnull +16 -> 666
    //   653: ldc_w 384
    //   656: astore_1
    //   657: aload_2
    //   658: iconst_1
    //   659: aload_1
    //   660: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: goto -41 -> 622
    //   666: new 57	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   673: aload 5
    //   675: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc_w 384
    //   681: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_1
    //   685: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: astore_1
    //   692: goto -35 -> 657
    //   695: astore_0
    //   696: goto -82 -> 614
    //   699: astore_1
    //   700: aconst_null
    //   701: astore_0
    //   702: goto -334 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	paramInputStream	InputStream
    //   0	705	1	paramOptions	BitmapFactory.Options
    //   0	705	2	paramFile	File
    //   0	705	3	paramInt	int
    //   84	324	4	localObject	Object
    //   36	638	5	str	String
    //   47	469	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   139	146	208	java/lang/OutOfMemoryError
    //   249	254	256	java/io/IOException
    //   89	97	364	java/lang/Exception
    //   100	110	364	java/lang/Exception
    //   113	120	364	java/lang/Exception
    //   123	128	364	java/lang/Exception
    //   131	136	364	java/lang/Exception
    //   139	146	364	java/lang/Exception
    //   155	161	364	java/lang/Exception
    //   168	180	364	java/lang/Exception
    //   183	187	364	java/lang/Exception
    //   190	195	364	java/lang/Exception
    //   212	239	364	java/lang/Exception
    //   330	336	364	java/lang/Exception
    //   339	345	364	java/lang/Exception
    //   353	361	364	java/lang/Exception
    //   200	205	424	java/io/IOException
    //   418	422	540	java/io/IOException
    //   49	61	611	finally
    //   61	75	611	finally
    //   75	86	611	finally
    //   618	622	624	java/io/IOException
    //   89	97	695	finally
    //   100	110	695	finally
    //   113	120	695	finally
    //   123	128	695	finally
    //   131	136	695	finally
    //   139	146	695	finally
    //   155	161	695	finally
    //   168	180	695	finally
    //   183	187	695	finally
    //   190	195	695	finally
    //   212	239	695	finally
    //   330	336	695	finally
    //   339	345	695	finally
    //   353	361	695	finally
    //   370	375	695	finally
    //   377	401	695	finally
    //   407	414	695	finally
    //   497	537	695	finally
    //   49	61	699	java/lang/Exception
    //   61	75	699	java/lang/Exception
    //   75	86	699	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      if (paramString == null) {
        return null;
      }
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        QLog.e(e, 1, "getImageBase64:FileNotFoundException " + paramString);
        paramString = null;
      }
      byte[] arrayOfByte1 = new byte[' '];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        for (;;)
        {
          int k = paramString.read(arrayOfByte1);
          if (k == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte1, 0, k);
        }
        byte[] arrayOfByte2;
        return "";
      }
      catch (IOException localIOException)
      {
        QLog.e(e, 1, "getImageBase64:IOException " + localIOException);
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        try
        {
          paramString.close();
        }
        catch (IOException paramString)
        {
          try
          {
            for (;;)
            {
              localByteArrayOutputStream.close();
              try
              {
                paramString = Base64.encodeToString(arrayOfByte2, 2);
                return paramString;
              }
              catch (Exception paramString)
              {
                QLog.e(e, 1, "getImageBase64:encodeToStringException " + paramString);
              }
              paramString = paramString;
              QLog.e(e, 1, "getImageBase64:IOException2 " + paramString);
            }
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              QLog.e(e, 1, "getImageBase64:IOException3 " + paramString);
            }
          }
        }
      }
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (!paramString.startsWith("file://")) {
      str = "file://" + paramString;
    }
    paramString = Uri.parse(str);
    paramString = a(BaseApplicationImpl.getContext(), paramString, paramInt1, paramInt2);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramString);
  }
  
  private String a(String[] paramArrayOfString)
  {
    QzoneDynamicAlbumPlugin.Size localSize = a(paramArrayOfString[1]);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", "http://www.dynamicalbumlocalimage.com" + paramArrayOfString[1]);
      if (localSize != null)
      {
        localJSONObject.put("width", localSize.jdField_a_of_type_Int);
        localJSONObject.put("height", localSize.b);
      }
      paramArrayOfString = a(paramArrayOfString[0]);
      if (paramArrayOfString != null)
      {
        localJSONObject.put("poiX", paramArrayOfString[1]);
        localJSONObject.put("poiY", paramArrayOfString[0]);
        localJSONObject.put("poiName", "");
      }
      paramArrayOfString = localJSONObject.toString();
      return paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
    return "";
  }
  
  private void a(Bundle paramBundle)
  {
    try
    {
      int k = paramBundle.getInt("param.DynamicMin");
      int m = paramBundle.getInt("param.DynamicMax");
      paramBundle = paramBundle.getString("param.DynamicCmd");
      if (!TextUtils.isEmpty(paramBundle))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("msg", "success");
        localJSONObject.put("maxNum", m);
        localJSONObject.put("minNum", k);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramBundle, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_d_of_type_Boolean)
      {
        localJSONObject.put("isCanPlayMusic", "false");
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      localJSONObject.put("isCanPlayMusic", "true");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    for (int k = paramArrayList.size();; k = 0)
    {
      new ArrayList();
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        if (jdField_a_of_type_ArrayOfInt == null) {
          jdField_a_of_type_ArrayOfInt = a();
        }
        if (jdField_a_of_type_JavaIoFile == null) {
          jdField_a_of_type_JavaIoFile = new File(jdField_d_of_type_JavaLangString);
        }
        ThreadManager.a(new yrh(this, paramArrayList, k), 5, null, true);
      }
      return;
    }
  }
  
  private void a(List paramList)
  {
    int k = 0;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "Dynamic" + e + " getDynamicAlbumImage " + paramList.size() + " " + (String)paramList.get(0));
      }
      if (jdField_a_of_type_ArrayOfInt != null) {}
    }
    else
    {
      return;
    }
    String[] arrayOfString = new String[paramList.size()];
    while (k < paramList.size()) {
      if (paramList.get(k) == null)
      {
        k += 1;
      }
      else
      {
        Object localObject = (String)paramList.get(k);
        int m = a((String)localObject);
        QzoneDynamicAlbumPlugin.Size localSize = a((String)localObject);
        float[] arrayOfFloat = a((String)localObject);
        double d1 = a(localSize);
        if (((m == 90) || (m == 270)) && (localSize != null))
        {
          m = localSize.jdField_a_of_type_Int;
          localSize.jdField_a_of_type_Int = localSize.b;
          localSize.b = m;
        }
        localObject = new JSONObject();
        arrayOfString[k] = (jdField_d_of_type_JavaLangString + (new Date().getTime() + k));
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("url", "http://www.dynamicalbumlocalimage.com" + arrayOfString[k]);
            if (localSize != null)
            {
              if (d1 <= 0.0D) {
                continue;
              }
              ((JSONObject)localObject).put("width", (int)(localSize.jdField_a_of_type_Int / d1));
              ((JSONObject)localObject).put("height", (int)(localSize.b / d1));
            }
            if (arrayOfFloat != null)
            {
              ((JSONObject)localObject).put("poiX", arrayOfFloat[1]);
              ((JSONObject)localObject).put("poiY", arrayOfFloat[0]);
              ((JSONObject)localObject).put("poiName", "");
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(((JSONObject)localObject).toString());
          break;
          ((JSONObject)localObject).put("width", localSize.jdField_a_of_type_Int);
          ((JSONObject)localObject).put("height", localSize.b);
        }
      }
    }
    ThreadManager.a(new yri(this, paramList, arrayOfString), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DeviceApiPlugin.a(true, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
      return;
    }
    DeviceApiPlugin.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(null);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_1
    //   10: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 68	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 9
    //   28: aload 9
    //   30: invokevirtual 253	java/io/File:exists	()Z
    //   33: ifeq -17 -> 16
    //   36: aload_1
    //   37: invokestatic 303	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)I
    //   40: istore 10
    //   42: new 258	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 5
    //   52: aload 9
    //   54: invokestatic 605	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   57: aload_0
    //   58: iload_3
    //   59: iload 4
    //   61: invokestatic 607	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:b	(Landroid/net/Uri;Landroid/content/Context;II)Landroid/graphics/BitmapFactory$Options;
    //   64: astore_0
    //   65: new 68	java/io/File
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: getstatic 543	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   77: invokevirtual 253	java/io/File:exists	()Z
    //   80: ifne +10 -> 90
    //   83: getstatic 543	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   86: invokevirtual 292	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: aload_1
    //   91: invokevirtual 253	java/io/File:exists	()Z
    //   94: ifne +8 -> 102
    //   97: aload_1
    //   98: invokevirtual 337	java/io/File:createNewFile	()Z
    //   101: pop
    //   102: new 339	java/io/FileOutputStream
    //   105: dup
    //   106: aload_1
    //   107: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 211	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   115: iconst_1
    //   116: if_icmpgt +13 -> 129
    //   119: aload_0
    //   120: getfield 345	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   123: invokestatic 348	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Ljava/lang/String;)Z
    //   126: ifne +113 -> 239
    //   129: aload_0
    //   130: getstatic 354	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   133: putfield 357	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   136: aload_0
    //   137: iconst_1
    //   138: putfield 360	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   141: aload_0
    //   142: iconst_1
    //   143: putfield 363	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   146: aload 5
    //   148: aconst_null
    //   149: aload_0
    //   150: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   153: astore_0
    //   154: aload_0
    //   155: astore_2
    //   156: iload 10
    //   158: ifeq +10 -> 168
    //   161: aload_0
    //   162: iload 10
    //   164: invokestatic 365	cooperation/qzone/webviewplugin/QzoneDynamicAlbumPlugin:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +47 -> 216
    //   172: aload_2
    //   173: getstatic 371	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   176: bipush 60
    //   178: aload_1
    //   179: invokevirtual 375	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   182: pop
    //   183: aload_2
    //   184: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   187: aload_1
    //   188: invokevirtual 378	java/io/OutputStream:close	()V
    //   191: aload 5
    //   193: invokevirtual 145	java/io/InputStream:close	()V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 378	java/io/OutputStream:close	()V
    //   204: aload 5
    //   206: ifnull +8 -> 214
    //   209: aload 5
    //   211: invokevirtual 145	java/io/InputStream:close	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 378	java/io/OutputStream:close	()V
    //   224: aload 5
    //   226: ifnull -210 -> 16
    //   229: aload 5
    //   231: invokevirtual 145	java/io/InputStream:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: iconst_0
    //   238: ireturn
    //   239: sipush 1024
    //   242: newarray <illegal type>
    //   244: astore_0
    //   245: aload 5
    //   247: aload_0
    //   248: invokevirtual 388	java/io/InputStream:read	([B)I
    //   251: istore_3
    //   252: iload_3
    //   253: iconst_m1
    //   254: if_icmpeq -67 -> 187
    //   257: aload_1
    //   258: aload_0
    //   259: iconst_0
    //   260: iload_3
    //   261: invokevirtual 392	java/io/OutputStream:write	([BII)V
    //   264: goto -19 -> 245
    //   267: astore_2
    //   268: aload_1
    //   269: astore_0
    //   270: aload_2
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   276: aload_0
    //   277: ifnull +7 -> 284
    //   280: aload_0
    //   281: invokevirtual 378	java/io/OutputStream:close	()V
    //   284: aload 5
    //   286: ifnull -270 -> 16
    //   289: aload 5
    //   291: invokevirtual 145	java/io/InputStream:close	()V
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_0
    //   297: iconst_0
    //   298: ireturn
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_1
    //   303: ifnull +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 378	java/io/OutputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_1
    //   313: aload 5
    //   315: astore_0
    //   316: aload_1
    //   317: invokevirtual 169	java/lang/Exception:printStackTrace	()V
    //   320: aload_0
    //   321: ifnull -305 -> 16
    //   324: aload_0
    //   325: invokevirtual 145	java/io/InputStream:close	()V
    //   328: iconst_0
    //   329: ireturn
    //   330: astore_0
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 145	java/io/InputStream:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: aload 6
    //   349: astore_0
    //   350: goto -196 -> 154
    //   353: astore_0
    //   354: goto -130 -> 224
    //   357: astore_0
    //   358: goto -154 -> 204
    //   361: astore_0
    //   362: goto -148 -> 214
    //   365: astore_0
    //   366: goto -82 -> 284
    //   369: astore_1
    //   370: goto -60 -> 310
    //   373: astore_1
    //   374: goto -30 -> 344
    //   377: astore_0
    //   378: aload 5
    //   380: astore_1
    //   381: goto -45 -> 336
    //   384: astore_2
    //   385: aload_0
    //   386: astore_1
    //   387: aload_2
    //   388: astore_0
    //   389: goto -53 -> 336
    //   392: astore_1
    //   393: aload 8
    //   395: astore_0
    //   396: goto -80 -> 316
    //   399: astore_0
    //   400: goto -98 -> 302
    //   403: astore_2
    //   404: aload_0
    //   405: astore_1
    //   406: aload_2
    //   407: astore_0
    //   408: goto -106 -> 302
    //   411: astore_1
    //   412: aload 7
    //   414: astore_0
    //   415: goto -143 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramContext	Context
    //   0	418	1	paramString1	String
    //   0	418	2	paramString2	String
    //   0	418	3	paramInt1	int
    //   0	418	4	paramInt2	int
    //   50	329	5	localFileInputStream	FileInputStream
    //   7	341	6	localObject1	Object
    //   1	412	7	localObject2	Object
    //   4	390	8	localObject3	Object
    //   26	27	9	localFile	File
    //   40	123	10	k	int
    // Exception table:
    //   from	to	target	type
    //   229	234	236	java/io/IOException
    //   111	129	267	java/lang/Exception
    //   129	146	267	java/lang/Exception
    //   146	154	267	java/lang/Exception
    //   161	168	267	java/lang/Exception
    //   172	187	267	java/lang/Exception
    //   187	196	267	java/lang/Exception
    //   239	245	267	java/lang/Exception
    //   245	252	267	java/lang/Exception
    //   257	264	267	java/lang/Exception
    //   289	294	296	java/io/IOException
    //   74	90	299	finally
    //   90	102	299	finally
    //   102	111	299	finally
    //   52	74	312	java/lang/Exception
    //   200	204	312	java/lang/Exception
    //   220	224	312	java/lang/Exception
    //   280	284	312	java/lang/Exception
    //   306	310	312	java/lang/Exception
    //   310	312	312	java/lang/Exception
    //   324	328	330	java/io/IOException
    //   42	52	333	finally
    //   146	154	346	java/lang/OutOfMemoryError
    //   220	224	353	java/io/IOException
    //   200	204	357	java/io/IOException
    //   209	214	361	java/io/IOException
    //   280	284	365	java/io/IOException
    //   306	310	369	java/io/IOException
    //   340	344	373	java/io/IOException
    //   52	74	377	finally
    //   200	204	377	finally
    //   220	224	377	finally
    //   280	284	377	finally
    //   306	310	377	finally
    //   310	312	377	finally
    //   316	320	384	finally
    //   42	52	392	java/lang/Exception
    //   111	129	399	finally
    //   129	146	399	finally
    //   146	154	399	finally
    //   161	168	399	finally
    //   172	187	399	finally
    //   187	196	399	finally
    //   239	245	399	finally
    //   245	252	399	finally
    //   257	264	399	finally
    //   272	276	403	finally
    //   74	90	411	java/lang/Exception
    //   90	102	411	java/lang/Exception
    //   102	111	411	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static float[] a(String paramString)
  {
    if (JpegExifReader.isCrashJpeg(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new ExifInterface(paramString);
        float[] arrayOfFloat = new float[2];
        boolean bool = paramString.getLatLong(arrayOfFloat);
        if (bool) {
          return arrayOfFloat;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static int[] a()
  {
    int[] arrayOfInt = new int[2];
    int k = QzoneConfig.a().a("MiniVideo", "MinCpu", 1150);
    long l1 = DeviceInfoUtil.a();
    long l2 = QzoneConfig.a().a("MiniVideo", "MinRam", 700);
    long l3 = DeviceInfoUtil.c() / 1048576L;
    long l4 = QzoneConfig.a().a("MiniVideo", "MinRuntimeRam", 150);
    long l5 = DeviceInfoUtil.d() / 1048576L;
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "Dynamic" + e + " freeSizeMB " + l5);
    }
    if ((Long.valueOf(l1).longValue() >= k) && (l3 >= l2) && (l5 >= l4))
    {
      arrayOfInt[0] = 1600;
      arrayOfInt[1] = 1600;
      return arrayOfInt;
    }
    arrayOfInt[0] = 640;
    arrayOfInt[1] = 640;
    return arrayOfInt;
  }
  
  public static double b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream.close();
      k = localOptions.outWidth;
      m = localOptions.outHeight;
      if (k < m) {
        if ((m <= paramInt1) && (k <= paramInt2))
        {
          d3 = 0.0D;
          return d3;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      double d3;
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
      double d1;
      if (m > k) {
        d1 = m / paramInt1;
      }
      for (double d2 = k / paramInt2;; d2 = m / paramInt2)
      {
        d3 = d1;
        if (d1 > d2) {
          break;
        }
        return d2;
        d1 = k / paramInt1;
      }
    }
    catch (OutOfMemoryError paramInputStream)
    {
      for (;;)
      {
        continue;
        int n = k;
        int k = m;
        int m = n;
      }
    }
  }
  
  public static BitmapFactory.Options b(Uri paramUri, Context paramContext, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    InputStream localInputStream = paramContext.getContentResolver().openInputStream(paramUri);
    double d1 = b(localInputStream, paramInt1, paramInt2);
    paramInt2 = (int)d1;
    paramInt1 = paramInt2;
    if (d1 > paramInt2) {
      paramInt1 = paramInt2 + 1;
    }
    localOptions.inSampleSize = paramInt1;
    localOptions.inJustDecodeBounds = true;
    localInputStream.close();
    paramUri = paramContext.getContentResolver().openInputStream(paramUri);
    try
    {
      BitmapFactory.decodeStream(paramUri, null, localOptions);
      paramUri.close();
      localOptions.inJustDecodeBounds = false;
      return localOptions;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;) {}
    }
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optJSONArray("photoList");
        ((JSONObject)localObject1).getString("callback");
        localObject1 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        k = 0;
        if (k < paramString.length())
        {
          Object localObject2 = paramString.get(k);
          if ((localObject2 != null) && ((localObject2 instanceof String)))
          {
            localObject2 = (String)localObject2;
            ((ArrayList)localObject1).add(localObject2);
            if (((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
              localArrayList.add(((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", ""));
            }
          }
        }
        else
        {
          RemoteHandleManager.a().a().a(localArrayList);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      k += 1;
    }
  }
  
  private void c(String paramString)
  {
    Object localObject1 = null;
    int k = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.optJSONArray("photoList");
        Object localObject2 = paramString.optJSONObject("data");
        ArrayList localArrayList = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          paramString = (String)localObject1;
          if (k < localJSONArray.length())
          {
            localObject3 = localJSONArray.getJSONObject(k);
            str1 = ((JSONObject)localObject3).getString("photoUrl");
            localObject1 = paramString;
            if (str1 != null)
            {
              localObject1 = paramString;
              if (str1.startsWith("http://www.dynamicalbumlocalimage.com")) {
                localObject1 = new DynamicPhotoData(str1, ((JSONObject)localObject3).getString("title"), ((JSONObject)localObject3).getString("desc"));
              }
            }
            if (localObject1 == null) {
              break label453;
            }
            localArrayList.add(localObject1);
            break label453;
          }
        }
        paramString = ((JSONObject)localObject2).getString("mgz_name");
        localObject1 = ((JSONObject)localObject2).getString("mgz_desc");
        Object localObject3 = ((JSONObject)localObject2).getString("tmplt_id");
        String str1 = ((JSONObject)localObject2).getString("music_id");
        String str2 = ((JSONObject)localObject2).getString("lrc_id");
        String str3 = ((JSONObject)localObject2).getString("climax_start");
        String str4 = ((JSONObject)localObject2).getString("climax_endure");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("DYNAMIC_ALBUM_PHOTOLIST", localArrayList);
        ((Bundle)localObject2).putString("mgz_name", paramString);
        ((Bundle)localObject2).putString("mgz_desc", (String)localObject1);
        ((Bundle)localObject2).putString("tmplt_id", (String)localObject3);
        ((Bundle)localObject2).putString("music_id", str1);
        ((Bundle)localObject2).putString("lrc_id", str2);
        ((Bundle)localObject2).putString("climax_start", str3);
        ((Bundle)localObject2).putString("climax_endure", str4);
        ((Bundle)localObject2).putBoolean("EDIT_IMAGE", false);
        ((Bundle)localObject2).putBoolean("APPEND_IMAGE", false);
        ((Bundle)localObject2).putBoolean("SHOW_RECNET_IMAGE", false);
        ((Bundle)localObject2).putString("SHARE_SOURCE", "动感影集");
        localObject3 = QZoneHelper.UserInfo.a();
        ((QZoneHelper.UserInfo)localObject3).a = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
        localObject1 = "";
        paramString = (String)localObject1;
        if (localJSONArray != null)
        {
          paramString = (String)localObject1;
          if (localJSONArray.length() > 0) {
            paramString = localJSONArray.getJSONObject(0).getString("photoUrl");
          }
        }
        if ((localArrayList.size() > 0) && (!TextUtils.isEmpty(paramString)))
        {
          localObject1 = paramString;
          if (paramString.startsWith("http://www.dynamicalbumlocalimage.com")) {
            localObject1 = paramString.replace("http://www.dynamicalbumlocalimage.com", "");
          }
          QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), (Bundle)localObject2, (QZoneHelper.UserInfo)localObject3, (String)localObject1, "动感影集", null, this.jdField_a_of_type_Int);
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label453:
      k += 1;
      paramString = (String)localObject1;
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label174;
        }
        localObject1 = new JSONArray();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(new JSONObject((String)((Iterator)localObject2).next()));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("photoList", localObject1);
    ((JSONObject)localObject2).put("totalNumPreSelected", this.jdField_a_of_type_JavaUtilList.size());
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", 0);
    ((JSONObject)localObject1).put("msg", "success");
    ((JSONObject)localObject1).put("data", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
    return;
    label174:
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("code", -1);
    ((JSONObject)localObject1).put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  private void e(String paramString)
  {
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).getString("callback");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("photoList");
          k = 0;
          if (k < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).get(k);
            if ((localObject2 == null) || (!(localObject2 instanceof String))) {
              break label232;
            }
            localObject2 = (String)localObject2;
            if (!((String)localObject2).startsWith("http://www.dynamicalbumlocalimage.com")) {
              break label232;
            }
            localObject2 = ((String)localObject2).replace("http://www.dynamicalbumlocalimage.com", "");
            Object localObject3 = a((String)localObject2);
            localObject2 = a((String)localObject2, ((QzoneDynamicAlbumPlugin.Size)localObject3).jdField_a_of_type_Int, ((QzoneDynamicAlbumPlugin.Size)localObject3).b);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("code", 0);
              ((JSONObject)localObject3).put("msg", "success");
              ((JSONObject)localObject3).put("data", localObject2);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject3).toString() });
            }
            else
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("code", -1);
              ((JSONObject)localObject2).put("msg", "fail");
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label232:
      k += 1;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.f = paramString;
      int k = new JSONObject(paramString).optInt("maxSelectNum");
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), PhotoListActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", k);
      localBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      localBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localBundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localBundle.putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      localBundle.putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      localBundle.putInt("uintype", 0);
      paramString.putExtras(localBundle);
      ((AbsBaseWebViewActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a()).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Object a(String paramString, long paramLong)
  {
    if ((paramLong == 8L) && (paramString.startsWith("http://www.dynamicalbumlocalimage.com")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZLog", 2, "Dynamic" + e + " getImageResponse " + paramString);
      }
      return a(paramString);
    }
    return super.a(paramString, paramLong);
  }
  
  public void a()
  {
    super.a();
    RemoteHandleManager.a().b(this);
    DeviceApiPlugin.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), false);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(e, 2, "unregiser fail");
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if (paramByte == this.jdField_a_of_type_Byte)
    {
      this.jdField_b_of_type_Boolean = false;
      if (paramInt == -1) {
        a(paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      }
    }
    else
    {
      return;
    }
    a(null, 0);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    if (!(paramWebViewPlugin.mRuntime.a() instanceof QQBrowserActivity)) {}
    do
    {
      do
      {
        return;
        localObject = ((QQBrowserActivity)paramWebViewPlugin.mRuntime.a()).ab;
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("h5s.qzone.qq.com/dynamic")));
      if (jdField_a_of_type_JavaIoFile == null) {
        jdField_a_of_type_JavaIoFile = new File(jdField_d_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.process.stopping");
    ((IntentFilter)localObject).addAction("com.tencent.process.starting");
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StopVideoChat");
    paramWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    RemoteHandleManager.a().a(this);
    paramWebViewPlugin.mRuntime.a().a(QzoneDynamicAlbumPlugin.class).post(new yrc(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    int k = localAudioManager.getStreamMaxVolume(3);
    int m = localAudioManager.getStreamVolume(3);
    if (localAudioManager.getRingerMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", paramInt);
        paramString.put("isMute", bool);
        paramString.put("maxVolume", k);
        paramString.put("currentVolume", m);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("qbrowserVolumeChange", paramString, paramString);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    String str;
    try
    {
      if (TextUtils.isEmpty(this.f)) {
        return;
      }
      str = new JSONObject(this.f).optString("callback");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label193;
      }
      localObject = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONArray)localObject).put(new JSONObject((String)paramList.next()));
      }
      paramList = new JSONObject();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    paramList.put("photoList", localObject);
    paramList.put("totalNumPreSelected", paramInt);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("msg", "success");
    ((JSONObject)localObject).put("data", paramList);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { ((JSONObject)localObject).toString() });
    return;
    label193:
    paramList = new JSONObject();
    paramList.put("code", -1);
    paramList.put("msg", "fail");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(str, new String[] { paramList.toString() });
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("qzDynamicAlbum")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (paramJsBridgeListener = "" + paramJsBridgeListener.a; "deletePhotos".equals(paramString3); paramJsBridgeListener = paramVarArgs[0])
    {
      b(paramJsBridgeListener);
      return true;
    }
    if ("saveDynamicAlbum".equals(paramString3)) {
      return true;
    }
    if ("getPhotos".equals(paramString3))
    {
      d(paramJsBridgeListener);
      return true;
    }
    if ("getSelectNum".equals(paramString3))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(QzoneDynamicAlbumPlugin.class).post(new yre(this, paramJsBridgeListener));
      return true;
    }
    if ("entryWriteMoodAsync".equals(paramString3))
    {
      c(paramJsBridgeListener);
      return true;
    }
    if ("toBase64".equals(paramString3))
    {
      e(paramJsBridgeListener);
      return true;
    }
    if ("openImagePicker".equals(paramString3))
    {
      f(paramJsBridgeListener);
      return true;
    }
    if ("cancel".equals(paramString3))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(QzoneDynamicAlbumPlugin.class).post(new yrf(this));
      return true;
    }
    if ("requestPlayMusic".equals(paramString3))
    {
      a(paramJsBridgeListener);
      return true;
    }
    if ("startPlay".equals(paramString3))
    {
      a(true);
      return true;
    }
    if ("endPlay".equals(paramString3))
    {
      a(false);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    int k;
    int m;
    if ((paramLong == 8589934600L) && ((Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte) || (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Int)))
    {
      k = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      m = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if (k != this.jdField_a_of_type_Byte) {
        break label178;
      }
      if (m != -1) {
        break label169;
      }
      a(localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }
    while ((TextUtils.isEmpty(paramString)) || (!paramString.contains("h5s.qzone.qq.com/dynamic")))
    {
      return super.a(paramString, paramLong, paramMap);
      label169:
      a(null, 0);
      continue;
      label178:
      if ((k == this.jdField_a_of_type_Int) && (m == -1) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
      }
    }
    if (paramLong == 2L)
    {
      this.c = true;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        a(null, 0);
      }
    }
    for (;;)
    {
      return super.a(paramString, paramLong, paramMap);
      if (paramLong == 8589934597L) {
        this.c = false;
      } else if (paramLong == 8589934608L) {
        a("qbrowserVolumeChange", 2);
      } else if (paramLong == 8589934609L) {
        a("qbrowserVolumeChange", 1);
      }
    }
  }
  
  public void b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playInterruptBegin", localJSONObject1, localJSONObject2);
  }
  
  public void c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("com.tencent.qq.qzone.playWillBeInterruptEnd", localJSONObject1, localJSONObject2);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramString.equals("cmd.getDynamicPhoto"))
      {
        a(paramBundle.getStringArrayList("param.DynamicPhotolist"));
        return;
      }
    } while (!paramString.equals("cmd.getDynamicSelnum"));
    a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneDynamicAlbumPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */