package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.share.QZoneShareActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import org.json.JSONException;
import org.json.JSONObject;
import ykz;

public class QZoneShareManager
{
  public static final int a = 2020014;
  public static final String a = "QZoneShare";
  private static ConcurrentHashMap a = new ConcurrentHashMap();
  public static final int b = 9;
  public static final String b = "1103584836";
  public static final int c = 55555;
  public static final String c = "qzone_uin";
  public static final int d = 55556;
  public static final String d = "share_data";
  public static final int e = 55557;
  public static final String e = "key_share_is_third_party";
  public static final int f = 55558;
  public static final String f = "summary";
  public static final int g = 30;
  public static final String g = "images";
  public static final int h = 40;
  public static final String h = "hulian_appid";
  public static final int i = -1;
  public static final String i = "share_action";
  public static final int j = -11210;
  public static final String j = "file_send_path";
  public static final int k = -11207;
  public static final String k = "defaultText";
  public static final int l = -11215;
  public static final String l = "app_name";
  public static final int m = -2;
  public static final String m = "from_web";
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 5;
  public static final int q = 15790320;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i2 = paramOptions.outHeight;
    int i1 = paramOptions.outWidth;
    if ((i2 > paramInt2) || (i1 > paramInt1))
    {
      paramInt2 = Math.round(i2 / paramInt2);
      paramInt1 = Math.round(i1 / paramInt1);
      if (paramInt2 < paramInt1) {
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 2;
      }
      return paramInt2;
      continue;
      paramInt1 = 2;
    }
  }
  
  public static final long a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return 0L;
      paramIntent = paramIntent.getBundleExtra("share_data");
    } while (paramIntent == null);
    return paramIntent.getLong("req_share_id", 0L);
  }
  
  public static final Bundle a(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if (localArrayList != null)
    {
      int i1 = localArrayList.size() - 1;
      while (i1 >= 0)
      {
        String str = (String)localArrayList.get(i1);
        if ((!HttpUtil.a(str)) && (!FileUtil.a(str))) {
          localArrayList.remove(i1);
        }
        i1 -= 1;
      }
      while (localArrayList.size() > 9) {
        localArrayList.remove(9);
      }
      if (localArrayList.size() > 0)
      {
        if (HttpUtil.a((String)localArrayList.get(0)))
        {
          i1 = localArrayList.size() - 1;
          while (i1 >= 0)
          {
            if (!HttpUtil.a((String)localArrayList.get(i1))) {
              localArrayList.remove(i1);
            }
            i1 -= 1;
          }
        }
        i1 = localArrayList.size() - 1;
        while (i1 >= 0)
        {
          if (i1 != 0) {
            localArrayList.remove(i1);
          }
          i1 -= 1;
        }
      }
      paramBundle.putStringArrayList("image_url", localArrayList);
    }
    return paramBundle;
  }
  
  public static OpenID a(AppRuntime paramAppRuntime, String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = (OpenID)a.get(paramString);
    if (localObject != null) {
      return (OpenID)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "get openid key = " + paramString);
    }
    paramAppRuntime = (AccountManager)paramAppRuntime.getManager(0);
    localObject = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    ((HashMap)localObject).put("RequestCustomSig", localRequestCustomSig);
    ((HashMap)localObject).put("OpenAppid", paramString);
    paramAppRuntime.changeToken((HashMap)localObject, new ykz(paramString, paramBusinessObserver));
    return null;
  }
  
  /* Error */
  public static File a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 228	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 5
    //   11: aload_0
    //   12: invokestatic 230	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: new 87	android/graphics/BitmapFactory$Options
    //   20: dup
    //   21: invokespecial 231	android/graphics/BitmapFactory$Options:<init>	()V
    //   24: astore_2
    //   25: aload_2
    //   26: iconst_1
    //   27: putfield 234	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: aload_2
    //   32: invokestatic 240	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: pop
    //   36: aload_2
    //   37: aload_2
    //   38: sipush 640
    //   41: sipush 640
    //   44: invokestatic 242	cooperation/qzone/QZoneShareManager:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   47: putfield 245	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   50: aload_2
    //   51: iconst_0
    //   52: putfield 234	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   55: aload_0
    //   56: aload_2
    //   57: invokestatic 240	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_0
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: ifnull +85 -> 149
    //   67: aload_3
    //   68: astore_2
    //   69: aload 5
    //   71: ifnull +78 -> 149
    //   74: aload_0
    //   75: astore_2
    //   76: new 247	java/io/File
    //   79: dup
    //   80: aload 5
    //   82: new 162	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   89: iload_1
    //   90: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 253	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: new 255	java/io/FileOutputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 258	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore 5
    //   117: aload_0
    //   118: astore_2
    //   119: aload_0
    //   120: getstatic 264	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   123: bipush 50
    //   125: aload 5
    //   127: invokevirtual 270	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: ifeq +17 -> 147
    //   133: aload_0
    //   134: astore_2
    //   135: aload 5
    //   137: invokevirtual 273	java/io/FileOutputStream:flush	()V
    //   140: aload_0
    //   141: astore_2
    //   142: aload 5
    //   144: invokevirtual 276	java/io/FileOutputStream:close	()V
    //   147: aload_3
    //   148: astore_2
    //   149: aload_2
    //   150: astore_3
    //   151: aload_0
    //   152: ifnull +21 -> 173
    //   155: aload_2
    //   156: astore_3
    //   157: aload_0
    //   158: invokevirtual 279	android/graphics/Bitmap:isRecycled	()Z
    //   161: ifne +12 -> 173
    //   164: aload_0
    //   165: invokevirtual 282	android/graphics/Bitmap:recycle	()V
    //   168: invokestatic 287	java/lang/System:gc	()V
    //   171: aload_2
    //   172: astore_3
    //   173: aload_3
    //   174: areturn
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: astore_2
    //   180: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +15 -> 198
    //   186: aload_0
    //   187: astore_2
    //   188: ldc 10
    //   190: iconst_2
    //   191: ldc_w 289
    //   194: aload_3
    //   195: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload 4
    //   200: astore_3
    //   201: aload_0
    //   202: ifnull -29 -> 173
    //   205: aload 4
    //   207: astore_3
    //   208: aload_0
    //   209: invokevirtual 279	android/graphics/Bitmap:isRecycled	()Z
    //   212: ifne -39 -> 173
    //   215: aload_0
    //   216: invokevirtual 282	android/graphics/Bitmap:recycle	()V
    //   219: invokestatic 287	java/lang/System:gc	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: astore_2
    //   229: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +15 -> 247
    //   235: aload_0
    //   236: astore_2
    //   237: ldc 10
    //   239: iconst_2
    //   240: ldc_w 294
    //   243: aload_3
    //   244: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload 4
    //   249: astore_3
    //   250: aload_0
    //   251: ifnull -78 -> 173
    //   254: aload 4
    //   256: astore_3
    //   257: aload_0
    //   258: invokevirtual 279	android/graphics/Bitmap:isRecycled	()Z
    //   261: ifne -88 -> 173
    //   264: aload_0
    //   265: invokevirtual 282	android/graphics/Bitmap:recycle	()V
    //   268: invokestatic 287	java/lang/System:gc	()V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_2
    //   276: aload_2
    //   277: ifnull +17 -> 294
    //   280: aload_2
    //   281: invokevirtual 279	android/graphics/Bitmap:isRecycled	()Z
    //   284: ifne +10 -> 294
    //   287: aload_2
    //   288: invokevirtual 282	android/graphics/Bitmap:recycle	()V
    //   291: invokestatic 287	java/lang/System:gc	()V
    //   294: aload_0
    //   295: athrow
    //   296: astore_0
    //   297: goto -21 -> 276
    //   300: astore_3
    //   301: goto -74 -> 227
    //   304: astore_3
    //   305: goto -127 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString	String
    //   0	308	1	paramInt	int
    //   24	264	2	localObject1	Object
    //   4	170	3	localObject2	Object
    //   175	20	3	localException1	Exception
    //   200	8	3	localObject3	Object
    //   224	20	3	localOutOfMemoryError1	OutOfMemoryError
    //   249	8	3	localObject4	Object
    //   300	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   304	1	3	localException2	Exception
    //   1	254	4	localObject5	Object
    //   9	134	5	localObject6	Object
    //   15	79	6	str	String
    // Exception table:
    //   from	to	target	type
    //   17	61	175	java/lang/Exception
    //   17	61	224	java/lang/OutOfMemoryError
    //   17	61	273	finally
    //   76	105	296	finally
    //   107	117	296	finally
    //   119	133	296	finally
    //   135	140	296	finally
    //   142	147	296	finally
    //   180	186	296	finally
    //   188	198	296	finally
    //   229	235	296	finally
    //   237	247	296	finally
    //   76	105	300	java/lang/OutOfMemoryError
    //   107	117	300	java/lang/OutOfMemoryError
    //   119	133	300	java/lang/OutOfMemoryError
    //   135	140	300	java/lang/OutOfMemoryError
    //   142	147	300	java/lang/OutOfMemoryError
    //   76	105	304	java/lang/Exception
    //   107	117	304	java/lang/Exception
    //   119	133	304	java/lang/Exception
    //   135	140	304	java/lang/Exception
    //   142	147	304	java/lang/Exception
  }
  
  public static final ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramArrayList.size()) {
        break label396;
      }
      Object localObject2 = (String)paramArrayList.get(i1);
      Object localObject1;
      if (FileUtil.a((String)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 4, "local url:" + (String)localObject2);
        }
        localObject1 = localObject2;
        if (FileUtil.a((String)localObject2) > 2097152L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 4, "file length:" + FileUtil.a((String)localObject2));
          }
          localObject2 = a((String)localObject2, i1);
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((File)localObject2).getAbsolutePath();
          localArrayList.add(localObject2);
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put("Connection", "keep-alive");
        ((Map)localObject2).put("Referer", "http://www.qq.com");
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("type", paramString3);
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("share_image", localObject1);
        localObject1 = HttpUtil.a(MsfSdkUtils.insertMtype("qzPicu", "http://cgi.connect.qq.com/qqconnectopen/upload_share_image"), paramString1, paramString2, localHashMap1, localHashMap2, (Map)localObject2);
        if (localObject1 == null) {}
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).getInt("retcode") == 0)
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("result");
          if (localObject1 != null)
          {
            paramArrayList.set(i1, ((JSONObject)localObject1).getString("url"));
            if (QLog.isColorLevel()) {
              QLog.d("QZoneShare", 4, "target url:" + ((JSONObject)localObject1).getString("url"));
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 4, localJSONException.getMessage());
          }
        }
      }
      i1 += 1;
    }
    label396:
    a(localArrayList);
    return paramArrayList;
  }
  
  public static final void a(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "shareToQzone()");
    }
    if ((paramContext == null) || (paramQZoneShareData == null))
    {
      QLog.e("QZoneShare", 1, "shareToQzone() params error");
      return;
    }
    com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
    try
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      ((Activity)paramContext).startActivityForResult(paramOnDismissListener, paramInt);
      return;
    }
    catch (Exception paramOnDismissListener)
    {
      paramOnDismissListener = new Intent(paramContext, QZoneShareActivity.class);
      paramOnDismissListener.putExtra("qzone_uin", paramString);
      paramOnDismissListener.putExtra("extraIntentKeyParcelable", paramQZoneShareData);
      paramOnDismissListener.addFlags(268435456);
      paramContext.startActivity(paramOnDismissListener);
    }
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "publishToQzone()");
    }
    if ((paramBundle == null) || (paramAppInterface == null))
    {
      QLog.d("QZoneShare", 1, "publishToQzone() params error");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramAppInterface.getAccount());
    localIntent.putExtra("key_share_is_third_party", true);
    ArrayList localArrayList = paramBundle.getStringArrayList("images");
    if ((localArrayList != null) && (localArrayList.size() > 9)) {}
    for (String str1 = "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity";; str1 = "com.qzone.publish.ui.activity.QZonePublishMoodActivity")
    {
      if (!a(paramBundle.getString("hulian_appid")))
      {
        String str2 = paramBundle.getString("file_send_path");
        if (((localArrayList != null) && (localArrayList.size() > 0)) || (!TextUtils.isEmpty(str2)))
        {
          paramBundle.putString("summary", "");
          paramBundle.putString("defaultText", "");
        }
      }
      localIntent.putExtras(paramBundle);
      QzonePluginProxyActivity.a(localIntent, str1);
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
      try
      {
        paramBundle = QZoneHelper.UserInfo.a();
        paramBundle.jdField_a_of_type_JavaLangString = paramAppInterface.a();
        QZoneHelper.a((Activity)paramContext, paramBundle, localIntent, paramInt, paramOnDismissListener);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
        paramAppInterface.addFlags(268435456);
        paramAppInterface.putExtras(localIntent);
        paramContext.startActivity(paramAppInterface);
        return;
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        FileUtil.a((File)localIterator.next());
      }
      paramArrayList.clear();
    }
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return a(paramAppInterface, paramContext, paramBundle, paramOnDismissListener, -1);
  }
  
  @Deprecated
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if ((paramBundle == null) || (paramAppInterface == null)) {
      return false;
    }
    Object localObject = paramBundle.getString("title");
    String str = paramBundle.getString("desc");
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("qzone_uin", paramAppInterface.getAccount());
      ((Intent)localObject).putExtra("key_share_is_third_party", true);
      ((Intent)localObject).putExtra("share_data", paramBundle);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(268435456);
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = true;
      try
      {
        paramBundle = QZoneHelper.UserInfo.a();
        paramBundle.jdField_a_of_type_JavaLangString = paramAppInterface.a();
        QZoneHelper.a((Activity)paramContext, paramBundle, (Intent)localObject, paramInt, paramOnDismissListener);
        return true;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
          paramAppInterface.addFlags(268435456);
          paramAppInterface.putExtras((Intent)localObject);
          paramContext.startActivity(paramAppInterface);
        }
      }
    }
    b(paramBundle);
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).b = paramBundle.getString("title");
    ((QZoneShareData)localObject).c = paramBundle.getString("desc");
    ((QZoneShareData)localObject).jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("image_url");
    ((QZoneShareData)localObject).jdField_g_of_type_JavaLangString = paramBundle.getString("share_qq_ext_str");
    ((QZoneShareData)localObject).jdField_a_of_type_Long = paramBundle.getLong("req_share_id");
    ((QZoneShareData)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("open_id");
    ((QZoneShareData)localObject).e = paramBundle.getString("app_name");
    ((QZoneShareData)localObject).d = paramBundle.getString("detail_url");
    ((QZoneShareData)localObject).jdField_f_of_type_Int = paramBundle.getInt("iUrlInfoFrm");
    if (paramBundle.getBoolean("thirdPartShare")) {}
    for (((QZoneShareData)localObject).jdField_g_of_type_Int = 1;; ((QZoneShareData)localObject).jdField_g_of_type_Int = 0)
    {
      ((QZoneShareData)localObject).h = paramBundle.getString("share_action");
      ((QZoneShareData)localObject).j = paramBundle.getString("jfrom");
      ((QZoneShareData)localObject).i = paramBundle.getString("pkg_name");
      ((QZoneShareData)localObject).jdField_f_of_type_JavaLangString = paramBundle.getString("share_uin");
      a(paramContext, paramAppInterface.a(), (QZoneShareData)localObject, paramOnDismissListener, paramInt);
      return true;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = QzoneConfig.a().a("QZoneSetting", "sharewhitelist", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramString.equals(localObject[i1])) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public static final Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      paramBundle.remove("detail_url");
    }
    a(paramBundle);
    return paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneShareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */