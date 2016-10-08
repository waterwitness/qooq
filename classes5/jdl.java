import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.DoLikeCallback;
import org.json.JSONObject;

class jdl
  implements TroopTopicMgr.DoLikeCallback
{
  jdl(jdh paramjdh, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("reqType", this.jdField_a_of_type_Int);
    paramJSONObject.putInt("seq", this.b);
    paramJSONObject.putInt("errorCode", paramInt);
    this.jdField_a_of_type_Jdh.a.a(59, paramJSONObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */