import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.OnLoadListener;

public class tlc
  implements Runnable
{
  public tlc(PicBrowserImage paramPicBrowserImage, URLDrawable paramURLDrawable, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLDrawable.getProgress());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */