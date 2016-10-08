import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mch
  extends SosoInterface.OnLocationListener
{
  public mch(QQBrowserActivity paramQQBrowserActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */