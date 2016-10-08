import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.util.Pair;

public class utq
  extends MQLruCache
{
  public utq(Integer paramInteger)
  {
    super(paramInteger.intValue());
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    if ((paramObject instanceof Bitmap))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    return 12;
  }
  
  public void a(String paramString, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */