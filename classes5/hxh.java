import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;

public final class hxh
  implements URLDrawable.URLDrawableListener
{
  public hxh(URLImageView paramURLImageView, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.b);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable);
    if (paramURLDrawable != null)
    {
      Bitmap localBitmap = ReadInJoyDisplayUtils.a(paramURLDrawable, paramURLDrawable.getWidth());
      paramURLDrawable.recycle();
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(localBitmap);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */