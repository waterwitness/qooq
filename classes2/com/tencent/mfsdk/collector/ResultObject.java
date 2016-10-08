package com.tencent.mfsdk.collector;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class ResultObject
  extends RecyclablePool.Recyclable
  implements Serializable
{
  private static final long serialVersionUID = -1219845830201712069L;
  public long elapse;
  public String eventName;
  public boolean isMerge;
  public boolean isRealTime;
  public boolean isSucceed;
  public ConcurrentHashMap params;
  public int reportType;
  public long size;
  public long uin;
  
  public ResultObject()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eventName = "";
    this.isSucceed = true;
  }
  
  public ResultObject(int paramInt, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean2, boolean paramBoolean3, long paramLong3)
  {
    this.eventName = "";
    this.isSucceed = true;
    this.reportType = paramInt;
    this.eventName = paramString;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramConcurrentHashMap;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
    this.uin = paramLong3;
  }
  
  public void recycle()
  {
    super.recycle();
    this.reportType = 0;
    this.eventName = "";
    this.isSucceed = false;
    this.elapse = 0L;
    this.size = 0L;
    this.params = null;
    this.isRealTime = false;
    this.isMerge = false;
    this.uin = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\collector\ResultObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */