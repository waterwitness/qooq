import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tgs
  extends Handler
{
  private final WeakReference a;
  
  public tgs(MusicPlayerActivity paramMusicPlayerActivity)
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramMusicPlayerActivity);
  }
  
  private void a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.a.get();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2) && (localMusicPlayerActivity != null))
    {
      int i = paramArrayOfInt[0];
      int j = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
      GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j, j, j, j, j, i });
      ((ImageView)localMusicPlayerActivity.findViewById(2131298487)).setImageDrawable(localGradientDrawable);
      localMusicPlayerActivity.findViewById(2131298490).setBackgroundColor(i);
      i = paramArrayOfInt[1];
      j = Color.argb(128, Color.red(i), Color.green(i), Color.blue(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTextColor(i);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTextColor(i);
      localMusicPlayerActivity.a.a().setLyricHilightColor(i);
      localMusicPlayerActivity.a.a().setLyricColor(j);
      MusicPlayerActivity.b(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.c(localMusicPlayerActivity).setTag(Integer.valueOf(i));
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130838927, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130838928, i);
      MusicPlayerActivity.a(localMusicPlayerActivity, 2130838521, i);
      if (paramBoolean)
      {
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130838700, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130838702, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130838701, i);
        MusicPlayerActivity.a(localMusicPlayerActivity, 2130837506, i);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 4;
    int j = 1;
    Object localObject1 = (MusicPlayerActivity)this.a.get();
    Object localObject2 = paramMessage.getData();
    if (localObject1 != null) {
      switch (paramMessage.what)
      {
      }
    }
    label488:
    label514:
    label540:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            a(((Bundle)localObject2).getIntArray("KEY_COLOR_LIST"), ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG"));
            return;
            i = paramMessage.arg1;
            paramMessage = MusicPlayerActivity.b((MusicPlayerActivity)localObject1).getTag();
            if ((paramMessage instanceof Integer))
            {
              j = ((Integer)paramMessage).intValue();
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130838927, j);
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1, 2130838928, j);
            }
            if ((i == 3) || (i == 4)) {
              MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130838928);
            }
            for (;;)
            {
              MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
              return;
              MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setImageResource(2130838927);
            }
          } while (!(paramMessage.obj instanceof tgu));
          localObject2 = (tgu)paramMessage.obj;
          if (paramMessage.arg1 == 1) {
            i = 0;
          }
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setVisibility(i);
          if (MusicPlayerActivity.a((MusicPlayerActivity)localObject1).isSelected()) {
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130838701);
          }
          for (;;)
          {
            MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setVisibility(i);
            MusicPlayerActivity.c((MusicPlayerActivity)localObject1).setImageResource(2130838700);
            MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setVisibility(i);
            MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setImageResource(2130837506);
            MusicPlayerActivity.d((MusicPlayerActivity)localObject1).setTag(localObject2);
            return;
            MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130838702);
          }
        } while (localObject2 == null);
        paramMessage = ((Bundle)localObject2).getString("KEY_SONG_NAME");
        ((Bundle)localObject2).getString("KEY_SINGER_NAME");
        Object localObject3 = ((Bundle)localObject2).getString("KEY_IMG_URL");
        boolean bool1 = ((Bundle)localObject2).getBoolean("KEY_MATCH_SONG");
        boolean bool2 = ((Bundle)localObject2).getBoolean("KEY_IS_FAVOURITE");
        if (!TextUtils.isEmpty(paramMessage)) {
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setText(paramMessage);
        }
        if (bool1)
        {
          if (!bool2) {
            break label488;
          }
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130838701);
        }
        URLDrawable localURLDrawable;
        Object localObject4;
        for (;;)
        {
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setSelected(bool2);
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!Patterns.WEB_URL.matcher((CharSequence)localObject3).matches())) {
            break label514;
          }
          paramMessage = (URLImageView)((MusicPlayerActivity)localObject1).findViewById(2131298486);
          localURLDrawable = URLDrawable.getDrawable((String)localObject3, URLDrawable.URLDrawableOptions.obtain());
          if (!MusicPlayerActivity.c().containsKey(localObject3)) {
            break label540;
          }
          localObject3 = (ArrayList)MusicPlayerActivity.c().get(localObject3);
          localObject4 = new int[((ArrayList)localObject3).size()];
          i = 0;
          while (i < ((ArrayList)localObject3).size())
          {
            localObject4[i] = ((Integer)((ArrayList)localObject3).get(i)).intValue();
            i += 1;
          }
          MusicPlayerActivity.a((MusicPlayerActivity)localObject1).setImageResource(2130838702);
        }
        a((int[])localObject4, bool1);
        for (;;)
        {
          paramMessage.setImageDrawable(localURLDrawable);
          paramMessage = ((Bundle)localObject2).getString("KEY_SOURCE_NAME");
          if (!TextUtils.isEmpty(paramMessage)) {
            break;
          }
          MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(2131372591);
          return;
          localObject3 = new tgt((MusicPlayerActivity)localObject1, bool1, (String)localObject3);
          if (localURLDrawable.getStatus() == 1)
          {
            localObject4 = localURLDrawable.getCurrDrawable();
            if ((localObject4 instanceof RegionDrawable)) {
              ((tgt)localObject3).run(null, ((RegionDrawable)localObject4).getBitmap());
            }
          }
          else
          {
            localURLDrawable.setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
          }
        }
        MusicPlayerActivity.b((MusicPlayerActivity)localObject1).setText(((MusicPlayerActivity)localObject1).getString(2131372590, new Object[] { paramMessage }));
        return;
        MusicPlayerActivity.a((MusicPlayerActivity)localObject1);
        return;
        paramMessage = MusicPlayerActivity.a((MusicPlayerActivity)localObject1).getTag();
        if ((paramMessage instanceof Integer)) {}
        for (i = ((Integer)paramMessage).intValue();; i = -1)
        {
          paramMessage = CalloutPopupWindow.a((Context)localObject1).b(3).a(((MusicPlayerActivity)localObject1).getString(2131372588)).a(i);
          paramMessage.c(49);
          paramMessage = new CalloutPopupWindow.DrawableBuilder(paramMessage).b(Color.argb(13, 255, 255, 255)).a(5).a();
          if (paramMessage == null) {
            break;
          }
          paramMessage = paramMessage.a();
          if (paramMessage == null) {
            break;
          }
          paramMessage.a(MusicPlayerActivity.a((MusicPlayerActivity)localObject1));
          return;
        }
        localObject1 = MusicPlayerActivity.d((MusicPlayerActivity)localObject1).getTag();
      } while (!(localObject1 instanceof tgu));
      localObject1 = (tgu)localObject1;
    } while (!(paramMessage.obj instanceof Bitmap));
    localObject2 = (Bitmap)paramMessage.obj;
    long l = System.currentTimeMillis();
    i = j;
    if (paramMessage.arg1 == 2) {
      i = 0;
    }
    WXShareHelper.a().a(String.valueOf(l), ((tgu)localObject1).a, (Bitmap)localObject2, ((tgu)localObject1).b, ((tgu)localObject1).d, i, ((tgu)localObject1).e);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */