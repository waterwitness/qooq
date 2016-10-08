package cooperation.buscard;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import xyr;

public class BuscardPluginRemoteCommand
  extends RemoteCommand
{
  public static final String a = "com.tencent.nfc.buscard.remotecommand";
  
  public BuscardPluginRemoteCommand()
  {
    super("com.tencent.nfc.buscard.remotecommand");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (!localPluginCommunicationHandler.containsCmd("com.tencent.nfc.buscard.remotecommand"))) {
      localPluginCommunicationHandler.register(this);
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    try
    {
      String str = paramBundle.getString("cmd");
      if (!TextUtils.isEmpty(str)) {
        if (str.equals("getQrCode"))
        {
          str = paramBundle.getString("sharelink");
          int i = paramBundle.getInt("imgsize");
          int j = paramBundle.getInt("margin");
          boolean bool = paramBundle.getBoolean("showlogo");
          if (!TextUtils.isEmpty(str))
          {
            Bitmap localBitmap = TroopShareUtility.a(str, BaseApplicationImpl.getContext().getResources(), i, j, bool);
            if (localBitmap != null)
            {
              paramOnInvokeFinishLinstener.putString("path", QRUtils.a(BaseApplicationImpl.getContext(), str.hashCode() + "", localBitmap));
              return paramOnInvokeFinishLinstener;
            }
          }
        }
        else if (str.equals("location"))
        {
          SosoInterface.a(new xyr(this, 3, true, true, 300000L, false, false, "buscardLocation", paramOnInvokeFinishLinstener));
          return paramOnInvokeFinishLinstener;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("params=");
        if (paramBundle != null)
        {
          paramBundle = paramBundle.toString();
          localStringBuilder = localStringBuilder.append(paramBundle).append("; result=");
          if (paramOnInvokeFinishLinstener == null) {
            break label234;
          }
        }
        label234:
        for (paramBundle = paramOnInvokeFinishLinstener.toString();; paramBundle = "null")
        {
          QLog.d("BuscardPluginRemoteCommand", 4, paramBundle);
          return paramOnInvokeFinishLinstener;
          paramBundle = "null";
          break;
        }
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\buscard\BuscardPluginRemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */