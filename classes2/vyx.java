import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;

public final class vyx
  implements Runnable
{
  public vyx(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str1 = CardHandler.a(this.a, CardHandler.b(BaseApplication.getContext()));
    int i = CardHandler.c(BaseApplication.getContext());
    String str2 = CardHandler.a(this.a, i);
    ImageUtil.a(this.b, str1);
    ImageUtil.a(this.b, str2, i, i);
    FileUtils.a(this.b, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */