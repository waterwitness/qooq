package com.tencent.mobileqq.highway.netprobe;

public class EchoProbe
  extends ProbeItem
{
  public static final String PROBE_NAME = "Echo_Probe";
  public static final int RESULT_EXCEPTION = 1;
  public static final int RESULT_NOT_MATCH = 2;
  private EchoTask mEchoTask;
  
  public EchoProbe()
  {
    this(1);
  }
  
  public EchoProbe(int paramInt)
  {
    this.mEchoTask = new EchoTask(WeakNetLearner.mContext, paramInt);
  }
  
  private void onFinish(int paramInt)
  {
    this.mResult.success = false;
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.mResult.errDesc = ("probe has error:" + this.mEchoTask.getErrorMsg());
      this.mResult.errCode = 1;
      return;
    case 1: 
      this.mResult.success = true;
      this.mResult.appendResult("echo response is normal!");
      return;
    }
    this.mResult.errDesc = ("echo response error,resposne url:" + this.mEchoTask.getResponseUrl());
    this.mResult.errCode = 2;
  }
  
  public void doProbe()
  {
    onFinish(this.mEchoTask.doEcho());
  }
  
  public String getProbeName()
  {
    String str = "";
    if (this.mEchoTask.mType == 1) {
      str = "GET_";
    }
    for (;;)
    {
      return str + "Echo_Probe";
      if (this.mEchoTask.mType == 2) {
        str = "POST_";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\netprobe\EchoProbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */