import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;

public class uaa
  extends FriendListObserver
{
  public uaa(QCallFacade paramQCallFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    this.a.a(String.valueOf(paramObject));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */