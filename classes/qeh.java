import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class qeh
  extends BroadcastReceiver
{
  public qeh(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.qzone.cleanunreadcount".equals(paramContext))
    {
      i = paramIntent.getIntExtra("clean_unread_feed_type", -1);
      paramContext = (QZoneManagerImp)this.a.getManager(9);
      if ((paramContext != null) && (i != -1)) {
        paramContext.a(i, 0L, 0L, null, false, false);
      }
    }
    while (!"com.tecent.qzone.clearAlbumRedTouch".equals(paramContext))
    {
      int i;
      return;
    }
    ((QzoneAlbumRedTouchManager)this.a.getManager(103)).b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */