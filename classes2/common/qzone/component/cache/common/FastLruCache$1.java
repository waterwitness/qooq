package common.qzone.component.cache.common;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class FastLruCache$1
  extends LinkedHashMap
{
  FastLruCache$1(FastLruCache paramFastLruCache, int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramFloat, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.val$maxSize;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\qzone\component\cache\common\FastLruCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */