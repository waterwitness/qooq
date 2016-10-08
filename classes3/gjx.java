import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.GlStringParser;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YUVTexture.GLRenderListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gjx
  extends Handler
{
  public gjx(YUVTexture paramYUVTexture, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (YUVTexture.a(this.a) == null);
          YUVTexture.a(this.a).a();
          return;
        } while (YUVTexture.a(this.a) == null);
        YUVTexture.a(this.a).b();
        return;
      } while (YUVTexture.a(this.a) == null);
      YUVTexture.a(this.a).c();
      return;
    } while (YUVTexture.a(this.a) == null);
    if (YUVTexture.a(this.a) == null) {
      YUVTexture.a(this.a, new GlStringParser('=', ';'));
    }
    paramMessage = (String)paramMessage.obj;
    YUVTexture.a(this.a).a(paramMessage);
    int i = YUVTexture.a(this.a).a("width");
    int j = YUVTexture.a(this.a).a("height");
    int k = YUVTexture.a(this.a).a("angle");
    YUVTexture.a(this.a).a(i, j, k);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */