import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.NewStoryViewController;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ius
  implements DialogInterface.OnDismissListener
{
  public ius(NewStoryDoodle paramNewStoryDoodle, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    NewStoryDoodle.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle).setViewActive(this.jdField_a_of_type_AndroidViewView, true);
    NewStoryDoodle.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle).setAllViewsActive(true);
    NewStoryDoodle.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle).setLeftBackIcon(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a.a.a.n();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ius.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */