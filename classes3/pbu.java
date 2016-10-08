import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.MqqWeakReferenceHandler;

public class pbu
  extends BroadcastReceiver
{
  public pbu(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if ((paramIntent != null) && (paramIntent.getAction().equals("action_music_info_js_to_qzone"))) {
      if (paramIntent.getIntExtra("key_is_paly_music", 0) != 1) {
        break label108;
      }
    }
    for (;;)
    {
      paramContext = paramIntent.getStringExtra("key_music_url");
      NewFlowCameraActivity.g(this.a, paramIntent.getStringExtra("key_song_id"));
      NewFlowCameraActivity.h(this.a, paramIntent.getStringExtra("key_song_interval"));
      if (i == 0) {
        break;
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        paramIntent = new Message();
        paramIntent.what = 1006;
        paramIntent.obj = paramContext;
        this.a.a.sendMessage(paramIntent);
      }
      return;
      label108:
      i = 0;
    }
    this.a.a.sendEmptyMessage(1007);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */