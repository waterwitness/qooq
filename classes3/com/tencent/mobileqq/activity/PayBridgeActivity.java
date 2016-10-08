package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager.PCPayData;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashSet;
import lyv;
import org.json.JSONException;
import org.json.JSONObject;

public class PayBridgeActivity
  extends BaseActivity
{
  public static final int A = 4;
  public static final int B = 5;
  public static final int C = 6;
  public static final int D = 7;
  public static final int E = 8;
  public static final int a = 1;
  public static final String a = "Q.qwallet.payPayBridgeActivity";
  public static final int b = 2;
  public static final String b = "release";
  public static final int c = 3;
  public static final String c = "pay_requestcode";
  private static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 4;
  public static final String d = "payparmas_paytype";
  public static final int e = 5;
  public static final String e = "payparmas_h5_url";
  public static final int f = 6;
  public static final String f = "payparmas_h5_start";
  public static final int g = 7;
  public static final String g = "payparmas_url_appinfo";
  public static final int h = 8;
  public static final String h = "payparmas_callback_sn";
  public static final int i = 9;
  public static final String i = "payparmas_json";
  public static final int j = 10;
  public static final String j = "payparmas_from_pcpush";
  public static final int k = -5;
  public static final String k = "payparmas_from_is_login_state";
  public static final int l = 11;
  public static final String l = "vacreport_key_seq";
  public static final int m = 12;
  public static final String m = "2711679534";
  public static final int n = 13;
  public static final int o = 14;
  public static final int p = -1;
  public static final int q = 0;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 1;
  public static final int u = 2;
  public static final int v = 3;
  public static final int w = 4;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  protected int F;
  private int G;
  private int H;
  protected long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private DataFactory.EmojiPayReqData jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData;
  public boolean a;
  public long b;
  public boolean b;
  private long jdField_c_of_type_Long;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  
  public PayBridgeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = -1;
    this.F = -1;
    this.H = -1;
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131558973);
    localDialog.setContentView(2130903236);
    TextView localTextView = (TextView)localDialog.findViewById(2131297840);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131296852);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297843);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131297844);
    if (paramString1 != null) {
      paramString1.setText(2131366521);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    String str1 = "";
    Object localObject1 = null;
    int i3 = -1;
    long l1 = 0L;
    Object localObject2 = "";
    long l2 = 0L;
    Object localObject3 = null;
    if ((paramActivity != null) && ((paramActivity instanceof BasePluginActivity)))
    {
      paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      if ((paramActivity != null) && ((paramActivity instanceof BasePluginActivity))) {
        paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      }
    }
    for (;;)
    {
      int i2 = 1;
      if ((paramAppInterface == null) || (paramActivity == null)) {
        i2 = 0;
      }
      int i1;
      if (paramBundle != null)
      {
        str1 = paramBundle.getString("payparmas_callback_sn");
        String str2 = paramBundle.getString("payparmas_json");
        int i4 = paramBundle.getInt("payparmas_paytype", -1);
        long l3 = paramBundle.getLong("payparmas_h5_start", 0L);
        String str3 = paramBundle.getString("payparmas_url_appinfo");
        long l4 = paramBundle.getLong("vacreport_key_seq", 0L);
        String str4 = paramBundle.getString("payparmas_h5_url");
        if ((i4 == -1) || (TextUtils.isEmpty(str2))) {
          i2 = 0;
        }
        i1 = i2;
        paramBundle = str1;
        localObject1 = str2;
        i3 = i4;
        l1 = l3;
        localObject2 = str3;
        l2 = l4;
        localObject3 = str4;
        if (paramInt != 6)
        {
          i1 = i2;
          paramBundle = str1;
          localObject1 = str2;
          i3 = i4;
          l1 = l3;
          localObject2 = str3;
          l2 = l4;
          localObject3 = str4;
          if (paramInt != 7)
          {
            i1 = i2;
            paramBundle = str1;
            localObject1 = str2;
            i3 = i4;
            l1 = l3;
            localObject2 = str3;
            l2 = l4;
            localObject3 = str4;
            if (paramInt != 8)
            {
              i1 = i2;
              paramBundle = str1;
              localObject1 = str2;
              i3 = i4;
              l1 = l3;
              localObject2 = str3;
              l2 = l4;
              localObject3 = str4;
              if (paramInt != 4)
              {
                i1 = i2;
                paramBundle = str1;
                localObject1 = str2;
                i3 = i4;
                l1 = l3;
                localObject2 = str3;
                l2 = l4;
                localObject3 = str4;
                if (paramInt != 9)
                {
                  i1 = i2;
                  paramBundle = str1;
                  localObject1 = str2;
                  i3 = i4;
                  l1 = l3;
                  localObject2 = str3;
                  l2 = l4;
                  localObject3 = str4;
                  if (paramInt != 14)
                  {
                    i1 = i2;
                    paramBundle = str1;
                    localObject1 = str2;
                    i3 = i4;
                    l1 = l3;
                    localObject2 = str3;
                    l2 = l4;
                    localObject3 = str4;
                    if (paramInt != 17)
                    {
                      i1 = 0;
                      localObject3 = str4;
                      l2 = l4;
                      localObject2 = str3;
                      l1 = l3;
                      i3 = i4;
                      localObject1 = str2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (paramBundle = str1;; paramBundle = str1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity invokerId:" + paramInt + " request=" + (String)localObject1 + ",callbackSn=" + paramBundle);
        }
        if (i1 != 0) {
          break;
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'System error.'}");
        return localBundle;
        i1 = 0;
      }
      if (paramInt == 6) {
        paramAppInterface = c(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
      }
      for (;;)
      {
        return paramAppInterface;
        if (paramInt == 7) {
          paramAppInterface = b(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
        } else if (paramInt == 8) {
          paramAppInterface = d(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
        } else if (paramInt == 4) {
          paramAppInterface = a(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
        } else if (paramInt == 9) {
          paramAppInterface = a(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, (String)localObject2, i3, l1, l2, (String)localObject3);
        } else if (paramInt == 14) {
          paramAppInterface = e(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
        } else if (paramInt == 17) {
          paramAppInterface = f(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, (String)localObject1, i3, l1);
        } else {
          paramAppInterface = localBundle;
        }
      }
    }
  }
  
  protected static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Bundle localBundle1 = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str12 = ((JSONObject)localObject).getString("offerId");
        String str13 = ((JSONObject)localObject).getString("userId");
        String str14 = ((JSONObject)localObject).getString("serviceCode");
        String str15 = ((JSONObject)localObject).getString("serviceName");
        if (!((JSONObject)localObject).has("channel")) {
          break label955;
        }
        paramString2 = ((JSONObject)localObject).getString("channel");
        if (!((JSONObject)localObject).has("unit")) {
          break label961;
        }
        str1 = ((JSONObject)localObject).getString("unit");
        if (!((JSONObject)localObject).has("openMonth")) {
          break label967;
        }
        str2 = ((JSONObject)localObject).getString("openMonth");
        if (!((JSONObject)localObject).has("isCanChange")) {
          break label973;
        }
        bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
        if (!((JSONObject)localObject).has("remark")) {
          break label979;
        }
        str3 = ((JSONObject)localObject).getString("remark");
        if (!((JSONObject)localObject).has("provideUin")) {
          break label986;
        }
        str4 = ((JSONObject)localObject).getString("provideUin");
        if (!((JSONObject)localObject).has("provideType")) {
          break label992;
        }
        str5 = ((JSONObject)localObject).getString("provideType");
        if (!((JSONObject)localObject).has("discountId")) {
          break label998;
        }
        str6 = ((JSONObject)localObject).getString("discountId");
        if (!((JSONObject)localObject).has("other")) {
          break label1005;
        }
        str7 = ((JSONObject)localObject).getString("other");
        if (!((JSONObject)localObject).has("autoPay")) {
          break label1012;
        }
        bool2 = ((JSONObject)localObject).getBoolean("autoPay");
        if (!((JSONObject)localObject).has("aid")) {
          break label1018;
        }
        str8 = ((JSONObject)localObject).getString("aid");
        if (!((JSONObject)localObject).has("couponId")) {
          break label1025;
        }
        str9 = ((JSONObject)localObject).getString("couponId");
        if ((((JSONObject)localObject).has("ticketName")) && (((JSONObject)localObject).has("ticketValue")))
        {
          str10 = ((JSONObject)localObject).getString("ticketName");
          str11 = ((JSONObject)localObject).getString("ticketValue");
          if (((JSONObject)localObject).has("pf"))
          {
            localObject = ((JSONObject)localObject).getString("pf");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("offerId", str12);
            localBundle2.putString("setEnv", "release");
            localBundle2.putBoolean("setLogEnable", false);
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle2.putString("unit", str1);
            }
            if ((paramString2 != null) && (paramString2.length() > 0)) {
              localBundle2.putString("payChannel", paramString2);
            }
            localBundle2.putString("callbackSn", paramString1);
            localBundle2.putString("userId", str13);
            if (str11 != null)
            {
              localBundle2.putString("sessionType", str10);
              localBundle2.putString("userKey", str11);
            }
            localBundle2.putString("sessionId", "uin");
            localBundle2.putString("pf", (String)localObject);
            localBundle2.putString("pfKey", "pfKey");
            localBundle2.putString("serviceCode", str14);
            localBundle2.putString("serviceName", str15);
            localBundle2.putInt("resId", 0);
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle2.putString("saveValue", str2);
              localBundle2.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            localBundle2.putString("remark", str3);
            localBundle2.putString("provideUin", str4);
            localBundle2.putString("provideType", str5);
            localBundle2.putString("discountId", str6);
            localBundle2.putString("other", str7);
            localBundle2.putBoolean("autoPay", Boolean.valueOf(bool2).booleanValue());
            localBundle2.putString("couponId", str9);
            localBundle2.putInt("PayInvokerId", 4);
            localBundle2.putInt("payparmas_paytype", paramInt);
            localBundle2.putLong("payparmas_h5_start", paramLong);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
            localBundle1.putInt("retCode", 0);
            localBundle1.putString("offerId", str12);
            localBundle1.putString("aid", str8);
            return localBundle1;
          }
          localObject = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str8;
          continue;
        }
        String str11 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'openService JSONException'}");
        return localBundle1;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'openService Exception'}");
        return localBundle1;
      }
      String str10 = null;
      continue;
      label955:
      paramString2 = null;
      continue;
      label961:
      String str1 = null;
      continue;
      label967:
      String str2 = null;
      continue;
      label973:
      boolean bool1 = true;
      continue;
      label979:
      String str3 = "";
      continue;
      label986:
      String str4 = null;
      continue;
      label992:
      String str5 = null;
      continue;
      label998:
      String str6 = "";
      continue;
      label1005:
      String str7 = "";
      continue;
      label1012:
      boolean bool2 = true;
      continue;
      label1018:
      String str8 = "";
      continue;
      label1025:
      String str9 = "";
    }
  }
  
  /* Error */
  protected static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4)
  {
    // Byte code:
    //   0: new 140	android/os/Bundle
    //   3: dup
    //   4: invokespecial 141	android/os/Bundle:<init>	()V
    //   7: astore 19
    //   9: aload 5
    //   11: astore 12
    //   13: aload 5
    //   15: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +13 -> 31
    //   21: aload 5
    //   23: ldc_w 400
    //   26: invokestatic 406	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 12
    //   31: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +53 -> 87
    //   37: ldc 20
    //   39: iconst_2
    //   40: new 175	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   47: ldc -113
    //   49: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokestatic 412	java/lang/System:currentTimeMillis	()J
    //   55: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: ldc_w 417
    //   61: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc -67
    //   71: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: invokestatic 420	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 232	org/json/JSONObject
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 235	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   96: astore 21
    //   98: aload_0
    //   99: invokevirtual 424	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   102: astore 22
    //   104: aload_0
    //   105: invokevirtual 428	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   108: new 175	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   115: getstatic 434	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   118: invokevirtual 435	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   121: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 22
    //   126: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 440	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 23
    //   137: aload 21
    //   139: ldc_w 442
    //   142: invokevirtual 238	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 20
    //   147: aload 21
    //   149: ldc_w 444
    //   152: invokevirtual 250	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   155: ifeq +525 -> 680
    //   158: aload 21
    //   160: ldc_w 444
    //   163: invokevirtual 447	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 26
    //   168: aload 21
    //   170: ldc_w 449
    //   173: invokevirtual 250	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   176: ifeq +510 -> 686
    //   179: aload 21
    //   181: ldc_w 449
    //   184: invokevirtual 238	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 4
    //   189: aload 21
    //   191: ldc_w 451
    //   194: invokevirtual 250	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   197: ifeq +993 -> 1190
    //   200: aload 21
    //   202: ldc_w 451
    //   205: invokevirtual 238	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 5
    //   210: aload 21
    //   212: ldc_w 453
    //   215: invokevirtual 250	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   218: ifeq +979 -> 1197
    //   221: aload 21
    //   223: ldc_w 453
    //   226: invokevirtual 238	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 13
    //   231: aload 4
    //   233: aload 12
    //   235: invokestatic 455	com/tencent/mobileqq/activity/PayBridgeActivity:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   238: astore 24
    //   240: aload 21
    //   242: ldc_w 457
    //   245: invokevirtual 250	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq +956 -> 1204
    //   251: aload 21
    //   253: ldc_w 457
    //   256: invokevirtual 238	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 12
    //   261: new 175	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   268: astore 14
    //   270: aload 14
    //   272: ldc_w 459
    //   275: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 20
    //   280: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 14
    //   286: ldc_w 461
    //   289: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 26
    //   294: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 14
    //   300: ldc_w 463
    //   303: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 4
    //   308: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 14
    //   314: ldc_w 465
    //   317: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 5
    //   322: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 14
    //   328: ldc_w 467
    //   331: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 13
    //   336: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 14
    //   342: ldc_w 469
    //   345: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 21
    //   350: ldc_w 471
    //   353: invokevirtual 474	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   356: invokevirtual 477	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 11
    //   362: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifne +17 -> 382
    //   368: aload 14
    //   370: ldc_w 479
    //   373: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload 11
    //   378: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: new 232	org/json/JSONObject
    //   385: dup
    //   386: aload 12
    //   388: invokespecial 235	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   391: astore 4
    //   393: aload 4
    //   395: ldc_w 481
    //   398: invokevirtual 485	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   401: pop
    //   402: aload 11
    //   404: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifne +14 -> 421
    //   410: aload 4
    //   412: ldc_w 481
    //   415: aload 11
    //   417: invokevirtual 489	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   420: pop
    //   421: aload 4
    //   423: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   426: astore 18
    //   428: lload 9
    //   430: aload 20
    //   432: ldc_w 492
    //   435: aload 14
    //   437: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: iconst_0
    //   441: aconst_null
    //   442: invokestatic 497	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   445: ldc_w 499
    //   448: astore 4
    //   450: ldc_w 499
    //   453: astore 5
    //   455: ldc_w 499
    //   458: astore 11
    //   460: aload 11
    //   462: astore 14
    //   464: aload 5
    //   466: astore 13
    //   468: aload 4
    //   470: astore 12
    //   472: aload 11
    //   474: astore 17
    //   476: aload 5
    //   478: astore 16
    //   480: aload 4
    //   482: astore 15
    //   484: aload 24
    //   486: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   489: ifne +764 -> 1253
    //   492: aload 11
    //   494: astore 14
    //   496: aload 5
    //   498: astore 13
    //   500: aload 4
    //   502: astore 12
    //   504: aload 24
    //   506: ldc_w 501
    //   509: invokevirtual 505	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   512: astore 25
    //   514: iconst_0
    //   515: istore 27
    //   517: aload 11
    //   519: astore 14
    //   521: aload 5
    //   523: astore 13
    //   525: aload 4
    //   527: astore 12
    //   529: aload 11
    //   531: astore 17
    //   533: aload 5
    //   535: astore 16
    //   537: aload 4
    //   539: astore 15
    //   541: iload 27
    //   543: aload 25
    //   545: arraylength
    //   546: if_icmpge +707 -> 1253
    //   549: aload 11
    //   551: astore 14
    //   553: aload 5
    //   555: astore 13
    //   557: aload 4
    //   559: astore 12
    //   561: aload 25
    //   563: iload 27
    //   565: aaload
    //   566: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   569: ifne +606 -> 1175
    //   572: aload 11
    //   574: astore 14
    //   576: aload 5
    //   578: astore 13
    //   580: aload 4
    //   582: astore 12
    //   584: aload 25
    //   586: iload 27
    //   588: aaload
    //   589: bipush 35
    //   591: invokevirtual 509	java/lang/String:indexOf	(I)I
    //   594: istore 28
    //   596: iload 28
    //   598: iconst_m1
    //   599: if_icmpeq +576 -> 1175
    //   602: aload 11
    //   604: astore 14
    //   606: aload 5
    //   608: astore 13
    //   610: aload 4
    //   612: astore 12
    //   614: aload 25
    //   616: iload 27
    //   618: aaload
    //   619: iload 28
    //   621: iconst_1
    //   622: iadd
    //   623: invokevirtual 513	java/lang/String:substring	(I)Ljava/lang/String;
    //   626: astore 15
    //   628: aload 15
    //   630: astore 12
    //   632: iload 27
    //   634: ifne +577 -> 1211
    //   637: aload 5
    //   639: astore 4
    //   641: aload 12
    //   643: astore 5
    //   645: iload 27
    //   647: iconst_1
    //   648: iadd
    //   649: istore 27
    //   651: aload 5
    //   653: astore 12
    //   655: aload 4
    //   657: astore 5
    //   659: aload 12
    //   661: astore 4
    //   663: goto -146 -> 517
    //   666: astore 12
    //   668: aload 12
    //   670: invokevirtual 514	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   673: aload 5
    //   675: astore 12
    //   677: goto -646 -> 31
    //   680: iconst_1
    //   681: istore 26
    //   683: goto -515 -> 168
    //   686: ldc -113
    //   688: astore 4
    //   690: goto -501 -> 189
    //   693: astore 4
    //   695: new 232	org/json/JSONObject
    //   698: dup
    //   699: invokespecial 515	org/json/JSONObject:<init>	()V
    //   702: astore 4
    //   704: aload 11
    //   706: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne +14 -> 723
    //   712: aload 4
    //   714: ldc_w 481
    //   717: aload 11
    //   719: invokevirtual 489	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   722: pop
    //   723: aload 4
    //   725: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   728: astore 18
    //   730: goto -302 -> 428
    //   733: new 140	android/os/Bundle
    //   736: dup
    //   737: invokespecial 141	android/os/Bundle:<init>	()V
    //   740: astore 12
    //   742: aload 12
    //   744: ldc_w 299
    //   747: aload_3
    //   748: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 12
    //   753: ldc_w 442
    //   756: aload 20
    //   758: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   761: aload 12
    //   763: ldc -16
    //   765: aload 22
    //   767: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload 12
    //   772: ldc_w 517
    //   775: aload 23
    //   777: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload 12
    //   782: ldc_w 444
    //   785: iload 26
    //   787: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   790: aload 12
    //   792: ldc_w 449
    //   795: aload 24
    //   797: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: aload 12
    //   802: ldc_w 457
    //   805: aload 18
    //   807: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: aload 12
    //   812: ldc_w 471
    //   815: aload 21
    //   817: ldc_w 471
    //   820: invokevirtual 474	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   823: invokevirtual 289	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   826: aload 12
    //   828: ldc_w 324
    //   831: bipush 9
    //   833: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   836: aload 12
    //   838: ldc 33
    //   840: iload 6
    //   842: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   845: aload 12
    //   847: ldc 39
    //   849: lload 7
    //   851: invokevirtual 328	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   854: aload 12
    //   856: ldc 61
    //   858: lload 9
    //   860: invokevirtual 328	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   863: aload_2
    //   864: ifnull +44 -> 908
    //   867: invokestatic 334	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   870: astore_3
    //   871: aload_2
    //   872: aload_3
    //   873: iconst_0
    //   874: invokevirtual 340	android/os/ResultReceiver:writeToParcel	(Landroid/os/Parcel;I)V
    //   877: aload_3
    //   878: iconst_0
    //   879: invokevirtual 343	android/os/Parcel:setDataPosition	(I)V
    //   882: getstatic 347	android/os/ResultReceiver:CREATOR	Landroid/os/Parcelable$Creator;
    //   885: aload_3
    //   886: invokeinterface 353 2 0
    //   891: checkcast 336	android/os/ResultReceiver
    //   894: astore_2
    //   895: aload_3
    //   896: invokevirtual 356	android/os/Parcel:recycle	()V
    //   899: aload 12
    //   901: ldc_w 358
    //   904: aload_2
    //   905: invokevirtual 362	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   908: lload 9
    //   910: aconst_null
    //   911: ldc_w 519
    //   914: aconst_null
    //   915: iconst_0
    //   916: aconst_null
    //   917: invokestatic 497	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   920: invokestatic 385	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   923: ifeq +32 -> 955
    //   926: ldc_w 521
    //   929: iconst_4
    //   930: new 175	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   937: ldc_w 523
    //   940: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokestatic 412	java/lang/System:currentTimeMillis	()J
    //   946: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   949: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokestatic 525	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aload_1
    //   956: aload_0
    //   957: aload 12
    //   959: invokestatic 367	cooperation/qwallet/plugin/QWalletPayBridge:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Landroid/os/Bundle;)Z
    //   962: pop
    //   963: aload 19
    //   965: ldc -58
    //   967: iconst_0
    //   968: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   971: aload 19
    //   973: ldc_w 527
    //   976: aload 20
    //   978: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload 19
    //   983: ldc_w 529
    //   986: aload 11
    //   988: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: aload 19
    //   993: ldc -10
    //   995: aload 5
    //   997: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: aload 19
    //   1002: ldc_w 531
    //   1005: aload 4
    //   1007: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1010: aload 19
    //   1012: areturn
    //   1013: astore 5
    //   1015: aload 14
    //   1017: astore 4
    //   1019: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq +8 -> 1030
    //   1025: aload 5
    //   1027: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   1030: aload 13
    //   1032: astore 5
    //   1034: aload 12
    //   1036: astore 11
    //   1038: goto -305 -> 733
    //   1041: astore_0
    //   1042: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1045: ifeq +32 -> 1077
    //   1048: ldc 20
    //   1050: iconst_2
    //   1051: new 175	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 533
    //   1061: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: invokevirtual 380	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1068: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1074: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1077: invokestatic 385	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1080: ifeq +7 -> 1087
    //   1083: aload_0
    //   1084: invokevirtual 388	org/json/JSONException:printStackTrace	()V
    //   1087: aload 19
    //   1089: ldc -58
    //   1091: iconst_m1
    //   1092: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1095: aload 19
    //   1097: ldc -52
    //   1099: ldc_w 535
    //   1102: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1105: aload 19
    //   1107: areturn
    //   1108: astore_0
    //   1109: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq +32 -> 1144
    //   1115: ldc 20
    //   1117: iconst_2
    //   1118: new 175	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1125: ldc_w 537
    //   1128: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload_0
    //   1132: invokevirtual 393	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1135: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: invokestatic 385	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1147: ifeq +7 -> 1154
    //   1150: aload_0
    //   1151: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   1154: aload 19
    //   1156: ldc -58
    //   1158: iconst_m1
    //   1159: invokevirtual 202	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1162: aload 19
    //   1164: ldc -52
    //   1166: ldc_w 539
    //   1169: invokevirtual 210	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1172: aload 19
    //   1174: areturn
    //   1175: aload 4
    //   1177: astore 12
    //   1179: aload 5
    //   1181: astore 4
    //   1183: aload 12
    //   1185: astore 5
    //   1187: goto -542 -> 645
    //   1190: ldc -113
    //   1192: astore 5
    //   1194: goto -984 -> 210
    //   1197: ldc -113
    //   1199: astore 13
    //   1201: goto -970 -> 231
    //   1204: ldc -113
    //   1206: astore 12
    //   1208: goto -947 -> 261
    //   1211: iload 27
    //   1213: iconst_1
    //   1214: if_icmpne +22 -> 1236
    //   1217: aload 12
    //   1219: astore 11
    //   1221: aload 4
    //   1223: astore 12
    //   1225: aload 5
    //   1227: astore 4
    //   1229: aload 12
    //   1231: astore 5
    //   1233: goto -588 -> 645
    //   1236: iload 27
    //   1238: iconst_2
    //   1239: if_icmpne -64 -> 1175
    //   1242: aload 4
    //   1244: astore 5
    //   1246: aload 12
    //   1248: astore 4
    //   1250: goto -605 -> 645
    //   1253: aload 17
    //   1255: astore 4
    //   1257: aload 16
    //   1259: astore 5
    //   1261: aload 15
    //   1263: astore 11
    //   1265: goto -532 -> 733
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1268	0	paramAppInterface	AppInterface
    //   0	1268	1	paramActivity	Activity
    //   0	1268	2	paramResultReceiver	ResultReceiver
    //   0	1268	3	paramString1	String
    //   0	1268	4	paramString2	String
    //   0	1268	5	paramString3	String
    //   0	1268	6	paramInt	int
    //   0	1268	7	paramLong1	long
    //   0	1268	9	paramLong2	long
    //   0	1268	11	paramString4	String
    //   11	649	12	localObject1	Object
    //   666	3	12	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   675	572	12	localObject2	Object
    //   229	971	13	str1	String
    //   268	748	14	localObject3	Object
    //   482	780	15	str2	String
    //   478	780	16	str3	String
    //   474	780	17	str4	String
    //   426	380	18	str5	String
    //   7	1166	19	localBundle	Bundle
    //   145	832	20	str6	String
    //   96	720	21	localJSONObject	JSONObject
    //   102	664	22	str7	String
    //   135	641	23	str8	String
    //   238	558	24	str9	String
    //   512	103	25	arrayOfString	String[]
    //   166	620	26	i1	int
    //   515	725	27	i2	int
    //   594	29	28	i3	int
    // Exception table:
    //   from	to	target	type
    //   21	31	666	java/io/UnsupportedEncodingException
    //   382	421	693	java/lang/Exception
    //   421	428	693	java/lang/Exception
    //   484	492	1013	java/lang/Exception
    //   504	514	1013	java/lang/Exception
    //   541	549	1013	java/lang/Exception
    //   561	572	1013	java/lang/Exception
    //   584	596	1013	java/lang/Exception
    //   614	628	1013	java/lang/Exception
    //   87	168	1041	org/json/JSONException
    //   168	189	1041	org/json/JSONException
    //   189	210	1041	org/json/JSONException
    //   210	231	1041	org/json/JSONException
    //   231	261	1041	org/json/JSONException
    //   261	382	1041	org/json/JSONException
    //   382	421	1041	org/json/JSONException
    //   421	428	1041	org/json/JSONException
    //   428	445	1041	org/json/JSONException
    //   484	492	1041	org/json/JSONException
    //   504	514	1041	org/json/JSONException
    //   541	549	1041	org/json/JSONException
    //   561	572	1041	org/json/JSONException
    //   584	596	1041	org/json/JSONException
    //   614	628	1041	org/json/JSONException
    //   695	723	1041	org/json/JSONException
    //   723	730	1041	org/json/JSONException
    //   733	863	1041	org/json/JSONException
    //   867	908	1041	org/json/JSONException
    //   908	955	1041	org/json/JSONException
    //   955	1010	1041	org/json/JSONException
    //   1019	1030	1041	org/json/JSONException
    //   87	168	1108	java/lang/Exception
    //   168	189	1108	java/lang/Exception
    //   189	210	1108	java/lang/Exception
    //   210	231	1108	java/lang/Exception
    //   231	261	1108	java/lang/Exception
    //   261	382	1108	java/lang/Exception
    //   428	445	1108	java/lang/Exception
    //   695	723	1108	java/lang/Exception
    //   723	730	1108	java/lang/Exception
    //   733	863	1108	java/lang/Exception
    //   867	908	1108	java/lang/Exception
    //   908	955	1108	java/lang/Exception
    //   955	1010	1108	java/lang/Exception
    //   1019	1030	1108	java/lang/Exception
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "native";
    case 1: 
      return "h5";
    case 2: 
      return "pcpush";
    case 3: 
      return "open-h5";
    case 4: 
      return "open-app";
    case 5: 
      return "native";
    case 6: 
      return "public";
    }
    return "app";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i1 = paramString.lastIndexOf('-');
    if (i1 != -1) {
      return paramString.substring(i1 + 1);
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    Object localObject1 = "";
    String str5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    String str3 = "";
    String str2 = "";
    int i2 = paramString1.lastIndexOf("|channel#");
    Object localObject3 = localObject4;
    String str1 = str5;
    String str4;
    int i1;
    if (i2 != -1)
    {
      str4 = paramString1.substring("|channel#".length() + i2);
      i1 = paramString1.indexOf("|bargainor_id#");
      localObject3 = localObject4;
      str1 = str5;
      localObject1 = str4;
      if (i1 != -1)
      {
        str5 = paramString1.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString1.indexOf("appid#");
        localObject3 = localObject4;
        str1 = str5;
        localObject1 = str4;
        if (i2 != -1)
        {
          localObject3 = paramString1.substring("appid#".length() + i2, i1);
          localObject1 = str4;
          str1 = str5;
        }
      }
    }
    i2 = paramString2.lastIndexOf("|channel#");
    localObject4 = str2;
    paramString1 = str3;
    if (i2 != -1)
    {
      str4 = paramString2.substring("|channel#".length() + i2);
      i1 = paramString2.indexOf("|bargainor_id#");
      localObject4 = str2;
      paramString1 = str3;
      localObject2 = str4;
      if (i1 != -1)
      {
        str3 = paramString2.substring("|bargainor_id#".length() + i1, i2);
        i2 = paramString2.indexOf("appid#");
        localObject4 = str2;
        paramString1 = str3;
        localObject2 = str4;
        if (i2 != -1)
        {
          localObject4 = paramString2.substring("appid#".length() + i2, i1);
          localObject2 = str4;
          paramString1 = str3;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramString2 = "appid#" + (String)localObject4;
      paramString2 = paramString2 + "|bargainor_id#";
      if (!TextUtils.isEmpty(str1)) {
        break label451;
      }
      paramString1 = paramString2 + paramString1;
      label375:
      paramString1 = paramString1 + "|channel#";
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label505;
      }
    }
    label451:
    label505:
    for (paramString1 = paramString1 + (String)localObject2;; paramString1 = paramString1 + (String)localObject1)
    {
      return paramString1;
      paramString2 = "appid#" + (String)localObject3;
      break;
      if (str1.compareTo("0") == 0)
      {
        paramString1 = paramString2 + paramString1;
        break label375;
      }
      paramString1 = paramString2 + str1;
      break label375;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString);
    localIntent.putExtras(localBundle);
    setResult(paramInt1, localIntent);
    a(paramInt1, localIntent);
    finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentIntent == null))
    {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.H = paramInt;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("callbackSn");
    String str2 = paramBundle.getString("json");
    String str3 = paramBundle.getString("payparmas_url_appinfo");
    paramBundle = null;
    if (paramInt == 4) {
      paramBundle = a(this.app, this, null, str1, str2, this.F, this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("retCode", -1) == 0) {
          break;
        }
        paramBundle = paramBundle.getString("retJson");
        if (paramBundle != null) {
          a(str1, paramBundle);
        }
        if (this.jdField_b_of_type_Long != 0L) {
          VACDReportUtil.a(this.jdField_b_of_type_Long, "parseurl", null, 668801, paramBundle);
        }
      }
      return;
      if (paramInt == 6)
      {
        paramBundle = c(this.app, this, null, str1, str2, this.F, this.jdField_a_of_type_Long);
      }
      else if (paramInt == 7)
      {
        paramBundle = b(this.app, this, null, str1, str2, this.F, this.jdField_a_of_type_Long);
      }
      else if (paramInt == 8)
      {
        paramBundle = d(this.app, this, null, str1, str2, this.F, this.jdField_a_of_type_Long);
      }
      else if (paramInt == 9)
      {
        if ((this.jdField_b_of_type_Long == 0L) && ((this.F == -1) || (this.F == 5)))
        {
          this.jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", "pay-native", "payinvoke", null, 0, null);
          this.jdField_b_of_type_Boolean = true;
        }
        paramBundle = a(this.app, this, null, str1, str2, str3, this.F, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
      }
      else if (paramInt == 14)
      {
        paramBundle = e(this.app, this, null, str1, str2, this.F, this.jdField_a_of_type_Long);
      }
    }
    if (paramInt == 9)
    {
      this.n = paramBundle.getString("token");
      this.o = paramBundle.getString("appid");
      this.p = paramBundle.getString("channel");
      this.q = paramBundle.getString("bargainor");
      return;
    }
    this.r = paramBundle.getString("offerId");
    this.s = paramBundle.getString("aid");
    this.t = paramBundle.getString("orderId");
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(paramInt1, paramString);
    a(paramInt1, paramString);
    finish();
  }
  
  private void a(Intent paramIntent)
  {
    setResult(-1, paramIntent);
    finish();
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("discountId");
    String str5 = paramBundle.getString("other");
    String str6 = paramBundle.getString("saveValue");
    boolean bool = paramBundle.getBoolean("isCanChange", true);
    this.r = str1;
    this.s = a(str3);
    paramBundle = new Bundle();
    paramBundle.putString("setEnv", "release");
    paramBundle.putBoolean("setLogEnable", false);
    paramBundle.putString("offerId", str1);
    paramBundle.putString("userId", str2);
    paramBundle.putString("sessionId", "uin");
    paramBundle.putString("zoneId", "1");
    paramBundle.putString("pf", str3);
    paramBundle.putString("pfKey", "pfKey");
    paramBundle.putString("acctType", "common");
    paramBundle.putInt("resId", 2130841622);
    paramBundle.putString("discountId", str4);
    paramBundle.putString("other", str5);
    paramBundle.putInt("PayInvokerId", 2);
    paramBundle.putInt("payparmas_paytype", this.F);
    if ((str6 != null) && (str6.trim().length() > 0))
    {
      paramBundle.putString("saveValue", str6);
      paramBundle.putBoolean("isCanChange", bool);
    }
    QWalletPayBridge.a(this, this.app, paramBundle);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      if (!paramString.contains(";")) {
        break;
      }
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length != 0))
      {
        int i2 = paramString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          StatisticCollector.a(paramAppInterface.a()).c(paramAppInterface, paramString[i1]);
          i1 += 1;
        }
      }
    }
    StatisticCollector.a(paramAppInterface.a()).c(paramAppInterface, paramString);
  }
  
  private void a(QWalletPushManager.PCPayData paramPCPayData)
  {
    if (paramPCPayData == null)
    {
      finish();
      return;
    }
    paramPCPayData.f = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramPCPayData.b);
    localBundle.putString("callbackSn", "0");
    switch (QWalletPushManager.a(paramPCPayData.e))
    {
    case 5: 
    case 10: 
    case 12: 
    case 13: 
    default: 
      finish();
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 14: 
      a(QWalletPushManager.a(paramPCPayData.e), localBundle);
      return;
    }
    e(localBundle);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData = paramEmojiPayReqData;
    this.r = paramEmojiPayReqData.b;
    this.s = a(paramEmojiPayReqData.h);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", paramEmojiPayReqData.b);
    localBundle.putBoolean("isShowNum", false);
    localBundle.putString("userId", paramEmojiPayReqData.c);
    localBundle.putString("userKey", paramEmojiPayReqData.d);
    localBundle.putString("sessionId", paramEmojiPayReqData.e);
    localBundle.putString("sessionType", paramEmojiPayReqData.f);
    localBundle.putString("zoneId", paramEmojiPayReqData.g);
    localBundle.putString("pf", paramEmojiPayReqData.h);
    localBundle.putString("pfKey", paramEmojiPayReqData.i);
    localBundle.putString("tokenUrl", paramEmojiPayReqData.j);
    localBundle.putInt("resId", 2130838490);
    localBundle.putString("discountId", paramEmojiPayReqData.k);
    localBundle.putString("other", paramEmojiPayReqData.l);
    localBundle.putInt("PayInvokerId", 1);
    localBundle.putInt("payparmas_paytype", this.F);
    QWalletPayBridge.a(this, this.app, localBundle);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramEmojiPayReqData == null)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new DataFactory.EmojiPayRespData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramEmojiPayReqData.a());
    localIntent.putExtras(paramString.a());
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", paramString2);
    localIntent.putExtra("callbackSn", paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpayResult:callbackSn=" + paramString1 + ",result=" + paramString2);
    }
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpay startActivity and request=" + paramBundle.toString() + ",requestCode=" + paramInt);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "startEmojimallPaycallbackid:" + paramString1 + "appid:" + paramString2 + "userId:" + paramString3 + "userKey:" + paramString4 + "zoneId:" + paramString5 + "pf:" + paramString6 + "pfKey:" + paramString7 + "tokenUrl:" + paramString8);
    }
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString8))) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(new DataFactory.EmojiPayReqData(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8).a());
    localIntent.putExtra("pay_requestcode", 1);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramActivity.startActivityForResult(localIntent, 1);
    return true;
  }
  
  private boolean a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    return (paramEmojiPayReqData != null) && (!TextUtils.isEmpty(paramEmojiPayReqData.b)) && (!TextUtils.isEmpty(paramEmojiPayReqData.a)) && (!TextUtils.isEmpty(paramEmojiPayReqData.c)) && (!TextUtils.isEmpty(paramEmojiPayReqData.d)) && (!TextUtils.isEmpty(paramEmojiPayReqData.j));
  }
  
  protected static Bundle b(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Bundle localBundle1 = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str4 = ((JSONObject)localObject).getString("offerId");
        String str6 = ((JSONObject)localObject).getString("userId");
        String str5 = ((JSONObject)localObject).getString("tokenUrl");
        if (((JSONObject)localObject).has("zoneId"))
        {
          paramString2 = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label653;
          }
          bool = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("unit")) {
            break label659;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("aid")) {
            break label665;
          }
          str1 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("discountId")) {
            break label672;
          }
          str3 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("offerId", str4);
            localBundle2.putString("setEnv", "release");
            localBundle2.putBoolean("setLogEnable", false);
            localBundle2.putBoolean("isShowNum", Boolean.valueOf(bool).booleanValue());
            if ((str2 != null) && (str2.length() > 0)) {
              localBundle2.putString("unit", str2);
            }
            localBundle2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str1;
            localBundle2.putString("userId", str6);
            localBundle2.putString("sessionId", "uin");
            localBundle2.putString("zoneId", paramString2);
            localBundle2.putString("pf", paramString1);
            localBundle2.putString("pfKey", "pfKey");
            localBundle2.putString("tokenUrl", str5);
            localBundle2.putInt("resId", 0);
            localBundle2.putString("discountId", str3);
            localBundle2.putString("other", (String)localObject);
            localBundle2.putInt("PayInvokerId", 7);
            localBundle2.putInt("payparmas_paytype", paramInt);
            localBundle2.putLong("payparmas_h5_start", paramLong);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
            localBundle1.putInt("retCode", 0);
            localBundle1.putString("offerId", str4);
            localBundle1.putString("aid", str1);
            localBundle1.putString("orderId", str5);
            return localBundle1;
          }
          localObject = "";
          continue;
        }
        paramString2 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "buyGoods JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
        paramAppInterface.printStackTrace();
        return localBundle1;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "buyGoods Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods Exception'}");
        return localBundle1;
      }
      continue;
      label653:
      boolean bool = true;
      continue;
      label659:
      String str2 = null;
      continue;
      label665:
      String str1 = "";
      continue;
      label672:
      String str3 = "";
    }
  }
  
  private String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(paramInt1, paramString);
    a(paramInt1, paramString);
    finish();
  }
  
  private void b(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("provideUin");
    String str5 = paramBundle.getString("provideType");
    String str6 = paramBundle.getString("discountId");
    paramBundle = paramBundle.getString("other");
    this.r = str1;
    this.s = a(str3);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", str1);
    localBundle.putString("userId", str2);
    localBundle.putString("sessionId", "uin");
    localBundle.putString("pf", str3);
    localBundle.putString("pfKey", "pfKey");
    localBundle.putString("serviceCode", "QQYFSC");
    localBundle.putString("serviceName", "腾讯文学包月VIP");
    localBundle.putInt("resId", 2130841622);
    localBundle.putString("saveValue", "3");
    localBundle.putBoolean("isCanChange", true);
    localBundle.putString("remark", "");
    localBundle.putString("provideUin", str4);
    localBundle.putString("provideType", str5);
    localBundle.putString("discountId", str6);
    localBundle.putString("other", paramBundle);
    localBundle.putInt("PayInvokerId", 3);
    localBundle.putInt("payparmas_paytype", this.F);
    QWalletPayBridge.a(this, this.app, localBundle);
  }
  
  protected static Bundle c(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Bundle localBundle1 = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str5 = ((JSONObject)localObject).getString("offerId");
        String str6 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("zoneId"))
        {
          paramString2 = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("acctType")) {
            break label690;
          }
          str1 = ((JSONObject)localObject).getString("acctType");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label698;
          }
          bool1 = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label704;
          }
          str2 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label710;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("aid")) {
            break label716;
          }
          str3 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("discountId")) {
            break label723;
          }
          str4 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("offerId", str5);
            localBundle2.putString("setEnv", "release");
            localBundle2.putBoolean("setLogEnable", true);
            localBundle2.putBoolean("isShowNum", Boolean.valueOf(bool1).booleanValue());
            localBundle2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str3;
            localBundle2.putString("userId", str6);
            localBundle2.putString("sessionId", "uin");
            localBundle2.putString("zoneId", paramString2);
            localBundle2.putString("pf", paramString1);
            localBundle2.putString("pfKey", "pfKey");
            localBundle2.putString("acctType", str1);
            localBundle2.putString("discountId", str4);
            localBundle2.putString("other", (String)localObject);
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle2.putString("saveValue", str2);
              localBundle2.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            localBundle2.putInt("resId", 0);
            localBundle2.putInt("PayInvokerId", 6);
            localBundle2.putInt("payparmas_paytype", paramInt);
            localBundle2.putLong("payparmas_h5_start", paramLong);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
            localBundle1.putInt("retCode", 0);
            localBundle1.putString("offerId", str5);
            localBundle1.putString("aid", str3);
            return localBundle1;
          }
          localObject = "";
          continue;
        }
        paramString2 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle1;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle1;
      }
      continue;
      label690:
      String str1 = "common";
      continue;
      label698:
      boolean bool1 = true;
      continue;
      label704:
      String str2 = null;
      continue;
      label710:
      boolean bool2 = true;
      continue;
      label716:
      String str3 = "";
      continue;
      label723:
      String str4 = "";
    }
  }
  
  private void c(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if ((i1 == 1) && (this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData != null))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, -1, -1, -1, -1, -1, "");
  }
  
  private void c(Bundle paramBundle)
  {
    int i1 = 1;
    String str1 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openTenpayView request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str1));
    }
    JSONObject localJSONObject;
    String str3;
    String str2;
    Object localObject;
    try
    {
      localJSONObject = new JSONObject(paramBundle.getString("json"));
      str3 = localJSONObject.getString("userId");
      paramBundle = new HashSet();
      paramBundle.add("bindNewCard");
      paramBundle.add("balance");
      paramBundle.add("pswManage");
      paramBundle.add("modifyPsw");
      paramBundle.add("checkPsw");
      paramBundle.add("withdraw");
      paramBundle.add("transferInfor");
      paramBundle.add("transfer");
      paramBundle.add("graphb");
      paramBundle.add("qpay_hb_share");
      paramBundle.add("sendHb");
      paramBundle.add("sendHbCallback");
      paramBundle.add("makeHongbao");
      paramBundle.add("parseqrcode");
      paramBundle.add("verifyqrcode");
      paramBundle.add("findPsw");
      paramBundle.add("pushMsg");
      paramBundle.add("transferPush");
      paramBundle.add("transferqrcode");
      paramBundle.add("transferInput");
      paramBundle.add("redgiftDetail");
      paramBundle.add("redgiftRecord");
      paramBundle.add("idCardVerify");
      paramBundle.add("payCode");
      paramBundle.add("showWearPayAuthor");
      paramBundle.add("rewardTransferInput");
      str2 = localJSONObject.getString("viewTag");
      if ((str2 == null) || (!paramBundle.contains(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(str2, 2, "openTenpayView viewTag is not allow");
        }
        a(str1, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
        return;
      }
      if (("transfer".compareTo(str2) != 0) && ("transferInput".compareTo(str2) != 0)) {
        break label554;
      }
      localObject = new Intent(this, TransactionActivity.class);
      ((Intent)localObject).putExtra("callbackSn", str1);
      ((Intent)localObject).putExtra("come_from", 1);
      ((Intent)localObject).putExtra("tag", str2);
      if (!localJSONObject.has("appInfo")) {
        break label548;
      }
      paramBundle = localJSONObject.getString("appInfo");
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openTenpayView JSONException:" + paramBundle.getMessage());
        }
        a(str1, "{'resultCode':-1,'retmsg':'openTenpayView params error'}");
        paramBundle.printStackTrace();
        return;
        paramBundle = "";
      }
      if ("makeHongbao".compareTo(str2) != 0) {
        break label749;
      }
      localObject = new Intent(this, SendHbActivity.class);
      ((Intent)localObject).putExtra("callbackSn", str1);
      ((Intent)localObject).putExtra("come_from", 2);
      ((Intent)localObject).putExtra("is_H5", true);
      if (!localJSONObject.has("appInfo")) {
        break label743;
      }
      paramBundle = localJSONObject.getString("appInfo");
      ((Intent)localObject).putExtra("app_info", paramBundle);
      if (!localJSONObject.has("extra_data")) {
        break label1309;
      }
      paramBundle = localJSONObject.getString("extra_data");
      ((Intent)localObject).putExtra("extra_data", paramBundle);
      ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
      startActivityForResult((Intent)localObject, 5);
      return;
    }
    catch (Exception paramBundle)
    {
      if (!QLog.isColorLevel()) {
        break label730;
      }
      QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openTenpayView Exception:" + paramBundle.getMessage());
      a(str1, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
      paramBundle.printStackTrace();
      return;
    }
    ((Intent)localObject).putExtra("app_info", paramBundle);
    if (localJSONObject.has("extra_data"))
    {
      paramBundle = localJSONObject.getString("extra_data");
      ((Intent)localObject).putExtra("extra_data", paramBundle);
      ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "is_H5=true", 0, null));
      startActivityForResult((Intent)localObject, 5);
      return;
      for (;;)
      {
        label548:
        label554:
        label653:
        label730:
        label743:
        paramBundle = "";
      }
      label749:
      if ("parseqrcode".compareTo(str2) == 0)
      {
        localObject = new Intent(this, TenpayJumpActivity.class);
        ((Intent)localObject).putExtra("callbackSn", str1);
        if (!localJSONObject.has("comeForm")) {
          break label1315;
        }
        i1 = localJSONObject.getInt("comeForm");
        label802:
        ((Intent)localObject).putExtra("come_from", i1);
        if (!localJSONObject.has("appInfo")) {
          break label1321;
        }
        paramBundle = localJSONObject.getString("appInfo");
        label832:
        ((Intent)localObject).putExtra("app_info", paramBundle);
        if (!localJSONObject.has("extra_data")) {
          break label1327;
        }
        paramBundle = localJSONObject.getString("extra_data");
        label861:
        ((Intent)localObject).putExtra("extra_data", paramBundle);
        startActivityForResult((Intent)localObject, 5);
        return;
      }
      String str4;
      if ("transferqrcode".compareTo(str2) == 0)
      {
        str4 = this.app.b();
        paramBundle = localJSONObject.optJSONObject("extra_data");
        localObject = paramBundle;
        if (paramBundle != null) {}
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("name", str4);
        localJSONObject.put("extra_data", localObject);
      }
      catch (Exception paramBundle)
      {
        label1058:
        for (;;) {}
      }
      if ("graphb".compareTo(str2) == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      localObject = new Bundle();
      if ((str2.equals("bindNewCard")) && (localJSONObject.has("bargainor_id"))) {
        ((Bundle)localObject).putString("bargainor_id", localJSONObject.getString("bargainor_id"));
      }
      if (localJSONObject.has("comeForm")) {
        i1 = localJSONObject.getInt("comeForm");
      }
      ((Bundle)localObject).putInt("come_from", i1);
      if (!localJSONObject.has("appInfo")) {
        break label1333;
      }
      paramBundle = localJSONObject.getString("appInfo");
      ((Bundle)localObject).putString("app_info", paramBundle);
      if (!localJSONObject.has("extra_data")) {
        break label1339;
      }
    }
    label1309:
    label1315:
    label1321:
    label1327:
    label1333:
    label1339:
    for (paramBundle = localJSONObject.getString("extra_data");; paramBundle = "")
    {
      ((Bundle)localObject).putString("extra_data", paramBundle);
      this.u = str2;
      paramBundle = new Bundle();
      paramBundle.putString("callbackSn", str1);
      paramBundle.putString("tag", str2);
      paramBundle.putString("uin", str3);
      paramBundle.putString("nick_name", this.app.b());
      paramBundle.putBundle("params", (Bundle)localObject);
      paramBundle.putInt("PayInvokerId", 5);
      paramBundle.putInt("payparmas_paytype", this.F);
      if (this.jdField_b_of_type_Long == 0L)
      {
        this.jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", "view." + str2, "loadPluginStart", null, 0, null);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        paramBundle.putLong("vacreport_key_seq", this.jdField_b_of_type_Long);
        if (QLog.isDevelopLevel()) {
          QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
        }
        QWalletPayBridge.a(this, this.app, paramBundle);
        return;
        VACDReportUtil.a(this.jdField_b_of_type_Long, null, "loadPluginStart", null, 0, null);
      }
      paramBundle = "";
      break;
      paramBundle = "";
      break label653;
      i1 = 5;
      break label802;
      paramBundle = "";
      break label832;
      paramBundle = "";
      break label861;
      paramBundle = "";
      break label1058;
    }
  }
  
  protected static Bundle d(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Bundle localBundle1 = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str7 = ((JSONObject)localObject).getString("offerId");
        String str8 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("channel"))
        {
          paramString2 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label675;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label681;
          }
          str2 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("aid")) {
            break label687;
          }
          str3 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("provideUin")) {
            break label694;
          }
          str4 = ((JSONObject)localObject).getString("provideUin");
          if (!((JSONObject)localObject).has("provideType")) {
            break label700;
          }
          str5 = ((JSONObject)localObject).getString("provideType");
          if (!((JSONObject)localObject).has("discountId")) {
            break label706;
          }
          str6 = ((JSONObject)localObject).getString("discountId");
          if (((JSONObject)localObject).has("other"))
          {
            localObject = ((JSONObject)localObject).getString("other");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("offerId", str7);
            localBundle2.putString("setEnv", "release");
            localBundle2.putBoolean("setLogEnable", true);
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle2.putString("unit", str1);
            }
            if ((paramString2 != null) && (paramString2.length() > 0)) {
              localBundle2.putString("payChannel", paramString2);
            }
            localBundle2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str3;
            localBundle2.putString("userId", str8);
            localBundle2.putString("sessionId", "uin");
            localBundle2.putString("pf", paramString1);
            localBundle2.putString("pfKey", "pfKey");
            localBundle2.putString("saveValue", str2);
            localBundle2.putString("provideUin", str4);
            localBundle2.putString("provideType", str5);
            localBundle2.putString("discountId", str6);
            localBundle2.putString("other", (String)localObject);
            localBundle2.putInt("PayInvokerId", 8);
            localBundle2.putInt("payparmas_paytype", paramInt);
            localBundle2.putLong("payparmas_h5_start", paramLong);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
            localBundle1.putInt("retCode", 0);
            localBundle1.putString("offerId", str7);
            localBundle1.putString("aid", str3);
            return localBundle1;
          }
          localObject = "";
          continue;
        }
        paramString2 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle1;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle1;
      }
      continue;
      label675:
      String str1 = null;
      continue;
      label681:
      String str2 = null;
      continue;
      label687:
      String str3 = "";
      continue;
      label694:
      String str4 = null;
      continue;
      label700:
      String str5 = null;
      continue;
      label706:
      String str6 = "";
    }
  }
  
  private void d(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(-1, -1, -1, -1, -1, "");
  }
  
  private void d(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("offerId");
      String str2 = paramBundle.getString("userId");
      String str3 = paramBundle.getString("skey");
      String str4 = paramBundle.getString("serviceCode");
      String str5 = paramBundle.getString("serviceName");
      String str6 = paramBundle.getString("channel");
      String str7 = paramBundle.getString("uint");
      String str8 = paramBundle.getString("openMonth");
      boolean bool1 = paramBundle.getBoolean("isCanChange");
      String str9 = paramBundle.getString("provideUin");
      String str10 = paramBundle.getString("provideType");
      String str11 = paramBundle.getString("discountId");
      String str12 = paramBundle.getString("other");
      boolean bool2 = paramBundle.getBoolean("autoPay", true);
      Object localObject = paramBundle.getString("aid");
      paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + (String)localObject;
      this.r = str1;
      this.s = ((String)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("setEnv", "release");
      ((Bundle)localObject).putBoolean("setLogEnable", true);
      ((Bundle)localObject).putString("offerId", str1);
      if ((str7 != null) && (str7.length() > 0)) {
        ((Bundle)localObject).putString("unit", str7);
      }
      if ((str6 != null) && (str6.length() > 0)) {
        ((Bundle)localObject).putString("payChannel", str6);
      }
      ((Bundle)localObject).putString("userId", str2);
      ((Bundle)localObject).putString("userKey", str3);
      ((Bundle)localObject).putString("sessionId", "uin");
      ((Bundle)localObject).putString("sessionType", "skey");
      ((Bundle)localObject).putString("pf", paramBundle);
      ((Bundle)localObject).putString("pfKey", "pfKey");
      ((Bundle)localObject).putString("serviceCode", str4);
      ((Bundle)localObject).putString("serviceName", str5);
      ((Bundle)localObject).putBoolean("autoPay", bool2);
      ((Bundle)localObject).putInt("resId", 0);
      if ((str8 != null) && (str8.length() > 0))
      {
        ((Bundle)localObject).putString("saveValue", str8);
        ((Bundle)localObject).putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
      }
      ((Bundle)localObject).putString("remark", "");
      ((Bundle)localObject).putString("provideUin", str9);
      ((Bundle)localObject).putString("provideType", str10);
      ((Bundle)localObject).putString("discountId", str11);
      ((Bundle)localObject).putString("other", str12);
      ((Bundle)localObject).putInt("PayInvokerId", 4);
      ((Bundle)localObject).putInt("payparmas_paytype", this.F);
      QWalletPayBridge.a(this, this.app, (Bundle)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramBundle.getMessage());
      }
      b(-5, "openService Exception", -1, -1);
      paramBundle.printStackTrace();
    }
  }
  
  protected static Bundle e(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Bundle localBundle1 = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str7 = ((JSONObject)localObject).getString("offerId");
        if (((JSONObject)localObject).has("isShowNum"))
        {
          bool1 = ((JSONObject)localObject).getBoolean("isShowNum");
          if (!((JSONObject)localObject).has("unit")) {
            break label826;
          }
          paramString2 = ((JSONObject)localObject).getString("unit");
          String str8 = ((JSONObject)localObject).getString("userId");
          String str9 = ((JSONObject)localObject).getString("serviceCode");
          String str10 = ((JSONObject)localObject).getString("serviceName");
          if (!((JSONObject)localObject).has("channel")) {
            break label832;
          }
          str1 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label838;
          }
          str2 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label844;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("remark")) {
            break label850;
          }
          str3 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("autoPay")) {
            break label857;
          }
          bool3 = ((JSONObject)localObject).getBoolean("autoPay");
          if (!((JSONObject)localObject).has("aid")) {
            break label863;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("productId")) {
            break label870;
          }
          str5 = ((JSONObject)localObject).getString("productId");
          if (!((JSONObject)localObject).has("couponId")) {
            break label877;
          }
          str6 = ((JSONObject)localObject).getString("couponId");
          if (((JSONObject)localObject).has("pf"))
          {
            localObject = ((JSONObject)localObject).getString("pf");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("setEnv", "release");
            localBundle2.putBoolean("setLogEnable", false);
            localBundle2.putString("offerId", str7);
            localBundle2.putBoolean("isShowNum", bool1);
            if ((paramString2 != null) && (paramString2.length() > 0)) {
              localBundle2.putString("unit", paramString2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle2.putString("payChannel", str1);
            }
            localBundle2.putString("callbackSn", paramString1);
            localBundle2.putString("userId", str8);
            localBundle2.putString("sessionId", "uin");
            localBundle2.putString("pf", (String)localObject);
            localBundle2.putString("pfKey", "pfKey");
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle2.putString("saveValue", str2);
              localBundle2.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            localBundle2.putInt("resId", 0);
            localBundle2.putString("serviceCode", str9);
            localBundle2.putString("serviceName", str10);
            localBundle2.putString("remark", str3);
            localBundle2.putBoolean("autoPay", Boolean.valueOf(bool3).booleanValue());
            localBundle2.putString("productId", str5);
            localBundle2.putString("couponId", str6);
            localBundle2.putInt("PayInvokerId", 14);
            localBundle2.putInt("payparmas_paytype", paramInt);
            localBundle2.putLong("payparmas_h5_start", paramLong);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
            localBundle1.putInt("retCode", 0);
            localBundle1.putString("offerId", str7);
            localBundle1.putString("aid", str4);
            return localBundle1;
          }
          localObject = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str4;
          continue;
        }
        boolean bool1 = true;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "subscribeMonthCardPay JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay JSONException'}");
        return localBundle1;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "subscribeMonthCardPay Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle1.putInt("retCode", -1);
        localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay Exception'}");
        return localBundle1;
      }
      continue;
      label826:
      paramString2 = null;
      continue;
      label832:
      String str1 = null;
      continue;
      label838:
      String str2 = null;
      continue;
      label844:
      boolean bool2 = false;
      continue;
      label850:
      String str3 = "";
      continue;
      label857:
      boolean bool3 = true;
      continue;
      label863:
      String str4 = "";
      continue;
      label870:
      String str5 = "";
      continue;
      label877:
      String str6 = "";
    }
  }
  
  private void e(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("realSaveNum", -1);
    int i4 = paramIntent.getIntExtra("payChannel", -1);
    int i5 = paramIntent.getIntExtra("payState", -1);
    int i6 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, i3, i4, i5, i6, paramIntent);
      return;
    }
    a(-1, -1, -1, -1, -1, "");
  }
  
  private void e(Bundle paramBundle)
  {
    String str16 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openSVip request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str16));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str20 = ((JSONObject)localObject).getString("offerId");
        String str17 = ((JSONObject)localObject).getString("userId");
        String str18 = ((JSONObject)localObject).getString("serviceCode");
        String str19 = ((JSONObject)localObject).getString("serviceName");
        if (((JSONObject)localObject).has("channel"))
        {
          paramBundle = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label1097;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("openMonth")) {
            break label1102;
          }
          str2 = ((JSONObject)localObject).getString("openMonth");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1107;
          }
          bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("isAutoPay")) {
            break label1113;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isAutoPay");
          if (!((JSONObject)localObject).has("remark")) {
            break label1119;
          }
          str3 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("aid")) {
            break label1126;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("actTitle")) {
            break label1133;
          }
          str5 = ((JSONObject)localObject).getString("actTitle");
          if (!((JSONObject)localObject).has("openType")) {
            break label1140;
          }
          i1 = ((JSONObject)localObject).getInt("openType");
          if (!((JSONObject)localObject).has("actHint")) {
            break label1146;
          }
          str6 = ((JSONObject)localObject).getString("actHint");
          if (!((JSONObject)localObject).has("actPayTotal")) {
            break label1152;
          }
          str7 = ((JSONObject)localObject).getString("actPayTotal");
          if (!((JSONObject)localObject).has("actPayDiscount")) {
            break label1158;
          }
          str8 = ((JSONObject)localObject).getString("actPayDiscount");
          if (!((JSONObject)localObject).has("actBtnTitle")) {
            break label1164;
          }
          str9 = ((JSONObject)localObject).getString("actBtnTitle");
          if (!((JSONObject)localObject).has("openServicePrice")) {
            break label1170;
          }
          str10 = ((JSONObject)localObject).getString("openServicePrice");
          if (!((JSONObject)localObject).has("upgradeServicePrice")) {
            break label1176;
          }
          str11 = ((JSONObject)localObject).getString("upgradeServicePrice");
          if (!((JSONObject)localObject).has("maxUpgradeMonth")) {
            break label1182;
          }
          i2 = ((JSONObject)localObject).getInt("maxUpgradeMonth");
          if (!((JSONObject)localObject).has("openTitle")) {
            break label1188;
          }
          str12 = ((JSONObject)localObject).getString("openTitle");
          if (!((JSONObject)localObject).has("upgradeTitle")) {
            break label1195;
          }
          str13 = ((JSONObject)localObject).getString("upgradeTitle");
          if (!((JSONObject)localObject).has("discountId")) {
            break label1202;
          }
          str14 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label1209;
          }
          str15 = ((JSONObject)localObject).getString("other");
          if (((JSONObject)localObject).has("couponId"))
          {
            localObject = ((JSONObject)localObject).getString("couponId");
            this.r = str20;
            this.s = str4;
            Bundle localBundle = new Bundle();
            localBundle.putString("offerId", str20);
            localBundle.putString("setEnv", "release");
            localBundle.putBoolean("setLogEnable", false);
            if ((str1 != null) && (str1.length() > 0)) {
              localBundle.putString("unit", str1);
            }
            if ((paramBundle != null) && (paramBundle.length() > 0)) {
              localBundle.putString("payChannel", paramBundle);
            }
            localBundle.putString("callbackSn", str16);
            paramBundle = "qq_m_qq-2013-android-" + AppSetting.a + "-" + str4;
            localBundle.putString("userId", str17);
            localBundle.putString("sessionId", "uin");
            localBundle.putString("pf", paramBundle);
            localBundle.putString("pfKey", "pfKey");
            localBundle.putString("serviceCode", str18);
            localBundle.putString("serviceName", str19);
            localBundle.putInt("resId", 0);
            if ((str2 != null) && (str2.length() > 0))
            {
              localBundle.putString("openMonth", str2);
              localBundle.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            localBundle.putBoolean("isAutoPay", Boolean.valueOf(bool2).booleanValue());
            localBundle.putString("remark", str3);
            localBundle.putString("actTitle", str5);
            localBundle.putInt("openType", i1);
            localBundle.putString("actHint", str6);
            localBundle.putString("actPayTotal", str7);
            localBundle.putString("actPayDiscount", str8);
            localBundle.putString("actBtnTitle", str9);
            localBundle.putString("openServicePrice", str10);
            localBundle.putString("upgradeServicePrice", str11);
            localBundle.putInt("maxUpgradeMonth", i2);
            localBundle.putString("openTitle", str12);
            localBundle.putString("upgradeTitle", str13);
            localBundle.putString("discountId", str14);
            localBundle.putString("other", str15);
            localBundle.putString("couponId", (String)localObject);
            localBundle.putInt("PayInvokerId", 11);
            localBundle.putInt("payparmas_paytype", this.F);
            localBundle.putLong("payparmas_h5_start", this.jdField_a_of_type_Long);
            QWalletPayBridge.a(this, this.app, localBundle);
            return;
          }
          localObject = "";
          continue;
        }
        paramBundle = null;
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openSVip JSONException:" + paramBundle.getMessage());
        }
        a(str16, "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
        paramBundle.printStackTrace();
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openSVip Exception:" + paramBundle.getMessage());
        }
        a(str16, "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      continue;
      label1097:
      String str1 = null;
      continue;
      label1102:
      String str2 = null;
      continue;
      label1107:
      boolean bool1 = true;
      continue;
      label1113:
      boolean bool2 = true;
      continue;
      label1119:
      String str3 = "";
      continue;
      label1126:
      String str4 = "";
      continue;
      label1133:
      String str5 = "";
      continue;
      label1140:
      int i1 = 0;
      continue;
      label1146:
      String str6 = null;
      continue;
      label1152:
      String str7 = null;
      continue;
      label1158:
      String str8 = null;
      continue;
      label1164:
      String str9 = null;
      continue;
      label1170:
      String str10 = null;
      continue;
      label1176:
      String str11 = null;
      continue;
      label1182:
      int i2 = 0;
      continue;
      label1188:
      String str12 = "";
      continue;
      label1195:
      String str13 = "";
      continue;
      label1202:
      String str14 = "";
      continue;
      label1209:
      String str15 = "";
    }
  }
  
  protected static Bundle f(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    localBundle1 = new Bundle();
    try
    {
      Object localObject = new JSONObject(paramString2);
      String str7 = ((JSONObject)localObject).getString("payType");
      String str8 = ((JSONObject)localObject).getString("appId");
      String str9 = ((JSONObject)localObject).getString("autoJump");
      String str1;
      label92:
      String str2;
      label113:
      String str3;
      label134:
      String str4;
      label155:
      String str5;
      label176:
      String str6;
      if (((JSONObject)localObject).has("wxSignUrl"))
      {
        paramString2 = ((JSONObject)localObject).getString("wxSignUrl");
        if (!((JSONObject)localObject).has("extend")) {
          break label444;
        }
        str1 = ((JSONObject)localObject).getString("extend");
        if (!((JSONObject)localObject).has("bargainorId")) {
          break label450;
        }
        str2 = ((JSONObject)localObject).getString("bargainorId");
        if (!((JSONObject)localObject).has("tokenId")) {
          break label456;
        }
        str3 = ((JSONObject)localObject).getString("tokenId");
        if (!((JSONObject)localObject).has("nonceStr")) {
          break label462;
        }
        str4 = ((JSONObject)localObject).getString("nonceStr");
        if (!((JSONObject)localObject).has("timeStamp")) {
          break label468;
        }
        str5 = ((JSONObject)localObject).getString("timeStamp");
        if (!((JSONObject)localObject).has("packageValue")) {
          break label474;
        }
        str6 = ((JSONObject)localObject).getString("packageValue");
        label197:
        if (!((JSONObject)localObject).has("sign")) {
          break label480;
        }
      }
      label444:
      label450:
      label456:
      label462:
      label468:
      label474:
      label480:
      for (localObject = ((JSONObject)localObject).getString("sign");; localObject = null)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("payType", str7);
        localBundle2.putString("appId", str8);
        localBundle2.putString("autoJump", str9);
        localBundle2.putString("wxSignUrl", paramString2);
        localBundle2.putString("extend", str1);
        localBundle2.putString("bargainorId", str2);
        localBundle2.putString("tokenId", str3);
        localBundle2.putString("nonceStr", str4);
        localBundle2.putString("timeStamp", str5);
        localBundle2.putString("packageValue", str6);
        localBundle2.putString("sign", (String)localObject);
        localBundle2.putString("callbackSn", paramString1);
        localBundle2.putInt("PayInvokerId", 17);
        localBundle2.putInt("payparmas_paytype", paramInt);
        localBundle2.putLong("payparmas_h5_start", paramLong);
        if (paramResultReceiver != null)
        {
          paramString1 = Parcel.obtain();
          paramResultReceiver.writeToParcel(paramString1, 0);
          paramString1.setDataPosition(0);
          paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
          paramString1.recycle();
          localBundle2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
        }
        QWalletPayBridge.a(paramActivity, paramAppInterface, localBundle2);
        localBundle1.putInt("retCode", 0);
        return localBundle1;
        paramString2 = null;
        break;
        str1 = null;
        break label92;
        str2 = null;
        break label113;
        str3 = null;
        break label134;
        str4 = null;
        break label155;
        str5 = null;
        break label176;
        str6 = null;
        break label197;
      }
      return localBundle1;
    }
    catch (JSONException paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "launchWeChat JSONException:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle1.putInt("retCode", -1);
      localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat JSONException'}");
      return localBundle1;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "launchWeChat Exception:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle1.putInt("retCode", -1);
      localBundle1.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat Exception'}");
    }
  }
  
  private void f(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int i2 = paramIntent.getIntExtra("result", -1);
    int i3 = paramIntent.getIntExtra("payState", -1);
    int i4 = paramIntent.getIntExtra("provideState", -1);
    paramIntent = paramIntent.getStringExtra("message");
    if (i1 == 1)
    {
      a(i2, paramIntent, i3, i4);
      return;
    }
    a(-1, "", -1, -1);
  }
  
  private void g(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void h(Intent paramIntent)
  {
    Object localObject;
    if (("graphb".equals(this.u)) && (paramIntent.hasExtra("upload_data")))
    {
      localObject = paramIntent.getStringExtra("upload_data");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(";");
        if ((localObject != null) && (localObject.length > 2) && (localObject[1].contains("redpackets.opened.show,")))
        {
          localObject = localObject[1].split("\\|");
          if ((localObject != null) && (localObject.length > 5))
          {
            localObject = localObject[4].split(",");
            if ((localObject == null) || (localObject.length <= 1)) {}
          }
        }
      }
    }
    try
    {
      this.jdField_d_of_type_Long = Long.parseLong(localObject[1]);
      int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
      localObject = paramIntent.getStringExtra("callbackSn");
      String str1 = paramIntent.getStringExtra("result");
      String str2 = paramIntent.getStringExtra("upload_data");
      long l1 = paramIntent.getLongExtra("reportSeq", 0L);
      int i2 = paramIntent.getIntExtra("viewRetCode", -9);
      if ((this.jdField_b_of_type_Boolean) && (l1 > 0L)) {
        VACDReportUtil.a(l1, "view.End", null, i2, null);
      }
      if (!TextUtils.isEmpty(str1)) {
        try
        {
          paramIntent = new JSONObject(str1).optJSONObject("retdata");
          if (paramIntent != null)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("retdata", paramIntent.toString());
            i2 = Integer.valueOf(paramIntent.optString("exec_code", "-1")).intValue();
            if ((i2 == 1) || (i2 == 2) || (i2 == 3))
            {
              setResult(-1, localIntent);
              finish();
              return;
            }
          }
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
      if (i1 == 1)
      {
        if ((str2 != null) && (str2.length() > 0)) {
          a(this.app, str2);
        }
        a((String)localObject, str1);
        return;
      }
      a((String)localObject, b());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
  }
  
  private void i(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str1 = paramIntent.getStringExtra("callbackSn");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    String str2 = paramIntent.getStringExtra("result");
    String str3 = paramIntent.getStringExtra("upload_data");
    boolean bool = paramIntent.getBooleanExtra("isChoosePubAcc", false);
    String str4 = paramIntent.getStringExtra("pubAcc");
    long l1 = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.jdField_b_of_type_Boolean) && (l1 > 0L)) {
      VACDReportUtil.a(l1, "payEnd", null, i2, null);
    }
    if (i1 == 1)
    {
      if ((str3 != null) && (str3.length() > 0)) {
        a(this.app, str3);
      }
      if ((bool) && (this.app != null) && (!TextUtils.isEmpty(str4))) {
        PublicAccountUtil.a(this.app, this.app.a(), str4, null);
      }
      a(str1, str2);
      return;
    }
    a(str1, b());
  }
  
  private void j(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void k(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void l(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void m(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  private void n(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    if (i1 == 1)
    {
      a(str, paramIntent);
      return;
    }
    a(str, a());
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (paramString1 == null)) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString1);
    localBundle.putString("callbackSn", paramString2);
    return a(paramActivity, paramInt, localBundle);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427379);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " PayBridgeActivity.doOnCreate");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " PayBridgeActivity.doOnCreate");
    }
    if ((this.app == null) || (this.app.a() == null) || (getIntent() == null) || (getIntent().getExtras() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "PayBridgeActivity.doOnCreate error");
      }
      finish();
    }
    paramBundle = getIntent().getExtras();
    ((NotificationManager)getSystemService("notification")).cancel(128);
    this.G = paramBundle.getInt("pay_requestcode", -1);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("payparmas_from_pcpush", false);
    this.F = paramBundle.getInt("payparmas_paytype", -1);
    this.jdField_a_of_type_Long = paramBundle.getLong("payparmas_h5_start", 0L);
    this.jdField_b_of_type_Long = paramBundle.getLong("vacreport_key_seq", 0L);
    if (this.G == 12)
    {
      if (GesturePWDUtils.getJumpLock(this, this.app.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.push", 2, "moveTaskToBack and startUnlockActivity...");
        }
        startUnlockActivity();
        super.finish();
        return false;
      }
      if (jdField_c_of_type_Boolean)
      {
        super.finish();
        return false;
      }
      jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      a(QWalletPushManager.a(this.jdField_a_of_type_Boolean));
    }
    jdField_c_of_type_Boolean = true;
    if (this.G == 1)
    {
      paramBundle = DataFactory.EmojiPayReqData.a(paramBundle);
      if ((paramBundle == null) || (!a(paramBundle)))
      {
        a(paramBundle, -1, 0, -1, -1, -1, "param error");
        if (paramBundle == null) {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror: reqData:null");
          }
        }
        for (;;)
        {
          jdField_c_of_type_Boolean = false;
          finish();
          return false;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror:userid:" + paramBundle.c + "userkey:" + paramBundle.d + "sessionid:" + paramBundle.e + "sessionType:" + paramBundle.f + "zoneId:" + paramBundle.g + "pf:" + paramBundle.h + "pfKey:" + paramBundle.i + "tokenUrl:" + paramBundle.j + "discountId:" + paramBundle.k + "other:" + paramBundle.l);
          }
        }
      }
      a(paramBundle);
      return false;
    }
    if (this.G == 2)
    {
      a(paramBundle);
      return false;
    }
    if (this.G == 3)
    {
      b(paramBundle);
      return false;
    }
    if ((this.G == 4) || (this.G == 6) || (this.G == 7) || (this.G == 8) || (this.G == 9) || (this.G == 14))
    {
      a(this.G, paramBundle);
      return false;
    }
    if (this.G == 5)
    {
      c(paramBundle);
      return false;
    }
    if (this.G == 10)
    {
      d(paramBundle);
      return false;
    }
    if (this.G == 11)
    {
      e(paramBundle);
      return false;
    }
    if (this.G == 13)
    {
      paramBundle = new Bundle();
      paramBundle.putInt("PayInvokerId", 12);
      QWalletPayBridge.a(this, this.app, paramBundle);
      return false;
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_c_of_type_Boolean = false;
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.F = paramBundle.getInt("mPayType", -1);
    this.n = paramBundle.getString("mPayTokenId");
    this.o = paramBundle.getString("mPayAppId");
    this.p = paramBundle.getString("mPayChannel");
    this.q = paramBundle.getString("mPayBargainorId");
    this.r = paramBundle.getString("mMidasOfferid");
    this.s = paramBundle.getString("mMidasAid");
    this.t = paramBundle.getString("mMidasOrderId");
    this.u = paramBundle.getString("mOpenViewTag");
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("mPayType", this.F);
    paramBundle.putString("mPayTokenId", this.n);
    paramBundle.putString("mPayAppId", this.o);
    paramBundle.putString("mPayChannel", this.p);
    paramBundle.putString("mPayBargainorId", this.q);
    paramBundle.putString("mMidasOfferid", this.r);
    paramBundle.putString("mMidasAid", this.s);
    paramBundle.putString("mMidasOrderId", this.t);
    paramBundle.putString("mOpenViewTag", this.u);
  }
  
  public void finish()
  {
    QWalletPushManager.a();
    int i1 = QWalletPushManager.a();
    if (i1 <= 0)
    {
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentIntent != null)) {
        setResult(this.H, this.jdField_a_of_type_AndroidContentIntent);
      }
      jdField_c_of_type_Boolean = false;
      super.finish();
      return;
    }
    Object localObject = String.format(getString(2131366522), new Object[] { Integer.valueOf(i1) });
    localObject = a(getString(2131370934), (String)localObject, null);
    ((Dialog)localObject).setCancelable(false);
    lyv locallyv = new lyv(this, (Dialog)localObject);
    ((Dialog)localObject).findViewById(2131297844).setOnClickListener(locallyv);
    ((Dialog)localObject).findViewById(2131297843).setOnClickListener(locallyv);
    ((Dialog)localObject).show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = -1;
    if (((paramIntent != null) && (paramInt1 == 3001)) || (paramInt2 == -1))
    {
      paramInt1 = i1;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "" + System.currentTimeMillis() + " PayBridgeAct.onActivityResult");
      }
      switch (paramInt1)
      {
      case 13: 
      case 15: 
      case 16: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown InvokerId : " + paramInt1);
        }
        finish();
        return;
      case 7: 
        b(paramIntent);
        return;
      case 1: 
        c(paramIntent);
        return;
      case 2: 
        d(paramIntent);
        return;
      case 3: 
        e(paramIntent);
        return;
      case 10: 
        f(paramIntent);
        return;
      case 4: 
        g(paramIntent);
        return;
      case 5: 
        h(paramIntent);
        return;
      case 9: 
        i(paramIntent);
        return;
      case 6: 
        j(paramIntent);
        return;
      case 8: 
        k(paramIntent);
        return;
      case 11: 
        l(paramIntent);
        return;
      case 12: 
        a(paramIntent);
        return;
      case 14: 
        m(paramIntent);
        return;
      }
      n(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown data");
    }
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PayBridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */