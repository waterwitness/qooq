import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ifm
  implements Runnable
{
  public ifm(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin, ArrayList paramArrayList, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          String str = UUID.randomUUID().toString();
          str = "mqqpa://resourceid/" + str;
          this.jdField_a_of_type_OrgJsonJSONArray.put(i, str);
          CompressInfo localCompressInfo = new CompressInfo((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), 0);
          localCompressInfo.f = 0;
          CompressOperator.a(localCompressInfo);
          if (!StringUtil.b(localCompressInfo.e)) {
            PublicAccountH5AbilityPlugin.b.put(str, localCompressInfo.e);
          } else {
            PublicAccountH5AbilityPlugin.b.put(str, this.jdField_a_of_type_JavaUtilArrayList.get(i));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("value", this.jdField_a_of_type_OrgJsonJSONArray);
      this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 0);
      this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "Success");
      this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "album");
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.callJs(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.L, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.L = "";
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
      return;
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ifm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */