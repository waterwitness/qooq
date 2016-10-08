import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class giz
  implements Runnable
{
  public giz(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null)
    {
      SessionInfo localSessionInfo = SessionMgr.a().a(this.a.e);
      if (localSessionInfo != null)
      {
        localSessionInfo.a.f = true;
        if (this.a.a.j() == 1) {}
        GuildMultiActivity.a(this.a, true);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\giz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */