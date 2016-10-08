import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ryl
  extends ryd
{
  public ryl(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = true;
    this.b = true;
  }
  
  protected String a()
  {
    return "StateEnd";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ryl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */