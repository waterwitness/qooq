import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class nba
  implements Runnable
{
  public nba(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.j = this.a.a(VisitorsActivity.c, 0);
    this.a.k = this.a.a(VisitorsActivity.c, 0);
    ArrayList localArrayList1 = this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(2, 7);
    ArrayList localArrayList2 = this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(3, 7);
    ArrayList localArrayList3 = new ArrayList();
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.c(localArrayList3);
    synchronized (VisitorsActivity.b)
    {
      VisitorsActivity.a(this.a, localArrayList3);
      this.a.e = this.a.getResources().getString(2131372706);
      this.a.f = this.a.getResources().getString(2131372707);
      this.a.g = this.a.getResources().getString(2131372708);
      this.a.h = this.a.getResources().getString(2131372709);
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, 0, 0, new Object[] { localArrayList1, localArrayList2 }).sendToTarget();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */