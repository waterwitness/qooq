import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gzs
  extends BroadcastReceiver
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "reason";
  public static final int b = 1;
  static final String b = "homekey";
  public static final int c = 2;
  static final String c = "rencentkeys";
  private int d;
  
  public gzs(VideoInviteFull paramVideoInviteFull, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Int = -1;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    switch (this.jdField_d_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (!paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            paramContext = paramIntent.getStringExtra("reason");
          } while (paramContext == null);
          TraeHelper.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        } while (!paramContext.equals("homekey"));
        if (this.a.b)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004399", "0X8004399", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80043F8", "0X80043F8", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
        return;
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      this.a.c = true;
      paramContext = new Intent(this.a, VideoInviteLock.class);
      paramContext.addFlags(268435456);
      paramContext.putExtra("uinType", this.a.e);
      paramContext.putExtra("peerUin", this.a.jdField_d_of_type_JavaLangString);
      paramContext.putExtra("extraUin", this.a.f);
      paramContext.putExtra("isAudioMode", this.a.b);
      paramContext.putExtra("curUserStatus", this.a.jdField_d_of_type_Int);
      paramContext.putExtra("powerKey", this.a.c);
      paramContext.putExtra("isDoubleVideoMeeting", this.a.h);
      this.a.startActivity(paramContext);
      this.a.finish();
      return;
      paramContext = paramIntent.getStringExtra("selfUin");
      paramIntent = paramIntent.getStringExtra("sendUin");
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "recv cancel video request");
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null) && ((!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(paramContext)) || (!paramIntent.equals(this.a.jdField_d_of_type_JavaLangString))));
    if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gzt(this));
      return;
    }
    VideoInviteFull.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */