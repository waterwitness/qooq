import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import cooperation.troop_homework.jsp.TroopHWVoiceController;
import cooperation.troop_homework.jsp.TroopHWVoiceController.RecordCallback;
import java.lang.ref.WeakReference;

public class yuc
  extends Handler
{
  public yuc(TroopHWVoiceController paramTroopHWVoiceController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (TroopHWVoiceController.a(this.a) != null) {
            TroopHWVoiceController.a(this.a).a(1, TroopHWVoiceController.a(this.a));
          }
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
        this.a.c(paramMessage);
        TroopHWVoiceController.a(this.a, paramMessage);
        return;
        TroopHWVoiceController.a(this.a).c();
        AudioUtil.b(2131165201, false);
      } while (this.a.a == null);
      paramMessage = (Context)this.a.a.get();
    } while (paramMessage == null);
    AudioUtil.a(paramMessage, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */