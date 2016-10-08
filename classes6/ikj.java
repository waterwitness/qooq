import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ikj
  implements View.OnClickListener
{
  ikj(ikf paramikf, Story paramStory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ikf.a.finish();
    StoryReportor.a("play_page_title", "close", this.jdField_a_of_type_Ikf.a.g, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", StoryReportor.a(this.jdField_a_of_type_Ikf.a) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */