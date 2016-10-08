package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqSummaryCard
  extends JceStruct
{
  static int cache_eAddFriendSource;
  static int cache_eComeFrom;
  static byte[] cache_vReqLastGameInfo;
  static byte[] cache_vReqStarInfo;
  static byte[] cache_vReqTemplateInfo;
  static byte[] cache_vSecureSig;
  static byte[] cache_vSeed;
  static ArrayList cache_vvReqServices;
  public byte bIsFriend;
  public int eAddFriendSource;
  public int eComeFrom = 65535;
  public long lGetControl;
  public long lGroupCode;
  public long lGroupUin;
  public long lTinyId;
  public long lUIN;
  public String strSearchName = "";
  public long uLikeSource;
  public long uQzoneFeedTimestamp;
  public byte[] vReqLastGameInfo;
  public byte[] vReqStarInfo;
  public byte[] vReqTemplateInfo;
  public byte[] vSecureSig;
  public byte[] vSeed;
  public ArrayList vvReqServices;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_eComeFrom = 0;
    cache_vSeed = (byte[])new byte[1];
    ((byte[])cache_vSeed)[0] = 0;
    cache_eAddFriendSource = 0;
    cache_vSecureSig = (byte[])new byte[1];
    ((byte[])cache_vSecureSig)[0] = 0;
    cache_vReqLastGameInfo = (byte[])new byte[1];
    ((byte[])cache_vReqLastGameInfo)[0] = 0;
    cache_vReqTemplateInfo = (byte[])new byte[1];
    ((byte[])cache_vReqTemplateInfo)[0] = 0;
    cache_vReqStarInfo = (byte[])new byte[1];
    ((byte[])cache_vReqStarInfo)[0] = 0;
    cache_vvReqServices = new ArrayList();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    cache_vvReqServices.add(arrayOfByte);
  }
  
  public ReqSummaryCard() {}
  
  public ReqSummaryCard(long paramLong1, int paramInt1, long paramLong2, byte paramByte, long paramLong3, long paramLong4, byte[] paramArrayOfByte1, String paramString, long paramLong5, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, ArrayList paramArrayList, long paramLong6, long paramLong7)
  {
    this.lUIN = paramLong1;
    this.eComeFrom = paramInt1;
    this.uQzoneFeedTimestamp = paramLong2;
    this.bIsFriend = paramByte;
    this.lGroupCode = paramLong3;
    this.lGroupUin = paramLong4;
    this.vSeed = paramArrayOfByte1;
    this.strSearchName = paramString;
    this.lGetControl = paramLong5;
    this.eAddFriendSource = paramInt2;
    this.vSecureSig = paramArrayOfByte2;
    this.vReqLastGameInfo = paramArrayOfByte3;
    this.vReqTemplateInfo = paramArrayOfByte4;
    this.vReqStarInfo = paramArrayOfByte5;
    this.vvReqServices = paramArrayList;
    this.lTinyId = paramLong6;
    this.uLikeSource = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.eComeFrom = paramJceInputStream.read(this.eComeFrom, 1, true);
    this.uQzoneFeedTimestamp = paramJceInputStream.read(this.uQzoneFeedTimestamp, 2, false);
    this.bIsFriend = paramJceInputStream.read(this.bIsFriend, 3, false);
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 4, false);
    this.lGroupUin = paramJceInputStream.read(this.lGroupUin, 5, false);
    this.vSeed = ((byte[])paramJceInputStream.read(cache_vSeed, 6, false));
    this.strSearchName = paramJceInputStream.readString(7, false);
    this.lGetControl = paramJceInputStream.read(this.lGetControl, 8, false);
    this.eAddFriendSource = paramJceInputStream.read(this.eAddFriendSource, 9, false);
    this.vSecureSig = ((byte[])paramJceInputStream.read(cache_vSecureSig, 10, false));
    this.vReqLastGameInfo = ((byte[])paramJceInputStream.read(cache_vReqLastGameInfo, 11, false));
    this.vReqTemplateInfo = ((byte[])paramJceInputStream.read(cache_vReqTemplateInfo, 12, false));
    this.vReqStarInfo = ((byte[])paramJceInputStream.read(cache_vReqStarInfo, 13, false));
    this.vvReqServices = ((ArrayList)paramJceInputStream.read(cache_vvReqServices, 14, false));
    this.lTinyId = paramJceInputStream.read(this.lTinyId, 15, false);
    this.uLikeSource = paramJceInputStream.read(this.uLikeSource, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.eComeFrom, 1);
    paramJceOutputStream.write(this.uQzoneFeedTimestamp, 2);
    paramJceOutputStream.write(this.bIsFriend, 3);
    paramJceOutputStream.write(this.lGroupCode, 4);
    paramJceOutputStream.write(this.lGroupUin, 5);
    if (this.vSeed != null) {
      paramJceOutputStream.write(this.vSeed, 6);
    }
    if (this.strSearchName != null) {
      paramJceOutputStream.write(this.strSearchName, 7);
    }
    paramJceOutputStream.write(this.lGetControl, 8);
    paramJceOutputStream.write(this.eAddFriendSource, 9);
    if (this.vSecureSig != null) {
      paramJceOutputStream.write(this.vSecureSig, 10);
    }
    if (this.vReqLastGameInfo != null) {
      paramJceOutputStream.write(this.vReqLastGameInfo, 11);
    }
    if (this.vReqTemplateInfo != null) {
      paramJceOutputStream.write(this.vReqTemplateInfo, 12);
    }
    if (this.vReqStarInfo != null) {
      paramJceOutputStream.write(this.vReqStarInfo, 13);
    }
    if (this.vvReqServices != null) {
      paramJceOutputStream.write(this.vvReqServices, 14);
    }
    paramJceOutputStream.write(this.lTinyId, 15);
    paramJceOutputStream.write(this.uLikeSource, 16);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\ReqSummaryCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */