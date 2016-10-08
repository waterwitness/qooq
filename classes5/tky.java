import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter;

public class tky
  implements Runnable
{
  public tky(PicBrowserGalleryAdapter paramPicBrowserGalleryAdapter, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PicBrowserGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */