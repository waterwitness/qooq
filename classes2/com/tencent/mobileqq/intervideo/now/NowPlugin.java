package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.tencent.biz.now.CgiHelper;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;
import com.tencent.txproxy.XEventListener;
import com.tencent.txproxy.XPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import svz;
import swd;

public class NowPlugin
{
  static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "XProxy|NowProxy";
  static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "XProxy_Perf";
  static final int jdField_c_of_type_Int = 2;
  private static final String jdField_c_of_type_JavaLangString = "1600000615";
  static final int d = 3;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  private static final int j = 4;
  private static final int k = 5;
  public Bundle a;
  ContainerActivity jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity;
  public CgiHelper a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public IVPluginInfo a;
  public LoginKeyHelper a;
  public JumpConfigUpdater a;
  public NowFromData a;
  private XEventListener jdField_a_of_type_ComTencentTxproxyXEventListener;
  XPlugin jdField_a_of_type_ComTencentTxproxyXPlugin;
  public List a;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  public int e;
  
  public NowPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater = new JumpConfigUpdater();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.e = 0;
    this.jdField_a_of_type_ComTencentBizNowCgiHelper = new CgiHelper();
    this.b = false;
    this.jdField_a_of_type_ComTencentTxproxyXEventListener = new swd(this);
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Live");
  }
  
  public NowPlugin(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater = new JumpConfigUpdater();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.e = 0;
    this.jdField_a_of_type_ComTencentBizNowCgiHelper = new CgiHelper();
    this.b = false;
    this.jdField_a_of_type_ComTencentTxproxyXEventListener = new swd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Live");
  }
  
  private void a(long paramLong)
  {
    Object localObject1 = "tnow://openpage/anchor?roomid=" + paramLong;
    Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
    ((Intent)localObject2).putExtras(this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a().a);
    ((Intent)localObject2).setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity((Intent)localObject2);
    StoryReportor.a("now_live", "jump_app", 0, 0, new String[] { localObject1 });
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IVPluginEvtListener)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((IVPluginEvtListener)localObject2).a("Live");
      }
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater.a() + "&roomid=" + paramLong;
    }
    StoryReportor.a("now_live", "jump_h5", 0, 0, new String[] { localObject });
    paramString = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("key_isReadModeEnabled", true);
    paramString.setFlags(268435456);
    WebAccelerator.a(BaseApplicationImpl.getContext(), paramString, (String)localObject);
    paramString = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      localObject = (IVPluginEvtListener)paramString.next();
      if (localObject != null) {
        ((IVPluginEvtListener)localObject).a("Live");
      }
    }
  }
  
  private void a(NowProxy.ListNameData paramListNameData, long paramLong, String paramString, Bundle paramBundle)
  {
    int m = 0;
    if (!this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b.equals("story")) {
      m = 1;
    }
    if ((m != 0) && (!this.jdField_a_of_type_ComTencentTxproxyXPlugin.hasLocalPlugin()))
    {
      QLog.i("XProxy|NowProxy", 2, "本地还没有插件，先跳转h5");
      a(paramLong, null);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.updatePluginAndPreInstall();
      return;
    }
    QLog.i("XProxy|NowProxy", 2, "直接跳转结合版");
    a(paramListNameData, paramLong, paramBundle);
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      InitParam localInitParam = new InitParam();
      localInitParam.mPluginName = "now";
      localInitParam.mChannelId = 2;
      localInitParam.mChannelType = 2;
      localInitParam.mSourceVersion = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        localInitParam.mSourceId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      localInitParam.isLogInHost = true;
      localInitParam.isDownloadInHost = true;
      if (this.jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity == null) {
        localInitParam.mDefaultLoadApkActivity = "com.tencent.mobileqq.intervideo.now.NowLoadApkActivity";
      }
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.setInitData(BaseApplicationImpl.getContext(), localInitParam);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("login.qq.kickout");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("com.tencent.now.sharetoqq");
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.registerPluginMsgCmd("now.room.destroy");
      QLog.i("XProxy|NowProxy", 2, "addEventListener listener = " + this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.addEventListener(this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "NowPlugin onDestroy");
    }
    c();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/startlive?from=1"));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    a(0L, "http://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644");
  }
  
  public void a(IVPluginEvtListener paramIVPluginEvtListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramIVPluginEvtListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramIVPluginEvtListener);
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.cancelRunPlugin(paramString);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.sendMessage(paramString, paramBundle);
  }
  
  public boolean a()
  {
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  public boolean a(Context paramContext)
  {
    if (this.b) {}
    int m;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("XProxy_Perf", 2, "开始预加载Now插件 time = " + System.currentTimeMillis());
      }
      StoryReportor.a("now_live", "preload", 0, 0, new String[] { "" });
      m = NetworkUtil.a(paramContext);
    } while ((m != 1) && (m != 4));
    this.e = 1;
    g();
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.updatePluginAndPreInstall();
    return true;
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, Bundle paramBundle)
  {
    QLog.i("XProxy_Perf", 2, "开始启动Now插件 time = " + System.currentTimeMillis());
    this.e = 3;
    g();
    IVPluginInfo localIVPluginInfo = new IVPluginInfo();
    int m = (int)(Math.random() * 1.0D + 0.5D);
    if (paramBundle != null) {}
    for (String str1 = paramBundle.getString("storyid");; str1 = "") {
      for (;;)
      {
        try
        {
          ArrayList localArrayList = paramListNameData.jdField_a_of_type_JavaUtilArrayList;
          String str2;
          StringBuilder localStringBuilder;
          localException1.printStackTrace();
        }
        catch (Exception localException1)
        {
          try
          {
            str2 = (String)localArrayList.get(paramListNameData.jdField_a_of_type_Int);
            localStringBuilder = new StringBuilder("roomnow://openpage/anchor?");
            localStringBuilder.append("roomid=").append(paramLong).append("&listname=").append(str2).append("&topicname=").append(str2).append("&from=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a).append("&storyid=").append(str1).append("&bizfrom=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b).append("&qqversion=").append(String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext())));
            localIVPluginInfo.mScheme = localStringBuilder.toString();
            localIVPluginInfo.mRoomId = paramLong;
            localIVPluginInfo.loadingDrawableIndex = m;
            localIVPluginInfo.mFromId = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a;
            this.jdField_a_of_type_AndroidOsBundle = paramBundle;
            localIVPluginInfo.mLoginAppId = "1600000615";
            localIVPluginInfo.mPackageName = "com.tencent.now";
            localIVPluginInfo.mPluginid = "Live";
            this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = localIVPluginInfo;
            paramBundle = new Intent(BaseApplicationImpl.getContext(), NowLoadingActivity.class);
            if ((localArrayList != null) && (localArrayList.size() > 0))
            {
              if (this.jdField_a_of_type_AndroidOsBundle == null) {
                this.jdField_a_of_type_AndroidOsBundle = new Bundle();
              }
              this.jdField_a_of_type_AndroidOsBundle.putSerializable("listnames", localArrayList);
              this.jdField_a_of_type_AndroidOsBundle.putInt("listname_index", paramListNameData.jdField_a_of_type_Int);
            }
            if (this.jdField_a_of_type_AndroidOsBundle != null) {
              paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
            }
            paramBundle.putExtra("plugininfo", this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo);
            paramBundle.addFlags(268435456);
            if (QLog.isColorLevel()) {
              QLog.i("XProxy_Perf", 4, "开始跳转loading界面 time = " + System.currentTimeMillis());
            }
            BaseApplicationImpl.getContext().startActivity(paramBundle);
            return true;
          }
          catch (Exception localException2)
          {
            String str3;
            for (;;) {}
          }
          localException1 = localException1;
          localArrayList = null;
        }
        str3 = "";
      }
    }
  }
  
  public boolean a(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    this.b = true;
    if (paramNowFromData == null) {
      paramNowFromData = new NowFromData();
    }
    for (;;)
    {
      NowPerfUtil.a("NowPrxoy begin to runNowPlugin");
      QLog.i("XProxy_Perf", 2, "开始进入now结合版,time = " + System.currentTimeMillis() + " roomid = " + paramLong + "ListNames = " + paramListNameData + "jumpFirst = " + paramInt + "fromidForDataReport = " + paramNowFromData.a + "bizFromId = " + paramNowFromData.b);
      StoryReportor.a("now_live", "run_now_plugin", 0, paramInt, new String[] { paramNowFromData.b, paramNowFromData.a });
      return b(paramListNameData, paramLong, paramNowFromData, paramInt, paramBundle);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)localIterator.next();
      if (localIVPluginEvtListener != null)
      {
        QLog.i("XProxy|NowProxy", 2, "notifyNowRoomDestroyed");
        localIVPluginEvtListener.b("Live");
      }
    }
  }
  
  public void b(IVPluginEvtListener paramIVPluginEvtListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramIVPluginEvtListener);
  }
  
  public boolean b(Context paramContext)
  {
    if (this.b) {}
    int m;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("XProxy_Perf", 2, "开始预登录Now插件 time = " + System.currentTimeMillis());
      }
      StoryReportor.a("now_live", "prelogin", 0, 0, new String[] { "" });
      m = NetworkUtil.a(paramContext);
    } while ((m != 1) && (m != 4));
    this.e = 2;
    g();
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.loadPlugin();
    return true;
  }
  
  public boolean b(NowProxy.ListNameData paramListNameData, long paramLong, NowFromData paramNowFromData, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData = paramNowFromData;
    if (!NetworkUtil.h(BaseApplicationImpl.getContext())) {
      Toast.makeText(BaseApplicationImpl.getContext(), "当前网络不可用，请稍候再试", 0);
    }
    g();
    if (paramInt == 3) {
      a(paramLong, null);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("XProxy_Perf", 2, "开始拉取撑量开关 time = " + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), paramLong, new svz(this, paramLong, paramNowFromData, paramInt, paramListNameData, paramBundle));
    }
  }
  
  protected void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.unload(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.removeListener(this.jdField_a_of_type_ComTencentTxproxyXEventListener);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void d()
  {
    StoryReportor.a("now_live", "jump_plugin", 0, 0, new String[] { "" });
    RunPluginParams localRunPluginParams = new RunPluginParams();
    localRunPluginParams.mRoomId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mRoomId;
    localRunPluginParams.mFromId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mFromId;
    localRunPluginParams.mPackageName = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mPackageName;
    localRunPluginParams.useDefaultLoading = false;
    localRunPluginParams.vasSchema = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mScheme;
    localRunPluginParams.mLauncherName = "com.tencent.litelive.module.videoroom.RoomActivity";
    Intent localIntent1 = this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a().a;
    Intent localIntent2 = new Intent();
    if (localIntent1 != null)
    {
      localIntent2.putExtra("withlogin", true);
      localIntent2.putExtras(localIntent1.getExtras());
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localIntent2.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    localIntent2.putExtra("bkgid", this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.loadingDrawableIndex);
    localRunPluginParams.intent = localIntent2;
    if ((!this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b.equals("story")) && (this.jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity != null))
    {
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.getPluginActivity(this.jdField_a_of_type_ComSixgodPluginsdkComponentContainerActivity, "com.tencent.litelive.module.videoroom.RoomActivity", localIntent2);
      return;
    }
    NowPerfUtil.b("loading activity show finish");
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.runPlugin(localRunPluginParams);
  }
  
  public void e()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "exitNowPlugin");
    }
    c();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\NowPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */