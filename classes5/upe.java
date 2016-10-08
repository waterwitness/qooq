import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public final class upe
  implements Runnable
{
  upe(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.getApplication().getApplicationContext(), "TroopStranger senderUin Error!麻烦rtx联系下yellowye", 0).a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */