package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Native$NativeException
  extends RuntimeException
{
  private static final long serialVersionUID = 411247780482311098L;
  
  public Native$NativeException()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Native$NativeException(String paramString)
  {
    super(paramString);
  }
  
  public Native$NativeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\Native$NativeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */