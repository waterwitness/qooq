import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.hotspotnode.QQHotSpotListHandler.Callback;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;
import cooperation.qqhotspot.hotspotnode.protocol.pbsrc.APNodeCheckResult;
import java.io.Serializable;
import java.util.Map;

public class yht
  implements QQHotSpotListHandler.Callback
{
  public yht(ShowNodeTaskManager paramShowNodeTaskManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, APNodeCheckResult paramAPNodeCheckResult, Serializable paramSerializable)
  {
    if (paramBoolean)
    {
      this.a.a(paramAPNodeCheckResult, (Map)paramSerializable);
      return;
    }
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */