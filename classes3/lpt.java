import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

public class lpt
  implements Runnable
{
  public lpt(JoinDiscussionActivity paramJoinDiscussionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str1 = StringUtil.a(this.a.c, 0, 32);
    String str2 = StringUtil.a(this.a.e, 0, 32);
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + String.format("(%d人)", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(str2 + " 创建于 " + DateFormat.format("yy-M-d", this.a.jdField_b_of_type_Long));
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */