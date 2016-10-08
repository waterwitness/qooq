import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.common.app.ToolRuntimeBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jkp
  implements ComponentCallbacks2
{
  public jkp(ToolRuntimeBase paramToolRuntimeBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    this.a.a(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */