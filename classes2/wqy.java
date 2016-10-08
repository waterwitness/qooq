import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import java.util.ArrayList;

public class wqy
  implements AdapterView.OnItemClickListener
{
  public wqy(FriendChooser paramFriendChooser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.getItem(paramInt);
    if ((paramAdapterView != null) && (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a)))
    {
      this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c(paramAdapterView.a);
      this.a.b.remove(paramAdapterView);
      this.a.e();
      ((OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.a.b(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */