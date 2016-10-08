import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class lgr
  implements AdapterView.OnItemClickListener
{
  public lgr(DiscussionMemberActivity paramDiscussionMemberActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a(paramView);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */