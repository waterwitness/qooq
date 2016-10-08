import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;

public class lbj
  implements Runnable
{
  public lbj(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((QzoneContactsFeedManager)this.a.a.getManager(90)).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */