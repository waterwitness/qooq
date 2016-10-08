import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.FetchInfoListManager.FetchInfoListener;
import com.tencent.mobileqq.util.FetchInfoReq;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vyh
  implements FetchInfoListManager.FetchInfoListener
{
  public vyh(FetchBuddyAndTroopNameHelper paramFetchBuddyAndTroopNameHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(FetchInfoReq paramFetchInfoReq)
  {
    if ((paramFetchInfoReq == null) || (!paramFetchInfoReq.a())) {}
    Object localObject;
    do
    {
      TroopHandler localTroopHandler;
      do
      {
        return;
        localObject = (FriendListHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(1);
        localTroopHandler = (TroopHandler)FetchBuddyAndTroopNameHelper.a(this.a).a(20);
      } while ((localObject == null) || (localTroopHandler == null));
      if (QLog.isColorLevel()) {
        QLog.d(FetchBuddyAndTroopNameHelper.a(), 2, StringUtil.a(new Object[] { "fetchInfo()", paramFetchInfoReq.toString() }));
      }
      if (paramFetchInfoReq.g == 2)
      {
        localTroopHandler.k(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramFetchInfoReq.g == 1)
      {
        ((FriendListHandler)localObject).b(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramFetchInfoReq.g == 3)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramFetchInfoReq.jdField_a_of_type_JavaLangString);
        if ((paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle != null) && (paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle.getInt(ContactUtils.jdField_a_of_type_JavaLangString) == ContactUtils.y))
        {
          localTroopHandler.a(paramFetchInfoReq.b, (ArrayList)localObject, paramFetchInfoReq.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        localTroopHandler.a(paramFetchInfoReq.b, (String)paramFetchInfoReq.jdField_a_of_type_JavaLangObject, (ArrayList)localObject);
        return;
      }
    } while (paramFetchInfoReq.g != 4);
    ((FriendListHandler)localObject).a(paramFetchInfoReq.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */