import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class piq
  implements Runnable
{
  public piq(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, List paramList, int paramInt1, int paramInt2, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.b).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.contains(localTroopMemberInfo.memberuin)) && (Utils.c(localTroopMemberInfo.memberuin))) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.e == 2) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(localTroopMemberInfo.memberuin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(localTroopMemberInfo.memberuin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.add(localTroopMemberInfo.memberuin);
        }
        else
        {
          localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
          if ((localTroopMemberInfo.displayedNamePinyinFirst == null) || (localTroopMemberInfo.displayedNamePinyinFirst.length() == 0))
          {
            localObject = "#";
            label215:
            int j = ((String)localObject).charAt(0);
            if (((65 > j) || (j > 90)) && ((97 > j) || (j > 122))) {
              break label337;
            }
          }
          label337:
          for (localObject = ((String)localObject).toUpperCase();; localObject = "#")
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_JavaUtilMap.get(localObject) == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_JavaUtilMap.put(localObject, new ArrayList());
            }
            ((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_JavaUtilMap.get(localObject)).add(localTroopMemberInfo);
            i += 1;
            break;
            localObject = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
            break label215;
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    ((Message)localObject).arg1 = i;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\piq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */