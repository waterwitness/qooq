import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gjh
  implements DialogInterface.OnClickListener
{
  public gjh(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a(this.a.e);
    if (localSessionInfo != null)
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", localSessionInfo.a.f);
      this.a.startActivity(localIntent);
      this.a.a(localSessionInfo, 1);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */