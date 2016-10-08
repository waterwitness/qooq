import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQLSSensor;

public class mcn
  implements Runnable
{
  public mcn(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a = new QQLSSensor(this.a.getApplicationContext(), this.a);
    this.a.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */