import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pdq
  implements Runnable
{
  pdq(pdn parampdn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */