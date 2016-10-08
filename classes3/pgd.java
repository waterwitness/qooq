import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
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

public class pgd
  extends Thread
{
  public pgd(PhoneContactSelectActivity paramPhoneContactSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(50);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ContactUtils.i(this.a.app, this.a.app.a());
    int i = this.a.i.size() - 1;
    ResultRecord localResultRecord;
    if (i >= 0)
    {
      localResultRecord = (ResultRecord)this.a.i.get(i);
      Object localObject2 = new AddDiscussMemberInfo();
      if ((localResultRecord.jdField_a_of_type_Int == 5) || (localResultRecord.jdField_a_of_type_Int == 4)) {
        break label1042;
      }
      try
      {
        ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
        ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList.add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label306;
        }
        localObject2 = localFriendsManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break label1037;
        }
        localObject1 = ((Friends)localObject2).name;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          break label298;
        }
        localObject2 = ((Friends)localObject2).name;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          String str;
          label219:
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContactSelectActivity", 2, "NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
          }
          continue;
          localObject3 = localNumberFormatException.remark;
          continue;
          if (localResultRecord.jdField_a_of_type_Int == 1)
          {
            localObject4 = DBUtils.a().a(this.a.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
            localObject1 = localObject3;
            if (localObject4 != null)
            {
              localObject1 = localObject3;
              if (!TextUtils.isEmpty(((TroopMemberInfo)localObject4).friendnick))
              {
                localObject1 = ((TroopMemberInfo)localObject4).friendnick;
                if (TextUtils.isEmpty(((TroopMemberInfo)localObject4).autoremark)) {
                  localObject3 = ((TroopMemberInfo)localObject4).friendnick;
                } else {
                  localObject3 = ((TroopMemberInfo)localObject4).autoremark;
                }
              }
            }
          }
          else if (localResultRecord.jdField_a_of_type_Int == 2)
          {
            localObject4 = ((DiscussionManager)this.a.app.getManager(52)).a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
            localObject1 = localObject3;
            if (localObject4 != null)
            {
              localObject1 = localObject3;
              if (((DiscussionMemberInfo)localObject4).inteRemark != null)
              {
                localObject1 = localObject3;
                if (((DiscussionMemberInfo)localObject4).inteRemark.length() > 0)
                {
                  localObject1 = ((DiscussionMemberInfo)localObject4).inteRemark;
                  localObject3 = ((DiscussionMemberInfo)localObject4).inteRemark;
                }
              }
            }
          }
          else if (localResultRecord.jdField_a_of_type_Int == 3)
          {
            localObject1 = localResultRecord.b;
            localObject3 = localResultRecord.b;
          }
          else
          {
            localObject1 = localObject3;
            if (localResultRecord.jdField_a_of_type_Int == 4)
            {
              localObject1 = localResultRecord.b;
              localObject3 = localResultRecord.b;
              continue;
              localObject1 = str + (String)localObject1;
            }
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
    }
    label298:
    label306:
    label1037:
    label1042:
    for (;;)
    {
      i -= 1;
      break;
      Object localObject4;
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
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          long l2;
          long l1;
          localException.printStackTrace();
          continue;
          if (13 != this.a.Q) {
            continue;
          }
          com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.h = false;
          continue;
          com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.h = false;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PhoneContactSelectActivity", 2, "add discussion member: groupCode: " + this.a.ad + " member count: " + localArrayList.size());
          if (this.a.Q != 18) {
            continue;
          }
          if (!PhoneContactSelectActivity.b(this.a)) {
            continue;
          }
          localException.a((String)localObject1, localArrayList, this.a.P);
          return;
          localException.a(Long.valueOf(this.a.ad).longValue(), localArrayList);
          return;
          localException.a(Long.valueOf(this.a.ad).longValue(), localArrayList);
          return;
        }
        if (this.a.a.getBooleanExtra("sendToVideo", false)) {
          this.a.j = localArrayList;
        }
        localObject3 = (DiscussionHandler)this.a.app.a(6);
        if (this.a.ad != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactSelectActivity", 2, String.format("reate discussion, line[%s], member[%s], mEntrance[%s], mFrom[%s]", new Object[] { localObject1, Integer.valueOf(localArrayList.size()), Integer.valueOf(this.a.Q), Integer.valueOf(this.a.P) }));
        }
        if (10 != this.a.Q) {
          continue;
        }
        com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.h = true;
        l2 = 0L;
        if (((this.a.Q != 10) || (this.a.P != 1003)) && ((this.a.Q != 18) || (this.a.P != 1003)) && ((this.a.Q != 20) || (this.a.P != 1005)))
        {
          l1 = l2;
          if (this.a.Q == 17)
          {
            l1 = l2;
            if (this.a.P != 1007) {}
          }
        }
        else
        {
          l1 = 1L;
        }
        ((DiscussionHandler)localObject3).a((String)localObject1, localArrayList, this.a.P, l1);
        return;
        i += 1;
      }
      localObject1 = null;
      break label219;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */