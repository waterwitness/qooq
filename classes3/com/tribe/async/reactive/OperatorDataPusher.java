package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class OperatorDataPusher<UP, DOWN>
  extends BaseDataPusher<DOWN>
{
  private Operator<UP, DOWN> mOperator;
  private DataPusher<UP> mUpDataPusher;
  
  public OperatorDataPusher(DataPusher<UP> paramDataPusher, Operator<UP, DOWN> paramOperator)
  {
    this.mUpDataPusher = paramDataPusher;
    this.mOperator = paramOperator;
  }
  
  public void apply(Observer<DOWN> paramObserver)
  {
    super.apply(paramObserver);
    AssertUtils.checkNotNull(paramObserver);
    paramObserver = (Observer)this.mOperator.apply(paramObserver);
    this.mUpDataPusher.apply(paramObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\reactive\OperatorDataPusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */