import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class htp
  extends SosoInterface.OnLocationListener
{
  public htp(EcShopAssistantActivity paramEcShopAssistantActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((this.a.app == null) || (TextUtils.isEmpty(this.a.app.getAccount()))) {}
    do
    {
      return;
      SharedPreferences.Editor localEditor = this.a.app.a().getSharedPreferences(this.a.app.getAccount(), 0).edit();
      if (paramInt == 0)
      {
        float f1 = (float)paramSosoLbsInfo.a.a;
        float f2 = (float)paramSosoLbsInfo.a.b;
        localEditor.putFloat("search_lbs_latitude", f1);
        localEditor.putFloat("search_lbs_logitude", f2);
        localEditor.commit();
        this.a.a = false;
        EcShopAssistantActivity.a(this.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EcShopAssistantActivity", 2, "location refresh failed Error Code:" + paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */