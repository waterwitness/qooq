import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ibf
  implements Runnable
{
  ibf(ibe paramibe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_JavaUtilList.remove(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_JavaLangLong);
    ReadInJoyBaseAdapter.a(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, true);
    if (this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_JavaUtilList.size() != 0) {
      this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.d();
    }
    this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
    if ((this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity, -1, this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity.getString(2131362994), 0).b(((BaseActivity)this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_Int, this.a.jdField_a_of_type_Ibd.jdField_a_of_type_JavaLangLong.longValue(), this.a.jdField_a_of_type_JavaUtilArrayList);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("time", System.currentTimeMillis() / 1000L);
        localJSONObject.put("channel_id", this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.p);
        localJSONObject.put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
        {
          localJSONObject.put("folder_status", ReadInJoyUtils.l);
          ReportController.b(null, "CliOper", "", "", "0X8007059", "0X8007059", 0, 0, "", "", "", localJSONObject.toString());
        }
        while (!(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity, -1, this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity.getString(2131362994), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Ibd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
          break;
        }
        localJSONObject.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", localJSONObject.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */