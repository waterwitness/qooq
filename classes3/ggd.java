import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggd
  extends BroadcastReceiver
{
  public ggd(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a() != null) && (paramIntent != null))
    {
      this.a.a(paramIntent.getStringExtra("camera_id"), paramIntent.getIntExtra("availability", 1));
      if (QLog.isColorLevel()) {
        QLog.d(VideoAppInterface.a, 2, "update camera availability status cameraId:" + paramIntent.getStringExtra("camera_id") + ", value:" + paramIntent.getIntExtra("availability", 1));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */