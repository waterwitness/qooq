import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class nxh
  implements View.OnClickListener
{
  public nxh(DiscussChatPie paramDiscussChatPie, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie) != null) && (DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).isShowing())) {
      DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie.a = null;
    }
    DiscussChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDiscussChatPie, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */