package NS_UNDEAL_COUNT;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_rsp_new
  extends JceStruct
{
  static byte[] cache_QzmallProfileDecoGetRsp;
  static Map cache_extendinfo;
  static int cache_jumpType;
  static Map cache_mapBuf;
  static Map cache_mapEntranceCfg;
  static Map cache_mapLastGetTime;
  static Map cache_mapYYIconInfo;
  static master_info cache_masterinfo;
  static ban_info cache_stBanInfo;
  static birth_info cache_stBirthInfo;
  static Map cache_stMapCountInfo;
  static master_info cache_stMasterInfo;
  static medal_banner cache_stMedalBanner;
  static medal_info cache_stMedalInfo;
  static yellow_info cache_stYellowInfo;
  static combine_diamond_info cache_stuCombineDiamondInfo;
  static star_info cache_stuStarInfo;
  static ArrayList cache_vecOperateInfo;
  public byte[] QzmallProfileDecoGetRsp;
  public Map extendinfo;
  public int iNextTimeout;
  public int isLiveShow;
  public int isPreLoad;
  public int isShowNewStyles;
  public int jumpType;
  public Map mapBuf;
  public Map mapEntranceCfg;
  public Map mapLastGetTime;
  public Map mapYYIconInfo;
  public master_info masterinfo;
  public String sTransParam = "";
  public ban_info stBanInfo;
  public birth_info stBirthInfo;
  public Map stMapCountInfo;
  public master_info stMasterInfo;
  public medal_banner stMedalBanner;
  public medal_info stMedalInfo;
  public yellow_info stYellowInfo;
  public String strDeviceName = "";
  public String strNick = "";
  public combine_diamond_info stuCombineDiamondInfo;
  public star_info stuStarInfo;
  public int switchTimeout;
  public String undealCountTime = "";
  public ArrayList vecOperateInfo;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_mapEntranceCfg = new HashMap();
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new entrance_cfg());
    cache_mapEntranceCfg.put(Integer.valueOf(0), localObject);
    cache_stMapCountInfo = new HashMap();
    localObject = new count_info();
    cache_stMapCountInfo.put(Integer.valueOf(0), localObject);
    cache_stBanInfo = new ban_info();
    cache_stBirthInfo = new birth_info();
    cache_stYellowInfo = new yellow_info();
    cache_mapBuf = new HashMap();
    localObject = new s_comm_data();
    cache_mapBuf.put(Long.valueOf(0L), localObject);
    cache_masterinfo = new master_info();
    cache_vecOperateInfo = new ArrayList();
    localObject = new operat_data();
    cache_vecOperateInfo.add(localObject);
    cache_mapLastGetTime = new HashMap();
    cache_mapLastGetTime.put(Long.valueOf(0L), Long.valueOf(0L));
    cache_stMasterInfo = new master_info();
    cache_stMedalInfo = new medal_info();
    cache_jumpType = 0;
    cache_stMedalBanner = new medal_banner();
    cache_mapYYIconInfo = new HashMap();
    localObject = new yy_icon();
    cache_mapYYIconInfo.put(Integer.valueOf(0), localObject);
    cache_stuStarInfo = new star_info();
    cache_stuCombineDiamondInfo = new combine_diamond_info();
    cache_extendinfo = new HashMap();
    cache_extendinfo.put(Integer.valueOf(0), "");
    cache_QzmallProfileDecoGetRsp = (byte[])new byte[1];
    ((byte[])cache_QzmallProfileDecoGetRsp)[0] = 0;
  }
  
  public mobile_count_rsp_new() {}
  
  public mobile_count_rsp_new(Map paramMap1, Map paramMap2, ban_info paramban_info, birth_info parambirth_info, String paramString1, int paramInt1, yellow_info paramyellow_info, String paramString2, Map paramMap3, master_info parammaster_info1, ArrayList paramArrayList, Map paramMap4, String paramString3, master_info parammaster_info2, medal_info parammedal_info, int paramInt2, medal_banner parammedal_banner, Map paramMap5, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info, Map paramMap6, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    this.mapEntranceCfg = paramMap1;
    this.stMapCountInfo = paramMap2;
    this.stBanInfo = paramban_info;
    this.stBirthInfo = parambirth_info;
    this.strNick = paramString1;
    this.iNextTimeout = paramInt1;
    this.stYellowInfo = paramyellow_info;
    this.strDeviceName = paramString2;
    this.mapBuf = paramMap3;
    this.masterinfo = parammaster_info1;
    this.vecOperateInfo = paramArrayList;
    this.mapLastGetTime = paramMap4;
    this.sTransParam = paramString3;
    this.stMasterInfo = parammaster_info2;
    this.stMedalInfo = parammedal_info;
    this.jumpType = paramInt2;
    this.stMedalBanner = parammedal_banner;
    this.mapYYIconInfo = paramMap5;
    this.stuStarInfo = paramstar_info;
    this.stuCombineDiamondInfo = paramcombine_diamond_info;
    this.extendinfo = paramMap6;
    this.undealCountTime = paramString4;
    this.isPreLoad = paramInt3;
    this.switchTimeout = paramInt4;
    this.isLiveShow = paramInt5;
    this.isShowNewStyles = paramInt6;
    this.QzmallProfileDecoGetRsp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mapEntranceCfg = ((Map)paramJceInputStream.read(cache_mapEntranceCfg, 0, false));
    this.stMapCountInfo = ((Map)paramJceInputStream.read(cache_stMapCountInfo, 1, false));
    this.stBanInfo = ((ban_info)paramJceInputStream.read(cache_stBanInfo, 2, false));
    this.stBirthInfo = ((birth_info)paramJceInputStream.read(cache_stBirthInfo, 3, false));
    this.strNick = paramJceInputStream.readString(4, false);
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 5, false);
    this.stYellowInfo = ((yellow_info)paramJceInputStream.read(cache_stYellowInfo, 6, false));
    this.strDeviceName = paramJceInputStream.readString(7, false);
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 8, false));
    this.masterinfo = ((master_info)paramJceInputStream.read(cache_masterinfo, 9, false));
    this.vecOperateInfo = ((ArrayList)paramJceInputStream.read(cache_vecOperateInfo, 10, false));
    this.mapLastGetTime = ((Map)paramJceInputStream.read(cache_mapLastGetTime, 11, false));
    this.sTransParam = paramJceInputStream.readString(12, false);
    this.stMasterInfo = ((master_info)paramJceInputStream.read(cache_stMasterInfo, 13, false));
    this.stMedalInfo = ((medal_info)paramJceInputStream.read(cache_stMedalInfo, 14, false));
    this.jumpType = paramJceInputStream.read(this.jumpType, 15, false);
    this.stMedalBanner = ((medal_banner)paramJceInputStream.read(cache_stMedalBanner, 16, false));
    this.mapYYIconInfo = ((Map)paramJceInputStream.read(cache_mapYYIconInfo, 17, false));
    this.stuStarInfo = ((star_info)paramJceInputStream.read(cache_stuStarInfo, 18, false));
    this.stuCombineDiamondInfo = ((combine_diamond_info)paramJceInputStream.read(cache_stuCombineDiamondInfo, 19, false));
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 20, false));
    this.undealCountTime = paramJceInputStream.readString(21, false);
    this.isPreLoad = paramJceInputStream.read(this.isPreLoad, 22, false);
    this.switchTimeout = paramJceInputStream.read(this.switchTimeout, 23, false);
    this.isLiveShow = paramJceInputStream.read(this.isLiveShow, 24, false);
    this.isShowNewStyles = paramJceInputStream.read(this.isShowNewStyles, 25, false);
    this.QzmallProfileDecoGetRsp = ((byte[])paramJceInputStream.read(cache_QzmallProfileDecoGetRsp, 26, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mapEntranceCfg != null) {
      paramJceOutputStream.write(this.mapEntranceCfg, 0);
    }
    if (this.stMapCountInfo != null) {
      paramJceOutputStream.write(this.stMapCountInfo, 1);
    }
    if (this.stBanInfo != null) {
      paramJceOutputStream.write(this.stBanInfo, 2);
    }
    if (this.stBirthInfo != null) {
      paramJceOutputStream.write(this.stBirthInfo, 3);
    }
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 4);
    }
    paramJceOutputStream.write(this.iNextTimeout, 5);
    if (this.stYellowInfo != null) {
      paramJceOutputStream.write(this.stYellowInfo, 6);
    }
    if (this.strDeviceName != null) {
      paramJceOutputStream.write(this.strDeviceName, 7);
    }
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 8);
    }
    if (this.masterinfo != null) {
      paramJceOutputStream.write(this.masterinfo, 9);
    }
    if (this.vecOperateInfo != null) {
      paramJceOutputStream.write(this.vecOperateInfo, 10);
    }
    if (this.mapLastGetTime != null) {
      paramJceOutputStream.write(this.mapLastGetTime, 11);
    }
    if (this.sTransParam != null) {
      paramJceOutputStream.write(this.sTransParam, 12);
    }
    if (this.stMasterInfo != null) {
      paramJceOutputStream.write(this.stMasterInfo, 13);
    }
    if (this.stMedalInfo != null) {
      paramJceOutputStream.write(this.stMedalInfo, 14);
    }
    paramJceOutputStream.write(this.jumpType, 15);
    if (this.stMedalBanner != null) {
      paramJceOutputStream.write(this.stMedalBanner, 16);
    }
    if (this.mapYYIconInfo != null) {
      paramJceOutputStream.write(this.mapYYIconInfo, 17);
    }
    if (this.stuStarInfo != null) {
      paramJceOutputStream.write(this.stuStarInfo, 18);
    }
    if (this.stuCombineDiamondInfo != null) {
      paramJceOutputStream.write(this.stuCombineDiamondInfo, 19);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 20);
    }
    if (this.undealCountTime != null) {
      paramJceOutputStream.write(this.undealCountTime, 21);
    }
    paramJceOutputStream.write(this.isPreLoad, 22);
    paramJceOutputStream.write(this.switchTimeout, 23);
    paramJceOutputStream.write(this.isLiveShow, 24);
    paramJceOutputStream.write(this.isShowNewStyles, 25);
    if (this.QzmallProfileDecoGetRsp != null) {
      paramJceOutputStream.write(this.QzmallProfileDecoGetRsp, 26);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\mobile_count_rsp_new.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */