import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter;
import com.tencent.widget.XListView;

class vfy
  implements Runnable
{
  vfy(vfx paramvfx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter = new TroopAdminList.AdminListAdapter(this.a.a, this.a.a);
    this.a.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */