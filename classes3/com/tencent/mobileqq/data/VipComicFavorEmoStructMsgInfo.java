package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="picMd5")
public class VipComicFavorEmoStructMsgInfo
  extends Entity
{
  public static final int init = 1;
  public static final int updated = 2;
  public String actionData;
  public String picMd5;
  public int status;
  
  public VipComicFavorEmoStructMsgInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.status = 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (super.equals(paramObject)) {}
    do
    {
      return true;
      if (!(paramObject instanceof VipComicFavorEmoStructMsgInfo)) {
        break;
      }
      if ((TextUtils.isEmpty(this.picMd5)) || (TextUtils.isEmpty(this.actionData))) {
        return false;
      }
      paramObject = (VipComicFavorEmoStructMsgInfo)paramObject;
    } while ((this.picMd5.equalsIgnoreCase(((VipComicFavorEmoStructMsgInfo)paramObject).picMd5)) && (this.actionData.equals(((VipComicFavorEmoStructMsgInfo)paramObject).actionData)));
    return false;
    return false;
  }
  
  public String toString()
  {
    return "md5 = " + this.picMd5 + " , actionData = " + this.actionData + " , status = " + this.status;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\VipComicFavorEmoStructMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */