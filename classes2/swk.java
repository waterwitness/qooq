import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;
import com.tencent.mobileqq.intervideo.od.ODDownloader;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.XEventListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class swk
  implements XEventListener
{
  public swk(ODProxy paramODProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDataReport(String paramString, Bundle paramBundle) {}
  
  public void onDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    new ODDownloader(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString1, paramString2, paramHostEventListener);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString1.next();
      if (localWeakReference.get() != null) {
        ((IVPluginEvtListener)localWeakReference.get()).a("Od", paramInt, paramString2);
      }
    }
  }
  
  public void onGetPluginActivity(Activity paramActivity) {}
  
  public void onLog(String paramString1, String paramString2, int paramInt) {}
  
  public void onOpenRoom(String paramString) {}
  
  public void onPluginLoaded(String paramString) {}
  
  public void onPluginRun(String paramString)
  {
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString.next();
      if (localWeakReference.get() != null) {
        ((IVPluginEvtListener)localWeakReference.get()).a("Od");
      }
    }
  }
  
  public void onPreInstallFinish(String paramString1, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void onProgress(String paramString, int paramInt)
  {
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramString.next();
      if (localWeakReference.get() != null) {
        ((IVPluginEvtListener)localWeakReference.get()).a("Od", paramInt);
      }
    }
  }
  
  public void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2)
  {
    if (paramUnZipSoListener != null) {
      paramUnZipSoListener.onUnZipComplete(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */