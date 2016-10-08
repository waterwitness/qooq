import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryLabelList;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.InputMethodUtil;

public class ivk
  implements View.OnClickListener
{
  public ivk(NewStoryLabelList paramNewStoryLabelList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a()))
    {
      this.a.b = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a();
      paramView = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((paramView.equals("##")) || (TextUtils.isEmpty(paramView)) || (!paramView.equals("# " + this.a.b)))
      {
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y)
        {
          paramView = "2";
          StoryReportor.a("video_edit", "use_custom_tag", 0, 0, new String[] { paramView });
        }
      }
      else {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.b);
      }
    }
    for (;;)
    {
      InputMethodUtil.b(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a());
      this.a.a();
      return;
      paramView = "1";
      break;
      this.a.b = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */