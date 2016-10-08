package com.dataline.mpfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class MpfileTaskRecord
  extends MessageRecord
  implements Cloneable
{
  public long currentSize;
  public long din;
  public String fileId;
  public String fileName;
  public String filePath;
  public String fileTempPath;
  public String fileTime;
  public long sessionId;
  public long totalSize;
  
  public MpfileTaskRecord()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.selfuin = String.valueOf(AppConstants.aj);
    this.frienduin = this.selfuin;
    this.senderuin = this.selfuin;
    this.istroop = 6000;
    this.versionCode = 1;
  }
  
  public static String tableName()
  {
    return "mr_dataline_mpfile";
  }
  
  public MpfileTaskRecord clone()
  {
    try
    {
      MpfileTaskRecord localMpfileTaskRecord = (MpfileTaskRecord)super.clone();
      return localMpfileTaskRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  protected Class getClassForTable()
  {
    return MpfileTaskRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_dataline_mpfile";
  }
  
  protected void postRead() {}
  
  protected void prewrite() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\mpfile\MpfileTaskRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */