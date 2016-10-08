import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.FileUtils;

public class vav
  extends TransProcessorHandler
{
  public vav(ForwardImageProcessor paramForwardImageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((i == 2002) || ((ForwardImageProcessor.a(this.a).equals(localFileMsg.r)) && (localFileMsg.e == 1) && (i != 2002)))
    {
      if ((localFileMsg.t == null) || (!localFileMsg.t.equals(ForwardImageProcessor.b(this.a)))) {
        return;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      ForwardImageProcessor.a(this.a);
      continue;
      if (FileUtils.b(ForwardImageProcessor.c(this.a)))
      {
        ForwardImageProcessor.a(this.a).a().b(this);
        ForwardImageProcessor.b(this.a);
      }
      else
      {
        ForwardImageProcessor.a(this.a);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */