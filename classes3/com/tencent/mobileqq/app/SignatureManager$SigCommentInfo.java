package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;

public class SignatureManager$SigCommentInfo
  implements Serializable, Comparable
{
  public String feedsid;
  public RichStatus rs;
  public long time;
  public int type;
  public long uin;
  
  public SignatureManager$SigCommentInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compareTo(SigCommentInfo paramSigCommentInfo)
  {
    return (int)(paramSigCommentInfo.time - this.time);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SignatureManager$SigCommentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */