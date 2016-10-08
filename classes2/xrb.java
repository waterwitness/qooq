import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.HashMap;

class xrb
  extends Handler
{
  xrb(xqz paramxqz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    label98:
    label355:
    do
    {
      Object localObject;
      do
      {
        try
        {
          HashMap localHashMap = (HashMap)paramMessage.obj;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
            if (this.a.a)
            {
              str = "Y";
              QLog.w("TRAE", 2, str);
            }
          }
          else
          {
            if (paramMessage.what != 32772) {
              break label98;
            }
            this.a.a(localHashMap);
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            do
            {
              for (;;)
              {
                localObject = null;
                continue;
                String str = "N";
              }
              if (!this.a.a)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 2, "******* disabled ,skip msg******");
                }
                paramMessage = new Intent();
                this.a.b.a(paramMessage, (HashMap)localObject, 1);
                return;
              }
              switch (paramMessage.what)
              {
              default: 
                return;
              case 32773: 
                this.a.b();
                return;
              case 32774: 
                this.a.a((HashMap)localObject);
                return;
              case 32777: 
                this.a.b.c((HashMap)localObject);
                return;
              case 32778: 
                this.a.b.d((HashMap)localObject);
                return;
              case 32779: 
                this.a.b.e((HashMap)localObject);
                return;
              case 32780: 
                this.a.b((HashMap)localObject);
                return;
              case 32781: 
                this.a.c((HashMap)localObject);
                return;
              case 32788: 
                paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
                if (paramMessage != null) {
                  break label355;
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
            return;
            this.a.b.y = paramMessage.intValue();
            this.a.a(paramMessage.intValue());
            return;
            this.a.d((HashMap)localObject);
            return;
            this.a.e((HashMap)localObject);
            return;
            this.a.g();
            return;
            this.a.a(this.a.b.y);
            return;
            this.a.f((HashMap)localObject);
            return;
            this.a.b.a();
            return;
            this.a.b.a((HashMap)localObject);
            return;
            this.a.b.b((HashMap)localObject);
            return;
            paramMessage = this.a.b.a.b();
            localObject = this.a.b.a.d();
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramMessage);
            }
            if (!paramMessage.equals(localObject))
            {
              this.a.b.a(paramMessage, null);
              return;
            }
            this.a.b.a();
            return;
            paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
          } while (this.a.b.a(paramMessage, null) == 0);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.au + " connected fail,auto switch!");
          }
          this.a.b.a(this.a.b.a.b(), null);
          return;
        }
      } while (this.a.b.a(this.a.b.au, null) == 0);
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.au + " connected fail,auto switch!");
      }
      this.a.b.a(this.a.b.a.b(), null);
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.a.b.ar.equals("DEVICE_BLUETOOTHHEADSET"))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + this.a.b.ar + " MESSAGE_BLUETOOTH_SCO_DISCONNECTED");
        }
        this.a.b.a(this.a.b.a.a("DEVICE_BLUETOOTHHEADSET"), null);
        return;
      }
    } while (this.a.b.a(this.a.b.ar, null) == 0);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + this.a.b.ar + " connected fail,auto switch!");
    }
    this.a.b.a(this.a.b.a.a("DEVICE_BLUETOOTHHEADSET"), null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */