import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.qzone.component.cache.common.SoftHashMap;

public class xyh
  extends xyg
{
  xyh(SoftHashMap paramSoftHashMap)
  {
    super(paramSoftHashMap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object next()
  {
    return a().getKey();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */