import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import mqq.os.MqqHandler;

public class mpy
  extends TroopObserver
{
  public mpy(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 6) {
      if (paramByte == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    while ((paramInt != 2) || (paramByte != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.app);
    this.a.e();
  }
  
  protected void b(String paramString)
  {
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */