package cooperation.comic;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VipComicLandReaderProxyActivity
  extends VipComicProxyActivity
{
  public VipComicLandReaderProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicLandReaderProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */