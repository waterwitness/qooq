import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class gyy
  extends BroadcastReceiver
{
  public gyy(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    paramContext = paramIntent.getStringExtra("camera_id");
    int i = paramIntent.getIntExtra("availability", 1);
    if (QLog.isColorLevel()) {
      QLog.d("VideoControlUI", 2, "update camera availability status cameraId:" + paramContext + ", value:" + i);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramContext, i);
    if (i == 0)
    {
      VideoControlUI.a(this.a, false);
      return;
    }
    paramContext = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.entrySet().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        VideoControlUI.a(this.a, false);
        return;
      }
      VideoControlUI.a(this.a, true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */