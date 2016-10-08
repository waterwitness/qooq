import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uhl
  implements Runnable
{
  public uhl(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app != null) {
      ((SignatureManager)this.a.app.getManager(57)).a(true, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */