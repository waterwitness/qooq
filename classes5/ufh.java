import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class ufh
  implements Runnable
{
  ufh(ufg paramufg, String paramString1, JSONObject paramJSONObject, BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Ufg.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) {
      localObject = RedTouchWebviewHandler.access$100(this.jdField_a_of_type_Ufg.a, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("buffer", (String)localObject);
    localBundle.putString("red", String.valueOf(this.jdField_b_of_type_Int));
    localBundle.putStringArrayList("missions", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putString("path", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("serial", this.c);
    localBundle.putString("callback", this.jdField_a_of_type_JavaLangString);
    localObject = DataFactory.a("redTouch_getAppInfo_report", this.jdField_a_of_type_JavaLangString, RedTouchWebviewHandler.access$200(this.jdField_a_of_type_Ufg.a).key, localBundle);
    RedTouchWebviewHandler.access$300(this.jdField_a_of_type_Ufg.a, (Bundle)localObject, false, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */