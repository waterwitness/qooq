import android.view.View;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

public class te
  implements Runnable
{
  public te(ETTextView paramETTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.getTag(2131296654) != null) {}
    for (boolean bool = ((Boolean)this.a.getTag(2131296654)).booleanValue();; bool = false)
    {
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick != null) && (!bool))
      {
        Object localObject = ETTextView.a(this.a).a(this.a.c, this.a.d);
        if ((localObject instanceof QQText.SmallEmojiSpan))
        {
          localObject = (QQText.SmallEmojiSpan)localObject;
          this.a.jdField_a_of_type_Int = ((QQText.SmallEmojiSpan)localObject).f;
          this.a.b = ((QQText.SmallEmojiSpan)localObject).g;
          if (QLog.isColorLevel()) {
            QLog.d("ETTextView", 2, "click span: " + this.a.jdField_a_of_type_Int);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick.a(this.a);
      }
      this.a.setTag(2131296654, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\te.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */