import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nni
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nni(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() > 2)
    {
      String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      str = str.substring(0, str.lastIndexOf("的日迹")).substring(0, this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(1) - QQStoryCommentItemBuilder.l - 2);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str + "…" + "的日迹");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setLines(2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */