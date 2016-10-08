package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import qbl;

public class NearbyGrayTipsManager$GreetWording
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long createTime;
  public int id;
  public int lastIndex;
  public List list;
  
  public NearbyGrayTipsManager$GreetWording()
  {
    this(0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (QLog.isDevelopLevel()) {
      QLog.i("nearby_aio_operation_gray_tips", 4, "GreetWording");
    }
  }
  
  public NearbyGrayTipsManager$GreetWording(int paramInt)
  {
    this.id = paramInt;
    this.createTime = 0L;
    this.list = new ArrayList(20);
    this.lastIndex = -1;
  }
  
  public static String getPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGrayTipsManager.a()).append(GreetWording.class.getSimpleName()).append("_").append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String getWording(Random paramRandom)
  {
    String str = "";
    synchronized (this.list)
    {
      int k = this.list.size();
      if (k > 0)
      {
        int j = paramRandom.nextInt(k);
        int i = j;
        if (j == this.lastIndex) {
          i = (this.lastIndex + 1) % k;
        }
        this.lastIndex = i;
        str = (String)this.list.get(i);
      }
      return str;
    }
  }
  
  public void saveWording(long paramLong, List paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      synchronized (this.list)
      {
        Object localObject1;
        if (this.list.size() != 0)
        {
          localObject1 = localObject2;
          if (this.createTime >= paramLong) {}
        }
        else
        {
          this.createTime = paramLong;
          this.list.clear();
          this.list.addAll(paramList);
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new GreetWording(this.id);
            ((GreetWording)localObject1).createTime = this.createTime;
            ((GreetWording)localObject1).lastIndex = this.lastIndex;
            ((GreetWording)localObject1).list.addAll(paramList);
          }
        }
        if ((!paramBoolean) || (localObject1 == null)) {
          continue;
        }
        ThreadManager.a().post(new qbl(this, (GreetWording)localObject1));
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[').append(this.id).append(',').append(this.createTime).append(',').append(this.lastIndex).append(',');
    if (this.list.size() == 0) {
      localStringBuffer.append("size is 0");
    }
    for (;;)
    {
      localStringBuffer.append(']');
      return localStringBuffer.toString();
      localStringBuffer.append("size = ").append(this.list.size());
      localStringBuffer.append('(');
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append((String)localIterator.next()).append(',');
      }
      localStringBuffer.append(')');
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyGrayTipsManager$GreetWording.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */