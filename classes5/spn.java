import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.freshnews.FreshNewsDragGridView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spn
  implements ViewTreeObserver.OnPreDrawListener
{
  public spn(FreshNewsDragGridView paramFreshNewsDragGridView, ViewTreeObserver paramViewTreeObserver, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver.removeOnPreDrawListener(this);
    FreshNewsDragGridView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView, FreshNewsDragGridView.c(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView), this.jdField_a_of_type_Int);
    FreshNewsDragGridView.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDragGridView, this.jdField_a_of_type_Int);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */