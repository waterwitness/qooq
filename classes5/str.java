import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class str
  implements AdapterView.OnItemClickListener
{
  public str(HotChatMemberListActivity paramHotChatMemberListActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.a(paramView, paramInt);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\str.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */