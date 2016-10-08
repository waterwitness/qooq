import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.TenpayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qwallet.CodeGenerate.CodeGenerateRes;

public class ott
  extends Handler
{
  public ott(TenpayUtil paramTenpayUtil, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isDevelopLevel()) {
      QLog.i(TenpayUtil.a(), 4, "handlerMessage type=" + i);
    }
    if (i == 100) {
      new Thread(new otu(this, (CodeGenerate.CodeGenerateRes)paramMessage.obj)).start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ott.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */