package com.tencent.mobileqq.intervideo.od;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;
import com.tencent.txproxy.XEventListener;
import com.tencent.txproxy.XPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import swk;
import swl;

public class ODProxy
  implements LoginKeyHelper.GetLoginKeyListener, Manager
{
  static final int jdField_a_of_type_Int = 0;
  static final String jdField_a_of_type_JavaLangString = "XProxy|ODPROXY";
  static final int jdField_b_of_type_Int = 1;
  static final String jdField_b_of_type_JavaLangString = "1104763709";
  static final int jdField_c_of_type_Int = 2;
  static final int jdField_d_of_type_Int = 3;
  static final int jdField_e_of_type_Int = 4;
  static final int f = 5;
  static final int g = 1;
  static final int h = 2;
  static final int i = 4;
  static final int j = 2;
  static final int k = 2;
  long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  public QQAppInterface a;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  LoginKeyHelper jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper;
  ODDownloader jdField_a_of_type_ComTencentMobileqqIntervideoOdODDownloader;
  private XEventListener jdField_a_of_type_ComTencentTxproxyXEventListener;
  XPlugin jdField_a_of_type_ComTencentTxproxyXPlugin;
  public List a;
  swl jdField_a_of_type_Swl;
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private int l;
  
  public ODProxy(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Swl = new swl(this);
    this.jdField_a_of_type_ComTencentTxproxyXEventListener = new swk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Od");
  }
  
  private void d()
  {
    InitParam localInitParam = new InitParam();
    localInitParam.mPluginName = "odapp";
    localInitParam.mChannelId = 2;
    localInitParam.mChannelType = 2;
    localInitParam.mSourceVersion = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    localInitParam.mSourceId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localInitParam.mDefaultLoadApkActivity = "com.tencent.pluginloader.proxy.ODLoadActivity";
    localInitParam.isDownloadInHost = true;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.setInitData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), localInitParam);
  }
  
  public void a() {}
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
    paramString1 = new IVPluginInfo();
    int m = (int)(Math.random() * 1.0D + 0.5D);
    paramString1.mRoomId = paramLong;
    paramString1.mFromId = String.valueOf(paramInt);
    paramString1.mLoginAppId = "1104763709";
    paramString1.mPackageName = "com.tencent.mobileqq";
    paramString1.mPluginid = "Od";
    a(paramContext, paramString1, true);
  }
  
  public void a(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramIVPluginEvtListener));
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.cancelRunPlugin(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    c();
  }
  
  protected boolean a(Context paramContext, IVPluginInfo paramIVPluginInfo, boolean paramBoolean)
  {
    if (paramIVPluginInfo == null) {
      return false;
    }
    paramIVPluginInfo.mLoginAppId = "1104763709";
    paramIVPluginInfo.mPackageName = "com.tencent.mobileqq";
    paramIVPluginInfo.mPluginid = "Od";
    if (paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, ODLoadingActivity.class);
      localIntent.putExtra("plugininfo", paramIVPluginInfo);
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIVPluginInfo.mPluginid, this.jdField_a_of_type_AndroidContentContext, paramIVPluginInfo.mLoginAppId, this);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
        str3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject3 = ((FriendsManager)localObject2).c(str3);
        if (localObject3 == null) {
          break label531;
        }
        localObject1 = ((Friends)localObject3).name;
        n = ((Friends)localObject3).gender;
        m = ((Friends)localObject3).age;
        localObject3 = ((FriendsManager)localObject2).a(str3);
        if (localObject3 == null) {
          break label512;
        }
        i1 = (int)((Card)localObject3).lBirthday;
        localObject2 = ((Card)localObject3).strCountry;
        str2 = ((Card)localObject3).strProvince;
        localObject3 = ((Card)localObject3).strCity;
      }
      catch (Exception localException)
      {
        Bundle localBundle;
        String str3;
        Object localObject1;
        localException.printStackTrace();
        return;
      }
      localBundle.putString("nickname", (String)localObject1);
      localBundle.putString("roomname", this.c);
      localBundle.putLong("roomid", this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mRoomId);
      localBundle.putInt("authtype", 1);
      localBundle.putString("authid", this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a().b);
      localBundle.putInt("gender", n);
      localBundle.putInt("vastype", 2);
      localBundle.putLong("hostid", Long.parseLong(str3));
      localBundle.putString("authkey", this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a().a);
      localBundle.putString("appid", "1104763709");
      localBundle.putString("vasname", this.d);
      localBundle.putString("userdata", this.e);
      localBundle.putInt("fromid", this.l);
      localBundle.putInt("age", m);
      localBundle.putInt("birthyear", i3);
      localBundle.putInt("birthmonth", i2);
      localBundle.putInt("birthday", i1);
      localBundle.putBoolean("loghost", true);
      localBundle.putBoolean("reporthost", true);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localBundle.putString("addrCountry", (String)localObject2);
      }
      if (!TextUtils.isEmpty(str2)) {
        localBundle.putString("addrProv", str2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localBundle.putString("addrCity", (String)localObject3);
      }
      localObject1 = new RunPluginParams();
      ((RunPluginParams)localObject1).mRoomId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mRoomId;
      ((RunPluginParams)localObject1).mPackageName = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mPackageName;
      ((RunPluginParams)localObject1).useDefaultLoading = false;
      ((RunPluginParams)localObject1).vasSchema = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mScheme;
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtras(localBundle);
      ((RunPluginParams)localObject1).intent = ((Intent)localObject2);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.addEventListener(this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.runPlugin((RunPluginParams)localObject1);
      return;
      int i3 = i1 >>> 16;
      i2 = (0xFF00 & i1) >>> 8;
      i1 &= 0xFF;
      continue;
      label512:
      localObject2 = "";
      int i1 = 0;
      String str2 = "";
      Object localObject3 = "";
      break label544;
      label531:
      int m = 0;
      int n = 0;
      String str1 = "";
      continue;
      label544:
      if (i1 == 0)
      {
        i3 = 1995;
        i1 = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XProxy|ODPROXY", 2, "onDestroy");
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\od\ODProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */