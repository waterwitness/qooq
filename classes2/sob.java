import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

class sob
  implements Runnable
{
  sob(snz paramsnz, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.i + ":");
    localStringBuffer.append(this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.j + ":");
    localStringBuffer.append(this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.k + ":");
    localStringBuffer.append(this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.l + ":");
    localStringBuffer.append(this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.n + ":");
    Object localObject = this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.d;
    int k = localObject.length;
    int i = 0;
    if (i < k) {
      if ("0".equals(localObject[i])) {}
    }
    for (i = 1;; i = 0)
    {
      localStringBuffer.append(i + ":");
      if (this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters.m > 0)
      {
        i = 1;
        label272:
        localStringBuffer.append(i);
        localObject = this.jdField_a_of_type_Snz.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        if (!this.jdField_a_of_type_Boolean) {
          break label338;
        }
      }
      label338:
      for (i = j;; i = 0)
      {
        ((NearbyAppInterface)localObject).a("CliOper", "", "", "0X80059D5", "0X80059D5", i, 0, "", "", localStringBuffer.toString(), "");
        return;
        i += 1;
        break;
        i = 0;
        break label272;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */