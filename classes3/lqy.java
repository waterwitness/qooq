import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

class lqy
  implements Runnable
{
  lqy(lqx paramlqx, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Lqx.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Lqx.a).clear();
      Leba.a(this.jdField_a_of_type_Lqx.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Lqx.a.a != null) {
        this.jdField_a_of_type_Lqx.a.a.notifyDataSetChanged();
      }
      Leba.b(this.jdField_a_of_type_Lqx.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */