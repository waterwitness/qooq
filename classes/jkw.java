import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jkw
  implements AnimationLister
{
  public jkw(AbstractImageListScene paramAbstractImageListScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onEnterAnimationEnd");
    }
    if (this.a.a.a() != this.a) {
      this.a.k();
    }
    this.a.b();
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onExitAnimationEnd");
    }
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */