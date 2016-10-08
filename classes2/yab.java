import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.service.LBSInfo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSHelper;
import cooperation.c2b.C2BTakePhotoActivity;
import cooperation.c2b.C2BWebPlugin;

public class yab
  extends BroadcastReceiver
{
  private yab(C2BWebPlugin paramC2BWebPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("C2BWebPlugin", 2, "C2BWebPluginReceiver onReceive action = " + paramContext);
    }
    if ((paramContext == null) || (C2BWebPlugin.a(this.a))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2BWebPlugin", 2, "C2BWebPluginReceiver onReceive action = null or isDestory ");
      }
    }
    label448:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                if (this.a.mRuntime.a() == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("C2BWebPlugin", 2, "C2BWebPluginReceiver onReceive mRuntime.getActivity() == null ");
                  }
                }
                else if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(this.a.mRuntime.a().getPackageName())))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("C2BWebPlugin", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + paramContext);
                  }
                }
                else
                {
                  String str2;
                  if (("tencent.c2b.action.RESPONSE_LBS" + C2BWebPlugin.a(this.a)).equals(paramContext))
                  {
                    boolean bool = paramIntent.getBooleanExtra(C2BLBSHelper.b, false);
                    paramContext = null;
                    if (bool) {
                      paramContext = new LBSInfo(paramIntent.getStringExtra("nation"), paramIntent.getStringExtra("province"), paramIntent.getStringExtra("city"), paramIntent.getStringExtra("district"), paramIntent.getStringExtra("town"), paramIntent.getStringExtra("village"), paramIntent.getStringExtra("street"), paramIntent.getStringExtra("streetNo"), paramIntent.getDoubleExtra("latitude", 0.0D), paramIntent.getDoubleExtra("longitude", 0.0D), paramIntent.getDoubleExtra("altitude", 0.0D), null);
                    }
                    str2 = paramIntent.getStringExtra(C2BLBSHelper.d);
                    str1 = paramIntent.getStringExtra("seq");
                    String str3 = paramIntent.getStringExtra("lbscallback");
                    paramIntent = paramIntent.getStringExtra("poicallback");
                    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(paramIntent)))
                    {
                      paramIntent = new yad(this.a, str2, str3, paramIntent);
                      paramIntent.a(str1);
                      if (bool)
                      {
                        i = 0;
                        paramIntent.a(i, paramContext);
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        paramIntent = new StringBuilder().append("C2BWebPluginReceiver onReceive isSucess=").append(bool).append(",seq=").append(str1).append("lbsInfo=");
                        if (paramContext == null) {
                          break label448;
                        }
                      }
                      for (paramContext = paramContext.toString();; paramContext = null)
                      {
                        QLog.i("C2BWebPlugin", 2, paramContext);
                        return;
                        i = -1;
                        break;
                      }
                    }
                    else if (QLog.isColorLevel())
                    {
                      QLog.i("C2BWebPlugin", 2, "onReceive LBS response invalid parameters");
                    }
                  }
                  else
                  {
                    if (!("tencent.c2b.action.RESPONSE_QRCODE" + C2BWebPlugin.a(this.a)).equals(paramContext)) {
                      break;
                    }
                    paramContext = paramIntent.getExtras();
                    if (paramContext != null)
                    {
                      str1 = paramContext.getString("seq");
                      str2 = paramIntent.getStringExtra("scanStr");
                      paramIntent = paramIntent.getStringExtra("callback");
                      if ((str2 != null) && (str2.length() > 0)) {
                        C2BWebPlugin.a(this.a, paramIntent, 0, str1, str2);
                      }
                      while (QLog.isColorLevel())
                      {
                        QLog.d("C2BWebPlugin", 2, "C2BWebPluginReceiver onGetQRCode result = " + str2 + ",type = " + paramContext.getInt("dimension"));
                        return;
                        C2BWebPlugin.a(this.a, paramIntent, 1, str1, "");
                      }
                    }
                  }
                }
              }
              if (!("tencent.c2b.action.RESPONSE_DTMF" + C2BWebPlugin.a(this.a)).equals(paramContext)) {
                break;
              }
              paramContext = paramIntent.getExtras();
            } while (paramContext == null);
            i = paramContext.getInt("result");
            paramContext = paramContext.getString("callback");
          } while (TextUtils.isEmpty(paramContext));
          paramContext = String.format("window." + paramContext + "(%d)", new Object[] { Integer.valueOf(i) });
          paramIntent = this.a.mRuntime.a();
          if (paramIntent != null) {
            paramIntent.c(paramContext);
          }
        } while (!QLog.isColorLevel());
        QLog.d("C2BWebPlugin", 2, "onDTMFSend js:" + paramContext);
        return;
        if (!("tencent.c2b.action.upload_image_or_video" + C2BWebPlugin.a(this.a)).equals(paramContext)) {
          break;
        }
        paramContext = paramIntent.getStringExtra("callback");
        String str1 = paramIntent.getStringExtra("qq.process.param.uploadfile.filepath");
        int i = paramIntent.getIntExtra("error_code", 0);
        this.a.a(paramContext, i, str1);
      } while (this.a.c != 0);
      paramContext = new Intent("tencent.c2b.action.REQUEST_MIC_STATE");
      paramContext.putExtra("mic_state_type", "open");
      paramContext.setPackage(this.a.mRuntime.a().getPackageName());
      this.a.mRuntime.a().sendBroadcast(paramContext);
      return;
      if (("tencent.c2b.action.RESPONSE_MIC_STATE" + C2BWebPlugin.a(this.a)).equals(paramContext))
      {
        if (paramIntent.getBooleanExtra("mic_state_result", false))
        {
          paramContext = new Intent(this.a.mRuntime.a(), C2BTakePhotoActivity.class);
          paramContext.putExtras(paramIntent);
          paramContext.putExtra("destaction", "tencent.c2b.action.upload_image_or_video" + C2BWebPlugin.a(this.a));
          paramContext.putExtra("caller", this.a.a());
          this.a.mRuntime.a().startActivity(paramContext);
          return;
        }
        paramContext = DialogUtil.a(this.a.mRuntime.a(), 230);
        paramContext.setTitle("温馨提示");
        paramContext.setMessage(this.a.mRuntime.a().getString(2131363689));
        paramContext.setPositiveButton("确定", new yac(this));
        paramContext.show();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2BWebPlugin", 2, "onReceive unknown action");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */