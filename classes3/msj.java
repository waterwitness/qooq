import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class msj
  implements URLDrawable.URLDrawableListener
{
  public msj(TroopMemberCardActivity paramTroopMemberCardActivity, int paramInt, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c = false;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c = false;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable);
    if (paramURLDrawable != null)
    {
      Bitmap localBitmap = ImageUtil.b(paramURLDrawable, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getApplicationContext(), 5.0F), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c = true;
      }
      paramURLDrawable.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */