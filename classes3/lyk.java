import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lyk
  implements View.OnClickListener
{
  public lyk(Now paramNow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!Now.a(this.a).a())
    {
      Now.a(this.a).a(1);
      Now.a(this.a).a("请检查你的网络后重试");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */