import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWServiceProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyu
  implements IBinder.DeathRecipient
{
  public iyu(RMWServiceProxy paramRMWServiceProxy, ComponentName paramComponentName)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void binderDied()
  {
    RMWLog.c("RMWServiceProxy", "binderDied, delay 1s then reconnect");
    RMWServiceProxy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoRmwRMWServiceProxy, this.jdField_a_of_type_AndroidContentComponentName);
    new Handler(Looper.getMainLooper()).postDelayed(new iyv(this), 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */