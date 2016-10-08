package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class PAMessage
  implements Serializable
{
  private static final long serialVersionUID = 243242567575L;
  public String grayTips;
  public ArrayList items;
  public long mMsgId;
  public String moreText;
  public String msg;
  public long sendTime;
  public int type;
  
  public PAMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\PAMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */