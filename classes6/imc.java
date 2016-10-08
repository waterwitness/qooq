import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imc
  implements View.OnLongClickListener
{
  public imc(DiscoverItem paramDiscoverItem, AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemLongClickListener.onItemLongClick(null, paramView, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.d, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.d);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */