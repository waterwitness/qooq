import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class pgz
  extends Thread
{
  public pgz(SelectMemberActivity paramSelectMemberActivity, FriendsManager paramFriendsManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a());
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.size() - 1;
    ResultRecord localResultRecord;
    Object localObject2;
    String str;
    if (i >= 0)
    {
      localResultRecord = (ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i.get(i);
      localObject2 = new AddDiscussMemberInfo();
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList.add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label294;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break label836;
        }
        localObject1 = ((Friends)localObject2).name;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          break label286;
        }
        localObject2 = ((Friends)localObject2).name;
      }
    }
    for (;;)
    {
      label174:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        i -= 1;
        break;
        try
        {
          ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
          ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SelectMemberActivity", 2, "NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
          }
        }
        continue;
        label286:
        localObject3 = localNumberFormatException.remark;
        break label174;
        label294:
        Object localObject5;
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localObject5 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label174;
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).friendnick)) {
            break label174;
          }
          localObject1 = ((TroopMemberInfo)localObject5).friendnick;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).autoremark))
          {
            localObject3 = ((TroopMemberInfo)localObject5).friendnick;
            break label174;
          }
          localObject3 = ((TroopMemberInfo)localObject5).autoremark;
          break label174;
        }
        if (localResultRecord.jdField_a_of_type_Int == 2)
        {
          localObject5 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(52)).a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label174;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark == null) {
            break label174;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark.length() <= 0) {
            break label174;
          }
          localObject1 = ((DiscussionMemberInfo)localObject5).inteRemark;
          localObject3 = ((DiscussionMemberInfo)localObject5).inteRemark;
          break label174;
        }
        if (localResultRecord.jdField_a_of_type_Int == 3)
        {
          localObject1 = localResultRecord.b;
          localObject3 = localResultRecord.b;
          break label174;
        }
        localObject1 = localObject3;
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label174;
        }
        localObject1 = localResultRecord.b;
        localObject3 = localResultRecord.b;
        break label174;
        localObject1 = str + (String)localObject1;
      }
      Object localObject3 = localObject1;
      for (;;)
      {
        try
        {
          if (((String)localObject1).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject1).length();
            i = 1;
            localObject3 = localObject1;
            if (i <= j)
            {
              if (((String)localObject1).substring(0, i).getBytes("utf-8").length <= 48) {
                continue;
              }
              localObject3 = ((String)localObject1).substring(0, i - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          Object localObject4 = localObject1;
          continue;
          if (13 != this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Q) {
            continue;
          }
          SelectMemberActivity.h = false;
          continue;
          SelectMemberActivity.h = false;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SelectMemberActivity", 2, "add discussion member: groupCode: " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.ad + " member count: " + localArrayList.size());
          ((DiscussionHandler)localObject1).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.ad).longValue(), localArrayList);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.getBooleanExtra("sendToVideo", false)) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j = localArrayList;
        }
        localObject1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(6);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.ad != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion: " + (String)localObject3 + " member count: " + localArrayList.size());
        }
        if (10 != this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.Q) {
          continue;
        }
        SelectMemberActivity.h = true;
        ((DiscussionHandler)localObject1).a((String)localObject3, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.P);
        return;
        i += 1;
      }
      label836:
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */