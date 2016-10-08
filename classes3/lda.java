import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lda
  extends DataLineObserver
{
  public lda(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, AppConstants.aj, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.ak, 6000);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    if (i == 0) {
      this.a.a(9, AppConstants.aj, 6003);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.ak, 6003);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, AppConstants.aj, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.ak, 6003);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */