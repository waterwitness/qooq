import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qpz
  implements qqf
{
  public qpz(ArkAppCGI paramArkAppCGI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(qqh paramqqh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!paramBoolean) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("getPredownloadAppList: fail, url=%s", new Object[] { paramqqh.jdField_a_of_type_JavaLangString }));
    }
    for (;;)
    {
      int i = 0;
      while (i < paramqqh.b.size())
      {
        paramArrayOfByte = paramqqh.jdField_a_of_type_JavaUtilArrayList.get(i);
        ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramqqh.b.get(i);
        if (localArkAppCGICallback != null) {
          localArkAppCGICallback.a(paramBoolean, localArrayList, paramArrayOfByte);
        }
        i += 1;
      }
      ArkAppCGI.a(this.a, paramArrayOfByte, localArrayList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */