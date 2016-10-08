import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotchat.PttShowRoomMng.Guest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sux
  extends LruCache
{
  public sux(PttShowRoomMng paramPttShowRoomMng, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sux.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */