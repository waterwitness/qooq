import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pdr
  implements Runnable
{
  pdr(pdn parampdn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.m();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */