import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.OnSegmentDataChangeListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.StoryHomeAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ito
  implements MystoryListView.OnSegmentDataChangeListener
{
  public ito(MystoryListView paramMystoryListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("offical_recommend")))
    {
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("needShowTitle");
        this.a.a.a("OfficialRecommendTitle", bool);
      }
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ito.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */