import com.dataline.util.file.ImageInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class cd
  implements Comparator
{
  public cd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ImageInfo paramImageInfo1, ImageInfo paramImageInfo2)
  {
    return -Long.valueOf(paramImageInfo1.a()).compareTo(Long.valueOf(paramImageInfo2.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */