package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class StatusServlet$RspGetHistory
  implements Serializable
{
  public int endTime;
  public boolean isAddFromCard;
  public boolean over;
  public ArrayList richStatus;
  public int startTime;
  
  public StatusServlet$RspGetHistory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\StatusServlet$RspGetHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */