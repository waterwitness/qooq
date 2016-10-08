import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;

public class uab
  extends DiscussionObserver
{
  public uab(QCallFacade paramQCallFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    this.a.b(paramString, 3000);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */