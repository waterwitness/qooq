import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.List;

class otj
  implements Runnable
{
  otj(oti paramoti, DownloadTask paramDownloadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.size();
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.get(i);
      PreloadImgManager.a(this.jdField_a_of_type_Oti.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */