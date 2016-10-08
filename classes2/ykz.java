import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

public final class ykz
  extends AccountObserver
{
  public ykz(String paramString, BusinessObserver paramBusinessObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChangeToken(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if ((paramHashMap != null) && (paramHashMap.SigList != null)) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      int i = 0;
      while (i < paramHashMap.SigList.size())
      {
        Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
        if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
        {
          localObject = new String(((CustomSigContent)localObject).SigContent);
          OpenID localOpenID = new OpenID();
          localOpenID.appID = this.jdField_a_of_type_JavaLangString;
          localOpenID.openID = ((String)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.a(1, true, localOpenID);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */