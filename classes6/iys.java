import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.tencent.biz.qqstory.takevideo.rmw.RMWControl;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWProto;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iys
  extends Handler
{
  public iys(RMWService paramRMWService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    RMWLog.b("RMWService", "service.handle : " + RMWProto.a(paramMessage));
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            RMWService.a(this.a).a(paramMessage.arg1);
            return;
            RMWControl localRMWControl = RMWService.a(this.a);
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              localRMWControl.a(bool);
              return;
              bool = false;
            }
            if (paramMessage.replyTo != null)
            {
              switch (paramMessage.arg1)
              {
              default: 
                RMWLog.b("RMWService", "illegal arg1 : " + paramMessage.arg1);
                return;
              case 1: 
                RMWService.a(this.a).a(paramMessage.replyTo.getBinder());
                return;
              }
              RMWService.a(this.a).b(paramMessage.replyTo.getBinder());
              return;
            }
            RMWLog.b("RMWService", "ACTION_KEEP_SHOWING must has call back messenger (replyTo) !");
            return;
            RMWService.a(this.a).a();
            return;
            RMWService.a(this.a).b();
            return;
            RMWService.a(this.a).a(paramMessage.getData().getFloat("progress"));
            return;
          } while (paramMessage.replyTo == null);
          switch (paramMessage.arg1)
          {
          default: 
            RMWLog.b("RMWService", "illegal arg1 : " + paramMessage.arg1);
            return;
          case 1: 
            RMWService.a(this.a).a(paramMessage.replyTo);
            return;
          }
          RMWService.a(this.a).b(paramMessage.replyTo);
          return;
        } while (paramMessage.replyTo == null);
        switch (paramMessage.arg1)
        {
        default: 
          RMWLog.b("RMWService", "illegal arg1 : " + paramMessage.arg1);
          return;
        case 1: 
          RMWService.a(this.a).c(paramMessage.replyTo);
          return;
        }
        RMWService.a(this.a).d(paramMessage.replyTo);
        return;
      } while (paramMessage.replyTo == null);
      switch (paramMessage.arg1)
      {
      default: 
        RMWLog.b("RMWService", "illegal arg1 : " + paramMessage.arg1);
        return;
      case 1: 
        RMWService.a(this.a).e(paramMessage.replyTo);
        return;
      }
      RMWService.a(this.a).f(paramMessage.replyTo);
      return;
    } while (paramMessage.replyTo == null);
    switch (paramMessage.arg1)
    {
    default: 
      RMWLog.b("RMWService", "illegal arg1 : " + paramMessage.arg1);
      return;
    case 1: 
      RMWService.a(this.a).g(paramMessage.replyTo);
      return;
    }
    RMWService.a(this.a).h(paramMessage.replyTo);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */