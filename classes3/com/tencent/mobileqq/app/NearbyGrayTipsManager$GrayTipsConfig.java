package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

public class NearbyGrayTipsManager$GrayTipsConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public ArrayList aioTypes;
  public long createTime;
  public int global_MaxTipsCountPerDay;
  public ArrayList grayTipWordings;
  public boolean grayTipsEnable;
  public int id;
  public int maxTipsCount;
  public int messageCount;
  public int priority;
  public ArrayList randomWordings;
  public NearbyGrayTipsManager.SceneFour sceneFour;
  public int sceneId;
  public NearbyGrayTipsManager.SceneOne sceneOne;
  public NearbyGrayTipsManager.SceneThree sceneThree;
  public NearbyGrayTipsManager.SceneTwo sceneTwo;
  public ArrayList sexTypes;
  public boolean showKeyboard;
  public int singleTask_MaxTipsCountPerDay;
  public int singleTask_maxTipsCount;
  public ArrayList timeRange;
  public boolean timeRangeControl;
  public String url;
  
  public NearbyGrayTipsManager$GrayTipsConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyGrayTipsManager.Wording getGrayTipWording(Random paramRandom)
  {
    int k = 0;
    int i;
    int m;
    int j;
    if (this.grayTipWordings != null)
    {
      i = this.grayTipWordings.size();
      if ((i <= 1) || (paramRandom == null)) {
        break label139;
      }
      m = paramRandom.nextInt(i);
      j = m;
      label38:
      if (j >= i) {
        break label158;
      }
      paramRandom = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(j);
      if ((paramRandom == null) || (TextUtils.isEmpty(paramRandom.text))) {
        break label121;
      }
    }
    for (;;)
    {
      Object localObject = paramRandom;
      if (paramRandom == null) {
        i = k;
      }
      for (;;)
      {
        localObject = paramRandom;
        if (i < m)
        {
          localObject = (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(i);
          if ((localObject == null) || (TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text))) {}
        }
        else
        {
          return (NearbyGrayTipsManager.Wording)localObject;
          i = 0;
          break;
          label121:
          j += 1;
          break label38;
        }
        i += 1;
        paramRandom = null;
      }
      label139:
      if (i == 1) {
        return (NearbyGrayTipsManager.Wording)this.grayTipWordings.get(0);
      }
      return null;
      label158:
      paramRandom = null;
    }
  }
  
  public boolean isInValidRangeDaily(long paramLong)
  {
    boolean bool2;
    if ((!this.timeRangeControl) || (this.timeRange == null) || (this.timeRange.size() == 0))
    {
      bool2 = true;
      return bool2;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int i = ((Calendar)localObject).get(11);
    localObject = this.timeRange.iterator();
    boolean bool1 = false;
    label58:
    while (((Iterator)localObject).hasNext())
    {
      NearbyGrayTipsManager.TimeRangeInOneDay localTimeRangeInOneDay = (NearbyGrayTipsManager.TimeRangeInOneDay)((Iterator)localObject).next();
      if (localTimeRangeInOneDay != null)
      {
        if (localTimeRangeInOneDay.beginTime <= localTimeRangeInOneDay.endTime) {
          if ((i >= localTimeRangeInOneDay.beginTime) && (i < localTimeRangeInOneDay.endTime)) {
            bool1 = true;
          }
        }
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          break label58;
          bool1 = false;
          continue;
          if (((i >= localTimeRangeInOneDay.beginTime) && (i < 24)) || ((i >= 0) && (i < localTimeRangeInOneDay.endTime))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isValid(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.aioTypes != null) && (!this.aioTypes.contains(Integer.valueOf(paramInt1)))) {
      return false;
    }
    if (this.sexTypes != null)
    {
      paramInt1 = ((NearbyCardManager)paramQQAppInterface.getManager(105)).a(paramInt2);
      if (!this.sexTypes.contains(Integer.valueOf(paramInt1))) {
        return false;
      }
    }
    return isInValidRangeDaily(paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyGrayTipsManager$GrayTipsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */