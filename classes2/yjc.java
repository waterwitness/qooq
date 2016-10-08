import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class yjc
  extends WtloginObserver
{
  public yjc(Handler.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnException(String paramString, int paramInt)
  {
    paramString = Message.obtain();
    paramString.what = 1001;
    if (this.a != null) {
      this.a.handleMessage(paramString);
    }
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    paramString = Message.obtain();
    paramString.what = 1000;
    if (this.a != null) {
      this.a.handleMessage(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */