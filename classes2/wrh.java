import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter;

public class wrh
  implements View.OnClickListener
{
  public wrh(GroupListOpenFrame.GroupListAdapter paramGroupListAdapter, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("group_index", this.jdField_a_of_type_Int);
    paramView.putString("group_name", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentOpenAgentGroupListOpenFrame$GroupListAdapter.a.a.a(1, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */