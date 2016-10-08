package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.transaction.Transaction;

public abstract interface TransactionOps
{
  public abstract void cancelTransactionTask(Transaction paramTransaction);
  
  public abstract void preConnect();
  
  public abstract void resumeTransactionTask(Transaction paramTransaction);
  
  public abstract void stopTransactionTask(Transaction paramTransaction);
  
  public abstract int submitTransactionTask(Transaction paramTransaction);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\api\TransactionOps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */