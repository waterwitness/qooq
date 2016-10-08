import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kac
  implements BusinessObserver
{
  public kac(DeviceMsgSettingActivity paramDeviceMsgSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (!paramBoolean)
    {
      ToastUtil.a().a(this.a.getString(2131362432));
      DeviceMsgSettingActivity.a(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131362432));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          ToastUtil.a().a(this.a.getString(2131362432));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new kad(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          ToastUtil.a().a(this.a.getString(2131362435));
          DeviceMsgSettingActivity.a(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        LogUtility.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        ToastUtil.a().a(this.a.getString(2131362432));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        kaf localkaf = new kaf(this.a, null);
        localkaf.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localkaf.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localkaf.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localkaf);
        paramInt += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */