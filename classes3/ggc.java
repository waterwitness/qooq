import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ggc
  extends BroadcastReceiver
{
  public ggc(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    long l;
    int i;
    boolean bool;
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
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "recv account broadcast: " + paramIntent.getAction());
                }
                if (!paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED")) {
                  break;
                }
                this.a.b();
                return;
              }
              catch (RuntimeException paramContext) {}
            } while (!QLog.isColorLevel());
            QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "RuntimeException", paramContext);
            return;
            if (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))
            {
              this.a.b();
              return;
            }
            if (paramIntent.getAction().equals("mqq.intent.action.LOGOUT"))
            {
              this.a.b();
              return;
            }
            if (paramIntent.getAction().equals("mqq.intent.action.EXIT_" + this.a.a().getPackageName()))
            {
              this.a.b();
              return;
            }
            if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) {
              break;
            }
          } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.e) {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.E, this.a.jdField_a_of_type_ComTencentAvVideoController.a, 0, new int[] { this.a.jdField_a_of_type_ComTencentAvVideoController.a().D });
          }
          if (QLog.isColorLevel()) {
            QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "ACTION_ACCOUNT_CHANGED, video process exit!");
          }
          this.a.b();
          return;
        } while (!"tencent.video.q2v.membersChange".equals(paramIntent.getAction()));
        l = paramIntent.getLongExtra("relationId", -1L);
        i = paramIntent.getIntExtra("relationType", 0);
        if (l != -1L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "can not get the right value");
      return;
      bool = paramIntent.getBooleanExtra("Exit", false);
      int j = paramIntent.getIntExtra("avtype", 0);
      this.a.a(new Object[] { Integer.valueOf(79), Long.valueOf(l), Boolean.valueOf(bool), Integer.valueOf(j) });
    } while (!bool);
    this.a.jdField_a_of_type_ComTencentAvVideoController.c(i, l);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */