import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mpt
  extends MessageObserver
{
  public mpt(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (!paramBoolean) {
      this.a.e();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    this.a.e();
  }
  
  protected void b()
  {
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */