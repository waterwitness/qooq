import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class jim
  implements BusinessObserver
{
  public jim(ShareApiPlugin paramShareApiPlugin, WebUiUtils.WebShareInterface paramWebShareInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareApiPlugin", 2, "onReceive, getUrlInfo, isSuccess=" + paramBoolean);
    }
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      Object localObject;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.e)) || (this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.e.startsWith("http://")) || (this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.e.startsWith("https://")))
      {
        localObject = paramBundle.getString("extra_summary");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label340;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.e = ((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share summary parsed by server");
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.f))
      {
        localObject = paramBundle.getStringArrayList("extra_images");
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label357;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.f = ((String)((ArrayList)localObject).get(0));
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share thumb parsed by server");
        }
      }
      label190:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.d))
      {
        localObject = paramBundle.getString("extra_title");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.d = ((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share title parsed by server");
        }
      }
      label242:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.c))
      {
        paramBundle = paramBundle.getString("extra_url");
        if (TextUtils.isEmpty(paramBundle)) {
          break label391;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.c = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.d("ShareApiPlugin", 2, "Use share url parsed by server");
        }
      }
      label291:
      localBundle.putInt("extra_url_info_from", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.setSummary(this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.d, this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.e, this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.c, this.jdField_a_of_type_ComTencentBizWebviewpluginShareApiPlugin.f, localBundle);
      return;
      label340:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve summary");
      break;
      label357:
      if (!QLog.isColorLevel()) {
        break label190;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve thumb");
      break label190;
      label374:
      if (!QLog.isColorLevel()) {
        break label242;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve title");
      break label242;
      label391:
      if (!QLog.isColorLevel()) {
        break label291;
      }
      QLog.d("ShareApiPlugin", 2, "Server can't resolve url");
      break label291;
      localBundle.putInt("extra_url_info_from", 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */