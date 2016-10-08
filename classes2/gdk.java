import QQService.AddDiscussMemberInfo;
import android.text.TextUtils;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
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

public class gdk
  implements Runnable
{
  public gdk(CreateArrageActivity paramCreateArrageActivity, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = ContactUtils.i(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app, this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app.a());
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app.getManager(50);
    int i = 0;
    ResultRecord localResultRecord;
    Object localObject1;
    String str;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localObject1 = new AddDiscussMemberInfo();
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject1).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject1).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList.add(localObject1);
        str = (String)localObject4 + "、";
        localObject4 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label309;
        }
        localObject4 = localFriendsManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject4 == null) {
          break label707;
        }
        localObject1 = ((Friends)localObject4).name;
        if (!TextUtils.isEmpty(((Friends)localObject4).remark)) {
          break label301;
        }
        localObject4 = ((Friends)localObject4).name;
      }
    }
    for (;;)
    {
      label182:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
      Object localObject2;
      for (;;)
      {
        i += 1;
        localObject4 = localObject1;
        break;
        try
        {
          ((AddDiscussMemberInfo)localObject1).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
          ((AddDiscussMemberInfo)localObject1).RefUin = Long.valueOf(localResultRecord.c).longValue();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject2 = localObject4;
        }
        if (QLog.isColorLevel())
        {
          QLog.d(CreateArrageActivity.a(), 2, "NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
          localObject2 = localObject4;
          continue;
          label301:
          localObject4 = ((Friends)localObject4).remark;
          break label182;
          label309:
          Object localObject5;
          if (localResultRecord.jdField_a_of_type_Int == 1)
          {
            localObject5 = DBUtils.a().a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
            localObject2 = localObject4;
            if (localObject5 == null) {
              break label182;
            }
            localObject2 = localObject4;
            if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).friendnick)) {
              break label182;
            }
            localObject2 = ((TroopMemberInfo)localObject5).friendnick;
            if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).autoremark))
            {
              localObject4 = ((TroopMemberInfo)localObject5).friendnick;
              break label182;
            }
            localObject4 = ((TroopMemberInfo)localObject5).autoremark;
            break label182;
          }
          if (localResultRecord.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((DiscussionManager)this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app.getManager(52)).a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
            localObject2 = localObject4;
            if (localObject5 == null) {
              break label182;
            }
            localObject2 = localObject4;
            if (((DiscussionMemberInfo)localObject5).inteRemark == null) {
              break label182;
            }
            localObject2 = localObject4;
            if (((DiscussionMemberInfo)localObject5).inteRemark.length() <= 0) {
              break label182;
            }
            localObject2 = ((DiscussionMemberInfo)localObject5).inteRemark;
            localObject4 = ((DiscussionMemberInfo)localObject5).inteRemark;
            break label182;
          }
          if (localResultRecord.jdField_a_of_type_Int == 3)
          {
            localObject2 = localResultRecord.b;
            localObject4 = localResultRecord.b;
            break label182;
          }
          localObject2 = localObject4;
          if (localResultRecord.jdField_a_of_type_Int != 4) {
            break label182;
          }
          localObject2 = localResultRecord.b;
          localObject4 = localResultRecord.b;
          break label182;
          localObject2 = str + (String)localObject2;
        }
      }
      for (;;)
      {
        try
        {
          if (((String)localObject4).getBytes("utf-8").length > 48)
          {
            int j = ((String)localObject4).length();
            i = 1;
            if (i <= j)
            {
              if (((String)localObject4).substring(0, i).getBytes("utf-8").length <= 48) {
                continue;
              }
              ((String)localObject4).substring(0, i - 1);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        localObject2 = (DiscussionHandler)this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity.app.a(6);
        if (QLog.isColorLevel()) {
          QLog.d(CreateArrageActivity.a(), 2, "add discussion member: groupCode: " + this.jdField_a_of_type_JavaLangString + " member count: " + localArrayList.size());
        }
        ((DiscussionHandler)localObject2).a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), localArrayList);
        return;
        i += 1;
      }
      label707:
      Object localObject3 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */