import android.view.View;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.TipsView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class inc
  implements Runnable
{
  public inc(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TipsView.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidWidgetButton, "订阅成功，新日迹将在首页优先展示。", 1, 1, -this.a.b.getWidth());
    StoryReportor.a("new_guide", "video", this.a.jdField_a_of_type_Int, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */