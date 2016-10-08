package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ProfFriendInfoRes
  extends JceStruct
{
  static Map cache_mFieldsInfo;
  static ArrayList cache_vUnGetFields;
  public byte cDataCode;
  public byte cResult;
  public Map mFieldsInfo;
  public String sSigInfo;
  public long uFriendUin;
  public ArrayList vUnGetFields;
  public short wLevel;
  
  public ProfFriendInfoRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sSigInfo = "";
  }
  
  public ProfFriendInfoRes(long paramLong, byte paramByte1, byte paramByte2, Map paramMap, ArrayList paramArrayList, String paramString, short paramShort)
  {
    this.sSigInfo = "";
    this.uFriendUin = paramLong;
    this.cResult = paramByte1;
    this.cDataCode = paramByte2;
    this.mFieldsInfo = paramMap;
    this.vUnGetFields = paramArrayList;
    this.sSigInfo = paramString;
    this.wLevel = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 0, true);
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    this.cDataCode = paramJceInputStream.read(this.cDataCode, 2, true);
    if (cache_mFieldsInfo == null)
    {
      cache_mFieldsInfo = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_mFieldsInfo.put(Short.valueOf((short)0), arrayOfByte);
    }
    this.mFieldsInfo = ((Map)paramJceInputStream.read(cache_mFieldsInfo, 3, true));
    if (cache_vUnGetFields == null)
    {
      cache_vUnGetFields = new ArrayList();
      cache_vUnGetFields.add(Short.valueOf((short)0));
    }
    this.vUnGetFields = ((ArrayList)paramJceInputStream.read(cache_vUnGetFields, 4, true));
    this.sSigInfo = paramJceInputStream.readString(5, true);
    this.wLevel = paramJceInputStream.read(this.wLevel, 6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFriendUin, 0);
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.cDataCode, 2);
    paramJceOutputStream.write(this.mFieldsInfo, 3);
    paramJceOutputStream.write(this.vUnGetFields, 4);
    paramJceOutputStream.write(this.sSigInfo, 5);
    paramJceOutputStream.write(this.wLevel, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfFriendInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */