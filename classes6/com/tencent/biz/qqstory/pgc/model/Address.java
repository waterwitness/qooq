package com.tencent.biz.qqstory.pgc.model;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;

public class Address
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public String building;
  public String city;
  public int coordinate;
  public String country;
  public int latitude;
  public int longitude;
  public String province;
  public String street;
  
  public Address()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Address convertFrom(qqstory_struct.Address paramAddress)
  {
    int j = 0;
    Object localObject2 = null;
    Address localAddress = new Address();
    Object localObject1;
    if (paramAddress.street.has())
    {
      localObject1 = paramAddress.street.get().toStringUtf8();
      localAddress.street = ((String)localObject1);
      if (!paramAddress.province.has()) {
        break label231;
      }
      localObject1 = paramAddress.province.get().toStringUtf8();
      label60:
      localAddress.province = ((String)localObject1);
      if (!paramAddress.city.has()) {
        break label236;
      }
      localObject1 = paramAddress.city.get().toStringUtf8();
      label86:
      localAddress.city = ((String)localObject1);
      if (!paramAddress.country.has()) {
        break label241;
      }
      localObject1 = paramAddress.country.get().toStringUtf8();
      label112:
      localAddress.country = ((String)localObject1);
      localObject1 = localObject2;
      if (paramAddress.building.has()) {
        localObject1 = paramAddress.building.get().toStringUtf8();
      }
      localAddress.building = ((String)localObject1);
      if (!paramAddress.longitude.has()) {
        break label246;
      }
      i = paramAddress.longitude.get();
      label164:
      localAddress.longitude = i;
      if (!paramAddress.latitude.has()) {
        break label252;
      }
    }
    label231:
    label236:
    label241:
    label246:
    label252:
    for (int i = paramAddress.latitude.get();; i = 0)
    {
      localAddress.latitude = i;
      i = j;
      if (paramAddress.coordinate.has()) {
        i = paramAddress.coordinate.get();
      }
      localAddress.coordinate = i;
      return localAddress;
      localObject1 = null;
      break;
      localObject1 = null;
      break label60;
      localObject1 = null;
      break label86;
      localObject1 = null;
      break label112;
      i = 0;
      break label164;
    }
  }
  
  public boolean checkData()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */