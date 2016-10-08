import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqn
  implements View.OnClickListener
{
  public iqn(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a())
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.a(1);
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.a("请检查你的网络后重试");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */