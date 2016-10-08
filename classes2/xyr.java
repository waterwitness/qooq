import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.buscard.BuscardPluginRemoteCommand;

public class xyr
  extends SosoInterface.OnLocationListener
{
  public xyr(BuscardPluginRemoteCommand paramBuscardPluginRemoteCommand, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, Bundle paramBundle)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      String str = paramSosoLbsInfo.a.d;
      paramSosoLbsInfo = paramSosoLbsInfo.a.e;
      this.jdField_a_of_type_AndroidOsBundle.putString("province", str);
      this.jdField_a_of_type_AndroidOsBundle.putString("city", paramSosoLbsInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */