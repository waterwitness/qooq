import com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import java.util.ArrayList;
import java.util.List;

public class utn
  implements LeakInspector.InspectorListener
{
  public List a(String paramString)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new uto(this, paramString));
    }
    paramString = new ArrayList(4);
    paramString.add(DumpMemInfoHandler.b());
    paramString.add(DumpMemInfoHandler.a());
    paramString.addAll(DumpMemInfoHandler.b());
    return paramString;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new utp(this, paramString1, paramBoolean, paramString2));
    }
  }
  
  public boolean a(LeakInspector.InspectUUID paramInspectUUID)
  {
    return InitMagnifierSDK.a(paramInspectUUID);
  }
  
  public boolean a(Object paramObject)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */