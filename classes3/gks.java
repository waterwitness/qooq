import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class gks
  extends gkp
{
  static final int g = 0;
  static final int h = 1;
  static final int i = 2;
  static final int j = 3;
  static final int k = 4;
  static final int l = 5;
  long jdField_b_of_type_Long;
  String f;
  int m;
  int n;
  int o;
  
  public gks(RandomWebProtocol paramRandomWebProtocol, gkp paramgkp, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, long paramLong)
  {
    super(paramRandomWebProtocol, paramgkp);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 3;
    this.c = paramString1;
    this.m = paramInt1;
    this.n = paramInt2;
    this.f = paramString2;
    this.o = paramInt3;
    this.jdField_b_of_type_Long = paramLong;
    if (paramRandomWebProtocol.jdField_a_of_type_Boolean) {
      switch (this.n)
      {
      }
    }
    for (;;)
    {
      this.d = ("[p]" + paramInt1 + paramInt2 + paramString2 + paramInt3 + paramLong);
      return;
      this.n = 5;
      continue;
      this.n = 4;
      continue;
      this.n = 6;
    }
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject();
      this.a.put("session_type", this.m);
      this.a.put("reqtype", this.n);
      if (2 == this.n)
      {
        this.a.put("peer_enuin", ChatActivityUtils.b(this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.f));
        this.a.put("peer_gender", this.o);
      }
      this.a.put("groupid", this.jdField_b_of_type_Long);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return super.a();
  }
  
  String b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(super.b());
      localJSONObject.put("pulltype", this.n);
      StringBuffer localStringBuffer;
      if (!TextUtils.isEmpty(this.f))
      {
        if ((this.n != 6) || (!this.f.contains("|"))) {
          break label193;
        }
        localObject = this.f.split("\\|");
        localStringBuffer = new StringBuffer();
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1];
          localStringBuffer.append(ChatActivityUtils.b(this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), str) + "|");
          i1 += 1;
        }
      }
      label193:
      for (Object localObject = localStringBuffer.toString();; localObject = ChatActivityUtils.b(this.jdField_b_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.f))
      {
        localJSONObject.put("enuin", localObject);
        localJSONObject.put("groupid", String.valueOf(this.jdField_b_of_type_Long));
        localJSONObject.put("sessionType", this.m);
        localJSONObject.put("gender", this.f);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */