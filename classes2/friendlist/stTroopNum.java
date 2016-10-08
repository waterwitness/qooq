package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stTroopNum
  extends JceStruct
{
  public long GroupCode;
  public long GroupUin;
  public byte cFlag;
  public long dwAdditionalFlag;
  public long dwAppPrivilegeFlag;
  public long dwCertificationType;
  public long dwCmdUinUinFlag;
  public long dwGroupClassExt;
  public long dwGroupFlagExt;
  public long dwGroupInfoSeq;
  public long dwGroupRankSeq;
  public long dwGroupSecType;
  public long dwGroupSecTypeInfo;
  public long dwGroupTypeFlag;
  public long dwMemberCardSeq;
  public long dwMemberNum;
  public long dwMemberNumSeq;
  public long dwMyShutupTimestamp;
  public long dwShutupTimestamp;
  public long dwSubscriptionUin;
  public String strGroupMemo;
  public String strGroupName;
  
  public stTroopNum()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strGroupName = "";
    this.strGroupMemo = "";
  }
  
  public stTroopNum(long paramLong1, long paramLong2, byte paramByte, long paramLong3, String paramString1, String paramString2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, long paramLong17, long paramLong18, long paramLong19)
  {
    this.strGroupName = "";
    this.strGroupMemo = "";
    this.GroupUin = paramLong1;
    this.GroupCode = paramLong2;
    this.cFlag = paramByte;
    this.dwGroupInfoSeq = paramLong3;
    this.strGroupName = paramString1;
    this.strGroupMemo = paramString2;
    this.dwGroupFlagExt = paramLong4;
    this.dwGroupRankSeq = paramLong5;
    this.dwCertificationType = paramLong6;
    this.dwShutupTimestamp = paramLong7;
    this.dwMyShutupTimestamp = paramLong8;
    this.dwCmdUinUinFlag = paramLong9;
    this.dwAdditionalFlag = paramLong10;
    this.dwGroupTypeFlag = paramLong11;
    this.dwGroupSecType = paramLong12;
    this.dwGroupSecTypeInfo = paramLong13;
    this.dwGroupClassExt = paramLong14;
    this.dwAppPrivilegeFlag = paramLong15;
    this.dwSubscriptionUin = paramLong16;
    this.dwMemberNum = paramLong17;
    this.dwMemberNumSeq = paramLong18;
    this.dwMemberCardSeq = paramLong19;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.cFlag = paramJceInputStream.read(this.cFlag, 2, false);
    this.dwGroupInfoSeq = paramJceInputStream.read(this.dwGroupInfoSeq, 3, false);
    this.strGroupName = paramJceInputStream.readString(4, false);
    this.strGroupMemo = paramJceInputStream.readString(5, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 6, false);
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 7, false);
    this.dwCertificationType = paramJceInputStream.read(this.dwCertificationType, 8, false);
    this.dwShutupTimestamp = paramJceInputStream.read(this.dwShutupTimestamp, 9, false);
    this.dwMyShutupTimestamp = paramJceInputStream.read(this.dwMyShutupTimestamp, 10, false);
    this.dwCmdUinUinFlag = paramJceInputStream.read(this.dwCmdUinUinFlag, 11, false);
    this.dwAdditionalFlag = paramJceInputStream.read(this.dwAdditionalFlag, 12, false);
    this.dwGroupTypeFlag = paramJceInputStream.read(this.dwGroupTypeFlag, 13, false);
    this.dwGroupSecType = paramJceInputStream.read(this.dwGroupSecType, 14, false);
    this.dwGroupSecTypeInfo = paramJceInputStream.read(this.dwGroupSecTypeInfo, 15, false);
    this.dwGroupClassExt = paramJceInputStream.read(this.dwGroupClassExt, 16, false);
    this.dwAppPrivilegeFlag = paramJceInputStream.read(this.dwAppPrivilegeFlag, 17, false);
    this.dwSubscriptionUin = paramJceInputStream.read(this.dwSubscriptionUin, 18, false);
    this.dwMemberNum = paramJceInputStream.read(this.dwMemberNum, 19, false);
    this.dwMemberNumSeq = paramJceInputStream.read(this.dwMemberNumSeq, 20, false);
    this.dwMemberCardSeq = paramJceInputStream.read(this.dwMemberCardSeq, 21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GroupUin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.cFlag, 2);
    paramJceOutputStream.write(this.dwGroupInfoSeq, 3);
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 4);
    }
    if (this.strGroupMemo != null) {
      paramJceOutputStream.write(this.strGroupMemo, 5);
    }
    paramJceOutputStream.write(this.dwGroupFlagExt, 6);
    paramJceOutputStream.write(this.dwGroupRankSeq, 7);
    paramJceOutputStream.write(this.dwCertificationType, 8);
    paramJceOutputStream.write(this.dwShutupTimestamp, 9);
    paramJceOutputStream.write(this.dwMyShutupTimestamp, 10);
    paramJceOutputStream.write(this.dwCmdUinUinFlag, 11);
    paramJceOutputStream.write(this.dwAdditionalFlag, 12);
    paramJceOutputStream.write(this.dwGroupTypeFlag, 13);
    paramJceOutputStream.write(this.dwGroupSecType, 14);
    paramJceOutputStream.write(this.dwGroupSecTypeInfo, 15);
    paramJceOutputStream.write(this.dwGroupClassExt, 16);
    paramJceOutputStream.write(this.dwAppPrivilegeFlag, 17);
    paramJceOutputStream.write(this.dwSubscriptionUin, 18);
    paramJceOutputStream.write(this.dwMemberNum, 19);
    paramJceOutputStream.write(this.dwMemberNumSeq, 20);
    paramJceOutputStream.write(this.dwMemberCardSeq, 21);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\stTroopNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */