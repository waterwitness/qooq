import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jkk
  implements Runnable
{
  public jkk(BaseApplicationImpl paramBaseApplicationImpl, Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_dex_patch", 4);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = "startFailCount" + MobileQQ.processName;
          i = ((SharedPreferences)localObject1).getInt((String)localObject2, 1);
          if (i <= 5) {
            localEditor.putInt((String)localObject2, i + 1).commit();
          }
        }
        if ((this.jdField_a_of_type_Int == 501) || (this.jdField_a_of_type_Int == 502)) {
          localEditor.putInt("installFailCount", this.b + 1).commit();
        }
        i = ((SharedPreferences)localObject1).getInt("dexPatchConfigCount", 0);
        int j = ((SharedPreferences)localObject1).getInt("curDexPatchIndex", -1);
        Object localObject2 = ((SharedPreferences)localObject1).getString("dexPatchConfigList", "");
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig curPatchCount=" + i + ", curPatchIndex=" + j + ", dexPatchCfgArray=" + (String)localObject2 + ", installFailCnt=" + this.b);
        if ((i > 1) && (j >= 0) && (j < i) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject2 = new JSONArray((String)localObject2);
          JSONArray localJSONArray = new JSONArray();
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          if (localObject3 != null) {
            localJSONArray.put(localObject3);
          }
          localObject3 = ((SharedPreferences)localObject1).getString("name", "");
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            if (i == j) {
              break label505;
            }
            localObject1 = ((JSONArray)localObject2).getJSONObject(i);
            if (!((JSONObject)localObject1).has("name")) {
              break label514;
            }
            localObject1 = ((JSONObject)localObject1).getString("name");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject3))) {
              break label505;
            }
            localObject1 = new File("/data/data/com.tencent.mobileqq/files/hotpatch/" + (String)localObject1);
            if ((localObject1 == null) || (!((File)localObject1).exists())) {
              break label505;
            }
            ((File)localObject1).delete();
            break label505;
          }
          if (localJSONArray.length() > 0)
          {
            localEditor.putString("dexPatchConfigList", localJSONArray.toString());
            localEditor.putInt("dexPatchConfigCount", 1);
            localEditor.putInt("curDexPatchIndex", 0);
            localEditor.commit();
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig JSONException=" + localJSONException.toString());
        localJSONException.printStackTrace();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig throwable=" + localThrowable.toString());
        localThrowable.printStackTrace();
        return;
      }
      label505:
      i += 1;
      continue;
      label514:
      String str = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */