package com.tencent.mobileqq.hotchat;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.SeatsInfo;

public class HCSeatInfo
  implements Serializable
{
  public long guestUin;
  public int seatFlag;
  public int seatID;
  public int seatSeq;
  
  public HCSeatInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List convert(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      Common.SeatsInfo localSeatsInfo = (Common.SeatsInfo)paramList.get(i);
      if (localSeatsInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        HCSeatInfo localHCSeatInfo = new HCSeatInfo();
        localHCSeatInfo.seatID = localSeatsInfo.uint32_seat_id.get();
        localHCSeatInfo.seatFlag = localSeatsInfo.uint32_seat_flag.get();
        localHCSeatInfo.guestUin = localSeatsInfo.uin64_guest_uin.get();
        localHCSeatInfo.seatSeq = localSeatsInfo.uint32_seat_seq.get();
        localArrayList.add(localHCSeatInfo);
      }
    }
    return localArrayList;
  }
  
  public static List convert2(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      HCSeatInfo localHCSeatInfo = (HCSeatInfo)paramList.get(i);
      if (localHCSeatInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        Common.SeatsInfo localSeatsInfo = new Common.SeatsInfo();
        localSeatsInfo.uin64_guest_uin.set(localHCSeatInfo.guestUin);
        localSeatsInfo.uint32_seat_id.set(localHCSeatInfo.seatID);
        localSeatsInfo.uint32_seat_flag.set(localHCSeatInfo.seatFlag);
        localSeatsInfo.uint32_seat_seq.set(localHCSeatInfo.seatSeq);
        localArrayList.add(localSeatsInfo);
      }
    }
    return localArrayList;
  }
  
  public static List decodeSeatsInfo(String paramString)
  {
    ArrayList localArrayList = new ArrayList(5);
    if ((paramString == null) || (paramString.length() == 0)) {
      return localArrayList;
    }
    for (;;)
    {
      int i;
      HCSeatInfo localHCSeatInfo;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          if (localJSONObject == null) {
            break label164;
          }
          localHCSeatInfo = new HCSeatInfo();
          localHCSeatInfo.seatID = localJSONObject.getInt("seatID");
          localHCSeatInfo.seatFlag = localJSONObject.getInt("seatFlag");
          localHCSeatInfo.guestUin = localJSONObject.getLong("guestUin");
          localHCSeatInfo.seatSeq = localJSONObject.getInt("seatSeq");
          if (localHCSeatInfo.seatID <= 0) {
            break label133;
          }
          localArrayList.add(localHCSeatInfo);
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return localArrayList;
      label133:
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "decodeSeatsInfo invalide seat: " + localHCSeatInfo);
      }
      label164:
      i += 1;
    }
  }
  
  public static String encodeSeatsInfo(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramList.size())
    {
      HCSeatInfo localHCSeatInfo = (HCSeatInfo)paramList.get(i);
      if (localHCSeatInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("seatID", localHCSeatInfo.seatID);
          localJSONObject.put("seatFlag", localHCSeatInfo.seatFlag);
          localJSONObject.put("guestUin", localHCSeatInfo.guestUin);
          localJSONObject.put("seatSeq", localHCSeatInfo.seatSeq);
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("[HCSeatInfo: ").append(this.seatID).append(",").append(this.seatFlag).append(",").append(this.guestUin).append(",").append(this.seatSeq).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HCSeatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */