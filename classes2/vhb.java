import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

class vhb
  implements Runnable
{
  vhb(vha paramvha)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      return;
      this.a.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
    } while ((this.a.a.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(this.a.a.jdField_b_of_type_AndroidWidgetTextView.getText())));
    this.a.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */