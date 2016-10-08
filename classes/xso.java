import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;

public class xso
  implements Runnable
{
  private xso(AdapterView paramAdapterView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.r)
    {
      if (this.a.a() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterView.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */