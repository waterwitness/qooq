import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kxb
  implements Runnable
{
  kxb(kxa paramkxa)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.b)
    {
      this.a.a.b = false;
      MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.a.app.getManager(91);
      if (localMessageRoamManager != null) {
        localMessageRoamManager.d();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */