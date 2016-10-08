package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class MarkFaceMessage
  implements Serializable
{
  public static final long serialVersionUID = 102222L;
  public int cFaceInfo;
  public int cSubType;
  public int dwMSGItemType;
  public int dwTabID;
  public String faceName;
  public int imageHeight;
  public int imageWidth;
  public long index;
  public int mediaType;
  public byte[] mobileparam;
  public byte[] resvAttr;
  public byte[] sbfKey;
  public byte[] sbufID;
  public int wSize;
  
  public MarkFaceMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dwMSGItemType = 6;
    this.cFaceInfo = 1;
    this.wSize = 37;
    this.cSubType = 3;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MarkFaceMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */