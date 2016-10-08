import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.biz.ui.PopupMenu;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfv
  implements View.OnClickListener
{
  public jfv(PopupMenu paramPopupMenu, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiPopupMenu.a != null) {
      this.jdField_a_of_type_ComTencentBizUiPopupMenu.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2);
    }
    paramView.post(new jfw(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */