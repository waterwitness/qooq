import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.StoryRecordButtonAnimationView;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lyo
  implements View.OnClickListener
{
  public lyo(Now paramNow)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("first_time_pic", Boolean.valueOf(false));
    this.a.c = false;
    this.a.a.a();
    this.a.a.setVisibility(8);
    this.a.a(true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */