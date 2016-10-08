import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.music.MusicComposeDialog;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iyi
  extends BroadcastReceiver
{
  public iyi(MusicComposeDialog paramMusicComposeDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic"))) {}
    }
    while (!"action_music_start".equals(paramContext))
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "onReceive:" + paramContext);
        }
      } while (TextUtils.isEmpty(paramContext));
      paramContext = new QQStoryMusicInfo(paramContext);
      this.a.b();
      this.a.a(paramContext);
      return;
    }
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */