import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imz
  implements DialogInterface.OnClickListener
{
  public imz(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.g = true;
    this.a.m = true;
    this.a.q();
    this.a.c.setVisibility(8);
    paramDialogInterface = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    if (!this.a.jdField_a_of_type_AndroidWidgetImageButton.isSelected()) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.setSelected(bool);
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      StoryReportor.a("play_page_video", "play", ((QQStoryContentActivity)this.a.getContext()).g, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", StoryReportor.a(this.a.getContext()) });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */