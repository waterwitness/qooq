package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class EmoticonResp
{
  public List data;
  public int delEpId;
  public String emoticonId;
  public int epId;
  public List ids;
  public String keySeq;
  public List magicData;
  public int resultcode;
  public List smallEmoticonData;
  public List tabOrderList;
  public String timeoutReason;
  public int timestamp;
  
  public EmoticonResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\EmoticonResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */