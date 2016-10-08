import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallProxy;

public class uaf
  implements Runnable
{
  public uaf(QCallProxy paramQCallProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.d();
    QCallProxy.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */