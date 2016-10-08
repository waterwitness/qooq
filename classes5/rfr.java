import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class rfr
  implements Runnable
{
  public rfr(HotChatFlashPicActivity paramHotChatFlashPicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(HotChatFlashPicActivity.f(this.a), 4).edit();
    if (HotChatFlashPicActivity.b(this.a))
    {
      localEditor.putInt("HOTCHAT_FLASHPIC_SHOT", HotChatFlashPicActivity.a(this.a));
      if (HotChatFlashPicActivity.a(this.a) != 1) {
        break label115;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X800597A", "0X800597A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putInt("commen_flashpic_shot", HotChatFlashPicActivity.a(this.a));
      break;
      label115:
      if (HotChatFlashPicActivity.a(this.a) == 2)
      {
        if (!HotChatFlashPicActivity.b(this.a)) {
          localEditor.putLong("commen_flashpic_shot_deadlineday", HotChatFlashPicActivity.b(this.a) + 518400000L);
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800597B", "0X800597B", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */