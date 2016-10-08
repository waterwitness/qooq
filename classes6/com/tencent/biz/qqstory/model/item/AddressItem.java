package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AddressItem
  extends BaseUIItem
  implements Copyable
{
  public String building;
  public String city;
  public int coordinate;
  public String country;
  public int latitude;
  public int longitude;
  public String province;
  public String street;
  
  public AddressItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String convertFromItem(AddressItem paramAddressItem)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("country", paramAddressItem.country);
      localJSONObject.put("city", paramAddressItem.city);
      localJSONObject.put("province", paramAddressItem.province);
      localJSONObject.put("street", paramAddressItem.street);
      localJSONObject.put("building", paramAddressItem.building);
      localJSONObject.put("longitude", paramAddressItem.longitude);
      localJSONObject.put("latitude", paramAddressItem.latitude);
      localJSONObject.put("coordinate", paramAddressItem.coordinate);
      SLog.b("AddressItem convertFromItem: ", localJSONObject.toString());
      return localJSONObject.toString();
    }
    catch (JSONException paramAddressItem)
    {
      for (;;)
      {
        paramAddressItem.printStackTrace();
      }
    }
  }
  
  public static AddressItem convertFromJson(String paramString)
  {
    AddressItem localAddressItem = new AddressItem();
    paramString = new JSONObject(paramString);
    localAddressItem.country = paramString.optString("country");
    localAddressItem.city = paramString.optString("city");
    localAddressItem.province = paramString.optString("province");
    localAddressItem.street = paramString.optString("street");
    localAddressItem.building = paramString.optString("building");
    localAddressItem.longitude = paramString.optInt("longitude");
    localAddressItem.latitude = paramString.optInt("latitude");
    localAddressItem.coordinate = paramString.optInt("coordinate");
    return localAddressItem;
  }
  
  public static String generatePoiJson(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("country", paramString2);
      localJSONObject.put("province", paramString4);
      localJSONObject.put("city", paramString3);
      localJSONObject.put("street", paramString5);
      localJSONObject.put("building", paramString6);
      localJSONObject.put("latitude", paramInt2);
      localJSONObject.put("longitude", paramInt1);
      localJSONObject.put("uid", paramString1);
      localJSONObject.put("coordinate", paramInt3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1) {}
    return "";
  }
  
  public static AddressItem getAddressFromProtoObject(qqstory_struct.Address paramAddress)
  {
    AddressItem localAddressItem = new AddressItem();
    if (paramAddress != null)
    {
      localAddressItem.country = paramAddress.country.get().toStringUtf8();
      localAddressItem.city = paramAddress.city.get().toStringUtf8();
      localAddressItem.province = paramAddress.province.get().toStringUtf8();
      localAddressItem.street = paramAddress.street.get().toStringUtf8();
      localAddressItem.building = paramAddress.building.get().toStringUtf8();
      localAddressItem.longitude = paramAddress.longitude.get();
      localAddressItem.latitude = paramAddress.latitude.get();
      localAddressItem.coordinate = paramAddress.coordinate.get();
      return localAddressItem;
    }
    SLog.b("AddressItem :getAddressFromProtoObject()", "address is null");
    return null;
  }
  
  public static final String getQQStoryPoiJson(TroopBarPOI paramTroopBarPOI)
  {
    if (paramTroopBarPOI == null) {}
    do
    {
      return null;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("latitude", paramTroopBarPOI.b);
        localJSONObject.put("longitude", paramTroopBarPOI.a);
        localJSONObject.put("uid", paramTroopBarPOI.h);
        localJSONObject.put("coordinate", 0);
        paramTroopBarPOI = localJSONObject.toString();
        return paramTroopBarPOI;
      }
      catch (JSONException paramTroopBarPOI) {}
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, QLog.getStackTraceString(paramTroopBarPOI));
    return null;
  }
  
  public void convertFrom(qqstory_struct.Address paramAddress)
  {
    this.country = paramAddress.country.get().toStringUtf8();
    this.city = paramAddress.city.get().toStringUtf8();
    this.province = paramAddress.province.get().toStringUtf8();
    this.street = paramAddress.street.get().toStringUtf8();
    this.building = paramAddress.building.get().toStringUtf8();
    this.longitude = paramAddress.longitude.get();
    this.latitude = paramAddress.latitude.get();
    this.coordinate = paramAddress.coordinate.get();
  }
  
  public qqstory_struct.Address convertToProtoObject()
  {
    qqstory_struct.Address localAddress = new qqstory_struct.Address();
    if (!TextUtils.isEmpty(this.country)) {
      localAddress.country.set(ByteStringMicro.copyFromUtf8(this.country));
    }
    if (!TextUtils.isEmpty(this.city)) {
      localAddress.city.set(ByteStringMicro.copyFromUtf8(this.city));
    }
    if (!TextUtils.isEmpty(this.province)) {
      localAddress.province.set(ByteStringMicro.copyFromUtf8(this.province));
    }
    if (!TextUtils.isEmpty(this.street)) {
      localAddress.street.set(ByteStringMicro.copyFromUtf8(this.street));
    }
    if (!TextUtils.isEmpty(this.building)) {
      localAddress.building.set(ByteStringMicro.copyFromUtf8(this.building));
    }
    localAddress.longitude.set(this.longitude);
    localAddress.latitude.set(this.latitude);
    localAddress.coordinate.set(this.coordinate);
    return localAddress;
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (AddressItem)paramObject;
    this.country = ((AddressItem)paramObject).country;
    this.city = ((AddressItem)paramObject).city;
    this.province = ((AddressItem)paramObject).province;
    this.street = ((AddressItem)paramObject).street;
    this.building = ((AddressItem)paramObject).building;
    this.longitude = ((AddressItem)paramObject).longitude;
    this.latitude = ((AddressItem)paramObject).latitude;
    this.coordinate = ((AddressItem)paramObject).coordinate;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{\"_class\":\"AddressItem\", \"country\":");
    if (this.country == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", ").append("\"city\":");
      if (this.city != null) {
        break label238;
      }
      str = "null";
      label49:
      localStringBuilder = localStringBuilder.append(str).append(", ").append("\"province\":");
      if (this.province != null) {
        break label269;
      }
      str = "null";
      label75:
      localStringBuilder = localStringBuilder.append(str).append(", ").append("\"street\":");
      if (this.street != null) {
        break label300;
      }
      str = "null";
      label101:
      localStringBuilder = localStringBuilder.append(str).append(", ").append("\"building\":");
      if (this.building != null) {
        break label331;
      }
    }
    label238:
    label269:
    label300:
    label331:
    for (String str = "null";; str = "\"" + this.building + "\"")
    {
      return str + ", " + "\"longitude\":\"" + this.longitude + "\"" + ", " + "\"latitude\":\"" + this.latitude + "\"" + ", " + "\"coordinate\":\"" + this.coordinate + "\"" + "}";
      str = "\"" + this.country + "\"";
      break;
      str = "\"" + this.city + "\"";
      break label49;
      str = "\"" + this.province + "\"";
      break label75;
      str = "\"" + this.street + "\"";
      break label101;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\AddressItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */