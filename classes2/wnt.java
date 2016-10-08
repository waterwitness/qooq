import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PublicMenuBar;

public class wnt
  implements View.OnClickListener
{
  public wnt(PublicMenuBar paramPublicMenuBar, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (PublicMenuBar.a(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar) != null) {
      PublicMenuBar.b(this.jdField_a_of_type_ComTencentMobileqqWidgetPublicMenuBar).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */