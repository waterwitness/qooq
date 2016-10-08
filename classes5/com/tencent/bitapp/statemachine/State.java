package com.tencent.bitapp.statemachine;

import android.os.Message;
import com.facebook.common.logging.FLog;

public class State
  implements IState
{
  private static final String TAG = State.class.getSimpleName();
  protected StateMachine mStateMachine = null;
  
  public State() {}
  
  protected State(StateMachine paramStateMachine)
  {
    this.mStateMachine = paramStateMachine;
  }
  
  public void enter()
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Into " + getClass().getSimpleName());
    }
    notifyListeners(new String[0]);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof State)) && (getName().equals(((State)paramObject).getName()));
  }
  
  public void exit()
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Out " + getClass().getSimpleName());
    }
  }
  
  public String getName()
  {
    String str = getClass().getName();
    return str.substring(str.lastIndexOf('$') + 1);
  }
  
  protected void notifyListeners(String... paramVarArgs)
  {
    if (this.mStateMachine != null) {
      this.mStateMachine.notifyListeners(paramVarArgs);
    }
  }
  
  public boolean processMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\statemachine\State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */