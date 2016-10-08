import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ora
  extends MediaFileFilter
{
  public ora()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    return (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (!"video/mp4".equals(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */