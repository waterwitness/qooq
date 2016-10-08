import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class lqs
  implements Runnable
{
  public lqs(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(11340005);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */