package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil
{
  public static List<PointF> getFullPoints(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    paramList.add(new PointF(((PointF)paramList.get(58)).x, ((PointF)paramList.get(57)).y));
    paramList.add(new PointF(((PointF)paramList.get(60)).x, ((PointF)paramList.get(61)).y));
    float f1 = ((PointF)paramList.get(35)).x;
    f1 = (((PointF)paramList.get(36)).x + f1) / 2.0F;
    float f2 = (((PointF)paramList.get(3)).y - ((PointF)paramList.get(2)).y) / 3.0F;
    paramList.add(new PointF(f1, ((PointF)paramList.get(2)).y + f2));
    f1 = ((PointF)paramList.get(45)).x;
    f1 = (((PointF)paramList.get(46)).x + f1) / 2.0F;
    f2 = (((PointF)paramList.get(15)).y - ((PointF)paramList.get(16)).y) / 3.0F;
    paramList.add(new PointF(f1, ((PointF)paramList.get(16)).y + f2));
    return paramList;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\TransformUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */