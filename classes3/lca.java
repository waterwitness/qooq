import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lca
  implements Runnable
{
  lca(lbz paramlbz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ARDeviceController.a().a(Conversation.a(this.a.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */