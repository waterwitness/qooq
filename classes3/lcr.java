import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lcr
  extends TroopQZoneUploadAlbumObserver
{
  public lcr(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    this.a.a(8, (String)paramObject, Integer.MIN_VALUE);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */