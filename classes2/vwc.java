import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr.OnPayRewardListener;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class vwc
  implements TroopRewardMgr.OnPayRewardListener
{
  public vwc(TroopRewardDetailActivity paramTroopRewardDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("tokenId", paramString);
        localJSONObject.put("appInfo", "appid#20000020|bargainor_id#1000054301|channel#qun");
        PayBridgeActivity.tenpay(this.a, localJSONObject.toString(), 9, "0");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    try
    {
      this.a.a.dismiss();
      this.a.a(this.a.getString(2131365275));
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */