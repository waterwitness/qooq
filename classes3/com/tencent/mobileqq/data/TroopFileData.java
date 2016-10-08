package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class TroopFileData
  extends Entity
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public String FromUin;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public long entitySessionId;
  public String fileName;
  @unique
  public String fileUrl;
  public int height;
  public long lastTime;
  public long lfileSize;
  public String sha1;
  public String uuid;
  public int width;
  
  public TroopFileData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "TroopFileData{dspFileSize='" + this.dspFileSize + '\'' + ", dspFileName='" + this.dspFileName + '\'' + ", bisID=" + this.bisID + ", fileUrl='" + this.fileUrl + '\'' + ", fileName='" + this.fileName + '\'' + ", lfileSize=" + this.lfileSize + ", uuid='" + this.uuid + '\'' + ", FromUin='" + this.FromUin + '\'' + ", lastTime=" + this.lastTime + ", entitySessionId=" + this.entitySessionId + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopFileData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */