package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin,type")
public class RecentUser
  extends BaseRecentUser
{
  public static final long FLAG_HOTCHAT = 1L;
  public static final String TABLE_NAME = "recent";
  private static final String TAG = "RecentUser";
  public String displayName;
  @notColumn
  public int jumpTabMode;
  @defaultzero
  public long lFlag;
  @defaultzero
  public long lastmsgdrafttime;
  public long lastmsgtime;
  @notColumn
  public Object msg;
  public byte[] msgData;
  public int msgType;
  @defaultzero
  public long showUpTime;
  public String troopUin;
  public int type;
  public String uin;
  
  public RecentUser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void cleanMsgAndMsgData(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "cleanMsgAndMsgData " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (this.msgType == paramInt)
    {
      this.msg = null;
      this.msgData = null;
      this.msgType = 0;
    }
  }
  
  public void doParse()
  {
    this.msg = RecentUserMsgFactory.a(this.msgType, this.msgData);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof RecentUser)))
    {
      paramObject = (RecentUser)paramObject;
      if (this.uin == null) {
        if ((((RecentUser)paramObject).uin != null) || (this.type != ((RecentUser)paramObject).type)) {}
      }
      while ((this.uin.equals(((RecentUser)paramObject).uin)) && (this.type == ((RecentUser)paramObject).type))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String getTableName()
  {
    return "recent";
  }
  
  protected void prewrite()
  {
    this.msgData = RecentUserMsgFactory.a(this.msgType, this.msg);
    super.prewrite();
  }
  
  public void setMsgAndType(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentUser", 2, "setMsgAndType " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + paramInt);
    }
    if (paramInt >= this.msgType)
    {
      this.msg = paramObject;
      this.msgType = paramInt;
      reParse();
    }
  }
  
  public boolean shouldShowInRecentList()
  {
    return (this.msgType == 14) || (this.msgType == 9) || (this.msgType == 3) || (this.msgType == 7) || (this.msgType == 16) || (this.msgType == 4) || (this.msgType == 5) || (this.msgType == 10) || (this.msgType == 13) || (this.msgType == 12) || (this.msgType == 6) || (this.msgType == 18) || (this.msgType == 2) || (this.msgType == 11) || (this.msgType == 8) || (this.msgType == 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\RecentUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */