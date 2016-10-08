import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class oag
  implements ActionSheet.OnButtonClickListener
{
  public oag(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.Y) {
      return;
    }
    this.a.Y = true;
    if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.a.r(2131364484);
      paramInt = this.a.jdField_a_of_type_ArrayOfInt[0];
      if (paramInt == 0) {
        this.a.a(true, 0);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.a.a(false, paramInt);
      continue;
      this.a.r(2131364484);
      this.a.a(true, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */