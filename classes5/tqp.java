import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearpeople.ranking.ShowLoveEditorActivity;
import mqq.app.MobileQQ;

public class tqp
  extends NearbyCardObserver
{
  public tqp(ShowLoveEditorActivity paramShowLoveEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramNearbyPeopleCard != null) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.app.a())))) {}
    while ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramNearbyPeopleCard.nickname)) && (!paramNearbyPeopleCard.nickname.equals(this.a.g)))
    {
      this.a.g = paramNearbyPeopleCard.nickname;
      this.a.jdField_a_of_type_Boolean = true;
    }
    if (paramNearbyPeopleCard.age != this.a.jdField_b_of_type_Int)
    {
      this.a.jdField_b_of_type_Int = paramNearbyPeopleCard.age;
      this.a.jdField_a_of_type_Boolean = true;
    }
    if ((paramNearbyPeopleCard.constellation != 0) && (paramNearbyPeopleCard.constellation != this.a.c))
    {
      this.a.c = paramNearbyPeopleCard.constellation;
      this.a.jdField_a_of_type_Boolean = true;
    }
    String str = "";
    Object localObject = str;
    if (!TextUtils.isEmpty(paramNearbyPeopleCard.hometownProvice))
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.hometownCity))
      {
        this.a.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramNearbyPeopleCard.hometownCountry, paramNearbyPeopleCard.hometownProvice, paramNearbyPeopleCard.hometownCity, paramNearbyPeopleCard.hometownDistrict };
        str = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_a_of_type_ArrayOfJavaLangString);
        localObject = str;
        if ("不限".equals(str)) {
          localObject = "";
        }
      }
    }
    if (!this.a.f.equals(localObject))
    {
      this.a.f = ((String)localObject);
      this.a.jdField_a_of_type_Boolean = true;
    }
    try
    {
      localObject = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.a()).strLocationCodes.split("-");
      this.a.h = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject);
      if ((this.a.jdField_a_of_type_Boolean) && (!this.a.jdField_b_of_type_Boolean))
      {
        this.a.a();
        localObject = this.a.app.getApplication().getSharedPreferences(this.a.app.a(), 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("SHOWLOVE_AGE", this.a.jdField_b_of_type_Int);
        ((SharedPreferences.Editor)localObject).putInt("SHOWLOVE_CONSTE", this.a.c);
        ((SharedPreferences.Editor)localObject).putString("SHOWLOVE_HOMECODE", this.a.f);
        ((SharedPreferences.Editor)localObject).putString("SHOWLOVE_NICKNAME", this.a.g);
        ((SharedPreferences.Editor)localObject).commit();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", my location= ").append(this.a.h);
      DatingUtil.c("showloveeidt", new Object[] { ((StringBuilder)localObject).toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a.h = "";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */