import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.SparkDot;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class giy
  implements Runnable
{
  public giy(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SessionMgr.a().a(this.a.e).a.b == 5)
    {
      this.a.a.b();
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\giy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */