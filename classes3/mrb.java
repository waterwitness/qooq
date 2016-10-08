import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mrb
  implements Runnable
{
  public mrb(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a((Context)localObject).a();
      if ((localGroupCatalogBean != null) && (localGroupCatalogBean.b.equals(str))) {}
      for (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = localGroupCatalogBean.a();; this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((GroupCatalogBean)localObject).a())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
        return;
        localObject = GroupCatalogTool.a((Context)localObject).a((Context)localObject, str);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */