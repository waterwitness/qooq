import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imb
  implements View.OnClickListener
{
  public imb(DiscoverItem paramDiscoverItem, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView.clearAnimation();
    if (this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener.onItemClick(null, paramView, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.d, this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.d);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */