package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class ConversationInfo
  extends Entity
{
  private static final String tableName = "conversation_info";
  public byte[] extData;
  public int extInt1;
  public int extInt2;
  public int extInt3;
  public String extString;
  public long lastread;
  public int type;
  public String uin;
  public int unreadCount;
  public int unreadGiftCount;
  public int unreadMark;
  
  public ConversationInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ConversationInfo(String paramString, int paramInt)
  {
    this.uin = paramString;
    this.type = paramInt;
  }
  
  public ConversationInfo(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.lastread = paramLong;
    this.unreadCount = paramInt2;
  }
  
  public static String getConversationInfoTableName()
  {
    return "conversation_info";
  }
  
  public String getTableName()
  {
    return getConversationInfoTableName();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--ConversationInfo--");
    localStringBuilder.append(",uin:").append(this.uin).append(",type:").append(this.type).append(",lastread:").append(this.lastread).append(",unreadCount:").append(this.unreadCount).append(",unreadGiftCount:").append(this.unreadGiftCount).append(",unreadRedPacketCount:").append(this.extInt1).append(",unreadMark:").append(this.unreadMark);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ConversationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */