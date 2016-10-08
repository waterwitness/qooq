import com.facebook.react.uimanager.UIManagerModuleConstantsHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public final class ujw
  implements Runnable
{
  public ujw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UIManagerModuleConstantsHelper.getStaticConstants(BaseApplication.getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ujw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */