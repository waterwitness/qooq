import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ifp
  implements BusinessObserver
{
  public ifp(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramBundle.getByteArray("data");
      if (localObject1 != null) {
        paramBundle = new mobileqq_mp.JSApiWebServerResponse();
      }
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom((byte[])localObject1);
        localObject1 = (mobileqq_mp.RetInfo)paramBundle.ret_info.get();
        Object localObject2 = paramBundle.body.get();
        int i = ((mobileqq_mp.RetInfo)localObject1).ret_code.get();
        paramBundle = ((mobileqq_mp.RetInfo)localObject1).err_info.get();
        localObject1 = new JSONObject();
        paramInt = i;
        if (i == 0)
        {
          localObject2 = new JSONObject((String)localObject2);
          i = ((JSONObject)localObject2).optInt("ret");
          paramBundle = ((JSONObject)localObject2).optString("msg");
          this.a.z = ((JSONObject)localObject2).optString("puin");
          if (i == -1)
          {
            paramInt = ((JSONObject)localObject2).optInt("refuseSec");
            if (paramInt > 0)
            {
              this.a.c = true;
              this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, paramInt * 1000);
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("bitmap");
          Object localObject3 = new ArrayList();
          if (localObject2 != null)
          {
            paramInt = 0;
            if (paramInt < ((JSONArray)localObject2).length())
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((JSONArray)localObject2).getInt(paramInt)));
              paramInt += 1;
              continue;
            }
          }
          localObject2 = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          Object localObject4;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = PublicAccountH5AbilityPlugin.a(((Integer)((Iterator)localObject3).next()).intValue());
            int j = localObject4.length;
            paramInt = 0;
            if (paramInt < j)
            {
              ((ArrayList)localObject2).add(Integer.valueOf(localObject4[paramInt]));
              paramInt += 1;
              continue;
            }
            continue;
          }
          localObject3 = new ArrayList();
          paramInt = 0;
          if (paramInt < ((ArrayList)localObject2).size())
          {
            localObject4 = (String)PublicAccountH5AbilityPlugin.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
            if ((localObject4 != null) && (((Integer)((ArrayList)localObject2).get(paramInt)).intValue() == 1) && (PublicAccountH5AbilityPlugin.a(PublicAccountH5AbilityPlugin.jdField_a_of_type_JavaUtilArrayList, (String)localObject4))) {
              ((ArrayList)localObject3).add(localObject4);
            }
          }
          else
          {
            localObject2 = PublicAccountH5AbilityPlugin.jdField_a_of_type_JavaUtilArrayList;
            PublicAccountH5AbilityPlugin.jdField_a_of_type_JavaUtilArrayList = (ArrayList)localObject3;
            PublicAccountH5AbilityPlugin.b = true;
            localObject3 = new ArrayList();
            paramInt = 0;
            if (paramInt < ((ArrayList)localObject2).size())
            {
              if (PublicAccountH5AbilityPlugin.a(PublicAccountH5AbilityPlugin.jdField_a_of_type_JavaUtilArrayList, (String)((ArrayList)localObject2).get(paramInt))) {
                break label549;
              }
              ((ArrayList)localObject3).add(Integer.valueOf(paramInt));
              break label549;
            }
            ((JSONObject)localObject1).put("forbidden", new JSONArray((Collection)localObject3));
            paramInt = i;
          }
        }
        else
        {
          ((JSONObject)localObject1).put("msg", paramBundle);
          ((JSONObject)localObject1).put("retCode", paramInt);
          paramBundle = ((JSONObject)localObject1).toString();
          if (this.a.B != null) {
            this.a.callJs(this.a.B, new String[] { paramBundle });
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      paramInt += 1;
      continue;
      label549:
      paramInt += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ifp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */