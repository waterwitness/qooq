import android.view.View;
import com.tencent.bitapp.BitAppViewGroup;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hdw
  extends URLDrawableDownListener.Adapter
{
  long jdField_a_of_type_Long;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public hdw(BitAppViewGroup paramBitAppViewGroup, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBitAppViewGroup);
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (BitAppViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BitAppViewGroup", 4, "DrawableListener - onLoadFailed ... msg: " + paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp + "[" + this.jdField_a_of_type_Long + "]");
      }
    } while (paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq != this.jdField_a_of_type_Long);
    paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(BitAppViewGroup.b);
    paramView.setBackgroundDrawable(BitAppViewGroup.c);
    paramView.f();
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (BitAppViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramView == null) || (paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BitAppViewGroup", 4, "DrawableListener - onLoadSuccessed ... msg: " + paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp + "[" + this.jdField_a_of_type_Long + "]");
      }
    } while (paramView.jdField_a_of_type_ComTencentBitappMessageForBitApp.uniseq != this.jdField_a_of_type_Long);
    paramView.f();
    paramView.j();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */