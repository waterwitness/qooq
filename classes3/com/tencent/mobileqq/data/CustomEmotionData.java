package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CustomEmotionData
  extends Entity
{
  public String RomaingType;
  public String eId;
  @unique
  public int emoId;
  public String emoPath;
  public boolean isMarkFace;
  public String md5;
  public String resid;
  public String uin;
  public String url;
  
  public CustomEmotionData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.RomaingType = "init";
  }
  
  public String toString()
  {
    return "CustomEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", isMarkFace=" + this.isMarkFace + ", RomaingType=" + this.RomaingType + ", eId=" + this.eId + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\CustomEmotionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */