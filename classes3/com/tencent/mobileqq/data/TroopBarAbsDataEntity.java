package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import java.io.Externalizable;
import org.json.JSONObject;

public abstract class TroopBarAbsDataEntity
  extends Entity
  implements Externalizable
{
  public String id;
  
  public TroopBarAbsDataEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopBarAbsDataEntity(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopBarAbsDataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */