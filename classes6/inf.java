import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryVideoDes;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class inf
  implements Runnable
{
  public inf(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b.setVisibility(8);
    this.a.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.a.jdField_a_of_type_AndroidWidgetSeekBar.getMax());
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    if ((this.a.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.a.jdField_c_of_type_Long > 0L))
    {
      VideoContentView localVideoContentView = this.a;
      localVideoContentView.d += System.currentTimeMillis() - this.a.jdField_c_of_type_Long;
      if (this.a.d > 0L)
      {
        StoryReportor.a("play_page_video", "time", ((QQStoryContentActivity)this.a.getContext()).g, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.a.d + "", this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
        StoryReportor.a(this.a.jdField_a_of_type_Int, 1, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), 3, this.a.e, this.a.d, VideoContentView.a(this.a), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
        this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 4);
        this.a.d = 0L;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */