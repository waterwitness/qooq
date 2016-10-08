import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class idj
  extends SubscriptObserver
{
  public idj(SubscriptFeedsActivity paramSubscriptFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetRecommendReadInJoyArticleList isSuccess: " + paramBoolean + " | data: " + paramArrayList);
    }
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        if ((paramArrayList != null) && (paramArrayList.size() == 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetRecommendReadInJoyArticleList data is null or small than 4");
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.a == null);
    Message localMessage = new Message();
    localMessage.what = 1003;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ReadInJoyArticleList", paramArrayList);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.a.removeMessages(1003);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */