import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gue
  extends BroadcastReceiver
{
  public gue(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName()))) {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
      }
    }
    int i;
    long l;
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("tencent.av.v2q.StopVideoChat"));
      i = paramIntent.getIntExtra("stopReason3rd", -1);
      l = paramIntent.getLongExtra("groupId", -1L);
    } while ((i != 1) || (this.a.jdField_a_of_type_Long != l));
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "ACTION_STOP_VIDEO_CHAT");
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */