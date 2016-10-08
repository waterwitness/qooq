package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_req
  extends JceStruct
{
  static Map cache_extendinfo;
  static Map cache_mapBuf;
  static Map cache_mapLastGetTime;
  static Map cache_mapTimeStamp;
  static Map cache_stMapCountInfo;
  public Map extendinfo;
  public int iRelationType;
  public int iVisitQZoneType;
  public String lastGetFeedTime = "";
  public Map mapBuf;
  public Map mapLastGetTime;
  public Map mapTimeStamp;
  public String sTransParam = "";
  public Map stMapCountInfo;
  public long uMask;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_mapBuf = new HashMap();
    Object localObject = new s_comm_data();
    cache_mapBuf.put(Long.valueOf(0L), localObject);
    cache_mapTimeStamp = new HashMap();
    cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    cache_mapLastGetTime = new HashMap();
    cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_stMapCountInfo = new HashMap();
    localObject = new count_info();
    cache_stMapCountInfo.put(Integer.valueOf(0), localObject);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
  }
  
  public mobile_count_req() {}
  
  public mobile_count_req(long paramLong, int paramInt1, int paramInt2, Map paramMap1, Map paramMap2, Map paramMap3, String paramString1, Map paramMap4, Map paramMap5, String paramString2)
  {
    this.uMask = paramLong;
    this.iRelationType = paramInt1;
    this.iVisitQZoneType = paramInt2;
    this.mapBuf = paramMap1;
    this.mapTimeStamp = paramMap2;
    this.mapLastGetTime = paramMap3;
    this.sTransParam = paramString1;
    this.stMapCountInfo = paramMap4;
    this.extendinfo = paramMap5;
    this.lastGetFeedTime = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    this.iRelationType = paramJceInputStream.read(this.iRelationType, 1, false);
    this.iVisitQZoneType = paramJceInputStream.read(this.iVisitQZoneType, 2, false);
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 3, false));
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 5, false));
    this.sTransParam = paramJceInputStream.readString(6, false);
    this.stMapCountInfo = ((Map)paramJceInputStream.read(cache_stMapCountInfo, 7, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 8, false));
    this.lastGetFeedTime = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    paramJceOutputStream.write(this.iRelationType, 1);
    paramJceOutputStream.write(this.iVisitQZoneType, 2);
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 3);
    }
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 4);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 5);
    }
    if (this.sTransParam != null) {
      paramJceOutputStream.write(this.sTransParam, 6);
    }
    if (this.stMapCountInfo != null) {
      paramJceOutputStream.write(this.stMapCountInfo, 7);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 8);
    }
    if (this.lastGetFeedTime != null) {
      paramJceOutputStream.write(this.lastGetFeedTime, 9);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\mobile_count_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */