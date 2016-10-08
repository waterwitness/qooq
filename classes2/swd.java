import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.SevenZip;
import com.tencent.mobileqq.intervideo.now.JumpConfigUpdater;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPerfUtil;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.intervideo.od.ODDownloader;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.XEventListener;
import java.util.Iterator;
import java.util.List;

public class swd
  implements XEventListener
{
  public swd(NowPlugin paramNowPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDataReport(String paramString, Bundle paramBundle) {}
  
  public void onDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    new ODDownloader(NowPlugin.a(this.a)).a(paramString1, paramString2, paramHostEventListener);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2)
  {
    StoryReportor.a("now_live", "now_plugin_error", 0, paramInt, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b, paramString2, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a });
    paramString1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString1.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live", paramInt, paramString2);
      }
    }
  }
  
  public void onGetPluginActivity(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "onGetPluginActivity activity  = " + paramActivity);
    }
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)localIterator.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a(paramActivity);
      }
    }
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 1: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 2: 
      QLog.i(paramString1, 2, paramString2);
      return;
    }
    QLog.e(paramString1, 2, paramString2);
  }
  
  public void onOpenRoom(String paramString) {}
  
  public void onPluginLoaded(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "Now插件加载完成，当前RequestCode = " + this.a.e);
    }
    NowPerfUtil.b("Nowproxy load plugin finish");
    if (this.a.e == 2) {
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater.a(NowPlugin.a(this.a), BaseApplicationImpl.getContext(), 0L, new swe(this));
    }
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.c("Live");
      }
    }
  }
  
  public void onPluginRun(String paramString)
  {
    StoryReportor.a("now_live", "now_plugin_run", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a });
    NowPerfUtil.b("NowProxy start plugin activity finish");
    new Handler().postDelayed(new swg(this), 11000L);
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live");
      }
    }
    this.a.b = false;
  }
  
  public void onPreInstallFinish(String paramString1, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void onProgress(String paramString, int paramInt)
  {
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)paramString.next();
      if (localIVPluginEvtListener != null) {
        localIVPluginEvtListener.a("Live", paramInt);
      }
    }
  }
  
  public void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramString2.equals("login.qq.kickout"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|NowProxy", 2, "收到Now被踢下线的广播");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(NowPlugin.a(this.a).getAccount(), this.a.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mPluginid, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mPackageName, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.mLoginAppId, null, true);
    }
    for (;;)
    {
      Object localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IVPluginEvtListener localIVPluginEvtListener = (IVPluginEvtListener)((Iterator)localObject).next();
        if (localIVPluginEvtListener != null) {
          localIVPluginEvtListener.a(paramString1, paramString2, paramBundle);
        }
      }
      if (paramString2.equals("com.tencent.now.sharetoqq"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy|NowProxy", 2, "收到分享到ＱＱ的广播");
        }
        localObject = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
        ((Intent)localObject).addFlags(268435456);
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        ((Intent)localObject).putExtra("uin", NowPlugin.a(this.a).f());
        if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
          ((Intent)localObject).putExtras(this.a.jdField_a_of_type_AndroidOsBundle);
        }
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
      }
      else if (paramString2.equals("now.room.destroy"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy|NowProxy", 2, "收到Now Destroy的消息");
        }
        this.a.b();
      }
    }
  }
  
  public void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "onUnZipSo soPath  = " + paramString2);
    }
    boolean bool = SevenZip.a(BaseApplicationImpl.getContext(), paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|NowProxy", 2, "onUnZipSo res   = " + bool);
    }
    if (paramUnZipSoListener != null) {
      paramUnZipSoListener.onUnZipComplete(bool);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */