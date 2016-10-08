import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import mqq.app.MobileQQ;

public class ufd
  extends MessageObserver
{
  public ufd(RedTouchManager paramRedTouchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 113) && (paramBoolean) && ((this.a.a instanceof QQAppInterface)))
    {
      RedpointHandler.a((QQAppInterface)this.a.a);
      paramObject = new Intent();
      ((Intent)paramObject).setAction("com.tencent.redpoint.broadcast.push");
      this.a.a.getApplication().sendBroadcast((Intent)paramObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */