import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.galleryactivity.UrlGalleryAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jlc
  extends URLDrawableDownListener.Adapter
{
  public jlc(UrlGalleryAdapter paramUrlGalleryAdapter, int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.b(this.jdField_a_of_type_Int, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, true);
    paramView = this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramURLDrawable.getURL(), this.jdField_a_of_type_AndroidViewViewGroup);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */