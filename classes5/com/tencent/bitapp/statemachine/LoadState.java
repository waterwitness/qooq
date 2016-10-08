package com.tencent.bitapp.statemachine;

import android.os.Message;

public abstract class LoadState
  extends State
{
  public static final int ACTION_LOAD = 1;
  protected static final int DEFAULT_ACTION_RESULT = 0;
  
  public LoadState(StateMachine paramStateMachine)
  {
    super(paramStateMachine);
  }
  
  private void loadCache()
  {
    int i = loadCache(this.mStateMachine.getName());
    if (1 == i) {
      this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(2));
    }
    while (2 != i) {
      return;
    }
    this.mStateMachine.sendMessage(this.mStateMachine.obtainMessage(3));
  }
  
  public abstract IState getNextState();
  
  protected int loadCache(String paramString)
  {
    return 0;
  }
  
  public boolean processMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.mStateMachine.transitionTo(getNextState());
    loadCache();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\statemachine\LoadState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */