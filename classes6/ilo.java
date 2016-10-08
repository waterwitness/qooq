import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilo
  implements View.OnClickListener
{
  public ilo(BaseContentPagerView paramBaseContentPagerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new InfoCardDialog(this.a.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user, 3);
    this.a.c = true;
    paramView.setOnDismissListener(new ilp(this));
    StoryReportor.a("play_page_share", "clk_card", ((QQStoryContentActivity)this.a.getContext()).g, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */