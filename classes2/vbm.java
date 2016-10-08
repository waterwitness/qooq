import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import java.util.TimerTask;

public final class vbm
  extends TimerTask
{
  public vbm(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RichMediaUtil.a(this.a, false, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */