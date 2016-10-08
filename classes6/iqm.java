import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.StoryRecordButtonAnimationView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqm
  implements View.OnClickListener
{
  public iqm(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("first_time_pic", Boolean.valueOf(false));
    this.a.b = false;
    this.a.a.a();
    this.a.a.setVisibility(8);
    this.a.a(true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */