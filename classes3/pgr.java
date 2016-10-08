import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.circle.IGroupObserver;

public class pgr
  implements IGroupObserver
{
  public pgr(RenMaiQuanTeamListInnerFrame paramRenMaiQuanTeamListInnerFrame)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.a.jdField_a_of_type_JavaUtilArrayList);
      RenMaiQuanTeamListInnerFrame.a(this.a).notifyDataSetChanged();
    }
    if (paramInt == 2) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.n();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */