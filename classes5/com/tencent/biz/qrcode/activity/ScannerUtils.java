package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.huangye.util.QQYPQRCodeUtil;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jcp;
import jcq;
import jcr;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.request.WtloginHelper;

public class ScannerUtils
{
  public static final int a = 600;
  public static final String a = "ScannerUtils";
  public static final int b = 600;
  protected static final String b = "needLandScape";
  public static int c = 1;
  protected static final String c = "lastCheckOrientation";
  public static final int d = 0;
  protected static final String d = "http://qm.qq.com/cgi-bin/check_orientation";
  public static final int e = 1;
  public static final String e = "qrcode";
  public static final int f = 2;
  public static final String f = "user";
  public static final String g = "group";
  public static final String h = "discussion";
  public static String i;
  public static final String j = "scanResult";
  public static final String k = "exttype";
  public static final String l = "extvalue";
  public static final String m = "^mecard.*";
  public static final String n = "^begin:vcard[\\s\\S]*end:vcard";
  public static final String o = "^bizcard.*;;$";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    i = "addDisSource";
  }
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap, Rect paramRect)
  {
    try
    {
      paramRect = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(paramRect);
      localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, 600, 600), null);
    }
    catch (OutOfMemoryError paramRect)
    {
      for (;;)
      {
        try
        {
          Canvas localCanvas;
          paramBitmap = new Paint();
          paramBitmap.setAntiAlias(true);
          Rect localRect = new Rect(247, 247, 353, 353);
          paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838505);
          localCanvas.drawBitmap(paramContext, null, localRect, paramBitmap);
          paramContext.recycle();
          return paramRect;
        }
        catch (OutOfMemoryError paramContext)
        {
          paramContext.printStackTrace();
        }
        paramRect = paramRect;
        System.gc();
        try
        {
          paramRect = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ScannerUtils", 2, paramContext.getMessage());
          }
          return null;
        }
      }
    }
    return null;
  }
  
  public static BitMatrix a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    paramSharedPreferences = paramSharedPreferences.getString("user" + paramString, null);
    if (paramSharedPreferences == null) {
      return null;
    }
    return QRUtils.a(paramSharedPreferences, paramInt);
  }
  
  public static String a(String paramString, SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getString("user" + paramString, null);
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (QRUtils.f(paramString))
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (QRUtils.h(paramString))
        {
          StatisticCollector.a(paramActivity.getApplicationContext()).b(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    paramString1 = "user" + paramString1;
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putString(paramString1, paramString2);
    paramSharedPreferences.commit();
  }
  
  public static void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, ScannerView paramScannerView, WtloginHelper paramWtloginHelper, View paramView)
  {
    String str1 = paramString.trim();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "resultString:" + str1);
    }
    if (paramAppActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerUtils", 2, "handleUrl,activity == null");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2.booleanValue())
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131165212, false);
        }
        paramAppActivity.setResult(-1, paramAppActivity.getIntent().putExtra("scanResult", paramString));
        paramAppActivity.finish();
        return;
      }
      String str2 = str1.toLowerCase();
      int i2 = -1;
      int i3 = 0;
      int i1 = i2;
      if (Pattern.compile("^mecard.*").matcher(str2).matches()) {
        if (str1.length() <= "MECARD:".length())
        {
          i1 = i2;
          if (!str1.contains(":")) {}
        }
        else
        {
          i1 = 0;
        }
      }
      i2 = i1;
      if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(str2).matches()) {
        if (str1.length() <= "BEGIN:VCARD\nEND:VCARD".length())
        {
          i2 = i1;
          if (!str1.contains(":")) {}
        }
        else
        {
          i2 = 1;
        }
      }
      i1 = i2;
      if (Pattern.compile("^bizcard.*;;$").matcher(str2).matches()) {
        if (str1.length() <= "BIZCARD:;;:".length())
        {
          i1 = i2;
          if (!str1.contains(":")) {}
        }
        else
        {
          i1 = 2;
        }
      }
      if (str2.startsWith("qqf2f://qf/"))
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131165212, false);
        }
        paramQQAppInterface.a().a(paramAppActivity, str1, paramScannerView);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.a().a(paramAppActivity, paramScannerView);
        return;
      }
      if (QQYPQRCodeUtil.a(paramString))
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131165212, false);
        }
        if (!QQYPQRCodeUtil.a(paramAppActivity, paramString, true)) {}
        paramAppActivity.finish();
        return;
      }
      i2 = i3;
      if (i1 != -1) {
        i2 = 1;
      }
      if (i2 != 0)
      {
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131165212, false);
        }
        if (i2 == 0) {
          break label956;
        }
        QRResultHandler.a(paramQQAppInterface, paramAppActivity, str1, i1);
        i1 = 0;
      }
      while ((i1 == 0) && (paramBoolean1.booleanValue()))
      {
        paramAppActivity.finish();
        return;
        if (!HttpUtil.a(paramAppActivity))
        {
          paramBoolean1 = DialogUtil.a(paramAppActivity, 230);
          paramBoolean1.setMessage(2131364390);
          paramBoolean2 = new jcq(paramScannerView);
          paramBoolean1.setPositiveButton(2131367263, paramBoolean2);
          paramBoolean1.setOnCancelListener(paramBoolean2);
          paramBoolean1.show();
          return;
        }
        if ((!paramQQAppInterface.k()) && (!paramQQAppInterface.h()) && (!paramQQAppInterface.l())) {
          AudioUtil.b(2131165212, false);
        }
        paramBoolean2 = paramWtloginHelper;
        if (paramWtloginHelper == null) {
          paramBoolean2 = new WtloginHelper(paramAppActivity.getApplicationContext(), true);
        }
        if ((paramBoolean2.IsWtLoginUrl(str2)) && (!QRUtils.a(str2)))
        {
          paramView.setVisibility(0);
          paramBoolean2 = new Intent(paramAppActivity, QRLoginActivity.class);
          paramBoolean2.putExtra("QR_CODE_STRING", str1);
          if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
            paramAppActivity.startActivityForResult(paramBoolean2, 2);
          }
          for (;;)
          {
            i1 = 0;
            break;
            paramAppActivity.startActivity(paramBoolean2);
          }
        }
        if (((!TextUtils.isEmpty(str2)) && (str2.startsWith("http://iot.qq.com/add"))) || (("ScanSmartDevice".equals(paramAppActivity.getIntent().getStringExtra("from"))) && (!TextUtils.isEmpty(str2)) && (!str2.startsWith("http://qqapp.eprintsw.com"))))
        {
          SmartDeviceReport.a().a(1);
          SmartDeviceReport.a().b = "";
          SmartDeviceReport.a().a = 0;
          SmartDeviceReport.a().a(BaseApplicationImpl.a().a(), "Usr_Entrance", 1);
          DeviceScanner.a(paramAppActivity, paramScannerView, str1);
          i1 = 0;
        }
        else if (QRUtils.d(str2))
        {
          QWalletHelper.b(paramQQAppInterface, paramAppActivity, str1);
          i1 = 0;
        }
        else if (QRUtils.e(str2))
        {
          QWalletHelper.a(paramQQAppInterface, paramAppActivity, str1);
          i1 = 0;
        }
        else if (QRUtils.g(str2))
        {
          if (QRUtils.b(str2))
          {
            paramBoolean2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
            paramBoolean2.putExtra("innerSig", str1);
            paramBoolean2.putExtra(i, c);
            if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
              paramAppActivity.startActivityForResult(paramBoolean2, 2);
            }
            for (;;)
            {
              i1 = 0;
              break;
              paramAppActivity.startActivity(paramBoolean2);
            }
          }
          a(paramBoolean1.booleanValue(), str1, paramAppActivity, paramQQAppInterface, paramBoolean, paramScannerView, paramView);
          i1 = 1;
        }
        else
        {
          QRResultHandler.a(paramQQAppInterface, paramAppActivity, str1);
          label956:
          i1 = 0;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean1, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean2, ScannerView paramScannerView, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerView = new jcr(paramAppActivity, paramString, paramQQAppInterface, paramBoolean1, paramScannerView, paramView, paramBoolean2);
    paramAppActivity = new NewIntent(paramAppActivity, QRCodeServlet.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramAppActivity.setObserver(paramScannerView);
    paramQQAppInterface.startServlet(paramAppActivity);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public static boolean a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ScannerUtils", 2, "Product:" + Build.PRODUCT);
    }
    if (paramSharedPreferences.contains("needLandScape")) {}
    for (bool = paramSharedPreferences.getBoolean("needLandScape", false);; bool = true) {
      do
      {
        long l1 = paramSharedPreferences.getLong("lastCheckOrientation", 0L);
        if (System.currentTimeMillis() - l1 > 86400000L) {
          new jcp(paramSharedPreferences, paramContext).start();
        }
        return bool;
      } while ((!Build.PRODUCT.equals("brcm_bcm21553")) && (!Build.PRODUCT.equals("SCH-I619")) && (!Build.PRODUCT.equals("GT-S5360")) && (!Build.PRODUCT.equals("GT-S5830i")) && ((!Build.PRODUCT.equals("meizu_m9")) || (Build.VERSION.SDK_INT >= 9)) && (!Build.PRODUCT.equals("GT-S6352")) && (!Build.PRODUCT.equals("GT-S5831i")));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\ScannerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */