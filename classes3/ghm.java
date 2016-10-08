import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV.EmotionInfo;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV.GetResListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

public class ghm
  implements INetEngine.INetEngineListener
{
  private MagicfaceManagerForAV.GetResListener jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener;
  
  public ghm(MagicfaceManagerForAV paramMagicfaceManagerForAV, MagicfaceManagerForAV.GetResListener paramGetResListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener = paramGetResListener;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener != null)
    {
      paramNetReq = (MagicfaceManagerForAV.EmotionInfo)paramNetReq.a();
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener.b(paramNetReq.a, (int)(100L * paramLong1 / paramLong2));
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    int j = 1;
    Object localObject = (MagicfaceManagerForAV.EmotionInfo)paramNetResp.a.a();
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.d("download file call back. file = " + ((MagicfaceManagerForAV.EmotionInfo)localObject).e);
    if (paramNetResp.e != 0)
    {
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.d("download file faild. errcode = " + paramNetResp.f);
      i = 0;
      if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener != null)
      {
        paramNetResp = this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV$GetResListener;
        localObject = ((MagicfaceManagerForAV.EmotionInfo)localObject).a;
        if (i == 0) {
          break label228;
        }
      }
    }
    label228:
    for (int i = j;; i = 0)
    {
      paramNetResp.a((String)localObject, i);
      return;
      if (!((MagicfaceManagerForAV.EmotionInfo)localObject).f.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.a.b)))
      {
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.d("download file faild : md5 is not match.");
        i = 0;
        break;
      }
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.d("download file successed.");
      try
      {
        String str = EmoticonUtils.j.replace("[epId]", ((MagicfaceManagerForAV.EmotionInfo)localObject).a);
        FileUtils.a(paramNetResp.a.b, str, false);
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.a(((MagicfaceManagerForAV.EmotionInfo)localObject).a, ((MagicfaceManagerForAV.EmotionInfo)localObject).f);
        i = 1;
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV.d("unzip file faild.");
        i = 0;
      }
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */