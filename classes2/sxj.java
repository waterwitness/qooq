import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahook.TimeoutExceptionHooker;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;

public class sxj
  implements ReplaceMethodCallback
{
  private sxj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    TimeoutExceptionHooker.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */