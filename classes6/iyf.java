import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyf
  implements TextView.OnEditorActionListener
{
  public iyf(QQStoryAddVideoLabelViewPart paramQQStoryAddVideoLabelViewPart)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      paramTextView = this.a.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (paramTextView != null) {
        paramTextView.onClick(this.a.jdField_a_of_type_AndroidWidgetTextView);
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */