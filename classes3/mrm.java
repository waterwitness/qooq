import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class mrm
  implements URLDrawable.URLDrawableListener
{
  public mrm(TroopInfoActivity paramTroopInfoActivity, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.j();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.getString(2131369980), 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.getTitleBarHeight());
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.j();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.getString(2131369980), 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.getTitleBarHeight());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.j();
    int i = (int)(paramURLDrawable.getIntrinsicHeight() / this.jdField_a_of_type_Float);
    int j = (int)(paramURLDrawable.getIntrinsicWidth() / this.jdField_a_of_type_Float);
    if ((i < 100) || (j < 100))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.getString(2131365056));
      return;
    }
    TroopInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */