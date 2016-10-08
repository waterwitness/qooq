import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.Gallery;

public class xtd
  implements Runnable
{
  public xtd(Gallery paramGallery)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Gallery.a(this.a, false);
    this.a.f_();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xtd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */