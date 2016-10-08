import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.List;

public class mjt
  implements AbsListView.OnScrollListener
{
  public mjt(SearchTroopListActivity paramSearchTroopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_Boolean))
    {
      paramInt = this.a.jdField_a_of_type_ComTencentWidgetXListView.t();
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= paramInt) {
        this.a.c();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */