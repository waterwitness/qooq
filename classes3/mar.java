import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

public class mar
  extends FriendListObserver
{
  public mar(ProfileCardMoreActivity paramProfileCardMoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)) || (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramString))) {}
    for (;;)
    {
      return;
      paramString = (FriendsManager)this.a.app.getManager(50);
      if (paramString == null) {}
      for (paramString = null; (paramString != null) && (!Utils.a(ProfileCardMoreActivity.b(this.a), paramString.group_name)); paramString = paramString.a(String.valueOf(paramByte1)))
      {
        ProfileCardMoreActivity.a(this.a, paramString.group_name);
        this.a.runOnUiThread(new mas(this));
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(String.valueOf(paramObject))))
    {
      this.a.a(2131367531, 2);
      if (this.a.jdField_a_of_type_AndroidContentIntent == null) {
        this.a.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(paramString1)) || (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.c = paramString2;
      this.a.b(paramString2);
      if ((ProfileCardMoreActivity.a(this.a) & 0x1) == 1)
      {
        paramString1 = this.a;
        if (!paramBoolean) {
          break label198;
        }
        paramByte = 2131370008;
        label77:
        if (!paramBoolean) {
          break label205;
        }
      }
    }
    label196:
    label198:
    label205:
    for (int i = 2;; i = 1)
    {
      paramString1.a(paramByte, i);
      ProfileCardMoreActivity.a(this.a, ProfileCardMoreActivity.a(this.a) & 0xFFFFFFFE);
      return;
      paramString1 = (FriendsManager)this.a.app.getManager(50);
      if (paramString1 == null) {}
      for (paramString1 = null;; paramString1 = paramString1.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))
      {
        if (paramString1 == null) {
          break label196;
        }
        if ((paramString1.remark != null) && (paramString1.isRemark == 1)) {
          this.a.c = paramString1.remark;
        }
        this.a.b(this.a.c);
        break;
      }
      break;
      paramByte = 2131370010;
      break label77;
    }
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      this.a.a(2131371905, 1);
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(true);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != null) && (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      localObject2 = (FriendsManager)this.a.app.getManager(50);
      if (localObject2 != null) {
        break label180;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        if ((((Friends)localObject1).remark != null) && (((Friends)localObject1).isRemark == 1)) {
          this.a.c = ((Friends)localObject1).remark;
        }
        this.a.b(this.a.c);
        localObject1 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!Utils.a(ProfileCardMoreActivity.b(this.a), ((Groups)localObject1).group_name)))
        {
          ProfileCardMoreActivity.a(this.a, ((Groups)localObject1).group_name);
          localObject2 = this.a.d;
          if (!TextUtils.isEmpty(ProfileCardMoreActivity.b(this.a))) {
            break label199;
          }
        }
      }
    }
    label180:
    label199:
    for (Object localObject1 = "";; localObject1 = ProfileCardMoreActivity.b(this.a))
    {
      ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      return;
      localObject1 = ((FriendsManager)localObject2).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      break;
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if (!paramBoolean)
    {
      this.a.a(2131371905, 1);
      this.a.b.setOnCheckedChangeListener(null);
      this.a.b.setChecked(false);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */