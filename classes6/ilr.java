import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ilr
  implements View.OnClickListener
{
  public ilr(BaseContentPagerView paramBaseContentPagerView, UserInfo paramUserInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j;
    String str1;
    int i;
    label91:
    String str2;
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.getContext()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.b = true;
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      j = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type;
      str1 = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_Boolean)
      {
        i = 1;
        paramView.a(j, str1, i, 1);
        this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_AndroidWidgetButton.postDelayed(new ils(this), 1000L);
        i = ((QQStoryContentActivity)this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.getContext()).g;
        j = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType;
        str1 = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId();
        str2 = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.jdField_a_of_type_Boolean) {
          break label212;
        }
      }
    }
    label212:
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("play_page_share", "follow", i, j, new String[] { str1, str2, paramView, "" });
      return;
      i = 0;
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.getContext(), "当前网络不可用，请检查你的网络设置", 0).a();
      break label91;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */