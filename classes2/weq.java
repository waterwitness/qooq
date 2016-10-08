import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividuationManager;
import com.tencent.mobileqq.vas.IndividuationManager.IndividUpdateLisener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import mqq.app.MobileQQ;

public class weq
  extends DownloadListener
{
  public weq(IndividuationManager paramIndividuationManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.a() == 3) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int i = paramDownloadTask.a().getInt("jsonVersion");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("clubContentVersion", 0).edit().putInt("IndividuationConfigJsonVersion4", i).commit();
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager$IndividUpdateLisener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager$IndividUpdateLisener.a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\weq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */