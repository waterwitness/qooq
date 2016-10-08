import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqp
  implements View.OnClickListener
{
  public iqp(QQStoryMainActivity paramQQStoryMainActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    StoryReportor.a("hall", "clk_entry", 0, 0, new String[0]);
    paramView = new Intent(this.a, QQStoryDiscoverActivity.class);
    paramView.putExtra("key_from", 2);
    QQStoryMainActivity.a(this.a, paramView, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */