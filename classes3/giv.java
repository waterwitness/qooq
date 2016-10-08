import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class giv
  implements Runnable
{
  public giv(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.a, 2, "updateMemInStage refresh");
    }
    GuildMultiActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\giv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */