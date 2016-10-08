import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class vcz
  extends BroadcastReceiver
{
  public vcz(AbsPublishActivity paramAbsPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("key_photo_delete_action".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("key_photo_delete_position", -1);
      this.a.a(i, 9);
    }
    do
    {
      return;
      if ("key_audio_delete_action".equals(paramContext))
      {
        this.a.a(0);
        this.a.a = null;
        TroopBarUtils.a(this.a.t, this.a.u, "del_record", this.a.v, this.a.c, "", "");
        return;
      }
    } while (!"key_audio_play_action".equals(paramContext));
    TroopBarUtils.a(this.a.t, this.a.u, "preview_record", this.a.v, this.a.c, "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */