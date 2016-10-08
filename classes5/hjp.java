import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hjp
  extends SosoInterface.OnLocationListener
{
  public hjp(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, SharedPreferences paramSharedPreferences)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    if (paramInt == 0)
    {
      SearchProtocol.a = (float)paramSosoLbsInfo.a.a;
      SearchProtocol.b = (float)paramSosoLbsInfo.a.b;
      localEditor.putFloat("search_lbs_latitude", SearchProtocol.a);
      localEditor.putFloat("search_lbs_logitude", SearchProtocol.b);
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      localEditor.remove("search_lbs_delay");
    }
    for (;;)
    {
      localEditor.putLong("search_lbs_timestamp", System.currentTimeMillis());
      localEditor.commit();
      return;
      localEditor.putInt("search_lbs_delay", 48);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */