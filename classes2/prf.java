import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class prf
  implements Runnable
{
  public prf(ApolloBoxEnterView paramApolloBoxEnterView, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView) == null) {
        return;
      }
      localQQAppInterface = (QQAppInterface)ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView).get();
      if (localQQAppInterface == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("extra_data");
      Object localObject2 = new WebSSOAgent.UniSsoServerRsp();
      ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxEnterView", 2, "handleQueryPandora ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() + ", msg: " + ((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.get());
      }
      if (0L != ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get()) {
        return;
      }
      localObject1 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).getJSONObject("data");
      j = ((JSONObject)localObject1).optInt("queryInterval");
      localObject2 = ((JSONObject)localObject1).getJSONArray("chipdata");
      int k = ((JSONArray)localObject2).length();
      localApolloManager = (ApolloManager)localQQAppInterface.getManager(152);
      i = 0;
      if (i >= k) {
        return;
      }
      localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
      l = localJSONObject.optLong("uin");
      localObject1 = localApolloManager.a(l + "", true);
      if (localObject1 != null) {
        break label487;
      }
      localObject1 = new ApolloPandora();
      ((ApolloPandora)localObject1).uin = (l + "");
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface;
      Object localObject1;
      int j;
      ApolloManager localApolloManager;
      int i;
      JSONObject localJSONObject;
      long l;
      short s;
      label487:
      while (QLog.isColorLevel())
      {
        QLog.e("ApolloBoxEnterView", 2, "handleQueryPandora failed ", localException);
        return;
      }
    }
    localJSONObject = localJSONObject.getJSONObject("chests");
    ((ApolloPandora)localObject1).checkPoint = localJSONObject.optLong("checkpoint");
    ((ApolloPandora)localObject1).queryInterval = j;
    ((ApolloPandora)localObject1).updateTime = System.currentTimeMillis();
    ((ApolloPandora)localObject1).canSteal = ((short)localJSONObject.optInt("chestState"));
    if (((ApolloPandora)localObject1).canSteal == 3) {}
    for (s = 1;; s = 0)
    {
      ((ApolloPandora)localObject1).hadStolen = s;
      localApolloManager.a((ApolloPandora)localObject1);
      if ((ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView) != null) && (ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView).equals(String.valueOf(l))))
      {
        ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ApolloPandora)localObject1);
        ApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView).sendEmptyMessage(255);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxEnterView", 2, "handleQueryPandora canSteal: " + ((ApolloPandora)localObject1).canSteal + ", hadStolen: " + ((ApolloPandora)localObject1).hadStolen + ", checkPoint: " + TimeFormatterUtils.a(localQQAppInterface.a(), ((ApolloPandora)localObject1).checkPoint * 1000L));
      }
      i += 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */