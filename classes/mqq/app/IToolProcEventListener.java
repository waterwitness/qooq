package mqq.app;

import android.content.Intent;

public abstract interface IToolProcEventListener
{
  public abstract void onBeforeExitProc();
  
  public abstract boolean onReceiveAccountAction(String paramString, Intent paramIntent);
  
  public abstract boolean onReceiveLegalExitProcAction();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\IToolProcEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */