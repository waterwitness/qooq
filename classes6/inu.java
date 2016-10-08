import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.view.VideoCoverView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class inu
  implements View.OnClickListener
{
  inu(int paramint)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    StoryReportor.b("story_play", "cover_video_play", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.a(), StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.getContext().getApplicationContext()), "", this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.b() });
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 6");
    }
    VideoCoverView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView, true);
    StoryReportor.a("play_page_title", "retry", this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity.g, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.getContext()), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewVideoCoverView.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */