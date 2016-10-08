package com.tencent.tmdownloader.internal.notification;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmdownloader.TMAssistantDownloadService;

public class e
{
  public static PendingIntent a(NotifyParam paramNotifyParam)
  {
    Intent localIntent = new Intent(f.a().b(), TMAssistantDownloadService.class);
    localIntent.putExtra("notification_id", paramNotifyParam.notificationTypeId);
    if (paramNotifyParam != null) {
      localIntent.putExtra("notifyParam", paramNotifyParam);
    }
    return PendingIntent.getService(f.a().b(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\notification\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */