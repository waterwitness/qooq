package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloPandora
  extends Entity
{
  public short boxType;
  public short canSteal;
  public long checkPoint;
  public short hadStolen;
  public long queryInterval;
  @unique
  public String uin;
  public long updateTime;
  
  public ApolloPandora()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean needShow(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    label53:
    do
    {
      do
      {
        do
        {
          return bool1;
          if (!paramString.equals(this.uin)) {
            break label53;
          }
          if (this.hadStolen != 0) {
            break;
          }
          bool1 = bool2;
        } while (this.canSteal == 1);
        bool1 = bool2;
      } while (this.canSteal == 2);
      return false;
      if (this.hadStolen != 0) {
        break;
      }
      bool1 = bool2;
    } while (this.canSteal == 1);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ApolloPandora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */