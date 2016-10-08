package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mUrl")
public class UniformDownloadBPTransEntity
  extends Entity
  implements Cloneable
{
  public String mFileName;
  public String mFilePath;
  public long mFileSize;
  public String mTempPath;
  @unique
  public String mUrl;
  
  public UniformDownloadBPTransEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mFileSize = 0L;
  }
  
  public static String tableName()
  {
    return "mr_UDLBPTrans";
  }
  
  public UniformDownloadBPTransEntity clone()
  {
    try
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)super.clone();
      return localUniformDownloadBPTransEntity;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void copyFrom(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    try
    {
      this.mUrl = paramUniformDownloadBPTransEntity.mUrl;
      this.mFileName = paramUniformDownloadBPTransEntity.mFileName;
      this.mFileSize = paramUniformDownloadBPTransEntity.mFileSize;
      this.mTempPath = paramUniformDownloadBPTransEntity.mTempPath;
      this.mFilePath = paramUniformDownloadBPTransEntity.mFilePath;
      return;
    }
    finally
    {
      paramUniformDownloadBPTransEntity = finally;
      throw paramUniformDownloadBPTransEntity;
    }
  }
  
  public String getTableName()
  {
    return "mr_UDLBPTrans";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\UniformDownloadBPTransEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */