package mqq.os;

public abstract interface MqqRegulatorCallback
{
  public abstract void checkInRegulatorMsg();
  
  public abstract boolean regulatorThread(Thread paramThread);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\os\MqqRegulatorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */