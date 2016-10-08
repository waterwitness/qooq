import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.QZoneVideoCommonUtils.onForwardVideoActivityFailedListener;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;

public class ysc
  implements QZoneVideoCommonUtils.onForwardVideoActivityFailedListener
{
  public ysc(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, paramString, 0).b(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */