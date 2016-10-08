import android.os.Bundle;
import com.facebook.react.bridge.Callback;
import com.tencent.biz.pubaccount.reactnative.module.ReadInjoyNetworkingModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class hwe
  implements Runnable
{
  public hwe(ReadInjoyNetworkingModule paramReadInjoyNetworkingModule, Callback paramCallback, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject1 = new Bundle();
      Object localObject3 = (TicketManager)ReadInjoyNetworkingModule.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReactnativeModuleReadInjoyNetworkingModule).getManager(2);
      Object localObject2 = ReadInjoyNetworkingModule.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReactnativeModuleReadInjoyNetworkingModule).f();
      localObject3 = ((TicketManager)localObject3).getSkey(ReadInjoyNetworkingModule.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReactnativeModuleReadInjoyNetworkingModule).a());
      ((Bundle)localObject1).putString("Cookie", "uin=" + (String)localObject2 + "; skey=" + (String)localObject3);
      ((Bundle)localObject1).putString("User-Agent", ReadInjoyNetworkingModule.access$100());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", BaseApplicationImpl.a());
      localObject1 = new hwf(this);
      new HttpWebCgiAsyncTask2(this.jdField_a_of_type_JavaLangString, "GET", (HttpWebCgiAsyncTask.Callback)localObject1, 0, null).execute(new HashMap[] { localObject2 });
      return;
    }
    catch (Exception localException)
    {
      do
      {
        this.jdField_a_of_type_ComFacebookReactBridgeCallback.invoke(new Object[] { Integer.valueOf(1), Integer.valueOf(1), localException.getMessage() });
      } while (!QLog.isColorLevel());
      QLog.w("ReadInjoyNetworkingModule", 2, "doSendRequestWithExtraHeader:request err " + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */