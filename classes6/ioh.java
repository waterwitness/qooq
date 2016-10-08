import android.view.View;
import com.tencent.biz.qqstory.network.handler.ReportEvilHandler;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ioh
  implements ActionSheet.OnButtonClickListener
{
  public ioh(StoryPlayVideoActivity paramStoryPlayVideoActivity, String paramString, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    new ReportEvilHandler().a(this.jdField_a_of_type_JavaLangString, paramInt + 1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.P);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */