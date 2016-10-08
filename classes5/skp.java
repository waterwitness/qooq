import android.os.AsyncTask;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop.TroopProxyActivity;
import java.util.ArrayList;

class skp
  extends AsyncTask
{
  skp(sko paramsko)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.a).a();
    int i = SendBottomBar.a(this.a.a).a();
    if (i == 5)
    {
      TroopProxyActivity.a.addAll(FMDataCache.b());
      return null;
    }
    if (paramVarArgs.equals(AppConstants.aj))
    {
      paramVarArgs = FMDataCache.b();
      ((DataLineHandler)SendBottomBar.a(this.a.a).a(8)).a(paramVarArgs);
      return null;
    }
    if (i == 6002)
    {
      localObject = FMDataCache.b();
      ((RouterHandler)SendBottomBar.a(this.a.a).a(48)).a((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
      return null;
    }
    if (i == 9501)
    {
      ((DeviceMsgHandle)SendBottomBar.a(this.a.a).a(49)).a().a(paramVarArgs, FMDataCache.b());
      return null;
    }
    Object localObject = SendBottomBar.a(this.a.a).b();
    SendBottomBar.a(this.a.a).a().a((String)localObject, paramVarArgs, i);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.a.c();
    FMDataCache.b();
    SendBottomBar.c(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */