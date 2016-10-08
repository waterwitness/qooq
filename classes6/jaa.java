import com.tencent.biz.qqstory.view.widget.AbsEmptyView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jaa
  implements Runnable
{
  public jaa(AbsEmptyView paramAbsEmptyView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (AbsEmptyView.a(this.a) == 0) {
      AbsEmptyView.a(this.a, 3, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\jaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */