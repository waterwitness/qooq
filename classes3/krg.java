import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.activity.book.ResizeLayout;
import com.tencent.mobileqq.activity.book.ResizeLayout.OnResizeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class krg
  implements ResizeLayout.OnResizeListener
{
  public krg(BookShareAdviceEditActivity paramBookShareAdviceEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Math.abs(paramInt2 - paramInt4) < DisplayUtil.a(this.a, 100.0F)) {}
    do
    {
      return;
      if (paramInt2 - paramInt4 < 0)
      {
        this.a.a(true);
        return;
      }
    } while (paramInt2 - paramInt4 <= 0);
    this.a.a(false);
    this.a.a.post(new krh(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */