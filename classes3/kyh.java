import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kyh
  extends QvipSpecialCareObserver
{
  public kyh(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null) {
      ((Integer)paramObject).intValue();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */