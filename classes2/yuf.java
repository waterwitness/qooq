import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.weiyun.sdk.Global.HostInterface;
import mqq.app.AppRuntime;

public final class yuf
  implements Global.HostInterface
{
  public yuf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getAppName()
  {
    return "mobileqq";
  }
  
  public long getUin()
  {
    return Long.valueOf(BaseApplicationImpl.a().a().getAccount()).longValue();
  }
  
  public String getVersionCode()
  {
    return RichMediaUtil.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yuf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */