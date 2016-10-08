package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import slk;
import sll;
import slm;
import slq;
import slr;
import sls;

public abstract class ForwardSdkBaseOption
  extends ForwardBaseOption
{
  public static Object a;
  public static final String ae = "UTF-8";
  public static final int c = 45;
  public static final int d = 60;
  static final int e = 0;
  static final int f = 1;
  public static final String g = "ForwardOption.ForwardSdkBaseOption";
  public static final String h = "ForwardSdkBaseOption";
  public Handler a;
  public AbsShareMsg a;
  public GetAppInfoProto.GetAppinfoResponse a;
  protected BusinessObserver a;
  sls a;
  public String af;
  public int b;
  public long b;
  private Handler b;
  public ShareResultDialog b;
  public long c;
  protected boolean g;
  public boolean h;
  public String i;
  public boolean i;
  protected String j;
  public boolean j;
  public String k = "";
  public boolean k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ForwardSdkBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new slk(this);
    this.jdField_a_of_type_Sls = new sls(this);
    this.jdField_b_of_type_AndroidOsHandler = new sll(this);
  }
  
  public static final void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    long l = 0L;
    if ((paramActivity == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = paramIntent.getBundleExtra("share_data");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramIntent.getExtras();
      }
      paramIntent = "shareToQzone";
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getString("share_action");
        paramIntent = (Intent)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramIntent = "shareToQzone";
        }
      }
      if (localObject1 != null) {
        l = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + l + " action=" + "shareToQzone");
      }
      localObject2 = new Intent();
      if (paramBoolean)
      {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), paramIntent })));
        if (localObject1 == null) {}
      }
      try
      {
        ((Intent)localObject2).setPackage(((Bundle)localObject1).getString("pkg_name"));
        try
        {
          paramActivity.startActivity((Intent)localObject2);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity, new Object[0]);
        return;
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l), paramIntent })));
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ((Intent)localObject2).setPackage(null);
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramLong + " action=" + paramString);
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
        if (paramActivity.getIntent() != null)
        {
          String str = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString = str;
          if (!TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        paramString = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    r();
    if ((paramInt2 == e.intValue()) && (paramInt1 == 0)) {
      this.i = true;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog == null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(new slr(this));
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131367975);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a((String)localObject, c());
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131364382);
      localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        label175:
        ((ShareResultDialog)localObject).a(bool);
        if (paramInt1 != 0) {
          break label222;
        }
        x();
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
        return;
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
        continue;
        bool = false;
        break label175;
        label222:
        if (paramInt1 == 1002) {
          if (QLog.isColorLevel()) {
            QLog.d("sdk_share", 2, "!!!upload image fail---------------------------------");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131367607), c());
          break;
          if (paramInt1 == 1003) {
            this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131364600);
          } else if (paramInt1 == 1004)
          {
            if (QLog.isColorLevel()) {
              QLog.d("sdk_share", 2, "!!!skey not ready fail---------------------------------");
            }
          }
          else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
            QLog.d("sdk_share", 2, "!!!vkey not ready fail---------------------------------");
          }
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("sdk_share", 2, "resultDlg.show() failed");
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      r();
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(1003, jdField_b_of_type_JavaLangInteger.intValue());
      return;
    }
    if ((this.jdField_b_of_type_Int != 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("image_url"))))
    {
      a(1002, jdField_b_of_type_JavaLangInteger.intValue());
      return;
    }
    if (paramHashMap.containsKey("imageUrl"))
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
      this.jdField_a_of_type_AndroidOsBundle.remove("image_url");
    }
    if (paramHashMap.containsKey("audioUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)paramHashMap.get("audioUrl"));
    }
    if (paramHashMap.containsKey("targetUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)paramHashMap.get("targetUrl"));
    }
    if (paramHashMap.containsKey("sourceUrl")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
    }
    if (paramHashMap.containsKey("sourceIcon")) {
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "-->asyncSendToBuddy--mForwardSubType = " + this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1) == 2)
    {
      paramHashMap = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      r();
      ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), paramHashMap, null);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_b_of_type_Long));
      if (this.jdField_b_of_type_Int != 5) {
        break label489;
      }
    }
    label489:
    for (paramHashMap = "connect_sharepic";; paramHashMap = "connect_share2qq")
    {
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), paramHashMap, "send", this.jdField_b_of_type_Long, e(), String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")));
      a(0, "", "");
      return;
      paramHashMap = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
      Bundle localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      paramHashMap.putExtras(localBundle);
      paramHashMap.setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramHashMap);
      break;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    r();
    String str;
    if (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog == null)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131367975);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.a(str, new slq(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.a(2131364383);
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131364386), new Object[] { Integer.valueOf(paramInt) });
      }
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.b(str);
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.show();
      return;
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected void i()
  {
    if (this.i) {
      a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", this.jdField_b_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.i("sdk_share", 2, "back call");
      }
      return;
      a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQQ", this.jdField_b_of_type_Long);
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("sdk_share", 2, "send call");
    }
    this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    w();
  }
  
  public void q()
  {
    super.q();
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  protected void u()
  {
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = localObject1;
      if (((String)localObject1).endsWith("...")) {
        localObject3 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("..."));
      }
    }
    localObject1 = localObject2;
    if (SubString.a((String)localObject2, "UTF-8") > 45) {
      localObject1 = SubString.a((String)localObject2, 45, "UTF-8", null);
    }
    Object localObject4 = localObject3;
    if (SubString.a((String)localObject3, "UTF-8") > 90) {
      localObject4 = SubString.a((String)localObject3, 90, "UTF-8", null);
    }
    localObject2 = localObject4;
    if (SubString.a((String)localObject1, "UTF-8") + SubString.a((String)localObject4, "UTF-8") > 105) {
      localObject2 = SubString.a((String)localObject4, 105 - ((String)localObject1).length(), "UTF-8", "...");
    }
    if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))) {
      localObject1 = (String)localObject1 + "...";
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((String)localObject2).endsWith("...")) && (!((String)localObject2).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))) {
        localObject2 = (String)localObject2 + "...";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject1);
        this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject2);
        return;
      }
    }
  }
  
  public final void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "-->getQQAccountSKey--send g_t_n_p, account = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4096, this.jdField_a_of_type_Sls);
  }
  
  protected void w()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    ThreadManager.a(new slm(this), 8, null, false);
  }
  
  protected void x()
  {
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_b_of_type_Long), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardSdkBaseOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */