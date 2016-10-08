import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;

public class umu
  extends SosoInterface.OnLocationListener
{
  public umu(NetSearchEngine paramNetSearchEngine, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      NetSearchEngine.a = paramSosoLbsInfo.a.a;
      NetSearchEngine.b = paramSosoLbsInfo.a.b;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */