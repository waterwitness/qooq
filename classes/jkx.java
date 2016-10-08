import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jkx
  implements Runnable
{
  public jkx(GalleryManager paramGalleryManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager.c = true;
    GalleryManager.a(this.a, this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene);
    GalleryManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */