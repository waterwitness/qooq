package com.tencent.mobileqq.highway.iplearning;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;

public abstract interface IpLearningStrategy
{
  public abstract ArrayList<EndPoint> adjustNewIpList(ArrayList<EndPoint> paramArrayList);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\iplearning\IpLearningStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */