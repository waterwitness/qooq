import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vfx
  implements Runnable
{
  public vfx(TroopAdminList paramTroopAdminList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    int j = this.a.jdField_a_of_type_ArrayOfJavaLangString.length;
    while (i < j)
    {
      String str = this.a.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", str);
        localHashMap.put("nick", ContactUtils.k(this.a.app, str));
        this.a.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
      i += 1;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.a.app.a(1));
    this.a.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.a.jdField_a_of_type_ArrayOfJavaLangString);
    this.a.runOnUiThread(new vfy(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */