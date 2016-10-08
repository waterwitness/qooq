import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.OfficialRecommendListView.OnOverScrollRightListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.OfficialRecommendSegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iub
  implements OfficialRecommendListView.OnOverScrollRightListener
{
  public iub(OfficialRecommendSegment paramOfficialRecommendSegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    StoryReportor.a("recommend", "slide_left", 0, 0, new String[0]);
    Intent localIntent = new Intent(this.a.a, QQStoryDiscoverActivity.class);
    localIntent.putExtra("key_from", 1);
    ((Activity)this.a.a).startActivityForResult(localIntent, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */