import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LengthConvertor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pem
  implements ExtendEditText.LengthConvertor
{
  public pem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return -paramInt1;
  }
  
  public int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return -paramInt1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */