import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class oqz
  extends MediaFileFilter
{
  public oqz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(String paramString)
  {
    paramString = MimeHelper.a(paramString);
    return (paramString == null) || (!"image".equals(paramString[0])) || (!MimeHelper.a(paramString[1]));
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */