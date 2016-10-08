package com.tencent.bitapp.statemachine;

import android.os.Message;

public abstract class ConditionState
  extends State
{
  public ConditionState(StateMachine paramStateMachine)
  {
    super(paramStateMachine);
  }
  
  private void fail()
  {
    int i = doFail(this.mStateMachine.getName());
    if (1 == i) {
      this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(2));
    }
    while (2 != i) {
      return;
    }
    this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(3));
  }
  
  private void success()
  {
    int i = doSuccess(this.mStateMachine.getName());
    if (1 == i) {
      this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(2));
    }
    while (2 != i) {
      return;
    }
    this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(3));
  }
  
  protected int doFail(String paramString)
  {
    return 2;
  }
  
  protected int doSuccess(String paramString)
  {
    return 1;
  }
  
  public abstract IState getFailState();
  
  public abstract IState getSuccessState();
  
  public boolean processMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 2: 
      this.mStateMachine.transitionTo(getSuccessState());
      success();
      return true;
    }
    this.mStateMachine.transitionTo(getFailState());
    fail();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\statemachine\ConditionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */