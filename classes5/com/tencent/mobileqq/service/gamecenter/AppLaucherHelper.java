package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;
import uoy;
import uoz;
import upa;
import upb;

public class AppLaucherHelper
{
  public static final int a = 1;
  protected static long a = 0L;
  public static boolean a = false;
  public static final int b = 2;
  protected static String b;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  public static final int g = 64;
  public static final int h = 128;
  public static final int i = 256;
  public Handler a;
  public String a;
  public HashMap a;
  public NewIntent a;
  public Handler b;
  public boolean b;
  protected int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public AppLaucherHelper()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString)
  {
    int m = 0;
    if (paramString.contains("$OPID$")) {
      m = 1;
    }
    int k = m;
    if (paramString.contains("$AT$")) {
      k = m | 0x2;
    }
    m = k;
    if (paramString.contains("$PT$")) {
      m = k | 0x4;
    }
    k = m;
    if (paramString.contains("$PF$")) {
      k = m | 0x40;
    }
    m = k;
    if (paramString.contains("$ESK$")) {
      m = k | 0x80;
    }
    return m;
  }
  
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localBundle;
      paramString = paramString.split("&");
    } while (paramString == null);
    int m = paramString.length;
    int k = 0;
    while (k < m)
    {
      Object localObject = paramString[k];
      int n = ((String)localObject).indexOf('=');
      if (n != -1) {}
      try
      {
        localBundle.putString(((String)localObject).substring(0, n), ((String)localObject).substring(n + 1));
        k += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("AppLaucherHelper", 2, localException.getMessage(), localException);
        }
      }
    }
  }
  
  public static void a()
  {
    jdField_b_of_type_JavaLangString = "";
  }
  
  private void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    localupb = new upb(this, System.currentTimeMillis(), paramString3, paramContext, paramInt);
    if (this.jdField_a_of_type_MqqAppNewIntent == null) {
      this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(paramContext, ProtoServlet.class);
    }
    localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramAppInterface.a());
      l1 = l2;
    }
    catch (Exception localException)
    {
      long l2;
      for (;;) {}
    }
    localAuthorizeRequest.uin.set(l1);
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      int k;
      for (;;) {}
    }
    localAuthorizeRequest.client_id.set(l1);
    localAuthorizeRequest.pf.set("");
    paramString1 = AppUtil.a(paramContext);
    localAuthorizeRequest.qqv.set(paramString1);
    localAuthorizeRequest.sdkp.set("a");
    paramString1 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString1);
    localAuthorizeRequest.skey.set(paramString4);
    k = a(paramString2);
    if (k == 0)
    {
      AppUtil.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
      jdField_a_of_type_Boolean = false;
      return;
    }
    localAuthorizeRequest.flags.set(k);
    paramString2 = "";
    paramString1 = paramString2;
    for (;;)
    {
      try
      {
        arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString3, 64).signatures;
        paramString1 = paramString2;
        if (arrayOfSignature != null)
        {
          paramString4 = paramString2;
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString2)
      {
        Signature[] arrayOfSignature;
        MessageDigest localMessageDigest;
        label302:
        continue;
        localAuthorizeRequest.apk_sign.set(paramString1);
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try
        {
          this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localAuthorizeRequest.toByteArray());
          this.jdField_a_of_type_MqqAppNewIntent.setObserver(localupb);
          paramAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
          return;
        }
        catch (Exception paramAppInterface)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(getClass().getSimpleName(), 2, paramAppInterface.getMessage());
          jdField_a_of_type_Boolean = false;
          return;
        }
      }
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        paramString4 = paramString2;
        paramString1 = paramString2;
        localMessageDigest.update(arrayOfSignature[0].toByteArray());
        paramString4 = paramString2;
        paramString1 = paramString2;
        paramString2 = HexUtil.a(localMessageDigest.digest());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        paramString2 = paramString4;
        paramString1 = paramString2;
        localNoSuchAlgorithmException1.printStackTrace();
        paramString1 = paramString2;
      }
    }
    try
    {
      paramString1 = paramString2.toLowerCase();
      paramString2 = paramString1;
      paramString4 = paramString2;
      paramString1 = paramString2;
      localMessageDigest.reset();
      paramString1 = paramString2;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString2;
      break label302;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      break label356;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "no sign");
      }
      jdField_a_of_type_Boolean = false;
      AppUtil.a(paramContext, paramString3, a(this.jdField_a_of_type_JavaLangString), paramInt);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public boolean a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp");
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new upa(this, Looper.getMainLooper(), paramContext, paramString3, paramInt, paramAppInterface, paramString1, paramString2);
    }
    if (paramString2.startsWith("?")) {}
    for (this.jdField_a_of_type_JavaLangString = paramString2.substring(1);; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      a(paramAppInterface, paramContext, paramString1, paramString2, paramString3, ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount()), paramInt);
      return true;
    }
  }
  
  public boolean a(String paramString1, Context paramContext, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (jdField_a_of_type_Boolean) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin");
    }
    if ((TextUtils.isEmpty(paramString2)) || (!AuthorizeConfig.a().d(paramString2))) {
      return false;
    }
    jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new uoy(this);
    }
    try
    {
      paramString2 = Long.valueOf(paramString3);
      long l1 = 1L;
      try
      {
        long l2 = Long.valueOf(paramString5).longValue();
        l1 = l2;
      }
      catch (Exception paramString3)
      {
        for (;;) {}
      }
      paramString3 = new WtloginHelper(paramAppInterface.getApplication().getApplicationContext());
      paramString5 = util.getPkgSigFromApkName(paramContext, paramString4);
      paramString3.GetA1WithA1(paramAppInterface.getAccount(), 16L, 16L, paramString4.getBytes(), 1L, paramString2.longValue(), l1, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      paramString3.SetListener(new uoz(this, paramString1, paramString3, paramInt, paramContext));
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 10000L);
      return true;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("appcenter", 2, "parse appid error = " + paramString3);
        }
        paramString2 = Long.valueOf(0L);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\gamecenter\AppLaucherHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */