package com.tribe.async.reactive;

public abstract class DataPusher<T>
  implements AsyncFunction<Observer<T>>
{
  public abstract void cancel();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\DataPusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */