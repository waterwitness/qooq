import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qqstory.pgc.view.WebcastContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;

public class inx
  implements IVPluginEvtListener
{
  public inx(WebcastContentView paramWebcastContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString)
  {
    try
    {
      ((Activity)this.a.a).finish();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void b(String paramString) {}
  
  public void c(String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */