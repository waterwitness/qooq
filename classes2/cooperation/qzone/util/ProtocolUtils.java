package cooperation.qzone.util;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.WNSStream;

public class ProtocolUtils
{
  public ProtocolUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new WNSStream();
    try
    {
      paramArrayOfByte = ((WNSStream)localObject).a(WupUtil.b(paramArrayOfByte));
      localObject = new UniAttribute();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
      {
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.Extra);
        localObject = (QmfBusiControl)((UniAttribute)localObject).get("busiCompCtl");
        if ((localObject != null) && (1 == ((QmfBusiControl)localObject).compFlag))
        {
          localObject = WNSStream.b(paramArrayOfByte.BusiBuff);
          if (localObject == null) {
            break label146;
          }
          paramArrayOfByte.BusiBuff = ((byte[])localObject);
        }
        localObject = new UniAttribute();
        ((UniAttribute)localObject).setEncodeName("utf-8");
        ((UniAttribute)localObject).decode(paramArrayOfByte.BusiBuff);
        return (JceStruct)((UniAttribute)localObject).get(paramString);
      }
      if (paramArrayOfByte != null)
      {
        int i = paramArrayOfByte.WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (paramArrayOfByte == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label146:
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\ProtocolUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */