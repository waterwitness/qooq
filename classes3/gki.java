import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gki
  implements Runnable
{
  public gki(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount());
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.b, 2000L);
    }
    do
    {
      return;
      if (this.a.c)
      {
        this.a.c = false;
        this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.jdField_a_of_type_Boolean, this.a.m, this.a.n);
        return;
      }
    } while (!this.a.d);
    this.a.d = false;
    this.a.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.a.jdField_a_of_type_Boolean, this.a.m);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */