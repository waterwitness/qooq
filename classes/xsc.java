import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xsc
{
  private int a;
  
  private xsc(AbsListView paramAbsListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a = AbsListView.a(this.b);
  }
  
  public boolean a()
  {
    return (this.b.hasWindowFocus()) && (AbsListView.b(this.b) == this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xsc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */