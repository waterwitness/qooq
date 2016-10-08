import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;

public class uhr
  implements Runnable
{
  public uhr(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SignatureManager localSignatureManager = (SignatureManager)this.a.app.getManager(57);
    this.a.a(localSignatureManager.a.a, this.a.p);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */