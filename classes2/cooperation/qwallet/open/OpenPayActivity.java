package cooperation.qwallet.open;

import VIP.BaseInfo;
import VIP.ReqCheckPayAuth;
import Wallet.PrePayRqt;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletOpenHandler;
import com.tencent.mobileqq.app.QWalletOpenObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.pubaccpay.PayResponse;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.net.URLEncoder;
import java.security.MessageDigest;
import org.json.JSONException;
import org.json.JSONObject;
import yjk;
import yjl;

public class OpenPayActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "extra.key.pay.type";
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final int b = 1;
  public static final String b = "extra.key.pay.from";
  public static final int c = 2;
  public static final String c = "extra.key.pay.platform";
  public static final int d = 3;
  public static final String d = "extra.key.app.type";
  public static final int e = 1;
  public static final String e = "1";
  public static final int f = 2;
  public static final String f = "0";
  public static final int g = 1;
  private static final String g = "Q.qwallet.open.OpenPayActivity";
  public static final int h = 2;
  public long a;
  private ReqCheckPayAuth jdField_a_of_type_VIPReqCheckPayAuth;
  private PrePayRqt jdField_a_of_type_WalletPrePayRqt;
  public Bundle a;
  protected ResultReceiver a;
  private QWalletOpenHandler jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler;
  private QWalletOpenObserver jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver;
  protected QWalletPayProgressDialog a;
  private yjl jdField_a_of_type_Yjl;
  private String h;
  public int i;
  private String i;
  public int j;
  private String j;
  public int k;
  private String k;
  private int jdField_l_of_type_Int = -1;
  private String jdField_l_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OpenPayActivity()
  {
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int m = 0;
    while (m < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[m] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[m] & 0xF)]);
      localStringBuilder.append(':');
      m += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver.a();
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver);
    }
    if (this.jdField_a_of_type_Yjl != null) {
      this.jdField_a_of_type_Yjl.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver = null;
    this.jdField_a_of_type_Yjl = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler = null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog != null) {
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setOnCancelListener(new yjk(this));
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
  }
  
  private void b(Bundle paramBundle)
  {
    switch (this.jdField_j_of_type_Int)
    {
    }
    for (;;)
    {
      QWalletHelper.a(0, "qwallet_openpay");
      return;
      d(paramBundle);
      continue;
      c(paramBundle);
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("appId");
    Object localObject3 = paramBundle.getString("nonce");
    String str1 = paramBundle.getString("timeStampStr");
    String str3 = paramBundle.getString("packageValue");
    String str4 = paramBundle.getString("sig");
    String str5 = paramBundle.getString("sigType");
    String str6 = paramBundle.getString("qVersion");
    String str7 = paramBundle.getString("url");
    String str2 = paramBundle.getString("packageName");
    paramBundle = paramBundle.getString("callbackScheme");
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)))
    {
      a(64529, "Parameters error.", null, null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckPubAccPayAuth -1007");
      }
    }
    do
    {
      return;
      if ((this.jdField_i_of_type_Int != 2) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramBundle)))) {
        break;
      }
      a(64527, "Parameters error.", null, null);
    } while (!QLog.isColorLevel());
    QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doCheckPubAccPayAuth -1009");
    return;
    a(true);
    this.jdField_a_of_type_WalletPrePayRqt = new PrePayRqt();
    this.jdField_a_of_type_WalletPrePayRqt.appId = ((String)localObject1);
    this.jdField_a_of_type_WalletPrePayRqt.timeStamp = str1;
    this.jdField_a_of_type_WalletPrePayRqt.nonceStr = ((String)localObject3);
    this.jdField_a_of_type_WalletPrePayRqt.payPackage = str3;
    this.jdField_a_of_type_WalletPrePayRqt.signType = str5;
    this.jdField_a_of_type_WalletPrePayRqt.paySign = str4;
    this.jdField_a_of_type_WalletPrePayRqt.MQVersion = str6;
    this.jdField_a_of_type_WalletPrePayRqt.MQOS = "android";
    this.jdField_a_of_type_WalletPrePayRqt.phoneModel = Build.MODEL;
    if (this.jdField_i_of_type_Int == 1)
    {
      this.jdField_a_of_type_WalletPrePayRqt.sourceType = 1;
      this.jdField_a_of_type_WalletPrePayRqt.sourceUrl = str7;
      label319:
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("ai=").append(this.jdField_a_of_type_WalletPrePayRqt.appId);
      ((StringBuilder)localObject3).append("&ue=").append(this.jdField_a_of_type_WalletPrePayRqt.nonceStr);
      ((StringBuilder)localObject3).append("&pp=").append(this.jdField_a_of_type_WalletPrePayRqt.payPackage);
      ((StringBuilder)localObject3).append("&ts=").append(this.jdField_a_of_type_WalletPrePayRqt.timeStamp);
      ((StringBuilder)localObject3).append("&sg=").append(this.jdField_a_of_type_WalletPrePayRqt.paySign);
      ((StringBuilder)localObject3).append("&st=").append(this.jdField_a_of_type_WalletPrePayRqt.signType);
      ((StringBuilder)localObject3).append("&tp=").append(this.jdField_a_of_type_WalletPrePayRqt.sourceType);
      if (this.jdField_i_of_type_Int != 1) {
        break label837;
      }
      localObject1 = this.jdField_a_of_type_WalletPrePayRqt.sourceUrl;
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramBundle = URLEncoder.encode((String)localObject1, "utf-8");
        }
        ((StringBuilder)localObject3).append("&url=").append(paramBundle);
        VACDReportUtil.a(this.jdField_a_of_type_Long, null, "payauth", ((StringBuilder)localObject3).toString(), 0, null);
        a();
        this.jdField_a_of_type_Yjl = new yjl(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver = new QWalletOpenObserver(this.jdField_a_of_type_Yjl);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler = ((QWalletOpenHandler)this.app.a(30));
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler.a(this.jdField_a_of_type_WalletPrePayRqt);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doCheckPubAccPayAuth send");
        return;
        if (this.jdField_i_of_type_Int == 3)
        {
          this.jdField_a_of_type_WalletPrePayRqt.sourceType = 3;
          this.jdField_a_of_type_WalletPrePayRqt.sourceUrl = "";
          this.jdField_a_of_type_AndroidOsBundle.remove("_qwallet_payresult_receiver");
          break label319;
        }
        str1 = "";
        try
        {
          localObject1 = getPackageManager().getPackageInfo(str2, 64);
          paramBundle = ((PackageInfo)localObject1).versionName + "." + ((PackageInfo)localObject1).versionCode;
        }
        catch (Exception localException1)
        {
          try
          {
            localObject1 = ((PackageInfo)localObject1).signatures;
            localObject3 = MessageDigest.getInstance("SHA1");
            ((MessageDigest)localObject3).reset();
            ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
            localObject1 = a(((MessageDigest)localObject3).digest());
            localObject3 = paramBundle;
            this.jdField_a_of_type_WalletPrePayRqt.sourceType = 2;
            this.jdField_a_of_type_WalletPrePayRqt.appVersion = ((String)localObject3);
            this.jdField_a_of_type_WalletPrePayRqt.packageName = str2;
            this.jdField_a_of_type_WalletPrePayRqt.sha = ((String)localObject1);
          }
          catch (Exception localException2)
          {
            Object localObject2;
            continue;
          }
          localException1 = localException1;
          paramBundle = "";
        }
        localException1.printStackTrace();
        localObject3 = paramBundle;
        localObject2 = str1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckPubAccPayAuth Exception");
        localObject3 = paramBundle;
        localObject2 = str1;
        continue;
      }
      catch (Exception localException3)
      {
        paramBundle = (Bundle)localObject2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException3.printStackTrace();
        paramBundle = (Bundle)localObject2;
        continue;
      }
      label837:
      ((StringBuilder)localObject3).append("&av=").append(this.jdField_a_of_type_WalletPrePayRqt.appVersion);
      ((StringBuilder)localObject3).append("&pkg=").append(this.jdField_a_of_type_WalletPrePayRqt.packageName);
      ((StringBuilder)localObject3).append("&sha=").append(this.jdField_a_of_type_WalletPrePayRqt.sha);
    }
  }
  
  private void d(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("appId");
    Object localObject3 = paramBundle.getString("nonce");
    long l1 = paramBundle.getLong("timeStamp");
    String str1 = paramBundle.getString("sig");
    String str3 = paramBundle.getString("sigType");
    String str4 = paramBundle.getString("tokenId");
    String str5 = paramBundle.getString("pubAcc");
    String str6 = paramBundle.getString("bargainorId");
    String str7 = paramBundle.getString("qVersion");
    String str8 = paramBundle.getString("domain");
    String str2 = paramBundle.getString("packageName");
    paramBundle = paramBundle.getString("callbackScheme");
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str6)))
    {
      paramBundle = "ai:" + (String)localObject1 + " bi:" + str6 + " ti:" + str4 + " ne:" + (String)localObject3 + " sg:" + str1 + " st:" + str3;
      a(64529, "Parameters error.", null, null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPayAuth Parameters error:" + paramBundle);
      }
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_i_of_type_Int != 2) || ((!TextUtils.isEmpty(str2)) && ((this.jdField_k_of_type_Int != 1) || (!TextUtils.isEmpty(paramBundle))))) {
          break;
        }
        a(64527, "Parameters error.", null, null);
      } while (!QLog.isColorLevel());
      QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPayAuth -1009");
      return;
      a(true);
      paramBundle = new BaseInfo();
      paramBundle.appId = ((String)localObject1);
      paramBundle.nonce = ((String)localObject3);
      paramBundle.timeStamp = l1;
      paramBundle.sig = str1;
      paramBundle.sigType = str3;
      paramBundle.qVersion = str7;
      paramBundle.phoneModel = Build.MODEL;
      paramBundle.phoneOS = "android";
      this.jdField_a_of_type_VIPReqCheckPayAuth = new ReqCheckPayAuth();
      this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo = paramBundle;
      this.jdField_a_of_type_VIPReqCheckPayAuth.tokenId = str4;
      this.jdField_a_of_type_VIPReqCheckPayAuth.pubAcc = str5;
      this.jdField_a_of_type_VIPReqCheckPayAuth.bargainorId = str6;
      if (this.jdField_i_of_type_Int != 1) {
        break;
      }
      this.jdField_a_of_type_VIPReqCheckPayAuth.payFrom = 1;
      this.jdField_a_of_type_VIPReqCheckPayAuth.p1 = str8;
      this.jdField_a_of_type_VIPReqCheckPayAuth.p2 = "";
      this.jdField_a_of_type_VIPReqCheckPayAuth.p3 = "";
      paramBundle = new StringBuilder();
      paramBundle.append("ai=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo.appId);
      paramBundle.append("&ue=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo.nonce);
      paramBundle.append("&ts=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo.timeStamp);
      paramBundle.append("&sg=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo.sig);
      paramBundle.append("&st=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.baseInfo.sigType);
      paramBundle.append("&ti=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.tokenId);
      paramBundle.append("&pa=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.pubAcc);
      paramBundle.append("&bi=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.bargainorId);
      paramBundle.append("&pf=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.payFrom);
      paramBundle.append("&p1=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.p1);
      paramBundle.append("&p2=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.p2);
      paramBundle.append("&p3=").append(this.jdField_a_of_type_VIPReqCheckPayAuth.p3);
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, "payauth", paramBundle.toString(), 0, null);
      a();
      this.jdField_a_of_type_Yjl = new yjl(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver = new QWalletOpenObserver(this.jdField_a_of_type_Yjl);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler = ((QWalletOpenHandler)this.app.a(30));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler.a(this.jdField_a_of_type_VIPReqCheckPayAuth);
    } while (!QLog.isColorLevel());
    QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doCheckOpenPayAuth send");
    return;
    str1 = "";
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getPackageInfo(str2, 64);
        paramBundle = ((PackageInfo)localObject1).versionName;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = ((PackageInfo)localObject1).signatures;
          localObject3 = MessageDigest.getInstance("SHA1");
          ((MessageDigest)localObject3).reset();
          ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
          localObject1 = a(((MessageDigest)localObject3).digest());
          localObject3 = paramBundle;
          this.jdField_a_of_type_VIPReqCheckPayAuth.payFrom = 2;
          this.jdField_a_of_type_VIPReqCheckPayAuth.p1 = str2;
          this.jdField_a_of_type_VIPReqCheckPayAuth.p2 = ((String)localObject3);
          this.jdField_a_of_type_VIPReqCheckPayAuth.p3 = ((String)localObject1);
        }
        catch (Exception localException2)
        {
          Object localObject2;
          for (;;) {}
        }
        localException1 = localException1;
        paramBundle = "";
      }
      localException1.printStackTrace();
      localObject3 = paramBundle;
      localObject2 = str1;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doCheckOpenPayAuth Exception");
        localObject3 = paramBundle;
        localObject2 = str1;
      }
    }
  }
  
  private void e(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doAppCashPayResult:" + paramBundle.toString());
    }
    if (this.jdField_i_of_type_Int != 2)
    {
      super.finish();
      return;
    }
    switch (this.jdField_j_of_type_Int)
    {
    default: 
      return;
    case 1: 
      g(paramBundle);
      return;
    }
    f(paramBundle);
  }
  
  private void f(Bundle paramBundle)
  {
    Object localObject = new PayResponse();
    ((PayResponse)localObject).jdField_a_of_type_Int = 90001;
    ((PayResponse)localObject).jdField_a_of_type_JavaLangString = "pubaccpay";
    ((PayResponse)localObject).jdField_c_of_type_JavaLangString = paramBundle.getString("callbackSn");
    ((PayResponse)localObject).e = paramBundle.getInt("retCode");
    ((PayResponse)localObject).b = paramBundle.getString("retMsg");
    paramBundle = new Bundle();
    ((PayResponse)localObject).a(paramBundle);
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("packageName");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("callbackScheme");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)))
    {
      super.finish();
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.open.OpenPayActivity", 2, "OpenPayActivity.doPubAccAppCashPayResult packageName&callbackScheme empty");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str + "://pubacc_pay/pay"));
    localIntent.setPackage((String)localObject);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("com_tencent_mobileqq_pubaccpay", "com.tencent.mobileqq.pubaccpay");
    try
    {
      super.startActivity(localIntent);
      super.finish();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.open.OpenPayActivity", 2, "doAppCashPayResult error:" + paramBundle.getMessage());
        } else if (QLog.isDevelopLevel()) {
          paramBundle.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  private void g(Bundle paramBundle)
  {
    // Byte code:
    //   0: new 607	cooperation/qwallet/open/openpay/PayResponse
    //   3: dup
    //   4: invokespecial 608	cooperation/qwallet/open/openpay/PayResponse:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: iconst_1
    //   12: putfield 610	cooperation/qwallet/open/openpay/PayResponse:jdField_d_of_type_Int	I
    //   15: aload 5
    //   17: ldc_w 612
    //   20: putfield 613	cooperation/qwallet/open/openpay/PayResponse:b	Ljava/lang/String;
    //   23: aload 5
    //   25: aload_1
    //   26: ldc_w 536
    //   29: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 615	cooperation/qwallet/open/openpay/PayResponse:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   35: aload 5
    //   37: aload_1
    //   38: ldc_w 540
    //   41: invokevirtual 544	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   44: putfield 617	cooperation/qwallet/open/openpay/PayResponse:jdField_c_of_type_Int	I
    //   47: aload 5
    //   49: aload_1
    //   50: ldc_w 548
    //   53: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 618	cooperation/qwallet/open/openpay/PayResponse:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 86	cooperation/qwallet/open/OpenPayActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   65: putfield 620	cooperation/qwallet/open/openpay/PayResponse:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   68: aload 5
    //   70: invokevirtual 622	cooperation/qwallet/open/openpay/PayResponse:a	()Z
    //   73: ifeq +75 -> 148
    //   76: aload 5
    //   78: aload_1
    //   79: ldc_w 624
    //   82: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 625	cooperation/qwallet/open/openpay/PayResponse:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   88: aload 5
    //   90: aload_1
    //   91: ldc_w 627
    //   94: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 629	cooperation/qwallet/open/openpay/PayResponse:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   100: aload 5
    //   102: aload_1
    //   103: ldc_w 631
    //   106: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   109: putfield 633	cooperation/qwallet/open/openpay/PayResponse:e	Ljava/lang/String;
    //   112: aload 5
    //   114: aload_1
    //   115: ldc_w 635
    //   118: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 637	cooperation/qwallet/open/openpay/PayResponse:f	Ljava/lang/String;
    //   124: aload 5
    //   126: aload_1
    //   127: ldc_w 639
    //   130: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putfield 641	cooperation/qwallet/open/openpay/PayResponse:g	Ljava/lang/String;
    //   136: aload 5
    //   138: aload_1
    //   139: ldc_w 643
    //   142: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: putfield 645	cooperation/qwallet/open/openpay/PayResponse:h	Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 341	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   152: ldc -62
    //   154: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore_2
    //   158: aload_0
    //   159: getfield 341	cooperation/qwallet/open/OpenPayActivity:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   162: ldc -60
    //   164: invokevirtual 178	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore_3
    //   168: aload_2
    //   169: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +10 -> 182
    //   175: aload_3
    //   176: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +23 -> 202
    //   182: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 31
    //   190: iconst_2
    //   191: ldc_w 647
    //   194: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: invokespecial 520	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   201: return
    //   202: new 557	android/content/Intent
    //   205: dup
    //   206: invokespecial 558	android/content/Intent:<init>	()V
    //   209: astore 4
    //   211: aload_0
    //   212: getfield 83	cooperation/qwallet/open/OpenPayActivity:jdField_k_of_type_Int	I
    //   215: iconst_2
    //   216: if_icmpne +124 -> 340
    //   219: aload 5
    //   221: invokevirtual 649	cooperation/qwallet/open/openpay/PayResponse:a	()Ljava/lang/String;
    //   224: astore_1
    //   225: aload_1
    //   226: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifne +105 -> 334
    //   232: new 651	java/lang/String
    //   235: dup
    //   236: aload_1
    //   237: invokevirtual 654	java/lang/String:getBytes	()[B
    //   240: iconst_0
    //   241: invokestatic 659	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   244: invokespecial 661	java/lang/String:<init>	([B)V
    //   247: astore_1
    //   248: aload 4
    //   250: ldc_w 560
    //   253: invokevirtual 564	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: aload 4
    //   259: new 90	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   266: aload_3
    //   267: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 663
    //   273: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 572	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   286: invokevirtual 576	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   289: pop
    //   290: aload 4
    //   292: aload_2
    //   293: invokevirtual 579	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   296: pop
    //   297: aload 4
    //   299: ldc_w 580
    //   302: invokevirtual 584	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   305: pop
    //   306: aload 4
    //   308: ldc_w 665
    //   311: ldc_w 667
    //   314: invokevirtual 596	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: aload_0
    //   319: aload 4
    //   321: invokespecial 600	com/tencent/mobileqq/app/BaseActivity:startActivity	(Landroid/content/Intent;)V
    //   324: aload_0
    //   325: invokespecial 520	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   328: return
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 408	java/lang/Exception:printStackTrace	()V
    //   334: ldc 107
    //   336: astore_1
    //   337: goto -89 -> 248
    //   340: new 174	android/os/Bundle
    //   343: dup
    //   344: invokespecial 551	android/os/Bundle:<init>	()V
    //   347: astore_1
    //   348: aload 5
    //   350: aload_1
    //   351: invokevirtual 668	cooperation/qwallet/open/openpay/PayResponse:a	(Landroid/os/Bundle;)V
    //   354: aload 4
    //   356: ldc_w 560
    //   359: invokevirtual 564	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   362: pop
    //   363: aload 4
    //   365: new 90	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   372: aload_3
    //   373: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 670
    //   379: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 572	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   388: invokevirtual 576	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   391: pop
    //   392: aload 4
    //   394: aload_2
    //   395: invokevirtual 579	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   398: pop
    //   399: aload 4
    //   401: ldc_w 580
    //   404: invokevirtual 584	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   407: pop
    //   408: aload 4
    //   410: aload_1
    //   411: invokevirtual 588	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   414: pop
    //   415: aload 4
    //   417: ldc_w 665
    //   420: ldc_w 667
    //   423: invokevirtual 596	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   426: pop
    //   427: goto -109 -> 318
    //   430: astore_1
    //   431: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +35 -> 469
    //   437: ldc 31
    //   439: iconst_2
    //   440: new 90	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 602
    //   450: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 605	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -142 -> 324
    //   469: invokestatic 413	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   472: ifeq -148 -> 324
    //   475: aload_1
    //   476: invokevirtual 408	java/lang/Exception:printStackTrace	()V
    //   479: goto -155 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	OpenPayActivity
    //   0	482	1	paramBundle	Bundle
    //   157	238	2	str1	String
    //   167	206	3	str2	String
    //   209	207	4	localIntent	Intent
    //   7	342	5	localPayResponse	cooperation.qwallet.open.openpay.PayResponse
    // Exception table:
    //   from	to	target	type
    //   232	248	329	java/lang/Exception
    //   318	324	430	java/lang/Exception
  }
  
  private void h(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doQuickPayResult:" + paramBundle.toString());
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(9, paramBundle);
    super.finish();
  }
  
  private void i(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doJsCashPayResult:" + paramBundle.toString());
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected int a()
  {
    if (this.jdField_j_of_type_Int == 1)
    {
      if (this.jdField_i_of_type_Int == 2) {
        return 4;
      }
      return 3;
    }
    if (this.jdField_j_of_type_Int == 2)
    {
      if (this.jdField_i_of_type_Int == 2) {
        return 7;
      }
      return 6;
    }
    return -1;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(false);
    String str1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("callbackSn");
    }
    int m = paramInt;
    Bundle localBundle;
    if (this.jdField_j_of_type_Int == 2)
    {
      if (paramInt == 0)
      {
        paramString1 = "支付完成";
        m = paramInt;
      }
    }
    else
    {
      localBundle = new Bundle();
      localBundle.putInt("retCode", m);
      localBundle.putString("retMsg", paramString1);
      localBundle.putString("callbackSn", str1);
      if ((m != 0) || (TextUtils.isEmpty(paramString2))) {}
    }
    for (;;)
    {
      String str2;
      try
      {
        localObject = new JSONObject(paramString2);
        if (((JSONObject)localObject).has("transaction_id"))
        {
          paramString1 = ((JSONObject)localObject).getString("transaction_id");
          if (!((JSONObject)localObject).has("pay_time")) {
            break label509;
          }
          paramString2 = ((JSONObject)localObject).getString("pay_time");
          if (!((JSONObject)localObject).has("total_fee")) {
            break label515;
          }
          paramString3 = ((JSONObject)localObject).getString("total_fee");
          if (!((JSONObject)localObject).has("callback_url")) {
            break label522;
          }
          str1 = ((JSONObject)localObject).getString("callback_url");
          if (!((JSONObject)localObject).has("sp_data")) {
            break label529;
          }
          str2 = ((JSONObject)localObject).getString("sp_data");
          if (!((JSONObject)localObject).has("iswechatpay")) {
            continue;
          }
          localObject = ((JSONObject)localObject).getString("iswechatpay");
          String str4 = "0";
          String str3 = str4;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            str3 = str4;
            if ("1".compareTo((String)localObject) == 0) {
              str3 = "1";
            }
          }
          localBundle.putString("payChannelType", str3);
          localBundle.putString("transactionId", paramString1);
          localBundle.putString("payTime", paramString2);
          localBundle.putString("totalFee", paramString3);
          localBundle.putString("callbackUrl", str1);
          localBundle.putString("spData", str2);
        }
      }
      catch (JSONException paramString1)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.qwallet.open.OpenPayActivity", 2, "doCashPayResult error:" + paramString1.getMessage());
          continue;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramString1.printStackTrace();
        continue;
        i(localBundle);
        return;
      }
      switch (this.jdField_i_of_type_Int)
      {
      default: 
        super.finish();
        return;
        if (paramInt == -1)
        {
          m = -2;
          paramString1 = "用户取消";
          break;
        }
        if (paramInt == 64525)
        {
          m = -3;
          paramString1 = "服务器连接失败";
          break;
        }
        if (paramInt == 64522)
        {
          m = -4;
          paramString1 = "支付鉴权失败";
          break;
        }
        paramString1 = "支付失败";
        m = -1;
        break;
        paramString1 = "";
        continue;
        localObject = "0";
        break;
      case 1: 
      case 2: 
        e(localBundle);
        return;
      case 3: 
        h(localBundle);
        return;
        label509:
        paramString2 = "";
        continue;
        label515:
        paramString3 = "";
        continue;
        label522:
        str1 = "";
        continue;
        label529:
        str2 = "";
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int m = 1;
    String str1 = paramBundle.getString("callbackSn");
    String str2 = this.app.a();
    String str3 = this.app.b();
    String str4 = paramBundle.getString("tokenId");
    String str5 = paramBundle.getString("bargainorId");
    String str6 = paramBundle.getString("appId");
    Object localObject = "";
    if (this.jdField_j_of_type_Int == 1) {
      if (this.jdField_i_of_type_Int == 2)
      {
        localObject = "thirdpartapp";
        m = 4;
      }
    }
    for (;;)
    {
      String str7 = "appid#" + str6 + "|bargainor_id#" + str5 + "|channel#" + (String)localObject;
      this.jdField_i_of_type_JavaLangString = str6;
      this.jdField_k_of_type_JavaLangString = str5;
      this.jdField_j_of_type_JavaLangString = ((String)localObject);
      this.h = str4;
      localObject = new Bundle();
      ((Bundle)localObject).putString("callbackSn", str1);
      ((Bundle)localObject).putString("tokenId", str4);
      ((Bundle)localObject).putString("userId", str2);
      ((Bundle)localObject).putString("userName", str3);
      ((Bundle)localObject).putInt("comeForm", m);
      ((Bundle)localObject).putString("appInfo", str7);
      str1 = paramBundle.getString("pubAcc");
      str2 = paramBundle.getString("pubAccHint");
      boolean bool = paramBundle.getBoolean("careFlag", false);
      if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0) && (!PublicAccountUtil.a(this.app, str1)))
      {
        ((Bundle)localObject).putString("pubAcc", str1);
        ((Bundle)localObject).putString("pubAccHint", str2);
        ((Bundle)localObject).putBoolean("careFlag", bool);
      }
      ((Bundle)localObject).putInt("PayInvokerId", 9);
      ((Bundle)localObject).putInt("payparmas_paytype", 4);
      ((Bundle)localObject).putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, "loadPluginStart", null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.i("QWalletLoadPlugin", 4, "loadPluginStart time=" + SystemClock.elapsedRealtime());
      }
      QWalletPayBridge.a(this, this.app, (Bundle)localObject, this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog);
      return;
      localObject = "thirdpartweb";
      m = 4;
      continue;
      if (this.jdField_i_of_type_Int == 2)
      {
        localObject = "app";
        m = 4;
      }
      else if (this.jdField_i_of_type_Int == 1)
      {
        localObject = "public";
        m = 4;
      }
      else if (this.jdField_i_of_type_Int == 3)
      {
        localObject = "publickj";
      }
      else
      {
        m = 4;
      }
    }
  }
  
  public boolean a()
  {
    switch (this.jdField_j_of_type_Int)
    {
    }
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler == null) || (this.jdField_a_of_type_VIPReqCheckPayAuth == null));
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler.a(this.jdField_a_of_type_VIPReqCheckPayAuth);
      return true;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler == null) || (this.jdField_a_of_type_WalletPrePayRqt == null));
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletOpenHandler.a(this.jdField_a_of_type_WalletPrePayRqt);
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayAct.onActivityResult request=" + paramInt1 + " result=" + paramInt2);
    }
    if (paramIntent == null)
    {
      a(64516, "System error.", null, null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult System error.");
      }
    }
    String str1;
    String str2;
    boolean bool;
    Object localObject;
    do
    {
      do
      {
        return;
        if (((paramInt1 != 3001) && (paramInt2 != -1)) || (paramIntent.getIntExtra("PayInvokerId", -1) == 9)) {
          break;
        }
        a(64533, "PayResult parameters error.", null, null);
      } while (!QLog.isColorLevel());
      QLog.e("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult PayResult parameters error.");
      return;
      paramInt1 = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
      str1 = paramIntent.getStringExtra("callbackSn");
      str2 = paramIntent.getStringExtra("result");
      bool = paramIntent.getBooleanExtra("isChoosePubAcc", false);
      localObject = paramIntent.getStringExtra("pubAcc");
      paramIntent = paramIntent.getStringExtra("upload_data");
      if ((!TextUtils.isEmpty(str2)) && (paramInt1 == 1)) {
        break;
      }
      a(64532, "Pay Cancelled.", null, str1);
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult -1004");
    return;
    if ((paramIntent != null) && (paramIntent.length() > 0)) {
      PayBridgeActivity.a(this.app, paramIntent);
    }
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      PublicAccountUtil.a(this.app, this.app.a(), (String)localObject, null, false);
    }
    try
    {
      localObject = new JSONObject(str2);
      if (!((JSONObject)localObject).has("resultCode")) {
        break label392;
      }
      paramInt1 = ((JSONObject)localObject).getInt("resultCode");
      if (!((JSONObject)localObject).has("retmsg")) {
        break label399;
      }
      paramIntent = ((JSONObject)localObject).getString("retmsg");
      label335:
      if (!((JSONObject)localObject).has("data")) {
        break label405;
      }
      localObject = ((JSONObject)localObject).getString("data");
      label356:
      a(paramInt1, paramIntent, (String)localObject, str1);
      return;
    }
    catch (JSONException paramIntent)
    {
      if (!QLog.isDevelopLevel()) {
        break label411;
      }
    }
    paramIntent.printStackTrace();
    for (;;)
    {
      a(64530, "PayResult JSONException", null, str1);
      return;
      label392:
      paramInt1 = 64531;
      break;
      label399:
      paramIntent = "";
      break label335;
      label405:
      localObject = null;
      break label356;
      label411:
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.open.OpenPayActivity", 2, "onActivityResult error:" + str2);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doOnCreate");
    }
    paramBundle = super.getIntent().getExtras();
    if ((this.app == null) || (paramBundle == null))
    {
      a(64535, "Parameters error.", null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate app == null || bundle == null");
      }
      return true;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_l_of_type_Int = paramBundle.getInt("extra.key.pay.type");
    this.jdField_i_of_type_Int = paramBundle.getInt("extra.key.pay.from", -1);
    this.jdField_j_of_type_Int = paramBundle.getInt("extra.key.pay.platform", -1);
    this.jdField_k_of_type_Int = paramBundle.getInt("extra.key.app.type", -1);
    this.jdField_a_of_type_Long = paramBundle.getLong("vacreport_key_seq", 0L);
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)this.jdField_a_of_type_AndroidOsBundle.getParcelable("_qwallet_payresult_receiver"));
    switch (this.jdField_l_of_type_Int)
    {
    default: 
      a(64534, "Parameters error.", null, null);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.doOnCreate mPayType error");
      }
      break;
    }
    while (BaseApplicationImpl.c > 0L)
    {
      Log.d("AutoMonitor", "actStartPay, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.c));
      return true;
      b(paramBundle);
    }
  }
  
  protected void doOnDestroy()
  {
    a();
    super.doOnDestroy();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.h = paramBundle.getString("mPayTokenId");
    this.jdField_i_of_type_JavaLangString = paramBundle.getString("mPayAppId");
    this.jdField_j_of_type_JavaLangString = paramBundle.getString("mPayChannel");
    this.jdField_k_of_type_JavaLangString = paramBundle.getString("mPayBargainorId");
    this.jdField_l_of_type_Int = paramBundle.getInt("mPayType", -1);
    this.jdField_i_of_type_Int = paramBundle.getInt("mPayFrom", -1);
    this.jdField_j_of_type_Int = paramBundle.getInt("mPayPlatfrom", -1);
    this.jdField_l_of_type_JavaLangString = paramBundle.getString("mOpenId");
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    paramBundle.putString("mPayTokenId", this.h);
    paramBundle.putString("mPayAppId", this.jdField_i_of_type_JavaLangString);
    paramBundle.putString("mPayChannel", this.jdField_j_of_type_JavaLangString);
    paramBundle.putString("mPayBargainorId", this.jdField_k_of_type_JavaLangString);
    paramBundle.putInt("mPayType", this.jdField_l_of_type_Int);
    paramBundle.putInt("mPayFrom", this.jdField_i_of_type_Int);
    paramBundle.putInt("mPayPlatfrom", this.jdField_j_of_type_Int);
    paramBundle.putString("mOpenId", this.jdField_l_of_type_JavaLangString);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\OpenPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */