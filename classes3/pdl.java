import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

class pdl
  implements Runnable
{
  pdl(pdk parampdk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(pdk.a, 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
    }
    Toast.makeText(VideoEnvironment.a(), "视频缓存被恶意篡改了", 1).show();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(pdk.a);
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.l();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */