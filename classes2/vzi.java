import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class vzi
  implements INetEngine.INetEngineListener
{
  public vzi(SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("vip_qqsetting_last_update_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()));
    if ((paramNetResp != null) && (paramNetResp.e == 0) && (paramNetResp.a.length > 0)) {}
    for (;;)
    {
      try
      {
        paramNetResp = new JSONArray(new String(paramNetResp.a, "UTF-8"));
        if ((paramNetResp != null) && (paramNetResp.length() > 0))
        {
          i = 0;
          if (i < paramNetResp.length())
          {
            JSONObject localJSONObject = paramNetResp.getJSONObject(i);
            if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQSetting", 2, "requestMyVipInfo result= " + localJSONObject.toString());
            }
            localEditor.putString("vip_qqsetting_title_vip", localJSONObject.optString("vip", "我的QQ会员"));
            localEditor.putString("vip_qqsetting_title_svip", localJSONObject.optString("svip", "我的超级会员"));
            localEditor.putString("vip_qqsetting_title_notvip", localJSONObject.optString("notVip", "开通会员"));
            localEditor.putString("vip_qqsetting_title_expired_vip", localJSONObject.optString("outdatedVip", "激活会员"));
          }
        }
      }
      catch (Exception paramNetResp)
      {
        int i;
        paramNetResp.printStackTrace();
        continue;
      }
      localEditor.commit();
      return;
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */