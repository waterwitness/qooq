import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class jic
  implements BusinessObserver
{
  public jic(Share paramShare, long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Share.g(), 2, "onReceive, isSuccess=" + paramBoolean + ", duration=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (paramBoolean)
    {
      String str1 = paramBundle.getString("extra_title");
      String str2 = paramBundle.getString("extra_summary");
      if (QLog.isColorLevel()) {
        QLog.d(Share.g(), 2, "onReceive, title=" + str1 + ", summary=" + str2);
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        Object localObject = null;
        ArrayList localArrayList = paramBundle.getStringArrayList("extra_images");
        paramBundle = (Bundle)localObject;
        if (localArrayList != null)
        {
          paramBundle = (Bundle)localObject;
          if (localArrayList.size() > 0) {
            paramBundle = (String)localArrayList.get(0);
          }
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_b_of_type_JavaLangString = str1;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c = str2;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d = paramBundle;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.runOnUiThread(new jid(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e(Share.g(), 2, "onReceive, title or summary is null");
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.runOnUiThread(new jie(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.runOnUiThread(new jif(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */