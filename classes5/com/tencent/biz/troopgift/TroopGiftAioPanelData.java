package com.tencent.biz.troopgift;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopGiftAioPanelData
{
  public static final String a = "troop_gift_aio_panel_data";
  public static final String b = "date";
  public static final String c = "defaultPackageID";
  public static final String d = "defaultQuantity";
  public static final String e = "items_personal";
  public static final String f = "items_public";
  public static final String g = "operationInfo";
  public static final String h = "coinInfo";
  public int a;
  public TroopGiftAioPanelData.CoinInfo a;
  public TroopGiftAioPanelData.OperationInfo a;
  public ArrayList a;
  public int b;
  public ArrayList b;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public TroopGiftAioPanelData(JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    if (paramJSONObject == null) {}
    label174:
    label265:
    do
    {
      return;
      this.l = paramJSONObject.toString();
      this.i = paramJSONObject.optString("date");
      this.j = paramJSONObject.optString("defaultPackageID");
      this.k = paramJSONObject.optString("defaultQuantity");
      Object localObject1 = paramJSONObject.optJSONArray("items_personal");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("items_public");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("operationInfo");
      paramJSONObject = paramJSONObject.optJSONObject("coinInfo");
      int i1;
      int m;
      if (localObject1 != null)
      {
        i1 = ((JSONArray)localObject1).length();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(i1);
        m = 0;
        if (m < i1)
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(m);
          if (localObject2 != null)
          {
            localObject2 = new TroopGiftAioItemData((JSONObject)localObject2, m);
            if (((TroopGiftAioItemData)localObject2).c <= 4) {
              break label174;
            }
          }
          for (;;)
          {
            m += 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
      }
      if (localJSONArray != null)
      {
        i1 = localJSONArray.length();
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(i1);
        m = n;
        if (m < i1)
        {
          localObject1 = localJSONArray.optJSONObject(m);
          if (localObject1 != null)
          {
            localObject1 = new TroopGiftAioItemData((JSONObject)localObject1, m);
            if (((TroopGiftAioItemData)localObject1).c <= 2) {
              break label265;
            }
          }
          for (;;)
          {
            m += 1;
            break;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          }
        }
      }
      if (localJSONObject != null) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$OperationInfo = new TroopGiftAioPanelData.OperationInfo(localJSONObject);
      }
    } while (paramJSONObject == null);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData$CoinInfo = new TroopGiftAioPanelData.CoinInfo(paramJSONObject);
  }
  
  public static TroopGiftAioPanelData a(Context paramContext)
  {
    paramContext = SharePreferenceUtils.a(paramContext, "troop_gift_aio_panel_data");
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new TroopGiftAioPanelData(new JSONObject(paramContext));
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(paramContext));
        }
      }
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.l)) {
      SharePreferenceUtils.a(paramContext, "troop_gift_aio_panel_data", this.l);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftAioPanelData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */