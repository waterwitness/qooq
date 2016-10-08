package com.tencent.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;

public class VideoMsgBroadcastReceiver
  extends BroadcastReceiver
{
  static final String a = "VideoMsgBroadcastReceiver";
  
  public VideoMsgBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgBroadcastReceiver", 2, "intent or context is null!");
      }
    }
    label362:
    long l1;
    label539:
    long l2;
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            Bundle localBundle;
            String str1;
            do
            {
              for (;;)
              {
                return;
                localBundle = paramIntent.getExtras();
                if (localBundle == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoMsgBroadcastReceiver", 2, "data is null!");
                  }
                }
                else
                {
                  localObject = localBundle.getString("uin");
                  str1 = localBundle.getString("fromUin");
                  String str2 = localBundle.getString("gatewayip");
                  if (localObject != null)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("VideoMsgBroadcastReceiver", 2, "Recv uin = " + (String)localObject + " action " + paramIntent.getAction());
                    }
                    try
                    {
                      paramContext = (MobileQQ)paramContext.getApplicationContext();
                      if (paramContext != null)
                      {
                        paramContext = (VideoAppInterface)paramContext.getAppRuntime((String)localObject);
                        if (paramContext != null)
                        {
                          if (str2 != null) {
                            paramContext.a().g(str2, 0);
                          }
                          if (!paramIntent.getAction().equals("com.tencent.av.ui.VChatActivity")) {
                            break label362;
                          }
                          if (QLog.isColorLevel()) {
                            QLog.d("VideoMsgBroadcastReceiver", 2, "Video process wake up");
                          }
                          int i = localBundle.getInt("istatus");
                          if (QLog.isColorLevel()) {
                            QLog.d("VideoMsgBroadcastReceiver", 2, "my status = " + i);
                          }
                          switch (i)
                          {
                          default: 
                            return;
                          case 11: 
                            paramContext.a().d(0);
                            return;
                          }
                        }
                      }
                    }
                    catch (AccountNotMatchException paramContext)
                    {
                      if (QLog.isColorLevel())
                      {
                        QLog.d("VideoMsgBroadcastReceiver", 2, "Account not match: uin = " + (String)localObject);
                        return;
                      }
                    }
                    catch (Exception paramContext) {}
                  }
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("VideoMsgBroadcastReceiver", 2, "Account not match: uin = " + (String)localObject + "app == null");
            return;
            paramContext.a().d(1);
            return;
            if (paramIntent.getAction().equals("tencent.video.q2v.RecvVideoCall"))
            {
              paramContext.a().a(localBundle);
              return;
            }
            if (paramIntent.getAction().equals("tencent.video.q2v.UpdateConfig"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 2, "updateConfigInfo");
              }
              paramContext.a().n();
              return;
            }
            if (paramIntent.getAction().equals("tencent.video.q2v.RecvSharpVideoCall"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 2, "onRecvSharpOfflineMsg");
              }
              l1 = localBundle.getLong("onLineStatus");
              boolean bool = localBundle.getBoolean("isRequest");
              if (l1 == 11L) {
                paramContext.a().d(0);
              }
              for (;;)
              {
                paramContext.a().b(localBundle);
                if (!bool) {
                  break;
                }
                paramContext.a().b(201, str1);
                if (paramContext.a().b() != 0) {
                  break label539;
                }
                paramContext.a().b(207, str1);
                return;
                paramContext.a().d(1);
              }
              paramContext.a().b(206, str1);
              return;
            }
            if (paramIntent.getAction().equals("tencent.video.q2v.RecvMultiVideoCall"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 2, "onRecvMultiVideoOfflineMsg");
              }
              paramContext.a().c(localBundle);
              return;
            }
            if (!paramIntent.getAction().equals("tencent.video.q2v.RecvBaseIMSharpMsg")) {
              break;
            }
            localObject = paramIntent.getBundleExtra("msgData");
          } while (localObject == null);
          localObject = ((Bundle)localObject).getByteArray("value");
          l1 = paramIntent.getLongExtra("tinyid", 0L);
        } while (localObject == null);
        paramContext.a().b(l1, (byte[])localObject);
        return;
      } while (!paramIntent.getAction().equals("tencent.video.q2v.AudioEngineReady"));
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgBroadcastReceiver", 2, "ACTION_OPPOSITE_AUDIO_ENGINE_READY");
      }
      l1 = paramIntent.getLongExtra("c2cuin", 0L);
      l2 = paramIntent.getLongExtra("c2croomid", 0L);
    } while ((l1 == 0L) || (l2 == 0L));
    paramContext.a().b(l1, l2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\VideoMsgBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */