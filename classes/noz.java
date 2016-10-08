import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class noz
  implements VideoDrawable.OnAudioPlayOnceListener
{
  public noz(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ShortVideoPTVItemBuilder.a() != null) && (ShortVideoPTVItemBuilder.a().get() != null))
    {
      ShortVideoPTVItemBuilder.a(ShortVideoPTVItemBuilder.a(this.a), (ChatMessage)ShortVideoPTVItemBuilder.a().get());
      ShortVideoPTVItemBuilder.a(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\noz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */