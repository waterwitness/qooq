import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class ltl
  extends MqqHandler
{
  public ltl(LoginInfoActivity paramLoginInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.LoginInfoActivity", 2, "handleMessage.msg.arg1=" + paramMessage.arg1);
          }
        } while (LoginInfoActivity.a(this.a) == null);
        LoginInfoActivity.a(this.a).DevSetup = paramMessage.arg1;
        LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
        return;
      } while (LoginInfoActivity.a(this.a) == null);
      localObject = paramMessage.getData();
    } while (localObject == null);
    paramMessage = ((Bundle)localObject).getString(AuthDevRenameActivity.f);
    Object localObject = ((Bundle)localObject).getByteArray(AuthDevRenameActivity.h);
    int i = 0;
    for (;;)
    {
      if (i < LoginInfoActivity.a(this.a).size())
      {
        SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)LoginInfoActivity.a(this.a).get(i);
        if ((localSvcDevLoginInfo != null) && (Arrays.equals(localSvcDevLoginInfo.stDeviceItemDes.vecItemDes, (byte[])localObject))) {
          localSvcDevLoginInfo.strDeviceName = paramMessage;
        }
      }
      else
      {
        LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */