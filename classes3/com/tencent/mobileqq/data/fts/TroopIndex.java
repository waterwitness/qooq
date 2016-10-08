package com.tencent.mobileqq.data.fts;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.entity.FTSEntity;
import com.tencent.mobileqq.fts.entity.notColumn;
import com.tencent.mobileqq.fts.utils.SegmentUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopIndex
  extends FTSEntity
{
  public String content;
  public String contentindex;
  public String ext4;
  public String ext5;
  public String ext6;
  public String ext7;
  public String ext8;
  public String ext9;
  @notColumn
  public String mMemberCard;
  @notColumn
  public String mMemberName;
  @notColumn
  public String mMemberUin;
  @notColumn
  public String mTroopUin;
  public long oId;
  public int type;
  
  public TroopIndex()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = -1;
    this.oId = -1L;
  }
  
  public TroopIndex(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.type = -1;
    this.oId = -1L;
    this.type = paramInt;
    this.mTroopUin = paramString1;
    this.mMemberUin = paramString2;
    this.mMemberName = paramString3;
    this.mMemberCard = paramString4;
  }
  
  protected void doDeserialize()
  {
    this.mTroopUin = this.ext1;
    this.mMemberName = this.ext2;
    this.mMemberCard = this.ext4;
    this.mMemberUin = this.ext6;
  }
  
  protected void doSerialize()
  {
    this.type = 2;
    this.ext1 = this.mTroopUin;
    String str;
    if (this.mMemberName == null)
    {
      str = "";
      this.mMemberName = str;
      if (this.mMemberCard != null) {
        break label115;
      }
      str = "";
      label38:
      this.mMemberCard = str;
      this.ext2 = this.mMemberName;
      if (!TextUtils.isEmpty(this.ext2)) {
        break label130;
      }
      this.ext3 = "";
      label67:
      this.ext4 = this.mMemberCard;
      if (!TextUtils.isEmpty(this.ext4)) {
        break label144;
      }
    }
    label115:
    label130:
    label144:
    for (this.ext5 = "";; this.ext5 = SegmentUtils.a(this.ext4))
    {
      this.ext6 = this.mMemberUin;
      return;
      str = this.mMemberName.replace("'", "''");
      break;
      str = this.mMemberCard.replace("'", "''");
      break label38;
      this.ext3 = SegmentUtils.a(this.ext2);
      break label67;
    }
  }
  
  public boolean needCompress()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
    doDeserialize();
  }
  
  public void preWrite()
  {
    try
    {
      doSerialize();
      super.preWrite();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\fts\TroopIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */