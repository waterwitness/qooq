import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.Workspace;
import java.util.ArrayList;

class lhy
  implements View.OnClickListener
{
  lhy(lhx paramlhx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof lhz))
    {
      paramView = (lhz)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramView.a);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a(this.a.jdField_a_of_type_JavaUtilArrayList.size());
        this.a.notifyDataSetChanged();
        int i = 0;
        while (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildCount())
        {
          ((BaseAdapter)((GridView)this.a.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a.getChildAt(i)).getAdapter()).notifyDataSetChanged();
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */