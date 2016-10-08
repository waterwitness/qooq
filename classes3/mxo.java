import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;

class mxo
  implements Runnable
{
  mxo(mxn parammxn, TroopInfo paramTroopInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Mxn.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localGroupCatalogBean.a();
      this.jdField_a_of_type_Mxn.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */