import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.pgc.adapter.DiscoverAdapter;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryPostDes;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AnimationUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ikl
  implements AdapterView.OnItemClickListener
{
  public ikl(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if ((paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null) && (!this.a.d))
    {
      if (paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type != 3) {
        break label105;
      }
      if ((paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory != null) && (paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes != null))
      {
        paramView = new Intent(this.a, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url);
        this.a.startActivity(paramView);
      }
    }
    for (;;)
    {
      this.a.d = true;
      return;
      label105:
      Intent localIntent = new Intent(paramView.getContext(), QQStoryContentActivity.class);
      localIntent.putExtra("showTitleBar", false);
      localIntent.putExtra("showAnimation", true);
      localIntent.putExtra("need_image_animation", false);
      localIntent.putExtra("user_type", paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.type);
      localIntent.putExtra("user_unionid", paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId());
      localIntent.putExtra("come_from", 9);
      AnimationUtils.a(this.a, localIntent, paramView, 1, paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId());
      paramView.postDelayed(new ikm(this, paramView), 600L);
      this.a.c = false;
      StoryReportor.a("hall", "clk_detail", 0, paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.type, new String[] { paramAdapterView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId() });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */