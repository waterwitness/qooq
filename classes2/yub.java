import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWVoiceController;

public class yub
  implements Runnable
{
  public yub(TroopHWVoiceController paramTroopHWVoiceController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = TroopHomeworkHelper.a(TroopHWVoiceController.a(this.a));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = TroopHWVoiceController.a(this.a).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */