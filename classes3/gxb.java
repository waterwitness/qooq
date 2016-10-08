import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.GVideoQQBrowserActivity;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class gxb
  implements AdapterView.OnItemClickListener
{
  public gxb(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Boolean)
    {
      String str;
      if (!this.jdField_a_of_type_Boolean)
      {
        paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramView = new Intent(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity, GVideoQQBrowserActivity.class);
        paramAdapterView = String.valueOf(paramAdapterView.a);
        str = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (paramAdapterView.equals(str))
        {
          paramAdapterView = "http://qvideo.qq.com/mobile/client/level/detail.html?_bid=2176&uin=" + str;
          paramView.putExtra("url", paramAdapterView);
          paramView.putExtra("uin", str);
          paramView.putExtra("portraitOnly", true);
          paramView.putExtra("hide_more_button", true);
          paramView.putExtra("hide_operation_bar", true);
          paramView.putExtra("isShowAd", false);
          this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.startActivity(paramView);
          ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_member", "Clk_people", 0, 0, "" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvVideoController.a, "" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), "", "");
        }
      }
      do
      {
        return;
        paramAdapterView = "http://qvideo.qq.com/mobile/client/level/pk.html?_bid=2176&my=" + str + "&pk=" + paramAdapterView;
        break;
        paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      } while ((paramAdapterView == null) || (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(String.valueOf(paramAdapterView.a))));
      paramView = new Intent();
      paramView.setAction("tencent.av.gift.SelectExtra");
      paramView.putExtra("selectUin", paramAdapterView.a);
      paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
      MultiVideoMembersListviewAvtivity.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity);
      return;
    }
    paramAdapterView = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onItemClick # mRelationUinStr = " + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.b + " # memberUin = " + String.valueOf(paramAdapterView.a));
    }
    paramView = new Intent();
    paramView.setAction("tencent.video.v2q.GaudioOpenTroopCard");
    paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.b);
    paramView.putExtra("memberUin", String.valueOf(paramAdapterView.a));
    paramView.putExtra("UinType", this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int);
    paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */