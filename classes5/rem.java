import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.GodListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.List;

class rem
  implements Runnable
{
  rem(rel paramrel, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatingTopListActivity.a(this.jdField_a_of_type_Rel.a, this.jdField_a_of_type_JavaUtilList, DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).listType, true);
    DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).a(this.jdField_a_of_type_JavaUtilList);
    DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).notifyDataSetChanged();
    DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).setSelection(0);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).b(true);
      if (DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).hasMore)
      {
        DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).b();
        this.jdField_a_of_type_Rel.a.b("0X8005275");
      }
    }
    for (;;)
    {
      DatingTopListActivity.a(this.jdField_a_of_type_Rel.a, DatingTopListActivity.a(this.jdField_a_of_type_Rel.a), true, false, false);
      return;
      DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).c();
      break;
      DatingTopListActivity.a(this.jdField_a_of_type_Rel.a).b(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */