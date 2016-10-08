import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ign
  extends FileObserver
{
  public ign(ScreenshotContentObserver paramScreenshotContentObserver, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver))) || (ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver) == null)) {
      return;
    }
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver).a(null, this.jdField_a_of_type_JavaLangString + paramString);
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */