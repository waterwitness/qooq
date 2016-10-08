import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.List;

class rej
  implements Runnable
{
  rej(rei paramrei, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatingTopListActivity.a(this.jdField_a_of_type_Rei.a, this.jdField_a_of_type_JavaUtilList, DatingTopListActivity.b(this.jdField_a_of_type_Rei.a).listType, true);
    DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).a(this.jdField_a_of_type_JavaUtilList);
    DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).notifyDataSetChanged();
    DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).setSelection(0);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).b(true);
      if (DatingTopListActivity.b(this.jdField_a_of_type_Rei.a).hasMore)
      {
        DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).b();
        this.jdField_a_of_type_Rei.a.b("0X8005276");
      }
    }
    for (;;)
    {
      DatingTopListActivity.a(this.jdField_a_of_type_Rei.a, DatingTopListActivity.b(this.jdField_a_of_type_Rei.a), true, false, false);
      return;
      DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).c();
      break;
      DatingTopListActivity.a(this.jdField_a_of_type_Rei.a).b(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */