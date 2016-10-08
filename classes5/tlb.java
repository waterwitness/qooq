import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.OnLoadListener;

public class tlb
  implements URLDrawableDownListener
{
  public tlb(PicBrowserImage paramPicBrowserImage, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 10000)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.b(this.jdField_a_of_type_Int, paramInt / 100);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */