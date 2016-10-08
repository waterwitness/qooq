import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilx
  implements View.OnClickListener
{
  public ilx(ContentEmptyView paramContentEmptyView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = ((QQStoryContentActivity)this.a.getContext()).app;
    InfoCardDialog localInfoCardDialog = new InfoCardDialog(this.a.getContext(), paramView);
    if (this.a.b != null) {}
    for (paramView = this.a.b;; paramView = this.a.a)
    {
      localInfoCardDialog.a(paramView, true, 5);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */