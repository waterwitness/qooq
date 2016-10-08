package com.tencent.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import jor;
import jos;
import mqq.app.AppRuntime;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class DeviceHeadMgr
{
  private static DeviceHeadMgr jdField_a_of_type_ComTencentDeviceDeviceHeadMgr;
  protected static final String a = "http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png";
  private static final String jdField_b_of_type_JavaLangString = "SDHeadImage";
  private static final String d = "sd_http_lastmodify";
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private String c;
  
  public DeviceHeadMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = (Environment.getExternalStorageDirectory().getPath() + "/devicehead/");
  }
  
  public static DeviceHeadMgr a()
  {
    if (jdField_a_of_type_ComTencentDeviceDeviceHeadMgr == null)
    {
      jdField_a_of_type_ComTencentDeviceDeviceHeadMgr = new DeviceHeadMgr();
      jdField_a_of_type_ComTencentDeviceDeviceHeadMgr.a();
    }
    return jdField_a_of_type_ComTencentDeviceDeviceHeadMgr;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 8) {}
    for (String str = "00000000" + paramString;; str = paramString)
    {
      str = str.substring(str.length() - 8);
      return String.format("http://i.gtimg.cn/open/device_icon/%s/%s/%s/%s/%s.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString });
    }
  }
  
  private void a()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      Object localObject = SSLSocketFactory.getSocketFactory();
      ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      localObject = new BasicHttpParams();
      ConnManagerParams.setTimeout((HttpParams)localObject, 3000L);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 30000);
      this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      Util.a(this.c);
      if (SystemUtil.a()) {}
      for (this.c = AppConstants.cU;; this.c = "/data/data/com.tencent.mobileqq/files/head/_dhd/")
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        if (this.b == null) {
          this.b = new HashMap();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("sd_http_lastmodify", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private String b(String paramString)
  {
    return CommonDataAdapter.a().a().getSharedPreferences("sd_http_lastmodify", 0).getString(paramString, "");
  }
  
  public Bitmap a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if (localBitmap2 != null) {
        return localBitmap2;
      }
    }
    ??? = String.valueOf(paramInt);
    String str = this.c + (String)???;
    if (TextUtils.isEmpty((CharSequence)???))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDHeadImage", 2, "productid is not valid");
      }
      try
      {
        ??? = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), 2130838435);
        return (Bitmap)???;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ??? = null;
        if (!QLog.isColorLevel()) {
          return ???;
        }
      }
      QLog.d("SDHeadImage", 2, "getDeviceHeadByPID BitmapFactory.decodeResource", localOutOfMemoryError);
      return null;
    }
    else
    {
      Bitmap localBitmap1 = BitmapManager.a(str);
      AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
      if (!this.b.containsKey(Integer.valueOf(paramInt)))
      {
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
        {
          ((QQAppInterface)localAppRuntime).a(new jor(this, (String)???, str, paramInt));
          this.b.put(Integer.valueOf(paramInt), Integer.valueOf(0));
        }
      }
      else
      {
        if (localBitmap1 == null) {
          break label309;
        }
        if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
          break label292;
        }
        localBitmap1 = ((QQAppInterface)localAppRuntime).a(localBitmap1, 50, 50);
      }
      label292:
      label309:
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBitmap1);
          ??? = localBitmap1;
          if (localBitmap1 != null) {
            return ???;
          }
          return BitmapManager.a(BaseApplication.getContext().getResources(), 2130838435);
          new Thread(new jos(this, (String)???, str, paramInt)).start();
          break;
          localBitmap1 = ImageUtil.b(localBitmap1, 50, 50);
        }
      }
    }
    return (Bitmap)???;
  }
  
  public Bitmap a(String paramString)
  {
    paramString = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(51)).a(Long.parseLong(paramString));
    if (paramString == null) {
      return a(0);
    }
    return a(paramString.productId);
  }
  
  public Drawable a(String paramString)
  {
    long l = Long.parseLong(paramString);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(51)).a(Long.valueOf(l).longValue());
    Bitmap localBitmap = null;
    if (localDeviceInfo != null)
    {
      localBitmap = a(localDeviceInfo.productId);
      if (a(paramString))
      {
        paramString = BaseApplication.getContext().getResources().getDrawable(2130838434);
        if ((paramString instanceof SkinnableBitmapDrawable)) {
          ((SkinnableBitmapDrawable)paramString).setGravity(119);
        }
        if ((paramString instanceof BitmapDrawable)) {
          ((BitmapDrawable)paramString).setGravity(119);
        }
        return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap), paramString });
      }
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = a(0);
    }
    return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
  }
  
  /* Error */
  public void a(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 39	java/io/File
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 381	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload 5
    //   17: ifnull +408 -> 425
    //   20: aload 5
    //   22: invokevirtual 384	java/io/File:exists	()Z
    //   25: ifeq +400 -> 425
    //   28: iconst_1
    //   29: istore 8
    //   31: aload 5
    //   33: invokevirtual 387	java/io/File:getParentFile	()Ljava/io/File;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +15 -> 53
    //   41: aload_2
    //   42: invokevirtual 384	java/io/File:exists	()Z
    //   45: ifne +8 -> 53
    //   48: aload_2
    //   49: invokevirtual 390	java/io/File:mkdirs	()Z
    //   52: pop
    //   53: ldc 70
    //   55: astore_2
    //   56: new 392	org/apache/http/client/methods/HttpGet
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 393	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   64: astore 4
    //   66: iload 8
    //   68: ifeq +21 -> 89
    //   71: aload_0
    //   72: aload_1
    //   73: invokestatic 398	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 400	com/tencent/device/DeviceHeadMgr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_2
    //   80: aload 4
    //   82: ldc_w 402
    //   85: aload_2
    //   86: invokevirtual 405	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +29 -> 121
    //   95: ldc 12
    //   97: iconst_2
    //   98: new 30	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 407
    //   108: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: getfield 158	com/tencent/device/DeviceHeadMgr:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   125: aload 4
    //   127: invokevirtual 411	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   130: astore_2
    //   131: aload_2
    //   132: invokeinterface 417 1 0
    //   137: invokeinterface 422 1 0
    //   142: istore 9
    //   144: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +30 -> 177
    //   150: ldc 12
    //   152: iconst_2
    //   153: new 30	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 424
    //   163: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 9
    //   168: invokevirtual 427	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_2
    //   178: invokeinterface 431 1 0
    //   183: astore 6
    //   185: iload 9
    //   187: sipush 200
    //   190: if_icmpne +195 -> 385
    //   193: iload 8
    //   195: ifeq +9 -> 204
    //   198: aload 5
    //   200: invokevirtual 434	java/io/File:delete	()Z
    //   203: pop
    //   204: new 436	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 438	java/io/FileOutputStream
    //   211: dup
    //   212: aload 5
    //   214: invokespecial 441	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   217: invokespecial 444	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   220: astore 7
    //   222: aload 6
    //   224: aload 7
    //   226: invokeinterface 449 2 0
    //   231: aload 7
    //   233: invokevirtual 454	java/io/OutputStream:flush	()V
    //   236: aload 5
    //   238: invokevirtual 456	java/io/File:length	()J
    //   241: lstore 12
    //   243: aload_2
    //   244: ldc_w 458
    //   247: invokeinterface 461 2 0
    //   252: ifeq +27 -> 279
    //   255: aload_2
    //   256: ldc_w 458
    //   259: invokeinterface 465 2 0
    //   264: invokeinterface 470 1 0
    //   269: astore_2
    //   270: aload_0
    //   271: aload_1
    //   272: invokestatic 398	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   275: aload_2
    //   276: invokespecial 472	com/tencent/device/DeviceHeadMgr:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +55 -> 337
    //   285: ldc 12
    //   287: iconst_2
    //   288: new 30	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 474
    //   298: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   304: lload 10
    //   306: lsub
    //   307: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: ldc_w 479
    //   313: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: lload 12
    //   318: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   321: ldc_w 481
    //   324: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_1
    //   328: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 484	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload_0
    //   338: getfield 175	com/tencent/device/DeviceHeadMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   341: astore_1
    //   342: aload_1
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 175	com/tencent/device/DeviceHeadMgr:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   348: iload_3
    //   349: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: invokevirtual 487	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: pop
    //   356: aload_1
    //   357: monitorexit
    //   358: new 489	android/content/Intent
    //   361: dup
    //   362: ldc_w 491
    //   365: invokespecial 492	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   368: astore_1
    //   369: aload_1
    //   370: ldc_w 493
    //   373: iload_3
    //   374: invokevirtual 497	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   377: pop
    //   378: invokestatic 275	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   381: aload_1
    //   382: invokevirtual 501	com/tencent/common/app/BaseApplicationImpl:sendBroadcast	(Landroid/content/Intent;)V
    //   385: aload 4
    //   387: invokevirtual 504	org/apache/http/client/methods/HttpGet:abort	()V
    //   390: return
    //   391: astore_2
    //   392: aload_1
    //   393: monitorexit
    //   394: aload_2
    //   395: athrow
    //   396: astore_1
    //   397: aload_1
    //   398: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   401: goto -16 -> 385
    //   404: astore_1
    //   405: aload_1
    //   406: invokevirtual 507	java/lang/Exception:printStackTrace	()V
    //   409: aload 4
    //   411: invokevirtual 504	org/apache/http/client/methods/HttpGet:abort	()V
    //   414: return
    //   415: astore_1
    //   416: aload 4
    //   418: invokevirtual 504	org/apache/http/client/methods/HttpGet:abort	()V
    //   421: aload_1
    //   422: athrow
    //   423: astore_1
    //   424: return
    //   425: iconst_0
    //   426: istore 8
    //   428: goto -397 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	DeviceHeadMgr
    //   0	431	2	paramString2	String
    //   0	431	3	paramInt	int
    //   64	353	4	localHttpGet	org.apache.http.client.methods.HttpGet
    //   13	224	5	localFile	File
    //   183	40	6	localHttpEntity	org.apache.http.HttpEntity
    //   220	12	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   29	398	8	i	int
    //   142	49	9	j	int
    //   3	302	10	l1	long
    //   241	76	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   344	358	391	finally
    //   392	394	391	finally
    //   204	279	396	java/lang/Exception
    //   279	337	396	java/lang/Exception
    //   337	344	396	java/lang/Exception
    //   358	385	396	java/lang/Exception
    //   394	396	396	java/lang/Exception
    //   121	177	404	java/lang/Exception
    //   177	185	404	java/lang/Exception
    //   198	204	404	java/lang/Exception
    //   397	401	404	java/lang/Exception
    //   121	177	415	finally
    //   177	185	415	finally
    //   198	204	415	finally
    //   204	279	415	finally
    //   279	337	415	finally
    //   337	344	415	finally
    //   358	385	415	finally
    //   394	396	415	finally
    //   397	401	415	finally
    //   405	409	415	finally
    //   31	37	423	java/lang/Exception
    //   41	53	423	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.a().a()).a(51)).a(Long.parseLong(paramString));
  }
  
  public Bitmap b(int paramInt)
  {
    return BitmapManager.a(this.c + paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\DeviceHeadMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */