import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class hqr
  implements BusinessObserver
{
  public hqr(PublicAccountManager paramPublicAccountManager, NewIntent paramNewIntent, Context paramContext, String paramString, BusinessObserver paramBusinessObserver, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = paramBundle.getByteArray("data");
        paramBundle = new mobileqq_mp.SendMenuEventResponse();
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle.mergeFrom((byte[])localObject2);
          Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("menuEventSharePre", 0);
          localObject1 = paramBundle;
          if (((SharedPreferences)localObject2).contains(this.jdField_a_of_type_JavaLangString))
          {
            localObject1 = paramBundle;
            if (paramBundle.seqno.has())
            {
              localObject1 = paramBundle;
              if (paramBundle.seqno.get() != ((SharedPreferences)localObject2).getInt(this.jdField_a_of_type_JavaLangString, 0))
              {
                if (this.jdField_a_of_type_MqqObserverBusinessObserver != null) {
                  this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverBusinessObserver, true);
                }
                localObject1 = ((SharedPreferences)localObject2).edit();
                ((SharedPreferences.Editor)localObject1).putInt(this.jdField_a_of_type_JavaLangString, paramBundle.seqno.get());
                ((SharedPreferences.Editor)localObject1).commit();
                localObject1 = paramBundle;
              }
            }
          }
          if (localObject1 != null) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        paramBundle = paramBundle;
        paramBundle = (Bundle)localObject1;
      }
      localObject1 = paramBundle;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */