import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jky
  implements Runnable
{
  public jky(GalleryManager paramGalleryManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager.c = false;
    GalleryManager.a(this.a, this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene);
    this.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */