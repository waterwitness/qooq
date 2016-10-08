import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

public class rhu
  extends VipFunCallObserver
{
  public rhu(MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramObject = (Bundle)paramObject;
        if (paramObject == null)
        {
          QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver.onUpdate dataBundle=null");
          return;
        }
        int i = ((Bundle)paramObject).getInt("result", -1);
        if (!QLog.isColorLevel()) {
          break label206;
        }
        QLog.d("Q.emoji.web.MessengerService", 2, "fcObserver.onUpdate ret=" + i + ", type=" + paramInt + ", isSuccess=" + paramBoolean);
      }
      catch (Exception paramObject)
      {
        QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Err:" + ((Exception)paramObject).getMessage());
        return;
      }
      QLog.e("Q.emoji.web.MessengerService", 1, "fcObserver onUpdate Error type=" + paramInt);
      paramObject = (QQAppInterface)MessengerService.a(this.a);
      if (paramObject != null)
      {
        Object localObject = (VipSetFunCallHandler)((QQAppInterface)paramObject).a(46);
        ((QQAppInterface)paramObject).b(this);
        return;
        if (this.a.a != null)
        {
          localObject = Message.obtain(null, 5);
          ((Message)localObject).setData((Bundle)paramObject);
          this.a.a.send((Message)localObject);
        }
      }
      else
      {
        return;
        label206:
        switch (paramInt)
        {
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */