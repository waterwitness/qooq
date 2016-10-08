package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetDiscussInfo
  extends JceStruct
{
  static ArrayList cache_Members;
  public long CreateTime;
  public long DiscussFlag;
  public long DiscussUin;
  public long GroupCode;
  public long GroupUin;
  public long InfoSeq;
  public long InteRemarkTimeStamp;
  public ArrayList Members;
  public String Name = "";
  public long OwnerUin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!RespGetDiscussInfo.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RespGetDiscussInfo() {}
  
  public RespGetDiscussInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, ArrayList paramArrayList, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    this.DiscussUin = paramLong1;
    this.OwnerUin = paramLong2;
    this.InfoSeq = paramLong3;
    this.DiscussFlag = paramLong4;
    this.Name = paramString;
    this.Members = paramArrayList;
    this.CreateTime = paramLong5;
    this.InteRemarkTimeStamp = paramLong6;
    this.GroupCode = paramLong7;
    this.GroupUin = paramLong8;
  }
  
  public String className()
  {
    return "QQService.RespGetDiscussInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.DiscussUin, "DiscussUin");
    paramStringBuilder.display(this.OwnerUin, "OwnerUin");
    paramStringBuilder.display(this.InfoSeq, "InfoSeq");
    paramStringBuilder.display(this.DiscussFlag, "DiscussFlag");
    paramStringBuilder.display(this.Name, "Name");
    paramStringBuilder.display(this.Members, "Members");
    paramStringBuilder.display(this.CreateTime, "CreateTime");
    paramStringBuilder.display(this.InteRemarkTimeStamp, "InteRemarkTimeStamp");
    paramStringBuilder.display(this.GroupCode, "GroupCode");
    paramStringBuilder.display(this.GroupUin, "GroupUin");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.DiscussUin, true);
    paramStringBuilder.displaySimple(this.OwnerUin, true);
    paramStringBuilder.displaySimple(this.InfoSeq, true);
    paramStringBuilder.displaySimple(this.DiscussFlag, true);
    paramStringBuilder.displaySimple(this.Name, true);
    paramStringBuilder.displaySimple(this.Members, true);
    paramStringBuilder.displaySimple(this.CreateTime, true);
    paramStringBuilder.displaySimple(this.InteRemarkTimeStamp, true);
    paramStringBuilder.displaySimple(this.GroupCode, true);
    paramStringBuilder.displaySimple(this.GroupUin, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespGetDiscussInfo)paramObject;
    } while ((!JceUtil.equals(this.DiscussUin, ((RespGetDiscussInfo)paramObject).DiscussUin)) || (!JceUtil.equals(this.OwnerUin, ((RespGetDiscussInfo)paramObject).OwnerUin)) || (!JceUtil.equals(this.InfoSeq, ((RespGetDiscussInfo)paramObject).InfoSeq)) || (!JceUtil.equals(this.DiscussFlag, ((RespGetDiscussInfo)paramObject).DiscussFlag)) || (!JceUtil.equals(this.Name, ((RespGetDiscussInfo)paramObject).Name)) || (!JceUtil.equals(this.Members, ((RespGetDiscussInfo)paramObject).Members)) || (!JceUtil.equals(this.CreateTime, ((RespGetDiscussInfo)paramObject).CreateTime)) || (!JceUtil.equals(this.InteRemarkTimeStamp, ((RespGetDiscussInfo)paramObject).InteRemarkTimeStamp)) || (!JceUtil.equals(this.GroupCode, ((RespGetDiscussInfo)paramObject).GroupCode)) || (!JceUtil.equals(this.GroupUin, ((RespGetDiscussInfo)paramObject).GroupUin)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.RespGetDiscussInfo";
  }
  
  public long getDiscussUin()
  {
    return this.DiscussUin;
  }
  
  public long getGroupCode()
  {
    return this.GroupCode;
  }
  
  public long getGroupUin()
  {
    return this.GroupUin;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    this.OwnerUin = paramJceInputStream.read(this.OwnerUin, 1, true);
    this.InfoSeq = paramJceInputStream.read(this.InfoSeq, 2, true);
    this.DiscussFlag = paramJceInputStream.read(this.DiscussFlag, 3, true);
    this.Name = paramJceInputStream.readString(4, true);
    if (cache_Members == null)
    {
      cache_Members = new ArrayList();
      DiscussMemberInfo localDiscussMemberInfo = new DiscussMemberInfo();
      cache_Members.add(localDiscussMemberInfo);
    }
    this.Members = ((ArrayList)paramJceInputStream.read(cache_Members, 5, true));
    this.CreateTime = paramJceInputStream.read(this.CreateTime, 6, false);
    this.InteRemarkTimeStamp = paramJceInputStream.read(this.InteRemarkTimeStamp, 7, false);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 8, false);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 9, false);
  }
  
  public void setGroupCode(long paramLong)
  {
    this.GroupCode = paramLong;
  }
  
  public void setGroupUin(long paramLong)
  {
    this.GroupUin = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.OwnerUin, 1);
    paramJceOutputStream.write(this.InfoSeq, 2);
    paramJceOutputStream.write(this.DiscussFlag, 3);
    paramJceOutputStream.write(this.Name, 4);
    paramJceOutputStream.write(this.Members, 5);
    paramJceOutputStream.write(this.CreateTime, 6);
    paramJceOutputStream.write(this.InteRemarkTimeStamp, 7);
    paramJceOutputStream.write(this.GroupCode, 8);
    paramJceOutputStream.write(this.GroupUin, 9);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetDiscussInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */