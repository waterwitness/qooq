import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class iwk
  implements ActionSheet.OnButtonClickListener
{
  public iwk(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      NewStoryTakeVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, true);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.k) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.l = true;
      }
      SLog.b("face", "click left hasChangeCamera" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.k);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.m();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */