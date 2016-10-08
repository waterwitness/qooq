import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchServlet;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import mqq.app.NewIntent;

public class ual
  implements Runnable
{
  public ual(QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    Object localObject = (RedTouchManager)this.a.a.getManager(35);
    String str = String.valueOf(100180);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a(str);
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      ((RedTouchManager)localObject).c(str);
      LocalMultiProcConfig.b("key_photo_guide_is_red", false);
      QZoneClickReport.startReportImediately(this.a.a.a(), "443", "2");
      return;
    }
    localObject = new NewIntent(this.a.a.getApplication(), QzoneAlbumRedTouchServlet.class);
    ((NewIntent)localObject).putExtra("req", new operation_red_touch_req(2L));
    this.a.a.startServlet((NewIntent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */