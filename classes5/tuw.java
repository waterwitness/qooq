import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.VipProfileCardDownLoadInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class tuw
  implements Runnable
{
  public tuw(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.b.set(1);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.mRuntime.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.mRuntime.a();
    if ((localObject1 == null) || (localObject2 == null)) {
      return;
    }
    Object localObject3 = ((Activity)localObject2).getApplicationContext();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) != null) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.d)) {
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
    }
    localObject2 = new tux(this);
    localObject3 = new File(ProfileCardUtil.c((Context)localObject3) + ProfileCardUtil.d(this.jdField_a_of_type_JavaLangString));
    localObject3 = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject3);
    ((DownloadTask)localObject3).f = "profileCardDownload";
    ((DownloadTask)localObject3).e = "VIP_profilecard";
    ((DownloadTask)localObject3).a = 1;
    if (WebpSoLoader.a() != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((DownloadTask)localObject3).j = bool;
      ((DownloadTask)localObject3).a((DownloadListener)localObject2);
      ProfileCardWebviewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin);
      int i = DownloaderFactory.a((DownloadTask)localObject3, (AppRuntime)localObject1);
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).f = Integer.valueOf(i);
      if (i == 0) {
        break;
      }
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.c;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.b.set(0);
      localObject1 = ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_b_of_type_JavaLangString;
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("result", i);
        ((JSONObject)localObject2).put("message", "httperr");
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a((String)localObject1, ((JSONObject)localObject2).toString());
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tuw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */